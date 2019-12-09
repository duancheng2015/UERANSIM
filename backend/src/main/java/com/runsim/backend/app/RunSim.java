package com.runsim.backend.app;

import com.runsim.backend.app.sim.*;
import com.runsim.backend.exceptions.MtsException;
import com.runsim.backend.mts.ImplicitTypedObject;
import com.runsim.backend.mts.MtsConstruct;
import com.runsim.backend.mts.MtsDecoder;
import com.runsim.backend.mts.TypeRegistry;
import com.runsim.backend.nas.NasEncoder;
import com.runsim.backend.nas.core.messages.NasMessage;
import com.runsim.backend.nas.eap.*;
import com.runsim.backend.ngap.Values;
import com.runsim.backend.ngap.ngap_commondatatypes.Criticality;
import com.runsim.backend.ngap.ngap_commondatatypes.ProtocolIE_ID;
import com.runsim.backend.ngap.ngap_ies.EmergencyFallbackRequestIndicator;
import com.runsim.backend.ngap.ngap_ies.NAS_PDU;
import com.runsim.backend.ngap.ngap_ies.RAN_UE_NGAP_ID;
import com.runsim.backend.ngap.ngap_ies.RRCEstablishmentCause;
import com.runsim.backend.ngap.ngap_pdu_contents.InitialUEMessage;
import com.runsim.backend.utils.Console;
import com.runsim.backend.utils.Utils;
import fr.marben.asnsdk.japi.spe.OpenTypeValue;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import java.util.ArrayList;

public class RunSim {

    public static void main(String[] args) {
        initMts();

        var flow = getSimulationFlow("flow1.json");
        Console.println(Json.toJson(flow));
    }

    private static void initMts() {
        try (ScanResult scanResult = new ClassGraph().enableClassInfo().ignoreClassVisibility().whitelistPackages(Constants.NAS_IMPL_PREFIX).scan()) {
            var classInfoList = scanResult.getAllClasses();
            for (var classInfo : classInfoList) {
                Class<?> clazz;
                try {
                    clazz = Class.forName(classInfo.getName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                String typeName = Utils.getTypeName(clazz);

                //Console.print(Color.RED, typeName + " ");
                //Console.println(Color.BLUE, clazz.getName());

                TypeRegistry.registerTypeName(typeName, clazz);
            }
        }

        final Class<?>[] otherTypes = new Class[]{
                Eap.class,
                EapAkaPrime.class,
                EapIdentity.class,
                EapNotification.class,
                EEapAkaAttributeType.class,
                EEapAkaSubType.class,
                EEapCode.class,
                EEapType.class,
                SimulationFlow.class,
                FlowConfig.class,
                SimulationStep.class,
                SimulatorSetup.class,
        };

        for (var type : otherTypes) {
            TypeRegistry.registerTypeName(type.getSimpleName(), type);
        }

        TypeRegistry.registerCustomType(new MtsProtocolEnumRegistry());
        TypeRegistry.registerCustomType(new MtsIEEapMessage());
        TypeRegistry.registerCustomType(new MtsEapAkaAttributes());

        MtsDecoder.setFileProvider(Utils::getResourceString);
    }

    private static SimulationFlow getSimulationFlow(String fileName) {
        var decoded = MtsDecoder.decode(fileName);
        if (decoded instanceof ImplicitTypedObject) {
            return MtsConstruct.construct(SimulationFlow.class, ((ImplicitTypedObject) decoded).getParameters(), true);
        } else if (decoded instanceof SimulationFlow) {
            return (SimulationFlow) decoded;
        } else {
            String name = decoded == null ? "null" : decoded.getClass().getSimpleName();
            throw new MtsException("unexpected type: '%s', SimulationFlow is expected", name);
        }
    }

    public static InitialUEMessage createInitialUeMessage(NasMessage nasMessage, int ranUeNgapIdValue, int establishmentCauseValue) {
        var ranUeNgapId = new InitialUEMessage.ProtocolIEs.SEQUENCE();
        ranUeNgapId.id = new ProtocolIE_ID(Values.NGAP_Constants__id_RAN_UE_NGAP_ID);
        ranUeNgapId.criticality = new Criticality(Criticality.ASN_reject);
        ranUeNgapId.value = new OpenTypeValue(new RAN_UE_NGAP_ID(ranUeNgapIdValue));

        var nasPdu = new InitialUEMessage.ProtocolIEs.SEQUENCE();
        nasPdu.id = new ProtocolIE_ID(Values.NGAP_Constants__id_NAS_PDU);
        nasPdu.criticality = new Criticality(Criticality.ASN_reject);
        nasPdu.value = new OpenTypeValue(new NAS_PDU(NasEncoder.nasPdu(nasMessage)));

        var establishmentCause = new InitialUEMessage.ProtocolIEs.SEQUENCE();
        establishmentCause.id = new ProtocolIE_ID(Values.NGAP_Constants__id_RRCEstablishmentCause);
        establishmentCause.criticality = new Criticality(Criticality.ASN_ignore);
        establishmentCause.value = new OpenTypeValue(new RRCEstablishmentCause(establishmentCauseValue));

        var fake = new InitialUEMessage.ProtocolIEs.SEQUENCE();
        fake.id = new ProtocolIE_ID(Values.NGAP_Constants__id_EmergencyFallbackIndicator);
        fake.criticality = new Criticality(Criticality.ASN_ignore);
        fake.value = new OpenTypeValue(new EmergencyFallbackRequestIndicator(establishmentCauseValue));

        var protocolIEs = new ArrayList<InitialUEMessage.ProtocolIEs.SEQUENCE>();
        protocolIEs.add(ranUeNgapId);
        protocolIEs.add(nasPdu);
        protocolIEs.add(establishmentCause);

        var initialUEMessage = new InitialUEMessage();
        initialUEMessage.protocolIEs = new InitialUEMessage.ProtocolIEs(protocolIEs);
        return initialUEMessage;
    }
}
package tr.havelsan.ueransim.ngap0.ies.sequences;

import tr.havelsan.ueransim.ngap0.core.*;
import tr.havelsan.ueransim.ngap0.pdu.*;
import tr.havelsan.ueransim.utils.bits.*;
import tr.havelsan.ueransim.utils.octets.*;
import tr.havelsan.ueransim.ngap0.ies.bit_strings.*;
import tr.havelsan.ueransim.ngap0.ies.octet_strings.*;
import tr.havelsan.ueransim.ngap0.ies.printable_strings.*;
import tr.havelsan.ueransim.ngap0.ies.sequences.*;
import tr.havelsan.ueransim.ngap0.ies.sequence_ofs.*;
import tr.havelsan.ueransim.ngap0.ies.choices.*;
import tr.havelsan.ueransim.ngap0.ies.integers.*;
import tr.havelsan.ueransim.ngap0.ies.enumerations.*;

import java.util.List;

public class NGAP_AdditionalDLUPTNLInformationForHOItem extends NGAP_Sequence {

    public NGAP_UPTransportLayerInformation additionalDL_NGU_UP_TNLInformation;
    public NGAP_QosFlowListWithDataForwarding additionalQosFlowSetupResponseList;
    public NGAP_UPTransportLayerInformation additionalDLForwardingUPTNLInformation;

    @Override
    public String getAsnName() {
        return "AdditionalDLUPTNLInformationForHOItem";
    }

    @Override
    public String getXmlTagName() {
        return "AdditionalDLUPTNLInformationForHOItem";
    }

    @Override
    public String[] getMemberNames() {
        return new String[]{"additionalDL-NGU-UP-TNLInformation", "additionalQosFlowSetupResponseList", "additionalDLForwardingUPTNLInformation"};
    }

    @Override
    public String[] getMemberIdentifiers() {
        return new String[]{"additionalDL_NGU_UP_TNLInformation", "additionalQosFlowSetupResponseList", "additionalDLForwardingUPTNLInformation"};
    }
}

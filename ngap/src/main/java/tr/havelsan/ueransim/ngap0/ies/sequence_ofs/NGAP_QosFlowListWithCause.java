package tr.havelsan.ueransim.ngap0.ies.sequence_ofs;

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

public class NGAP_QosFlowListWithCause extends NGAP_SequenceOf<NGAP_QosFlowWithCauseItem> {

    public NGAP_QosFlowListWithCause() {
        super();
    }

    public NGAP_QosFlowListWithCause(List<NGAP_QosFlowWithCauseItem> value) {
        super(value);
    }

    @Override
    public String getAsnName() {
        return "QosFlowListWithCause";
    }

    @Override
    public String getXmlTagName() {
        return "QosFlowListWithCause";
    }

    @Override
    public Class<NGAP_QosFlowWithCauseItem> getItemType() {
        return NGAP_QosFlowWithCauseItem.class;
    }
}

package tr.havelsan.ueransim.ngap0.ies.integers;

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

public class NGAP_IntendedNumberOfPagingAttempts extends NGAP_Integer {

    public NGAP_IntendedNumberOfPagingAttempts(long value) {
        super(value);
    }

    public NGAP_IntendedNumberOfPagingAttempts(Octet value) {
        super(value);
    }

    public NGAP_IntendedNumberOfPagingAttempts(Octet2 value) {
        super(value);
    }

    public NGAP_IntendedNumberOfPagingAttempts(Octet3 value) {
        super(value);
    }

    public NGAP_IntendedNumberOfPagingAttempts(Octet4 value) {
        super(value);
    }

    @Override
    public String getAsnName() {
        return "IntendedNumberOfPagingAttempts";
    }

    @Override
    public String getXmlTagName() {
        return "IntendedNumberOfPagingAttempts";
    }
}

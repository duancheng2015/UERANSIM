package com.runsim.backend.nas.impl.messages;

import com.runsim.backend.nas.core.IMessageBuilder;
import com.runsim.backend.nas.core.messages.PlainMmMessage;
import com.runsim.backend.nas.impl.ies.IEAbba;
import com.runsim.backend.nas.impl.ies.IEEapMessage;
import com.runsim.backend.nas.impl.ies.IENasKeySetIdentifier;

public class AuthenticationResult extends PlainMmMessage {
    public IENasKeySetIdentifier ngKSI;
    public IEEapMessage eapMessage;
    public IEAbba abba;

    @Override
    public void build(IMessageBuilder builder) {
        super.build(builder);

        builder.mandatoryIE1("ngKSI");
        builder.mandatoryIE("eapMessage");
        builder.optionalIE(0x38, "abba");
    }
}

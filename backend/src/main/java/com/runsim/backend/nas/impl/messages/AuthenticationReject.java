package com.runsim.backend.nas.impl.messages;

import com.runsim.backend.nas.core.IMessageBuilder;
import com.runsim.backend.nas.core.messages.PlainMmMessage;
import com.runsim.backend.nas.impl.ies.IEEapMessage;

public class AuthenticationReject extends PlainMmMessage {
    public IEEapMessage eapMessage;

    @Override
    public void build(IMessageBuilder builder) {
        super.build(builder);

        builder.optionalIE(0x78, "eapMessage");
    }
}

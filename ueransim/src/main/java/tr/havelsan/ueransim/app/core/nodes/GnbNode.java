/*
 * MIT License
 *
 * Copyright (c) 2020 ALİ GÜNGÖR
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package tr.havelsan.ueransim.app.core.nodes;

import tr.havelsan.ueransim.app.api.gnb.GNodeB;
import tr.havelsan.ueransim.app.api.gnb.ngap.NgapTask;
import tr.havelsan.ueransim.app.api.gnb.sctp.SctpTask;
import tr.havelsan.ueransim.app.core.GnbSimContext;
import tr.havelsan.ueransim.app.core.threads.NodeLooperThread;

public class GnbNode {

    public static final int TASK_SCTP = 1;
    public static final int TASK_NGAP = 2;

    public static void run(GnbSimContext ctx) {
        var itms = ctx.itms;

        var sctpTask = new SctpTask(itms, TASK_SCTP, ctx);
        var ngapTask = new NgapTask(itms, TASK_NGAP, ctx);

        itms.createTask(sctpTask);
        itms.createTask(ngapTask);

        itms.startTask(sctpTask);
        itms.startTask(ngapTask);

        var looperThread = new NodeLooperThread<>(ctx, GNodeB::cycle);
        ctx.setLooperThread(looperThread);
        looperThread.start();
    }
}

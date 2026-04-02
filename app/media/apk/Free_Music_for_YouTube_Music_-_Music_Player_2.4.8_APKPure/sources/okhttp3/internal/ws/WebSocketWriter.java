package okhttp3.internal.ws;

import c.c;
import c.d;
import c.f;
import c.r;
import c.t;
import java.io.IOException;
import java.util.Random;
/* loaded from: classes2.dex */
final class WebSocketWriter {
    static final /* synthetic */ boolean $assertionsDisabled;
    boolean activeWriter;
    final c buffer = new c();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    final byte[] maskBuffer;
    final byte[] maskKey;
    final Random random;
    final d sink;
    boolean writerClosed;

    static {
        $assertionsDisabled = !WebSocketWriter.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketWriter(boolean z, d dVar, Random random) {
        if (dVar == null) {
            throw new NullPointerException("sink == null");
        }
        if (random == null) {
            throw new NullPointerException("random == null");
        }
        this.isClient = z;
        this.sink = dVar;
        this.random = random;
        this.maskKey = z ? new byte[4] : null;
        this.maskBuffer = z ? new byte[8192] : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writePing(f fVar) throws IOException {
        synchronized (this) {
            writeControlFrameSynchronized(9, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writePong(f fVar) throws IOException {
        synchronized (this) {
            writeControlFrameSynchronized(10, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeClose(int i, f fVar) throws IOException {
        f fVar2 = f.f289b;
        if (i != 0 || fVar != null) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            c cVar = new c();
            cVar.h(i);
            if (fVar != null) {
                cVar.b(fVar);
            }
            fVar2 = cVar.q();
        }
        synchronized (this) {
            writeControlFrameSynchronized(8, fVar2);
            this.writerClosed = true;
        }
    }

    private void writeControlFrameSynchronized(int i, f fVar) throws IOException {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int h = fVar.h();
        if (h > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sink.i(i | 128);
        if (this.isClient) {
            this.sink.i(h | 128);
            this.random.nextBytes(this.maskKey);
            this.sink.c(this.maskKey);
            byte[] i2 = fVar.i();
            WebSocketProtocol.toggleMask(i2, i2.length, this.maskKey, 0L);
            this.sink.c(i2);
        } else {
            this.sink.i(h);
            this.sink.b(fVar);
        }
        this.sink.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r newMessageSink(int i, long j) {
        if (this.activeWriter) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.activeWriter = true;
        this.frameSink.formatOpcode = i;
        this.frameSink.contentLength = j;
        this.frameSink.isFirstFrame = true;
        this.frameSink.closed = false;
        return this.frameSink;
    }

    void writeMessageFrameSynchronized(int i, long j, boolean z, boolean z2) throws IOException {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int i2 = z ? i : 0;
        if (z2) {
            i2 |= 128;
        }
        this.sink.i(i2);
        int i3 = this.isClient ? 128 : 0;
        if (j <= 125) {
            this.sink.i(i3 | ((int) j));
        } else if (j <= 65535) {
            this.sink.i(i3 | 126);
            this.sink.h((int) j);
        } else {
            this.sink.i(i3 | 127);
            this.sink.n(j);
        }
        if (this.isClient) {
            this.random.nextBytes(this.maskKey);
            this.sink.c(this.maskKey);
            long j2 = 0;
            while (j2 < j) {
                int a2 = this.buffer.a(this.maskBuffer, 0, (int) Math.min(j, this.maskBuffer.length));
                if (a2 == -1) {
                    throw new AssertionError();
                }
                WebSocketProtocol.toggleMask(this.maskBuffer, a2, this.maskKey, j2);
                this.sink.c(this.maskBuffer, 0, a2);
                j2 += a2;
            }
        } else {
            this.sink.write(this.buffer, j);
        }
        this.sink.e();
    }

    /* loaded from: classes2.dex */
    final class FrameSink implements r {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        @Override // c.r
        public void write(c cVar, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.buffer.write(cVar, j);
            boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.buffer.a() > this.contentLength - 8192;
            long h = WebSocketWriter.this.buffer.h();
            if (h > 0 && !z) {
                synchronized (WebSocketWriter.this) {
                    WebSocketWriter.this.writeMessageFrameSynchronized(this.formatOpcode, h, this.isFirstFrame, false);
                }
                this.isFirstFrame = false;
            }
        }

        @Override // c.r, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            synchronized (WebSocketWriter.this) {
                WebSocketWriter.this.writeMessageFrameSynchronized(this.formatOpcode, WebSocketWriter.this.buffer.a(), this.isFirstFrame, false);
            }
            this.isFirstFrame = false;
        }

        @Override // c.r
        public t timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            synchronized (WebSocketWriter.this) {
                WebSocketWriter.this.writeMessageFrameSynchronized(this.formatOpcode, WebSocketWriter.this.buffer.a(), this.isFirstFrame, true);
            }
            this.closed = true;
            WebSocketWriter.this.activeWriter = false;
        }
    }
}

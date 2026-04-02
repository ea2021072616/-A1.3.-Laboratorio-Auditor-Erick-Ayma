package okhttp3.internal.http2;

import c.a;
import c.c;
import c.e;
import c.r;
import c.s;
import c.t;
import com.pili.pldroid.player.AVOptions;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;
    private boolean hasResponseHeaders;
    final int id;
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final FramingSink sink;
    private final FramingSource source;
    long unacknowledgedBytesRead = 0;
    final StreamTimeout readTimeout = new StreamTimeout();
    final StreamTimeout writeTimeout = new StreamTimeout();
    ErrorCode errorCode = null;

    static {
        $assertionsDisabled = !Http2Stream.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, List<Header> list) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.id = i;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
        this.source = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize());
        this.sink = new FramingSink();
        this.source.finished = z2;
        this.sink.finished = z;
        this.requestHeaders = list;
    }

    public int getId() {
        return this.id;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
        if (r2.hasResponseHeaders == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isOpen() {
        /*
            r2 = this;
            r0 = 0
            monitor-enter(r2)
            okhttp3.internal.http2.ErrorCode r1 = r2.errorCode     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L8
        L6:
            monitor-exit(r2)
            return r0
        L8:
            okhttp3.internal.http2.Http2Stream$FramingSource r1 = r2.source     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.finished     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L14
            okhttp3.internal.http2.Http2Stream$FramingSource r1 = r2.source     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.closed     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L24
        L14:
            okhttp3.internal.http2.Http2Stream$FramingSink r1 = r2.sink     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.finished     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L20
            okhttp3.internal.http2.Http2Stream$FramingSink r1 = r2.sink     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.closed     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L24
        L20:
            boolean r1 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L6
        L24:
            r0 = 1
            goto L6
        L26:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.isOpen():boolean");
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public synchronized List<Header> takeResponseHeaders() throws IOException {
        List<Header> list;
        if (!isLocallyInitiated()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.readTimeout.enter();
        while (this.responseHeaders == null && this.errorCode == null) {
            waitForIo();
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        list = this.responseHeaders;
        if (list != null) {
            this.responseHeaders = null;
        } else {
            throw new StreamResetException(this.errorCode);
        }
        return list;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public void sendResponseHeaders(List<Header> list, boolean z) throws IOException {
        boolean z2 = true;
        if (!$assertionsDisabled && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (list == null) {
            throw new NullPointerException("responseHeaders == null");
        }
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z) {
                z2 = false;
            } else {
                this.sink.finished = true;
            }
        }
        this.connection.writeSynReply(this.id, z2, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public t readTimeout() {
        return this.readTimeout;
    }

    public t writeTimeout() {
        return this.writeTimeout;
    }

    public s getSource() {
        return this.source;
    }

    public r getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.id, errorCode);
        }
    }

    private boolean closeInternal(ErrorCode errorCode) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.source.finished && this.sink.finished) {
                    return false;
                }
                this.errorCode = errorCode;
                notifyAll();
                this.connection.removeStream(this.id);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receiveHeaders(List<Header> list) {
        boolean z = true;
        if (!$assertionsDisabled && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (this.responseHeaders == null) {
                this.responseHeaders = list;
                z = isOpen();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.responseHeaders);
                arrayList.add(null);
                arrayList.addAll(list);
                this.responseHeaders = arrayList;
            }
        }
        if (!z) {
            this.connection.removeStream(this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receiveData(e eVar, int i) throws IOException {
        if (!$assertionsDisabled && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.source.receive(eVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receiveFin() {
        boolean isOpen;
        if (!$assertionsDisabled && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.source.finished = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class FramingSource implements s {
        static final /* synthetic */ boolean $assertionsDisabled;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private final c receiveBuffer = new c();
        private final c readBuffer = new c();

        static {
            $assertionsDisabled = !Http2Stream.class.desiredAssertionStatus();
        }

        FramingSource(long j) {
            this.maxByteCount = j;
        }

        @Override // c.s
        public long read(c cVar, long j) throws IOException {
            long read;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (Http2Stream.this) {
                waitUntilReadable();
                checkNotClosed();
                if (this.readBuffer.a() == 0) {
                    read = -1;
                } else {
                    read = this.readBuffer.read(cVar, Math.min(j, this.readBuffer.a()));
                    Http2Stream.this.unacknowledgedBytesRead += read;
                    if (Http2Stream.this.unacknowledgedBytesRead >= Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2) {
                        Http2Stream.this.connection.writeWindowUpdateLater(Http2Stream.this.id, Http2Stream.this.unacknowledgedBytesRead);
                        Http2Stream.this.unacknowledgedBytesRead = 0L;
                    }
                    synchronized (Http2Stream.this.connection) {
                        Http2Stream.this.connection.unacknowledgedBytesRead += read;
                        if (Http2Stream.this.connection.unacknowledgedBytesRead >= Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2) {
                            Http2Stream.this.connection.writeWindowUpdateLater(0, Http2Stream.this.connection.unacknowledgedBytesRead);
                            Http2Stream.this.connection.unacknowledgedBytesRead = 0L;
                        }
                    }
                }
            }
            return read;
        }

        private void waitUntilReadable() throws IOException {
            Http2Stream.this.readTimeout.enter();
            while (this.readBuffer.a() == 0 && !this.finished && !this.closed && Http2Stream.this.errorCode == null) {
                try {
                    Http2Stream.this.waitForIo();
                } finally {
                    Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        void receive(e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            if (!$assertionsDisabled && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = this.readBuffer.a() + j > this.maxByteCount;
                }
                if (z2) {
                    eVar.h(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.h(j);
                    return;
                } else {
                    long read = eVar.read(this.receiveBuffer, j);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    j -= read;
                    synchronized (Http2Stream.this) {
                        boolean z3 = this.readBuffer.a() == 0;
                        this.readBuffer.a((s) this.receiveBuffer);
                        if (z3) {
                            Http2Stream.this.notifyAll();
                        }
                    }
                }
            }
        }

        @Override // c.s
        public t timeout() {
            return Http2Stream.this.readTimeout;
        }

        @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                this.closed = true;
                this.readBuffer.v();
                Http2Stream.this.notifyAll();
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            }
            if (Http2Stream.this.errorCode != null) {
                throw new StreamResetException(Http2Stream.this.errorCode);
            }
        }
    }

    void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        if (!$assertionsDisabled && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class FramingSink implements r {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final c sendBuffer = new c();

        static {
            $assertionsDisabled = !Http2Stream.class.desiredAssertionStatus();
        }

        FramingSink() {
        }

        @Override // c.r
        public void write(c cVar, long j) throws IOException {
            if (!$assertionsDisabled && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            this.sendBuffer.write(cVar, j);
            while (this.sendBuffer.a() >= 16384) {
                emitFrame(false);
            }
        }

        private void emitFrame(boolean z) throws IOException {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (Http2Stream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && Http2Stream.this.errorCode == null) {
                    Http2Stream.this.waitForIo();
                }
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed();
                min = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.a());
                Http2Stream.this.bytesLeftInWriteWindow -= min;
            }
            Http2Stream.this.writeTimeout.enter();
            try {
                Http2Stream.this.connection.writeData(Http2Stream.this.id, z && min == this.sendBuffer.a(), this.sendBuffer, min);
            } finally {
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        @Override // c.r, java.io.Flushable
        public void flush() throws IOException {
            if (!$assertionsDisabled && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.a() > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // c.r
        public t timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!$assertionsDisabled && Thread.holdsLock(Http2Stream.this)) {
                throw new AssertionError();
            }
            synchronized (Http2Stream.this) {
                if (!this.closed) {
                    if (!Http2Stream.this.sink.finished) {
                        if (this.sendBuffer.a() > 0) {
                            while (this.sendBuffer.a() > 0) {
                                emitFrame(true);
                            }
                        } else {
                            Http2Stream.this.connection.writeData(Http2Stream.this.id, true, null, 0L);
                        }
                    }
                    synchronized (Http2Stream.this) {
                        this.closed = true;
                    }
                    Http2Stream.this.connection.flush();
                    Http2Stream.this.cancelStreamIfNecessary();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void checkOutNotClosed() throws IOException {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        }
        if (this.sink.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            throw new StreamResetException(this.errorCode);
        }
    }

    void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class StreamTimeout extends a {
        StreamTimeout() {
        }

        @Override // c.a
        protected void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
        }

        @Override // c.a
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(AVOptions.KEY_PREPARE_TIMEOUT);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }
    }
}

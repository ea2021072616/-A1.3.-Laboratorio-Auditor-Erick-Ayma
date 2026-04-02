package okhttp3.internal.http2;

import android.support.v7.widget.ActivityChooserView;
import c.c;
import c.e;
import c.f;
import c.s;
import c.t;
import com.flurry.android.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final e source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, f fVar, String str2, int i2, long j);

        void data(boolean z, int i, e eVar, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, f fVar);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    public Http2Reader(e eVar, boolean z) {
        this.source = eVar;
        this.client = z;
        this.continuation = new ContinuationSource(this.source);
        this.hpackReader = new Hpack.Reader(4096, this.continuation);
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        f d = this.source.d(Http2.CONNECTION_PREFACE.h());
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Util.format("<< CONNECTION %s", d.f()));
        }
        if (!Http2.CONNECTION_PREFACE.equals(d)) {
            throw Http2.ioException("Expected a connection header but was %s", d.a());
        }
    }

    public boolean nextFrame(boolean z, Handler handler) throws IOException {
        try {
            this.source.a(9L);
            int readMedium = readMedium(this.source);
            if (readMedium < 0 || readMedium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
            }
            byte i = (byte) (this.source.i() & Constants.UNKNOWN);
            if (z && i != 4) {
                throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(i));
            }
            byte i2 = (byte) (this.source.i() & Constants.UNKNOWN);
            int k = this.source.k() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(true, k, readMedium, i, i2));
            }
            switch (i) {
                case 0:
                    readData(handler, readMedium, i2, k);
                    return true;
                case 1:
                    readHeaders(handler, readMedium, i2, k);
                    return true;
                case 2:
                    readPriority(handler, readMedium, i2, k);
                    return true;
                case 3:
                    readRstStream(handler, readMedium, i2, k);
                    return true;
                case 4:
                    readSettings(handler, readMedium, i2, k);
                    return true;
                case 5:
                    readPushPromise(handler, readMedium, i2, k);
                    return true;
                case 6:
                    readPing(handler, readMedium, i2, k);
                    return true;
                case 7:
                    readGoAway(handler, readMedium, i2, k);
                    return true;
                case 8:
                    readWindowUpdate(handler, readMedium, i2, k);
                    return true;
                default:
                    this.source.h(readMedium);
                    return true;
            }
        } catch (IOException e) {
            return false;
        }
    }

    private void readHeaders(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short i3 = (b2 & 8) != 0 ? (short) (this.source.i() & Constants.UNKNOWN) : (short) 0;
        if ((b2 & 32) != 0) {
            readPriority(handler, i2);
            i -= 5;
        }
        handler.headers(z, i2, -1, readHeaderBlock(lengthWithoutPadding(i, b2, i3), i3, b2, i2));
    }

    private List<Header> readHeaderBlock(int i, short s, byte b2, int i2) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        this.continuation.left = i;
        continuationSource.length = i;
        this.continuation.padding = s;
        this.continuation.flags = b2;
        this.continuation.streamId = i2;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readData(Handler handler, int i, byte b2, int i2) throws IOException {
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short i3 = (b2 & 8) != 0 ? (short) (this.source.i() & Constants.UNKNOWN) : (short) 0;
        handler.data(z, i2, this.source, lengthWithoutPadding(i, b2, i3));
        this.source.h(i3);
    }

    private void readPriority(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        readPriority(handler, i2);
    }

    private void readPriority(Handler handler, int i) throws IOException {
        int k = this.source.k();
        handler.priority(i, k & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (this.source.i() & Constants.UNKNOWN) + 1, (Integer.MIN_VALUE & k) != 0);
    }

    private void readRstStream(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int k = this.source.k();
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(k);
        if (fromHttp2 == null) {
            throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(k));
        }
        handler.rstStream(i2, fromHttp2);
    }

    private void readSettings(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i != 0) {
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
        } else if (i % 6 != 0) {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        } else {
            Settings settings = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short j = this.source.j();
                int k = this.source.k();
                switch (j) {
                    case 2:
                        if (k != 0 && k != 1) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        break;
                    case 3:
                        j = 4;
                        break;
                    case 4:
                        j = 7;
                        if (k < 0) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        break;
                    case 5:
                        if (k < 16384 || k > 16777215) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(k));
                        }
                        break;
                }
                settings.set(j, k);
            }
            handler.settings(false, settings);
        }
    }

    private void readPushPromise(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short i3 = (b2 & 8) != 0 ? (short) (this.source.i() & Constants.UNKNOWN) : (short) 0;
        handler.pushPromise(i2, this.source.k() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, readHeaderBlock(lengthWithoutPadding(i - 4, b2, i3), i3, b2, i2));
    }

    private void readPing(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.ping((b2 & 1) != 0, this.source.k(), this.source.k());
    }

    private void readGoAway(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int k = this.source.k();
        int k2 = this.source.k();
        int i3 = i - 8;
        ErrorCode fromHttp2 = ErrorCode.fromHttp2(k2);
        if (fromHttp2 == null) {
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(k2));
        }
        f fVar = f.f289b;
        if (i3 > 0) {
            fVar = this.source.d(i3);
        }
        handler.goAway(k, fromHttp2, fVar);
    }

    private void readWindowUpdate(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long k = this.source.k() & 2147483647L;
        if (k == 0) {
            throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(k));
        }
        handler.windowUpdate(i2, k);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ContinuationSource implements s {
        byte flags;
        int left;
        int length;
        short padding;
        private final e source;
        int streamId;

        public ContinuationSource(e eVar) {
            this.source = eVar;
        }

        @Override // c.s
        public long read(c cVar, long j) throws IOException {
            while (this.left == 0) {
                this.source.h(this.padding);
                this.padding = (short) 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
            long read = this.source.read(cVar, Math.min(j, this.left));
            if (read != -1) {
                this.left = (int) (this.left - read);
                return read;
            }
            return -1L;
        }

        @Override // c.s
        public t timeout() {
            return this.source.timeout();
        }

        @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        private void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int readMedium = Http2Reader.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            byte i2 = (byte) (this.source.i() & Constants.UNKNOWN);
            this.flags = (byte) (this.source.i() & Constants.UNKNOWN);
            if (Http2Reader.logger.isLoggable(Level.FINE)) {
                Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, i2, this.flags));
            }
            this.streamId = this.source.k() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (i2 != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(i2));
            }
            if (this.streamId != i) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int readMedium(e eVar) throws IOException {
        return ((eVar.i() & Constants.UNKNOWN) << 16) | ((eVar.i() & Constants.UNKNOWN) << 8) | (eVar.i() & Constants.UNKNOWN);
    }

    static int lengthWithoutPadding(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s > i) {
            throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        }
        return (short) (i - s);
    }
}

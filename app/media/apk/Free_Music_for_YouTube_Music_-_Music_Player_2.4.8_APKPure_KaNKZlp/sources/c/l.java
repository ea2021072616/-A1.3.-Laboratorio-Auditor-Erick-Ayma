package c;

import com.pili.pldroid.player.AVOptions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: Okio.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f298a = Logger.getLogger(l.class.getName());

    private l() {
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    public static r a(OutputStream outputStream) {
        return a(outputStream, new t());
    }

    private static r a(final OutputStream outputStream, final t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new r() { // from class: c.l.1
            @Override // c.r
            public void write(c cVar, long j) throws IOException {
                u.a(cVar.f285b, 0L, j);
                while (j > 0) {
                    t.this.throwIfReached();
                    o oVar = cVar.f284a;
                    int min = (int) Math.min(j, oVar.f313c - oVar.f312b);
                    outputStream.write(oVar.f311a, oVar.f312b, min);
                    oVar.f312b += min;
                    j -= min;
                    cVar.f285b -= min;
                    if (oVar.f312b == oVar.f313c) {
                        cVar.f284a = oVar.a();
                        p.a(oVar);
                    }
                }
            }

            @Override // c.r, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // c.r
            public t timeout() {
                return t.this;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static r a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        a c2 = c(socket);
        return c2.sink(a(socket.getOutputStream(), c2));
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(final InputStream inputStream, final t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new s() { // from class: c.l.2
            @Override // c.s
            public long read(c cVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: " + j);
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    t.this.throwIfReached();
                    o e = cVar.e(1);
                    int read = inputStream.read(e.f311a, e.f313c, (int) Math.min(j, 8192 - e.f313c));
                    if (read == -1) {
                        return -1L;
                    }
                    e.f313c += read;
                    cVar.f285b += read;
                    return read;
                } catch (AssertionError e2) {
                    if (l.a(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }

            @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // c.s
            public t timeout() {
                return t.this;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static s a(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileInputStream(file));
    }

    public static r b(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file));
    }

    public static r c(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file, true));
    }

    public static r a() {
        return new r() { // from class: c.l.3
            @Override // c.r
            public void write(c cVar, long j) throws IOException {
                cVar.h(j);
            }

            @Override // c.r, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // c.r
            public t timeout() {
                return t.NONE;
            }

            @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }
        };
    }

    public static s b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        a c2 = c(socket);
        return c2.source(a(socket.getInputStream(), c2));
    }

    private static a c(final Socket socket) {
        return new a() { // from class: c.l.4
            @Override // c.a
            protected IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException(AVOptions.KEY_PREPARE_TIMEOUT);
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // c.a
            protected void timedOut() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (l.a(e)) {
                        l.f298a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    l.f298a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}

package b.a.a.a.a.e;

import com.google.android.exoplayer2.C;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
/* compiled from: HttpRequest.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f191b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    private static b f192c = b.f199a;

    /* renamed from: a  reason: collision with root package name */
    public final URL f193a;
    private final String e;
    private e f;
    private boolean g;
    private String k;
    private int l;
    private HttpURLConnection d = null;
    private boolean h = true;
    private boolean i = false;
    private int j = 8192;

    /* compiled from: HttpRequest.java */
    /* loaded from: classes.dex */
    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f199a = new b() { // from class: b.a.a.a.a.e.d.b.1
            @Override // b.a.a.a.a.e.d.b
            public HttpURLConnection a(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }

            @Override // b.a.a.a.a.e.d.b
            public HttpURLConnection a(URL url, Proxy proxy) throws IOException {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        };

        HttpURLConnection a(URL url) throws IOException;

        HttpURLConnection a(URL url, Proxy proxy) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(String str) {
        return (str == null || str.length() <= 0) ? C.UTF8_NAME : str;
    }

    private static StringBuilder a(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    private static StringBuilder b(String str, StringBuilder sb) {
        int indexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (indexOf == -1) {
            sb.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    /* compiled from: HttpRequest.java */
    /* loaded from: classes.dex */
    public static class c extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        protected c(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        /* renamed from: a */
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: HttpRequest.java */
    /* renamed from: b.a.a.a.a.e.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractCallableC0011d<V> implements Callable<V> {
        protected abstract V b() throws c, IOException;

        protected abstract void c() throws IOException;

        protected AbstractCallableC0011d() {
        }

        @Override // java.util.concurrent.Callable
        public V call() throws c {
            boolean z = true;
            try {
                try {
                    try {
                        V b2 = b();
                        try {
                            c();
                            return b2;
                        } catch (IOException e) {
                            throw new c(e);
                        }
                    } catch (c e2) {
                        throw e2;
                    }
                } catch (IOException e3) {
                    throw new c(e3);
                } catch (Throwable th) {
                    th = th;
                    z = false;
                    try {
                        c();
                    } catch (IOException e4) {
                        if (!z) {
                            throw new c(e4);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                c();
                throw th;
            }
        }
    }

    /* compiled from: HttpRequest.java */
    /* loaded from: classes.dex */
    protected static abstract class a<V> extends AbstractCallableC0011d<V> {

        /* renamed from: a  reason: collision with root package name */
        private final Closeable f197a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f198b;

        protected a(Closeable closeable, boolean z) {
            this.f197a = closeable;
            this.f198b = z;
        }

        @Override // b.a.a.a.a.e.d.AbstractCallableC0011d
        protected void c() throws IOException {
            if (this.f197a instanceof Flushable) {
                ((Flushable) this.f197a).flush();
            }
            if (this.f198b) {
                try {
                    this.f197a.close();
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            this.f197a.close();
        }
    }

    /* compiled from: HttpRequest.java */
    /* loaded from: classes.dex */
    public static class e extends BufferedOutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final CharsetEncoder f200a;

        public e(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f200a = Charset.forName(d.f(str)).newEncoder();
        }

        public e a(String str) throws IOException {
            ByteBuffer encode = this.f200a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    public static String a(CharSequence charSequence) throws c {
        int port;
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            if (url.getPort() != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = aSCIIString.indexOf(63);
                if (indexOf > 0 && indexOf + 1 < aSCIIString.length()) {
                    return aSCIIString.substring(0, indexOf + 1) + aSCIIString.substring(indexOf + 1).replace("+", "%2B");
                }
                return aSCIIString;
            } catch (URISyntaxException e2) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e2);
                throw new c(iOException);
            }
        } catch (IOException e3) {
            throw new c(e3);
        }
    }

    public static String a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(charSequence2);
            a(charSequence2, sb);
            b(charSequence2, sb);
            Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
            Map.Entry<?, ?> next = it.next();
            sb.append(next.getKey().toString());
            sb.append('=');
            Object value = next.getValue();
            if (value != null) {
                sb.append(value);
            }
            while (it.hasNext()) {
                sb.append('&');
                Map.Entry<?, ?> next2 = it.next();
                sb.append(next2.getKey().toString());
                sb.append('=');
                Object value2 = next2.getValue();
                if (value2 != null) {
                    sb.append(value2);
                }
            }
            return sb.toString();
        }
        return charSequence2;
    }

    public static d b(CharSequence charSequence) throws c {
        return new d(charSequence, "GET");
    }

    public static d a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a2 = a(charSequence, map);
        if (z) {
            a2 = a((CharSequence) a2);
        }
        return b((CharSequence) a2);
    }

    public static d c(CharSequence charSequence) throws c {
        return new d(charSequence, "POST");
    }

    public static d b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a2 = a(charSequence, map);
        if (z) {
            a2 = a((CharSequence) a2);
        }
        return c((CharSequence) a2);
    }

    public static d d(CharSequence charSequence) throws c {
        return new d(charSequence, "PUT");
    }

    public static d e(CharSequence charSequence) throws c {
        return new d(charSequence, "DELETE");
    }

    public d(CharSequence charSequence, String str) throws c {
        try {
            this.f193a = new URL(charSequence.toString());
            this.e = str;
        } catch (MalformedURLException e2) {
            throw new c(e2);
        }
    }

    private Proxy q() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.k, this.l));
    }

    private HttpURLConnection r() {
        HttpURLConnection a2;
        try {
            if (this.k != null) {
                a2 = f192c.a(this.f193a, q());
            } else {
                a2 = f192c.a(this.f193a);
            }
            a2.setRequestMethod(this.e);
            return a2;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public String toString() {
        return p() + ' ' + o();
    }

    public HttpURLConnection a() {
        if (this.d == null) {
            this.d = r();
        }
        return this.d;
    }

    public int b() throws c {
        try {
            k();
            return a().getResponseCode();
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public boolean c() throws c {
        return 200 == b();
    }

    protected ByteArrayOutputStream d() {
        int j = j();
        return j > 0 ? new ByteArrayOutputStream(j) : new ByteArrayOutputStream();
    }

    public String a(String str) throws c {
        ByteArrayOutputStream d = d();
        try {
            a(f(), d);
            return d.toString(f(str));
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public String e() throws c {
        return a(h());
    }

    public BufferedInputStream f() throws c {
        return new BufferedInputStream(g(), this.j);
    }

    public InputStream g() throws c {
        InputStream inputStream;
        if (b() < 400) {
            try {
                inputStream = a().getInputStream();
            } catch (IOException e2) {
                throw new c(e2);
            }
        } else {
            inputStream = a().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = a().getInputStream();
                } catch (IOException e3) {
                    throw new c(e3);
                }
            }
        }
        if (!this.i || !"gzip".equals(i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e4) {
            throw new c(e4);
        }
    }

    public d a(int i) {
        a().setConnectTimeout(i);
        return this;
    }

    public d a(String str, String str2) {
        a().setRequestProperty(str, str2);
        return this;
    }

    public d a(Map.Entry<String, String> entry) {
        return a(entry.getKey(), entry.getValue());
    }

    public String b(String str) throws c {
        l();
        return a().getHeaderField(str);
    }

    public int c(String str) throws c {
        return a(str, -1);
    }

    public int a(String str, int i) throws c {
        l();
        return a().getHeaderFieldInt(str, i);
    }

    public String b(String str, String str2) {
        return c(b(str), str2);
    }

    protected String c(String str, String str2) {
        int i;
        int i2;
        String trim;
        int length;
        if (str == null || str.length() == 0) {
            return null;
        }
        int length2 = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length2) {
            return null;
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            i = indexOf;
            i2 = length2;
        } else {
            i = indexOf;
            i2 = indexOf2;
        }
        while (i < i2) {
            int indexOf3 = str.indexOf(61, i);
            if (indexOf3 != -1 && indexOf3 < i2 && str2.equals(str.substring(i, indexOf3).trim()) && (length = (trim = str.substring(indexOf3 + 1, i2).trim()).length()) != 0) {
                if (length > 2 && '\"' == trim.charAt(0) && '\"' == trim.charAt(length - 1)) {
                    return trim.substring(1, length - 1);
                }
                return trim;
            }
            int i3 = i2 + 1;
            int indexOf4 = str.indexOf(59, i3);
            if (indexOf4 == -1) {
                indexOf4 = length2;
            }
            int i4 = indexOf4;
            i = i3;
            i2 = i4;
        }
        return null;
    }

    public String h() {
        return b("Content-Type", "charset");
    }

    public d a(boolean z) {
        a().setUseCaches(z);
        return this;
    }

    public String i() {
        return b("Content-Encoding");
    }

    public d d(String str) {
        return d(str, null);
    }

    public d d(String str, String str2) {
        return (str2 == null || str2.length() <= 0) ? a("Content-Type", str) : a("Content-Type", str + "; charset=" + str2);
    }

    public int j() {
        return c("Content-Length");
    }

    protected d a(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        return new a<d>(inputStream, this.h) { // from class: b.a.a.a.a.e.d.1
            @Override // b.a.a.a.a.e.d.AbstractCallableC0011d
            /* renamed from: a */
            public d b() throws IOException {
                byte[] bArr = new byte[d.this.j];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        return d.this;
                    }
                }
            }
        }.call();
    }

    protected d k() throws IOException {
        if (this.f != null) {
            if (this.g) {
                this.f.a("\r\n--00content0boundary00--\r\n");
            }
            if (this.h) {
                try {
                    this.f.close();
                } catch (IOException e2) {
                }
            } else {
                this.f.close();
            }
            this.f = null;
        }
        return this;
    }

    protected d l() throws c {
        try {
            return k();
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    protected d m() throws IOException {
        if (this.f == null) {
            a().setDoOutput(true);
            this.f = new e(a().getOutputStream(), c(a().getRequestProperty("Content-Type"), "charset"), this.j);
        }
        return this;
    }

    protected d n() throws IOException {
        if (!this.g) {
            this.g = true;
            d("multipart/form-data; boundary=00content0boundary00").m();
            this.f.a("--00content0boundary00\r\n");
        } else {
            this.f.a("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    protected d a(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"").append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"").append(str2);
        }
        sb.append('\"');
        f("Content-Disposition", sb.toString());
        if (str3 != null) {
            f("Content-Type", str3);
        }
        return f("\r\n");
    }

    public d e(String str, String str2) {
        return b(str, (String) null, str2);
    }

    public d b(String str, String str2, String str3) throws c {
        return a(str, str2, (String) null, str3);
    }

    public d a(String str, String str2, String str3, String str4) throws c {
        try {
            n();
            a(str, str2, str3);
            this.f.a(str4);
            return this;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public d a(String str, Number number) throws c {
        return a(str, (String) null, number);
    }

    public d a(String str, String str2, Number number) throws c {
        return b(str, str2, number != null ? number.toString() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b.a.a.a.a.e.d a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.io.File r7) throws b.a.a.a.a.e.d.c {
        /*
            r3 = this;
            r2 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            r0.<init>(r7)     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            r1.<init>(r0)     // Catch: java.io.IOException -> L15 java.lang.Throwable -> L28
            b.a.a.a.a.e.d r0 = r3.a(r4, r5, r6, r1)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L2b
            if (r1 == 0) goto L14
            r1.close()     // Catch: java.io.IOException -> L24
        L14:
            return r0
        L15:
            r0 = move-exception
            r1 = r2
        L17:
            b.a.a.a.a.e.d$c r2 = new b.a.a.a.a.e.d$c     // Catch: java.lang.Throwable -> L1d
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L1d
            throw r2     // Catch: java.lang.Throwable -> L1d
        L1d:
            r0 = move-exception
        L1e:
            if (r1 == 0) goto L23
            r1.close()     // Catch: java.io.IOException -> L26
        L23:
            throw r0
        L24:
            r1 = move-exception
            goto L14
        L26:
            r1 = move-exception
            goto L23
        L28:
            r0 = move-exception
            r1 = r2
            goto L1e
        L2b:
            r0 = move-exception
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.a.a.e.d.a(java.lang.String, java.lang.String, java.lang.String, java.io.File):b.a.a.a.a.e.d");
    }

    public d a(String str, String str2, String str3, InputStream inputStream) throws c {
        try {
            n();
            a(str, str2, str3);
            a(inputStream, this.f);
            return this;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public d f(String str, String str2) throws c {
        return f((CharSequence) str).f(": ").f((CharSequence) str2).f("\r\n");
    }

    public d f(CharSequence charSequence) throws c {
        try {
            m();
            this.f.a(charSequence.toString());
            return this;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public URL o() {
        return a().getURL();
    }

    public String p() {
        return a().getRequestMethod();
    }
}

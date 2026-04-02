package c;

import com.flurry.android.Constants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public final class c implements d, e, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f283c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with root package name */
    o f284a;

    /* renamed from: b  reason: collision with root package name */
    long f285b;

    public long a() {
        return this.f285b;
    }

    @Override // c.d, c.e
    public c b() {
        return this;
    }

    public OutputStream c() {
        return new OutputStream() { // from class: c.c.1
            @Override // java.io.OutputStream
            public void write(int i) {
                c.this.i((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                c.this.c(bArr, i, i2);
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public String toString() {
                return c.this + ".outputStream()";
            }
        };
    }

    @Override // c.d
    /* renamed from: d */
    public c y() {
        return this;
    }

    @Override // c.d
    public d e() {
        return this;
    }

    @Override // c.e
    public boolean f() {
        return this.f285b == 0;
    }

    @Override // c.e
    public void a(long j) throws EOFException {
        if (this.f285b < j) {
            throw new EOFException();
        }
    }

    @Override // c.e
    public boolean b(long j) {
        return this.f285b >= j;
    }

    @Override // c.e
    public InputStream g() {
        return new InputStream() { // from class: c.c.2
            @Override // java.io.InputStream
            public int read() {
                if (c.this.f285b > 0) {
                    return c.this.i() & Constants.UNKNOWN;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.f285b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        u.a(this.f285b, j, j2);
        if (j2 != 0) {
            cVar.f285b += j2;
            o oVar = this.f284a;
            while (j >= oVar.f313c - oVar.f312b) {
                j -= oVar.f313c - oVar.f312b;
                oVar = oVar.f;
            }
            while (j2 > 0) {
                o oVar2 = new o(oVar);
                oVar2.f312b = (int) (oVar2.f312b + j);
                oVar2.f313c = Math.min(oVar2.f312b + ((int) j2), oVar2.f313c);
                if (cVar.f284a == null) {
                    oVar2.g = oVar2;
                    oVar2.f = oVar2;
                    cVar.f284a = oVar2;
                } else {
                    cVar.f284a.g.a(oVar2);
                }
                j2 -= oVar2.f313c - oVar2.f312b;
                oVar = oVar.f;
                j = 0;
            }
        }
        return this;
    }

    public long h() {
        long j = this.f285b;
        if (j == 0) {
            return 0L;
        }
        o oVar = this.f284a.g;
        if (oVar.f313c < 8192 && oVar.e) {
            return j - (oVar.f313c - oVar.f312b);
        }
        return j;
    }

    @Override // c.e
    public byte i() {
        if (this.f285b == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.f284a;
        int i = oVar.f312b;
        int i2 = oVar.f313c;
        int i3 = i + 1;
        byte b2 = oVar.f311a[i];
        this.f285b--;
        if (i3 == i2) {
            this.f284a = oVar.a();
            p.a(oVar);
        } else {
            oVar.f312b = i3;
        }
        return b2;
    }

    public byte c(long j) {
        u.a(this.f285b, j, 1L);
        o oVar = this.f284a;
        while (true) {
            int i = oVar.f313c - oVar.f312b;
            if (j < i) {
                return oVar.f311a[oVar.f312b + ((int) j)];
            }
            j -= i;
            oVar = oVar.f;
        }
    }

    @Override // c.e
    public short j() {
        if (this.f285b < 2) {
            throw new IllegalStateException("size < 2: " + this.f285b);
        }
        o oVar = this.f284a;
        int i = oVar.f312b;
        int i2 = oVar.f313c;
        if (i2 - i < 2) {
            return (short) (((i() & Constants.UNKNOWN) << 8) | (i() & Constants.UNKNOWN));
        }
        byte[] bArr = oVar.f311a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & Constants.UNKNOWN) << 8) | (bArr[i3] & Constants.UNKNOWN);
        this.f285b -= 2;
        if (i4 == i2) {
            this.f284a = oVar.a();
            p.a(oVar);
        } else {
            oVar.f312b = i4;
        }
        return (short) i5;
    }

    @Override // c.e
    public int k() {
        if (this.f285b < 4) {
            throw new IllegalStateException("size < 4: " + this.f285b);
        }
        o oVar = this.f284a;
        int i = oVar.f312b;
        int i2 = oVar.f313c;
        if (i2 - i < 4) {
            return ((i() & Constants.UNKNOWN) << 24) | ((i() & Constants.UNKNOWN) << 16) | ((i() & Constants.UNKNOWN) << 8) | (i() & Constants.UNKNOWN);
        }
        byte[] bArr = oVar.f311a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & Constants.UNKNOWN) << 24) | ((bArr[i3] & Constants.UNKNOWN) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & Constants.UNKNOWN) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & Constants.UNKNOWN);
        this.f285b -= 4;
        if (i8 == i2) {
            this.f284a = oVar.a();
            p.a(oVar);
            return i9;
        }
        oVar.f312b = i8;
        return i9;
    }

    @Override // c.e
    public long l() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.f285b < 8) {
            throw new IllegalStateException("size < 8: " + this.f285b);
        }
        o oVar = this.f284a;
        int i7 = oVar.f312b;
        int i8 = oVar.f313c;
        if (i8 - i7 < 8) {
            return ((k() & 4294967295L) << 32) | (k() & 4294967295L);
        }
        byte[] bArr = oVar.f311a;
        int i9 = i7 + 1 + 1;
        long j = ((bArr[i] & 255) << 48) | ((bArr[i7] & 255) << 56);
        long j2 = j | ((bArr[i9] & 255) << 40) | ((bArr[i2] & 255) << 32);
        long j3 = j2 | ((bArr[i3] & 255) << 24) | ((bArr[i4] & 255) << 16);
        int i10 = i9 + 1 + 1 + 1 + 1 + 1 + 1;
        long j4 = (bArr[i6] & 255) | j3 | ((bArr[i5] & 255) << 8);
        this.f285b -= 8;
        if (i10 == i8) {
            this.f284a = oVar.a();
            p.a(oVar);
            return j4;
        }
        oVar.f312b = i10;
        return j4;
    }

    @Override // c.e
    public short m() {
        return u.a(j());
    }

    @Override // c.e
    public int n() {
        return u.a(k());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd A[EDGE_INSN: B:44:0x00cd->B:39:0x00cd ?: BREAK  , SYNTHETIC] */
    @Override // c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long o() {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.o():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1 A[EDGE_INSN: B:41:0x00b1->B:37:0x00b1 ?: BREAK  , SYNTHETIC] */
    @Override // c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long p() {
        /*
            r18 = this;
            r0 = r18
            long r2 = r0.f285b
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L12
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "size == 0"
            r2.<init>(r3)
            throw r2
        L12:
            r4 = 0
            r3 = 0
            r2 = 0
        L16:
            r0 = r18
            c.o r10 = r0.f284a
            byte[] r11 = r10.f311a
            int r6 = r10.f312b
            int r12 = r10.f313c
            r7 = r6
        L21:
            if (r7 >= r12) goto L9c
            r8 = r11[r7]
            r6 = 48
            if (r8 < r6) goto L62
            r6 = 57
            if (r8 > r6) goto L62
            int r6 = r8 + (-48)
        L2f:
            r14 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r14 = r14 & r4
            r16 = 0
            int r9 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r9 == 0) goto Lbd
            c.c r2 = new c.c
            r2.<init>()
            c.c r2 = r2.l(r4)
            c.c r2 = r2.i(r8)
            java.lang.NumberFormatException r3 = new java.lang.NumberFormatException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Number too large: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r2 = r2.r()
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r2 = r2.toString()
            r3.<init>(r2)
            throw r3
        L62:
            r6 = 97
            if (r8 < r6) goto L6f
            r6 = 102(0x66, float:1.43E-43)
            if (r8 > r6) goto L6f
            int r6 = r8 + (-97)
            int r6 = r6 + 10
            goto L2f
        L6f:
            r6 = 65
            if (r8 < r6) goto L7c
            r6 = 70
            if (r8 > r6) goto L7c
            int r6 = r8 + (-65)
            int r6 = r6 + 10
            goto L2f
        L7c:
            if (r3 != 0) goto L9b
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = java.lang.Integer.toHexString(r8)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L9b:
            r2 = 1
        L9c:
            if (r7 != r12) goto Lc9
            c.o r6 = r10.a()
            r0 = r18
            r0.f284a = r6
            c.p.a(r10)
        La9:
            if (r2 != 0) goto Lb1
            r0 = r18
            c.o r6 = r0.f284a
            if (r6 != 0) goto L16
        Lb1:
            r0 = r18
            long r6 = r0.f285b
            long r2 = (long) r3
            long r2 = r6 - r2
            r0 = r18
            r0.f285b = r2
            return r4
        Lbd:
            r8 = 4
            long r4 = r4 << r8
            long r8 = (long) r6
            long r8 = r8 | r4
            int r4 = r7 + 1
            int r3 = r3 + 1
            r7 = r4
            r4 = r8
            goto L21
        Lc9:
            r10.f312b = r7
            goto La9
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.p():long");
    }

    public f q() {
        return new f(u());
    }

    @Override // c.e
    public f d(long j) throws EOFException {
        return new f(g(j));
    }

    @Override // c.e
    public void a(c cVar, long j) throws EOFException {
        if (this.f285b < j) {
            cVar.write(this, this.f285b);
            throw new EOFException();
        } else {
            cVar.write(this, j);
        }
    }

    @Override // c.e
    public long a(r rVar) throws IOException {
        long j = this.f285b;
        if (j > 0) {
            rVar.write(this, j);
        }
        return j;
    }

    public String r() {
        try {
            return a(this.f285b, u.f316a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String e(long j) throws EOFException {
        return a(j, u.f316a);
    }

    @Override // c.e
    public String a(Charset charset) {
        try {
            return a(this.f285b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        u.a(this.f285b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        o oVar = this.f284a;
        if (oVar.f312b + j > oVar.f313c) {
            return new String(g(j), charset);
        }
        String str = new String(oVar.f311a, oVar.f312b, (int) j, charset);
        oVar.f312b = (int) (oVar.f312b + j);
        this.f285b -= j;
        if (oVar.f312b == oVar.f313c) {
            this.f284a = oVar.a();
            p.a(oVar);
            return str;
        }
        return str;
    }

    @Override // c.e
    public String s() throws EOFException {
        long a2 = a((byte) 10);
        if (a2 == -1) {
            c cVar = new c();
            a(cVar, 0L, Math.min(32L, this.f285b));
            throw new EOFException("\\n not found: size=" + a() + " content=" + cVar.q().f() + "…");
        }
        return f(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f(long j) throws EOFException {
        if (j > 0 && c(j - 1) == 13) {
            String e = e(j - 1);
            h(2L);
            return e;
        }
        String e2 = e(j);
        h(1L);
        return e2;
    }

    public int t() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.f285b == 0) {
            throw new EOFException();
        }
        byte c2 = c(0L);
        if ((c2 & 128) == 0) {
            i3 = 0;
            i = c2 & Byte.MAX_VALUE;
            i2 = 1;
        } else if ((c2 & 224) == 192) {
            i = c2 & 31;
            i2 = 2;
            i3 = 128;
        } else if ((c2 & 240) == 224) {
            i = c2 & 15;
            i2 = 3;
            i3 = 2048;
        } else if ((c2 & 248) == 240) {
            i = c2 & 7;
            i2 = 4;
            i3 = 65536;
        } else {
            h(1L);
            return 65533;
        }
        if (this.f285b < i2) {
            throw new EOFException("size < " + i2 + ": " + this.f285b + " (to read code point prefixed 0x" + Integer.toHexString(c2) + ")");
        }
        int i4 = i;
        int i5 = 1;
        while (i5 < i2) {
            byte c3 = c(i5);
            if ((c3 & 192) == 128) {
                i5++;
                i4 = (c3 & 63) | (i4 << 6);
            } else {
                h(i5);
                return 65533;
            }
        }
        h(i2);
        if (i4 > 1114111) {
            return 65533;
        }
        if ((i4 < 55296 || i4 > 57343) && i4 >= i3) {
            return i4;
        }
        return 65533;
    }

    @Override // c.e
    public byte[] u() {
        try {
            return g(this.f285b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // c.e
    public byte[] g(long j) throws EOFException {
        u.a(this.f285b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    @Override // c.e
    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 == -1) {
                throw new EOFException();
            }
            i += a2;
        }
    }

    @Override // c.e
    public int a(byte[] bArr, int i, int i2) {
        u.a(bArr.length, i, i2);
        o oVar = this.f284a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i2, oVar.f313c - oVar.f312b);
        System.arraycopy(oVar.f311a, oVar.f312b, bArr, i, min);
        oVar.f312b += min;
        this.f285b -= min;
        if (oVar.f312b == oVar.f313c) {
            this.f284a = oVar.a();
            p.a(oVar);
            return min;
        }
        return min;
    }

    public void v() {
        try {
            h(this.f285b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // c.e
    public void h(long j) throws EOFException {
        while (j > 0) {
            if (this.f284a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, this.f284a.f313c - this.f284a.f312b);
            this.f285b -= min;
            j -= min;
            o oVar = this.f284a;
            oVar.f312b = min + oVar.f312b;
            if (this.f284a.f312b == this.f284a.f313c) {
                o oVar2 = this.f284a;
                this.f284a = oVar2.a();
                p.a(oVar2);
            }
        }
    }

    @Override // c.d
    /* renamed from: a */
    public c b(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.a(this);
        return this;
    }

    @Override // c.d
    /* renamed from: a */
    public c b(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                o e = e(1);
                byte[] bArr = e.f311a;
                int i4 = e.f313c - i;
                int min = Math.min(i2, 8192 - i4);
                i3 = i + 1;
                bArr[i4 + i] = (byte) charAt;
                while (i3 < min) {
                    char charAt2 = str.charAt(i3);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i3 + i4] = (byte) charAt2;
                    i3++;
                }
                int i5 = (i3 + i4) - e.f313c;
                e.f313c += i5;
                this.f285b += i5;
            } else if (charAt < 2048) {
                i((charAt >> 6) | PsExtractor.AUDIO_STREAM);
                i((charAt & '?') | 128);
                i3 = i + 1;
            } else if (charAt < 55296 || charAt > 57343) {
                i((charAt >> '\f') | 224);
                i(((charAt >> 6) & 63) | 128);
                i((charAt & '?') | 128);
                i3 = i + 1;
            } else {
                char charAt3 = i + 1 < i2 ? str.charAt(i + 1) : (char) 0;
                if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                    i(63);
                    i++;
                } else {
                    int i6 = ((charAt3 & 9215) | ((charAt & 10239) << 10)) + 65536;
                    i((i6 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                    i(((i6 >> 12) & 63) | 128);
                    i(((i6 >> 6) & 63) | 128);
                    i((i6 & 63) | 128);
                    i3 = i + 2;
                }
            }
            i = i3;
        }
        return this;
    }

    public c a(int i) {
        if (i < 128) {
            i(i);
        } else if (i < 2048) {
            i((i >> 6) | PsExtractor.AUDIO_STREAM);
            i((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            i((i >> 12) | 224);
            i(((i >> 6) & 63) | 128);
            i((i & 63) | 128);
        } else if (i <= 1114111) {
            i((i >> 18) | PsExtractor.VIDEO_STREAM_MASK);
            i(((i >> 12) & 63) | 128);
            i(((i >> 6) & 63) | 128);
            i((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c a(String str, Charset charset) {
        return a(str, 0, str.length(), charset);
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(u.f316a)) {
            return a(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return c(bytes, 0, bytes.length);
    }

    @Override // c.d
    /* renamed from: b */
    public c c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return c(bArr, 0, bArr.length);
    }

    @Override // c.d
    /* renamed from: b */
    public c c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        u.a(bArr.length, i, i2);
        int i3 = i + i2;
        while (i < i3) {
            o e = e(1);
            int min = Math.min(i3 - i, 8192 - e.f313c);
            System.arraycopy(bArr, i, e.f311a, e.f313c, min);
            i += min;
            e.f313c = min + e.f313c;
        }
        this.f285b += i2;
        return this;
    }

    @Override // c.d
    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = sVar.read(this, 8192L);
            if (read != -1) {
                j += read;
            } else {
                return j;
            }
        }
    }

    @Override // c.d
    /* renamed from: b */
    public c i(int i) {
        o e = e(1);
        byte[] bArr = e.f311a;
        int i2 = e.f313c;
        e.f313c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f285b++;
        return this;
    }

    @Override // c.d
    /* renamed from: c */
    public c h(int i) {
        o e = e(2);
        byte[] bArr = e.f311a;
        int i2 = e.f313c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        e.f313c = i3 + 1;
        this.f285b += 2;
        return this;
    }

    @Override // c.d
    /* renamed from: d */
    public c g(int i) {
        o e = e(4);
        byte[] bArr = e.f311a;
        int i2 = e.f313c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        e.f313c = i5 + 1;
        this.f285b += 4;
        return this;
    }

    @Override // c.d
    /* renamed from: i */
    public c n(long j) {
        o e = e(8);
        byte[] bArr = e.f311a;
        int i = e.f313c;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        e.f313c = i8 + 1;
        this.f285b += 8;
        return this;
    }

    @Override // c.d
    /* renamed from: j */
    public c m(long j) {
        boolean z;
        long j2;
        int i;
        if (j == 0) {
            return i(48);
        }
        if (j >= 0) {
            z = false;
            j2 = j;
        } else {
            j2 = -j;
            if (j2 < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < C.NANOS_PER_SECOND ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i = j2 < C.MICROS_PER_SECOND ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 < 100) {
            i = j2 < 10 ? 1 : 2;
        } else {
            i = j2 < 1000 ? 3 : 4;
        }
        if (z) {
            i++;
        }
        o e = e(i);
        byte[] bArr = e.f311a;
        int i2 = e.f313c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = f283c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        e.f313c += i;
        this.f285b = i + this.f285b;
        return this;
    }

    @Override // c.d
    /* renamed from: k */
    public c l(long j) {
        if (j == 0) {
            return i(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        o e = e(numberOfTrailingZeros);
        byte[] bArr = e.f311a;
        int i = e.f313c;
        for (int i2 = (e.f313c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f283c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f313c += numberOfTrailingZeros;
        this.f285b = numberOfTrailingZeros + this.f285b;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o e(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        if (this.f284a == null) {
            this.f284a = p.a();
            o oVar = this.f284a;
            o oVar2 = this.f284a;
            o oVar3 = this.f284a;
            oVar2.g = oVar3;
            oVar.f = oVar3;
            return oVar3;
        }
        o oVar4 = this.f284a.g;
        if (oVar4.f313c + i > 8192 || !oVar4.e) {
            return oVar4.a(p.a());
        }
        return oVar4;
    }

    @Override // c.r
    public void write(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        u.a(cVar.f285b, 0L, j);
        while (j > 0) {
            if (j < cVar.f284a.f313c - cVar.f284a.f312b) {
                o oVar = this.f284a != null ? this.f284a.g : null;
                if (oVar != null && oVar.e) {
                    if ((oVar.f313c + j) - (oVar.d ? 0 : oVar.f312b) <= 8192) {
                        cVar.f284a.a(oVar, (int) j);
                        cVar.f285b -= j;
                        this.f285b += j;
                        return;
                    }
                }
                cVar.f284a = cVar.f284a.a((int) j);
            }
            o oVar2 = cVar.f284a;
            long j2 = oVar2.f313c - oVar2.f312b;
            cVar.f284a = oVar2.a();
            if (this.f284a == null) {
                this.f284a = oVar2;
                o oVar3 = this.f284a;
                o oVar4 = this.f284a;
                o oVar5 = this.f284a;
                oVar4.g = oVar5;
                oVar3.f = oVar5;
            } else {
                this.f284a.g.a(oVar2).b();
            }
            cVar.f285b -= j2;
            this.f285b += j2;
            j -= j2;
        }
    }

    @Override // c.s
    public long read(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f285b == 0) {
            return -1L;
        }
        if (j > this.f285b) {
            j = this.f285b;
        }
        cVar.write(this, j);
        return j;
    }

    @Override // c.e
    public long a(byte b2) {
        return a(b2, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(byte r11, long r12) {
        /*
            r10 = this;
            r0 = 0
            r6 = -1
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 >= 0) goto L10
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "fromIndex < 0"
            r0.<init>(r1)
            throw r0
        L10:
            c.o r2 = r10.f284a
            if (r2 != 0) goto L16
            r0 = r6
        L15:
            return r0
        L16:
            long r4 = r10.f285b
            long r4 = r4 - r12
            int r3 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r3 >= 0) goto L2e
            long r0 = r10.f285b
            r4 = r2
        L20:
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 <= 0) goto L49
            c.o r4 = r4.g
            int r2 = r4.f313c
            int r3 = r4.f312b
            int r2 = r2 - r3
            long r2 = (long) r2
            long r0 = r0 - r2
            goto L20
        L2e:
            r4 = r2
        L2f:
            int r2 = r4.f313c
            int r3 = r4.f312b
            int r2 = r2 - r3
            long r2 = (long) r2
            long r2 = r2 + r0
            int r5 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r5 >= 0) goto L49
            c.o r0 = r4.f
            r4 = r0
            r0 = r2
            goto L2f
        L3f:
            int r2 = r4.f313c
            int r3 = r4.f312b
            int r2 = r2 - r3
            long r2 = (long) r2
            long r0 = r0 + r2
            c.o r4 = r4.f
            r12 = r0
        L49:
            long r2 = r10.f285b
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L68
            byte[] r3 = r4.f311a
            int r2 = r4.f312b
            long r8 = (long) r2
            long r8 = r8 + r12
            long r8 = r8 - r0
            int r2 = (int) r8
            int r5 = r4.f313c
        L59:
            if (r2 >= r5) goto L3f
            r8 = r3[r2]
            if (r8 != r11) goto L65
            int r3 = r4.f312b
            int r2 = r2 - r3
            long r2 = (long) r2
            long r0 = r0 + r2
            goto L15
        L65:
            int r2 = r2 + 1
            goto L59
        L68:
            r0 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a(byte, long):long");
    }

    @Override // c.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.h());
    }

    public boolean a(long j, f fVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f285b - j < i2 || fVar.h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (c(i3 + j) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // c.d, c.r, java.io.Flushable
    public void flush() {
    }

    @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // c.r
    public t timeout() {
        return t.NONE;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f285b != cVar.f285b) {
                return false;
            }
            if (this.f285b == 0) {
                return true;
            }
            o oVar = this.f284a;
            o oVar2 = cVar.f284a;
            int i = oVar.f312b;
            int i2 = oVar2.f312b;
            while (j < this.f285b) {
                long min = Math.min(oVar.f313c - i, oVar2.f313c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    byte b2 = oVar.f311a[i];
                    int i5 = i2 + 1;
                    if (b2 != oVar2.f311a[i2]) {
                        return false;
                    }
                    i3++;
                    i2 = i5;
                    i = i4;
                }
                if (i == oVar.f313c) {
                    oVar = oVar.f;
                    i = oVar.f312b;
                }
                if (i2 == oVar2.f313c) {
                    oVar2 = oVar2.f;
                    i2 = oVar2.f312b;
                }
                j += min;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        o oVar = this.f284a;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = oVar.f312b;
            int i3 = oVar.f313c;
            while (i2 < i3) {
                i2++;
                i = oVar.f311a[i2] + (i * 31);
            }
            oVar = oVar.f;
        } while (oVar != this.f284a);
        return i;
    }

    public String toString() {
        return x().toString();
    }

    /* renamed from: w */
    public c clone() {
        c cVar = new c();
        if (this.f285b == 0) {
            return cVar;
        }
        cVar.f284a = new o(this.f284a);
        o oVar = cVar.f284a;
        o oVar2 = cVar.f284a;
        o oVar3 = cVar.f284a;
        oVar2.g = oVar3;
        oVar.f = oVar3;
        for (o oVar4 = this.f284a.f; oVar4 != this.f284a; oVar4 = oVar4.f) {
            cVar.f284a.g.a(new o(oVar4));
        }
        cVar.f285b = this.f285b;
        return cVar;
    }

    public f x() {
        if (this.f285b > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f285b);
        }
        return f((int) this.f285b);
    }

    public f f(int i) {
        return i == 0 ? f.f289b : new q(this, i);
    }
}

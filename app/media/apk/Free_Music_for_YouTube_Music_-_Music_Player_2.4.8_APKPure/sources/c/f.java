package c;

import com.flurry.android.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* compiled from: ByteString.java */
/* loaded from: classes.dex */
public class f implements Serializable, Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f288a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final f f289b = a(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: c  reason: collision with root package name */
    final byte[] f290c;
    transient int d;
    transient String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(byte[] bArr) {
        this.f290c = bArr;
    }

    public static f a(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new f((byte[]) bArr.clone());
    }

    public static f a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(u.f316a));
        fVar.e = str;
        return fVar;
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f290c, u.f316a);
        this.e = str2;
        return str2;
    }

    public String b() {
        return b.a(this.f290c);
    }

    public f c() {
        return d("MD5");
    }

    public f d() {
        return d("SHA-1");
    }

    public f e() {
        return d("SHA-256");
    }

    private f d(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f290c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static f b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a2 = b.a(str);
        if (a2 != null) {
            return new f(a2);
        }
        return null;
    }

    public String f() {
        byte[] bArr;
        char[] cArr = new char[this.f290c.length * 2];
        int i = 0;
        for (byte b2 : this.f290c) {
            int i2 = i + 1;
            cArr[i] = f288a[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = f288a[b2 & 15];
        }
        return new String(cArr);
    }

    public static f c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((a(str.charAt(i * 2)) << 4) + a(str.charAt((i * 2) + 1)));
        }
        return a(bArr);
    }

    private static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            if (c2 < 'a' || c2 > 'f') {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c2);
                }
                return (c2 - 'A') + 10;
            }
            return (c2 - 'a') + 10;
        }
        return c2 - '0';
    }

    public static f a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
        return new f(bArr);
    }

    public f g() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f290c.length) {
                byte b2 = this.f290c[i2];
                if (b2 < 65 || b2 > 90) {
                    i = i2 + 1;
                } else {
                    byte[] bArr = (byte[]) this.f290c.clone();
                    bArr[i2] = (byte) (b2 + 32);
                    for (int i3 = i2 + 1; i3 < bArr.length; i3++) {
                        byte b3 = bArr[i3];
                        if (b3 >= 65 && b3 <= 90) {
                            bArr[i3] = (byte) (b3 + 32);
                        }
                    }
                    return new f(bArr);
                }
            } else {
                return this;
            }
        }
    }

    public f a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (i2 > this.f290c.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f290c.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i != 0 || i2 != this.f290c.length) {
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f290c, i, bArr, 0, i3);
            return new f(bArr);
        }
        return this;
    }

    public byte a(int i) {
        return this.f290c[i];
    }

    public int h() {
        return this.f290c.length;
    }

    public byte[] i() {
        return (byte[]) this.f290c.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        cVar.c(this.f290c, 0, this.f290c.length);
    }

    public boolean a(int i, f fVar, int i2, int i3) {
        return fVar.a(i2, this.f290c, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f290c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && u.a(this.f290c, i, bArr, i2, i3);
    }

    public final boolean a(f fVar) {
        return a(0, fVar, 0, fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof f) && ((f) obj).h() == this.f290c.length && ((f) obj).a(0, this.f290c, 0, this.f290c.length);
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f290c);
        this.d = hashCode;
        return hashCode;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(f fVar) {
        int h = h();
        int h2 = fVar.h();
        int min = Math.min(h, h2);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & Constants.UNKNOWN;
            int a3 = fVar.a(i) & Constants.UNKNOWN;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (h == h2) {
            return 0;
        }
        return h >= h2 ? 1 : -1;
    }

    public String toString() {
        if (this.f290c.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int a3 = a(a2, 64);
        if (a3 == -1) {
            if (this.f290c.length <= 64) {
                return "[hex=" + f() + "]";
            }
            return "[size=" + this.f290c.length + " hex=" + a(0, 64).f() + "…]";
        }
        String replace = a2.substring(0, a3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return a3 < a2.length() ? "[size=" + this.f290c.length + " text=" + replace + "…]" : "[text=" + replace + "]";
    }

    static int a(String str, int i) {
        int i2 = 0;
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            if (i3 != i) {
                int codePointAt = str.codePointAt(i2);
                if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                    return -1;
                }
                i3++;
                i2 += Character.charCount(codePointAt);
            } else {
                return i2;
            }
        }
        return str.length();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        f a2 = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = f.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, a2.f290c);
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (NoSuchFieldException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f290c.length);
        objectOutputStream.write(this.f290c);
    }
}

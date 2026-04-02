package b.a.a.a.a.b;

import com.flurry.android.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: QueueFile.java */
/* loaded from: classes.dex */
public class q implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f124b = Logger.getLogger(q.class.getName());

    /* renamed from: a  reason: collision with root package name */
    int f125a;

    /* renamed from: c  reason: collision with root package name */
    private final RandomAccessFile f126c;
    private int d;
    private a e;
    private a f;
    private final byte[] g = new byte[16];

    /* compiled from: QueueFile.java */
    /* loaded from: classes.dex */
    public interface c {
        void read(InputStream inputStream, int i) throws IOException;
    }

    public q(File file) throws IOException {
        if (!file.exists()) {
            a(file);
        }
        this.f126c = b(file);
        e();
    }

    private static void b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            b(bArr, i, i2);
            i += 4;
        }
    }

    private static int a(byte[] bArr, int i) {
        return ((bArr[i] & Constants.UNKNOWN) << 24) + ((bArr[i + 1] & Constants.UNKNOWN) << 16) + ((bArr[i + 2] & Constants.UNKNOWN) << 8) + (bArr[i + 3] & Constants.UNKNOWN);
    }

    private void e() throws IOException {
        this.f126c.seek(0L);
        this.f126c.readFully(this.g);
        this.f125a = a(this.g, 0);
        if (this.f125a > this.f126c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f125a + ", Actual length: " + this.f126c.length());
        }
        this.d = a(this.g, 4);
        int a2 = a(this.g, 8);
        int a3 = a(this.g, 12);
        this.e = a(a2);
        this.f = a(a3);
    }

    private void a(int i, int i2, int i3, int i4) throws IOException {
        a(this.g, i, i2, i3, i4);
        this.f126c.seek(0L);
        this.f126c.write(this.g);
    }

    private a a(int i) throws IOException {
        if (i == 0) {
            return a.f130a;
        }
        this.f126c.seek(i);
        return new a(i, this.f126c.readInt());
    }

    private static void a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b2 = b(file2);
        try {
            b2.setLength(4096L);
            b2.seek(0L);
            byte[] bArr = new byte[16];
            a(bArr, 4096, 0, 0, 0);
            b2.write(bArr);
            b2.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    private static RandomAccessFile b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        return i < this.f125a ? i : (i + 16) - this.f125a;
    }

    private void a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int b2 = b(i);
        if (b2 + i3 <= this.f125a) {
            this.f126c.seek(b2);
            this.f126c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f125a - b2;
        this.f126c.seek(b2);
        this.f126c.write(bArr, i2, i4);
        this.f126c.seek(16L);
        this.f126c.write(bArr, i2 + i4, i3 - i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int b2 = b(i);
        if (b2 + i3 <= this.f125a) {
            this.f126c.seek(b2);
            this.f126c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f125a - b2;
        this.f126c.seek(b2);
        this.f126c.readFully(bArr, i2, i4);
        this.f126c.seek(16L);
        this.f126c.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    public synchronized void a(byte[] bArr, int i, int i2) throws IOException {
        b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        c(i2);
        boolean b2 = b();
        a aVar = new a(b2 ? 16 : b(this.f.f131b + 4 + this.f.f132c), i2);
        b(this.g, 0, i2);
        a(aVar.f131b, this.g, 0, 4);
        a(aVar.f131b + 4, bArr, i, i2);
        a(this.f125a, this.d + 1, b2 ? aVar.f131b : this.e.f131b, aVar.f131b);
        this.f = aVar;
        this.d++;
        if (b2) {
            this.e = this.f;
        }
    }

    public int a() {
        if (this.d == 0) {
            return 16;
        }
        if (this.f.f131b >= this.e.f131b) {
            return (this.f.f131b - this.e.f131b) + 4 + this.f.f132c + 16;
        }
        return (((this.f.f131b + 4) + this.f.f132c) + this.f125a) - this.e.f131b;
    }

    private int f() {
        return this.f125a - a();
    }

    public synchronized boolean b() {
        return this.d == 0;
    }

    private void c(int i) throws IOException {
        int i2 = i + 4;
        int f = f();
        if (f < i2) {
            int i3 = this.f125a;
            do {
                f += i3;
                i3 <<= 1;
            } while (f < i2);
            d(i3);
            int b2 = b(this.f.f131b + 4 + this.f.f132c);
            if (b2 < this.e.f131b) {
                FileChannel channel = this.f126c.getChannel();
                channel.position(this.f125a);
                int i4 = b2 - 4;
                if (channel.transferTo(16L, i4, channel) != i4) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f.f131b < this.e.f131b) {
                int i5 = (this.f125a + this.f.f131b) - 16;
                a(i3, this.d, this.e.f131b, i5);
                this.f = new a(i5, this.f.f132c);
            } else {
                a(i3, this.d, this.e.f131b, this.f.f131b);
            }
            this.f125a = i3;
        }
    }

    private void d(int i) throws IOException {
        this.f126c.setLength(i);
        this.f126c.getChannel().force(true);
    }

    public synchronized void a(c cVar) throws IOException {
        int i = this.e.f131b;
        for (int i2 = 0; i2 < this.d; i2++) {
            a a2 = a(i);
            cVar.read(new b(a2), a2.f132c);
            i = b(a2.f132c + a2.f131b + 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T b(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QueueFile.java */
    /* loaded from: classes.dex */
    public final class b extends InputStream {

        /* renamed from: b  reason: collision with root package name */
        private int f134b;

        /* renamed from: c  reason: collision with root package name */
        private int f135c;

        private b(a aVar) {
            this.f134b = q.this.b(aVar.f131b + 4);
            this.f135c = aVar.f132c;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            q.b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (this.f135c > 0) {
                if (i2 > this.f135c) {
                    i2 = this.f135c;
                }
                q.this.b(this.f134b, bArr, i, i2);
                this.f134b = q.this.b(this.f134b + i2);
                this.f135c -= i2;
                return i2;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f135c != 0) {
                q.this.f126c.seek(this.f134b);
                int read = q.this.f126c.read();
                this.f134b = q.this.b(this.f134b + 1);
                this.f135c--;
                return read;
            }
            return -1;
        }
    }

    public synchronized void c() throws IOException {
        if (b()) {
            throw new NoSuchElementException();
        }
        if (this.d == 1) {
            d();
        } else {
            int b2 = b(this.e.f131b + 4 + this.e.f132c);
            b(b2, this.g, 0, 4);
            int a2 = a(this.g, 0);
            a(this.f125a, this.d - 1, b2, this.f.f131b);
            this.d--;
            this.e = new a(b2, a2);
        }
    }

    public synchronized void d() throws IOException {
        a(4096, 0, 0, 0);
        this.d = 0;
        this.e = a.f130a;
        this.f = a.f130a;
        if (this.f125a > 4096) {
            d(4096);
        }
        this.f125a = 4096;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f126c.close();
    }

    public boolean a(int i, int i2) {
        return (a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append('[');
        sb.append("fileLength=").append(this.f125a);
        sb.append(", size=").append(this.d);
        sb.append(", first=").append(this.e);
        sb.append(", last=").append(this.f);
        sb.append(", element lengths=[");
        try {
            a(new c() { // from class: b.a.a.a.a.b.q.1

                /* renamed from: a  reason: collision with root package name */
                boolean f127a = true;

                @Override // b.a.a.a.a.b.q.c
                public void read(InputStream inputStream, int i) throws IOException {
                    if (this.f127a) {
                        this.f127a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            f124b.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueueFile.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final a f130a = new a(0, 0);

        /* renamed from: b  reason: collision with root package name */
        final int f131b;

        /* renamed from: c  reason: collision with root package name */
        final int f132c;

        a(int i, int i2) {
            this.f131b = i;
            this.f132c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f131b + ", length = " + this.f132c + "]";
        }
    }
}

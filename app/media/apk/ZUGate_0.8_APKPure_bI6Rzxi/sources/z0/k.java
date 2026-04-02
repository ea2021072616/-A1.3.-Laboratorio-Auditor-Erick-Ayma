package z0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f5795a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5796b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5797c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5798d;

    public k(int i5, int i6, long j5, long j6) {
        this.f5795a = i5;
        this.f5796b = i6;
        this.f5797c = j5;
        this.f5798d = j6;
    }

    public static k a(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            k kVar = new k(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return kVar;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void b(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f5795a);
            dataOutputStream.writeInt(this.f5796b);
            dataOutputStream.writeLong(this.f5797c);
            dataOutputStream.writeLong(this.f5798d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f5796b == kVar.f5796b && this.f5797c == kVar.f5797c && this.f5795a == kVar.f5795a && this.f5798d == kVar.f5798d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f5796b), Long.valueOf(this.f5797c), Integer.valueOf(this.f5795a), Long.valueOf(this.f5798d));
    }
}

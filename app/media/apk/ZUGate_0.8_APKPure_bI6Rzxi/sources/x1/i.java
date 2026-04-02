package x1;

import android.util.Base64;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f5461a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f5462b;

    /* renamed from: c  reason: collision with root package name */
    public final u1.c f5463c;

    public i(String str, byte[] bArr, u1.c cVar) {
        this.f5461a = str;
        this.f5462b = bArr;
        this.f5463c = cVar;
    }

    public static d.e a() {
        d.e eVar = new d.e(8);
        eVar.p(u1.c.DEFAULT);
        return eVar;
    }

    /* renamed from: b */
    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = this.f5461a;
        objArr[1] = this.f5463c;
        byte[] bArr = this.f5462b;
        objArr[2] = bArr == null ? "" : Base64.encodeToString(bArr, 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return this.f5461a.equals(iVar.f5461a) && Arrays.equals(this.f5462b, iVar.f5462b) && this.f5463c.equals(iVar.f5463c);
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f5461a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5462b)) * 1000003) ^ this.f5463c.hashCode();
    }
}

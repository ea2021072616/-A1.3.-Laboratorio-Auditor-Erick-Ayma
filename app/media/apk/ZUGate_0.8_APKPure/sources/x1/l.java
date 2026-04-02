package x1;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final u1.b f5470a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f5471b;

    public l(u1.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f5470a = bVar;
        this.f5471b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f5470a.equals(lVar.f5470a)) {
                return Arrays.equals(this.f5471b, lVar.f5471b);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f5470a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5471b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f5470a + ", bytes=[...]}";
    }
}

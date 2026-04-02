package b.a.a.a.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvertisingInfo.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f86a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f87b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, boolean z) {
        this.f86a = str;
        this.f87b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f87b != bVar.f87b) {
            return false;
        }
        if (this.f86a != null) {
            if (this.f86a.equals(bVar.f86a)) {
                return true;
            }
        } else if (bVar.f86a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f86a != null ? this.f86a.hashCode() : 0) * 31) + (this.f87b ? 1 : 0);
    }
}

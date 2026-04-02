package w1;
/* loaded from: classes.dex */
public final class o extends w {

    /* renamed from: a  reason: collision with root package name */
    public final v f5376a;

    /* renamed from: b  reason: collision with root package name */
    public final u f5377b;

    public o(v vVar, u uVar) {
        this.f5376a = vVar;
        this.f5377b = uVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            v vVar = this.f5376a;
            if (vVar != null ? vVar.equals(((o) wVar).f5376a) : ((o) wVar).f5376a == null) {
                u uVar = this.f5377b;
                if (uVar == null) {
                    if (((o) wVar).f5377b == null) {
                        return true;
                    }
                } else if (uVar.equals(((o) wVar).f5377b)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        v vVar = this.f5376a;
        int hashCode = ((vVar == null ? 0 : vVar.hashCode()) ^ 1000003) * 1000003;
        u uVar = this.f5377b;
        return (uVar != null ? uVar.hashCode() : 0) ^ hashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f5376a + ", mobileSubtype=" + this.f5377b + "}";
    }
}

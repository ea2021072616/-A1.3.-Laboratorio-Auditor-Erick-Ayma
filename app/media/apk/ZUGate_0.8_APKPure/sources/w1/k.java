package w1;
/* loaded from: classes.dex */
public final class k extends r {

    /* renamed from: a  reason: collision with root package name */
    public final q f5359a;

    /* renamed from: b  reason: collision with root package name */
    public final a f5360b;

    public k(q qVar, a aVar) {
        this.f5359a = qVar;
        this.f5360b = aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            q qVar = this.f5359a;
            if (qVar != null ? qVar.equals(((k) rVar).f5359a) : ((k) rVar).f5359a == null) {
                a aVar = this.f5360b;
                if (aVar == null) {
                    if (((k) rVar).f5360b == null) {
                        return true;
                    }
                } else if (aVar.equals(((k) rVar).f5360b)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        q qVar = this.f5359a;
        int hashCode = ((qVar == null ? 0 : qVar.hashCode()) ^ 1000003) * 1000003;
        a aVar = this.f5360b;
        return (aVar != null ? aVar.hashCode() : 0) ^ hashCode;
    }

    public final String toString() {
        return "ClientInfo{clientType=" + this.f5359a + ", androidClientInfo=" + this.f5360b + "}";
    }
}

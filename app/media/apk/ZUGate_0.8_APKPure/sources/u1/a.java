package u1;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5130a;

    public a(Object obj) {
        this.f5130a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            aVar.getClass();
            if (this.f5130a.equals(aVar.f5130a)) {
                Object obj2 = c.DEFAULT;
                if (obj2.equals(obj2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f5130a.hashCode() ^ (-721379959)) * 1000003) ^ c.DEFAULT.hashCode();
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f5130a + ", priority=" + c.DEFAULT + "}";
    }
}

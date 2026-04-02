package d2;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f2513a;

    /* renamed from: b  reason: collision with root package name */
    public final x1.i f2514b;

    /* renamed from: c  reason: collision with root package name */
    public final x1.h f2515c;

    public b(long j5, x1.i iVar, x1.h hVar) {
        this.f2513a = j5;
        if (iVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f2514b = iVar;
        this.f2515c = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f2513a == bVar.f2513a && this.f2514b.equals(bVar.f2514b) && this.f2515c.equals(bVar.f2515c);
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f2513a;
        return ((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f2514b.hashCode()) * 1000003) ^ this.f2515c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f2513a + ", transportContext=" + this.f2514b + ", event=" + this.f2515c + "}";
    }
}

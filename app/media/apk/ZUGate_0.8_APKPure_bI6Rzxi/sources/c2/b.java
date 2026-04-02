package c2;

import java.util.Map;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final f2.a f1714a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f1715b;

    public b(f2.a aVar, Map map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f1714a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f1715b = map;
    }

    public final long a(u1.c cVar, long j5, int i5) {
        int i6;
        long a5 = j5 - ((f2.b) this.f1714a).a();
        c cVar2 = (c) this.f1715b.get(cVar);
        long j6 = cVar2.f1716a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i5 - 1) * j6 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j6 > 1 ? j6 : 2L) * i6))), a5), cVar2.f1717b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f1714a.equals(bVar.f1714a) && this.f1715b.equals(bVar.f1715b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f1714a.hashCode() ^ 1000003) * 1000003) ^ this.f1715b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f1714a + ", values=" + this.f1715b + "}";
    }
}

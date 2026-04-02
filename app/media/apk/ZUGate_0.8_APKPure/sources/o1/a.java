package o1;

import m1.h;
import t1.f;
/* loaded from: classes.dex */
public final class a extends b {
    public a(p1.a aVar) {
        super((k1.a) aVar);
    }

    @Override // o1.b, o1.d
    public final c a(float f5, float f6) {
        c a5 = super.a(f5, f6);
        if (a5 == null) {
            return null;
        }
        p1.b bVar = this.f4092a;
        f f7 = ((k1.a) bVar).f(1);
        f7.getClass();
        t1.b b5 = t1.b.b(0.0d, 0.0d);
        f7.a(f5, f6, b5);
        m1.b bVar2 = (m1.b) ((p1.a) bVar).getBarData().c(a5.f4098e);
        if (!(bVar2.f3928u > 1)) {
            t1.b.c(b5);
            return a5;
        }
        int d5 = bVar2.d((float) b5.f4985b, (float) b5.f4986c, 3);
        if (((m1.c) (d5 > -1 ? (h) bVar2.o.get(d5) : null)) == null) {
            return null;
        }
        return a5;
    }

    @Override // o1.b
    public final m1.d b() {
        return ((p1.a) this.f4092a).getBarData();
    }

    @Override // o1.b
    public final float c(float f5, float f6, float f7, float f8) {
        return Math.abs(f5 - f7);
    }
}

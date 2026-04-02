package e4;

import l2.i;
/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public final c4.f f2704c;

    /* renamed from: d  reason: collision with root package name */
    public transient c4.b f2705d;

    public c(c4.b bVar, c4.f fVar) {
        super(bVar);
        this.f2704c = fVar;
    }

    @Override // c4.b
    public final c4.f a() {
        c4.f fVar = this.f2704c;
        e.c(fVar);
        return fVar;
    }

    @Override // e4.a
    public final void h() {
        c4.b bVar = this.f2705d;
        if (bVar != null && bVar != this) {
            c4.f fVar = this.f2704c;
            e.c(fVar);
            int i5 = c4.c.f1789a;
            c4.d j5 = fVar.j(i.f3858l);
            e.c(j5);
            c4.c cVar = (c4.c) j5;
            r4.a aVar = (r4.a) bVar;
        }
        this.f2705d = b.f2703b;
    }
}

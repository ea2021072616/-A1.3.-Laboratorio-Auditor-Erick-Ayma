package h1;

import java.util.Set;
/* loaded from: classes.dex */
public final class c implements l2.b {

    /* renamed from: h  reason: collision with root package name */
    public final j2.b f3263h;

    /* renamed from: i  reason: collision with root package name */
    public final k2.a f3264i;

    /* renamed from: l  reason: collision with root package name */
    public final Object f3267l;

    /* renamed from: j  reason: collision with root package name */
    public Object f3265j = null;

    /* renamed from: k  reason: collision with root package name */
    public Set f3266k = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3262g = false;

    public c(k2.d dVar, l2.f fVar, k2.a aVar) {
        this.f3267l = dVar;
        this.f3263h = fVar;
        this.f3264i = aVar;
    }

    @Override // l2.b
    public final void a(i2.a aVar) {
        ((k2.d) this.f3267l).f3589m.post(new androidx.appcompat.widget.k(this, 10, aVar));
    }

    public final void b(i2.a aVar) {
        k2.o oVar = (k2.o) ((k2.d) this.f3267l).f3586j.get(this.f3264i);
        if (oVar != null) {
            oVar.p(aVar);
        }
    }
}

package x1;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class p implements z1.b {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5478g;

    /* renamed from: h  reason: collision with root package name */
    public final z3.a f5479h;

    /* renamed from: i  reason: collision with root package name */
    public final z3.a f5480i;

    /* renamed from: j  reason: collision with root package name */
    public final z3.a f5481j;

    /* renamed from: k  reason: collision with root package name */
    public final z3.a f5482k;

    /* renamed from: l  reason: collision with root package name */
    public final z3.a f5483l;

    public /* synthetic */ p(z3.a aVar, z3.a aVar2, z1.b bVar, z3.a aVar3, z3.a aVar4, int i5) {
        this.f5478g = i5;
        this.f5479h = aVar;
        this.f5480i = aVar2;
        this.f5481j = bVar;
        this.f5482k = aVar3;
        this.f5483l = aVar4;
    }

    @Override // z3.a
    public final Object get() {
        int i5 = this.f5478g;
        z3.a aVar = this.f5483l;
        z3.a aVar2 = this.f5482k;
        z3.a aVar3 = this.f5481j;
        z3.a aVar4 = this.f5480i;
        z3.a aVar5 = this.f5479h;
        switch (i5) {
            case 0:
                return new o((f2.a) aVar5.get(), (f2.a) aVar4.get(), (b2.c) aVar3.get(), (c2.k) aVar2.get(), (c2.m) aVar.get());
            case 1:
                return new b2.b((Executor) aVar5.get(), (y1.f) aVar4.get(), (c2.n) aVar3.get(), (d2.d) aVar2.get(), (e2.c) aVar.get());
            default:
                f2.a aVar6 = (f2.a) aVar5.get();
                f2.a aVar7 = (f2.a) aVar4.get();
                Object obj = aVar3.get();
                return new d2.k(aVar6, aVar7, (d2.a) obj, (d2.n) aVar2.get(), this.f5483l);
        }
    }
}

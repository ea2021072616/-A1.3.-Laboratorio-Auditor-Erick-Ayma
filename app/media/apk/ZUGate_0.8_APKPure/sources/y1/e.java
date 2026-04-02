package y1;

import android.content.Context;
import d2.n;
/* loaded from: classes.dex */
public final class e implements z1.b {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5668g;

    /* renamed from: h  reason: collision with root package name */
    public final z3.a f5669h;

    /* renamed from: i  reason: collision with root package name */
    public final z3.a f5670i;

    /* renamed from: j  reason: collision with root package name */
    public final z3.a f5671j;

    public /* synthetic */ e(z3.a aVar, z0.d dVar, z0.d dVar2, int i5) {
        this.f5668g = i5;
        this.f5669h = aVar;
        this.f5670i = dVar;
        this.f5671j = dVar2;
    }

    @Override // z3.a
    public final Object get() {
        int i5 = this.f5668g;
        z3.a aVar = this.f5671j;
        z3.a aVar2 = this.f5670i;
        z3.a aVar3 = this.f5669h;
        switch (i5) {
            case 0:
                return new d((Context) aVar3.get(), (f2.a) aVar2.get(), (f2.a) aVar.get());
            default:
                return new n(((Integer) aVar.get()).intValue(), (Context) aVar3.get(), (String) aVar2.get());
        }
    }
}

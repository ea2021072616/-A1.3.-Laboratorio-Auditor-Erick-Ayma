package e1;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class j extends s {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f2610a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2611b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f2612c = null;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2613d = null;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f2614e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2615f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f2616g;

    public j(l lVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f2616g = lVar;
        this.f2610a = obj;
        this.f2611b = arrayList;
        this.f2614e = obj2;
        this.f2615f = arrayList2;
    }

    @Override // e1.s, e1.p
    public final void a(r rVar) {
        l lVar = this.f2616g;
        Object obj = this.f2610a;
        if (obj != null) {
            lVar.s(obj, this.f2611b, null);
        }
        Object obj2 = this.f2612c;
        if (obj2 != null) {
            lVar.s(obj2, this.f2613d, null);
        }
        Object obj3 = this.f2614e;
        if (obj3 != null) {
            lVar.s(obj3, this.f2615f, null);
        }
    }

    @Override // e1.p
    public final void f(r rVar) {
        rVar.z(this);
    }
}

package e1;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class t extends s {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2673a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2674b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f2675c;

    public /* synthetic */ t(Object obj, int i5, Object obj2) {
        this.f2673a = i5;
        this.f2675c = obj;
        this.f2674b = obj2;
    }

    @Override // e1.p
    public final void f(r rVar) {
        int i5 = this.f2673a;
        Object obj = this.f2674b;
        switch (i5) {
            case 0:
                ((ArrayList) ((l.b) obj).getOrDefault(((u) this.f2675c).f2677h, null)).remove(rVar);
                rVar.z(this);
                return;
            default:
                ((r) obj).C();
                rVar.z(this);
                return;
        }
    }
}

package androidx.appcompat.widget;

import android.view.View;
/* loaded from: classes.dex */
public final class l extends e2 {

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f402p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Object f403q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ View f404r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(View view, View view2, Object obj, int i5) {
        super(view2);
        this.f402p = i5;
        this.f404r = view;
        this.f403q = obj;
    }

    @Override // androidx.appcompat.widget.e2
    public final h.e0 b() {
        switch (this.f402p) {
            case 0:
                i iVar = ((m) this.f404r).f411j.f431y;
                if (iVar == null) {
                    return null;
                }
                return iVar.a();
            default:
                return (u0) this.f403q;
        }
    }

    @Override // androidx.appcompat.widget.e2
    public final boolean c() {
        int i5 = this.f402p;
        View view = this.f404r;
        switch (i5) {
            case 0:
                ((m) view).f411j.l();
                return true;
            default:
                x0 x0Var = (x0) view;
                if (!x0Var.getInternalPopup().a()) {
                    x0Var.f581l.d(x0Var.getTextDirection(), x0Var.getTextAlignment());
                }
                return true;
        }
    }

    @Override // androidx.appcompat.widget.e2
    public final boolean d() {
        switch (this.f402p) {
            case 0:
                n nVar = ((m) this.f404r).f411j;
                if (nVar.A != null) {
                    return false;
                }
                nVar.f();
                return true;
            default:
                super.d();
                return true;
        }
    }
}

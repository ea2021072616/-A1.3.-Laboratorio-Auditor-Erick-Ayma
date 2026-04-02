package e1;

import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class c extends s {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2588a = false;

    /* renamed from: b  reason: collision with root package name */
    public final ViewGroup f2589b;

    public c(ViewGroup viewGroup) {
        this.f2589b = viewGroup;
    }

    @Override // e1.s, e1.p
    public final void c() {
        com.google.android.gms.internal.play_billing.i0.S(this.f2589b, false);
    }

    @Override // e1.s, e1.p
    public final void d(r rVar) {
        com.google.android.gms.internal.play_billing.i0.S(this.f2589b, false);
        this.f2588a = true;
    }

    @Override // e1.s, e1.p
    public final void e() {
        com.google.android.gms.internal.play_billing.i0.S(this.f2589b, true);
    }

    @Override // e1.p
    public final void f(r rVar) {
        if (!this.f2588a) {
            com.google.android.gms.internal.play_billing.i0.S(this.f2589b, false);
        }
        rVar.z(this);
    }
}

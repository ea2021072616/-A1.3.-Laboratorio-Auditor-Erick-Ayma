package d;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class p0 extends androidx.activity.p implements r {

    /* renamed from: j  reason: collision with root package name */
    public n0 f2446j;

    /* renamed from: k  reason: collision with root package name */
    public final o0 f2447k;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r2v2, types: [d.o0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p0(android.content.Context r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 2130968987(0x7f04019b, float:1.7546643E38)
            if (r6 != 0) goto L15
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r5.getTheme()
            r3.resolveAttribute(r1, r2, r0)
            int r2 = r2.resourceId
            goto L16
        L15:
            r2 = r6
        L16:
            r4.<init>(r5, r2)
            d.o0 r2 = new d.o0
            r2.<init>()
            r4.f2447k = r2
            d.y r2 = r4.c()
            if (r6 != 0) goto L34
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            r5.resolveAttribute(r1, r6, r0)
            int r6 = r6.resourceId
        L34:
            r5 = r2
            d.n0 r5 = (d.n0) r5
            r5.Z = r6
            r2.g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.p0.<init>(android.content.Context, int):void");
    }

    @Override // androidx.activity.p, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c().a(view, layoutParams);
    }

    public final y c() {
        if (this.f2446j == null) {
            w wVar = y.f2482g;
            this.f2446j = new n0(getContext(), getWindow(), this, this);
        }
        return this.f2446j;
    }

    public final void d() {
        b4.j.S(getWindow().getDecorView(), this);
        b4.j.T(getWindow().getDecorView(), this);
        p2.a.S(getWindow().getDecorView(), this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        c().h();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return p2.a.t(this.f2447k, getWindow().getDecorView(), this, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i5) {
        n0 n0Var = (n0) c();
        n0Var.y();
        return n0Var.f2433r.findViewById(i5);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        c().e();
    }

    @Override // androidx.activity.p, android.app.Dialog
    public void onCreate(Bundle bundle) {
        c().b();
        super.onCreate(bundle);
        c().g();
    }

    @Override // androidx.activity.p, android.app.Dialog
    public final void onStop() {
        super.onStop();
        n0 n0Var = (n0) c();
        n0Var.D();
        b bVar = n0Var.f2436u;
        if (bVar != null) {
            bVar.n(false);
        }
    }

    @Override // d.r
    public final void onSupportActionModeFinished(g.b bVar) {
    }

    @Override // d.r
    public final void onSupportActionModeStarted(g.b bVar) {
    }

    @Override // d.r
    public final g.b onWindowStartingSupportActionMode(g.a aVar) {
        return null;
    }

    @Override // androidx.activity.p, android.app.Dialog
    public void setContentView(int i5) {
        d();
        c().k(i5);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        c().n(charSequence);
    }

    @Override // androidx.activity.p, android.app.Dialog
    public void setContentView(View view) {
        d();
        c().l(view);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i5) {
        super.setTitle(i5);
        c().n(getContext().getString(i5));
    }

    @Override // androidx.activity.p, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        c().m(view, layoutParams);
    }
}

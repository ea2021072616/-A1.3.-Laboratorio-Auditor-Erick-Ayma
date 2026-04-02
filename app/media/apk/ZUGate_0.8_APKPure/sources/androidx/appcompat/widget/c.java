package androidx.appcompat.widget;

import android.view.View;
import android.view.Window;
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f298g = 0;

    /* renamed from: h  reason: collision with root package name */
    public final Object f299h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f300i;

    public c(ActionBarContextView actionBarContextView, g.b bVar) {
        this.f300i = actionBarContextView;
        this.f299h = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i5 = this.f298g;
        Object obj = this.f299h;
        switch (i5) {
            case 0:
                ((g.b) obj).a();
                return;
            default:
                p3 p3Var = (p3) this.f300i;
                Window.Callback callback = p3Var.f496k;
                if (callback == null || !p3Var.f497l) {
                    return;
                }
                callback.onMenuItemSelected(0, (h.a) obj);
                return;
        }
    }

    public c(p3 p3Var) {
        this.f300i = p3Var;
        this.f299h = new h.a(p3Var.f486a.getContext(), p3Var.f493h);
    }
}

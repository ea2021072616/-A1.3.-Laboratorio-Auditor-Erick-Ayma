package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
public final class t0 implements PopupWindow.OnDismissListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f532g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ u0 f533h;

    public t0(u0 u0Var, h.e eVar) {
        this.f533h = u0Var;
        this.f532g = eVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f533h.M.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f532g);
        }
    }
}

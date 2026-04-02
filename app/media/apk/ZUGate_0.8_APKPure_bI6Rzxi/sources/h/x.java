package h;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
public final class x implements PopupWindow.OnDismissListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ y f3077g;

    public x(y yVar) {
        this.f3077g = yVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f3077g.c();
    }
}

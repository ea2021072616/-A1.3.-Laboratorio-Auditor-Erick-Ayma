package h;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.t2;
import androidx.appcompat.widget.u0;
import androidx.appcompat.widget.x0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2964g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f2965h;

    public /* synthetic */ e(int i5, Object obj) {
        this.f2964g = i5;
        this.f2965h = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int i5 = this.f2964g;
        boolean z4 = false;
        Object obj = this.f2965h;
        switch (i5) {
            case 0:
                i iVar = (i) obj;
                if (iVar.a()) {
                    ArrayList arrayList = iVar.o;
                    if (arrayList.size() <= 0 || ((h) arrayList.get(0)).f2990a.E) {
                        return;
                    }
                    View view = iVar.f3006v;
                    if (view == null || !view.isShown()) {
                        iVar.dismiss();
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((h) it.next()).f2990a.f();
                    }
                    return;
                }
                return;
            case 1:
                f0 f0Var = (f0) obj;
                if (f0Var.a()) {
                    t2 t2Var = f0Var.o;
                    if (t2Var.E) {
                        return;
                    }
                    View view2 = f0Var.f2979t;
                    if (view2 == null || !view2.isShown()) {
                        f0Var.dismiss();
                        return;
                    } else {
                        t2Var.f();
                        return;
                    }
                }
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                x0 x0Var = (x0) obj;
                if (!x0Var.getInternalPopup().a()) {
                    x0Var.f581l.d(x0Var.getTextDirection(), x0Var.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = x0Var.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                    return;
                }
                return;
            default:
                u0 u0Var = (u0) obj;
                x0 x0Var2 = u0Var.M;
                if (x0Var2.isAttachedToWindow() && x0Var2.getGlobalVisibleRect(u0Var.K)) {
                    z4 = true;
                }
                if (!z4) {
                    u0Var.dismiss();
                    return;
                }
                u0Var.s();
                u0Var.f();
                return;
        }
    }
}

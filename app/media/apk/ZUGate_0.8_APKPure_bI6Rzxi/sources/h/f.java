package h;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class f implements View.OnAttachStateChangeListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2966g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f2967h;

    public /* synthetic */ f(int i5, Object obj) {
        this.f2966g = i5;
        this.f2967h = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        AccessibilityManager accessibilityManager;
        switch (this.f2966g) {
            case 0:
            case 1:
                return;
            default:
                s3.n nVar = (s3.n) this.f2967h;
                int i5 = s3.n.C;
                if (nVar.A == null || (accessibilityManager = nVar.f4914z) == null) {
                    return;
                }
                WeakHashMap weakHashMap = z0.f3233a;
                if (nVar.isAttachedToWindow()) {
                    accessibilityManager.addTouchExplorationStateChangeListener(new i0.b(nVar.A));
                    return;
                }
                return;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        int i5 = this.f2966g;
        Object obj = this.f2967h;
        switch (i5) {
            case 0:
                i iVar = (i) obj;
                ViewTreeObserver viewTreeObserver = iVar.E;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        iVar.E = view.getViewTreeObserver();
                    }
                    iVar.E.removeGlobalOnLayoutListener(iVar.f3000p);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            case 1:
                f0 f0Var = (f0) obj;
                ViewTreeObserver viewTreeObserver2 = f0Var.f2981v;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        f0Var.f2981v = view.getViewTreeObserver();
                    }
                    f0Var.f2981v.removeGlobalOnLayoutListener(f0Var.f2975p);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            default:
                s3.n nVar = (s3.n) obj;
                int i6 = s3.n.C;
                w.g gVar = nVar.A;
                if (gVar == null || (accessibilityManager = nVar.f4914z) == null) {
                    return;
                }
                accessibilityManager.removeTouchExplorationStateChangeListener(new i0.b(gVar));
                return;
        }
    }
}

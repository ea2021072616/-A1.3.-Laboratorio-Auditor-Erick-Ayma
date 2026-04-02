package h0;

import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
public final class a0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: g  reason: collision with root package name */
    public final View f3091g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver f3092h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f3093i;

    public a0(View view, Runnable runnable) {
        this.f3091g = view;
        this.f3092h = view.getViewTreeObserver();
        this.f3093i = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        a0 a0Var = new a0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(a0Var);
        view.addOnAttachStateChangeListener(a0Var);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean isAlive = this.f3092h.isAlive();
        View view = this.f3091g;
        if (isAlive) {
            this.f3092h.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f3093i.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f3092h = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean isAlive = this.f3092h.isAlive();
        View view2 = this.f3091g;
        if (isAlive) {
            this.f3092h.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}

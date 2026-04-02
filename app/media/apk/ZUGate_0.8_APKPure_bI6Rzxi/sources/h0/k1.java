package h0;

import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class k1 {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f3165a;

    public k1(View view) {
        this.f3165a = new WeakReference(view);
    }

    public final void a(float f5) {
        View view = (View) this.f3165a.get();
        if (view != null) {
            view.animate().alpha(f5);
        }
    }

    public final void b() {
        View view = (View) this.f3165a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j5) {
        View view = (View) this.f3165a.get();
        if (view != null) {
            view.animate().setDuration(j5);
        }
    }

    public final void d(l1 l1Var) {
        View view = (View) this.f3165a.get();
        if (view != null) {
            if (l1Var != null) {
                view.animate().setListener(new j1(this, l1Var, view, 0));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f5) {
        View view = (View) this.f3165a.get();
        if (view != null) {
            view.animate().translationY(f5);
        }
    }
}

package u;

import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public abstract class a {
    public a(int i5) {
    }

    public boolean e(View view) {
        return false;
    }

    public void f(View view) {
    }

    public void g(d dVar) {
    }

    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    public void i() {
    }

    public boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    public boolean k(CoordinatorLayout coordinatorLayout, View view, int i5) {
        return false;
    }

    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i5, int i6, int i7) {
        return false;
    }

    public boolean m(View view) {
        return false;
    }

    public void n(View view, View view2, int i5, int[] iArr, int i6) {
    }

    public void o(CoordinatorLayout coordinatorLayout, View view, int i5, int i6, int i7, int[] iArr) {
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
    }

    public void p(CoordinatorLayout coordinatorLayout, View view) {
    }

    public void q(View view, Parcelable parcelable) {
    }

    public Parcelable r(View view) {
        return View.BaseSavedState.EMPTY_STATE;
    }

    public boolean s(View view, int i5, int i6) {
        return false;
    }

    public void t(View view, View view2, int i5) {
    }

    public boolean u(View view, MotionEvent motionEvent) {
        return false;
    }
}

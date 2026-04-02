package d;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;
/* loaded from: classes.dex */
public final class l0 extends ContentFrameLayout {
    public final /* synthetic */ n0 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(n0 n0Var, g.d dVar) {
        super(dVar, null);
        this.o = n0Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.o.w(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x5 = (int) motionEvent.getX();
            int y5 = (int) motionEvent.getY();
            if (x5 < -5 || y5 < -5 || x5 > getWidth() + 5 || y5 > getHeight() + 5) {
                n0 n0Var = this.o;
                n0Var.u(n0Var.B(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i5) {
        setBackgroundDrawable(p2.a.x(getContext(), i5));
    }
}

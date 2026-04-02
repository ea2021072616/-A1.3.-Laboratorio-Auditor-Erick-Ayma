package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public final class n2 implements View.OnTouchListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f433g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f434h;

    public /* synthetic */ n2(int i5, Object obj) {
        this.f433g = i5;
        this.f434h = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        o2 o2Var;
        j0 j0Var;
        switch (this.f433g) {
            case 0:
                int action = motionEvent.getAction();
                int x5 = (int) motionEvent.getX();
                int y5 = (int) motionEvent.getY();
                Object obj = this.f434h;
                if (action == 0 && (j0Var = (o2Var = (o2) obj).F) != null && j0Var.isShowing() && x5 >= 0) {
                    j0 j0Var2 = o2Var.F;
                    if (x5 < j0Var2.getWidth() && y5 >= 0 && y5 < j0Var2.getHeight()) {
                        o2Var.B.postDelayed(o2Var.f466x, 250L);
                        return false;
                    }
                }
                if (action == 1) {
                    o2 o2Var2 = (o2) obj;
                    o2Var2.B.removeCallbacks(o2Var2.f466x);
                    return false;
                }
                return false;
            default:
                return true;
        }
    }
}

package g3;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: g  reason: collision with root package name */
    public final Dialog f2940g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2941h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2942i;

    /* renamed from: j  reason: collision with root package name */
    public final int f2943j;

    public a(Dialog dialog, Rect rect) {
        this.f2940g = dialog;
        this.f2941h = rect.left;
        this.f2942i = rect.top;
        this.f2943j = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.f2941h;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.f2942i;
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i5 = this.f2943j;
            obtain.setLocation((-i5) - 1, (-i5) - 1);
        }
        view.performClick();
        return this.f2940g.onTouchEvent(obtain);
    }
}

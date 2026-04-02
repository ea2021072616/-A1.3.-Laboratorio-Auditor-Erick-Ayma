package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
/* loaded from: classes.dex */
public final class d2 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f308b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e2 f309c;

    public /* synthetic */ d2(e2 e2Var, int i5) {
        this.f308b = i5;
        this.f309c = e2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f308b;
        e2 e2Var = this.f309c;
        switch (i5) {
            case 0:
                ViewParent parent = e2Var.f337j.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
                return;
            default:
                e2Var.a();
                View view = e2Var.f337j;
                if (view.isEnabled() && !view.isLongClickable() && e2Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    e2Var.f340m = true;
                    return;
                }
                return;
        }
    }
}

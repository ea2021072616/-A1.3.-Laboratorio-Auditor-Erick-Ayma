package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public abstract class e2 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: g  reason: collision with root package name */
    public final float f334g;

    /* renamed from: h  reason: collision with root package name */
    public final int f335h;

    /* renamed from: i  reason: collision with root package name */
    public final int f336i;

    /* renamed from: j  reason: collision with root package name */
    public final View f337j;

    /* renamed from: k  reason: collision with root package name */
    public d2 f338k;

    /* renamed from: l  reason: collision with root package name */
    public d2 f339l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f340m;

    /* renamed from: n  reason: collision with root package name */
    public int f341n;
    public final int[] o = new int[2];

    public e2(View view) {
        this.f337j = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f334g = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f335h = tapTimeout;
        this.f336i = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        d2 d2Var = this.f339l;
        View view = this.f337j;
        if (d2Var != null) {
            view.removeCallbacks(d2Var);
        }
        d2 d2Var2 = this.f338k;
        if (d2Var2 != null) {
            view.removeCallbacks(d2Var2);
        }
    }

    public abstract h.e0 b();

    public abstract boolean c();

    public boolean d() {
        h.e0 b5 = b();
        if (b5 == null || !b5.a()) {
            return true;
        }
        b5.dismiss();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
        if (r4 != 3) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010c  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e2.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f340m = false;
        this.f341n = -1;
        d2 d2Var = this.f338k;
        if (d2Var != null) {
            this.f337j.removeCallbacks(d2Var);
        }
    }
}

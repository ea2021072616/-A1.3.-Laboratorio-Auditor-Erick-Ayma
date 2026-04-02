package h0;

import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public final class o1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f3187b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ androidx.appcompat.widget.d0 f3188c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f3189d;

    public o1(View view, u1 u1Var, androidx.appcompat.widget.d0 d0Var, ValueAnimator valueAnimator) {
        this.f3187b = view;
        this.f3188c = d0Var;
        this.f3189d = valueAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q1.h(this.f3187b, this.f3188c);
        this.f3189d.start();
    }
}

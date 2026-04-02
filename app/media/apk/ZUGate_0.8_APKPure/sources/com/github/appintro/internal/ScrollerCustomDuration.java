package com.github.appintro.internal;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import e4.e;
/* loaded from: classes.dex */
public final class ScrollerCustomDuration extends Scroller {
    private double scrollDurationFactor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollerCustomDuration(Context context, Interpolator interpolator) {
        super(context, interpolator);
        e.f(context, "context");
        e.f(interpolator, "interpolator");
        this.scrollDurationFactor = 6.0d;
    }

    public final double getScrollDurationFactor() {
        return this.scrollDurationFactor;
    }

    public final void setScrollDurationFactor(double d5) {
        this.scrollDurationFactor = d5;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i5, int i6, int i7, int i8, int i9) {
        super.startScroll(i5, i6, i7, i8, (int) (i9 * this.scrollDurationFactor));
    }
}

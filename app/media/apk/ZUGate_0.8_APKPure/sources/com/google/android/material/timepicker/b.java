package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f2264g;

    public b(ClockFaceView clockFaceView) {
        this.f2264g = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f2264g;
        if (clockFaceView.isShown()) {
            clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
            int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f2248z.f2252j) - clockFaceView.H;
            if (height != clockFaceView.f2268x) {
                clockFaceView.f2268x = height;
                clockFaceView.m();
                int i5 = clockFaceView.f2268x;
                ClockHandView clockHandView = clockFaceView.f2248z;
                clockHandView.f2259r = i5;
                clockHandView.invalidate();
            }
            return true;
        }
        return true;
    }
}

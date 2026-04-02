package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public final class j extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TimePickerView f2276g;

    public j(TimePickerView timePickerView) {
        this.f2276g = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        int i5 = TimePickerView.f2261x;
        this.f2276g.getClass();
        return false;
    }
}

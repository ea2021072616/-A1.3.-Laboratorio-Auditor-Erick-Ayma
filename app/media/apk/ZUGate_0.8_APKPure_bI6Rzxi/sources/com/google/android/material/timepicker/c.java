package com.google.android.material.timepicker;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class c extends h0.b {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f2265d;

    public c(ClockFaceView clockFaceView) {
        this.f2265d = clockFaceView;
    }

    @Override // h0.b
    public final void d(View view, i0.j jVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f3105a;
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (intValue > 0) {
            accessibilityNodeInfo.setTraversalAfter((View) this.f2265d.D.get(intValue - 1));
        }
        accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, intValue, 1, false, view.isSelected()));
        accessibilityNodeInfo.setClickable(true);
        jVar.b(i0.e.f3362e);
    }

    @Override // h0.b
    public final boolean g(View view, int i5, Bundle bundle) {
        if (i5 == 16) {
            long uptimeMillis = SystemClock.uptimeMillis();
            ClockFaceView clockFaceView = this.f2265d;
            view.getHitRect(clockFaceView.A);
            float centerX = clockFaceView.A.centerX();
            float centerY = clockFaceView.A.centerY();
            clockFaceView.f2248z.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
            clockFaceView.f2248z.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
            return true;
        }
        return super.g(view, i5, bundle);
    }
}

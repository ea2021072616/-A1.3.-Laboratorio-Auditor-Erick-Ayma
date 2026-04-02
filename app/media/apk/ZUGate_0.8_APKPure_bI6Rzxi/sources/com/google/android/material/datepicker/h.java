package com.google.android.material.datepicker;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class h extends h0.b {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2118d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f2119e;

    public /* synthetic */ h(int i5, Object obj) {
        this.f2118d = i5;
        this.f2119e = obj;
    }

    @Override // h0.b
    public final void d(View view, i0.j jVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        int i5 = this.f2118d;
        View.AccessibilityDelegate accessibilityDelegate = this.f3105a;
        switch (i5) {
            case 0:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCollectionInfo(null);
                return;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setScrollable(false);
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                l lVar = (l) this.f2119e;
                accessibilityNodeInfo.setHintText(lVar.f2134r.getVisibility() == 0 ? lVar.getString(R.string.mtrl_picker_toggle_to_year_selection) : lVar.getString(R.string.mtrl_picker_toggle_to_day_selection));
                return;
            default:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCollectionInfo(null);
                return;
        }
    }
}

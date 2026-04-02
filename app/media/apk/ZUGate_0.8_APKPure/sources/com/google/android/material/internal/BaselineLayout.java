package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class BaselineLayout extends ViewGroup {

    /* renamed from: g  reason: collision with root package name */
    public int f2166g;

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2166g = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f2166g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i7 - i5) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                int baseline = (this.f2166g == -1 || childAt.getBaseline() == -1) ? paddingTop : (this.f2166g + paddingTop) - childAt.getBaseline();
                childAt.layout(i10, baseline, measuredWidth + i10, measuredHeight + baseline);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i5, i6);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i10 = Math.max(i10, baseline);
                    i11 = Math.max(i11, childAt.getMeasuredHeight() - baseline);
                }
                i8 = Math.max(i8, childAt.getMeasuredWidth());
                i7 = Math.max(i7, childAt.getMeasuredHeight());
                i9 = View.combineMeasuredStates(i9, childAt.getMeasuredState());
            }
        }
        if (i10 != -1) {
            i7 = Math.max(i7, Math.max(i11, getPaddingBottom()) + i10);
            this.f2166g = i10;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i8, getSuggestedMinimumWidth()), i5, i9), View.resolveSizeAndState(Math.max(i7, getSuggestedMinimumHeight()), i6, i9 << 16));
    }
}

package com.aspsine.irecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class RefreshHeaderLayout extends ViewGroup {
    public RefreshHeaderLayout(Context context) {
        this(context, null);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (getChildCount() > 0) {
            measureChildWithMargins(getChildAt(0), i, 0, View.MeasureSpec.makeMeasureSpec(0, 0), 0);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutChildren();
    }

    private void layoutChildren() {
        getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingRight();
        getPaddingBottom();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight2 = childAt.getMeasuredHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i = paddingLeft + marginLayoutParams.leftMargin;
            int i2 = (marginLayoutParams.topMargin + paddingTop) - (measuredHeight2 - measuredHeight);
            childAt.layout(i, i2, i + measuredWidth, i2 + measuredHeight2);
        }
    }
}

package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FlowLayout extends ViewGroup {
    private static final int CENTER = 0;
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final String TAG = "FlowLayout";
    private List<View> lineViews;
    protected List<List<View>> mAllViews;
    private int mGravity;
    protected List<Integer> mLineHeight;
    protected List<Integer> mLineWidth;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAllViews = new ArrayList();
        this.mLineHeight = new ArrayList();
        this.mLineWidth = new ArrayList();
        this.lineViews = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.mGravity = obtainStyledAttributes.getInt(R.styleable.TagFlowLayout_gravity, -1);
        obtainStyledAttributes.recycle();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3;
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                if (i10 == childCount - 1) {
                    int i11 = i7 + i9;
                    i5 = Math.max(i8, i6);
                    int i12 = i8;
                    i4 = i11;
                    measuredHeight = i9;
                    i3 = i12;
                } else {
                    measuredHeight = i9;
                    i3 = i8;
                    i4 = i7;
                    i5 = i6;
                }
            } else {
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                measuredHeight = marginLayoutParams.bottomMargin + childAt.getMeasuredHeight() + marginLayoutParams.topMargin;
                if (i8 + measuredWidth > (size - getPaddingLeft()) - getPaddingRight()) {
                    int max = Math.max(i6, i8);
                    i4 = i7 + i9;
                    i3 = measuredWidth;
                    i5 = max;
                } else {
                    measuredHeight = Math.max(i9, measuredHeight);
                    i3 = i8 + measuredWidth;
                    i4 = i7;
                    i5 = i6;
                }
                if (i10 == childCount - 1) {
                    i5 = Math.max(i3, i5);
                    i4 += measuredHeight;
                }
            }
            i10++;
            i6 = i5;
            i7 = i4;
            i8 = i3;
            i9 = measuredHeight;
        }
        setMeasuredDimension(mode == 1073741824 ? size : getPaddingLeft() + i6 + getPaddingRight(), mode2 == 1073741824 ? size2 : getPaddingTop() + i7 + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int measuredWidth;
        this.mAllViews.clear();
        this.mLineHeight.clear();
        this.mLineWidth.clear();
        this.lineViews.clear();
        int width = getWidth();
        int i5 = 0;
        int i6 = 0;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth2 + i5 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.mLineHeight.add(Integer.valueOf(i6));
                    this.mAllViews.add(this.lineViews);
                    this.mLineWidth.add(Integer.valueOf(i5));
                    i5 = 0;
                    i6 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.lineViews = new ArrayList();
                }
                i5 += measuredWidth2 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i6 = Math.max(i6, marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight);
                this.lineViews.add(childAt);
            }
        }
        this.mLineHeight.add(Integer.valueOf(i6));
        this.mLineWidth.add(Integer.valueOf(i5));
        this.mAllViews.add(this.lineViews);
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.mAllViews.size();
        int i8 = 0;
        int i9 = paddingTop;
        int i10 = paddingLeft2;
        while (i8 < size) {
            this.lineViews = this.mAllViews.get(i8);
            int intValue = this.mLineHeight.get(i8).intValue();
            int intValue2 = this.mLineWidth.get(i8).intValue();
            switch (this.mGravity) {
                case -1:
                    paddingLeft = getPaddingLeft();
                    break;
                case 0:
                    paddingLeft = ((width - intValue2) / 2) + getPaddingLeft();
                    break;
                case 1:
                    paddingLeft = (width - intValue2) + getPaddingLeft();
                    break;
                default:
                    paddingLeft = i10;
                    break;
            }
            int i11 = 0;
            int i12 = paddingLeft;
            while (i11 < this.lineViews.size()) {
                View view = this.lineViews.get(i11);
                if (view.getVisibility() == 8) {
                    measuredWidth = i12;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i13 = marginLayoutParams2.leftMargin + i12;
                    int i14 = marginLayoutParams2.topMargin + i9;
                    view.layout(i13, i14, view.getMeasuredWidth() + i13, view.getMeasuredHeight() + i14);
                    measuredWidth = i12 + view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
                i11++;
                i12 = measuredWidth;
            }
            i8++;
            i9 += intValue;
            i10 = i12;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }
}

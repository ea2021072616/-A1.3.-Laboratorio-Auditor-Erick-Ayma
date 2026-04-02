package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import r3.k;
/* loaded from: classes.dex */
public final class Snackbar$SnackbarLayout extends k {
    public Snackbar$SnackbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // r3.k, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        int childCount = getChildCount();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getLayoutParams().width == -1) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
            }
        }
    }

    @Override // r3.k, android.view.View
    public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
        super.setBackground(drawable);
    }

    @Override // r3.k, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // r3.k, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
        super.setBackgroundTintList(colorStateList);
    }

    @Override // r3.k, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
        super.setBackgroundTintMode(mode);
    }

    @Override // r3.k, android.view.View
    public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // r3.k, android.view.View
    public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }
}

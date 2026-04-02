package com.github.appintro.indicator;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import e4.e;
import j4.d;
/* loaded from: classes.dex */
public final class ProgressIndicatorController extends ProgressBar implements IndicatorController {
    private int selectedIndicatorColor;
    private int unselectedIndicatorColor;

    public ProgressIndicatorController(Context context) {
        this(context, null, 0, 6, null);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public int getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public int getUnselectedIndicatorColor() {
        return this.unselectedIndicatorColor;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void initialize(int i5) {
        setMax(i5);
        if (i5 == 1) {
            setVisibility(4);
        }
        selectPosition(0);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public ProgressIndicatorController newInstance(Context context) {
        e.f(context, "context");
        return this;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void selectPosition(int i5) {
        setProgress(i5 + 1);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setSelectedIndicatorColor(int i5) {
        this.selectedIndicatorColor = i5;
        getProgressDrawable().setColorFilter(i5, PorterDuff.Mode.SRC_IN);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setUnselectedIndicatorColor(int i5) {
        this.unselectedIndicatorColor = i5;
        getIndeterminateDrawable().setColorFilter(i5, PorterDuff.Mode.SRC_IN);
    }

    public ProgressIndicatorController(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ProgressIndicatorController(Context context, AttributeSet attributeSet, int i5, int i6, d dVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 16842872 : i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorController(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        e.f(context, "context");
        this.selectedIndicatorColor = 1;
        this.unselectedIndicatorColor = 1;
    }
}

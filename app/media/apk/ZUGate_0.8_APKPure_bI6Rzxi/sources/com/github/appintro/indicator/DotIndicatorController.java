package com.github.appintro.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.github.appintro.R;
import e4.e;
import x.a;
import x.b;
/* loaded from: classes.dex */
public final class DotIndicatorController extends LinearLayout implements IndicatorController {
    private int currentPosition;
    private int selectedIndicatorColor;
    private int slideCount;
    private int unselectedIndicatorColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotIndicatorController(Context context) {
        super(context);
        e.f(context, "context");
        this.selectedIndicatorColor = b.a(context, R.color.appintro_default_selected_color);
        this.unselectedIndicatorColor = b.a(context, R.color.appintro_default_unselected_color);
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
        this.slideCount = i5;
        for (int i6 = 0; i6 < i5; i6++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(a.b(getContext(), R.drawable.ic_appintro_indicator));
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i5 == 1) {
                imageView.setVisibility(4);
            }
            addView(imageView, layoutParams);
        }
        selectPosition(0);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public View newInstance(Context context) {
        e.f(context, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 16;
        setLayoutParams(layoutParams);
        setOrientation(0);
        setGravity(17);
        return this;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void selectPosition(int i5) {
        this.currentPosition = i5;
        int i6 = this.slideCount;
        int i7 = 0;
        while (i7 < i6) {
            int selectedIndicatorColor = i7 == i5 ? getSelectedIndicatorColor() : getUnselectedIndicatorColor();
            View childAt = getChildAt(i7);
            if (childAt == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            a0.a.g(((ImageView) childAt).getDrawable(), selectedIndicatorColor);
            i7++;
        }
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setSelectedIndicatorColor(int i5) {
        this.selectedIndicatorColor = i5;
        selectPosition(this.currentPosition);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setUnselectedIndicatorColor(int i5) {
        this.unselectedIndicatorColor = i5;
        selectPosition(this.currentPosition);
    }
}

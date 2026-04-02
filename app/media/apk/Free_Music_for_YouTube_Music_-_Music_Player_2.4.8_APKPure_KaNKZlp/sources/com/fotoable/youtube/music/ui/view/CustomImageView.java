package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class CustomImageView extends ImageView {
    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}

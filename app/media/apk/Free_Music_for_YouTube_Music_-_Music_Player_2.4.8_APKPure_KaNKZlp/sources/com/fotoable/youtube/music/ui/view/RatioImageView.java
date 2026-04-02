package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class RatioImageView extends ImageView {
    private static final float DEFAULT_ASPECT_RATIO = 1.91f;
    private float aspectRatio;

    public RatioImageView(Context context) {
        this(context, null);
    }

    public RatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aspectRatio = DEFAULT_ASPECT_RATIO;
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) / this.aspectRatio), 1073741824));
    }

    public void setAspectRatio(float f) {
        this.aspectRatio = f;
    }
}

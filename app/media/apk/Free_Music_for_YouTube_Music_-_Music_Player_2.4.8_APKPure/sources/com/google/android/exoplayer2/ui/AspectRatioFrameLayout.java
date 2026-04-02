package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.R;
/* loaded from: classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    private static final float MAX_ASPECT_RATIO_DEFORMATION_FRACTION = 0.01f;
    public static final int RESIZE_MODE_FIT = 0;
    public static final int RESIZE_MODE_FIXED_HEIGHT = 2;
    public static final int RESIZE_MODE_FIXED_WIDTH = 1;
    private int resizeMode;
    private float videoAspectRatio;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.resizeMode = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.resizeMode = obtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setAspectRatio(float f) {
        if (this.videoAspectRatio != f) {
            this.videoAspectRatio = f;
            requestLayout();
        }
    }

    public void setResizeMode(int i) {
        if (this.resizeMode != i) {
            this.resizeMode = i;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.videoAspectRatio != 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f = (this.videoAspectRatio / (measuredWidth / measuredHeight)) - 1.0f;
            if (Math.abs(f) > MAX_ASPECT_RATIO_DEFORMATION_FRACTION) {
                switch (this.resizeMode) {
                    case 1:
                        measuredHeight = (int) (measuredWidth / this.videoAspectRatio);
                        break;
                    case 2:
                        measuredWidth = (int) (measuredHeight * this.videoAspectRatio);
                        break;
                    default:
                        if (f > 0.0f) {
                            measuredHeight = (int) (measuredWidth / this.videoAspectRatio);
                            break;
                        } else {
                            measuredWidth = (int) (measuredHeight * this.videoAspectRatio);
                            break;
                        }
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }
}

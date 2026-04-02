package com.fotoable.youtube.music.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.TextureView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public abstract class ScalableTextureView extends TextureView {
    private Integer mContentHeight;
    private float mContentRotation;
    private float mContentScaleMultiplier;
    private float mContentScaleX;
    private float mContentScaleY;
    private Integer mContentWidth;
    private int mContentX;
    private int mContentY;
    private float mPivotPointX;
    private float mPivotPointY;
    private ScaleType mScaleType;
    private final Matrix mTransformMatrix;

    /* loaded from: classes.dex */
    public enum ScaleType {
        CENTER_CROP,
        TOP,
        BOTTOM,
        FILL
    }

    public ScalableTextureView(Context context) {
        super(context);
        this.mPivotPointX = 0.0f;
        this.mPivotPointY = 0.0f;
        this.mContentScaleX = 1.0f;
        this.mContentScaleY = 1.0f;
        this.mContentRotation = 0.0f;
        this.mContentScaleMultiplier = 1.0f;
        this.mContentX = 0;
        this.mContentY = 0;
        this.mTransformMatrix = new Matrix();
    }

    public ScalableTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPivotPointX = 0.0f;
        this.mPivotPointY = 0.0f;
        this.mContentScaleX = 1.0f;
        this.mContentScaleY = 1.0f;
        this.mContentRotation = 0.0f;
        this.mContentScaleMultiplier = 1.0f;
        this.mContentX = 0;
        this.mContentY = 0;
        this.mTransformMatrix = new Matrix();
    }

    public ScalableTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPivotPointX = 0.0f;
        this.mPivotPointY = 0.0f;
        this.mContentScaleX = 1.0f;
        this.mContentScaleY = 1.0f;
        this.mContentRotation = 0.0f;
        this.mContentScaleMultiplier = 1.0f;
        this.mContentX = 0;
        this.mContentY = 0;
        this.mTransformMatrix = new Matrix();
    }

    @TargetApi(21)
    public ScalableTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPivotPointX = 0.0f;
        this.mPivotPointY = 0.0f;
        this.mContentScaleX = 1.0f;
        this.mContentScaleY = 1.0f;
        this.mContentRotation = 0.0f;
        this.mContentScaleMultiplier = 1.0f;
        this.mContentX = 0;
        this.mContentY = 0;
        this.mTransformMatrix = new Matrix();
    }

    public void setScaleType(ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mContentWidth != null && this.mContentHeight != null) {
            updateTextureViewSize();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void updateTextureViewSize() {
        float f;
        float f2;
        float f3;
        float f4 = 0.0f;
        float f5 = 1.0f;
        if (this.mContentWidth == null || this.mContentHeight == null) {
            throw new RuntimeException("null content size");
        }
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        float intValue = this.mContentWidth.intValue();
        float intValue2 = this.mContentHeight.intValue();
        switch (this.mScaleType) {
            case FILL:
                if (measuredWidth > measuredHeight) {
                    f = (intValue * measuredHeight) / (measuredWidth * intValue2);
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = (measuredWidth * intValue2) / (intValue * measuredHeight);
                    f = 1.0f;
                    break;
                }
            case BOTTOM:
            case CENTER_CROP:
            case TOP:
                if (intValue > measuredWidth && intValue2 > measuredHeight) {
                    f = intValue / measuredWidth;
                    f2 = intValue2 / measuredHeight;
                    break;
                } else if (intValue < measuredWidth && intValue2 < measuredHeight) {
                    f2 = measuredWidth / intValue;
                    f = measuredHeight / intValue2;
                    break;
                } else if (measuredWidth > intValue) {
                    f2 = (measuredWidth / intValue) / (measuredHeight / intValue2);
                    f = 1.0f;
                    break;
                } else if (measuredHeight > intValue2) {
                    f = (measuredHeight / intValue2) / (measuredWidth / intValue);
                    f2 = 1.0f;
                    break;
                }
                break;
            default:
                f2 = 1.0f;
                f = 1.0f;
                break;
        }
        switch (this.mScaleType) {
            case FILL:
                f3 = this.mPivotPointX;
                f4 = this.mPivotPointY;
                break;
            case BOTTOM:
                f4 = measuredHeight;
                f3 = measuredWidth;
                break;
            case CENTER_CROP:
                f3 = measuredWidth / 2.0f;
                f4 = measuredHeight / 2.0f;
                break;
            case TOP:
                f3 = 0.0f;
                break;
            default:
                throw new IllegalStateException("pivotPointX, pivotPointY for ScaleType " + this.mScaleType + " are not defined");
        }
        switch (this.mScaleType) {
            case BOTTOM:
            case CENTER_CROP:
            case TOP:
                if (this.mContentHeight.intValue() > this.mContentWidth.intValue()) {
                    f5 = measuredWidth / (measuredWidth * f);
                    break;
                } else {
                    f5 = measuredHeight / (measuredHeight * f2);
                    break;
                }
        }
        this.mContentScaleX = f * f5;
        this.mContentScaleY = f2 * f5;
        this.mPivotPointX = f3;
        this.mPivotPointY = f4;
        updateMatrixScaleRotate();
    }

    private void updateMatrixScaleRotate() {
        this.mTransformMatrix.reset();
        this.mTransformMatrix.setScale(this.mContentScaleX * this.mContentScaleMultiplier, this.mContentScaleY * this.mContentScaleMultiplier, this.mPivotPointX, this.mPivotPointY);
        this.mTransformMatrix.postRotate(this.mContentRotation, this.mPivotPointX, this.mPivotPointY);
        setTransform(this.mTransformMatrix);
    }

    private void updateMatrixTranslate() {
        float f = this.mContentScaleX * this.mContentScaleMultiplier;
        float f2 = this.mContentScaleY * this.mContentScaleMultiplier;
        this.mTransformMatrix.reset();
        this.mTransformMatrix.setScale(f, f2, this.mPivotPointX, this.mPivotPointY);
        this.mTransformMatrix.postTranslate(this.mContentX, this.mContentY);
        setTransform(this.mTransformMatrix);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.mContentRotation = f;
        updateMatrixScaleRotate();
    }

    @Override // android.view.View
    public float getRotation() {
        return this.mContentRotation;
    }

    @Override // android.view.View
    public void setPivotX(float f) {
        this.mPivotPointX = f;
    }

    @Override // android.view.View
    public void setPivotY(float f) {
        this.mPivotPointY = f;
    }

    @Override // android.view.View
    public float getPivotX() {
        return this.mPivotPointX;
    }

    @Override // android.view.View
    public float getPivotY() {
        return this.mPivotPointY;
    }

    public float getContentAspectRatio() {
        if (this.mContentWidth == null || this.mContentHeight == null) {
            return 0.0f;
        }
        return this.mContentWidth.intValue() / this.mContentHeight.intValue();
    }

    public final void setContentX(float f) {
        this.mContentX = ((int) f) - ((getMeasuredWidth() - getScaledContentWidth().intValue()) / 2);
        updateMatrixTranslate();
    }

    public final void setContentY(float f) {
        this.mContentY = ((int) f) - ((getMeasuredHeight() - getScaledContentHeight().intValue()) / 2);
        updateMatrixTranslate();
    }

    protected final float getContentX() {
        return this.mContentX;
    }

    protected final float getContentY() {
        return this.mContentY;
    }

    public void centralizeContent() {
        getMeasuredWidth();
        getMeasuredHeight();
        getScaledContentWidth().intValue();
        getScaledContentHeight().intValue();
        this.mContentX = 0;
        this.mContentY = 0;
        updateMatrixScaleRotate();
    }

    public Integer getScaledContentWidth() {
        return Integer.valueOf((int) (this.mContentScaleX * this.mContentScaleMultiplier * getMeasuredWidth()));
    }

    public Integer getScaledContentHeight() {
        return Integer.valueOf((int) (this.mContentScaleY * this.mContentScaleMultiplier * getMeasuredHeight()));
    }

    public float getContentScale() {
        return this.mContentScaleMultiplier;
    }

    public void setContentScale(float f) {
        this.mContentScaleMultiplier = f;
        updateMatrixScaleRotate();
    }

    protected final void setContentHeight(int i) {
        this.mContentHeight = Integer.valueOf(i);
    }

    protected final Integer getContentHeight() {
        return this.mContentHeight;
    }

    protected final void setContentWidth(int i) {
        this.mContentWidth = Integer.valueOf(i);
    }

    protected final Integer getContentWidth() {
        return this.mContentWidth;
    }
}

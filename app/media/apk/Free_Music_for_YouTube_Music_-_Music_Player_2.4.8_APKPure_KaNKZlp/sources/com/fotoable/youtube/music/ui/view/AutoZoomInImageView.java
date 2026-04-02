package com.fotoable.youtube.music.ui.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AutoZoomInImageView extends ImageView {
    private Drawable mDrawable;
    private int mDrawableH;
    private int mDrawableW;
    private long mDurationMillis;
    private int mImageViewH;
    private int mImageViewW;
    private Matrix mMatrix;
    private OnZoomListener mOnZoomListener;
    private float mScaleDelta;
    private float[] mValues;

    /* loaded from: classes.dex */
    public interface OnZoomListener {
        void onEnd(View view);

        void onStart(View view);

        void onUpdate(View view, float f);
    }

    public AutoZoomInImageView(Context context) {
        super(context);
        this.mValues = new float[9];
        this.mScaleDelta = 0.2f;
        this.mDurationMillis = 700L;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public AutoZoomInImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mValues = new float[9];
        this.mScaleDelta = 0.2f;
        this.mDurationMillis = 700L;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public AutoZoomInImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mValues = new float[9];
        this.mScaleDelta = 0.2f;
        this.mDurationMillis = 700L;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public AutoZoomInImageView init() {
        initInternalValues();
        initPicturePosition();
        return this;
    }

    public void init(Drawable drawable) {
        initInternalValues(drawable);
        initPicturePosition();
    }

    private void initInternalValues() {
        this.mDrawable = getDrawable();
        if (this.mDrawable == null) {
            throw new IllegalArgumentException("please set the source of AutoZoomInImageView");
        }
        this.mDrawableW = this.mDrawable.getIntrinsicWidth();
        this.mDrawableH = this.mDrawable.getIntrinsicHeight();
        this.mImageViewW = getMeasuredWidth();
        this.mImageViewH = getMeasuredHeight();
        this.mMatrix = getImageMatrix();
        this.mMatrix.getValues(this.mValues);
    }

    private void initInternalValues(Drawable drawable) {
        this.mDrawable = drawable;
        if (this.mDrawable == null) {
            throw new IllegalArgumentException("please set the source of AutoZoomInImageView");
        }
        this.mDrawableW = this.mDrawable.getIntrinsicWidth();
        this.mDrawableH = this.mDrawable.getIntrinsicHeight();
        this.mImageViewW = getMeasuredWidth();
        this.mImageViewH = getMeasuredHeight();
        this.mMatrix = getImageMatrix();
        this.mMatrix.getValues(this.mValues);
    }

    private void initPicturePosition() {
        updateMatrixValuesOrigin(this.mMatrix, this.mValues, this.mDrawableW, this.mDrawableH, this.mImageViewW, this.mImageViewH);
        setImageMatrix(this.mMatrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startZoomInByScaleDelta(final float f, long j) {
        final float f2 = this.mValues[0];
        final float f3 = this.mValues[4];
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fotoable.youtube.music.ui.view.AutoZoomInImageView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (AutoZoomInImageView.this.mOnZoomListener != null) {
                    AutoZoomInImageView.this.mOnZoomListener.onUpdate(AutoZoomInImageView.this, floatValue / f);
                }
                AutoZoomInImageView.this.updateMatrixValuesSpan(AutoZoomInImageView.this.mValues, AutoZoomInImageView.this.mDrawableW, AutoZoomInImageView.this.mDrawableH, AutoZoomInImageView.this.mImageViewW, AutoZoomInImageView.this.mImageViewH, f2, f3, floatValue);
                AutoZoomInImageView.this.mMatrix.setValues(AutoZoomInImageView.this.mValues);
                AutoZoomInImageView.this.setImageMatrix(AutoZoomInImageView.this.mMatrix);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.fotoable.youtube.music.ui.view.AutoZoomInImageView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (AutoZoomInImageView.this.mOnZoomListener != null) {
                    AutoZoomInImageView.this.mOnZoomListener.onStart(AutoZoomInImageView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AutoZoomInImageView.this.mOnZoomListener != null) {
                    AutoZoomInImageView.this.mOnZoomListener.onEnd(AutoZoomInImageView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.setDuration(j);
        ofFloat.start();
    }

    public void startZoomInByScaleDeltaAndDuration(final float f, final long j, long j2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("scaleDelta should be larger than 0, now scaleDelta is " + f);
        }
        if (j < 0) {
            throw new IllegalArgumentException("durationMillis should not be less than 0, now durationMillis is " + j);
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("delayMillis should not be less than 0, now delayMillis is " + j2);
        }
        postDelayed(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.AutoZoomInImageView.3
            @Override // java.lang.Runnable
            public void run() {
                AutoZoomInImageView.this.startZoomInByScaleDelta(f, j);
            }
        }, j2);
    }

    public AutoZoomInImageView setScaleDelta(float f) {
        this.mScaleDelta = f;
        return this;
    }

    public AutoZoomInImageView setDurationMillis(long j) {
        this.mDurationMillis = j;
        return this;
    }

    public AutoZoomInImageView setOnZoomListener(OnZoomListener onZoomListener) {
        this.mOnZoomListener = onZoomListener;
        return this;
    }

    public void start(long j) {
        postDelayed(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.AutoZoomInImageView.4
            @Override // java.lang.Runnable
            public void run() {
                AutoZoomInImageView.this.startZoomInByScaleDelta(AutoZoomInImageView.this.mScaleDelta, AutoZoomInImageView.this.mDurationMillis);
            }
        }, j);
    }

    private void updateMatrixValuesOrigin(Matrix matrix, float[] fArr, float f, float f2, float f3, float f4) {
        if (matrix == null || fArr == null) {
            throw new IllegalArgumentException("please set the source of AutoZoomInImageView's matrix and values");
        }
        matrix.reset();
        if (f4 * f > f2 * f3) {
            float f5 = f4 / f2;
            matrix.postScale(f5, f5);
            matrix.postTranslate(-(((f * f5) - f3) / 2.0f), 0.0f);
        } else {
            float f6 = f3 / f;
            matrix.postScale(f6, f6);
            matrix.postTranslate(0.0f, -(((f2 * f6) - f4) / 2.0f));
        }
        matrix.getValues(fArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMatrixValuesSpan(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        fArr[0] = (1.0f + f7) * f5;
        fArr[4] = (1.0f + f7) * f6;
        fArr[2] = -(((fArr[0] * f) - f3) / 2.0f);
        fArr[5] = -(((fArr[0] * f2) - f4) / 2.0f);
    }

    public String printMyMatrix(Matrix matrix) {
        float[] fArr;
        matrix.getValues(new float[9]);
        String str = "";
        for (int i = 0; i < 9; i++) {
            str = str + " [ " + fArr[i] + " ] ";
        }
        return str;
    }

    public String printMyValue(float[] fArr) {
        String str = "";
        for (int i = 0; i < 9; i++) {
            str = str + " [ " + fArr[i] + " ] ";
        }
        return str;
    }
}

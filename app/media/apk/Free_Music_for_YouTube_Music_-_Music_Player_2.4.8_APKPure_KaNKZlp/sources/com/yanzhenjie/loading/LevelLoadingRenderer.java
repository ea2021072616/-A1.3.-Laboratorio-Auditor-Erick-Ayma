package com.yanzhenjie.loading;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
/* loaded from: classes2.dex */
public class LevelLoadingRenderer extends LoadingRenderer {
    private static final float DEFAULT_CENTER_RADIUS = 12.5f;
    private static final float DEFAULT_STROKE_WIDTH = 2.5f;
    private static final int DEGREE_360 = 360;
    private static final float END_TRIM_DURATION_OFFSET = 1.0f;
    private static final float FULL_GROUP_ROTATION = 1080.0f;
    private static final float MAX_SWIPE_DEGREES = 288.0f;
    private static final int NUM_POINTS = 5;
    private static final float START_TRIM_DURATION_OFFSET = 0.5f;
    private final Animator.AnimatorListener mAnimatorListener;
    private float mCenterRadius;
    private float mEndDegrees;
    private float mGroupRotation;
    private int[] mLevelColors;
    private float[] mLevelSwipeDegrees;
    private float mOriginEndDegrees;
    private float mOriginStartDegrees;
    private final Paint mPaint;
    private float mRotationCount;
    private float mStartDegrees;
    private float mStrokeInset;
    private float mStrokeWidth;
    private final RectF mTempBounds;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final Interpolator ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();
    private static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final float[] LEVEL_SWEEP_ANGLE_OFFSETS = {1.0f, 0.875f, 0.625f};
    private static final int[] DEFAULT_LEVEL_COLORS = {Color.parseColor("#55ffffff"), Color.parseColor("#b1ffffff"), Color.parseColor("#ffffffff")};

    public LevelLoadingRenderer(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mTempBounds = new RectF();
        this.mAnimatorListener = new AnimatorListenerAdapter() { // from class: com.yanzhenjie.loading.LevelLoadingRenderer.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                LevelLoadingRenderer.this.storeOriginals();
                LevelLoadingRenderer.this.mStartDegrees = LevelLoadingRenderer.this.mEndDegrees;
                LevelLoadingRenderer.this.mRotationCount = (LevelLoadingRenderer.this.mRotationCount + 1.0f) % 5.0f;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                LevelLoadingRenderer.this.mRotationCount = 0.0f;
            }
        };
        init(context);
        setupPaint();
        addRenderListener(this.mAnimatorListener);
    }

    private void init(Context context) {
        this.mStrokeWidth = Utils.dip2px(context, DEFAULT_STROKE_WIDTH);
        this.mCenterRadius = Utils.dip2px(context, DEFAULT_CENTER_RADIUS);
        this.mLevelSwipeDegrees = new float[3];
        this.mLevelColors = DEFAULT_LEVEL_COLORS;
    }

    private void setupPaint() {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        initStrokeInset((int) this.mWidth, (int) this.mHeight);
    }

    public void setCircleColors(int i, int i2, int i3) {
        this.mLevelColors = new int[]{i, i2, i3};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yanzhenjie.loading.LoadingRenderer
    public void draw(Canvas canvas) {
        int save = canvas.save();
        this.mTempBounds.set(this.mBounds);
        this.mTempBounds.inset(this.mStrokeInset, this.mStrokeInset);
        canvas.rotate(this.mGroupRotation, this.mTempBounds.centerX(), this.mTempBounds.centerY());
        for (int i = 0; i < 3; i++) {
            if (this.mLevelSwipeDegrees[i] != 0.0f) {
                this.mPaint.setColor(this.mLevelColors[i]);
                canvas.drawArc(this.mTempBounds, this.mEndDegrees, this.mLevelSwipeDegrees[i], false, this.mPaint);
            }
        }
        canvas.restoreToCount(save);
    }

    @Override // com.yanzhenjie.loading.LoadingRenderer
    protected void computeRender(float f) {
        if (f <= START_TRIM_DURATION_OFFSET) {
            float f2 = f / START_TRIM_DURATION_OFFSET;
            this.mStartDegrees = (MATERIAL_INTERPOLATOR.getInterpolation(f2) * MAX_SWIPE_DEGREES) + this.mOriginStartDegrees;
            float f3 = this.mEndDegrees - this.mStartDegrees;
            float abs = Math.abs(f3) / MAX_SWIPE_DEGREES;
            float interpolation = DECELERATE_INTERPOLATOR.getInterpolation(abs) - LINEAR_INTERPOLATOR.getInterpolation(abs);
            float interpolation2 = ACCELERATE_INTERPOLATOR.getInterpolation(abs) - LINEAR_INTERPOLATOR.getInterpolation(abs);
            this.mLevelSwipeDegrees[0] = (interpolation + 1.0f) * (-f3) * LEVEL_SWEEP_ANGLE_OFFSETS[0];
            this.mLevelSwipeDegrees[1] = (-f3) * LEVEL_SWEEP_ANGLE_OFFSETS[1] * 1.0f;
            this.mLevelSwipeDegrees[2] = (-f3) * LEVEL_SWEEP_ANGLE_OFFSETS[2] * (interpolation2 + 1.0f);
        }
        if (f > START_TRIM_DURATION_OFFSET) {
            float f4 = (f - START_TRIM_DURATION_OFFSET) / START_TRIM_DURATION_OFFSET;
            this.mEndDegrees = (MATERIAL_INTERPOLATOR.getInterpolation(f4) * MAX_SWIPE_DEGREES) + this.mOriginEndDegrees;
            float f5 = this.mEndDegrees - this.mStartDegrees;
            float abs2 = Math.abs(f5) / MAX_SWIPE_DEGREES;
            if (abs2 > LEVEL_SWEEP_ANGLE_OFFSETS[1]) {
                this.mLevelSwipeDegrees[0] = -f5;
                this.mLevelSwipeDegrees[1] = LEVEL_SWEEP_ANGLE_OFFSETS[1] * MAX_SWIPE_DEGREES;
                this.mLevelSwipeDegrees[2] = LEVEL_SWEEP_ANGLE_OFFSETS[2] * MAX_SWIPE_DEGREES;
            } else if (abs2 > LEVEL_SWEEP_ANGLE_OFFSETS[2]) {
                this.mLevelSwipeDegrees[0] = 0.0f;
                this.mLevelSwipeDegrees[1] = -f5;
                this.mLevelSwipeDegrees[2] = LEVEL_SWEEP_ANGLE_OFFSETS[2] * MAX_SWIPE_DEGREES;
            } else {
                this.mLevelSwipeDegrees[0] = 0.0f;
                this.mLevelSwipeDegrees[1] = 0.0f;
                this.mLevelSwipeDegrees[2] = -f5;
            }
        }
        this.mGroupRotation = (216.0f * f) + (FULL_GROUP_ROTATION * (this.mRotationCount / 5.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yanzhenjie.loading.LoadingRenderer
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yanzhenjie.loading.LoadingRenderer
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // com.yanzhenjie.loading.LoadingRenderer
    protected void reset() {
        resetOriginals();
    }

    private void initStrokeInset(float f, float f2) {
        float min = (Math.min(f, f2) / 2.0f) - this.mCenterRadius;
        float ceil = (float) Math.ceil(this.mStrokeWidth / 2.0f);
        if (min >= ceil) {
            ceil = min;
        }
        this.mStrokeInset = ceil;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeOriginals() {
        this.mOriginEndDegrees = this.mEndDegrees;
        this.mOriginStartDegrees = this.mEndDegrees;
    }

    private void resetOriginals() {
        this.mOriginEndDegrees = 0.0f;
        this.mOriginStartDegrees = 0.0f;
        this.mEndDegrees = 0.0f;
        this.mStartDegrees = 0.0f;
        this.mLevelSwipeDegrees[0] = 0.0f;
        this.mLevelSwipeDegrees[1] = 0.0f;
        this.mLevelSwipeDegrees[2] = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apply(Builder builder) {
        float f;
        float f2;
        float f3;
        float f4;
        long j;
        int[] iArr;
        if (builder.mWidth <= 0) {
            f = this.mWidth;
        } else {
            f = builder.mWidth;
        }
        this.mWidth = f;
        if (builder.mHeight <= 0) {
            f2 = this.mHeight;
        } else {
            f2 = builder.mHeight;
        }
        this.mHeight = f2;
        if (builder.mStrokeWidth <= 0) {
            f3 = this.mStrokeWidth;
        } else {
            f3 = builder.mStrokeWidth;
        }
        this.mStrokeWidth = f3;
        if (builder.mCenterRadius <= 0) {
            f4 = this.mCenterRadius;
        } else {
            f4 = builder.mCenterRadius;
        }
        this.mCenterRadius = f4;
        if (builder.mDuration <= 0) {
            j = this.mDuration;
        } else {
            j = builder.mDuration;
        }
        this.mDuration = j;
        if (builder.mLevelColors == null) {
            iArr = this.mLevelColors;
        } else {
            iArr = builder.mLevelColors;
        }
        this.mLevelColors = iArr;
        setupPaint();
        initStrokeInset(this.mWidth, this.mHeight);
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private int mCenterRadius;
        private Context mContext;
        private int mDuration;
        private int mHeight;
        private int[] mLevelColors;
        private int mStrokeWidth;
        private int mWidth;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setWidth(int i) {
            this.mWidth = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.mHeight = i;
            return this;
        }

        public Builder setStrokeWidth(int i) {
            this.mStrokeWidth = i;
            return this;
        }

        public Builder setCenterRadius(int i) {
            this.mCenterRadius = i;
            return this;
        }

        public Builder setDuration(int i) {
            this.mDuration = i;
            return this;
        }

        public Builder setLevelColors(int[] iArr) {
            this.mLevelColors = iArr;
            return this;
        }

        public Builder setLevelColor(int i) {
            return setLevelColors(new int[]{oneThirdAlphaColor(i), twoThirdAlphaColor(i), i});
        }

        public LevelLoadingRenderer build() {
            LevelLoadingRenderer levelLoadingRenderer = new LevelLoadingRenderer(this.mContext);
            levelLoadingRenderer.apply(this);
            return levelLoadingRenderer;
        }

        private int oneThirdAlphaColor(int i) {
            return ((((i >> 24) & 255) / 3) << 24) | (((i >> 16) & 255) << 16) | (((i >> 8) & 255) << 8) | (i & 255);
        }

        private int twoThirdAlphaColor(int i) {
            return (((((i >> 24) & 255) * 2) / 3) << 24) | (((i >> 16) & 255) << 16) | (((i >> 8) & 255) << 8) | (i & 255);
        }
    }
}

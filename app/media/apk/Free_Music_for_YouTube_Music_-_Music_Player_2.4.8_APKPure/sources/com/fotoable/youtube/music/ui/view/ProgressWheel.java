package com.fotoable.youtube.music.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.fotoable.youtube.music.R;
/* loaded from: classes.dex */
public class ProgressWheel extends View {
    private static final String TAG = ProgressWheel.class.getSimpleName();
    private int barColor;
    private float barExtraLength;
    private boolean barGrowingFromFront;
    private final int barLength;
    private final int barMaxLength;
    private Paint barPaint;
    private double barSpinCycleTime;
    private int barWidth;
    private ProgressCallback callback;
    private RectF circleBounds;
    private int circleRadius;
    private boolean fillRadius;
    private boolean isSpinning;
    private long lastTimeAnimated;
    private boolean linearProgress;
    private float mProgress;
    private float mTargetProgress;
    private final long pauseGrowingTime;
    private long pausedTimeWithoutGrowing;
    private int rimColor;
    private Paint rimPaint;
    private int rimWidth;
    private boolean shouldAnimate;
    private float spinSpeed;
    private double timeStartGrowing;

    /* loaded from: classes.dex */
    public interface ProgressCallback {
        void onProgressUpdate(float f);
    }

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.barLength = 16;
        this.barMaxLength = 270;
        this.pauseGrowingTime = 200L;
        this.circleRadius = 28;
        this.barWidth = 4;
        this.rimWidth = 4;
        this.fillRadius = false;
        this.timeStartGrowing = 0.0d;
        this.barSpinCycleTime = 460.0d;
        this.barExtraLength = 0.0f;
        this.barGrowingFromFront = true;
        this.pausedTimeWithoutGrowing = 0L;
        this.barColor = -1442840576;
        this.rimColor = ViewCompat.MEASURED_SIZE_MASK;
        this.barPaint = new Paint();
        this.rimPaint = new Paint();
        this.circleBounds = new RectF();
        this.spinSpeed = 230.0f;
        this.lastTimeAnimated = 0L;
        this.mProgress = 0.0f;
        this.mTargetProgress = 0.0f;
        this.isSpinning = false;
        parseAttributes(context.obtainStyledAttributes(attributeSet, R.styleable.ProgressWheel));
        setAnimationEnabled();
    }

    public ProgressWheel(Context context) {
        super(context);
        this.barLength = 16;
        this.barMaxLength = 270;
        this.pauseGrowingTime = 200L;
        this.circleRadius = 28;
        this.barWidth = 4;
        this.rimWidth = 4;
        this.fillRadius = false;
        this.timeStartGrowing = 0.0d;
        this.barSpinCycleTime = 460.0d;
        this.barExtraLength = 0.0f;
        this.barGrowingFromFront = true;
        this.pausedTimeWithoutGrowing = 0L;
        this.barColor = -1442840576;
        this.rimColor = ViewCompat.MEASURED_SIZE_MASK;
        this.barPaint = new Paint();
        this.rimPaint = new Paint();
        this.circleBounds = new RectF();
        this.spinSpeed = 230.0f;
        this.lastTimeAnimated = 0L;
        this.mProgress = 0.0f;
        this.mTargetProgress = 0.0f;
        this.isSpinning = false;
        setAnimationEnabled();
    }

    @TargetApi(17)
    private void setAnimationEnabled() {
        float f;
        if (Build.VERSION.SDK_INT >= 17) {
            f = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        } else {
            f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        }
        this.shouldAnimate = f != 0.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = this.circleRadius + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.circleRadius + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(size, paddingTop);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setupBounds(i, i2);
        setupPaints();
        invalidate();
    }

    private void setupPaints() {
        this.barPaint.setColor(this.barColor);
        this.barPaint.setAntiAlias(true);
        this.barPaint.setStyle(Paint.Style.STROKE);
        this.barPaint.setStrokeWidth(this.barWidth);
        this.rimPaint.setColor(this.rimColor);
        this.rimPaint.setAntiAlias(true);
        this.rimPaint.setStyle(Paint.Style.STROKE);
        this.rimPaint.setStrokeWidth(this.rimWidth);
    }

    private void setupBounds(int i, int i2) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.fillRadius) {
            int min = Math.min(Math.min((i - paddingLeft) - paddingRight, (i2 - paddingBottom) - paddingTop), (this.circleRadius * 2) - (this.barWidth * 2));
            int i3 = paddingLeft + ((((i - paddingLeft) - paddingRight) - min) / 2);
            int i4 = paddingTop + ((((i2 - paddingTop) - paddingBottom) - min) / 2);
            this.circleBounds = new RectF(this.barWidth + i3, this.barWidth + i4, (i3 + min) - this.barWidth, (i4 + min) - this.barWidth);
            return;
        }
        this.circleBounds = new RectF(paddingLeft + this.barWidth, paddingTop + this.barWidth, (i - paddingRight) - this.barWidth, (i2 - paddingBottom) - this.barWidth);
    }

    private void parseAttributes(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.barWidth = (int) TypedValue.applyDimension(1, this.barWidth, displayMetrics);
        this.rimWidth = (int) TypedValue.applyDimension(1, this.rimWidth, displayMetrics);
        this.circleRadius = (int) TypedValue.applyDimension(1, this.circleRadius, displayMetrics);
        this.circleRadius = (int) typedArray.getDimension(6, this.circleRadius);
        this.fillRadius = typedArray.getBoolean(7, false);
        this.barWidth = (int) typedArray.getDimension(8, this.barWidth);
        this.rimWidth = (int) typedArray.getDimension(3, this.rimWidth);
        this.spinSpeed = typedArray.getFloat(4, this.spinSpeed / 360.0f) * 360.0f;
        this.barSpinCycleTime = typedArray.getInt(5, (int) this.barSpinCycleTime);
        this.barColor = typedArray.getColor(1, this.barColor);
        this.rimColor = typedArray.getColor(2, this.rimColor);
        this.linearProgress = typedArray.getBoolean(9, false);
        if (typedArray.getBoolean(0, false)) {
            spin();
        }
        typedArray.recycle();
    }

    public void setCallback(ProgressCallback progressCallback) {
        this.callback = progressCallback;
        if (!this.isSpinning) {
            runCallback();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        float f;
        super.onDraw(canvas);
        canvas.drawArc(this.circleBounds, 360.0f, 360.0f, false, this.rimPaint);
        boolean z2 = false;
        if (this.shouldAnimate) {
            if (this.isSpinning) {
                z = true;
                long uptimeMillis = SystemClock.uptimeMillis() - this.lastTimeAnimated;
                updateBarLength(uptimeMillis);
                this.mProgress += (((float) uptimeMillis) * this.spinSpeed) / 1000.0f;
                if (this.mProgress > 360.0f) {
                    this.mProgress -= 360.0f;
                    runCallback(-1.0f);
                }
                this.lastTimeAnimated = SystemClock.uptimeMillis();
                float f2 = this.mProgress - 90.0f;
                float f3 = 16.0f + this.barExtraLength;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f3 = 135.0f;
                }
                canvas.drawArc(this.circleBounds, f2, f3, false, this.barPaint);
            } else {
                float f4 = this.mProgress;
                if (this.mProgress != this.mTargetProgress) {
                    z2 = true;
                    this.mProgress = Math.min(((((float) (SystemClock.uptimeMillis() - this.lastTimeAnimated)) / 1000.0f) * this.spinSpeed) + this.mProgress, this.mTargetProgress);
                    this.lastTimeAnimated = SystemClock.uptimeMillis();
                }
                z = z2;
                if (f4 != this.mProgress) {
                    runCallback();
                }
                float f5 = this.mProgress;
                if (this.linearProgress) {
                    f = 0.0f;
                } else {
                    f5 = ((float) (1.0d - Math.pow(1.0f - (this.mProgress / 360.0f), 2.0f))) * 360.0f;
                    f = ((float) (1.0d - Math.pow(1.0f - (this.mProgress / 360.0f), 2.0f * 2.0f))) * 360.0f;
                }
                canvas.drawArc(this.circleBounds, f - 90.0f, isInEditMode() ? 360.0f : f5, false, this.barPaint);
            }
            if (z) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.lastTimeAnimated = SystemClock.uptimeMillis();
        }
    }

    private void updateBarLength(long j) {
        if (this.pausedTimeWithoutGrowing >= 200) {
            this.timeStartGrowing += j;
            if (this.timeStartGrowing > this.barSpinCycleTime) {
                this.timeStartGrowing -= this.barSpinCycleTime;
                this.pausedTimeWithoutGrowing = 0L;
                this.barGrowingFromFront = !this.barGrowingFromFront;
            }
            float cos = (((float) Math.cos(((this.timeStartGrowing / this.barSpinCycleTime) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (!this.barGrowingFromFront) {
                float f = (1.0f - cos) * 254.0f;
                this.mProgress += this.barExtraLength - f;
                this.barExtraLength = f;
                return;
            }
            this.barExtraLength = cos * 254.0f;
            return;
        }
        this.pausedTimeWithoutGrowing += j;
    }

    public boolean isSpinning() {
        return this.isSpinning;
    }

    public void resetCount() {
        this.mProgress = 0.0f;
        this.mTargetProgress = 0.0f;
        invalidate();
    }

    public void stopSpinning() {
        this.isSpinning = false;
        this.mProgress = 0.0f;
        this.mTargetProgress = 0.0f;
        invalidate();
    }

    public void spin() {
        this.lastTimeAnimated = SystemClock.uptimeMillis();
        this.isSpinning = true;
        invalidate();
    }

    private void runCallback(float f) {
        if (this.callback != null) {
            this.callback.onProgressUpdate(f);
        }
    }

    private void runCallback() {
        if (this.callback != null) {
            this.callback.onProgressUpdate(Math.round((this.mProgress * 100.0f) / 360.0f) / 100.0f);
        }
    }

    public void setInstantProgress(float f) {
        if (this.isSpinning) {
            this.mProgress = 0.0f;
            this.isSpinning = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f != this.mTargetProgress) {
            this.mTargetProgress = Math.min(f * 360.0f, 360.0f);
            this.mProgress = this.mTargetProgress;
            this.lastTimeAnimated = SystemClock.uptimeMillis();
            invalidate();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.mProgress = this.mProgress;
        wheelSavedState.mTargetProgress = this.mTargetProgress;
        wheelSavedState.isSpinning = this.isSpinning;
        wheelSavedState.spinSpeed = this.spinSpeed;
        wheelSavedState.barWidth = this.barWidth;
        wheelSavedState.barColor = this.barColor;
        wheelSavedState.rimWidth = this.rimWidth;
        wheelSavedState.rimColor = this.rimColor;
        wheelSavedState.circleRadius = this.circleRadius;
        wheelSavedState.linearProgress = this.linearProgress;
        wheelSavedState.fillRadius = this.fillRadius;
        return wheelSavedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.mProgress = wheelSavedState.mProgress;
        this.mTargetProgress = wheelSavedState.mTargetProgress;
        this.isSpinning = wheelSavedState.isSpinning;
        this.spinSpeed = wheelSavedState.spinSpeed;
        this.barWidth = wheelSavedState.barWidth;
        this.barColor = wheelSavedState.barColor;
        this.rimWidth = wheelSavedState.rimWidth;
        this.rimColor = wheelSavedState.rimColor;
        this.circleRadius = wheelSavedState.circleRadius;
        this.linearProgress = wheelSavedState.linearProgress;
        this.fillRadius = wheelSavedState.fillRadius;
        this.lastTimeAnimated = SystemClock.uptimeMillis();
    }

    public float getProgress() {
        if (this.isSpinning) {
            return -1.0f;
        }
        return this.mProgress / 360.0f;
    }

    public void setProgress(float f) {
        if (this.isSpinning) {
            this.mProgress = 0.0f;
            this.isSpinning = false;
            runCallback();
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f != this.mTargetProgress) {
            if (this.mProgress == this.mTargetProgress) {
                this.lastTimeAnimated = SystemClock.uptimeMillis();
            }
            this.mTargetProgress = Math.min(f * 360.0f, 360.0f);
            invalidate();
        }
    }

    public void setLinearProgress(boolean z) {
        this.linearProgress = z;
        if (!this.isSpinning) {
            invalidate();
        }
    }

    public int getCircleRadius() {
        return this.circleRadius;
    }

    public void setCircleRadius(int i) {
        this.circleRadius = i;
        if (!this.isSpinning) {
            invalidate();
        }
    }

    public int getBarWidth() {
        return this.barWidth;
    }

    public void setBarWidth(int i) {
        this.barWidth = i;
        if (!this.isSpinning) {
            invalidate();
        }
    }

    public int getBarColor() {
        return this.barColor;
    }

    public void setBarColor(int i) {
        this.barColor = i;
        setupPaints();
        if (!this.isSpinning) {
            invalidate();
        }
    }

    public int getRimColor() {
        return this.rimColor;
    }

    public void setRimColor(int i) {
        this.rimColor = i;
        setupPaints();
        if (!this.isSpinning) {
            invalidate();
        }
    }

    public float getSpinSpeed() {
        return this.spinSpeed / 360.0f;
    }

    public void setSpinSpeed(float f) {
        this.spinSpeed = 360.0f * f;
    }

    public int getRimWidth() {
        return this.rimWidth;
    }

    public void setRimWidth(int i) {
        this.rimWidth = i;
        if (!this.isSpinning) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() { // from class: com.fotoable.youtube.music.ui.view.ProgressWheel.WheelSavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WheelSavedState[] newArray(int i) {
                return new WheelSavedState[i];
            }
        };
        int barColor;
        int barWidth;
        int circleRadius;
        boolean fillRadius;
        boolean isSpinning;
        boolean linearProgress;
        float mProgress;
        float mTargetProgress;
        int rimColor;
        int rimWidth;
        float spinSpeed;

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            super(parcel);
            this.mProgress = parcel.readFloat();
            this.mTargetProgress = parcel.readFloat();
            this.isSpinning = parcel.readByte() != 0;
            this.spinSpeed = parcel.readFloat();
            this.barWidth = parcel.readInt();
            this.barColor = parcel.readInt();
            this.rimWidth = parcel.readInt();
            this.rimColor = parcel.readInt();
            this.circleRadius = parcel.readInt();
            this.linearProgress = parcel.readByte() != 0;
            this.fillRadius = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.mProgress);
            parcel.writeFloat(this.mTargetProgress);
            parcel.writeByte((byte) (this.isSpinning ? 1 : 0));
            parcel.writeFloat(this.spinSpeed);
            parcel.writeInt(this.barWidth);
            parcel.writeInt(this.barColor);
            parcel.writeInt(this.rimWidth);
            parcel.writeInt(this.rimColor);
            parcel.writeInt(this.circleRadius);
            parcel.writeByte((byte) (this.linearProgress ? 1 : 0));
            parcel.writeByte((byte) (this.fillRadius ? 1 : 0));
        }
    }
}

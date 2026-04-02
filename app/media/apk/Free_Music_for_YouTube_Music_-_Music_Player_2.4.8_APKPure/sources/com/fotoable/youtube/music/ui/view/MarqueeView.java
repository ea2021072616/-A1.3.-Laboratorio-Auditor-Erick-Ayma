package com.fotoable.youtube.music.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.fotoable.youtube.music.R;
/* loaded from: classes.dex */
public class MarqueeView extends LinearLayout {
    private static final int DEFAULT_ANIMATION_PAUSE = 2000;
    private static final int DEFAULT_SPEED = 60;
    private static final String TAG = MarqueeView.class.getSimpleName();
    private static final int TEXTVIEW_VIRTUAL_WIDTH = 2000;
    private int mAnimationPause;
    private Runnable mAnimationStartRunnable;
    private boolean mAutoStart;
    private boolean mCancelled;
    private Interpolator mInterpolator;
    private boolean mMarqueeNeeded;
    private Animation mMoveTextIn;
    private Animation mMoveTextOut;
    private Paint mPaint;
    private ScrollView mScrollView;
    private int mSpeed;
    private boolean mStarted;
    private float mTextDifference;
    private TextView mTextField;

    public void setSpeed(int i) {
        this.mSpeed = i;
    }

    public void setPauseBetweenAnimations(int i) {
        this.mAnimationPause = i;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public MarqueeView(Context context) {
        super(context);
        this.mMoveTextOut = null;
        this.mMoveTextIn = null;
        this.mMarqueeNeeded = false;
        this.mSpeed = 60;
        this.mAnimationPause = 2000;
        this.mAutoStart = false;
        this.mInterpolator = new LinearInterpolator();
        this.mCancelled = false;
        init();
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMoveTextOut = null;
        this.mMoveTextIn = null;
        this.mMarqueeNeeded = false;
        this.mSpeed = 60;
        this.mAnimationPause = 2000;
        this.mAutoStart = false;
        this.mInterpolator = new LinearInterpolator();
        this.mCancelled = false;
        init();
        extractAttributes(attributeSet);
    }

    @TargetApi(11)
    public MarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMoveTextOut = null;
        this.mMoveTextIn = null;
        this.mMarqueeNeeded = false;
        this.mSpeed = 60;
        this.mAnimationPause = 2000;
        this.mAutoStart = false;
        this.mInterpolator = new LinearInterpolator();
        this.mCancelled = false;
        init();
        extractAttributes(attributeSet);
    }

    private void extractAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (getContext() != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.asia_ivity_android_marqueeview_MarqueeView)) != null) {
            this.mSpeed = obtainStyledAttributes.getInteger(0, 60);
            this.mAnimationPause = obtainStyledAttributes.getInteger(1, 2000);
            this.mAutoStart = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
        }
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mInterpolator = new LinearInterpolator();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getChildCount() != 1) {
            throw new RuntimeException("MarqueeView must have exactly one child element.");
        }
        if (z && this.mScrollView == null) {
            if (!(getChildAt(0) instanceof TextView)) {
                throw new RuntimeException("The child view of this MarqueeView must be a TextView instance.");
            }
            initView(getContext());
            prepareAnimation();
            if (this.mAutoStart) {
                startMarquee();
            }
        }
    }

    public void startMarquee() {
        if (this.mMarqueeNeeded) {
            startTextFieldAnimation();
        }
        this.mCancelled = false;
        this.mStarted = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTextFieldAnimation() {
        this.mAnimationStartRunnable = new Runnable() { // from class: com.fotoable.youtube.music.ui.view.MarqueeView.1
            @Override // java.lang.Runnable
            public void run() {
                MarqueeView.this.mTextField.startAnimation(MarqueeView.this.mMoveTextOut);
            }
        };
        postDelayed(this.mAnimationStartRunnable, this.mAnimationPause);
    }

    public void reset() {
        this.mCancelled = true;
        if (this.mAnimationStartRunnable != null) {
            removeCallbacks(this.mAnimationStartRunnable);
        }
        this.mTextField.clearAnimation();
        this.mStarted = false;
        this.mMoveTextOut.reset();
        this.mMoveTextIn.reset();
        cutTextView();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareAnimation() {
        this.mPaint.setTextSize(this.mTextField.getTextSize());
        this.mPaint.setTypeface(this.mTextField.getTypeface());
        float measureText = this.mPaint.measureText(this.mTextField.getText().toString());
        this.mMarqueeNeeded = measureText > ((float) getMeasuredWidth());
        this.mTextDifference = Math.abs(measureText - getMeasuredWidth()) + 5.0f;
        int i = (int) (this.mTextDifference * this.mSpeed);
        this.mMoveTextOut = new TranslateAnimation(0.0f, -this.mTextDifference, 0.0f, 0.0f);
        this.mMoveTextOut.setDuration(i);
        this.mMoveTextOut.setInterpolator(this.mInterpolator);
        this.mMoveTextOut.setFillAfter(true);
        this.mMoveTextIn = new TranslateAnimation(-this.mTextDifference, 0.0f, 0.0f, 0.0f);
        this.mMoveTextIn.setDuration(i);
        this.mMoveTextIn.setStartOffset(this.mAnimationPause);
        this.mMoveTextIn.setInterpolator(this.mInterpolator);
        this.mMoveTextIn.setFillAfter(true);
        this.mMoveTextOut.setAnimationListener(new Animation.AnimationListener() { // from class: com.fotoable.youtube.music.ui.view.MarqueeView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MarqueeView.this.expandTextView();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (!MarqueeView.this.mCancelled) {
                    MarqueeView.this.mTextField.startAnimation(MarqueeView.this.mMoveTextIn);
                } else {
                    MarqueeView.this.reset();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mMoveTextIn.setAnimationListener(new Animation.AnimationListener() { // from class: com.fotoable.youtube.music.ui.view.MarqueeView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MarqueeView.this.cutTextView();
                if (!MarqueeView.this.mCancelled) {
                    MarqueeView.this.startTextFieldAnimation();
                } else {
                    MarqueeView.this.reset();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void initView(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        this.mScrollView = new ScrollView(context);
        this.mTextField = (TextView) getChildAt(0);
        removeView(this.mTextField);
        this.mScrollView.addView(this.mTextField, new FrameLayout.LayoutParams(2000, -2));
        this.mTextField.addTextChangedListener(new TextWatcher() { // from class: com.fotoable.youtube.music.ui.view.MarqueeView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                final boolean z = MarqueeView.this.mStarted;
                MarqueeView.this.reset();
                MarqueeView.this.prepareAnimation();
                MarqueeView.this.cutTextView();
                MarqueeView.this.post(new Runnable() { // from class: com.fotoable.youtube.music.ui.view.MarqueeView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z) {
                            MarqueeView.this.startMarquee();
                        }
                    }
                });
            }
        });
        addView(this.mScrollView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expandTextView() {
        ViewGroup.LayoutParams layoutParams = this.mTextField.getLayoutParams();
        layoutParams.width = 2000;
        this.mTextField.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cutTextView() {
        if (this.mTextField.getWidth() != getMeasuredWidth()) {
            ViewGroup.LayoutParams layoutParams = this.mTextField.getLayoutParams();
            layoutParams.width = getMeasuredWidth();
            this.mTextField.setLayoutParams(layoutParams);
        }
    }
}

package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.facebook.appevents.AppEventsConstants;
import com.fotoable.youtube.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public class NumberPickerView extends View {
    private static final boolean DEFAULT_CURRENT_ITEM_INDEX_EFFECT = false;
    private static final int DEFAULT_DIVIDER_COLOR = -695533;
    private static final int DEFAULT_DIVIDER_HEIGHT = 2;
    private static final int DEFAULT_DIVIDER_MARGIN_HORIZONTAL = 0;
    private static final int DEFAULT_INTERVAL_REVISE_DURATION = 300;
    private static final int DEFAULT_ITEM_PADDING_DP_H = 5;
    private static final int DEFAULT_ITEM_PADDING_DP_V = 2;
    private static final int DEFAULT_MARGIN_END_OF_HINT_DP = 8;
    private static final int DEFAULT_MARGIN_START_OF_HINT_DP = 8;
    private static final int DEFAULT_MAX_SCROLL_BY_INDEX_DURATION = 600;
    private static final int DEFAULT_MIN_SCROLL_BY_INDEX_DURATION = 300;
    private static final boolean DEFAULT_RESPOND_CHANGE_IN_MAIN_THREAD = true;
    private static final boolean DEFAULT_RESPOND_CHANGE_ON_DETACH = false;
    private static final int DEFAULT_SHOW_COUNT = 3;
    private static final boolean DEFAULT_SHOW_DIVIDER = true;
    private static final int DEFAULT_TEXT_COLOR_NORMAL = -13421773;
    private static final int DEFAULT_TEXT_COLOR_SELECTED = -695533;
    private static final int DEFAULT_TEXT_SIZE_HINT_SP = 14;
    private static final int DEFAULT_TEXT_SIZE_NORMAL_SP = 14;
    private static final int DEFAULT_TEXT_SIZE_SELECTED_SP = 16;
    private static final boolean DEFAULT_WRAP_SELECTOR_WHEEL = true;
    private static final int HANDLER_INTERVAL_REFRESH = 32;
    private static final int HANDLER_WHAT_LISTENER_VALUE_CHANGED = 2;
    private static final int HANDLER_WHAT_REFRESH = 1;
    private static final int HANDLER_WHAT_REQUEST_LAYOUT = 3;
    private static final String TEXT_ELLIPSIZE_END = "end";
    private static final String TEXT_ELLIPSIZE_MIDDLE = "middle";
    private static final String TEXT_ELLIPSIZE_START = "start";
    private float currY;
    private float dividerY0;
    private float dividerY1;
    private float downY;
    private float downYGlobal;
    private String mAlterHint;
    private CharSequence[] mAlterTextArrayWithMeasureHint;
    private CharSequence[] mAlterTextArrayWithoutMeasureHint;
    private int mCurrDrawFirstItemIndex;
    private int mCurrDrawFirstItemY;
    private int mCurrDrawGlobalY;
    private boolean mCurrentItemIndexEffect;
    private String[] mDisplayedValues;
    private int mDividerColor;
    private int mDividerHeight;
    private int mDividerIndex0;
    private int mDividerIndex1;
    private int mDividerMarginL;
    private int mDividerMarginR;
    private String mEmptyItemHint;
    private boolean mFlagMayPress;
    private float mFriction;
    private Handler mHandlerInMainThread;
    private Handler mHandlerInNewThread;
    private HandlerThread mHandlerThread;
    private boolean mHasInit;
    private String mHintText;
    private int mInScrollingPickedNewValue;
    private int mInScrollingPickedOldValue;
    private int mItemHeight;
    private int mItemPaddingHorizontal;
    private int mItemPaddingVertical;
    private int mMarginEndOfHint;
    private int mMarginStartOfHint;
    private int mMaxHeightOfDisplayedValues;
    private int mMaxShowIndex;
    private int mMaxValue;
    private int mMaxWidthOfAlterArrayWithMeasureHint;
    private int mMaxWidthOfAlterArrayWithoutMeasureHint;
    private int mMaxWidthOfDisplayedValues;
    private int mMinShowIndex;
    private int mMinValue;
    private int mMiniVelocityFling;
    private int mNotWrapLimitYBottom;
    private int mNotWrapLimitYTop;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private OnValueChangeListenerInScrolling mOnValueChangeListenerInScrolling;
    private OnValueChangeListenerRelativeToRaw mOnValueChangeListenerRaw;
    private Paint mPaintDivider;
    private Paint mPaintHint;
    private TextPaint mPaintText;
    private boolean mPendingWrapToLinear;
    private int mPrevPickedIndex;
    private boolean mRespondChangeInMainThread;
    private boolean mRespondChangeOnDetach;
    private int mScaledTouchSlop;
    private int mScrollState;
    private ScrollerCompat mScroller;
    private int mShowCount;
    private boolean mShowDivider;
    private int mSpecModeH;
    private int mSpecModeW;
    private int mTextColorHint;
    private int mTextColorNormal;
    private int mTextColorSelected;
    private String mTextEllipsize;
    private int mTextSizeHint;
    private float mTextSizeHintCenterYOffset;
    private int mTextSizeNormal;
    private float mTextSizeNormalCenterYOffset;
    private int mTextSizeSelected;
    private float mTextSizeSelectedCenterYOffset;
    private VelocityTracker mVelocityTracker;
    private float mViewCenterX;
    private int mViewHeight;
    private int mViewWidth;
    private int mWidthOfAlterHint;
    private int mWidthOfHintText;
    private boolean mWrapSelectorWheel;
    private boolean mWrapSelectorWheelCheck;

    /* loaded from: classes.dex */
    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChange(NumberPickerView numberPickerView, int i);
    }

    /* loaded from: classes.dex */
    public interface OnValueChangeListener {
        void onValueChange(NumberPickerView numberPickerView, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnValueChangeListenerInScrolling {
        void onValueChangeInScrolling(NumberPickerView numberPickerView, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnValueChangeListenerRelativeToRaw {
        void onValueChangeRelativeToRaw(NumberPickerView numberPickerView, int i, int i2, String[] strArr);
    }

    public NumberPickerView(Context context) {
        super(context);
        this.mTextColorNormal = DEFAULT_TEXT_COLOR_NORMAL;
        this.mTextColorSelected = -695533;
        this.mTextColorHint = -695533;
        this.mTextSizeNormal = 0;
        this.mTextSizeSelected = 0;
        this.mTextSizeHint = 0;
        this.mWidthOfHintText = 0;
        this.mWidthOfAlterHint = 0;
        this.mMarginStartOfHint = 0;
        this.mMarginEndOfHint = 0;
        this.mItemPaddingVertical = 0;
        this.mItemPaddingHorizontal = 0;
        this.mDividerColor = -695533;
        this.mDividerHeight = 2;
        this.mDividerMarginL = 0;
        this.mDividerMarginR = 0;
        this.mShowCount = 3;
        this.mDividerIndex0 = 0;
        this.mDividerIndex1 = 0;
        this.mMinShowIndex = -1;
        this.mMaxShowIndex = -1;
        this.mMinValue = 0;
        this.mMaxValue = 0;
        this.mMaxWidthOfDisplayedValues = 0;
        this.mMaxHeightOfDisplayedValues = 0;
        this.mMaxWidthOfAlterArrayWithMeasureHint = 0;
        this.mMaxWidthOfAlterArrayWithoutMeasureHint = 0;
        this.mPrevPickedIndex = 0;
        this.mMiniVelocityFling = 150;
        this.mScaledTouchSlop = 8;
        this.mFriction = 1.0f;
        this.mTextSizeNormalCenterYOffset = 0.0f;
        this.mTextSizeSelectedCenterYOffset = 0.0f;
        this.mTextSizeHintCenterYOffset = 0.0f;
        this.mShowDivider = true;
        this.mWrapSelectorWheel = true;
        this.mCurrentItemIndexEffect = false;
        this.mHasInit = false;
        this.mWrapSelectorWheelCheck = true;
        this.mPendingWrapToLinear = false;
        this.mRespondChangeOnDetach = false;
        this.mRespondChangeInMainThread = true;
        this.mPaintDivider = new Paint();
        this.mPaintText = new TextPaint();
        this.mPaintHint = new Paint();
        this.mScrollState = 0;
        this.downYGlobal = 0.0f;
        this.downY = 0.0f;
        this.currY = 0.0f;
        this.mFlagMayPress = false;
        this.mCurrDrawFirstItemIndex = 0;
        this.mCurrDrawFirstItemY = 0;
        this.mCurrDrawGlobalY = 0;
        this.mSpecModeW = 0;
        this.mSpecModeH = 0;
        init(context);
    }

    public NumberPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextColorNormal = DEFAULT_TEXT_COLOR_NORMAL;
        this.mTextColorSelected = -695533;
        this.mTextColorHint = -695533;
        this.mTextSizeNormal = 0;
        this.mTextSizeSelected = 0;
        this.mTextSizeHint = 0;
        this.mWidthOfHintText = 0;
        this.mWidthOfAlterHint = 0;
        this.mMarginStartOfHint = 0;
        this.mMarginEndOfHint = 0;
        this.mItemPaddingVertical = 0;
        this.mItemPaddingHorizontal = 0;
        this.mDividerColor = -695533;
        this.mDividerHeight = 2;
        this.mDividerMarginL = 0;
        this.mDividerMarginR = 0;
        this.mShowCount = 3;
        this.mDividerIndex0 = 0;
        this.mDividerIndex1 = 0;
        this.mMinShowIndex = -1;
        this.mMaxShowIndex = -1;
        this.mMinValue = 0;
        this.mMaxValue = 0;
        this.mMaxWidthOfDisplayedValues = 0;
        this.mMaxHeightOfDisplayedValues = 0;
        this.mMaxWidthOfAlterArrayWithMeasureHint = 0;
        this.mMaxWidthOfAlterArrayWithoutMeasureHint = 0;
        this.mPrevPickedIndex = 0;
        this.mMiniVelocityFling = 150;
        this.mScaledTouchSlop = 8;
        this.mFriction = 1.0f;
        this.mTextSizeNormalCenterYOffset = 0.0f;
        this.mTextSizeSelectedCenterYOffset = 0.0f;
        this.mTextSizeHintCenterYOffset = 0.0f;
        this.mShowDivider = true;
        this.mWrapSelectorWheel = true;
        this.mCurrentItemIndexEffect = false;
        this.mHasInit = false;
        this.mWrapSelectorWheelCheck = true;
        this.mPendingWrapToLinear = false;
        this.mRespondChangeOnDetach = false;
        this.mRespondChangeInMainThread = true;
        this.mPaintDivider = new Paint();
        this.mPaintText = new TextPaint();
        this.mPaintHint = new Paint();
        this.mScrollState = 0;
        this.downYGlobal = 0.0f;
        this.downY = 0.0f;
        this.currY = 0.0f;
        this.mFlagMayPress = false;
        this.mCurrDrawFirstItemIndex = 0;
        this.mCurrDrawFirstItemY = 0;
        this.mCurrDrawGlobalY = 0;
        this.mSpecModeW = 0;
        this.mSpecModeH = 0;
        initAttr(context, attributeSet);
        init(context);
    }

    public NumberPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextColorNormal = DEFAULT_TEXT_COLOR_NORMAL;
        this.mTextColorSelected = -695533;
        this.mTextColorHint = -695533;
        this.mTextSizeNormal = 0;
        this.mTextSizeSelected = 0;
        this.mTextSizeHint = 0;
        this.mWidthOfHintText = 0;
        this.mWidthOfAlterHint = 0;
        this.mMarginStartOfHint = 0;
        this.mMarginEndOfHint = 0;
        this.mItemPaddingVertical = 0;
        this.mItemPaddingHorizontal = 0;
        this.mDividerColor = -695533;
        this.mDividerHeight = 2;
        this.mDividerMarginL = 0;
        this.mDividerMarginR = 0;
        this.mShowCount = 3;
        this.mDividerIndex0 = 0;
        this.mDividerIndex1 = 0;
        this.mMinShowIndex = -1;
        this.mMaxShowIndex = -1;
        this.mMinValue = 0;
        this.mMaxValue = 0;
        this.mMaxWidthOfDisplayedValues = 0;
        this.mMaxHeightOfDisplayedValues = 0;
        this.mMaxWidthOfAlterArrayWithMeasureHint = 0;
        this.mMaxWidthOfAlterArrayWithoutMeasureHint = 0;
        this.mPrevPickedIndex = 0;
        this.mMiniVelocityFling = 150;
        this.mScaledTouchSlop = 8;
        this.mFriction = 1.0f;
        this.mTextSizeNormalCenterYOffset = 0.0f;
        this.mTextSizeSelectedCenterYOffset = 0.0f;
        this.mTextSizeHintCenterYOffset = 0.0f;
        this.mShowDivider = true;
        this.mWrapSelectorWheel = true;
        this.mCurrentItemIndexEffect = false;
        this.mHasInit = false;
        this.mWrapSelectorWheelCheck = true;
        this.mPendingWrapToLinear = false;
        this.mRespondChangeOnDetach = false;
        this.mRespondChangeInMainThread = true;
        this.mPaintDivider = new Paint();
        this.mPaintText = new TextPaint();
        this.mPaintHint = new Paint();
        this.mScrollState = 0;
        this.downYGlobal = 0.0f;
        this.downY = 0.0f;
        this.currY = 0.0f;
        this.mFlagMayPress = false;
        this.mCurrDrawFirstItemIndex = 0;
        this.mCurrDrawFirstItemY = 0;
        this.mCurrDrawGlobalY = 0;
        this.mSpecModeW = 0;
        this.mSpecModeH = 0;
        initAttr(context, attributeSet);
        init(context);
    }

    private void initAttr(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NumberPickerView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.mShowCount = obtainStyledAttributes.getInt(index, 3);
                } else if (index == 2) {
                    this.mDividerColor = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == 5) {
                    this.mDividerHeight = obtainStyledAttributes.getDimensionPixelSize(index, 2);
                } else if (index == 3) {
                    this.mDividerMarginL = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.mDividerMarginR = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 12) {
                    this.mDisplayedValues = convertCharSequenceArrayToStringArray(obtainStyledAttributes.getTextArray(index));
                } else if (index == 6) {
                    this.mTextColorNormal = obtainStyledAttributes.getColor(index, DEFAULT_TEXT_COLOR_NORMAL);
                } else if (index == 7) {
                    this.mTextColorSelected = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == 8) {
                    this.mTextColorHint = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == 9) {
                    this.mTextSizeNormal = obtainStyledAttributes.getDimensionPixelSize(index, sp2px(context, 14.0f));
                } else if (index == 10) {
                    this.mTextSizeSelected = obtainStyledAttributes.getDimensionPixelSize(index, sp2px(context, 16.0f));
                } else if (index == 11) {
                    this.mTextSizeHint = obtainStyledAttributes.getDimensionPixelSize(index, sp2px(context, 14.0f));
                } else if (index == 13) {
                    this.mMinShowIndex = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == 14) {
                    this.mMaxShowIndex = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == 15) {
                    this.mWrapSelectorWheel = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 1) {
                    this.mShowDivider = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 17) {
                    this.mHintText = obtainStyledAttributes.getString(index);
                } else if (index == 27) {
                    this.mAlterHint = obtainStyledAttributes.getString(index);
                } else if (index == 18) {
                    this.mEmptyItemHint = obtainStyledAttributes.getString(index);
                } else if (index == 19) {
                    this.mMarginStartOfHint = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 8.0f));
                } else if (index == 20) {
                    this.mMarginEndOfHint = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 8.0f));
                } else if (index == 22) {
                    this.mItemPaddingVertical = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 2.0f));
                } else if (index == 21) {
                    this.mItemPaddingHorizontal = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 5.0f));
                } else if (index == 25) {
                    this.mAlterTextArrayWithMeasureHint = obtainStyledAttributes.getTextArray(index);
                } else if (index == 26) {
                    this.mAlterTextArrayWithoutMeasureHint = obtainStyledAttributes.getTextArray(index);
                } else if (index == 16) {
                    this.mRespondChangeOnDetach = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == 23) {
                    this.mRespondChangeInMainThread = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 24) {
                    this.mTextEllipsize = obtainStyledAttributes.getString(index);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void init(Context context) {
        this.mScroller = ScrollerCompat.create(context);
        this.mMiniVelocityFling = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.mTextSizeNormal == 0) {
            this.mTextSizeNormal = sp2px(context, 14.0f);
        }
        if (this.mTextSizeSelected == 0) {
            this.mTextSizeSelected = sp2px(context, 16.0f);
        }
        if (this.mTextSizeHint == 0) {
            this.mTextSizeHint = sp2px(context, 14.0f);
        }
        if (this.mMarginStartOfHint == 0) {
            this.mMarginStartOfHint = dp2px(context, 8.0f);
        }
        if (this.mMarginEndOfHint == 0) {
            this.mMarginEndOfHint = dp2px(context, 8.0f);
        }
        this.mPaintDivider.setColor(this.mDividerColor);
        this.mPaintDivider.setAntiAlias(true);
        this.mPaintDivider.setStyle(Paint.Style.STROKE);
        this.mPaintDivider.setStrokeWidth(this.mDividerHeight);
        this.mPaintText.setColor(this.mTextColorNormal);
        this.mPaintText.setAntiAlias(true);
        this.mPaintText.setTextAlign(Paint.Align.CENTER);
        this.mPaintHint.setColor(this.mTextColorHint);
        this.mPaintHint.setAntiAlias(true);
        this.mPaintHint.setTextAlign(Paint.Align.CENTER);
        this.mPaintHint.setTextSize(this.mTextSizeHint);
        if (this.mShowCount % 2 == 0) {
            this.mShowCount++;
        }
        if (this.mMinShowIndex == -1 || this.mMaxShowIndex == -1) {
            updateValueForInit();
        }
        initHandler();
    }

    private void initHandler() {
        this.mHandlerThread = new HandlerThread("HandlerThread-For-Refreshing");
        this.mHandlerThread.start();
        this.mHandlerInNewThread = new Handler(this.mHandlerThread.getLooper()) { // from class: com.fotoable.youtube.music.ui.view.NumberPickerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int willPickIndexByGlobalY;
                int i = 0;
                switch (message.what) {
                    case 1:
                        if (!NumberPickerView.this.mScroller.isFinished()) {
                            if (NumberPickerView.this.mScrollState == 0) {
                                NumberPickerView.this.onScrollStateChange(1);
                            }
                            NumberPickerView.this.mHandlerInNewThread.sendMessageDelayed(NumberPickerView.this.getMsg(1, 0, 0, message.obj), 32L);
                            return;
                        }
                        if (NumberPickerView.this.mCurrDrawFirstItemY != 0) {
                            if (NumberPickerView.this.mScrollState == 0) {
                                NumberPickerView.this.onScrollStateChange(1);
                            }
                            if (NumberPickerView.this.mCurrDrawFirstItemY < (-NumberPickerView.this.mItemHeight) / 2) {
                                int i2 = (int) (((NumberPickerView.this.mItemHeight + NumberPickerView.this.mCurrDrawFirstItemY) * 300.0f) / NumberPickerView.this.mItemHeight);
                                NumberPickerView.this.mScroller.startScroll(0, NumberPickerView.this.mCurrDrawGlobalY, 0, NumberPickerView.this.mCurrDrawFirstItemY + NumberPickerView.this.mItemHeight, i2 * 3);
                                willPickIndexByGlobalY = NumberPickerView.this.getWillPickIndexByGlobalY(NumberPickerView.this.mCurrDrawGlobalY + NumberPickerView.this.mItemHeight + NumberPickerView.this.mCurrDrawFirstItemY);
                                i = i2;
                            } else {
                                int i3 = (int) (((-NumberPickerView.this.mCurrDrawFirstItemY) * 300.0f) / NumberPickerView.this.mItemHeight);
                                NumberPickerView.this.mScroller.startScroll(0, NumberPickerView.this.mCurrDrawGlobalY, 0, NumberPickerView.this.mCurrDrawFirstItemY, i3 * 3);
                                willPickIndexByGlobalY = NumberPickerView.this.getWillPickIndexByGlobalY(NumberPickerView.this.mCurrDrawGlobalY + NumberPickerView.this.mCurrDrawFirstItemY);
                                i = i3;
                            }
                            NumberPickerView.this.postInvalidate();
                        } else {
                            NumberPickerView.this.onScrollStateChange(0);
                            willPickIndexByGlobalY = NumberPickerView.this.getWillPickIndexByGlobalY(NumberPickerView.this.mCurrDrawGlobalY);
                        }
                        Message msg = NumberPickerView.this.getMsg(2, NumberPickerView.this.mPrevPickedIndex, willPickIndexByGlobalY, message.obj);
                        if (NumberPickerView.this.mRespondChangeInMainThread) {
                            NumberPickerView.this.mHandlerInMainThread.sendMessageDelayed(msg, i * 2);
                            return;
                        } else {
                            NumberPickerView.this.mHandlerInNewThread.sendMessageDelayed(msg, i * 2);
                            return;
                        }
                    case 2:
                        NumberPickerView.this.respondPickedValueChanged(message.arg1, message.arg2, message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mHandlerInMainThread = new Handler() { // from class: com.fotoable.youtube.music.ui.view.NumberPickerView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 2:
                        NumberPickerView.this.respondPickedValueChanged(message.arg1, message.arg2, message.obj);
                        return;
                    case 3:
                        NumberPickerView.this.requestLayout();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private void respondPickedValueChangedInScrolling(int i, int i2) {
        this.mOnValueChangeListenerInScrolling.onValueChangeInScrolling(this, i, i2);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        updateMaxWHOfDisplayedValues(false);
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        super.onSizeChanged(i, i2, i3, i4);
        this.mViewWidth = i;
        this.mViewHeight = i2;
        this.mItemHeight = this.mViewHeight / this.mShowCount;
        this.mViewCenterX = ((this.mViewWidth + getPaddingLeft()) - getPaddingRight()) / 2.0f;
        if (getOneRecycleSize() <= 1) {
            i5 = 0;
        } else if (this.mHasInit) {
            i5 = getValue() - this.mMinValue;
        } else {
            i5 = this.mCurrentItemIndexEffect ? this.mCurrDrawFirstItemIndex + ((this.mShowCount - 1) / 2) : 0;
        }
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            z = true;
        }
        correctPositionByDefaultValue(i5, z);
        updateFontAttr();
        updateNotWrapYLimit();
        updateDividerAttr();
        this.mHasInit = true;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mHandlerThread == null || !this.mHandlerThread.isAlive()) {
            initHandler();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandlerThread.quit();
        if (this.mItemHeight != 0) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                this.mCurrDrawGlobalY = this.mScroller.getCurrY();
                calculateFirstItemParameterByGlobalY();
                if (this.mCurrDrawFirstItemY != 0) {
                    if (this.mCurrDrawFirstItemY < (-this.mItemHeight) / 2) {
                        this.mCurrDrawGlobalY = this.mCurrDrawGlobalY + this.mItemHeight + this.mCurrDrawFirstItemY;
                    } else {
                        this.mCurrDrawGlobalY += this.mCurrDrawFirstItemY;
                    }
                    calculateFirstItemParameterByGlobalY();
                }
                onScrollStateChange(0);
            }
            int willPickIndexByGlobalY = getWillPickIndexByGlobalY(this.mCurrDrawGlobalY);
            if (willPickIndexByGlobalY != this.mPrevPickedIndex && this.mRespondChangeOnDetach) {
                try {
                    if (this.mOnValueChangeListener != null) {
                        this.mOnValueChangeListener.onValueChange(this, this.mPrevPickedIndex + this.mMinValue, this.mMinValue + willPickIndexByGlobalY);
                    }
                    if (this.mOnValueChangeListenerRaw != null) {
                        this.mOnValueChangeListenerRaw.onValueChangeRelativeToRaw(this, this.mPrevPickedIndex, willPickIndexByGlobalY, this.mDisplayedValues);
                    }
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
            this.mPrevPickedIndex = willPickIndexByGlobalY;
        }
    }

    public int getOneRecycleSize() {
        return (this.mMaxShowIndex - this.mMinShowIndex) + 1;
    }

    public int getRawContentSize() {
        if (this.mDisplayedValues != null) {
            return this.mDisplayedValues.length;
        }
        return 0;
    }

    public void setDisplayedValuesAndPickedIndex(String[] strArr, int i, boolean z) {
        stopScrolling();
        if (strArr == null) {
            throw new IllegalArgumentException("newDisplayedValues should not be null.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("pickedIndex should not be negative, now pickedIndex is " + i);
        }
        updateContent(strArr);
        updateMaxWHOfDisplayedValues(true);
        updateNotWrapYLimit();
        updateValue();
        this.mPrevPickedIndex = this.mMinShowIndex + i;
        correctPositionByDefaultValue(i, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
        if (z) {
            this.mHandlerInNewThread.sendMessageDelayed(getMsg(1), 0L);
            postInvalidate();
        }
    }

    public void setDisplayedValues(String[] strArr, boolean z) {
        setDisplayedValuesAndPickedIndex(strArr, 0, z);
    }

    public void setDisplayedValues(String[] strArr) {
        boolean z = true;
        stopRefreshing();
        stopScrolling();
        if (strArr == null) {
            throw new IllegalArgumentException("newDisplayedValues should not be null.");
        }
        if ((this.mMaxValue - this.mMinValue) + 1 > strArr.length) {
            throw new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.mMaxValue - this.mMinValue) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
        }
        updateContent(strArr);
        updateMaxWHOfDisplayedValues(true);
        this.mPrevPickedIndex = this.mMinShowIndex + 0;
        if (!this.mWrapSelectorWheel || !this.mWrapSelectorWheelCheck) {
            z = false;
        }
        correctPositionByDefaultValue(0, z);
        postInvalidate();
        this.mHandlerInMainThread.sendEmptyMessage(3);
    }

    public String[] getDisplayedValues() {
        return this.mDisplayedValues;
    }

    public void setWrapSelectorWheel(boolean z) {
        if (this.mWrapSelectorWheel != z) {
            if (!z) {
                if (this.mScrollState == 0) {
                    internalSetWrapToLinear();
                    return;
                } else {
                    this.mPendingWrapToLinear = true;
                    return;
                }
            }
            this.mWrapSelectorWheel = z;
            updateWrapStateByContent();
            postInvalidate();
        }
    }

    public void smoothScrollToValue(int i) {
        smoothScrollToValue(getValue(), i, true);
    }

    public void smoothScrollToValue(int i, boolean z) {
        smoothScrollToValue(getValue(), i, z);
    }

    public void smoothScrollToValue(int i, int i2) {
        smoothScrollToValue(i, i2, true);
    }

    public void smoothScrollToValue(int i, int i2, boolean z) {
        int i3;
        boolean z2 = true;
        int refineValueByLimit = refineValueByLimit(i, this.mMinValue, this.mMaxValue, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
        int i4 = this.mMinValue;
        int i5 = this.mMaxValue;
        if (!this.mWrapSelectorWheel || !this.mWrapSelectorWheelCheck) {
            z2 = false;
        }
        int refineValueByLimit2 = refineValueByLimit(i2, i4, i5, z2);
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            i3 = refineValueByLimit2 - refineValueByLimit;
            int oneRecycleSize = getOneRecycleSize() / 2;
            if (i3 < (-oneRecycleSize) || oneRecycleSize < i3) {
                i3 = i3 > 0 ? i3 - getOneRecycleSize() : i3 + getOneRecycleSize();
            }
        } else {
            i3 = refineValueByLimit2 - refineValueByLimit;
        }
        setValue(refineValueByLimit);
        if (refineValueByLimit != refineValueByLimit2) {
            scrollByIndexSmoothly(i3, z);
        }
    }

    public void refreshByNewDisplayedValues(String[] strArr) {
        int minValue = getMinValue();
        int maxValue = (getMaxValue() - minValue) + 1;
        int length = strArr.length - 1;
        if ((length - minValue) + 1 > maxValue) {
            setDisplayedValues(strArr);
            setMaxValue(length);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void respondPickedValueChanged(int i, int i2, Object obj) {
        onScrollStateChange(0);
        if (i != i2 && (obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue())) {
            if (this.mOnValueChangeListener != null) {
                this.mOnValueChangeListener.onValueChange(this, this.mMinValue + i, this.mMinValue + i2);
            }
            if (this.mOnValueChangeListenerRaw != null) {
                this.mOnValueChangeListenerRaw.onValueChangeRelativeToRaw(this, i, i2, this.mDisplayedValues);
            }
        }
        this.mPrevPickedIndex = i2;
        if (this.mPendingWrapToLinear) {
            this.mPendingWrapToLinear = false;
            internalSetWrapToLinear();
        }
    }

    private void scrollByIndexSmoothly(int i) {
        scrollByIndexSmoothly(i, true);
    }

    private void scrollByIndexSmoothly(int i, boolean z) {
        int i2;
        int i3;
        if (!this.mWrapSelectorWheel || !this.mWrapSelectorWheelCheck) {
            int pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw();
            if (pickedIndexRelativeToRaw + i > this.mMaxShowIndex) {
                i = this.mMaxShowIndex - pickedIndexRelativeToRaw;
            } else if (pickedIndexRelativeToRaw + i < this.mMinShowIndex) {
                i = this.mMinShowIndex - pickedIndexRelativeToRaw;
            }
        }
        if (this.mCurrDrawFirstItemY < (-this.mItemHeight) / 2) {
            i2 = this.mItemHeight + this.mCurrDrawFirstItemY;
            int i4 = (int) (((this.mItemHeight + this.mCurrDrawFirstItemY) * 300.0f) / this.mItemHeight);
            if (i < 0) {
                i3 = (-i4) - (i * IjkMediaCodecInfo.RANK_SECURE);
            } else {
                i3 = i4 + (i * IjkMediaCodecInfo.RANK_SECURE);
            }
        } else {
            i2 = this.mCurrDrawFirstItemY;
            int i5 = (int) (((-this.mCurrDrawFirstItemY) * 300.0f) / this.mItemHeight);
            if (i < 0) {
                i3 = i5 - (i * IjkMediaCodecInfo.RANK_SECURE);
            } else {
                i3 = i5 + (i * IjkMediaCodecInfo.RANK_SECURE);
            }
        }
        int i6 = (this.mItemHeight * i) + i2;
        int i7 = i3 < 300 ? 300 : i3;
        int i8 = i7 <= 600 ? i7 : 600;
        this.mScroller.startScroll(0, this.mCurrDrawGlobalY, 0, i6, i8);
        if (z) {
            this.mHandlerInNewThread.sendMessageDelayed(getMsg(1), i8 / 4);
        } else {
            this.mHandlerInNewThread.sendMessageDelayed(getMsg(1, 0, 0, new Boolean(z)), i8 / 4);
        }
        postInvalidate();
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public void setMinValue(int i) {
        this.mMinValue = i;
        this.mMinShowIndex = 0;
        updateNotWrapYLimit();
    }

    public void setMaxValue(int i) {
        if (this.mDisplayedValues == null) {
            throw new NullPointerException("mDisplayedValues should not be null");
        }
        if ((i - this.mMinValue) + 1 > this.mDisplayedValues.length) {
            throw new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i - this.mMinValue) + 1) + " and mDisplayedValues.length is " + this.mDisplayedValues.length);
        }
        this.mMaxValue = i;
        this.mMaxShowIndex = (this.mMaxValue - this.mMinValue) + this.mMinShowIndex;
        setMinAndMaxShowIndex(this.mMinShowIndex, this.mMaxShowIndex);
        updateNotWrapYLimit();
    }

    public void setValue(int i) {
        if (i < this.mMinValue) {
            throw new IllegalArgumentException("should not set a value less than mMinValue, value is " + i);
        }
        if (i > this.mMaxValue) {
            throw new IllegalArgumentException("should not set a value greater than mMaxValue, value is " + i);
        }
        setPickedIndexRelativeToRaw(i - this.mMinValue);
    }

    public int getValue() {
        return getPickedIndexRelativeToRaw() + this.mMinValue;
    }

    public String getContentByCurrValue() {
        return this.mDisplayedValues[getValue() - this.mMinValue];
    }

    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    public boolean getWrapSelectorWheelAbsolutely() {
        return this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck;
    }

    public void setHintText(String str) {
        if (!isStringEqual(this.mHintText, str)) {
            this.mHintText = str;
            this.mTextSizeHintCenterYOffset = getTextCenterYOffset(this.mPaintHint.getFontMetrics());
            this.mWidthOfHintText = getTextWidth(this.mHintText, this.mPaintHint);
            this.mHandlerInMainThread.sendEmptyMessage(3);
        }
    }

    public void setPickedIndexRelativeToMin(int i) {
        if (i >= 0 && i < getOneRecycleSize()) {
            this.mPrevPickedIndex = this.mMinShowIndex + i;
            correctPositionByDefaultValue(i, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
            postInvalidate();
        }
    }

    public void setNormalTextColor(int i) {
        if (this.mTextColorNormal != i) {
            this.mTextColorNormal = i;
            postInvalidate();
        }
    }

    public void setSelectedTextColor(int i) {
        if (this.mTextColorSelected != i) {
            this.mTextColorSelected = i;
            postInvalidate();
        }
    }

    public void setHintTextColor(int i) {
        if (this.mTextColorHint != i) {
            this.mTextColorHint = i;
            this.mPaintHint.setColor(this.mTextColorHint);
            postInvalidate();
        }
    }

    public void setDividerColor(int i) {
        if (this.mDividerColor != i) {
            this.mDividerColor = i;
            this.mPaintDivider.setColor(this.mDividerColor);
            postInvalidate();
        }
    }

    public void setPickedIndexRelativeToRaw(int i) {
        if (this.mMinShowIndex > -1 && this.mMinShowIndex <= i && i <= this.mMaxShowIndex) {
            this.mPrevPickedIndex = i;
            correctPositionByDefaultValue(i - this.mMinShowIndex, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
            postInvalidate();
        }
    }

    public int getPickedIndexRelativeToRaw() {
        if (this.mCurrDrawFirstItemY != 0) {
            if (this.mCurrDrawFirstItemY < (-this.mItemHeight) / 2) {
                return getWillPickIndexByGlobalY(this.mCurrDrawGlobalY + this.mItemHeight + this.mCurrDrawFirstItemY);
            }
            return getWillPickIndexByGlobalY(this.mCurrDrawGlobalY + this.mCurrDrawFirstItemY);
        }
        return getWillPickIndexByGlobalY(this.mCurrDrawGlobalY);
    }

    public void setMinAndMaxShowIndex(int i, int i2) {
        setMinAndMaxShowIndex(i, i2, true);
    }

    public void setMinAndMaxShowIndex(int i, int i2, boolean z) {
        if (i > i2) {
            throw new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i + ", maxShowIndex is " + i2 + ".");
        }
        if (this.mDisplayedValues == null) {
            throw new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is " + i);
        }
        if (i > this.mDisplayedValues.length - 1) {
            throw new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.mDisplayedValues.length - 1) + " minShowIndex is " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is " + i2);
        }
        if (i2 > this.mDisplayedValues.length - 1) {
            throw new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.mDisplayedValues.length - 1) + " maxShowIndex is " + i2);
        }
        this.mMinShowIndex = i;
        this.mMaxShowIndex = i2;
        if (z) {
            this.mPrevPickedIndex = this.mMinShowIndex + 0;
            correctPositionByDefaultValue(0, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
            postInvalidate();
        }
    }

    public void setFriction(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("you should set a a positive float friction, now friction is " + f);
        }
        ViewConfiguration.get(getContext());
        this.mFriction = ViewConfiguration.getScrollFriction() / f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScrollStateChange(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mOnScrollListener != null) {
                this.mOnScrollListener.onScrollStateChange(this, i);
            }
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.mOnValueChangeListener = onValueChangeListener;
    }

    public void setOnValueChangedListenerRelativeToRaw(OnValueChangeListenerRelativeToRaw onValueChangeListenerRelativeToRaw) {
        this.mOnValueChangeListenerRaw = onValueChangeListenerRelativeToRaw;
    }

    public void setOnValueChangeListenerInScrolling(OnValueChangeListenerInScrolling onValueChangeListenerInScrolling) {
        this.mOnValueChangeListenerInScrolling = onValueChangeListenerInScrolling;
    }

    public void setContentTextTypeface(Typeface typeface) {
        this.mPaintText.setTypeface(typeface);
    }

    public void setHintTextTypeface(Typeface typeface) {
        this.mPaintHint.setTypeface(typeface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWillPickIndexByGlobalY(int i) {
        boolean z = false;
        if (this.mItemHeight == 0) {
            return 0;
        }
        int i2 = (i / this.mItemHeight) + (this.mShowCount / 2);
        int oneRecycleSize = getOneRecycleSize();
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            z = true;
        }
        int indexByRawIndex = getIndexByRawIndex(i2, oneRecycleSize, z);
        if (indexByRawIndex >= 0 && indexByRawIndex < getOneRecycleSize()) {
            return indexByRawIndex + this.mMinShowIndex;
        }
        throw new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + indexByRawIndex + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.mWrapSelectorWheel);
    }

    private int getIndexByRawIndex(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        if (z) {
            int i3 = i % i2;
            if (i3 < 0) {
                return i3 + i2;
            }
            return i3;
        }
        return i;
    }

    private void internalSetWrapToLinear() {
        correctPositionByDefaultValue(getPickedIndexRelativeToRaw() - this.mMinShowIndex, false);
        this.mWrapSelectorWheel = false;
        postInvalidate();
    }

    private void updateDividerAttr() {
        this.mDividerIndex0 = this.mShowCount / 2;
        this.mDividerIndex1 = this.mDividerIndex0 + 1;
        this.dividerY0 = (this.mDividerIndex0 * this.mViewHeight) / this.mShowCount;
        this.dividerY1 = (this.mDividerIndex1 * this.mViewHeight) / this.mShowCount;
        if (this.mDividerMarginL < 0) {
            this.mDividerMarginL = 0;
        }
        if (this.mDividerMarginR < 0) {
            this.mDividerMarginR = 0;
        }
        if (this.mDividerMarginL + this.mDividerMarginR != 0 && getPaddingLeft() + this.mDividerMarginL >= (this.mViewWidth - getPaddingRight()) - this.mDividerMarginR) {
            int paddingLeft = (((getPaddingLeft() + this.mDividerMarginL) + getPaddingRight()) + this.mDividerMarginR) - this.mViewWidth;
            this.mDividerMarginL = (int) (this.mDividerMarginL - ((paddingLeft * this.mDividerMarginL) / (this.mDividerMarginL + this.mDividerMarginR)));
            this.mDividerMarginR = (int) (this.mDividerMarginR - ((paddingLeft * this.mDividerMarginR) / (this.mDividerMarginL + this.mDividerMarginR)));
        }
    }

    private void updateFontAttr() {
        if (this.mTextSizeNormal > this.mItemHeight) {
            this.mTextSizeNormal = this.mItemHeight;
        }
        if (this.mTextSizeSelected > this.mItemHeight) {
            this.mTextSizeSelected = this.mItemHeight;
        }
        if (this.mPaintHint == null) {
            throw new IllegalArgumentException("mPaintHint should not be null.");
        }
        this.mPaintHint.setTextSize(this.mTextSizeHint);
        this.mTextSizeHintCenterYOffset = getTextCenterYOffset(this.mPaintHint.getFontMetrics());
        this.mWidthOfHintText = getTextWidth(this.mHintText, this.mPaintHint);
        if (this.mPaintText == null) {
            throw new IllegalArgumentException("mPaintText should not be null.");
        }
        this.mPaintText.setTextSize(this.mTextSizeSelected);
        this.mTextSizeSelectedCenterYOffset = getTextCenterYOffset(this.mPaintText.getFontMetrics());
        this.mPaintText.setTextSize(this.mTextSizeNormal);
        this.mTextSizeNormalCenterYOffset = getTextCenterYOffset(this.mPaintText.getFontMetrics());
    }

    private void updateNotWrapYLimit() {
        this.mNotWrapLimitYTop = 0;
        this.mNotWrapLimitYBottom = (-this.mShowCount) * this.mItemHeight;
        if (this.mDisplayedValues != null) {
            this.mNotWrapLimitYTop = ((getOneRecycleSize() - (this.mShowCount / 2)) - 1) * this.mItemHeight;
            this.mNotWrapLimitYBottom = (-(this.mShowCount / 2)) * this.mItemHeight;
        }
    }

    private int limitY(int i) {
        if (!this.mWrapSelectorWheel || !this.mWrapSelectorWheelCheck) {
            if (i < this.mNotWrapLimitYBottom) {
                return this.mNotWrapLimitYBottom;
            }
            if (i > this.mNotWrapLimitYTop) {
                return this.mNotWrapLimitYTop;
            }
            return i;
        }
        return i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mItemHeight != 0) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            this.currY = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.mFlagMayPress = true;
                    this.mHandlerInNewThread.removeMessages(1);
                    stopScrolling();
                    this.downY = this.currY;
                    this.downYGlobal = this.mCurrDrawGlobalY;
                    onScrollStateChange(0);
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                    if (this.mFlagMayPress) {
                        click(motionEvent);
                        break;
                    } else {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000);
                        int yVelocity = (int) (velocityTracker.getYVelocity() * this.mFriction);
                        if (Math.abs(yVelocity) > this.mMiniVelocityFling) {
                            this.mScroller.fling(0, this.mCurrDrawGlobalY, 0, -yVelocity, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, limitY(Integer.MIN_VALUE), limitY(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
                            invalidate();
                            onScrollStateChange(2);
                        }
                        this.mHandlerInNewThread.sendMessageDelayed(getMsg(1), 0L);
                        releaseVelocityTracker();
                        break;
                    }
                case 2:
                    float f = this.downY - this.currY;
                    if (!this.mFlagMayPress || (-this.mScaledTouchSlop) >= f || f >= this.mScaledTouchSlop) {
                        this.mFlagMayPress = false;
                        this.mCurrDrawGlobalY = limitY((int) (f + this.downYGlobal));
                        calculateFirstItemParameterByGlobalY();
                        invalidate();
                    }
                    onScrollStateChange(1);
                    break;
                case 3:
                    this.downYGlobal = this.mCurrDrawGlobalY;
                    stopScrolling();
                    this.mHandlerInNewThread.sendMessageDelayed(getMsg(1), 0L);
                    break;
            }
        }
        return true;
    }

    private void click(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        for (int i = 0; i < this.mShowCount; i++) {
            if (this.mItemHeight * i <= y && y < this.mItemHeight * (i + 1)) {
                clickItem(i);
                return;
            }
        }
    }

    private void clickItem(int i) {
        if (i >= 0 && i < this.mShowCount) {
            scrollByIndexSmoothly(i - (this.mShowCount / 2));
        }
    }

    private float getTextCenterYOffset(Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    private void correctPositionByDefaultValue(int i, boolean z) {
        this.mCurrDrawFirstItemIndex = i - ((this.mShowCount - 1) / 2);
        this.mCurrDrawFirstItemIndex = getIndexByRawIndex(this.mCurrDrawFirstItemIndex, getOneRecycleSize(), z);
        if (this.mItemHeight == 0) {
            this.mCurrentItemIndexEffect = true;
            return;
        }
        this.mCurrDrawGlobalY = this.mCurrDrawFirstItemIndex * this.mItemHeight;
        this.mInScrollingPickedOldValue = this.mCurrDrawFirstItemIndex + (this.mShowCount / 2);
        this.mInScrollingPickedOldValue %= getOneRecycleSize();
        if (this.mInScrollingPickedOldValue < 0) {
            this.mInScrollingPickedOldValue += getOneRecycleSize();
        }
        this.mInScrollingPickedNewValue = this.mInScrollingPickedOldValue;
        calculateFirstItemParameterByGlobalY();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mItemHeight != 0 && this.mScroller.computeScrollOffset()) {
            this.mCurrDrawGlobalY = this.mScroller.getCurrY();
            calculateFirstItemParameterByGlobalY();
            postInvalidate();
        }
    }

    private void calculateFirstItemParameterByGlobalY() {
        this.mCurrDrawFirstItemIndex = (int) Math.floor(this.mCurrDrawGlobalY / this.mItemHeight);
        this.mCurrDrawFirstItemY = -(this.mCurrDrawGlobalY - (this.mCurrDrawFirstItemIndex * this.mItemHeight));
        if (this.mOnValueChangeListenerInScrolling != null) {
            if ((-this.mCurrDrawFirstItemY) > this.mItemHeight / 2) {
                this.mInScrollingPickedNewValue = this.mCurrDrawFirstItemIndex + 1 + (this.mShowCount / 2);
            } else {
                this.mInScrollingPickedNewValue = this.mCurrDrawFirstItemIndex + (this.mShowCount / 2);
            }
            this.mInScrollingPickedNewValue %= getOneRecycleSize();
            if (this.mInScrollingPickedNewValue < 0) {
                this.mInScrollingPickedNewValue += getOneRecycleSize();
            }
            if (this.mInScrollingPickedOldValue != this.mInScrollingPickedNewValue) {
                respondPickedValueChangedInScrolling(this.mInScrollingPickedNewValue, this.mInScrollingPickedOldValue);
            }
            this.mInScrollingPickedOldValue = this.mInScrollingPickedNewValue;
        }
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void updateMaxWHOfDisplayedValues(boolean z) {
        updateMaxWidthOfDisplayedValues();
        updateMaxHeightOfDisplayedValues();
        if (z) {
            if (this.mSpecModeW == Integer.MIN_VALUE || this.mSpecModeH == Integer.MIN_VALUE) {
                this.mHandlerInMainThread.sendEmptyMessage(3);
            }
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        this.mSpecModeW = mode;
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int max = Math.max(this.mMaxWidthOfAlterArrayWithMeasureHint, (((Math.max(this.mWidthOfHintText, this.mWidthOfAlterHint) == 0 ? 0 : this.mMarginEndOfHint) + (Math.max(this.mWidthOfHintText, this.mWidthOfAlterHint) != 0 ? this.mMarginStartOfHint : 0) + Math.max(this.mWidthOfHintText, this.mWidthOfAlterHint) + (this.mItemPaddingHorizontal * 2)) * 2) + Math.max(this.mMaxWidthOfDisplayedValues, this.mMaxWidthOfAlterArrayWithoutMeasureHint)) + getPaddingLeft() + getPaddingRight();
        if (mode == Integer.MIN_VALUE) {
            return Math.min(max, size);
        }
        return max;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        this.mSpecModeH = mode;
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingTop = (this.mShowCount * (this.mMaxHeightOfDisplayedValues + (this.mItemPaddingVertical * 2))) + getPaddingTop() + getPaddingBottom();
            return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
        }
        return size;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawContent(canvas);
        drawLine(canvas);
        drawHint(canvas);
    }

    private void drawContent(Canvas canvas) {
        int i;
        float f;
        float f2;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < this.mShowCount + 1; i2++) {
            float f4 = this.mCurrDrawFirstItemY + (this.mItemHeight * i2);
            int indexByRawIndex = getIndexByRawIndex(this.mCurrDrawFirstItemIndex + i2, getOneRecycleSize(), this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
            if (i2 == this.mShowCount / 2) {
                float f5 = (this.mItemHeight + this.mCurrDrawFirstItemY) / this.mItemHeight;
                i = getEvaluateColor(f5, this.mTextColorNormal, this.mTextColorSelected);
                f = getEvaluateSize(f5, this.mTextSizeNormal, this.mTextSizeSelected);
                f3 = f5;
                f2 = getEvaluateSize(f5, this.mTextSizeNormalCenterYOffset, this.mTextSizeSelectedCenterYOffset);
            } else if (i2 == (this.mShowCount / 2) + 1) {
                i = getEvaluateColor(1.0f - f3, this.mTextColorNormal, this.mTextColorSelected);
                f = getEvaluateSize(1.0f - f3, this.mTextSizeNormal, this.mTextSizeSelected);
                f2 = getEvaluateSize(1.0f - f3, this.mTextSizeNormalCenterYOffset, this.mTextSizeSelectedCenterYOffset);
            } else {
                i = this.mTextColorNormal;
                f = this.mTextSizeNormal;
                f2 = this.mTextSizeNormalCenterYOffset;
            }
            this.mPaintText.setColor(i);
            this.mPaintText.setTextSize(f);
            if (indexByRawIndex >= 0 && indexByRawIndex < getOneRecycleSize()) {
                CharSequence charSequence = this.mDisplayedValues[this.mMinShowIndex + indexByRawIndex];
                if (this.mTextEllipsize != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.mPaintText, getWidth() - (this.mItemPaddingHorizontal * 2), getEllipsizeType());
                }
                canvas.drawText(charSequence.toString(), this.mViewCenterX, f2 + f4 + (this.mItemHeight / 2), this.mPaintText);
            } else if (!TextUtils.isEmpty(this.mEmptyItemHint)) {
                canvas.drawText(this.mEmptyItemHint, this.mViewCenterX, f2 + f4 + (this.mItemHeight / 2), this.mPaintText);
            }
        }
    }

    private TextUtils.TruncateAt getEllipsizeType() {
        String str = this.mTextEllipsize;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals(TEXT_ELLIPSIZE_MIDDLE)) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return TextUtils.TruncateAt.START;
            case 1:
                return TextUtils.TruncateAt.MIDDLE;
            case 2:
                return TextUtils.TruncateAt.END;
            default:
                throw new IllegalArgumentException("Illegal text ellipsize type.");
        }
    }

    private void drawLine(Canvas canvas) {
        if (this.mShowDivider) {
            canvas.drawLine(getPaddingLeft() + this.mDividerMarginL, this.dividerY0, (this.mViewWidth - getPaddingRight()) - this.mDividerMarginR, this.dividerY0, this.mPaintDivider);
            canvas.drawLine(getPaddingLeft() + this.mDividerMarginL, this.dividerY1, (this.mViewWidth - getPaddingRight()) - this.mDividerMarginR, this.dividerY1, this.mPaintDivider);
        }
    }

    private void drawHint(Canvas canvas) {
        if (!TextUtils.isEmpty(this.mHintText)) {
            canvas.drawText(this.mHintText, this.mViewCenterX + ((this.mMaxWidthOfDisplayedValues + this.mWidthOfHintText) / 2) + this.mMarginStartOfHint, ((this.dividerY0 + this.dividerY1) / 2.0f) + this.mTextSizeHintCenterYOffset, this.mPaintHint);
        }
    }

    private void updateMaxWidthOfDisplayedValues() {
        float textSize = this.mPaintText.getTextSize();
        this.mPaintText.setTextSize(this.mTextSizeSelected);
        this.mMaxWidthOfDisplayedValues = getMaxWidthOfTextArray(this.mDisplayedValues, this.mPaintText);
        this.mMaxWidthOfAlterArrayWithMeasureHint = getMaxWidthOfTextArray(this.mAlterTextArrayWithMeasureHint, this.mPaintText);
        this.mMaxWidthOfAlterArrayWithoutMeasureHint = getMaxWidthOfTextArray(this.mAlterTextArrayWithoutMeasureHint, this.mPaintText);
        this.mPaintText.setTextSize(this.mTextSizeHint);
        this.mWidthOfAlterHint = getTextWidth(this.mAlterHint, this.mPaintText);
        this.mPaintText.setTextSize(textSize);
    }

    private int getMaxWidthOfTextArray(CharSequence[] charSequenceArr, Paint paint) {
        int i = 0;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                if (charSequence != null) {
                    i = Math.max(getTextWidth(charSequence, paint), i);
                }
            }
        }
        return i;
    }

    private int getTextWidth(CharSequence charSequence, Paint paint) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        return (int) (paint.measureText(charSequence.toString()) + 0.5f);
    }

    private void updateMaxHeightOfDisplayedValues() {
        float textSize = this.mPaintText.getTextSize();
        this.mPaintText.setTextSize(this.mTextSizeSelected);
        this.mMaxHeightOfDisplayedValues = (int) ((this.mPaintText.getFontMetrics().bottom - this.mPaintText.getFontMetrics().top) + 0.5d);
        this.mPaintText.setTextSize(textSize);
    }

    private void updateContentAndIndex(String[] strArr) {
        this.mMinShowIndex = 0;
        this.mMaxShowIndex = strArr.length - 1;
        this.mDisplayedValues = strArr;
        updateWrapStateByContent();
    }

    private void updateContent(String[] strArr) {
        this.mDisplayedValues = strArr;
        updateWrapStateByContent();
    }

    private void updateValue() {
        inflateDisplayedValuesIfNull();
        updateWrapStateByContent();
        this.mMinShowIndex = 0;
        this.mMaxShowIndex = this.mDisplayedValues.length - 1;
    }

    private void updateValueForInit() {
        inflateDisplayedValuesIfNull();
        updateWrapStateByContent();
        if (this.mMinShowIndex == -1) {
            this.mMinShowIndex = 0;
        }
        if (this.mMaxShowIndex == -1) {
            this.mMaxShowIndex = this.mDisplayedValues.length - 1;
        }
        setMinAndMaxShowIndex(this.mMinShowIndex, this.mMaxShowIndex, false);
    }

    private void inflateDisplayedValuesIfNull() {
        if (this.mDisplayedValues == null) {
            this.mDisplayedValues = new String[1];
            this.mDisplayedValues[0] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    private void updateWrapStateByContent() {
        this.mWrapSelectorWheelCheck = this.mDisplayedValues.length > this.mShowCount;
    }

    private int refineValueByLimit(int i, int i2, int i3, boolean z) {
        if (z) {
            if (i > i3) {
                return (((i - i3) % getOneRecycleSize()) + i2) - 1;
            }
            if (i < i2) {
                return ((i - i2) % getOneRecycleSize()) + i3 + 1;
            }
            return i;
        }
        if (i <= i3) {
            i3 = i < i2 ? i2 : i;
        }
        return i3;
    }

    private void stopRefreshing() {
        if (this.mHandlerInNewThread != null) {
            this.mHandlerInNewThread.removeMessages(1);
        }
    }

    public void stopScrolling() {
        if (this.mScroller != null && !this.mScroller.isFinished()) {
            this.mScroller.startScroll(0, this.mScroller.getCurrY(), 0, 0, 1);
            this.mScroller.abortAnimation();
            postInvalidate();
        }
    }

    public void stopScrollingAndCorrectPosition() {
        stopScrolling();
        if (this.mHandlerInNewThread != null) {
            this.mHandlerInNewThread.sendMessageDelayed(getMsg(1), 0L);
        }
    }

    private Message getMsg(int i) {
        return getMsg(i, 0, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message getMsg(int i, int i2, int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        return obtain;
    }

    private boolean isStringEqual(String str, String str2) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        }
        return str.equals(str2);
    }

    private int sp2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }

    private int dp2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    private int getEvaluateColor(float f, int i, int i2) {
        int i3 = (i & ViewCompat.MEASURED_STATE_MASK) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        int i6 = (i & 255) >>> 0;
        return (((int) ((((((-16777216) & i2) >>> 24) - i3) * f) + i3)) << 24) | (((int) (((((16711680 & i2) >>> 16) - i4) * f) + i4)) << 16) | (((int) (((((65280 & i2) >>> 8) - i5) * f) + i5)) << 8) | ((int) (((((i2 & 255) >>> 0) - i6) * f) + i6));
    }

    private float getEvaluateSize(float f, float f2, float f3) {
        return ((f3 - f2) * f) + f2;
    }

    private String[] convertCharSequenceArrayToStringArray(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            return null;
        }
        String[] strArr = new String[charSequenceArr.length];
        for (int i = 0; i < charSequenceArr.length; i++) {
            strArr[i] = charSequenceArr[i].toString();
        }
        return strArr;
    }
}

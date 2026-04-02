package com.fotoable.youtube.music.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.util.b;
import com.fotoable.youtube.music.util.h;
/* loaded from: classes.dex */
public class FloatLockSlideView extends RelativeLayout {
    private static final int SLIDE_STATE_EXIT = 4;
    private static final int SLIDE_STATE_NEXT = 3;
    private static final int SLIDE_STATE_NONE = 1;
    private static final int SLIDE_STATE_PAUSE = 2;
    private static final String TAG = FloatLockSlideView.class.getSimpleName();
    private float defaultTx;
    private Handler handler;
    private boolean isDown;
    private OnDrawPowerModelListener onDrawPowerModelListener;
    private float point_x;
    private float point_y;
    private int slideState;
    private TextView slide_state;
    private ImageView slide_thumb;
    private TextView slide_to_exit;
    private float touch_down_x;
    private float touch_down_y;
    private ValueAnimator valueAnimator;
    private Vibrator vibrator;

    /* loaded from: classes.dex */
    public interface OnDrawPowerModelListener {
        void onDark();

        void onExit();

        void onLight();

        void onNext();
    }

    public FloatLockSlideView(Context context) {
        super(context);
        this.handler = new Handler() { // from class: com.fotoable.youtube.music.ui.view.FloatLockSlideView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1001) {
                }
            }
        };
        this.isDown = false;
        this.slideState = 1;
    }

    public FloatLockSlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler() { // from class: com.fotoable.youtube.music.ui.view.FloatLockSlideView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1001) {
                }
            }
        };
        this.isDown = false;
        this.slideState = 1;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            initView();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private void initView() {
        this.vibrator = (Vibrator) getContext().getSystemService("vibrator");
        this.slide_state = (TextView) findViewById(R.id.slide_state);
        this.slide_to_exit = (TextView) findViewById(R.id.slide_to_exit);
        this.slide_thumb = (ImageView) findViewById(R.id.slide_thumb);
        this.defaultTx = 16.0f * getResources().getDisplayMetrics().density;
        this.slide_thumb.setTranslationX(this.defaultTx);
    }

    @Override // android.view.ViewGroup
    protected void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.attachViewToParent(view, i, layoutParams);
        h.a(TAG, "显示暗屏播放");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.touch_down_x = motionEvent.getX();
            this.touch_down_y = motionEvent.getY();
            if (this.touch_down_x >= this.defaultTx && this.touch_down_x <= this.defaultTx + this.slide_thumb.getWidth()) {
                this.isDown = true;
                this.slide_to_exit.setVisibility(8);
                cleanAnim();
            }
        } else if (action == 2) {
            this.point_x = motionEvent.getX();
            this.point_y = motionEvent.getY();
            float f = (this.point_x - this.touch_down_x) + this.defaultTx;
            if (f < this.defaultTx) {
                f = this.defaultTx;
            } else if (this.slide_thumb.getWidth() + f > getResources().getDisplayMetrics().widthPixels - this.defaultTx) {
                f = (getResources().getDisplayMetrics().widthPixels - this.defaultTx) - this.slide_thumb.getWidth();
            }
            this.slide_thumb.setTranslationX(f);
            if ((this.point_x - this.touch_down_x) + this.defaultTx > (getWidth() / 3.0f) * 2.0f) {
                if (this.slideState != 4) {
                    this.slideState = 4;
                    setBackgroundColor(Color.parseColor("#ffb74d"));
                    this.slide_state.setText(R.string.exit);
                    if (this.onDrawPowerModelListener != null) {
                        this.onDrawPowerModelListener.onLight();
                    }
                    this.vibrator.vibrate(100L);
                }
            } else if ((this.point_x - this.touch_down_x) + this.defaultTx > (getWidth() / 2.0f) - (this.slide_thumb.getWidth() / 2.0f)) {
                if (this.slideState != 3) {
                    this.slide_state.setVisibility(0);
                    this.slideState = 3;
                    setBackgroundColor(Color.parseColor("#48b18e"));
                    this.slide_state.setText(R.string.next);
                    if (this.onDrawPowerModelListener != null) {
                        this.onDrawPowerModelListener.onLight();
                    }
                    this.vibrator.vibrate(100L);
                }
            } else if ((this.point_x - this.touch_down_x) + this.defaultTx > this.defaultTx + this.slide_state.getWidth()) {
                if (this.slideState != 1) {
                    this.slide_state.setVisibility(4);
                    this.slideState = 1;
                    setBackgroundColor(Color.parseColor("#546e7a"));
                }
            } else if (this.slideState != 1) {
                this.slideState = 1;
                this.slide_state.setVisibility(4);
                setBackgroundColor(Color.parseColor("#546e7a"));
            }
        } else if (action == 1) {
            this.slide_thumb.setTranslationX(this.defaultTx);
            this.isDown = false;
            this.slide_to_exit.setVisibility(0);
            this.slide_state.setVisibility(4);
            setBackgroundColor(Color.parseColor("#546e7a"));
            if (this.slideState != 2) {
                if (this.slideState == 3) {
                    b.b("SaverPlayer-SlideNext");
                    if (this.onDrawPowerModelListener != null) {
                        this.onDrawPowerModelListener.onNext();
                    }
                } else if (this.slideState == 4) {
                    if (this.onDrawPowerModelListener != null) {
                        this.onDrawPowerModelListener.onExit();
                    }
                    b.b("SaverPlayer-SlideExit");
                } else if (this.onDrawPowerModelListener != null) {
                    this.onDrawPowerModelListener.onDark();
                }
            }
            this.slideState = 1;
        }
        if (this.isDown) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setLight() {
        cleanAnim();
        this.handler.removeMessages(1001);
        this.handler.sendEmptyMessageDelayed(1001, 1000L);
    }

    private void cleanAnim() {
        if (this.valueAnimator != null) {
            this.valueAnimator.cancel();
            this.valueAnimator = null;
        }
    }

    public void removeLight() {
        this.handler.removeMessages(1001);
        cleanAnim();
    }

    public void setOnDrawPowerModelListener(OnDrawPowerModelListener onDrawPowerModelListener) {
        this.onDrawPowerModelListener = onDrawPowerModelListener;
    }
}

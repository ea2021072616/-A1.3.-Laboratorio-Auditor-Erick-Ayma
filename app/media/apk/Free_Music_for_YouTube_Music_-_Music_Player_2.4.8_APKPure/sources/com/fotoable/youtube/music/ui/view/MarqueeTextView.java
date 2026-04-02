package com.fotoable.youtube.music.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class MarqueeTextView extends LaToTextView {
    private boolean autoScroll;
    private float betweenWidth;
    private String content;
    private int gravity;
    private Handler handler;
    private boolean isBottom;
    private Paint paint;
    private int position;
    private int textColor;
    private float textHeight;
    private float textSize;
    private float textWidth;
    private int x;

    public MarqueeTextView(Context context) {
        this(context, null);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.content = "";
        this.position = 0;
        this.autoScroll = true;
        this.textColor = -1;
        this.handler = new Handler() { // from class: com.fotoable.youtube.music.ui.view.MarqueeTextView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (MarqueeTextView.this.autoScroll) {
                            MarqueeTextView.this.requestFocus();
                            MarqueeTextView.this.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.textSize = getTextSize();
        this.textColor = getCurrentTextColor();
        this.content = getText().toString();
        this.gravity = getGravity();
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setTextSize(this.textSize);
        this.paint.setColor(this.textColor);
        this.paint.setTypeface(getTypeface());
        this.betweenWidth = TypedValue.applyDimension(1, 50.0f, getResources().getDisplayMetrics());
        setSingleLine(true);
        setPadding(0, (int) (getResources().getDisplayMetrics().density * 4.0f), 0, (int) (getResources().getDisplayMetrics().density * 4.0f));
    }

    public void setBottom(boolean z) {
        this.isBottom = z;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        float height = (getHeight() / 2) + (this.textHeight / 2.0f);
        if (this.isBottom) {
            height = getHeight();
        }
        this.handler.removeMessages(1);
        if (getWidth() < this.textWidth) {
            if ((-this.x) > this.textWidth + this.betweenWidth) {
                this.x = 0;
                canvas.drawText(this.content, this.x, height, this.paint);
                canvas.drawText(this.content, this.x + this.textWidth + this.betweenWidth, height, this.paint);
                this.handler.sendEmptyMessageDelayed(1, 2000L);
                return;
            }
            canvas.drawText(this.content, this.x, height, this.paint);
            canvas.drawText(this.content, this.x + this.textWidth + this.betweenWidth, height, this.paint);
            this.x--;
            this.handler.sendEmptyMessage(1);
            return;
        }
        if (this.position == 0) {
            this.x = 0;
        } else {
            this.x = (int) ((getWidth() - this.textWidth) / 2.0f);
        }
        canvas.drawText(this.content, this.x, height, this.paint);
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setText(String str) {
        this.handler.removeMessages(1);
        this.content = str;
        this.textWidth = this.paint.measureText(str);
        Rect rect = new Rect();
        this.paint.getTextBounds(this.content, 0, this.content.length(), rect);
        this.textHeight = rect.height();
        this.x = -((int) (this.textWidth + this.betweenWidth + 2.0f));
        super.setText((CharSequence) str);
    }

    public void setAutoScroll(boolean z) {
        this.autoScroll = z;
        this.handler.sendEmptyMessageDelayed(1, 2000L);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        this.textColor = i;
        this.paint.setColor(this.textColor);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.paint.setTextSize(this.textSize);
        super.setTextSize(i);
    }
}

package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fotoable.youtube.music.util.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SimpleViewPagerIndicator extends LinearLayout {
    private int COLOR_INDICATOR_COLOR;
    private int COLOR_TEXT_NORMAL;
    private int COLOR_TEXT_SELECT;
    private int SIZE_TEXT;
    private ArrayList<TextView> arrTextViews;
    private Typeface fromAsset2;
    private Paint mPaint;
    private int mTabCount;
    private int mTabWidth;
    private String[] mTitles;
    private float mTranslationX;
    private ViewPager viewPager;

    public SimpleViewPagerIndicator(Context context) {
        this(context, null);
    }

    public SimpleViewPagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.COLOR_TEXT_NORMAL = -1;
        this.COLOR_TEXT_SELECT = SupportMenu.CATEGORY_MASK;
        this.COLOR_INDICATOR_COLOR = -16711936;
        this.SIZE_TEXT = 16;
        this.arrTextViews = new ArrayList<>();
        this.mPaint = new Paint();
        this.mPaint.setColor(this.COLOR_INDICATOR_COLOR);
        this.mPaint.setStrokeWidth(9.0f);
        this.fromAsset2 = Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Regular.ttf");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public void setTitles(String[] strArr) {
        this.mTitles = strArr;
        this.mTabCount = strArr.length;
        generateTitleView();
    }

    public void setColorTextNormal(int i) {
        this.COLOR_TEXT_NORMAL = i;
    }

    public void setColorIndicatorColor(int i) {
        this.COLOR_INDICATOR_COLOR = i;
        this.mPaint.setColor(this.COLOR_INDICATOR_COLOR);
    }

    public void setColorTextSelect(int i) {
        this.COLOR_TEXT_SELECT = i;
    }

    public void setSIZE_TEXT(int i) {
        this.SIZE_TEXT = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        canvas.translate(this.mTranslationX, getHeight() - 2);
        canvas.drawLine(0.0f, 0.0f, w.a(getContext(), 24.0f), 0.0f, this.mPaint);
        canvas.restore();
    }

    public void scroll(int i, float f) {
        this.mTranslationX = ((this.arrTextViews.get(i).getWidth() / 2) + ((i + f) * (getWidth() / this.mTabCount))) - w.a(getContext(), 12.0f);
        invalidate();
    }

    public void onPageSelected(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.arrTextViews.size()) {
                if (i3 == i) {
                    this.arrTextViews.get(i).setTextColor(this.COLOR_TEXT_SELECT);
                } else {
                    this.arrTextViews.get(i3).setTextColor(this.COLOR_TEXT_NORMAL);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    private void generateTitleView() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        int length = this.mTitles.length;
        setWeightSum(length);
        this.arrTextViews.clear();
        for (int i = 0; i < length; i++) {
            TextView textView = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            textView.setGravity(17);
            textView.setTextColor(this.COLOR_TEXT_NORMAL);
            textView.setText(this.mTitles[i] + "");
            textView.setTextSize(2, this.SIZE_TEXT);
            textView.setLayoutParams(layoutParams);
            textView.setMaxLines(1);
            textView.setTag(Integer.valueOf(i));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.view.SimpleViewPagerIndicator.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SimpleViewPagerIndicator.this.viewPager.setCurrentItem(((Integer) view.getTag()).intValue(), false);
                }
            });
            if (Build.VERSION.SDK_INT >= 11) {
                TypedValue typedValue = new TypedValue();
                getContext().getTheme().resolveAttribute(16843534, typedValue, true);
                textView.setBackgroundResource(typedValue.resourceId);
            }
            textView.setTypeface(this.fromAsset2);
            this.arrTextViews.add(textView);
            addView(textView);
        }
        this.arrTextViews.get(0).setTextColor(this.COLOR_TEXT_SELECT);
    }
}

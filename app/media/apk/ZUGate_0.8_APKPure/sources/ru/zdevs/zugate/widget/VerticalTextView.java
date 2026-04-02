package ru.zdevs.zugate.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.i1;
/* loaded from: classes.dex */
public class VerticalTextView extends i1 {
    public VerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        canvas.save();
        canvas.translate(0.0f, getHeight());
        canvas.rotate(-90.0f);
        canvas.translate(getCompoundPaddingLeft(), getExtendedPaddingTop());
        getLayout().draw(canvas);
        canvas.restore();
    }

    @Override // androidx.appcompat.widget.i1, android.widget.TextView, android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i6, i5);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }
}

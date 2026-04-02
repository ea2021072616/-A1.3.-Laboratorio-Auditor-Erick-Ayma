package androidx.preference.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import y0.e0;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class PreferenceImageView extends ImageView {

    /* renamed from: g  reason: collision with root package name */
    public int f1201g;

    /* renamed from: h  reason: collision with root package name */
    public int f1202h;

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1201g = Integer.MAX_VALUE;
        this.f1202h = Integer.MAX_VALUE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.f5614j, 0, 0);
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(3, Integer.MAX_VALUE));
        setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(2, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.f1202h;
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.f1201g;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i5);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i5 = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i6);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i6);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i6 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i5, i6);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i5) {
        this.f1202h = i5;
        super.setMaxHeight(i5);
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i5) {
        this.f1201g = i5;
        super.setMaxWidth(i5);
    }
}

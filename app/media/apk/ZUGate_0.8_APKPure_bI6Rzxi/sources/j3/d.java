package j3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.g2;
/* loaded from: classes.dex */
public abstract class d extends g2 {
    public boolean A;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f3485v;

    /* renamed from: w  reason: collision with root package name */
    public final Rect f3486w;

    /* renamed from: x  reason: collision with root package name */
    public final Rect f3487x;

    /* renamed from: y  reason: collision with root package name */
    public int f3488y;

    /* renamed from: z  reason: collision with root package name */
    public final boolean f3489z;

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3486w = new Rect();
        this.f3487x = new Rect();
        this.f3488y = 119;
        this.f3489z = true;
        this.A = false;
        TypedArray D = b4.j.D(context, attributeSet, w2.a.f5393h, 0, 0, new int[0]);
        this.f3488y = D.getInt(1, this.f3488y);
        Drawable drawable = D.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f3489z = D.getBoolean(2, true);
        D.recycle();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f3485v;
        if (drawable != null) {
            if (this.A) {
                this.A = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z4 = this.f3489z;
                Rect rect = this.f3486w;
                if (z4) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i5 = this.f3488y;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.f3487x;
                Gravity.apply(i5, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float f5, float f6) {
        super.drawableHotspotChanged(f5, f6);
        Drawable drawable = this.f3485v;
        if (drawable != null) {
            drawable.setHotspot(f5, f6);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3485v;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f3485v.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f3485v;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f3488y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3485v;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.g2, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        this.A = z4 | this.A;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.A = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f3485v;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f3485v);
            }
            this.f3485v = drawable;
            this.A = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f3488y == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i5) {
        if (this.f3488y != i5) {
            if ((8388615 & i5) == 0) {
                i5 |= 8388611;
            }
            if ((i5 & 112) == 0) {
                i5 |= 48;
            }
            this.f3488y = i5;
            if (i5 == 119 && this.f3485v != null) {
                this.f3485v.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3485v;
    }
}

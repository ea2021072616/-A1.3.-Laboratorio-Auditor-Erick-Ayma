package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.github.appintro.R;
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: g  reason: collision with root package name */
    public boolean f157g;

    /* renamed from: h  reason: collision with root package name */
    public View f158h;

    /* renamed from: i  reason: collision with root package name */
    public View f159i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f160j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f161k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f162l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f163m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f164n;
    public final int o;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f1684a);
        boolean z4 = false;
        this.f160j = obtainStyledAttributes.getDrawable(0);
        this.f161k = obtainStyledAttributes.getDrawable(2);
        this.o = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f163m = true;
            this.f162l = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.f163m ? !(this.f160j != null || this.f161k != null) : this.f162l == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f160j;
        if (drawable != null && drawable.isStateful()) {
            this.f160j.setState(getDrawableState());
        }
        Drawable drawable2 = this.f161k;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f161k.setState(getDrawableState());
        }
        Drawable drawable3 = this.f162l;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f162l.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f160j;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f161k;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f162l;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f158h = findViewById(R.id.action_bar);
        this.f159i = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f157g || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        boolean z5 = true;
        if (this.f163m) {
            Drawable drawable = this.f162l;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z5 = false;
            }
        } else {
            if (this.f160j == null) {
                z5 = false;
            } else if (this.f158h.getVisibility() == 0) {
                this.f160j.setBounds(this.f158h.getLeft(), this.f158h.getTop(), this.f158h.getRight(), this.f158h.getBottom());
            } else {
                View view = this.f159i;
                if (view == null || view.getVisibility() != 0) {
                    this.f160j.setBounds(0, 0, 0, 0);
                } else {
                    this.f160j.setBounds(this.f159i.getLeft(), this.f159i.getTop(), this.f159i.getRight(), this.f159i.getBottom());
                }
            }
            this.f164n = false;
        }
        if (z5) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        if (this.f158h == null && View.MeasureSpec.getMode(i6) == Integer.MIN_VALUE && (i7 = this.o) >= 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.min(i7, View.MeasureSpec.getSize(i6)), Integer.MIN_VALUE);
        }
        super.onMeasure(i5, i6);
        if (this.f158h == null) {
            return;
        }
        View.MeasureSpec.getMode(i6);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f160j;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f160j);
        }
        this.f160j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f158h;
            if (view != null) {
                this.f160j.setBounds(view.getLeft(), this.f158h.getTop(), this.f158h.getRight(), this.f158h.getBottom());
            }
        }
        boolean z4 = true;
        if (!this.f163m ? this.f160j != null || this.f161k != null : this.f162l != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f162l;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f162l);
        }
        this.f162l = drawable;
        boolean z4 = this.f163m;
        boolean z5 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z4 && (drawable2 = this.f162l) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z4 ? !(this.f160j != null || this.f161k != null) : this.f162l == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f161k;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f161k);
        }
        this.f161k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f164n && this.f161k != null) {
                throw null;
            }
        }
        setWillNotDraw(!this.f163m ? !(this.f160j == null && this.f161k == null) : this.f162l != null);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(y2 y2Var) {
    }

    public void setTransitioning(boolean z4) {
        this.f157g = z4;
        setDescendantFocusability(z4 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        boolean z4 = i5 == 0;
        Drawable drawable = this.f160j;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
        Drawable drawable2 = this.f161k;
        if (drawable2 != null) {
            drawable2.setVisible(z4, false);
        }
        Drawable drawable3 = this.f162l;
        if (drawable3 != null) {
            drawable3.setVisible(z4, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f160j;
        boolean z4 = this.f163m;
        return (drawable == drawable2 && !z4) || (drawable == this.f161k && this.f164n) || ((drawable == this.f162l && z4) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i5) {
        if (i5 != 0) {
            return super.startActionModeForChild(view, callback, i5);
        }
        return null;
    }
}

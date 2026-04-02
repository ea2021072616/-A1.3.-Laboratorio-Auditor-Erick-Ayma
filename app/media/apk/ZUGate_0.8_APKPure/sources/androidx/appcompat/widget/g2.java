package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public abstract class g2 extends ViewGroup {

    /* renamed from: g  reason: collision with root package name */
    public boolean f354g;

    /* renamed from: h  reason: collision with root package name */
    public int f355h;

    /* renamed from: i  reason: collision with root package name */
    public int f356i;

    /* renamed from: j  reason: collision with root package name */
    public int f357j;

    /* renamed from: k  reason: collision with root package name */
    public int f358k;

    /* renamed from: l  reason: collision with root package name */
    public int f359l;

    /* renamed from: m  reason: collision with root package name */
    public float f360m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f361n;
    public int[] o;

    /* renamed from: p  reason: collision with root package name */
    public int[] f362p;

    /* renamed from: q  reason: collision with root package name */
    public Drawable f363q;

    /* renamed from: r  reason: collision with root package name */
    public int f364r;

    /* renamed from: s  reason: collision with root package name */
    public int f365s;

    /* renamed from: t  reason: collision with root package name */
    public int f366t;

    /* renamed from: u  reason: collision with root package name */
    public int f367u;

    public g2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f354g = true;
        this.f355h = -1;
        this.f356i = 0;
        this.f358k = 8388659;
        int[] iArr = c.a.f1697n;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        z2 z2Var = new z2(context, obtainStyledAttributes);
        h0.z0.m(this, context, iArr, attributeSet, obtainStyledAttributes, 0);
        int h5 = z2Var.h(1, -1);
        if (h5 >= 0) {
            setOrientation(h5);
        }
        int h6 = z2Var.h(0, -1);
        if (h6 >= 0) {
            setGravity(h6);
        }
        boolean a5 = z2Var.a(2, true);
        if (!a5) {
            setBaselineAligned(a5);
        }
        this.f360m = obtainStyledAttributes.getFloat(4, -1.0f);
        this.f355h = z2Var.h(3, -1);
        this.f361n = z2Var.a(7, false);
        setDividerDrawable(z2Var.e(5));
        this.f366t = z2Var.h(8, 0);
        this.f367u = z2Var.d(6, 0);
        z2Var.n();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f2;
    }

    public final void d(Canvas canvas, int i5) {
        this.f363q.setBounds(getPaddingLeft() + this.f367u, i5, (getWidth() - getPaddingRight()) - this.f367u, this.f365s + i5);
        this.f363q.draw(canvas);
    }

    public final void e(Canvas canvas, int i5) {
        this.f363q.setBounds(i5, getPaddingTop() + this.f367u, this.f364r + i5, (getHeight() - getPaddingBottom()) - this.f367u);
        this.f363q.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: f */
    public f2 generateDefaultLayoutParams() {
        int i5 = this.f357j;
        if (i5 == 0) {
            return new f2(-2);
        }
        if (i5 == 1) {
            return new f2(-1);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: g */
    public f2 generateLayoutParams(AttributeSet attributeSet) {
        return new f2(getContext(), attributeSet);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i5;
        if (this.f355h < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i6 = this.f355h;
        if (childCount > i6) {
            View childAt = getChildAt(i6);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f355h == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i7 = this.f356i;
            if (this.f357j == 1 && (i5 = this.f358k & 112) != 48) {
                if (i5 == 16) {
                    i7 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f359l) / 2;
                } else if (i5 == 80) {
                    i7 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f359l;
                }
            }
            return i7 + ((LinearLayout.LayoutParams) ((f2) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f355h;
    }

    public Drawable getDividerDrawable() {
        return this.f363q;
    }

    public int getDividerPadding() {
        return this.f367u;
    }

    public int getDividerWidth() {
        return this.f364r;
    }

    public int getGravity() {
        return this.f358k;
    }

    public int getOrientation() {
        return this.f357j;
    }

    public int getShowDividers() {
        return this.f366t;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f360m;
    }

    @Override // android.view.ViewGroup
    /* renamed from: h */
    public f2 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f2 ? new f2((f2) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f2((ViewGroup.MarginLayoutParams) layoutParams) : new f2(layoutParams);
    }

    public final boolean i(int i5) {
        if (i5 == 0) {
            return (this.f366t & 1) != 0;
        } else if (i5 == getChildCount()) {
            return (this.f366t & 4) != 0;
        } else if ((this.f366t & 2) != 0) {
            for (int i6 = i5 - 1; i6 >= 0; i6--) {
                if (getChildAt(i6).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i5;
        if (this.f363q == null) {
            return;
        }
        int i6 = 0;
        if (this.f357j == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i6 < virtualChildCount) {
                View childAt = getChildAt(i6);
                if (childAt != null && childAt.getVisibility() != 8 && i(i6)) {
                    d(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((f2) childAt.getLayoutParams())).topMargin) - this.f365s);
                }
                i6++;
            }
            if (i(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                d(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f365s : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((f2) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z4 = v3.f560a;
        boolean z5 = getLayoutDirection() == 1;
        while (i6 < virtualChildCount2) {
            View childAt3 = getChildAt(i6);
            if (childAt3 != null && childAt3.getVisibility() != 8 && i(i6)) {
                f2 f2Var = (f2) childAt3.getLayoutParams();
                e(canvas, z5 ? childAt3.getRight() + ((LinearLayout.LayoutParams) f2Var).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) f2Var).leftMargin) - this.f364r);
            }
            i6++;
        }
        if (i(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                f2 f2Var2 = (f2) childAt4.getLayoutParams();
                if (z5) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) f2Var2).leftMargin;
                    i5 = this.f364r;
                    right = left - i5;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) f2Var2).rightMargin;
                }
            } else if (z5) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i5 = this.f364r;
                right = left - i5;
            }
            e(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ae  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r25, int r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g2.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x06e7  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x08a4  */
    /* JADX WARN: Removed duplicated region for block: B:448:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g2.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z4) {
        this.f354g = z4;
    }

    public void setBaselineAlignedChildIndex(int i5) {
        if (i5 >= 0 && i5 < getChildCount()) {
            this.f355h = i5;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f363q) {
            return;
        }
        this.f363q = drawable;
        if (drawable != null) {
            this.f364r = drawable.getIntrinsicWidth();
            this.f365s = drawable.getIntrinsicHeight();
        } else {
            this.f364r = 0;
            this.f365s = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i5) {
        this.f367u = i5;
    }

    public void setGravity(int i5) {
        if (this.f358k != i5) {
            if ((8388615 & i5) == 0) {
                i5 |= 8388611;
            }
            if ((i5 & 112) == 0) {
                i5 |= 48;
            }
            this.f358k = i5;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i5) {
        int i6 = i5 & 8388615;
        int i7 = this.f358k;
        if ((8388615 & i7) != i6) {
            this.f358k = i6 | ((-8388616) & i7);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z4) {
        this.f361n = z4;
    }

    public void setOrientation(int i5) {
        if (this.f357j != i5) {
            this.f357j = i5;
            requestLayout();
        }
    }

    public void setShowDividers(int i5) {
        if (i5 != this.f366t) {
            requestLayout();
        }
        this.f366t = i5;
    }

    public void setVerticalGravity(int i5) {
        int i6 = i5 & 112;
        int i7 = this.f358k;
        if ((i7 & 112) != i6) {
            this.f358k = i6 | (i7 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f5) {
        this.f360m = Math.max(0.0f, f5);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}

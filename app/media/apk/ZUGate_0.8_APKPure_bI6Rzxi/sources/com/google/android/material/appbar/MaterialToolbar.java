package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import b4.j;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import e4.e;
import h.o;
import h0.o0;
import h0.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import p2.a;
import p3.g;
/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: i0  reason: collision with root package name */
    public static final ImageView.ScaleType[] f1998i0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: d0  reason: collision with root package name */
    public Integer f1999d0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f2000e0;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f2001f0;

    /* renamed from: g0  reason: collision with root package name */
    public ImageView.ScaleType f2002g0;

    /* renamed from: h0  reason: collision with root package name */
    public Boolean f2003h0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(a.b0(context, attributeSet, R.attr.toolbarStyle, 2131952780), attributeSet, 0);
        Context context2 = getContext();
        TypedArray D = j.D(context2, attributeSet, w2.a.f5403s, R.attr.toolbarStyle, 2131952780, new int[0]);
        if (D.hasValue(2)) {
            setNavigationIconTint(D.getColor(2, -1));
        }
        this.f2000e0 = D.getBoolean(4, false);
        this.f2001f0 = D.getBoolean(3, false);
        int i5 = D.getInt(1, -1);
        if (i5 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f1998i0;
            if (i5 < scaleTypeArr.length) {
                this.f2002g0 = scaleTypeArr[i5];
            }
        }
        if (D.hasValue(0)) {
            this.f2003h0 = Boolean.valueOf(D.getBoolean(0, false));
        }
        D.recycle();
        Drawable background = getBackground();
        ColorStateList valueOf = background == null ? ColorStateList.valueOf(0) : e.n(background);
        if (valueOf != null) {
            g gVar = new g();
            gVar.j(valueOf);
            gVar.h(context2);
            WeakHashMap weakHashMap = z0.f3233a;
            gVar.i(o0.i(this));
            setBackground(gVar);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f2002g0;
    }

    public Integer getNavigationIconTint() {
        return this.f1999d0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void k(int i5) {
        Menu menu = getMenu();
        boolean z4 = menu instanceof o;
        if (z4) {
            ((o) menu).w();
        }
        super.k(i5);
        if (z4) {
            ((o) menu).v();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            a.U(this, (g) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z4, i5, i6, i7, i8);
        int i9 = 0;
        ImageView imageView2 = null;
        if (this.f2000e0 || this.f2001f0) {
            ArrayList E = i0.E(this, getTitle());
            boolean isEmpty = E.isEmpty();
            u.g gVar = i0.f1887d;
            TextView textView = isEmpty ? null : (TextView) Collections.min(E, gVar);
            ArrayList E2 = i0.E(this, getSubtitle());
            TextView textView2 = E2.isEmpty() ? null : (TextView) Collections.max(E2, gVar);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i10 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i11 = 0; i11 < getChildCount(); i11++) {
                    View childAt = getChildAt(i11);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i10 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i10 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f2000e0 && textView != null) {
                    t(textView, pair);
                }
                if (this.f2001f0 && textView2 != null) {
                    t(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i9 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i9);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i9++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.f2003h0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f2002g0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        Drawable background = getBackground();
        if (background instanceof g) {
            ((g) background).i(f5);
        }
    }

    public void setLogoAdjustViewBounds(boolean z4) {
        Boolean bool = this.f2003h0;
        if (bool == null || bool.booleanValue() != z4) {
            this.f2003h0 = Boolean.valueOf(z4);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f2002g0 != scaleType) {
            this.f2002g0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f1999d0 != null) {
            drawable = drawable.mutate();
            a0.a.g(drawable, this.f1999d0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i5) {
        this.f1999d0 = Integer.valueOf(i5);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z4) {
        if (this.f2001f0 != z4) {
            this.f2001f0 = z4;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z4) {
        if (this.f2000e0 != z4) {
            this.f2000e0 = z4;
            requestLayout();
        }
    }

    public final void t(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i5 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i6 = measuredWidth2 + i5;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i5, 0), Math.max(i6 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i5 += max;
            i6 -= max;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i6 - i5, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i5, textView.getTop(), i6, textView.getBottom());
    }
}

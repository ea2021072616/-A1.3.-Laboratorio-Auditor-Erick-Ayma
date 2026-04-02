package f1;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public final class n extends e {

    /* renamed from: p  reason: collision with root package name */
    public static final PorterDuff.Mode f2809p = PorterDuff.Mode.SRC_IN;

    /* renamed from: h  reason: collision with root package name */
    public l f2810h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffColorFilter f2811i;

    /* renamed from: j  reason: collision with root package name */
    public ColorFilter f2812j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2813k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2814l;

    /* renamed from: m  reason: collision with root package name */
    public final float[] f2815m;

    /* renamed from: n  reason: collision with root package name */
    public final Matrix f2816n;
    public final Rect o;

    public n() {
        this.f2814l = true;
        this.f2815m = new float[9];
        this.f2816n = new Matrix();
        this.o = new Rect();
        this.f2810h = new l();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            a0.a.b(drawable);
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bb, code lost:
        if ((r5 == r10.getWidth() && r6 == r9.f2801f.getHeight()) == false) goto L66;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.n.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getAlpha() : this.f2810h.f2797b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f2810h.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f2754g;
        return drawable != null ? a0.a.c(drawable) : this.f2812j;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f2754g != null) {
            return new m(this.f2754g.getConstantState());
        }
        this.f2810h.f2796a = getChangingConfigurations();
        return this.f2810h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f2810h.f2797b.f2790i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f2810h.f2797b.f2789h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.isAutoMirrored() : this.f2810h.f2800e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            l lVar = this.f2810h;
            if (lVar != null) {
                k kVar = lVar.f2797b;
                if (kVar.f2795n == null) {
                    kVar.f2795n = Boolean.valueOf(kVar.f2788g.a());
                }
                if (kVar.f2795n.booleanValue() || ((colorStateList = this.f2810h.f2798c) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2813k && super.mutate() == this) {
            this.f2810h = new l(this.f2810h);
            this.f2813k = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z4;
        PorterDuff.Mode mode;
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        l lVar = this.f2810h;
        ColorStateList colorStateList = lVar.f2798c;
        if (colorStateList == null || (mode = lVar.f2799d) == null) {
            z4 = false;
        } else {
            this.f2811i = a(colorStateList, mode);
            invalidateSelf();
            z4 = true;
        }
        k kVar = lVar.f2797b;
        if (kVar.f2795n == null) {
            kVar.f2795n = Boolean.valueOf(kVar.f2788g.a());
        }
        if (kVar.f2795n.booleanValue()) {
            boolean b5 = lVar.f2797b.f2788g.b(iArr);
            lVar.f2806k |= b5;
            if (b5) {
                invalidateSelf();
                return true;
            }
        }
        return z4;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j5) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j5);
        } else {
            super.scheduleSelf(runnable, j5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setAlpha(i5);
        } else if (this.f2810h.f2797b.getRootAlpha() != i5) {
            this.f2810h.f2797b.setRootAlpha(i5);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z4) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setAutoMirrored(z4);
        } else {
            this.f2810h.f2800e = z4;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f2812j = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i5) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            p2.a.V(drawable, i5);
        } else {
            setTintList(ColorStateList.valueOf(i5));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            a0.a.h(drawable, colorStateList);
            return;
        }
        l lVar = this.f2810h;
        if (lVar.f2798c != colorStateList) {
            lVar.f2798c = colorStateList;
            this.f2811i = a(colorStateList, lVar.f2799d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            a0.a.i(drawable, mode);
            return;
        }
        l lVar = this.f2810h;
        if (lVar.f2799d != mode) {
            lVar.f2799d = mode;
            this.f2811i = a(lVar.f2798c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        Drawable drawable = this.f2754g;
        return drawable != null ? drawable.setVisible(z4, z5) : super.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f2754g;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r23, org.xmlpull.v1.XmlPullParser r24, android.util.AttributeSet r25, android.content.res.Resources.Theme r26) {
        /*
            Method dump skipped, instructions count: 1014
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.n.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    public n(l lVar) {
        this.f2814l = true;
        this.f2815m = new float[9];
        this.f2816n = new Matrix();
        this.o = new Rect();
        this.f2810h = lVar;
        this.f2811i = a(lVar.f2798c, lVar.f2799d);
    }
}

package f3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.github.appintro.R;
import com.google.android.material.chip.Chip;
import j3.h;
import j3.i;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p3.g;
import p3.j;
import p3.l;
/* loaded from: classes.dex */
public final class f extends g implements Drawable.Callback, h {
    public static final int[] M0 = {16842910};
    public static final ShapeDrawable N0 = new ShapeDrawable(new OvalShape());
    public ColorFilter A0;
    public PorterDuffColorFilter B0;
    public ColorStateList C0;
    public ColorStateList D;
    public PorterDuff.Mode D0;
    public ColorStateList E;
    public int[] E0;
    public float F;
    public boolean F0;
    public float G;
    public ColorStateList G0;
    public ColorStateList H;
    public WeakReference H0;
    public float I;
    public TextUtils.TruncateAt I0;
    public ColorStateList J;
    public boolean J0;
    public CharSequence K;
    public int K0;
    public boolean L;
    public boolean L0;
    public Drawable M;
    public ColorStateList N;
    public float O;
    public boolean P;
    public boolean Q;
    public Drawable R;
    public RippleDrawable S;
    public ColorStateList T;
    public float U;
    public SpannableStringBuilder V;
    public boolean W;
    public boolean X;
    public Drawable Y;
    public ColorStateList Z;

    /* renamed from: a0  reason: collision with root package name */
    public x2.b f2836a0;

    /* renamed from: b0  reason: collision with root package name */
    public x2.b f2837b0;

    /* renamed from: c0  reason: collision with root package name */
    public float f2838c0;

    /* renamed from: d0  reason: collision with root package name */
    public float f2839d0;

    /* renamed from: e0  reason: collision with root package name */
    public float f2840e0;

    /* renamed from: f0  reason: collision with root package name */
    public float f2841f0;

    /* renamed from: g0  reason: collision with root package name */
    public float f2842g0;

    /* renamed from: h0  reason: collision with root package name */
    public float f2843h0;

    /* renamed from: i0  reason: collision with root package name */
    public float f2844i0;

    /* renamed from: j0  reason: collision with root package name */
    public float f2845j0;

    /* renamed from: k0  reason: collision with root package name */
    public final Context f2846k0;

    /* renamed from: l0  reason: collision with root package name */
    public final Paint f2847l0;

    /* renamed from: m0  reason: collision with root package name */
    public final Paint.FontMetrics f2848m0;

    /* renamed from: n0  reason: collision with root package name */
    public final RectF f2849n0;

    /* renamed from: o0  reason: collision with root package name */
    public final PointF f2850o0;

    /* renamed from: p0  reason: collision with root package name */
    public final Path f2851p0;

    /* renamed from: q0  reason: collision with root package name */
    public final i f2852q0;

    /* renamed from: r0  reason: collision with root package name */
    public int f2853r0;

    /* renamed from: s0  reason: collision with root package name */
    public int f2854s0;

    /* renamed from: t0  reason: collision with root package name */
    public int f2855t0;

    /* renamed from: u0  reason: collision with root package name */
    public int f2856u0;

    /* renamed from: v0  reason: collision with root package name */
    public int f2857v0;

    /* renamed from: w0  reason: collision with root package name */
    public int f2858w0;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f2859x0;

    /* renamed from: y0  reason: collision with root package name */
    public int f2860y0;

    /* renamed from: z0  reason: collision with root package name */
    public int f2861z0;

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.chipStyle, 2131952694);
        this.G = -1.0f;
        this.f2847l0 = new Paint(1);
        this.f2848m0 = new Paint.FontMetrics();
        this.f2849n0 = new RectF();
        this.f2850o0 = new PointF();
        this.f2851p0 = new Path();
        this.f2861z0 = 255;
        this.D0 = PorterDuff.Mode.SRC_IN;
        this.H0 = new WeakReference(null);
        h(context);
        this.f2846k0 = context;
        i iVar = new i(this);
        this.f2852q0 = iVar;
        this.K = "";
        iVar.f3502a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = M0;
        setState(iArr);
        if (!Arrays.equals(this.E0, iArr)) {
            this.E0 = iArr;
            if (T()) {
                v(getState(), iArr);
            }
        }
        this.J0 = true;
        int[] iArr2 = n3.a.f4089a;
        N0.setTint(-1);
    }

    public static void U(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean s(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean t(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(float f5) {
        if (this.G != f5) {
            this.G = f5;
            j jVar = this.f4294g.f4274a;
            jVar.getClass();
            w1.h hVar = new w1.h(jVar);
            hVar.f5338e = new p3.a(f5);
            hVar.f5339f = new p3.a(f5);
            hVar.f5340g = new p3.a(f5);
            hVar.f5341h = new p3.a(f5);
            setShapeAppearanceModel(new j(hVar));
        }
    }

    public final void B(Drawable drawable) {
        Drawable drawable2 = this.M;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof a0.g) {
            ((a0.h) ((a0.g) drawable2)).getClass();
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float p5 = p();
            this.M = drawable != null ? drawable.mutate() : null;
            float p6 = p();
            U(drawable2);
            if (S()) {
                n(this.M);
            }
            invalidateSelf();
            if (p5 != p6) {
                u();
            }
        }
    }

    public final void C(float f5) {
        if (this.O != f5) {
            float p5 = p();
            this.O = f5;
            float p6 = p();
            invalidateSelf();
            if (p5 != p6) {
                u();
            }
        }
    }

    public final void D(ColorStateList colorStateList) {
        this.P = true;
        if (this.N != colorStateList) {
            this.N = colorStateList;
            if (S()) {
                a0.a.h(this.M, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void E(boolean z4) {
        if (this.L != z4) {
            boolean S = S();
            this.L = z4;
            boolean S2 = S();
            if (S != S2) {
                if (S2) {
                    n(this.M);
                } else {
                    U(this.M);
                }
                invalidateSelf();
                u();
            }
        }
    }

    public final void F(ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            if (this.L0) {
                p3.f fVar = this.f4294g;
                if (fVar.f4277d != colorStateList) {
                    fVar.f4277d = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void G(float f5) {
        if (this.I != f5) {
            this.I = f5;
            this.f2847l0.setStrokeWidth(f5);
            if (this.L0) {
                this.f4294g.f4284k = f5;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void H(Drawable drawable) {
        Drawable drawable2 = this.R;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof a0.g) {
            ((a0.h) ((a0.g) drawable2)).getClass();
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float q5 = q();
            this.R = drawable != null ? drawable.mutate() : null;
            int[] iArr = n3.a.f4089a;
            this.S = new RippleDrawable(n3.a.a(this.J), this.R, N0);
            float q6 = q();
            U(drawable2);
            if (T()) {
                n(this.R);
            }
            invalidateSelf();
            if (q5 != q6) {
                u();
            }
        }
    }

    public final void I(float f5) {
        if (this.f2844i0 != f5) {
            this.f2844i0 = f5;
            invalidateSelf();
            if (T()) {
                u();
            }
        }
    }

    public final void J(float f5) {
        if (this.U != f5) {
            this.U = f5;
            invalidateSelf();
            if (T()) {
                u();
            }
        }
    }

    public final void K(float f5) {
        if (this.f2843h0 != f5) {
            this.f2843h0 = f5;
            invalidateSelf();
            if (T()) {
                u();
            }
        }
    }

    public final void L(ColorStateList colorStateList) {
        if (this.T != colorStateList) {
            this.T = colorStateList;
            if (T()) {
                a0.a.h(this.R, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void M(boolean z4) {
        if (this.Q != z4) {
            boolean T = T();
            this.Q = z4;
            boolean T2 = T();
            if (T != T2) {
                if (T2) {
                    n(this.R);
                } else {
                    U(this.R);
                }
                invalidateSelf();
                u();
            }
        }
    }

    public final void N(float f5) {
        if (this.f2840e0 != f5) {
            float p5 = p();
            this.f2840e0 = f5;
            float p6 = p();
            invalidateSelf();
            if (p5 != p6) {
                u();
            }
        }
    }

    public final void O(float f5) {
        if (this.f2839d0 != f5) {
            float p5 = p();
            this.f2839d0 = f5;
            float p6 = p();
            invalidateSelf();
            if (p5 != p6) {
                u();
            }
        }
    }

    public final void P(ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            this.G0 = this.F0 ? n3.a.a(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public final void Q(m3.d dVar) {
        i iVar = this.f2852q0;
        if (iVar.f3507f != dVar) {
            iVar.f3507f = dVar;
            if (dVar != null) {
                TextPaint textPaint = iVar.f3502a;
                Context context = this.f2846k0;
                b bVar = iVar.f3503b;
                dVar.f(context, textPaint, bVar);
                h hVar = (h) iVar.f3506e.get();
                if (hVar != null) {
                    textPaint.drawableState = hVar.getState();
                }
                dVar.e(context, textPaint, bVar);
                iVar.f3505d = true;
            }
            h hVar2 = (h) iVar.f3506e.get();
            if (hVar2 != null) {
                f fVar = (f) hVar2;
                fVar.u();
                fVar.invalidateSelf();
                fVar.onStateChange(hVar2.getState());
            }
        }
    }

    public final boolean R() {
        return this.X && this.Y != null && this.f2859x0;
    }

    public final boolean S() {
        return this.L && this.M != null;
    }

    public final boolean T() {
        return this.Q && this.R != null;
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i5;
        RectF rectF;
        int i6;
        int i7;
        int i8;
        RectF rectF2;
        int i9;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i5 = this.f2861z0) == 0) {
            return;
        }
        int saveLayerAlpha = i5 < 255 ? canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i5) : 0;
        boolean z4 = this.L0;
        Paint paint = this.f2847l0;
        RectF rectF3 = this.f2849n0;
        if (!z4) {
            paint.setColor(this.f2853r0);
            paint.setStyle(Paint.Style.FILL);
            rectF3.set(bounds);
            canvas.drawRoundRect(rectF3, r(), r(), paint);
        }
        if (!this.L0) {
            paint.setColor(this.f2854s0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.A0;
            if (colorFilter == null) {
                colorFilter = this.B0;
            }
            paint.setColorFilter(colorFilter);
            rectF3.set(bounds);
            canvas.drawRoundRect(rectF3, r(), r(), paint);
        }
        if (this.L0) {
            super.draw(canvas);
        }
        if (this.I > 0.0f && !this.L0) {
            paint.setColor(this.f2856u0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.L0) {
                ColorFilter colorFilter2 = this.A0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.B0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f5 = this.I / 2.0f;
            rectF3.set(bounds.left + f5, bounds.top + f5, bounds.right - f5, bounds.bottom - f5);
            float f6 = this.G - (this.I / 2.0f);
            canvas.drawRoundRect(rectF3, f6, f6, paint);
        }
        paint.setColor(this.f2857v0);
        paint.setStyle(Paint.Style.FILL);
        rectF3.set(bounds);
        if (this.L0) {
            RectF rectF4 = new RectF(bounds);
            Path path = this.f2851p0;
            l lVar = this.f4310x;
            p3.f fVar = this.f4294g;
            lVar.a(fVar.f4274a, fVar.f4283j, rectF4, this.f4309w, path);
            e(canvas, paint, path, this.f4294g.f4274a, g());
        } else {
            canvas.drawRoundRect(rectF3, r(), r(), paint);
        }
        if (S()) {
            o(bounds, rectF3);
            float f7 = rectF3.left;
            float f8 = rectF3.top;
            canvas.translate(f7, f8);
            this.M.setBounds(0, 0, (int) rectF3.width(), (int) rectF3.height());
            this.M.draw(canvas);
            canvas.translate(-f7, -f8);
        }
        if (R()) {
            o(bounds, rectF3);
            float f9 = rectF3.left;
            float f10 = rectF3.top;
            canvas.translate(f9, f10);
            this.Y.setBounds(0, 0, (int) rectF3.width(), (int) rectF3.height());
            this.Y.draw(canvas);
            canvas.translate(-f9, -f10);
        }
        if (!this.J0 || this.K == null) {
            rectF = rectF3;
            i6 = saveLayerAlpha;
            i7 = 0;
            i8 = 255;
        } else {
            PointF pointF = this.f2850o0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.K;
            i iVar = this.f2852q0;
            if (charSequence != null) {
                float p5 = p() + this.f2838c0 + this.f2841f0;
                if (a0.b.a(this) == 0) {
                    pointF.x = bounds.left + p5;
                    align = Paint.Align.LEFT;
                } else {
                    pointF.x = bounds.right - p5;
                    align = Paint.Align.RIGHT;
                }
                TextPaint textPaint = iVar.f3502a;
                Paint.FontMetrics fontMetrics = this.f2848m0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = bounds.centerY() - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF3.setEmpty();
            if (this.K != null) {
                float p6 = p() + this.f2838c0 + this.f2841f0;
                float q5 = q() + this.f2845j0 + this.f2842g0;
                if (a0.b.a(this) == 0) {
                    rectF3.left = bounds.left + p6;
                    rectF3.right = bounds.right - q5;
                } else {
                    rectF3.left = bounds.left + q5;
                    rectF3.right = bounds.right - p6;
                }
                rectF3.top = bounds.top;
                rectF3.bottom = bounds.bottom;
            }
            m3.d dVar = iVar.f3507f;
            TextPaint textPaint2 = iVar.f3502a;
            if (dVar != null) {
                textPaint2.drawableState = getState();
                iVar.f3507f.e(this.f2846k0, textPaint2, iVar.f3503b);
            }
            textPaint2.setTextAlign(align);
            boolean z5 = Math.round(iVar.a(this.K.toString())) > Math.round(rectF3.width());
            if (z5) {
                i9 = canvas.save();
                canvas.clipRect(rectF3);
            } else {
                i9 = 0;
            }
            CharSequence charSequence2 = this.K;
            if (z5 && this.I0 != null) {
                charSequence2 = TextUtils.ellipsize(charSequence2, textPaint2, rectF3.width(), this.I0);
            }
            CharSequence charSequence3 = charSequence2;
            int length = charSequence3.length();
            float f11 = pointF.x;
            float f12 = pointF.y;
            rectF = rectF3;
            i6 = saveLayerAlpha;
            i7 = 0;
            i8 = 255;
            canvas.drawText(charSequence3, 0, length, f11, f12, textPaint2);
            if (z5) {
                canvas.restoreToCount(i9);
            }
        }
        if (T()) {
            rectF.setEmpty();
            if (T()) {
                float f13 = this.f2845j0 + this.f2844i0;
                if (a0.b.a(this) == 0) {
                    float f14 = bounds.right - f13;
                    rectF2 = rectF;
                    rectF2.right = f14;
                    rectF2.left = f14 - this.U;
                } else {
                    rectF2 = rectF;
                    float f15 = bounds.left + f13;
                    rectF2.left = f15;
                    rectF2.right = f15 + this.U;
                }
                float exactCenterY = bounds.exactCenterY();
                float f16 = this.U;
                float f17 = exactCenterY - (f16 / 2.0f);
                rectF2.top = f17;
                rectF2.bottom = f17 + f16;
            } else {
                rectF2 = rectF;
            }
            float f18 = rectF2.left;
            float f19 = rectF2.top;
            canvas.translate(f18, f19);
            this.R.setBounds(i7, i7, (int) rectF2.width(), (int) rectF2.height());
            int[] iArr = n3.a.f4089a;
            this.S.setBounds(this.R.getBounds());
            this.S.jumpToCurrentState();
            this.S.draw(canvas);
            canvas.translate(-f18, -f19);
        }
        if (this.f2861z0 < i8) {
            canvas.restoreToCount(i6);
        }
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f2861z0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.A0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.F;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(q() + this.f2852q0.a(this.K.toString()) + p() + this.f2838c0 + this.f2841f0 + this.f2842g0 + this.f2845j0), this.K0);
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        if (this.L0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.F, this.G);
        } else {
            outline.setRoundRect(bounds, this.G);
        }
        outline.setAlpha(this.f2861z0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (s(this.D) || s(this.E) || s(this.H)) {
            return true;
        }
        if (this.F0 && s(this.G0)) {
            return true;
        }
        m3.d dVar = this.f2852q0.f3507f;
        if ((dVar == null || (colorStateList = dVar.f3981j) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        return (this.X && this.Y != null && this.W) || t(this.M) || t(this.Y) || s(this.C0);
    }

    public final void n(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        a0.b.b(drawable, a0.b.a(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.R) {
            if (drawable.isStateful()) {
                drawable.setState(this.E0);
            }
            a0.a.h(drawable, this.T);
            return;
        }
        Drawable drawable2 = this.M;
        if (drawable == drawable2 && this.P) {
            a0.a.h(drawable2, this.N);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void o(Rect rect, RectF rectF) {
        float f5;
        rectF.setEmpty();
        if (S() || R()) {
            float f6 = this.f2838c0 + this.f2839d0;
            Drawable drawable = this.f2859x0 ? this.Y : this.M;
            float f7 = this.O;
            if (f7 <= 0.0f && drawable != null) {
                f7 = drawable.getIntrinsicWidth();
            }
            if (a0.b.a(this) == 0) {
                float f8 = rect.left + f6;
                rectF.left = f8;
                rectF.right = f8 + f7;
            } else {
                float f9 = rect.right - f6;
                rectF.right = f9;
                rectF.left = f9 - f7;
            }
            Drawable drawable2 = this.f2859x0 ? this.Y : this.M;
            float f10 = this.O;
            if (f10 <= 0.0f && drawable2 != null) {
                f10 = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f2846k0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= f10) {
                    f5 = drawable2.getIntrinsicHeight();
                    float exactCenterY = rect.exactCenterY() - (f5 / 2.0f);
                    rectF.top = exactCenterY;
                    rectF.bottom = exactCenterY + f5;
                }
            }
            f5 = f10;
            float exactCenterY2 = rect.exactCenterY() - (f5 / 2.0f);
            rectF.top = exactCenterY2;
            rectF.bottom = exactCenterY2 + f5;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i5) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i5);
        if (S()) {
            onLayoutDirectionChanged |= a0.b.b(this.M, i5);
        }
        if (R()) {
            onLayoutDirectionChanged |= a0.b.b(this.Y, i5);
        }
        if (T()) {
            onLayoutDirectionChanged |= a0.b.b(this.R, i5);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i5) {
        boolean onLevelChange = super.onLevelChange(i5);
        if (S()) {
            onLevelChange |= this.M.setLevel(i5);
        }
        if (R()) {
            onLevelChange |= this.Y.setLevel(i5);
        }
        if (T()) {
            onLevelChange |= this.R.setLevel(i5);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.L0) {
            super.onStateChange(iArr);
        }
        return v(iArr, this.E0);
    }

    public final float p() {
        if (S() || R()) {
            float f5 = this.f2839d0;
            Drawable drawable = this.f2859x0 ? this.Y : this.M;
            float f6 = this.O;
            if (f6 <= 0.0f && drawable != null) {
                f6 = drawable.getIntrinsicWidth();
            }
            return f6 + f5 + this.f2840e0;
        }
        return 0.0f;
    }

    public final float q() {
        if (T()) {
            return this.f2843h0 + this.U + this.f2844i0;
        }
        return 0.0f;
    }

    public final float r() {
        return this.L0 ? this.f4294g.f4274a.f4318e.a(g()) : this.G;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j5);
        }
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        if (this.f2861z0 != i5) {
            this.f2861z0 = i5;
            invalidateSelf();
        }
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.A0 != colorFilter) {
            this.A0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.C0 != colorStateList) {
            this.C0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // p3.g, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.D0 != mode) {
            this.D0 = mode;
            ColorStateList colorStateList = this.C0;
            this.B0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        boolean visible = super.setVisible(z4, z5);
        if (S()) {
            visible |= this.M.setVisible(z4, z5);
        }
        if (R()) {
            visible |= this.Y.setVisible(z4, z5);
        }
        if (T()) {
            visible |= this.R.setVisible(z4, z5);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void u() {
        e eVar = (e) this.H0.get();
        if (eVar != null) {
            Chip chip = (Chip) eVar;
            chip.b(chip.f2089v);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final boolean v(int[] iArr, int[] iArr2) {
        boolean z4;
        boolean z5;
        ColorStateList colorStateList;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.D;
        int c5 = c(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f2853r0) : 0);
        boolean z6 = true;
        if (this.f2853r0 != c5) {
            this.f2853r0 = c5;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.E;
        int c6 = c(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f2854s0) : 0);
        if (this.f2854s0 != c6) {
            this.f2854s0 = c6;
            onStateChange = true;
        }
        int b5 = z.a.b(c6, c5);
        if ((this.f2855t0 != b5) | (this.f4294g.f4276c == null)) {
            this.f2855t0 = b5;
            j(ColorStateList.valueOf(b5));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.H;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f2856u0) : 0;
        if (this.f2856u0 != colorForState) {
            this.f2856u0 = colorForState;
            onStateChange = true;
        }
        int colorForState2 = (this.G0 == null || !n3.a.b(iArr)) ? 0 : this.G0.getColorForState(iArr, this.f2857v0);
        if (this.f2857v0 != colorForState2) {
            this.f2857v0 = colorForState2;
            if (this.F0) {
                onStateChange = true;
            }
        }
        m3.d dVar = this.f2852q0.f3507f;
        int colorForState3 = (dVar == null || (colorStateList = dVar.f3981j) == null) ? 0 : colorStateList.getColorForState(iArr, this.f2858w0);
        if (this.f2858w0 != colorForState3) {
            this.f2858w0 = colorForState3;
            onStateChange = true;
        }
        int[] state = getState();
        if (state != null) {
            for (int i5 : state) {
                if (i5 == 16842912) {
                    z4 = true;
                    break;
                }
            }
        }
        z4 = false;
        boolean z7 = z4 && this.W;
        if (this.f2859x0 == z7 || this.Y == null) {
            z5 = false;
        } else {
            float p5 = p();
            this.f2859x0 = z7;
            if (p5 != p()) {
                onStateChange = true;
                z5 = true;
            } else {
                z5 = false;
                onStateChange = true;
            }
        }
        ColorStateList colorStateList5 = this.C0;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.f2860y0) : 0;
        if (this.f2860y0 != colorForState4) {
            this.f2860y0 = colorForState4;
            ColorStateList colorStateList6 = this.C0;
            PorterDuff.Mode mode = this.D0;
            this.B0 = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            z6 = onStateChange;
        }
        if (t(this.M)) {
            z6 |= this.M.setState(iArr);
        }
        if (t(this.Y)) {
            z6 |= this.Y.setState(iArr);
        }
        if (t(this.R)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z6 |= this.R.setState(iArr3);
        }
        int[] iArr4 = n3.a.f4089a;
        if (t(this.S)) {
            z6 |= this.S.setState(iArr2);
        }
        if (z6) {
            invalidateSelf();
        }
        if (z5) {
            u();
        }
        return z6;
    }

    public final void w(boolean z4) {
        if (this.W != z4) {
            this.W = z4;
            float p5 = p();
            if (!z4 && this.f2859x0) {
                this.f2859x0 = false;
            }
            float p6 = p();
            invalidateSelf();
            if (p5 != p6) {
                u();
            }
        }
    }

    public final void x(Drawable drawable) {
        if (this.Y != drawable) {
            float p5 = p();
            this.Y = drawable;
            float p6 = p();
            U(this.Y);
            n(this.Y);
            invalidateSelf();
            if (p5 != p6) {
                u();
            }
        }
    }

    public final void y(ColorStateList colorStateList) {
        if (this.Z != colorStateList) {
            this.Z = colorStateList;
            if (this.X && this.Y != null && this.W) {
                a0.a.h(this.Y, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void z(boolean z4) {
        if (this.X != z4) {
            boolean R = R();
            this.X = z4;
            boolean R2 = R();
            if (R != R2) {
                if (R2) {
                    n(this.Y);
                } else {
                    U(this.Y);
                }
                invalidateSelf();
                u();
            }
        }
    }
}

package j3;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class b {
    public CharSequence A;
    public CharSequence B;
    public boolean C;
    public Bitmap E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public int[] L;
    public boolean M;
    public final TextPaint N;
    public final TextPaint O;
    public TimeInterpolator P;
    public TimeInterpolator Q;
    public float R;
    public float S;
    public float T;
    public ColorStateList U;
    public float V;
    public float W;
    public float X;
    public StaticLayout Y;
    public float Z;

    /* renamed from: a  reason: collision with root package name */
    public final View f3452a;

    /* renamed from: a0  reason: collision with root package name */
    public float f3453a0;

    /* renamed from: b  reason: collision with root package name */
    public float f3454b;

    /* renamed from: b0  reason: collision with root package name */
    public float f3455b0;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f3456c;

    /* renamed from: c0  reason: collision with root package name */
    public CharSequence f3457c0;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f3458d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f3460e;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f3467j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f3468k;

    /* renamed from: l  reason: collision with root package name */
    public float f3469l;

    /* renamed from: m  reason: collision with root package name */
    public float f3470m;

    /* renamed from: n  reason: collision with root package name */
    public float f3471n;
    public float o;

    /* renamed from: p  reason: collision with root package name */
    public float f3472p;

    /* renamed from: q  reason: collision with root package name */
    public float f3473q;

    /* renamed from: r  reason: collision with root package name */
    public Typeface f3474r;

    /* renamed from: s  reason: collision with root package name */
    public Typeface f3475s;

    /* renamed from: t  reason: collision with root package name */
    public Typeface f3476t;

    /* renamed from: u  reason: collision with root package name */
    public Typeface f3477u;

    /* renamed from: v  reason: collision with root package name */
    public Typeface f3478v;

    /* renamed from: w  reason: collision with root package name */
    public Typeface f3479w;

    /* renamed from: x  reason: collision with root package name */
    public Typeface f3480x;

    /* renamed from: y  reason: collision with root package name */
    public m3.a f3481y;

    /* renamed from: f  reason: collision with root package name */
    public int f3462f = 16;

    /* renamed from: g  reason: collision with root package name */
    public int f3464g = 16;

    /* renamed from: h  reason: collision with root package name */
    public float f3465h = 15.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f3466i = 15.0f;

    /* renamed from: z  reason: collision with root package name */
    public final TextUtils.TruncateAt f3482z = TextUtils.TruncateAt.END;
    public final boolean D = true;

    /* renamed from: d0  reason: collision with root package name */
    public final int f3459d0 = 1;

    /* renamed from: e0  reason: collision with root package name */
    public final float f3461e0 = 1.0f;

    /* renamed from: f0  reason: collision with root package name */
    public final int f3463f0 = 1;

    public b(View view) {
        this.f3452a = view;
        TextPaint textPaint = new TextPaint(129);
        this.N = textPaint;
        this.O = new TextPaint(textPaint);
        this.f3458d = new Rect();
        this.f3456c = new Rect();
        this.f3460e = new RectF();
        g(view.getContext().getResources().getConfiguration());
    }

    public static int a(int i5, float f5, int i6) {
        float f6 = 1.0f - f5;
        return Color.argb(Math.round((Color.alpha(i6) * f5) + (Color.alpha(i5) * f6)), Math.round((Color.red(i6) * f5) + (Color.red(i5) * f6)), Math.round((Color.green(i6) * f5) + (Color.green(i5) * f6)), Math.round((Color.blue(i6) * f5) + (Color.blue(i5) * f6)));
    }

    public static float f(float f5, float f6, float f7, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f7 = timeInterpolator.getInterpolation(f7);
        }
        LinearInterpolator linearInterpolator = x2.a.f5484a;
        return ((f6 - f5) * f7) + f5;
    }

    public final boolean b(CharSequence charSequence) {
        WeakHashMap weakHashMap = z0.f3233a;
        boolean z4 = this.f3452a.getLayoutDirection() == 1;
        if (this.D) {
            return (z4 ? f0.i.f2742d : f0.i.f2741c).b(charSequence, charSequence.length());
        }
        return z4;
    }

    public final void c(float f5, boolean z4) {
        float f6;
        float f7;
        Typeface typeface;
        boolean z5;
        StaticLayout staticLayout;
        Layout.Alignment alignment;
        if (this.A == null) {
            return;
        }
        float width = this.f3458d.width();
        float width2 = this.f3456c.width();
        if (Math.abs(f5 - 1.0f) < 1.0E-5f) {
            f6 = this.f3466i;
            f7 = this.V;
            this.F = 1.0f;
            typeface = this.f3474r;
        } else {
            float f8 = this.f3465h;
            float f9 = this.W;
            Typeface typeface2 = this.f3477u;
            if (Math.abs(f5 - 0.0f) < 1.0E-5f) {
                this.F = 1.0f;
            } else {
                this.F = f(this.f3465h, this.f3466i, f5, this.Q) / this.f3465h;
            }
            float f10 = this.f3466i / this.f3465h;
            width = (z4 || width2 * f10 <= width) ? width2 : Math.min(width / f10, width2);
            f6 = f8;
            f7 = f9;
            typeface = typeface2;
        }
        int i5 = (width > 0.0f ? 1 : (width == 0.0f ? 0 : -1));
        TextPaint textPaint = this.N;
        if (i5 > 0) {
            boolean z6 = this.G != f6;
            boolean z7 = this.X != f7;
            boolean z8 = this.f3480x != typeface;
            StaticLayout staticLayout2 = this.Y;
            boolean z9 = z6 || z7 || (staticLayout2 != null && (width > ((float) staticLayout2.getWidth()) ? 1 : (width == ((float) staticLayout2.getWidth()) ? 0 : -1)) != 0) || z8 || this.M;
            this.G = f6;
            this.X = f7;
            this.f3480x = typeface;
            this.M = false;
            textPaint.setLinearText(this.F != 1.0f);
            z5 = z9;
        } else {
            z5 = false;
        }
        if (this.B == null || z5) {
            textPaint.setTextSize(this.G);
            textPaint.setTypeface(this.f3480x);
            textPaint.setLetterSpacing(this.X);
            boolean b5 = b(this.A);
            this.C = b5;
            int i6 = this.f3459d0;
            if (!(i6 > 1 && !b5)) {
                i6 = 1;
            }
            try {
                if (i6 == 1) {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                } else {
                    int absoluteGravity = Gravity.getAbsoluteGravity(this.f3462f, b5 ? 1 : 0) & 7;
                    alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.C ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.C ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
                }
                g gVar = new g(this.A, textPaint, (int) width);
                gVar.f3501l = this.f3482z;
                gVar.f3500k = b5;
                gVar.f3494e = alignment;
                gVar.f3499j = false;
                gVar.f3495f = i6;
                float f11 = this.f3461e0;
                gVar.f3496g = 0.0f;
                gVar.f3497h = f11;
                gVar.f3498i = this.f3463f0;
                staticLayout = gVar.a();
            } catch (f e5) {
                Log.e("CollapsingTextHelper", e5.getCause().getMessage(), e5);
                staticLayout = null;
            }
            staticLayout.getClass();
            this.Y = staticLayout;
            this.B = staticLayout.getText();
        }
    }

    public final float d() {
        TextPaint textPaint = this.O;
        textPaint.setTextSize(this.f3466i);
        textPaint.setTypeface(this.f3474r);
        textPaint.setLetterSpacing(this.V);
        return -textPaint.ascent();
    }

    public final int e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.L;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void g(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f3476t;
            if (typeface != null) {
                this.f3475s = e4.e.D(configuration, typeface);
            }
            Typeface typeface2 = this.f3479w;
            if (typeface2 != null) {
                this.f3478v = e4.e.D(configuration, typeface2);
            }
            Typeface typeface3 = this.f3475s;
            if (typeface3 == null) {
                typeface3 = this.f3476t;
            }
            this.f3474r = typeface3;
            Typeface typeface4 = this.f3478v;
            if (typeface4 == null) {
                typeface4 = this.f3479w;
            }
            this.f3477u = typeface4;
            h(true);
        }
    }

    public final void h(boolean z4) {
        StaticLayout staticLayout;
        float measureText;
        StaticLayout staticLayout2;
        View view = this.f3452a;
        if ((view.getHeight() <= 0 || view.getWidth() <= 0) && !z4) {
            return;
        }
        c(1.0f, z4);
        CharSequence charSequence = this.B;
        TextPaint textPaint = this.N;
        if (charSequence != null && (staticLayout2 = this.Y) != null) {
            this.f3457c0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout2.getWidth(), this.f3482z);
        }
        CharSequence charSequence2 = this.f3457c0;
        if (charSequence2 != null) {
            this.Z = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.Z = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f3464g, this.C ? 1 : 0);
        int i5 = absoluteGravity & 112;
        Rect rect = this.f3458d;
        if (i5 == 48) {
            this.f3470m = rect.top;
        } else if (i5 != 80) {
            this.f3470m = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f3470m = textPaint.ascent() + rect.bottom;
        }
        int i6 = absoluteGravity & 8388615;
        if (i6 == 1) {
            this.o = rect.centerX() - (this.Z / 2.0f);
        } else if (i6 != 5) {
            this.o = rect.left;
        } else {
            this.o = rect.right - this.Z;
        }
        c(0.0f, z4);
        float height = this.Y != null ? staticLayout.getHeight() : 0.0f;
        StaticLayout staticLayout3 = this.Y;
        if (staticLayout3 == null || this.f3459d0 <= 1) {
            CharSequence charSequence3 = this.B;
            measureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            measureText = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.Y;
        if (staticLayout4 != null) {
            staticLayout4.getLineCount();
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f3462f, this.C ? 1 : 0);
        int i7 = absoluteGravity2 & 112;
        Rect rect2 = this.f3456c;
        if (i7 == 48) {
            this.f3469l = rect2.top;
        } else if (i7 != 80) {
            this.f3469l = rect2.centerY() - (height / 2.0f);
        } else {
            this.f3469l = textPaint.descent() + (rect2.bottom - height);
        }
        int i8 = absoluteGravity2 & 8388615;
        if (i8 == 1) {
            this.f3471n = rect2.centerX() - (measureText / 2.0f);
        } else if (i8 != 5) {
            this.f3471n = rect2.left;
        } else {
            this.f3471n = rect2.right - measureText;
        }
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            bitmap.recycle();
            this.E = null;
        }
        l(this.f3454b);
        float f5 = this.f3454b;
        float f6 = f(rect2.left, rect.left, f5, this.P);
        RectF rectF = this.f3460e;
        rectF.left = f6;
        rectF.top = f(this.f3469l, this.f3470m, f5, this.P);
        rectF.right = f(rect2.right, rect.right, f5, this.P);
        rectF.bottom = f(rect2.bottom, rect.bottom, f5, this.P);
        this.f3472p = f(this.f3471n, this.o, f5, this.P);
        this.f3473q = f(this.f3469l, this.f3470m, f5, this.P);
        l(f5);
        v0.b bVar = x2.a.f5485b;
        this.f3453a0 = 1.0f - f(0.0f, 1.0f, 1.0f - f5, bVar);
        WeakHashMap weakHashMap = z0.f3233a;
        view.postInvalidateOnAnimation();
        this.f3455b0 = f(1.0f, 0.0f, f5, bVar);
        view.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f3468k;
        ColorStateList colorStateList2 = this.f3467j;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(e(colorStateList2), f5, e(this.f3468k)));
        } else {
            textPaint.setColor(e(colorStateList));
        }
        float f7 = this.V;
        float f8 = this.W;
        if (f7 != f8) {
            textPaint.setLetterSpacing(f(f8, f7, f5, bVar));
        } else {
            textPaint.setLetterSpacing(f7);
        }
        this.H = f(0.0f, this.R, f5, null);
        this.I = f(0.0f, this.S, f5, null);
        this.J = f(0.0f, this.T, f5, null);
        int a5 = a(e(null), f5, e(this.U));
        this.K = a5;
        textPaint.setShadowLayer(this.H, this.I, this.J, a5);
        view.postInvalidateOnAnimation();
    }

    public final void i(ColorStateList colorStateList) {
        if (this.f3468k == colorStateList && this.f3467j == colorStateList) {
            return;
        }
        this.f3468k = colorStateList;
        this.f3467j = colorStateList;
        h(false);
    }

    public final boolean j(Typeface typeface) {
        m3.a aVar = this.f3481y;
        if (aVar != null) {
            aVar.f3965w = true;
        }
        if (this.f3476t != typeface) {
            this.f3476t = typeface;
            Typeface D = e4.e.D(this.f3452a.getContext().getResources().getConfiguration(), typeface);
            this.f3475s = D;
            if (D == null) {
                D = this.f3476t;
            }
            this.f3474r = D;
            return true;
        }
        return false;
    }

    public final void k(float f5) {
        if (f5 < 0.0f) {
            f5 = 0.0f;
        } else if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        if (f5 != this.f3454b) {
            this.f3454b = f5;
            Rect rect = this.f3456c;
            Rect rect2 = this.f3458d;
            float f6 = f(rect.left, rect2.left, f5, this.P);
            RectF rectF = this.f3460e;
            rectF.left = f6;
            rectF.top = f(this.f3469l, this.f3470m, f5, this.P);
            rectF.right = f(rect.right, rect2.right, f5, this.P);
            rectF.bottom = f(rect.bottom, rect2.bottom, f5, this.P);
            this.f3472p = f(this.f3471n, this.o, f5, this.P);
            this.f3473q = f(this.f3469l, this.f3470m, f5, this.P);
            l(f5);
            v0.b bVar = x2.a.f5485b;
            this.f3453a0 = 1.0f - f(0.0f, 1.0f, 1.0f - f5, bVar);
            WeakHashMap weakHashMap = z0.f3233a;
            View view = this.f3452a;
            view.postInvalidateOnAnimation();
            this.f3455b0 = f(1.0f, 0.0f, f5, bVar);
            view.postInvalidateOnAnimation();
            ColorStateList colorStateList = this.f3468k;
            ColorStateList colorStateList2 = this.f3467j;
            TextPaint textPaint = this.N;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(a(e(colorStateList2), f5, e(this.f3468k)));
            } else {
                textPaint.setColor(e(colorStateList));
            }
            float f7 = this.V;
            float f8 = this.W;
            if (f7 != f8) {
                textPaint.setLetterSpacing(f(f8, f7, f5, bVar));
            } else {
                textPaint.setLetterSpacing(f7);
            }
            this.H = f(0.0f, this.R, f5, null);
            this.I = f(0.0f, this.S, f5, null);
            this.J = f(0.0f, this.T, f5, null);
            int a5 = a(e(null), f5, e(this.U));
            this.K = a5;
            textPaint.setShadowLayer(this.H, this.I, this.J, a5);
            view.postInvalidateOnAnimation();
        }
    }

    public final void l(float f5) {
        c(f5, false);
        WeakHashMap weakHashMap = z0.f3233a;
        this.f3452a.postInvalidateOnAnimation();
    }

    public final void m(Typeface typeface) {
        boolean z4;
        boolean j5 = j(typeface);
        if (this.f3479w != typeface) {
            this.f3479w = typeface;
            Typeface D = e4.e.D(this.f3452a.getContext().getResources().getConfiguration(), typeface);
            this.f3478v = D;
            if (D == null) {
                D = this.f3479w;
            }
            this.f3477u = D;
            z4 = true;
        } else {
            z4 = false;
        }
        if (j5 || z4) {
            h(false);
        }
    }
}

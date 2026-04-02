package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f321a;

    /* renamed from: b  reason: collision with root package name */
    public f3 f322b;

    /* renamed from: c  reason: collision with root package name */
    public f3 f323c;

    /* renamed from: d  reason: collision with root package name */
    public f3 f324d;

    /* renamed from: e  reason: collision with root package name */
    public f3 f325e;

    /* renamed from: f  reason: collision with root package name */
    public f3 f326f;

    /* renamed from: g  reason: collision with root package name */
    public f3 f327g;

    /* renamed from: h  reason: collision with root package name */
    public f3 f328h;

    /* renamed from: i  reason: collision with root package name */
    public final o1 f329i;

    /* renamed from: j  reason: collision with root package name */
    public int f330j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f331k = -1;

    /* renamed from: l  reason: collision with root package name */
    public Typeface f332l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f333m;

    public e1(TextView textView) {
        this.f321a = textView;
        this.f329i = new o1(textView);
    }

    public static f3 c(Context context, y yVar, int i5) {
        ColorStateList h5;
        synchronized (yVar) {
            h5 = yVar.f598a.h(context, i5);
        }
        if (h5 != null) {
            f3 f3Var = new f3(0);
            f3Var.f347b = true;
            f3Var.f348c = h5;
            return f3Var;
        }
        return null;
    }

    public static void h(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i5 >= 30) {
            m0.a.w(editorInfo, text);
            return;
        }
        text.getClass();
        if (i5 >= 30) {
            m0.a.w(editorInfo, text);
            return;
        }
        int i6 = editorInfo.initialSelStart;
        int i7 = editorInfo.initialSelEnd;
        int i8 = i6 > i7 ? i7 + 0 : i6 + 0;
        int i9 = i6 > i7 ? i6 - 0 : i7 + 0;
        int length = text.length();
        if (i8 < 0 || i9 > length) {
            e4.e.R(editorInfo, null, 0, 0);
            return;
        }
        int i10 = editorInfo.inputType & 4095;
        if (i10 == 129 || i10 == 225 || i10 == 18) {
            e4.e.R(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            e4.e.R(editorInfo, text, i8, i9);
        } else {
            int i11 = i9 - i8;
            int i12 = i11 > 1024 ? 0 : i11;
            int i13 = 2048 - i12;
            int min = Math.min(text.length() - i9, i13 - Math.min(i8, (int) (i13 * 0.8d)));
            int min2 = Math.min(i8, i13 - min);
            int i14 = i8 - min2;
            if (Character.isLowSurrogate(text.charAt(i14))) {
                i14++;
                min2--;
            }
            if (Character.isHighSurrogate(text.charAt((i9 + min) - 1))) {
                min--;
            }
            CharSequence concat = i12 != i11 ? TextUtils.concat(text.subSequence(i14, i14 + min2), text.subSequence(i9, min + i9)) : text.subSequence(i14, min2 + i12 + min + i14);
            int i15 = min2 + 0;
            e4.e.R(editorInfo, concat, i15, i12 + i15);
        }
    }

    public final void a(Drawable drawable, f3 f3Var) {
        if (drawable == null || f3Var == null) {
            return;
        }
        y.d(drawable, f3Var, this.f321a.getDrawableState());
    }

    public final void b() {
        f3 f3Var = this.f322b;
        TextView textView = this.f321a;
        if (f3Var != null || this.f323c != null || this.f324d != null || this.f325e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f322b);
            a(compoundDrawables[1], this.f323c);
            a(compoundDrawables[2], this.f324d);
            a(compoundDrawables[3], this.f325e);
        }
        if (this.f326f == null && this.f327g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f326f);
        a(compoundDrawablesRelative[2], this.f327g);
    }

    public final ColorStateList d() {
        f3 f3Var = this.f328h;
        if (f3Var != null) {
            return (ColorStateList) f3Var.f348c;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        f3 f3Var = this.f328h;
        if (f3Var != null) {
            return (PorterDuff.Mode) f3Var.f349d;
        }
        return null;
    }

    public final void f(AttributeSet attributeSet, int i5) {
        boolean z4;
        boolean z5;
        String str;
        String str2;
        int i6;
        int i7;
        int i8;
        float f5;
        int i9;
        int resourceId;
        int i10;
        TextView textView = this.f321a;
        Context context = textView.getContext();
        y a5 = y.a();
        int[] iArr = c.a.f1691h;
        z2 m5 = z2.m(context, attributeSet, iArr, i5);
        h0.z0.m(textView, textView.getContext(), iArr, attributeSet, (TypedArray) m5.f606b, i5);
        int i11 = m5.i(0, -1);
        if (m5.l(3)) {
            this.f322b = c(context, a5, m5.i(3, 0));
        }
        if (m5.l(1)) {
            this.f323c = c(context, a5, m5.i(1, 0));
        }
        if (m5.l(4)) {
            this.f324d = c(context, a5, m5.i(4, 0));
        }
        if (m5.l(2)) {
            this.f325e = c(context, a5, m5.i(2, 0));
        }
        if (m5.l(5)) {
            this.f326f = c(context, a5, m5.i(5, 0));
        }
        if (m5.l(6)) {
            this.f327g = c(context, a5, m5.i(6, 0));
        }
        m5.n();
        boolean z6 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = c.a.f1705w;
        if (i11 != -1) {
            z2 z2Var = new z2(context, context.obtainStyledAttributes(i11, iArr2));
            if (z6 || !z2Var.l(14)) {
                z4 = false;
                z5 = false;
            } else {
                z4 = z2Var.a(14, false);
                z5 = true;
            }
            n(context, z2Var);
            if (z2Var.l(15)) {
                str = z2Var.j(15);
                i10 = 13;
            } else {
                i10 = 13;
                str = null;
            }
            str2 = z2Var.l(i10) ? z2Var.j(i10) : null;
            z2Var.n();
        } else {
            z4 = false;
            z5 = false;
            str = null;
            str2 = null;
        }
        z2 z2Var2 = new z2(context, context.obtainStyledAttributes(attributeSet, iArr2, i5, 0));
        if (!z6 && z2Var2.l(14)) {
            z4 = z2Var2.a(14, false);
            z5 = true;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (z2Var2.l(15)) {
            str = z2Var2.j(15);
        }
        if (z2Var2.l(13)) {
            str2 = z2Var2.j(13);
        }
        String str3 = str2;
        if (i12 >= 28 && z2Var2.l(0) && z2Var2.d(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, z2Var2);
        z2Var2.n();
        if (!z6 && z5) {
            textView.setAllCaps(z4);
        }
        Typeface typeface = this.f332l;
        if (typeface != null) {
            if (this.f331k == -1) {
                textView.setTypeface(typeface, this.f330j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (str3 != null) {
            c1.d(textView, str3);
        }
        if (str != null) {
            b1.b(textView, b1.a(str));
        }
        int[] iArr3 = c.a.f1692i;
        o1 o1Var = this.f329i;
        Context context2 = o1Var.f448j;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr3, i5, 0);
        TextView textView2 = o1Var.f447i;
        h0.z0.m(textView2, textView2.getContext(), iArr3, attributeSet, obtainStyledAttributes, i5);
        if (obtainStyledAttributes.hasValue(5)) {
            o1Var.f439a = obtainStyledAttributes.getInt(5, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(4) ? obtainStyledAttributes.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(2) ? obtainStyledAttributes.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(1) ? obtainStyledAttributes.getDimension(1, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(3) && (resourceId = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            int length = obtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i13 = 0; i13 < length; i13++) {
                    iArr4[i13] = obtainTypedArray.getDimensionPixelSize(i13, -1);
                }
                o1Var.f444f = o1.b(iArr4);
                o1Var.h();
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!o1Var.i()) {
            o1Var.f439a = 0;
        } else if (o1Var.f439a == 1) {
            if (!o1Var.f445g) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i9 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i9 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i9, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                o1Var.j(dimension2, dimension3, dimension);
            }
            o1Var.g();
        }
        if (v3.f562c && o1Var.f439a != 0) {
            int[] iArr5 = o1Var.f444f;
            if (iArr5.length > 0) {
                if (c1.a(textView) != -1.0f) {
                    c1.b(textView, Math.round(o1Var.f442d), Math.round(o1Var.f443e), Math.round(o1Var.f441c), 0);
                } else {
                    c1.c(textView, iArr5, 0);
                }
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr3);
        z2 z2Var3 = new z2(context, obtainStyledAttributes2);
        int i14 = z2Var3.i(8, -1);
        Drawable b5 = i14 != -1 ? a5.b(context, i14) : null;
        int i15 = z2Var3.i(13, -1);
        Drawable b6 = i15 != -1 ? a5.b(context, i15) : null;
        int i16 = z2Var3.i(9, -1);
        Drawable b7 = i16 != -1 ? a5.b(context, i16) : null;
        int i17 = z2Var3.i(6, -1);
        Drawable b8 = i17 != -1 ? a5.b(context, i17) : null;
        int i18 = z2Var3.i(10, -1);
        Drawable b9 = i18 != -1 ? a5.b(context, i18) : null;
        int i19 = z2Var3.i(7, -1);
        Drawable b10 = i19 != -1 ? a5.b(context, i19) : null;
        if (b9 != null || b10 != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            if (b9 == null) {
                b9 = compoundDrawablesRelative[0];
            }
            if (b6 == null) {
                b6 = compoundDrawablesRelative[1];
            }
            if (b10 == null) {
                b10 = compoundDrawablesRelative[2];
            }
            if (b8 == null) {
                b8 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(b9, b6, b10, b8);
        } else if (b5 != null || b6 != null || b7 != null || b8 != null) {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative2[0];
            if (drawable == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (b5 == null) {
                    b5 = compoundDrawables[0];
                }
                if (b6 == null) {
                    b6 = compoundDrawables[1];
                }
                if (b7 == null) {
                    b7 = compoundDrawables[2];
                }
                if (b8 == null) {
                    b8 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(b5, b6, b7, b8);
            } else {
                if (b6 == null) {
                    b6 = compoundDrawablesRelative2[1];
                }
                if (b8 == null) {
                    b8 = compoundDrawablesRelative2[3];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, b6, compoundDrawablesRelative2[2], b8);
            }
        }
        if (z2Var3.l(11)) {
            n0.m.f(textView, z2Var3.b(11));
        }
        if (z2Var3.l(12)) {
            i6 = -1;
            n0.m.g(textView, v1.c(z2Var3.h(12, -1), null));
        } else {
            i6 = -1;
        }
        int d5 = z2Var3.d(15, i6);
        int d6 = z2Var3.d(18, i6);
        if (z2Var3.l(19)) {
            TypedValue peekValue = obtainStyledAttributes2.peekValue(19);
            if (peekValue == null || peekValue.type != 5) {
                i7 = -1;
                f5 = z2Var3.d(19, -1);
                i8 = -1;
            } else {
                int i20 = peekValue.data;
                i8 = (i20 >> 0) & 15;
                f5 = TypedValue.complexToFloat(i20);
                i7 = -1;
            }
        } else {
            i7 = -1;
            i8 = -1;
            f5 = -1.0f;
        }
        z2Var3.n();
        if (d5 != i7) {
            b4.j.X(textView, d5);
        }
        if (d6 != i7) {
            b4.j.Y(textView, d6);
        }
        if (f5 != -1.0f) {
            if (i8 == i7) {
                b4.j.Z(textView, (int) f5);
            } else {
                b4.j.a0(textView, i8, f5);
            }
        }
    }

    public final void g(Context context, int i5) {
        String j5;
        z2 z2Var = new z2(context, context.obtainStyledAttributes(i5, c.a.f1705w));
        boolean l5 = z2Var.l(14);
        TextView textView = this.f321a;
        if (l5) {
            textView.setAllCaps(z2Var.a(14, false));
        }
        if (z2Var.l(0) && z2Var.d(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, z2Var);
        if (z2Var.l(13) && (j5 = z2Var.j(13)) != null) {
            c1.d(textView, j5);
        }
        z2Var.n();
        Typeface typeface = this.f332l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f330j);
        }
    }

    public final void i(int i5, int i6, int i7, int i8) {
        o1 o1Var = this.f329i;
        if (o1Var.i()) {
            DisplayMetrics displayMetrics = o1Var.f448j.getResources().getDisplayMetrics();
            o1Var.j(TypedValue.applyDimension(i8, i5, displayMetrics), TypedValue.applyDimension(i8, i6, displayMetrics), TypedValue.applyDimension(i8, i7, displayMetrics));
            if (o1Var.g()) {
                o1Var.a();
            }
        }
    }

    public final void j(int[] iArr, int i5) {
        o1 o1Var = this.f329i;
        if (o1Var.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i5 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = o1Var.f448j.getResources().getDisplayMetrics();
                    for (int i6 = 0; i6 < length; i6++) {
                        iArr2[i6] = Math.round(TypedValue.applyDimension(i5, iArr[i6], displayMetrics));
                    }
                }
                o1Var.f444f = o1.b(iArr2);
                if (!o1Var.h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                o1Var.f445g = false;
            }
            if (o1Var.g()) {
                o1Var.a();
            }
        }
    }

    public final void k(int i5) {
        o1 o1Var = this.f329i;
        if (o1Var.i()) {
            if (i5 == 0) {
                o1Var.f439a = 0;
                o1Var.f442d = -1.0f;
                o1Var.f443e = -1.0f;
                o1Var.f441c = -1.0f;
                o1Var.f444f = new int[0];
                o1Var.f440b = false;
            } else if (i5 != 1) {
                throw new IllegalArgumentException(b0.f("Unknown auto-size text type: ", i5));
            } else {
                DisplayMetrics displayMetrics = o1Var.f448j.getResources().getDisplayMetrics();
                o1Var.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (o1Var.g()) {
                    o1Var.a();
                }
            }
        }
    }

    public final void l(ColorStateList colorStateList) {
        if (this.f328h == null) {
            this.f328h = new f3(0);
        }
        f3 f3Var = this.f328h;
        f3Var.f348c = colorStateList;
        f3Var.f347b = colorStateList != null;
        this.f322b = f3Var;
        this.f323c = f3Var;
        this.f324d = f3Var;
        this.f325e = f3Var;
        this.f326f = f3Var;
        this.f327g = f3Var;
    }

    public final void m(PorterDuff.Mode mode) {
        if (this.f328h == null) {
            this.f328h = new f3(0);
        }
        f3 f3Var = this.f328h;
        f3Var.f349d = mode;
        f3Var.f346a = mode != null;
        this.f322b = f3Var;
        this.f323c = f3Var;
        this.f324d = f3Var;
        this.f325e = f3Var;
        this.f326f = f3Var;
        this.f327g = f3Var;
    }

    public final void n(Context context, z2 z2Var) {
        String j5;
        this.f330j = z2Var.h(2, this.f330j);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 28) {
            int h5 = z2Var.h(11, -1);
            this.f331k = h5;
            if (h5 != -1) {
                this.f330j = (this.f330j & 2) | 0;
            }
        }
        if (!z2Var.l(10) && !z2Var.l(12)) {
            if (z2Var.l(1)) {
                this.f333m = false;
                int h6 = z2Var.h(1, 1);
                if (h6 == 1) {
                    this.f332l = Typeface.SANS_SERIF;
                    return;
                } else if (h6 == 2) {
                    this.f332l = Typeface.SERIF;
                    return;
                } else if (h6 != 3) {
                    return;
                } else {
                    this.f332l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f332l = null;
        int i6 = z2Var.l(12) ? 12 : 10;
        int i7 = this.f331k;
        int i8 = this.f330j;
        if (!context.isRestricted()) {
            try {
                Typeface g5 = z2Var.g(i6, this.f330j, new z0(this, i7, i8, new WeakReference(this.f321a)));
                if (g5 != null) {
                    if (i5 < 28 || this.f331k == -1) {
                        this.f332l = g5;
                    } else {
                        this.f332l = d1.a(Typeface.create(g5, 0), this.f331k, (this.f330j & 2) != 0);
                    }
                }
                this.f333m = this.f332l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f332l != null || (j5 = z2Var.j(i6)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f331k == -1) {
            this.f332l = Typeface.create(j5, this.f330j);
        } else {
            this.f332l = d1.a(Typeface.create(j5, 0), this.f331k, (this.f330j & 2) != 0);
        }
    }
}

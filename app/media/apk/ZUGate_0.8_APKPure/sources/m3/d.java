package m3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import e4.e;
import y.q;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f3972a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3973b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3974c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3975d;

    /* renamed from: e  reason: collision with root package name */
    public final float f3976e;

    /* renamed from: f  reason: collision with root package name */
    public final float f3977f;

    /* renamed from: g  reason: collision with root package name */
    public final float f3978g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3979h;

    /* renamed from: i  reason: collision with root package name */
    public final float f3980i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f3981j;

    /* renamed from: k  reason: collision with root package name */
    public float f3982k;

    /* renamed from: l  reason: collision with root package name */
    public final int f3983l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f3984m = false;

    /* renamed from: n  reason: collision with root package name */
    public Typeface f3985n;

    public d(Context context, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i5, w2.a.f5409y);
        this.f3982k = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f3981j = p2.a.v(context, obtainStyledAttributes, 3);
        p2.a.v(context, obtainStyledAttributes, 4);
        p2.a.v(context, obtainStyledAttributes, 5);
        this.f3974c = obtainStyledAttributes.getInt(2, 0);
        this.f3975d = obtainStyledAttributes.getInt(1, 1);
        int i6 = obtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f3983l = obtainStyledAttributes.getResourceId(i6, 0);
        this.f3973b = obtainStyledAttributes.getString(i6);
        obtainStyledAttributes.getBoolean(14, false);
        this.f3972a = p2.a.v(context, obtainStyledAttributes, 6);
        this.f3976e = obtainStyledAttributes.getFloat(7, 0.0f);
        this.f3977f = obtainStyledAttributes.getFloat(8, 0.0f);
        this.f3978g = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i5, w2.a.f5401q);
        this.f3979h = obtainStyledAttributes2.hasValue(0);
        this.f3980i = obtainStyledAttributes2.getFloat(0, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f3985n;
        int i5 = this.f3974c;
        if (typeface == null && (str = this.f3973b) != null) {
            this.f3985n = Typeface.create(str, i5);
        }
        if (this.f3985n == null) {
            int i6 = this.f3975d;
            if (i6 == 1) {
                this.f3985n = Typeface.SANS_SERIF;
            } else if (i6 == 2) {
                this.f3985n = Typeface.SERIF;
            } else if (i6 != 3) {
                this.f3985n = Typeface.DEFAULT;
            } else {
                this.f3985n = Typeface.MONOSPACE;
            }
            this.f3985n = Typeface.create(this.f3985n, i5);
        }
    }

    public final Typeface b(Context context) {
        if (this.f3984m) {
            return this.f3985n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface a5 = q.a(context, this.f3983l);
                this.f3985n = a5;
                if (a5 != null) {
                    this.f3985n = Typeface.create(a5, this.f3974c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e5) {
                Log.d("TextAppearance", "Error loading font " + this.f3973b, e5);
            }
        }
        a();
        this.f3984m = true;
        return this.f3985n;
    }

    public final void c(Context context, p2.a aVar) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i5 = this.f3983l;
        if (i5 == 0) {
            this.f3984m = true;
        }
        if (this.f3984m) {
            aVar.N(this.f3985n, true);
            return;
        }
        try {
            q.b(context, i5, new b(this, aVar));
        } catch (Resources.NotFoundException unused) {
            this.f3984m = true;
            aVar.M(1);
        } catch (Exception e5) {
            Log.d("TextAppearance", "Error loading font " + this.f3973b, e5);
            this.f3984m = true;
            aVar.M(-3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0021 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.content.Context r8) {
        /*
            r7 = this;
            int r1 = r7.f3983l
            if (r1 == 0) goto L1c
            java.lang.ThreadLocal r0 = y.q.f5568a
            boolean r0 = r8.isRestricted()
            if (r0 == 0) goto Ld
            goto L1c
        Ld:
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1
            r0 = r8
            android.graphics.Typeface r8 = y.q.c(r0, r1, r2, r3, r4, r5, r6)
            goto L1d
        L1c:
            r8 = 0
        L1d:
            if (r8 == 0) goto L21
            r8 = 1
            goto L22
        L21:
            r8 = 0
        L22:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.d.d(android.content.Context):boolean");
    }

    public final void e(Context context, TextPaint textPaint, p2.a aVar) {
        f(context, textPaint, aVar);
        ColorStateList colorStateList = this.f3981j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f3972a;
        textPaint.setShadowLayer(this.f3978g, this.f3976e, this.f3977f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void f(Context context, TextPaint textPaint, p2.a aVar) {
        if (d(context)) {
            g(context, textPaint, b(context));
            return;
        }
        a();
        g(context, textPaint, this.f3985n);
        c(context, new c(this, context, textPaint, aVar));
    }

    public final void g(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface D = e.D(context.getResources().getConfiguration(), typeface);
        if (D != null) {
            typeface = D;
        }
        textPaint.setTypeface(typeface);
        int i5 = (~typeface.getStyle()) & this.f3974c;
        textPaint.setFakeBoldText((i5 & 1) != 0);
        textPaint.setTextSkewX((i5 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f3982k);
        if (this.f3979h) {
            textPaint.setLetterSpacing(this.f3980i);
        }
    }
}

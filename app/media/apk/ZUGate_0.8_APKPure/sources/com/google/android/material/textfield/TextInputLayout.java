package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.d;
import androidx.appcompat.widget.i1;
import androidx.appcompat.widget.v1;
import androidx.appcompat.widget.v2;
import androidx.appcompat.widget.z2;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import com.google.android.material.internal.CheckableImageButton;
import e1.g;
import e1.v;
import e4.e;
import h0.h;
import h0.q0;
import h0.z0;
import j3.b;
import j3.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import p2.a;
import p3.f;
import p3.j;
import s3.a0;
import s3.k;
import s3.m;
import s3.n;
import s3.q;
import s3.r;
import s3.u;
import s3.w;
import s3.x;
import s3.y;
import s3.z;
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] I0 = {new int[]{16842919}, new int[0]};
    public ColorStateList A;
    public boolean A0;
    public int B;
    public final b B0;
    public g C;
    public boolean C0;
    public g D;
    public boolean D0;
    public ColorStateList E;
    public ValueAnimator E0;
    public ColorStateList F;
    public boolean F0;
    public ColorStateList G;
    public boolean G0;
    public ColorStateList H;
    public boolean H0;
    public boolean I;
    public CharSequence J;
    public boolean K;
    public p3.g L;
    public p3.g M;
    public StateListDrawable N;
    public boolean O;
    public p3.g P;
    public p3.g Q;
    public j R;
    public boolean S;
    public final int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a0  reason: collision with root package name */
    public int f2201a0;

    /* renamed from: b0  reason: collision with root package name */
    public int f2202b0;

    /* renamed from: c0  reason: collision with root package name */
    public int f2203c0;

    /* renamed from: d0  reason: collision with root package name */
    public int f2204d0;

    /* renamed from: e0  reason: collision with root package name */
    public final Rect f2205e0;

    /* renamed from: f0  reason: collision with root package name */
    public final Rect f2206f0;

    /* renamed from: g  reason: collision with root package name */
    public final FrameLayout f2207g;

    /* renamed from: g0  reason: collision with root package name */
    public final RectF f2208g0;

    /* renamed from: h  reason: collision with root package name */
    public final w f2209h;

    /* renamed from: h0  reason: collision with root package name */
    public Typeface f2210h0;

    /* renamed from: i  reason: collision with root package name */
    public final n f2211i;

    /* renamed from: i0  reason: collision with root package name */
    public ColorDrawable f2212i0;

    /* renamed from: j  reason: collision with root package name */
    public EditText f2213j;

    /* renamed from: j0  reason: collision with root package name */
    public int f2214j0;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f2215k;

    /* renamed from: k0  reason: collision with root package name */
    public final LinkedHashSet f2216k0;

    /* renamed from: l  reason: collision with root package name */
    public int f2217l;

    /* renamed from: l0  reason: collision with root package name */
    public ColorDrawable f2218l0;

    /* renamed from: m  reason: collision with root package name */
    public int f2219m;

    /* renamed from: m0  reason: collision with root package name */
    public int f2220m0;

    /* renamed from: n  reason: collision with root package name */
    public int f2221n;

    /* renamed from: n0  reason: collision with root package name */
    public Drawable f2222n0;
    public int o;

    /* renamed from: o0  reason: collision with root package name */
    public ColorStateList f2223o0;

    /* renamed from: p  reason: collision with root package name */
    public final r f2224p;

    /* renamed from: p0  reason: collision with root package name */
    public ColorStateList f2225p0;

    /* renamed from: q  reason: collision with root package name */
    public boolean f2226q;

    /* renamed from: q0  reason: collision with root package name */
    public int f2227q0;

    /* renamed from: r  reason: collision with root package name */
    public int f2228r;

    /* renamed from: r0  reason: collision with root package name */
    public int f2229r0;

    /* renamed from: s  reason: collision with root package name */
    public boolean f2230s;

    /* renamed from: s0  reason: collision with root package name */
    public int f2231s0;

    /* renamed from: t  reason: collision with root package name */
    public z f2232t;

    /* renamed from: t0  reason: collision with root package name */
    public ColorStateList f2233t0;

    /* renamed from: u  reason: collision with root package name */
    public i1 f2234u;

    /* renamed from: u0  reason: collision with root package name */
    public int f2235u0;

    /* renamed from: v  reason: collision with root package name */
    public int f2236v;

    /* renamed from: v0  reason: collision with root package name */
    public int f2237v0;

    /* renamed from: w  reason: collision with root package name */
    public int f2238w;

    /* renamed from: w0  reason: collision with root package name */
    public int f2239w0;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f2240x;

    /* renamed from: x0  reason: collision with root package name */
    public int f2241x0;

    /* renamed from: y  reason: collision with root package name */
    public boolean f2242y;

    /* renamed from: y0  reason: collision with root package name */
    public int f2243y0;

    /* renamed from: z  reason: collision with root package name */
    public i1 f2244z;

    /* renamed from: z0  reason: collision with root package name */
    public int f2245z0;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(a.b0(context, attributeSet, R.attr.textInputStyle, 2131952487), attributeSet, R.attr.textInputStyle);
        this.f2217l = -1;
        this.f2219m = -1;
        this.f2221n = -1;
        this.o = -1;
        this.f2224p = new r(this);
        this.f2232t = new h(18);
        this.f2205e0 = new Rect();
        this.f2206f0 = new Rect();
        this.f2208g0 = new RectF();
        this.f2216k0 = new LinkedHashSet();
        b bVar = new b(this);
        this.B0 = bVar;
        this.H0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f2207g = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = x2.a.f5484a;
        bVar.Q = linearInterpolator;
        bVar.h(false);
        bVar.P = linearInterpolator;
        bVar.h(false);
        if (bVar.f3464g != 8388659) {
            bVar.f3464g = 8388659;
            bVar.h(false);
        }
        int[] iArr = w2.a.A;
        b4.j.e(context2, attributeSet, R.attr.textInputStyle, 2131952487);
        b4.j.f(context2, attributeSet, iArr, R.attr.textInputStyle, 2131952487, 22, 20, 40, 45, 49);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.textInputStyle, 2131952487);
        z2 z2Var = new z2(context2, obtainStyledAttributes);
        w wVar = new w(this, z2Var);
        this.f2209h = wVar;
        this.I = z2Var.a(48, true);
        setHint(z2Var.k(4));
        this.D0 = z2Var.a(47, true);
        this.C0 = z2Var.a(42, true);
        if (z2Var.l(6)) {
            setMinEms(z2Var.h(6, -1));
        } else if (z2Var.l(3)) {
            setMinWidth(z2Var.d(3, -1));
        }
        if (z2Var.l(5)) {
            setMaxEms(z2Var.h(5, -1));
        } else if (z2Var.l(2)) {
            setMaxWidth(z2Var.d(2, -1));
        }
        this.R = new j(j.b(context2, attributeSet, R.attr.textInputStyle, 2131952487));
        this.T = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.V = z2Var.c(9, 0);
        this.f2201a0 = z2Var.d(16, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.f2202b0 = z2Var.d(17, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.W = this.f2201a0;
        float dimension = obtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = obtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = obtainStyledAttributes.getDimension(11, -1.0f);
        j jVar = this.R;
        jVar.getClass();
        w1.h hVar = new w1.h(jVar);
        if (dimension >= 0.0f) {
            hVar.f5338e = new p3.a(dimension);
        }
        if (dimension2 >= 0.0f) {
            hVar.f5339f = new p3.a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            hVar.f5340g = new p3.a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            hVar.f5341h = new p3.a(dimension4);
        }
        this.R = new j(hVar);
        ColorStateList w5 = a.w(context2, z2Var, 7);
        if (w5 != null) {
            int defaultColor = w5.getDefaultColor();
            this.f2235u0 = defaultColor;
            this.f2204d0 = defaultColor;
            if (w5.isStateful()) {
                this.f2237v0 = w5.getColorForState(new int[]{-16842910}, -1);
                this.f2239w0 = w5.getColorForState(new int[]{16842908, 16842910}, -1);
                this.f2241x0 = w5.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                this.f2239w0 = this.f2235u0;
                ColorStateList u3 = a.u(context2, R.color.mtrl_filled_background_color);
                this.f2237v0 = u3.getColorForState(new int[]{-16842910}, -1);
                this.f2241x0 = u3.getColorForState(new int[]{16843623}, -1);
            }
        } else {
            this.f2204d0 = 0;
            this.f2235u0 = 0;
            this.f2237v0 = 0;
            this.f2239w0 = 0;
            this.f2241x0 = 0;
        }
        if (z2Var.l(1)) {
            ColorStateList b5 = z2Var.b(1);
            this.f2225p0 = b5;
            this.f2223o0 = b5;
        }
        ColorStateList w6 = a.w(context2, z2Var, 14);
        this.f2231s0 = obtainStyledAttributes.getColor(14, 0);
        this.f2227q0 = x.b.a(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.f2243y0 = x.b.a(context2, R.color.mtrl_textinput_disabled_color);
        this.f2229r0 = x.b.a(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (w6 != null) {
            setBoxStrokeColorStateList(w6);
        }
        if (z2Var.l(15)) {
            setBoxStrokeErrorColor(a.w(context2, z2Var, 15));
        }
        if (z2Var.i(49, -1) != -1) {
            setHintTextAppearance(z2Var.i(49, 0));
        }
        this.G = z2Var.b(24);
        this.H = z2Var.b(25);
        int i5 = z2Var.i(40, 0);
        CharSequence k5 = z2Var.k(35);
        int h5 = z2Var.h(34, 1);
        boolean a5 = z2Var.a(36, false);
        int i6 = z2Var.i(45, 0);
        boolean a6 = z2Var.a(44, false);
        CharSequence k6 = z2Var.k(43);
        int i7 = z2Var.i(57, 0);
        CharSequence k7 = z2Var.k(56);
        boolean a7 = z2Var.a(18, false);
        setCounterMaxLength(z2Var.h(19, -1));
        this.f2238w = z2Var.i(22, 0);
        this.f2236v = z2Var.i(20, 0);
        setBoxBackgroundMode(z2Var.h(8, 0));
        setErrorContentDescription(k5);
        setErrorAccessibilityLiveRegion(h5);
        setCounterOverflowTextAppearance(this.f2236v);
        setHelperTextTextAppearance(i6);
        setErrorTextAppearance(i5);
        setCounterTextAppearance(this.f2238w);
        setPlaceholderText(k7);
        setPlaceholderTextAppearance(i7);
        if (z2Var.l(41)) {
            setErrorTextColor(z2Var.b(41));
        }
        if (z2Var.l(46)) {
            setHelperTextColor(z2Var.b(46));
        }
        if (z2Var.l(50)) {
            setHintTextColor(z2Var.b(50));
        }
        if (z2Var.l(23)) {
            setCounterTextColor(z2Var.b(23));
        }
        if (z2Var.l(21)) {
            setCounterOverflowTextColor(z2Var.b(21));
        }
        if (z2Var.l(58)) {
            setPlaceholderTextColor(z2Var.b(58));
        }
        n nVar = new n(this, z2Var);
        this.f2211i = nVar;
        boolean a8 = z2Var.a(0, true);
        z2Var.n();
        setImportantForAccessibility(2);
        q0.m(this, 1);
        frameLayout.addView(wVar);
        frameLayout.addView(nVar);
        addView(frameLayout);
        setEnabled(a8);
        setHelperTextEnabled(a6);
        setErrorEnabled(a5);
        setCounterEnabled(a7);
        setHelperText(k6);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f2213j;
        if (editText instanceof AutoCompleteTextView) {
            if (!(editText.getInputType() != 0)) {
                int l5 = e.l(this.f2213j, R.attr.colorControlHighlight);
                int i5 = this.U;
                int[][] iArr = I0;
                if (i5 != 2) {
                    if (i5 == 1) {
                        p3.g gVar = this.L;
                        int i6 = this.f2204d0;
                        return new RippleDrawable(new ColorStateList(iArr, new int[]{e.B(l5, 0.1f, i6), i6}), gVar, gVar);
                    }
                    return null;
                }
                Context context = getContext();
                p3.g gVar2 = this.L;
                TypedValue P = e.P(R.attr.colorSurface, context, "TextInputLayout");
                int i7 = P.resourceId;
                int a5 = i7 != 0 ? x.b.a(context, i7) : P.data;
                p3.g gVar3 = new p3.g(gVar2.f4294g.f4274a);
                int B = e.B(l5, 0.1f, a5);
                gVar3.j(new ColorStateList(iArr, new int[]{B, 0}));
                gVar3.setTint(a5);
                ColorStateList colorStateList = new ColorStateList(iArr, new int[]{B, a5});
                p3.g gVar4 = new p3.g(gVar2.f4294g.f4274a);
                gVar4.setTint(-1);
                return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar3, gVar4), gVar2});
            }
        }
        return this.L;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.N == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.N = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, getOrCreateOutlinedDropDownMenuBackground());
            this.N.addState(new int[0], f(false));
        }
        return this.N;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.M == null) {
            this.M = f(true);
        }
        return this.M;
    }

    public static void k(ViewGroup viewGroup, boolean z4) {
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            childAt.setEnabled(z4);
            if (childAt instanceof ViewGroup) {
                k((ViewGroup) childAt, z4);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f2213j != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f2213j = editText;
        int i5 = this.f2217l;
        if (i5 != -1) {
            setMinEms(i5);
        } else {
            setMinWidth(this.f2221n);
        }
        int i6 = this.f2219m;
        if (i6 != -1) {
            setMaxEms(i6);
        } else {
            setMaxWidth(this.o);
        }
        this.O = false;
        i();
        setTextInputAccessibilityDelegate(new y(this));
        Typeface typeface = this.f2213j.getTypeface();
        b bVar = this.B0;
        bVar.m(typeface);
        float textSize = this.f2213j.getTextSize();
        if (bVar.f3465h != textSize) {
            bVar.f3465h = textSize;
            bVar.h(false);
        }
        int i7 = Build.VERSION.SDK_INT;
        float letterSpacing = this.f2213j.getLetterSpacing();
        if (bVar.W != letterSpacing) {
            bVar.W = letterSpacing;
            bVar.h(false);
        }
        int gravity = this.f2213j.getGravity();
        int i8 = (gravity & (-113)) | 48;
        if (bVar.f3464g != i8) {
            bVar.f3464g = i8;
            bVar.h(false);
        }
        if (bVar.f3462f != gravity) {
            bVar.f3462f = gravity;
            bVar.h(false);
        }
        WeakHashMap weakHashMap = z0.f3233a;
        this.f2245z0 = editText.getMinimumHeight();
        this.f2213j.addTextChangedListener(new x(this, editText));
        if (this.f2223o0 == null) {
            this.f2223o0 = this.f2213j.getHintTextColors();
        }
        if (this.I) {
            if (TextUtils.isEmpty(this.J)) {
                CharSequence hint = this.f2213j.getHint();
                this.f2215k = hint;
                setHint(hint);
                this.f2213j.setHint((CharSequence) null);
            }
            this.K = true;
        }
        if (i7 >= 29) {
            p();
        }
        if (this.f2234u != null) {
            n(this.f2213j.getText());
        }
        r();
        this.f2224p.b();
        this.f2209h.bringToFront();
        n nVar = this.f2211i;
        nVar.bringToFront();
        Iterator it = this.f2216k0.iterator();
        while (it.hasNext()) {
            ((m) it.next()).a(this);
        }
        nVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        u(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.J)) {
            return;
        }
        this.J = charSequence;
        b bVar = this.B0;
        if (charSequence == null || !TextUtils.equals(bVar.A, charSequence)) {
            bVar.A = charSequence;
            bVar.B = null;
            Bitmap bitmap = bVar.E;
            if (bitmap != null) {
                bitmap.recycle();
                bVar.E = null;
            }
            bVar.h(false);
        }
        if (this.A0) {
            return;
        }
        j();
    }

    private void setPlaceholderTextEnabled(boolean z4) {
        if (this.f2242y == z4) {
            return;
        }
        if (z4) {
            i1 i1Var = this.f2244z;
            if (i1Var != null) {
                this.f2207g.addView(i1Var);
                this.f2244z.setVisibility(0);
            }
        } else {
            i1 i1Var2 = this.f2244z;
            if (i1Var2 != null) {
                i1Var2.setVisibility(8);
            }
            this.f2244z = null;
        }
        this.f2242y = z4;
    }

    public final void a(float f5) {
        b bVar = this.B0;
        if (bVar.f3454b == f5) {
            return;
        }
        if (this.E0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.E0 = valueAnimator;
            valueAnimator.setInterpolator(a.R(getContext(), R.attr.motionEasingEmphasizedInterpolator, x2.a.f5485b));
            this.E0.setDuration(a.Q(getContext(), R.attr.motionDurationMedium4, 167));
            this.E0.addUpdateListener(new k1.b(2, this));
        }
        this.E0.setFloatValues(bVar.f3454b, f5);
        this.E0.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i5, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f2207g;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        t();
        setEditText((EditText) view);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r7 = this;
            p3.g r0 = r7.L
            if (r0 != 0) goto L5
            return
        L5:
            p3.f r1 = r0.f4294g
            p3.j r1 = r1.f4274a
            p3.j r2 = r7.R
            if (r1 == r2) goto L10
            r0.setShapeAppearanceModel(r2)
        L10:
            int r0 = r7.U
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            if (r0 != r1) goto L27
            int r0 = r7.W
            if (r0 <= r2) goto L22
            int r0 = r7.f2203c0
            if (r0 == 0) goto L22
            r0 = r4
            goto L23
        L22:
            r0 = r3
        L23:
            if (r0 == 0) goto L27
            r0 = r4
            goto L28
        L27:
            r0 = r3
        L28:
            if (r0 == 0) goto L4b
            p3.g r0 = r7.L
            int r1 = r7.W
            float r1 = (float) r1
            int r5 = r7.f2203c0
            p3.f r6 = r0.f4294g
            r6.f4284k = r1
            r0.invalidateSelf()
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r5)
            p3.f r5 = r0.f4294g
            android.content.res.ColorStateList r6 = r5.f4277d
            if (r6 == r1) goto L4b
            r5.f4277d = r1
            int[] r1 = r0.getState()
            r0.onStateChange(r1)
        L4b:
            int r0 = r7.f2204d0
            int r1 = r7.U
            if (r1 != r4) goto L62
            android.content.Context r0 = r7.getContext()
            r1 = 2130968889(0x7f040139, float:1.7546444E38)
            int r0 = e4.e.k(r0, r1, r3)
            int r1 = r7.f2204d0
            int r0 = z.a.b(r1, r0)
        L62:
            r7.f2204d0 = r0
            p3.g r1 = r7.L
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.j(r0)
            p3.g r0 = r7.P
            if (r0 == 0) goto La7
            p3.g r1 = r7.Q
            if (r1 != 0) goto L76
            goto La7
        L76:
            int r1 = r7.W
            if (r1 <= r2) goto L7f
            int r1 = r7.f2203c0
            if (r1 == 0) goto L7f
            r3 = r4
        L7f:
            if (r3 == 0) goto La4
            android.widget.EditText r1 = r7.f2213j
            boolean r1 = r1.isFocused()
            if (r1 == 0) goto L90
            int r1 = r7.f2227q0
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            goto L96
        L90:
            int r1 = r7.f2203c0
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
        L96:
            r0.j(r1)
            p3.g r0 = r7.Q
            int r1 = r7.f2203c0
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.j(r1)
        La4:
            r7.invalidate()
        La7:
            r7.s()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.b():void");
    }

    public final int c() {
        float d5;
        if (this.I) {
            int i5 = this.U;
            b bVar = this.B0;
            if (i5 == 0) {
                d5 = bVar.d();
            } else if (i5 != 2) {
                return 0;
            } else {
                d5 = bVar.d() / 2.0f;
            }
            return (int) d5;
        }
        return 0;
    }

    public final g d() {
        g gVar = new g();
        gVar.f2653d = a.Q(getContext(), R.attr.motionDurationShort2, 87);
        gVar.f2654e = a.R(getContext(), R.attr.motionEasingLinearInterpolator, x2.a.f5484a);
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i5) {
        EditText editText = this.f2213j;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i5);
            return;
        }
        if (this.f2215k != null) {
            boolean z4 = this.K;
            this.K = false;
            CharSequence hint = editText.getHint();
            this.f2213j.setHint(this.f2215k);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i5);
                return;
            } finally {
                this.f2213j.setHint(hint);
                this.K = z4;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i5);
        onProvideAutofillVirtualStructure(viewStructure, i5);
        FrameLayout frameLayout = this.f2207g;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i6 = 0; i6 < frameLayout.getChildCount(); i6++) {
            View childAt = frameLayout.getChildAt(i6);
            ViewStructure newChild = viewStructure.newChild(i6);
            childAt.dispatchProvideAutofillStructure(newChild, i5);
            if (childAt == this.f2213j) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.G0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.G0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        p3.g gVar;
        super.draw(canvas);
        boolean z4 = this.I;
        b bVar = this.B0;
        if (z4) {
            bVar.getClass();
            int save = canvas.save();
            if (bVar.B != null) {
                RectF rectF = bVar.f3460e;
                if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                    TextPaint textPaint = bVar.N;
                    textPaint.setTextSize(bVar.G);
                    float f5 = bVar.f3472p;
                    float f6 = bVar.f3473q;
                    float f7 = bVar.F;
                    if (f7 != 1.0f) {
                        canvas.scale(f7, f7, f5, f6);
                    }
                    boolean z5 = true;
                    if (bVar.f3459d0 <= 1 || bVar.C) {
                        z5 = false;
                    }
                    if (z5) {
                        int alpha = textPaint.getAlpha();
                        canvas.translate(bVar.f3472p - bVar.Y.getLineStart(0), f6);
                        float f8 = alpha;
                        textPaint.setAlpha((int) (bVar.f3455b0 * f8));
                        int i5 = Build.VERSION.SDK_INT;
                        if (i5 >= 31) {
                            float f9 = bVar.H;
                            float f10 = bVar.I;
                            float f11 = bVar.J;
                            int i6 = bVar.K;
                            textPaint.setShadowLayer(f9, f10, f11, z.a.c(i6, (Color.alpha(i6) * textPaint.getAlpha()) / 255));
                        }
                        bVar.Y.draw(canvas);
                        textPaint.setAlpha((int) (bVar.f3453a0 * f8));
                        if (i5 >= 31) {
                            float f12 = bVar.H;
                            float f13 = bVar.I;
                            float f14 = bVar.J;
                            int i7 = bVar.K;
                            textPaint.setShadowLayer(f12, f13, f14, z.a.c(i7, (Color.alpha(i7) * textPaint.getAlpha()) / 255));
                        }
                        int lineBaseline = bVar.Y.getLineBaseline(0);
                        CharSequence charSequence = bVar.f3457c0;
                        float f15 = lineBaseline;
                        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f15, textPaint);
                        if (i5 >= 31) {
                            textPaint.setShadowLayer(bVar.H, bVar.I, bVar.J, bVar.K);
                        }
                        String trim = bVar.f3457c0.toString().trim();
                        if (trim.endsWith("…")) {
                            trim = trim.substring(0, trim.length() - 1);
                        }
                        String str = trim;
                        textPaint.setAlpha(alpha);
                        canvas.drawText(str, 0, Math.min(bVar.Y.getLineEnd(0), str.length()), 0.0f, f15, (Paint) textPaint);
                    } else {
                        canvas.translate(f5, f6);
                        bVar.Y.draw(canvas);
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
        if (this.Q == null || (gVar = this.P) == null) {
            return;
        }
        gVar.draw(canvas);
        if (this.f2213j.isFocused()) {
            Rect bounds = this.Q.getBounds();
            Rect bounds2 = this.P.getBounds();
            float f16 = bVar.f3454b;
            int centerX = bounds2.centerX();
            bounds.left = x2.a.b(centerX, f16, bounds2.left);
            bounds.right = x2.a.b(centerX, f16, bounds2.right);
            this.Q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        boolean z4;
        ColorStateList colorStateList;
        boolean z5;
        if (this.F0) {
            return;
        }
        boolean z6 = true;
        this.F0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        b bVar = this.B0;
        if (bVar != null) {
            bVar.L = drawableState;
            ColorStateList colorStateList2 = bVar.f3468k;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = bVar.f3467j) != null && colorStateList.isStateful())) {
                bVar.h(false);
                z5 = true;
            } else {
                z5 = false;
            }
            z4 = z5 | false;
        } else {
            z4 = false;
        }
        if (this.f2213j != null) {
            WeakHashMap weakHashMap = z0.f3233a;
            if (!isLaidOut() || !isEnabled()) {
                z6 = false;
            }
            u(z6, false);
        }
        r();
        x();
        if (z4) {
            invalidate();
        }
        this.F0 = false;
    }

    public final boolean e() {
        return this.I && !TextUtils.isEmpty(this.J) && (this.L instanceof s3.h);
    }

    public final p3.g f(boolean z4) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float f5 = z4 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f2213j;
        float popupElevation = editText instanceof u ? ((u) editText).getPopupElevation() : getResources().getDimensionPixelOffset(R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        w1.h hVar = new w1.h(1);
        hVar.f5338e = new p3.a(f5);
        hVar.f5339f = new p3.a(f5);
        hVar.f5341h = new p3.a(dimensionPixelOffset);
        hVar.f5340g = new p3.a(dimensionPixelOffset);
        j jVar = new j(hVar);
        EditText editText2 = this.f2213j;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof u ? ((u) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = p3.g.C;
            TypedValue P = e.P(R.attr.colorSurface, context, p3.g.class.getSimpleName());
            int i5 = P.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i5 != 0 ? x.b.a(context, i5) : P.data);
        }
        p3.g gVar = new p3.g();
        gVar.h(context);
        gVar.j(dropDownBackgroundTintList);
        gVar.i(popupElevation);
        gVar.setShapeAppearanceModel(jVar);
        f fVar = gVar.f4294g;
        if (fVar.f4281h == null) {
            fVar.f4281h = new Rect();
        }
        gVar.f4294g.f4281h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        gVar.invalidateSelf();
        return gVar;
    }

    public final int g(int i5, boolean z4) {
        return ((z4 || getPrefixText() == null) ? (!z4 || getSuffixText() == null) ? this.f2213j.getCompoundPaddingLeft() : this.f2211i.c() : this.f2209h.a()) + i5;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f2213j;
        if (editText != null) {
            return c() + getPaddingTop() + editText.getBaseline();
        }
        return super.getBaseline();
    }

    public p3.g getBoxBackground() {
        int i5 = this.U;
        if (i5 == 1 || i5 == 2) {
            return this.L;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f2204d0;
    }

    public int getBoxBackgroundMode() {
        return this.U;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.V;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean C = a.C(this);
        RectF rectF = this.f2208g0;
        return C ? this.R.f4321h.a(rectF) : this.R.f4320g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean C = a.C(this);
        RectF rectF = this.f2208g0;
        return C ? this.R.f4320g.a(rectF) : this.R.f4321h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean C = a.C(this);
        RectF rectF = this.f2208g0;
        return C ? this.R.f4318e.a(rectF) : this.R.f4319f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean C = a.C(this);
        RectF rectF = this.f2208g0;
        return C ? this.R.f4319f.a(rectF) : this.R.f4318e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f2231s0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f2233t0;
    }

    public int getBoxStrokeWidth() {
        return this.f2201a0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f2202b0;
    }

    public int getCounterMaxLength() {
        return this.f2228r;
    }

    public CharSequence getCounterOverflowDescription() {
        i1 i1Var;
        if (this.f2226q && this.f2230s && (i1Var = this.f2234u) != null) {
            return i1Var.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.F;
    }

    public ColorStateList getCounterTextColor() {
        return this.E;
    }

    public ColorStateList getCursorColor() {
        return this.G;
    }

    public ColorStateList getCursorErrorColor() {
        return this.H;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f2223o0;
    }

    public EditText getEditText() {
        return this.f2213j;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f2211i.f4902m.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f2211i.f4902m.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f2211i.f4907s;
    }

    public int getEndIconMode() {
        return this.f2211i.o;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f2211i.f4908t;
    }

    public CheckableImageButton getEndIconView() {
        return this.f2211i.f4902m;
    }

    public CharSequence getError() {
        r rVar = this.f2224p;
        if (rVar.f4940q) {
            return rVar.f4939p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f2224p.f4943t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f2224p.f4942s;
    }

    public int getErrorCurrentTextColors() {
        i1 i1Var = this.f2224p.f4941r;
        if (i1Var != null) {
            return i1Var.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f2211i.f4898i.getDrawable();
    }

    public CharSequence getHelperText() {
        r rVar = this.f2224p;
        if (rVar.f4947x) {
            return rVar.f4946w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        i1 i1Var = this.f2224p.f4948y;
        if (i1Var != null) {
            return i1Var.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.I) {
            return this.J;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.B0.d();
    }

    public final int getHintCurrentCollapsedTextColor() {
        b bVar = this.B0;
        return bVar.e(bVar.f3468k);
    }

    public ColorStateList getHintTextColor() {
        return this.f2225p0;
    }

    public z getLengthCounter() {
        return this.f2232t;
    }

    public int getMaxEms() {
        return this.f2219m;
    }

    public int getMaxWidth() {
        return this.o;
    }

    public int getMinEms() {
        return this.f2217l;
    }

    public int getMinWidth() {
        return this.f2221n;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f2211i.f4902m.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f2211i.f4902m.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f2242y) {
            return this.f2240x;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.B;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.A;
    }

    public CharSequence getPrefixText() {
        return this.f2209h.f4966i;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f2209h.f4965h.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f2209h.f4965h;
    }

    public j getShapeAppearanceModel() {
        return this.R;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f2209h.f4967j.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f2209h.f4967j.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f2209h.f4970m;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f2209h.f4971n;
    }

    public CharSequence getSuffixText() {
        return this.f2211i.f4910v;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f2211i.f4911w.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f2211i.f4911w;
    }

    public Typeface getTypeface() {
        return this.f2210h0;
    }

    public final int h(int i5, boolean z4) {
        return i5 - ((z4 || getSuffixText() == null) ? (!z4 || getPrefixText() == null) ? this.f2213j.getCompoundPaddingRight() : this.f2209h.a() : this.f2211i.c());
    }

    public final void i() {
        int i5 = this.U;
        if (i5 == 0) {
            this.L = null;
            this.P = null;
            this.Q = null;
        } else if (i5 == 1) {
            this.L = new p3.g(this.R);
            this.P = new p3.g();
            this.Q = new p3.g();
        } else if (i5 != 2) {
            throw new IllegalArgumentException(this.U + " is illegal; only @BoxBackgroundMode constants are supported.");
        } else {
            if (!this.I || (this.L instanceof s3.h)) {
                this.L = new p3.g(this.R);
            } else {
                j jVar = this.R;
                int i6 = s3.h.E;
                if (jVar == null) {
                    jVar = new j();
                }
                this.L = new s3.g(new s3.f(jVar, new RectF()));
            }
            this.P = null;
            this.Q = null;
        }
        s();
        x();
        if (this.U == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.V = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (a.B(getContext())) {
                this.V = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.f2213j != null && this.U == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText = this.f2213j;
                WeakHashMap weakHashMap = z0.f3233a;
                editText.setPaddingRelative(editText.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), this.f2213j.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (a.B(getContext())) {
                EditText editText2 = this.f2213j;
                WeakHashMap weakHashMap2 = z0.f3233a;
                editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), this.f2213j.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.U != 0) {
            t();
        }
        EditText editText3 = this.f2213j;
        if (editText3 instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText3;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i7 = this.U;
                if (i7 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i7 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    public final void j() {
        float f5;
        float f6;
        float f7;
        RectF rectF;
        float f8;
        int i5;
        int i6;
        if (e()) {
            int width = this.f2213j.getWidth();
            int gravity = this.f2213j.getGravity();
            b bVar = this.B0;
            boolean b5 = bVar.b(bVar.A);
            bVar.C = b5;
            Rect rect = bVar.f3458d;
            if (gravity != 17 && (gravity & 7) != 1) {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (b5) {
                        i6 = rect.left;
                        f7 = i6;
                    } else {
                        f5 = rect.right;
                        f6 = bVar.Z;
                    }
                } else if (b5) {
                    f5 = rect.right;
                    f6 = bVar.Z;
                } else {
                    i6 = rect.left;
                    f7 = i6;
                }
                float max = Math.max(f7, rect.left);
                rectF = this.f2208g0;
                rectF.left = max;
                rectF.top = rect.top;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f8 = (width / 2.0f) + (bVar.Z / 2.0f);
                } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (bVar.C) {
                        f8 = bVar.Z + max;
                    } else {
                        i5 = rect.right;
                        f8 = i5;
                    }
                } else if (bVar.C) {
                    i5 = rect.right;
                    f8 = i5;
                } else {
                    f8 = bVar.Z + max;
                }
                rectF.right = Math.min(f8, rect.right);
                rectF.bottom = bVar.d() + rect.top;
                if (rectF.width() > 0.0f || rectF.height() <= 0.0f) {
                }
                float f9 = rectF.left;
                float f10 = this.T;
                rectF.left = f9 - f10;
                rectF.right += f10;
                rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.W);
                s3.h hVar = (s3.h) this.L;
                hVar.getClass();
                hVar.n(rectF.left, rectF.top, rectF.right, rectF.bottom);
                return;
            }
            f5 = width / 2.0f;
            f6 = bVar.Z / 2.0f;
            f7 = f5 - f6;
            float max2 = Math.max(f7, rect.left);
            rectF = this.f2208g0;
            rectF.left = max2;
            rectF.top = rect.top;
            if (gravity != 17) {
            }
            f8 = (width / 2.0f) + (bVar.Z / 2.0f);
            rectF.right = Math.min(f8, rect.right);
            rectF.bottom = bVar.d() + rect.top;
            if (rectF.width() > 0.0f) {
            }
        }
    }

    public final void l(TextView textView, int i5) {
        boolean z4 = true;
        try {
            textView.setTextAppearance(i5);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z4 = false;
            }
        } catch (Exception unused) {
        }
        if (z4) {
            textView.setTextAppearance(2131952063);
            textView.setTextColor(x.b.a(getContext(), R.color.design_error));
        }
    }

    public final boolean m() {
        r rVar = this.f2224p;
        return (rVar.o != 1 || rVar.f4941r == null || TextUtils.isEmpty(rVar.f4939p)) ? false : true;
    }

    public final void n(Editable editable) {
        ((h) this.f2232t).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z4 = this.f2230s;
        int i5 = this.f2228r;
        String str = null;
        if (i5 == -1) {
            this.f2234u.setText(String.valueOf(length));
            this.f2234u.setContentDescription(null);
            this.f2230s = false;
        } else {
            this.f2230s = length > i5;
            this.f2234u.setContentDescription(getContext().getString(this.f2230s ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.f2228r)));
            if (z4 != this.f2230s) {
                o();
            }
            String str2 = f0.b.f2726d;
            f0.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? f0.b.f2729g : f0.b.f2728f;
            i1 i1Var = this.f2234u;
            String string = getContext().getString(R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.f2228r));
            if (string == null) {
                bVar.getClass();
            } else {
                str = bVar.c(string, bVar.f2732c).toString();
            }
            i1Var.setText(str);
        }
        if (this.f2213j == null || z4 == this.f2230s) {
            return;
        }
        u(false, false);
        x();
        r();
    }

    public final void o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        i1 i1Var = this.f2234u;
        if (i1Var != null) {
            l(i1Var, this.f2230s ? this.f2236v : this.f2238w);
            if (!this.f2230s && (colorStateList2 = this.E) != null) {
                this.f2234u.setTextColor(colorStateList2);
            }
            if (!this.f2230s || (colorStateList = this.F) == null) {
                return;
            }
            this.f2234u.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.B0.g(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int max;
        n nVar = this.f2211i;
        nVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z4 = false;
        this.H0 = false;
        if (this.f2213j != null && this.f2213j.getMeasuredHeight() < (max = Math.max(nVar.getMeasuredHeight(), this.f2209h.getMeasuredHeight()))) {
            this.f2213j.setMinimumHeight(max);
            z4 = true;
        }
        boolean q5 = q();
        if (z4 || q5) {
            this.f2213j.post(new d(13, this));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        EditText editText = this.f2213j;
        if (editText != null) {
            ThreadLocal threadLocal = c.f3483a;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.f2205e0;
            rect.set(0, 0, width, height);
            ThreadLocal threadLocal2 = c.f3483a;
            Matrix matrix = (Matrix) threadLocal2.get();
            if (matrix == null) {
                matrix = new Matrix();
                threadLocal2.set(matrix);
            } else {
                matrix.reset();
            }
            c.a(this, editText, matrix);
            ThreadLocal threadLocal3 = c.f3484b;
            RectF rectF = (RectF) threadLocal3.get();
            if (rectF == null) {
                rectF = new RectF();
                threadLocal3.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
            p3.g gVar = this.P;
            if (gVar != null) {
                int i9 = rect.bottom;
                gVar.setBounds(rect.left, i9 - this.f2201a0, rect.right, i9);
            }
            p3.g gVar2 = this.Q;
            if (gVar2 != null) {
                int i10 = rect.bottom;
                gVar2.setBounds(rect.left, i10 - this.f2202b0, rect.right, i10);
            }
            if (this.I) {
                float textSize = this.f2213j.getTextSize();
                b bVar = this.B0;
                if (bVar.f3465h != textSize) {
                    bVar.f3465h = textSize;
                    bVar.h(false);
                }
                int gravity = this.f2213j.getGravity();
                int i11 = (gravity & (-113)) | 48;
                if (bVar.f3464g != i11) {
                    bVar.f3464g = i11;
                    bVar.h(false);
                }
                if (bVar.f3462f != gravity) {
                    bVar.f3462f = gravity;
                    bVar.h(false);
                }
                if (this.f2213j == null) {
                    throw new IllegalStateException();
                }
                boolean C = a.C(this);
                int i12 = rect.bottom;
                Rect rect2 = this.f2206f0;
                rect2.bottom = i12;
                int i13 = this.U;
                if (i13 == 1) {
                    rect2.left = g(rect.left, C);
                    rect2.top = rect.top + this.V;
                    rect2.right = h(rect.right, C);
                } else if (i13 != 2) {
                    rect2.left = g(rect.left, C);
                    rect2.top = getPaddingTop();
                    rect2.right = h(rect.right, C);
                } else {
                    rect2.left = this.f2213j.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - c();
                    rect2.right = rect.right - this.f2213j.getPaddingRight();
                }
                int i14 = rect2.left;
                int i15 = rect2.top;
                int i16 = rect2.right;
                int i17 = rect2.bottom;
                Rect rect3 = bVar.f3458d;
                if (!(rect3.left == i14 && rect3.top == i15 && rect3.right == i16 && rect3.bottom == i17)) {
                    rect3.set(i14, i15, i16, i17);
                    bVar.M = true;
                }
                if (this.f2213j == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = bVar.O;
                textPaint.setTextSize(bVar.f3465h);
                textPaint.setTypeface(bVar.f3477u);
                textPaint.setLetterSpacing(bVar.W);
                float f5 = -textPaint.ascent();
                rect2.left = this.f2213j.getCompoundPaddingLeft() + rect.left;
                rect2.top = this.U == 1 && this.f2213j.getMinLines() <= 1 ? (int) (rect.centerY() - (f5 / 2.0f)) : rect.top + this.f2213j.getCompoundPaddingTop();
                rect2.right = rect.right - this.f2213j.getCompoundPaddingRight();
                int compoundPaddingBottom = this.U == 1 && this.f2213j.getMinLines() <= 1 ? (int) (rect2.top + f5) : rect.bottom - this.f2213j.getCompoundPaddingBottom();
                rect2.bottom = compoundPaddingBottom;
                int i18 = rect2.left;
                int i19 = rect2.top;
                int i20 = rect2.right;
                Rect rect4 = bVar.f3456c;
                if (!(rect4.left == i18 && rect4.top == i19 && rect4.right == i20 && rect4.bottom == compoundPaddingBottom)) {
                    rect4.set(i18, i19, i20, compoundPaddingBottom);
                    bVar.M = true;
                }
                bVar.h(false);
                if (!e() || this.A0) {
                    return;
                }
                j();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        EditText editText;
        super.onMeasure(i5, i6);
        boolean z4 = this.H0;
        n nVar = this.f2211i;
        if (!z4) {
            nVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.H0 = true;
        }
        if (this.f2244z != null && (editText = this.f2213j) != null) {
            this.f2244z.setGravity(editText.getGravity());
            this.f2244z.setPadding(this.f2213j.getCompoundPaddingLeft(), this.f2213j.getCompoundPaddingTop(), this.f2213j.getCompoundPaddingRight(), this.f2213j.getCompoundPaddingBottom());
        }
        nVar.m();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a0 a0Var = (a0) parcelable;
        super.onRestoreInstanceState(a0Var.f4245b);
        setError(a0Var.f4862d);
        if (a0Var.f4863e) {
            post(new androidx.activity.j(18, this));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        boolean z4 = i5 == 1;
        if (z4 != this.S) {
            p3.c cVar = this.R.f4318e;
            RectF rectF = this.f2208g0;
            float a5 = cVar.a(rectF);
            float a6 = this.R.f4319f.a(rectF);
            float a7 = this.R.f4321h.a(rectF);
            float a8 = this.R.f4320g.a(rectF);
            j jVar = this.R;
            i0 i0Var = jVar.f4314a;
            w1.h hVar = new w1.h(1);
            i0 i0Var2 = jVar.f4315b;
            hVar.f5334a = i0Var2;
            w1.h.b(i0Var2);
            hVar.f5335b = i0Var;
            w1.h.b(i0Var);
            i0 i0Var3 = jVar.f4316c;
            hVar.f5337d = i0Var3;
            w1.h.b(i0Var3);
            i0 i0Var4 = jVar.f4317d;
            hVar.f5336c = i0Var4;
            w1.h.b(i0Var4);
            hVar.f5338e = new p3.a(a6);
            hVar.f5339f = new p3.a(a5);
            hVar.f5341h = new p3.a(a8);
            hVar.f5340g = new p3.a(a7);
            j jVar2 = new j(hVar);
            this.S = z4;
            setShapeAppearanceModel(jVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        a0 a0Var = new a0(super.onSaveInstanceState());
        if (m()) {
            a0Var.f4862d = getError();
        }
        n nVar = this.f2211i;
        boolean z4 = true;
        if (!(nVar.o != 0) || !nVar.f4902m.isChecked()) {
            z4 = false;
        }
        a0Var.f4863e = z4;
        return a0Var;
    }

    public final void p() {
        Drawable textCursorDrawable;
        Drawable textCursorDrawable2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.G;
        if (colorStateList2 == null) {
            Context context = getContext();
            TypedValue N = e.N(context, R.attr.colorControlActivated);
            if (N != null) {
                int i5 = N.resourceId;
                if (i5 != 0) {
                    colorStateList2 = a.u(context, i5);
                } else {
                    int i6 = N.data;
                    if (i6 != 0) {
                        colorStateList2 = ColorStateList.valueOf(i6);
                    }
                }
            }
            colorStateList2 = null;
        }
        EditText editText = this.f2213j;
        if (editText != null) {
            textCursorDrawable = editText.getTextCursorDrawable();
            if (textCursorDrawable == null) {
                return;
            }
            textCursorDrawable2 = this.f2213j.getTextCursorDrawable();
            Drawable mutate = textCursorDrawable2.mutate();
            if ((m() || (this.f2234u != null && this.f2230s)) && (colorStateList = this.H) != null) {
                colorStateList2 = colorStateList;
            }
            a0.a.h(mutate, colorStateList2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0093, code lost:
        if (r3.d() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0097, code lost:
        if (r3.f4910v != null) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q() {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.q():boolean");
    }

    public final void r() {
        Drawable background;
        i1 i1Var;
        PorterDuffColorFilter g5;
        PorterDuffColorFilter g6;
        EditText editText = this.f2213j;
        if (editText == null || this.U != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = v1.f549a;
        Drawable mutate = background.mutate();
        if (m()) {
            int errorCurrentTextColors = getErrorCurrentTextColors();
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            PorterDuff.Mode mode2 = androidx.appcompat.widget.y.f596b;
            synchronized (androidx.appcompat.widget.y.class) {
                g6 = v2.g(errorCurrentTextColors, mode);
            }
            mutate.setColorFilter(g6);
        } else if (!this.f2230s || (i1Var = this.f2234u) == null) {
            mutate.clearColorFilter();
            this.f2213j.refreshDrawableState();
        } else {
            int currentTextColor = i1Var.getCurrentTextColor();
            PorterDuff.Mode mode3 = PorterDuff.Mode.SRC_IN;
            PorterDuff.Mode mode4 = androidx.appcompat.widget.y.f596b;
            synchronized (androidx.appcompat.widget.y.class) {
                g5 = v2.g(currentTextColor, mode3);
            }
            mutate.setColorFilter(g5);
        }
    }

    public final void s() {
        EditText editText = this.f2213j;
        if (editText == null || this.L == null) {
            return;
        }
        if ((this.O || editText.getBackground() == null) && this.U != 0) {
            Drawable editTextBoxBackground = getEditTextBoxBackground();
            EditText editText2 = this.f2213j;
            WeakHashMap weakHashMap = z0.f3233a;
            editText2.setBackground(editTextBoxBackground);
            this.O = true;
        }
    }

    public void setBoxBackgroundColor(int i5) {
        if (this.f2204d0 != i5) {
            this.f2204d0 = i5;
            this.f2235u0 = i5;
            this.f2239w0 = i5;
            this.f2241x0 = i5;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i5) {
        setBoxBackgroundColor(x.b.a(getContext(), i5));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f2235u0 = defaultColor;
        this.f2204d0 = defaultColor;
        this.f2237v0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f2239w0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f2241x0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i5) {
        if (i5 == this.U) {
            return;
        }
        this.U = i5;
        if (this.f2213j != null) {
            i();
        }
    }

    public void setBoxCollapsedPaddingTop(int i5) {
        this.V = i5;
    }

    public void setBoxCornerFamily(int i5) {
        j jVar = this.R;
        jVar.getClass();
        w1.h hVar = new w1.h(jVar);
        p3.c cVar = this.R.f4318e;
        i0 n5 = a.n(i5);
        hVar.f5334a = n5;
        w1.h.b(n5);
        hVar.f5338e = cVar;
        p3.c cVar2 = this.R.f4319f;
        i0 n6 = a.n(i5);
        hVar.f5335b = n6;
        w1.h.b(n6);
        hVar.f5339f = cVar2;
        p3.c cVar3 = this.R.f4321h;
        i0 n7 = a.n(i5);
        hVar.f5337d = n7;
        w1.h.b(n7);
        hVar.f5341h = cVar3;
        p3.c cVar4 = this.R.f4320g;
        i0 n8 = a.n(i5);
        hVar.f5336c = n8;
        w1.h.b(n8);
        hVar.f5340g = cVar4;
        this.R = new j(hVar);
        b();
    }

    public void setBoxStrokeColor(int i5) {
        if (this.f2231s0 != i5) {
            this.f2231s0 = i5;
            x();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f2227q0 = colorStateList.getDefaultColor();
            this.f2243y0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f2229r0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.f2231s0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.f2231s0 != colorStateList.getDefaultColor()) {
            this.f2231s0 = colorStateList.getDefaultColor();
        }
        x();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f2233t0 != colorStateList) {
            this.f2233t0 = colorStateList;
            x();
        }
    }

    public void setBoxStrokeWidth(int i5) {
        this.f2201a0 = i5;
        x();
    }

    public void setBoxStrokeWidthFocused(int i5) {
        this.f2202b0 = i5;
        x();
    }

    public void setBoxStrokeWidthFocusedResource(int i5) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i5));
    }

    public void setBoxStrokeWidthResource(int i5) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i5));
    }

    public void setCounterEnabled(boolean z4) {
        if (this.f2226q != z4) {
            r rVar = this.f2224p;
            if (z4) {
                i1 i1Var = new i1(getContext(), null);
                this.f2234u = i1Var;
                i1Var.setId(R.id.textinput_counter);
                Typeface typeface = this.f2210h0;
                if (typeface != null) {
                    this.f2234u.setTypeface(typeface);
                }
                this.f2234u.setMaxLines(1);
                rVar.a(this.f2234u, 2);
                ((ViewGroup.MarginLayoutParams) this.f2234u.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                o();
                if (this.f2234u != null) {
                    EditText editText = this.f2213j;
                    n(editText != null ? editText.getText() : null);
                }
            } else {
                rVar.g(this.f2234u, 2);
                this.f2234u = null;
            }
            this.f2226q = z4;
        }
    }

    public void setCounterMaxLength(int i5) {
        if (this.f2228r != i5) {
            if (i5 > 0) {
                this.f2228r = i5;
            } else {
                this.f2228r = -1;
            }
            if (!this.f2226q || this.f2234u == null) {
                return;
            }
            EditText editText = this.f2213j;
            n(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i5) {
        if (this.f2236v != i5) {
            this.f2236v = i5;
            o();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            o();
        }
    }

    public void setCounterTextAppearance(int i5) {
        if (this.f2238w != i5) {
            this.f2238w = i5;
            o();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            o();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            p();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            if (m() || (this.f2234u != null && this.f2230s)) {
                p();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f2223o0 = colorStateList;
        this.f2225p0 = colorStateList;
        if (this.f2213j != null) {
            u(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        k(this, z4);
        super.setEnabled(z4);
    }

    public void setEndIconActivated(boolean z4) {
        this.f2211i.f4902m.setActivated(z4);
    }

    public void setEndIconCheckable(boolean z4) {
        this.f2211i.f4902m.setCheckable(z4);
    }

    public void setEndIconContentDescription(int i5) {
        n nVar = this.f2211i;
        CharSequence text = i5 != 0 ? nVar.getResources().getText(i5) : null;
        CheckableImageButton checkableImageButton = nVar.f4902m;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i5) {
        n nVar = this.f2211i;
        Drawable x5 = i5 != 0 ? a.x(nVar.getContext(), i5) : null;
        CheckableImageButton checkableImageButton = nVar.f4902m;
        checkableImageButton.setImageDrawable(x5);
        if (x5 != null) {
            ColorStateList colorStateList = nVar.f4905q;
            PorterDuff.Mode mode = nVar.f4906r;
            TextInputLayout textInputLayout = nVar.f4896g;
            a.b(textInputLayout, checkableImageButton, colorStateList, mode);
            a.P(textInputLayout, checkableImageButton, nVar.f4905q);
        }
    }

    public void setEndIconMinSize(int i5) {
        n nVar = this.f2211i;
        if (i5 < 0) {
            nVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        } else if (i5 != nVar.f4907s) {
            nVar.f4907s = i5;
            CheckableImageButton checkableImageButton = nVar.f4902m;
            checkableImageButton.setMinimumWidth(i5);
            checkableImageButton.setMinimumHeight(i5);
            CheckableImageButton checkableImageButton2 = nVar.f4898i;
            checkableImageButton2.setMinimumWidth(i5);
            checkableImageButton2.setMinimumHeight(i5);
        }
    }

    public void setEndIconMode(int i5) {
        this.f2211i.g(i5);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        n nVar = this.f2211i;
        View.OnLongClickListener onLongClickListener = nVar.f4909u;
        CheckableImageButton checkableImageButton = nVar.f4902m;
        checkableImageButton.setOnClickListener(onClickListener);
        a.T(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        n nVar = this.f2211i;
        nVar.f4909u = onLongClickListener;
        CheckableImageButton checkableImageButton = nVar.f4902m;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a.T(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        n nVar = this.f2211i;
        nVar.f4908t = scaleType;
        nVar.f4902m.setScaleType(scaleType);
        nVar.f4898i.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        n nVar = this.f2211i;
        if (nVar.f4905q != colorStateList) {
            nVar.f4905q = colorStateList;
            a.b(nVar.f4896g, nVar.f4902m, colorStateList, nVar.f4906r);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        n nVar = this.f2211i;
        if (nVar.f4906r != mode) {
            nVar.f4906r = mode;
            a.b(nVar.f4896g, nVar.f4902m, nVar.f4905q, mode);
        }
    }

    public void setEndIconVisible(boolean z4) {
        this.f2211i.h(z4);
    }

    public void setError(CharSequence charSequence) {
        r rVar = this.f2224p;
        if (!rVar.f4940q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (TextUtils.isEmpty(charSequence)) {
            rVar.f();
            return;
        }
        rVar.c();
        rVar.f4939p = charSequence;
        rVar.f4941r.setText(charSequence);
        int i5 = rVar.f4938n;
        if (i5 != 1) {
            rVar.o = 1;
        }
        rVar.i(i5, rVar.h(rVar.f4941r, charSequence), rVar.o);
    }

    public void setErrorAccessibilityLiveRegion(int i5) {
        r rVar = this.f2224p;
        rVar.f4943t = i5;
        i1 i1Var = rVar.f4941r;
        if (i1Var != null) {
            WeakHashMap weakHashMap = z0.f3233a;
            i1Var.setAccessibilityLiveRegion(i5);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        r rVar = this.f2224p;
        rVar.f4942s = charSequence;
        i1 i1Var = rVar.f4941r;
        if (i1Var != null) {
            i1Var.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z4) {
        r rVar = this.f2224p;
        if (rVar.f4940q == z4) {
            return;
        }
        rVar.c();
        TextInputLayout textInputLayout = rVar.f4932h;
        if (z4) {
            i1 i1Var = new i1(rVar.f4931g, null);
            rVar.f4941r = i1Var;
            i1Var.setId(R.id.textinput_error);
            rVar.f4941r.setTextAlignment(5);
            Typeface typeface = rVar.B;
            if (typeface != null) {
                rVar.f4941r.setTypeface(typeface);
            }
            int i5 = rVar.f4944u;
            rVar.f4944u = i5;
            i1 i1Var2 = rVar.f4941r;
            if (i1Var2 != null) {
                textInputLayout.l(i1Var2, i5);
            }
            ColorStateList colorStateList = rVar.f4945v;
            rVar.f4945v = colorStateList;
            i1 i1Var3 = rVar.f4941r;
            if (i1Var3 != null && colorStateList != null) {
                i1Var3.setTextColor(colorStateList);
            }
            CharSequence charSequence = rVar.f4942s;
            rVar.f4942s = charSequence;
            i1 i1Var4 = rVar.f4941r;
            if (i1Var4 != null) {
                i1Var4.setContentDescription(charSequence);
            }
            int i6 = rVar.f4943t;
            rVar.f4943t = i6;
            i1 i1Var5 = rVar.f4941r;
            if (i1Var5 != null) {
                WeakHashMap weakHashMap = z0.f3233a;
                i1Var5.setAccessibilityLiveRegion(i6);
            }
            rVar.f4941r.setVisibility(4);
            rVar.a(rVar.f4941r, 0);
        } else {
            rVar.f();
            rVar.g(rVar.f4941r, 0);
            rVar.f4941r = null;
            textInputLayout.r();
            textInputLayout.x();
        }
        rVar.f4940q = z4;
    }

    public void setErrorIconDrawable(int i5) {
        n nVar = this.f2211i;
        nVar.i(i5 != 0 ? a.x(nVar.getContext(), i5) : null);
        a.P(nVar.f4896g, nVar.f4898i, nVar.f4899j);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        n nVar = this.f2211i;
        CheckableImageButton checkableImageButton = nVar.f4898i;
        View.OnLongClickListener onLongClickListener = nVar.f4901l;
        checkableImageButton.setOnClickListener(onClickListener);
        a.T(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        n nVar = this.f2211i;
        nVar.f4901l = onLongClickListener;
        CheckableImageButton checkableImageButton = nVar.f4898i;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a.T(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        n nVar = this.f2211i;
        if (nVar.f4899j != colorStateList) {
            nVar.f4899j = colorStateList;
            a.b(nVar.f4896g, nVar.f4898i, colorStateList, nVar.f4900k);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        n nVar = this.f2211i;
        if (nVar.f4900k != mode) {
            nVar.f4900k = mode;
            a.b(nVar.f4896g, nVar.f4898i, nVar.f4899j, mode);
        }
    }

    public void setErrorTextAppearance(int i5) {
        r rVar = this.f2224p;
        rVar.f4944u = i5;
        i1 i1Var = rVar.f4941r;
        if (i1Var != null) {
            rVar.f4932h.l(i1Var, i5);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        r rVar = this.f2224p;
        rVar.f4945v = colorStateList;
        i1 i1Var = rVar.f4941r;
        if (i1Var == null || colorStateList == null) {
            return;
        }
        i1Var.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z4) {
        if (this.C0 != z4) {
            this.C0 = z4;
            u(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        r rVar = this.f2224p;
        if (isEmpty) {
            if (rVar.f4947x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!rVar.f4947x) {
            setHelperTextEnabled(true);
        }
        rVar.c();
        rVar.f4946w = charSequence;
        rVar.f4948y.setText(charSequence);
        int i5 = rVar.f4938n;
        if (i5 != 2) {
            rVar.o = 2;
        }
        rVar.i(i5, rVar.h(rVar.f4948y, charSequence), rVar.o);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        r rVar = this.f2224p;
        rVar.A = colorStateList;
        i1 i1Var = rVar.f4948y;
        if (i1Var == null || colorStateList == null) {
            return;
        }
        i1Var.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z4) {
        r rVar = this.f2224p;
        if (rVar.f4947x == z4) {
            return;
        }
        rVar.c();
        if (z4) {
            i1 i1Var = new i1(rVar.f4931g, null);
            rVar.f4948y = i1Var;
            i1Var.setId(R.id.textinput_helper_text);
            rVar.f4948y.setTextAlignment(5);
            Typeface typeface = rVar.B;
            if (typeface != null) {
                rVar.f4948y.setTypeface(typeface);
            }
            rVar.f4948y.setVisibility(4);
            rVar.f4948y.setAccessibilityLiveRegion(1);
            int i5 = rVar.f4949z;
            rVar.f4949z = i5;
            i1 i1Var2 = rVar.f4948y;
            if (i1Var2 != null) {
                i1Var2.setTextAppearance(i5);
            }
            ColorStateList colorStateList = rVar.A;
            rVar.A = colorStateList;
            i1 i1Var3 = rVar.f4948y;
            if (i1Var3 != null && colorStateList != null) {
                i1Var3.setTextColor(colorStateList);
            }
            rVar.a(rVar.f4948y, 1);
            rVar.f4948y.setAccessibilityDelegate(new q(rVar));
        } else {
            rVar.c();
            int i6 = rVar.f4938n;
            if (i6 == 2) {
                rVar.o = 0;
            }
            rVar.i(i6, rVar.h(rVar.f4948y, ""), rVar.o);
            rVar.g(rVar.f4948y, 1);
            rVar.f4948y = null;
            TextInputLayout textInputLayout = rVar.f4932h;
            textInputLayout.r();
            textInputLayout.x();
        }
        rVar.f4947x = z4;
    }

    public void setHelperTextTextAppearance(int i5) {
        r rVar = this.f2224p;
        rVar.f4949z = i5;
        i1 i1Var = rVar.f4948y;
        if (i1Var != null) {
            i1Var.setTextAppearance(i5);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.I) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z4) {
        this.D0 = z4;
    }

    public void setHintEnabled(boolean z4) {
        if (z4 != this.I) {
            this.I = z4;
            if (z4) {
                CharSequence hint = this.f2213j.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.J)) {
                        setHint(hint);
                    }
                    this.f2213j.setHint((CharSequence) null);
                }
                this.K = true;
            } else {
                this.K = false;
                if (!TextUtils.isEmpty(this.J) && TextUtils.isEmpty(this.f2213j.getHint())) {
                    this.f2213j.setHint(this.J);
                }
                setHintInternal(null);
            }
            if (this.f2213j != null) {
                t();
            }
        }
    }

    public void setHintTextAppearance(int i5) {
        b bVar = this.B0;
        View view = bVar.f3452a;
        m3.d dVar = new m3.d(view.getContext(), i5);
        ColorStateList colorStateList = dVar.f3981j;
        if (colorStateList != null) {
            bVar.f3468k = colorStateList;
        }
        float f5 = dVar.f3982k;
        if (f5 != 0.0f) {
            bVar.f3466i = f5;
        }
        ColorStateList colorStateList2 = dVar.f3972a;
        if (colorStateList2 != null) {
            bVar.U = colorStateList2;
        }
        bVar.S = dVar.f3976e;
        bVar.T = dVar.f3977f;
        bVar.R = dVar.f3978g;
        bVar.V = dVar.f3980i;
        m3.a aVar = bVar.f3481y;
        if (aVar != null) {
            aVar.f3965w = true;
        }
        n2.b bVar2 = new n2.b(bVar);
        dVar.a();
        bVar.f3481y = new m3.a(bVar2, dVar.f3985n);
        dVar.c(view.getContext(), bVar.f3481y);
        bVar.h(false);
        this.f2225p0 = bVar.f3468k;
        if (this.f2213j != null) {
            u(false, false);
            t();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f2225p0 != colorStateList) {
            if (this.f2223o0 == null) {
                b bVar = this.B0;
                if (bVar.f3468k != colorStateList) {
                    bVar.f3468k = colorStateList;
                    bVar.h(false);
                }
            }
            this.f2225p0 = colorStateList;
            if (this.f2213j != null) {
                u(false, false);
            }
        }
    }

    public void setLengthCounter(z zVar) {
        this.f2232t = zVar;
    }

    public void setMaxEms(int i5) {
        this.f2219m = i5;
        EditText editText = this.f2213j;
        if (editText == null || i5 == -1) {
            return;
        }
        editText.setMaxEms(i5);
    }

    public void setMaxWidth(int i5) {
        this.o = i5;
        EditText editText = this.f2213j;
        if (editText == null || i5 == -1) {
            return;
        }
        editText.setMaxWidth(i5);
    }

    public void setMaxWidthResource(int i5) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i5));
    }

    public void setMinEms(int i5) {
        this.f2217l = i5;
        EditText editText = this.f2213j;
        if (editText == null || i5 == -1) {
            return;
        }
        editText.setMinEms(i5);
    }

    public void setMinWidth(int i5) {
        this.f2221n = i5;
        EditText editText = this.f2213j;
        if (editText == null || i5 == -1) {
            return;
        }
        editText.setMinWidth(i5);
    }

    public void setMinWidthResource(int i5) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i5));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i5) {
        n nVar = this.f2211i;
        nVar.f4902m.setContentDescription(i5 != 0 ? nVar.getResources().getText(i5) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i5) {
        n nVar = this.f2211i;
        nVar.f4902m.setImageDrawable(i5 != 0 ? a.x(nVar.getContext(), i5) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z4) {
        n nVar = this.f2211i;
        if (z4 && nVar.o != 1) {
            nVar.g(1);
        } else if (z4) {
            nVar.getClass();
        } else {
            nVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        n nVar = this.f2211i;
        nVar.f4905q = colorStateList;
        a.b(nVar.f4896g, nVar.f4902m, colorStateList, nVar.f4906r);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        n nVar = this.f2211i;
        nVar.f4906r = mode;
        a.b(nVar.f4896g, nVar.f4902m, nVar.f4905q, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f2244z == null) {
            i1 i1Var = new i1(getContext(), null);
            this.f2244z = i1Var;
            i1Var.setId(R.id.textinput_placeholder);
            this.f2244z.setImportantForAccessibility(2);
            g d5 = d();
            this.C = d5;
            d5.f2652c = 67L;
            this.D = d();
            setPlaceholderTextAppearance(this.B);
            setPlaceholderTextColor(this.A);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f2242y) {
                setPlaceholderTextEnabled(true);
            }
            this.f2240x = charSequence;
        }
        EditText editText = this.f2213j;
        v(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i5) {
        this.B = i5;
        i1 i1Var = this.f2244z;
        if (i1Var != null) {
            i1Var.setTextAppearance(i5);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            i1 i1Var = this.f2244z;
            if (i1Var == null || colorStateList == null) {
                return;
            }
            i1Var.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        w wVar = this.f2209h;
        wVar.getClass();
        wVar.f4966i = TextUtils.isEmpty(charSequence) ? null : charSequence;
        wVar.f4965h.setText(charSequence);
        wVar.e();
    }

    public void setPrefixTextAppearance(int i5) {
        this.f2209h.f4965h.setTextAppearance(i5);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f2209h.f4965h.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(j jVar) {
        p3.g gVar = this.L;
        if (gVar == null || gVar.f4294g.f4274a == jVar) {
            return;
        }
        this.R = jVar;
        b();
    }

    public void setStartIconCheckable(boolean z4) {
        this.f2209h.f4967j.setCheckable(z4);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f2209h.f4967j;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i5) {
        setStartIconDrawable(i5 != 0 ? a.x(getContext(), i5) : null);
    }

    public void setStartIconMinSize(int i5) {
        w wVar = this.f2209h;
        if (i5 < 0) {
            wVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        } else if (i5 != wVar.f4970m) {
            wVar.f4970m = i5;
            CheckableImageButton checkableImageButton = wVar.f4967j;
            checkableImageButton.setMinimumWidth(i5);
            checkableImageButton.setMinimumHeight(i5);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        w wVar = this.f2209h;
        View.OnLongClickListener onLongClickListener = wVar.o;
        CheckableImageButton checkableImageButton = wVar.f4967j;
        checkableImageButton.setOnClickListener(onClickListener);
        a.T(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        w wVar = this.f2209h;
        wVar.o = onLongClickListener;
        CheckableImageButton checkableImageButton = wVar.f4967j;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a.T(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        w wVar = this.f2209h;
        wVar.f4971n = scaleType;
        wVar.f4967j.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        w wVar = this.f2209h;
        if (wVar.f4968k != colorStateList) {
            wVar.f4968k = colorStateList;
            a.b(wVar.f4964g, wVar.f4967j, colorStateList, wVar.f4969l);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        w wVar = this.f2209h;
        if (wVar.f4969l != mode) {
            wVar.f4969l = mode;
            a.b(wVar.f4964g, wVar.f4967j, wVar.f4968k, mode);
        }
    }

    public void setStartIconVisible(boolean z4) {
        this.f2209h.c(z4);
    }

    public void setSuffixText(CharSequence charSequence) {
        n nVar = this.f2211i;
        nVar.getClass();
        nVar.f4910v = TextUtils.isEmpty(charSequence) ? null : charSequence;
        nVar.f4911w.setText(charSequence);
        nVar.n();
    }

    public void setSuffixTextAppearance(int i5) {
        this.f2211i.f4911w.setTextAppearance(i5);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f2211i.f4911w.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(y yVar) {
        EditText editText = this.f2213j;
        if (editText != null) {
            z0.n(editText, yVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f2210h0) {
            this.f2210h0 = typeface;
            this.B0.m(typeface);
            r rVar = this.f2224p;
            if (typeface != rVar.B) {
                rVar.B = typeface;
                i1 i1Var = rVar.f4941r;
                if (i1Var != null) {
                    i1Var.setTypeface(typeface);
                }
                i1 i1Var2 = rVar.f4948y;
                if (i1Var2 != null) {
                    i1Var2.setTypeface(typeface);
                }
            }
            i1 i1Var3 = this.f2234u;
            if (i1Var3 != null) {
                i1Var3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        if (this.U != 1) {
            FrameLayout frameLayout = this.f2207g;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int c5 = c();
            if (c5 != layoutParams.topMargin) {
                layoutParams.topMargin = c5;
                frameLayout.requestLayout();
            }
        }
    }

    public final void u(boolean z4, boolean z5) {
        ColorStateList colorStateList;
        i1 i1Var;
        boolean isEnabled = isEnabled();
        EditText editText = this.f2213j;
        boolean z6 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f2213j;
        boolean z7 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f2223o0;
        b bVar = this.B0;
        if (colorStateList2 != null) {
            bVar.i(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f2223o0;
            bVar.i(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f2243y0) : this.f2243y0));
        } else if (m()) {
            i1 i1Var2 = this.f2224p.f4941r;
            bVar.i(i1Var2 != null ? i1Var2.getTextColors() : null);
        } else if (this.f2230s && (i1Var = this.f2234u) != null) {
            bVar.i(i1Var.getTextColors());
        } else if (z7 && (colorStateList = this.f2225p0) != null && bVar.f3468k != colorStateList) {
            bVar.f3468k = colorStateList;
            bVar.h(false);
        }
        n nVar = this.f2211i;
        w wVar = this.f2209h;
        if (z6 || !this.C0 || (isEnabled() && z7)) {
            if (z5 || this.A0) {
                ValueAnimator valueAnimator = this.E0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.E0.cancel();
                }
                if (z4 && this.D0) {
                    a(1.0f);
                } else {
                    bVar.k(1.0f);
                }
                this.A0 = false;
                if (e()) {
                    j();
                }
                EditText editText3 = this.f2213j;
                v(editText3 != null ? editText3.getText() : null);
                wVar.f4972p = false;
                wVar.e();
                nVar.f4912x = false;
                nVar.n();
            }
        } else if (z5 || !this.A0) {
            ValueAnimator valueAnimator2 = this.E0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.E0.cancel();
            }
            if (z4 && this.D0) {
                a(0.0f);
            } else {
                bVar.k(0.0f);
            }
            if (e() && (!((s3.h) this.L).D.f4878v.isEmpty()) && e()) {
                ((s3.h) this.L).n(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.A0 = true;
            i1 i1Var3 = this.f2244z;
            if (i1Var3 != null && this.f2242y) {
                i1Var3.setText((CharSequence) null);
                v.a(this.f2207g, this.D);
                this.f2244z.setVisibility(4);
            }
            wVar.f4972p = true;
            wVar.e();
            nVar.f4912x = true;
            nVar.n();
        }
    }

    public final void v(Editable editable) {
        ((h) this.f2232t).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f2207g;
        if (length != 0 || this.A0) {
            i1 i1Var = this.f2244z;
            if (i1Var == null || !this.f2242y) {
                return;
            }
            i1Var.setText((CharSequence) null);
            v.a(frameLayout, this.D);
            this.f2244z.setVisibility(4);
        } else if (this.f2244z == null || !this.f2242y || TextUtils.isEmpty(this.f2240x)) {
        } else {
            this.f2244z.setText(this.f2240x);
            v.a(frameLayout, this.C);
            this.f2244z.setVisibility(0);
            this.f2244z.bringToFront();
            announceForAccessibility(this.f2240x);
        }
    }

    public final void w(boolean z4, boolean z5) {
        int defaultColor = this.f2233t0.getDefaultColor();
        int colorForState = this.f2233t0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.f2233t0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z4) {
            this.f2203c0 = colorForState2;
        } else if (z5) {
            this.f2203c0 = colorForState;
        } else {
            this.f2203c0 = defaultColor;
        }
    }

    public final void x() {
        i1 i1Var;
        EditText editText;
        EditText editText2;
        if (this.L == null || this.U == 0) {
            return;
        }
        boolean z4 = false;
        boolean z5 = isFocused() || ((editText2 = this.f2213j) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f2213j) != null && editText.isHovered())) {
            z4 = true;
        }
        if (!isEnabled()) {
            this.f2203c0 = this.f2243y0;
        } else if (m()) {
            if (this.f2233t0 != null) {
                w(z5, z4);
            } else {
                this.f2203c0 = getErrorCurrentTextColors();
            }
        } else if (!this.f2230s || (i1Var = this.f2234u) == null) {
            if (z5) {
                this.f2203c0 = this.f2231s0;
            } else if (z4) {
                this.f2203c0 = this.f2229r0;
            } else {
                this.f2203c0 = this.f2227q0;
            }
        } else if (this.f2233t0 != null) {
            w(z5, z4);
        } else {
            this.f2203c0 = i1Var.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            p();
        }
        n nVar = this.f2211i;
        nVar.l();
        CheckableImageButton checkableImageButton = nVar.f4898i;
        ColorStateList colorStateList = nVar.f4899j;
        TextInputLayout textInputLayout = nVar.f4896g;
        a.P(textInputLayout, checkableImageButton, colorStateList);
        ColorStateList colorStateList2 = nVar.f4905q;
        CheckableImageButton checkableImageButton2 = nVar.f4902m;
        a.P(textInputLayout, checkableImageButton2, colorStateList2);
        if (nVar.b() instanceof k) {
            if (!textInputLayout.m() || checkableImageButton2.getDrawable() == null) {
                a.b(textInputLayout, checkableImageButton2, nVar.f4905q, nVar.f4906r);
            } else {
                Drawable mutate = checkableImageButton2.getDrawable().mutate();
                a0.a.g(mutate, textInputLayout.getErrorCurrentTextColors());
                checkableImageButton2.setImageDrawable(mutate);
            }
        }
        w wVar = this.f2209h;
        a.P(wVar.f4964g, wVar.f4967j, wVar.f4968k);
        if (this.U == 2) {
            int i5 = this.W;
            if (z5 && isEnabled()) {
                this.W = this.f2202b0;
            } else {
                this.W = this.f2201a0;
            }
            if (this.W != i5 && e() && !this.A0) {
                if (e()) {
                    ((s3.h) this.L).n(0.0f, 0.0f, 0.0f, 0.0f);
                }
                j();
            }
        }
        if (this.U == 1) {
            if (!isEnabled()) {
                this.f2204d0 = this.f2237v0;
            } else if (z4 && !z5) {
                this.f2204d0 = this.f2241x0;
            } else if (z5) {
                this.f2204d0 = this.f2239w0;
            } else {
                this.f2204d0 = this.f2235u0;
            }
        }
        b();
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f2209h.b(drawable);
    }

    public void setHint(int i5) {
        setHint(i5 != 0 ? getResources().getText(i5) : null);
    }

    public void setStartIconContentDescription(int i5) {
        setStartIconContentDescription(i5 != 0 ? getResources().getText(i5) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f2211i.f4902m.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f2211i.f4902m.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f2211i.i(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f2211i.f4902m;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        n nVar = this.f2211i;
        CheckableImageButton checkableImageButton = nVar.f4902m;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = nVar.f4905q;
            PorterDuff.Mode mode = nVar.f4906r;
            TextInputLayout textInputLayout = nVar.f4896g;
            a.b(textInputLayout, checkableImageButton, colorStateList, mode);
            a.P(textInputLayout, checkableImageButton, nVar.f4905q);
        }
    }
}

package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.github.appintro.R;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: a0  reason: collision with root package name */
    public static final b3 f225a0 = new b3(Float.class, "thumbPos", 0);

    /* renamed from: b0  reason: collision with root package name */
    public static final int[] f226b0 = {16842912};
    public final int A;
    public float B;
    public float C;
    public final VelocityTracker D;
    public final int E;
    public float F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public boolean N;
    public final TextPaint O;
    public ColorStateList P;
    public StaticLayout Q;
    public StaticLayout R;
    public f.a S;
    public ObjectAnimator T;
    public e0 U;
    public c3 V;
    public final Rect W;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f227g;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f228h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuff.Mode f229i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f230j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f231k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f232l;

    /* renamed from: m  reason: collision with root package name */
    public ColorStateList f233m;

    /* renamed from: n  reason: collision with root package name */
    public PorterDuff.Mode f234n;
    public boolean o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f235p;

    /* renamed from: q  reason: collision with root package name */
    public int f236q;

    /* renamed from: r  reason: collision with root package name */
    public int f237r;

    /* renamed from: s  reason: collision with root package name */
    public int f238s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f239t;

    /* renamed from: u  reason: collision with root package name */
    public CharSequence f240u;

    /* renamed from: v  reason: collision with root package name */
    public CharSequence f241v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f242w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f243x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f244y;

    /* renamed from: z  reason: collision with root package name */
    public int f245z;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.switchStyle);
        int resourceId;
        this.f228h = null;
        this.f229i = null;
        this.f230j = false;
        this.f231k = false;
        this.f233m = null;
        this.f234n = null;
        this.o = false;
        this.f235p = false;
        this.D = VelocityTracker.obtain();
        this.N = true;
        this.W = new Rect();
        d3.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.O = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = c.a.f1704v;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.switchStyle, 0);
        z2 z2Var = new z2(context, obtainStyledAttributes);
        h0.z0.m(this, context, iArr, attributeSet, obtainStyledAttributes, R.attr.switchStyle);
        Drawable e5 = z2Var.e(2);
        this.f227g = e5;
        if (e5 != null) {
            e5.setCallback(this);
        }
        Drawable e6 = z2Var.e(11);
        this.f232l = e6;
        if (e6 != null) {
            e6.setCallback(this);
        }
        setTextOnInternal(z2Var.k(0));
        setTextOffInternal(z2Var.k(1));
        this.f244y = z2Var.a(3, true);
        this.f236q = z2Var.d(8, 0);
        this.f237r = z2Var.d(5, 0);
        this.f238s = z2Var.d(6, 0);
        this.f239t = z2Var.a(4, false);
        ColorStateList b5 = z2Var.b(9);
        if (b5 != null) {
            this.f228h = b5;
            this.f230j = true;
        }
        PorterDuff.Mode c5 = v1.c(z2Var.h(10, -1), null);
        if (this.f229i != c5) {
            this.f229i = c5;
            this.f231k = true;
        }
        if (this.f230j || this.f231k) {
            a();
        }
        ColorStateList b6 = z2Var.b(12);
        if (b6 != null) {
            this.f233m = b6;
            this.o = true;
        }
        PorterDuff.Mode c6 = v1.c(z2Var.h(13, -1), null);
        if (this.f234n != c6) {
            this.f234n = c6;
            this.f235p = true;
        }
        if (this.o || this.f235p) {
            b();
        }
        int i5 = z2Var.i(7, 0);
        if (i5 != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i5, c.a.f1705w);
            ColorStateList colorStateList = (!obtainStyledAttributes2.hasValue(3) || (resourceId = obtainStyledAttributes2.getResourceId(3, 0)) == 0 || (colorStateList = p2.a.u(context, resourceId)) == null) ? obtainStyledAttributes2.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.P = colorStateList;
            } else {
                this.P = getTextColors();
            }
            int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f5 = dimensionPixelSize;
                if (f5 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f5);
                    requestLayout();
                }
            }
            int i6 = obtainStyledAttributes2.getInt(1, -1);
            int i7 = obtainStyledAttributes2.getInt(2, -1);
            Typeface typeface = i6 != 1 ? i6 != 2 ? i6 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i7 > 0) {
                Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i7) : Typeface.create(typeface, i7);
                setSwitchTypeface(defaultFromStyle);
                int i8 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i7;
                textPaint.setFakeBoldText((i8 & 1) != 0);
                textPaint.setTextSkewX((i8 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes2.getBoolean(14, false)) {
                this.S = new f.a(getContext());
            } else {
                this.S = null;
            }
            setTextOnInternal(this.f240u);
            setTextOffInternal(this.f242w);
            obtainStyledAttributes2.recycle();
        }
        new e1(this).f(attributeSet, R.attr.switchStyle);
        z2Var.n();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.A = viewConfiguration.getScaledTouchSlop();
        this.E = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, R.attr.switchStyle);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private e0 getEmojiTextViewHelper() {
        if (this.U == null) {
            this.U = new e0(this);
        }
        return this.U;
    }

    private boolean getTargetCheckedState() {
        return this.F > 0.5f;
    }

    private int getThumbOffset() {
        boolean z4 = v3.f560a;
        return (int) (((getLayoutDirection() == 1 ? 1.0f - this.F : this.F) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f232l;
        if (drawable != null) {
            Rect rect = this.W;
            drawable.getPadding(rect);
            Drawable drawable2 = this.f227g;
            Rect b5 = drawable2 != null ? v1.b(drawable2) : v1.f551c;
            return ((((this.G - this.I) - rect.left) - rect.right) - b5.left) - b5.right;
        }
        return 0;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f242w = charSequence;
        e0 emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod z4 = ((p3.e) emojiTextViewHelper.f320b.f2463h).z(this.S);
        if (z4 != null) {
            charSequence = z4.getTransformation(charSequence, this);
        }
        this.f243x = charSequence;
        this.R = null;
        if (this.f244y) {
            e();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f240u = charSequence;
        e0 emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod z4 = ((p3.e) emojiTextViewHelper.f320b.f2463h).z(this.S);
        if (z4 != null) {
            charSequence = z4.getTransformation(charSequence, this);
        }
        this.f241v = charSequence;
        this.Q = null;
        if (this.f244y) {
            e();
        }
    }

    public final void a() {
        Drawable drawable = this.f227g;
        if (drawable != null) {
            if (this.f230j || this.f231k) {
                Drawable mutate = drawable.mutate();
                this.f227g = mutate;
                if (this.f230j) {
                    a0.a.h(mutate, this.f228h);
                }
                if (this.f231k) {
                    a0.a.i(this.f227g, this.f229i);
                }
                if (this.f227g.isStateful()) {
                    this.f227g.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f232l;
        if (drawable != null) {
            if (this.o || this.f235p) {
                Drawable mutate = drawable.mutate();
                this.f232l = mutate;
                if (this.o) {
                    a0.a.h(mutate, this.f233m);
                }
                if (this.f235p) {
                    a0.a.i(this.f232l, this.f234n);
                }
                if (this.f232l.isStateful()) {
                    this.f232l.setState(getDrawableState());
                }
            }
        }
    }

    public final StaticLayout c(CharSequence charSequence) {
        TextPaint textPaint = this.O;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public final void d() {
        setTextOnInternal(this.f240u);
        setTextOffInternal(this.f242w);
        requestLayout();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i5;
        int i6;
        int i7 = this.J;
        int i8 = this.K;
        int i9 = this.L;
        int i10 = this.M;
        int thumbOffset = getThumbOffset() + i7;
        Drawable drawable = this.f227g;
        Rect b5 = drawable != null ? v1.b(drawable) : v1.f551c;
        Drawable drawable2 = this.f232l;
        Rect rect = this.W;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i11 = rect.left;
            thumbOffset += i11;
            if (b5 != null) {
                int i12 = b5.left;
                if (i12 > i11) {
                    i7 += i12 - i11;
                }
                int i13 = b5.top;
                int i14 = rect.top;
                i5 = i13 > i14 ? (i13 - i14) + i8 : i8;
                int i15 = b5.right;
                int i16 = rect.right;
                if (i15 > i16) {
                    i9 -= i15 - i16;
                }
                int i17 = b5.bottom;
                int i18 = rect.bottom;
                if (i17 > i18) {
                    i6 = i10 - (i17 - i18);
                    this.f232l.setBounds(i7, i5, i9, i6);
                }
            } else {
                i5 = i8;
            }
            i6 = i10;
            this.f232l.setBounds(i7, i5, i9, i6);
        }
        Drawable drawable3 = this.f227g;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i19 = thumbOffset - rect.left;
            int i20 = thumbOffset + this.I + rect.right;
            this.f227g.setBounds(i19, i8, i20, i10);
            Drawable background = getBackground();
            if (background != null) {
                a0.a.f(background, i19, i8, i20, i10);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f5, float f6) {
        super.drawableHotspotChanged(f5, f6);
        Drawable drawable = this.f227g;
        if (drawable != null) {
            a0.a.e(drawable, f5, f6);
        }
        Drawable drawable2 = this.f232l;
        if (drawable2 != null) {
            a0.a.e(drawable2, f5, f6);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f227g;
        boolean z4 = false;
        if (drawable != null && drawable.isStateful()) {
            z4 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f232l;
        if (drawable2 != null && drawable2.isStateful()) {
            z4 |= drawable2.setState(drawableState);
        }
        if (z4) {
            invalidate();
        }
    }

    public final void e() {
        if (this.V == null && ((p3.e) this.U.f320b.f2463h).p()) {
            if (androidx.emoji2.text.m.f769k != null) {
                androidx.emoji2.text.m a5 = androidx.emoji2.text.m.a();
                int b5 = a5.b();
                if (b5 == 3 || b5 == 0) {
                    c3 c3Var = new c3(this);
                    this.V = c3Var;
                    a5.g(c3Var);
                }
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        boolean z4 = v3.f560a;
        if (getLayoutDirection() == 1) {
            int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.G;
            return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f238s : compoundPaddingLeft;
        }
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        boolean z4 = v3.f560a;
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.G;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f238s : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return b4.j.e0(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f244y;
    }

    public boolean getSplitTrack() {
        return this.f239t;
    }

    public int getSwitchMinWidth() {
        return this.f237r;
    }

    public int getSwitchPadding() {
        return this.f238s;
    }

    public CharSequence getTextOff() {
        return this.f242w;
    }

    public CharSequence getTextOn() {
        return this.f240u;
    }

    public Drawable getThumbDrawable() {
        return this.f227g;
    }

    public final float getThumbPosition() {
        return this.F;
    }

    public int getThumbTextPadding() {
        return this.f236q;
    }

    public ColorStateList getThumbTintList() {
        return this.f228h;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f229i;
    }

    public Drawable getTrackDrawable() {
        return this.f232l;
    }

    public ColorStateList getTrackTintList() {
        return this.f233m;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f234n;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f227g;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f232l;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.T;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.T.end();
        this.T = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i5) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f226b0);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f232l;
        Rect rect = this.W;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i5 = this.K;
        int i6 = this.M;
        int i7 = i5 + rect.top;
        int i8 = i6 - rect.bottom;
        Drawable drawable2 = this.f227g;
        if (drawable != null) {
            if (!this.f239t || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect b5 = v1.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += b5.left;
                rect.right -= b5.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.Q : this.R;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.P;
            TextPaint textPaint = this.O;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i7 + i8) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f240u : this.f242w;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int width;
        int i11;
        int i12;
        int i13;
        super.onLayout(z4, i5, i6, i7, i8);
        if (this.f227g != null) {
            Drawable drawable = this.f232l;
            Rect rect = this.W;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect b5 = v1.b(this.f227g);
            i10 = Math.max(0, b5.left - rect.left);
            i9 = Math.max(0, b5.right - rect.right);
        } else {
            i9 = 0;
            i10 = 0;
        }
        boolean z5 = v3.f560a;
        if (getLayoutDirection() == 1) {
            i11 = getPaddingLeft() + i10;
            width = ((this.G + i11) - i10) - i9;
        } else {
            width = (getWidth() - getPaddingRight()) - i9;
            i11 = (width - this.G) + i10 + i9;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = getPaddingTop();
            int i14 = this.H;
            int height = (((getHeight() + paddingTop) - getPaddingBottom()) / 2) - (i14 / 2);
            i12 = i14 + height;
            i13 = height;
        } else if (gravity != 80) {
            i13 = getPaddingTop();
            i12 = this.H + i13;
        } else {
            i12 = getHeight() - getPaddingBottom();
            i13 = i12 - this.H;
        }
        this.J = i11;
        this.K = i13;
        this.M = i12;
        this.L = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        if (this.f244y) {
            if (this.Q == null) {
                this.Q = c(this.f241v);
            }
            if (this.R == null) {
                this.R = c(this.f243x);
            }
        }
        Drawable drawable = this.f227g;
        int i9 = 0;
        Rect rect = this.W;
        if (drawable != null) {
            drawable.getPadding(rect);
            i7 = (this.f227g.getIntrinsicWidth() - rect.left) - rect.right;
            i8 = this.f227g.getIntrinsicHeight();
        } else {
            i7 = 0;
            i8 = 0;
        }
        this.I = Math.max(this.f244y ? (this.f236q * 2) + Math.max(this.Q.getWidth(), this.R.getWidth()) : 0, i7);
        Drawable drawable2 = this.f232l;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i9 = this.f232l.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i10 = rect.left;
        int i11 = rect.right;
        Drawable drawable3 = this.f227g;
        if (drawable3 != null) {
            Rect b5 = v1.b(drawable3);
            i10 = Math.max(i10, b5.left);
            i11 = Math.max(i11, b5.right);
        }
        int max = this.N ? Math.max(this.f237r, (this.I * 2) + i10 + i11) : this.f237r;
        int max2 = Math.max(i9, i8);
        this.G = max;
        this.H = max2;
        super.onMeasure(i5, i6);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f240u : this.f242w;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r1 != 3) goto L7;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        super.setChecked(z4);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object obj = this.f240u;
                if (obj == null) {
                    obj = getResources().getString(R.string.abc_capital_on);
                }
                WeakHashMap weakHashMap = h0.z0.f3233a;
                new h0.j0(R.id.tag_state_description, 64, 30, 2).c(this, obj);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object obj2 = this.f242w;
            if (obj2 == null) {
                obj2 = getResources().getString(R.string.abc_capital_off);
            }
            WeakHashMap weakHashMap2 = h0.z0.f3233a;
            new h0.j0(R.id.tag_state_description, 64, 30, 2).c(this, obj2);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.T;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f225a0, isChecked ? 1.0f : 0.0f);
        this.T = ofFloat;
        ofFloat.setDuration(250L);
        this.T.setAutoCancel(true);
        this.T.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(b4.j.f0(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
        setTextOnInternal(this.f240u);
        setTextOffInternal(this.f242w);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z4) {
        this.N = z4;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z4) {
        if (this.f244y != z4) {
            this.f244y = z4;
            requestLayout();
            if (z4) {
                e();
            }
        }
    }

    public void setSplitTrack(boolean z4) {
        this.f239t = z4;
        invalidate();
    }

    public void setSwitchMinWidth(int i5) {
        this.f237r = i5;
        requestLayout();
    }

    public void setSwitchPadding(int i5) {
        this.f238s = i5;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.O;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object obj = this.f242w;
        if (obj == null) {
            obj = getResources().getString(R.string.abc_capital_off);
        }
        WeakHashMap weakHashMap = h0.z0.f3233a;
        new h0.j0(R.id.tag_state_description, 64, 30, 2).c(this, obj);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object obj = this.f240u;
        if (obj == null) {
            obj = getResources().getString(R.string.abc_capital_on);
        }
        WeakHashMap weakHashMap = h0.z0.f3233a;
        new h0.j0(R.id.tag_state_description, 64, 30, 2).c(this, obj);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f227g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f227g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f5) {
        this.F = f5;
        invalidate();
    }

    public void setThumbResource(int i5) {
        setThumbDrawable(p2.a.x(getContext(), i5));
    }

    public void setThumbTextPadding(int i5) {
        this.f236q = i5;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f228h = colorStateList;
        this.f230j = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f229i = mode;
        this.f231k = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f232l;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f232l = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i5) {
        setTrackDrawable(p2.a.x(getContext(), i5));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f233m = colorStateList;
        this.o = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f234n = mode;
        this.f235p = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f227g || drawable == this.f232l;
    }
}

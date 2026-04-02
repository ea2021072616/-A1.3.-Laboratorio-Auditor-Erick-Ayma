package com.google.android.material.chip;

import a0.g;
import a0.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.u;
import b4.j;
import com.github.appintro.R;
import f3.b;
import f3.c;
import f3.d;
import f3.e;
import f3.f;
import h0.o0;
import h0.z0;
import j3.i;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;
import p2.a;
/* loaded from: classes.dex */
public class Chip extends u implements e, p3.u, Checkable {
    public static final Rect C = new Rect();
    public static final int[] D = {16842913};
    public static final int[] E = {16842911};
    public final RectF A;
    public final b B;

    /* renamed from: k  reason: collision with root package name */
    public f f2079k;

    /* renamed from: l  reason: collision with root package name */
    public InsetDrawable f2080l;

    /* renamed from: m  reason: collision with root package name */
    public RippleDrawable f2081m;

    /* renamed from: n  reason: collision with root package name */
    public View.OnClickListener f2082n;
    public CompoundButton.OnCheckedChangeListener o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2083p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f2084q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2085r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f2086s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f2087t;

    /* renamed from: u  reason: collision with root package name */
    public int f2088u;

    /* renamed from: v  reason: collision with root package name */
    public int f2089v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f2090w;

    /* renamed from: x  reason: collision with root package name */
    public final d f2091x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f2092y;

    /* renamed from: z  reason: collision with root package name */
    public final Rect f2093z;

    public Chip(Context context, AttributeSet attributeSet) {
        super(a.b0(context, attributeSet, R.attr.chipStyle, 2131952694), attributeSet, R.attr.chipStyle);
        int resourceId;
        int resourceId2;
        int resourceId3;
        this.f2093z = new Rect();
        this.A = new RectF();
        this.B = new b(0, this);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        f fVar = new f(context2, attributeSet);
        Context context3 = fVar.f2846k0;
        int[] iArr = w2.a.f5388c;
        TypedArray D2 = j.D(context3, attributeSet, iArr, R.attr.chipStyle, 2131952694, new int[0]);
        fVar.L0 = D2.hasValue(37);
        Context context4 = fVar.f2846k0;
        ColorStateList v5 = a.v(context4, D2, 24);
        if (fVar.D != v5) {
            fVar.D = v5;
            fVar.onStateChange(fVar.getState());
        }
        ColorStateList v6 = a.v(context4, D2, 11);
        if (fVar.E != v6) {
            fVar.E = v6;
            fVar.onStateChange(fVar.getState());
        }
        float dimension = D2.getDimension(19, 0.0f);
        if (fVar.F != dimension) {
            fVar.F = dimension;
            fVar.invalidateSelf();
            fVar.u();
        }
        if (D2.hasValue(12)) {
            fVar.A(D2.getDimension(12, 0.0f));
        }
        fVar.F(a.v(context4, D2, 22));
        fVar.G(D2.getDimension(23, 0.0f));
        fVar.P(a.v(context4, D2, 36));
        String text = D2.getText(5);
        text = text == null ? "" : text;
        if (!TextUtils.equals(fVar.K, text)) {
            fVar.K = text;
            fVar.f2852q0.f3505d = true;
            fVar.invalidateSelf();
            fVar.u();
        }
        x2.b bVar = null;
        m3.d dVar = (!D2.hasValue(0) || (resourceId3 = D2.getResourceId(0, 0)) == 0) ? null : new m3.d(context4, resourceId3);
        dVar.f3982k = D2.getDimension(1, dVar.f3982k);
        fVar.Q(dVar);
        int i5 = D2.getInt(3, 0);
        if (i5 == 1) {
            fVar.I0 = TextUtils.TruncateAt.START;
        } else if (i5 == 2) {
            fVar.I0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i5 == 3) {
            fVar.I0 = TextUtils.TruncateAt.END;
        }
        fVar.E(D2.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            fVar.E(D2.getBoolean(15, false));
        }
        fVar.B(a.y(context4, D2, 14));
        if (D2.hasValue(17)) {
            fVar.D(a.v(context4, D2, 17));
        }
        fVar.C(D2.getDimension(16, -1.0f));
        fVar.M(D2.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            fVar.M(D2.getBoolean(26, false));
        }
        fVar.H(a.y(context4, D2, 25));
        fVar.L(a.v(context4, D2, 30));
        fVar.J(D2.getDimension(28, 0.0f));
        fVar.w(D2.getBoolean(6, false));
        fVar.z(D2.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            fVar.z(D2.getBoolean(8, false));
        }
        fVar.x(a.y(context4, D2, 7));
        if (D2.hasValue(9)) {
            fVar.y(a.v(context4, D2, 9));
        }
        fVar.f2836a0 = (!D2.hasValue(39) || (resourceId2 = D2.getResourceId(39, 0)) == 0) ? null : x2.b.a(context4, resourceId2);
        if (D2.hasValue(33) && (resourceId = D2.getResourceId(33, 0)) != 0) {
            bVar = x2.b.a(context4, resourceId);
        }
        fVar.f2837b0 = bVar;
        float dimension2 = D2.getDimension(21, 0.0f);
        if (fVar.f2838c0 != dimension2) {
            fVar.f2838c0 = dimension2;
            fVar.invalidateSelf();
            fVar.u();
        }
        fVar.O(D2.getDimension(35, 0.0f));
        fVar.N(D2.getDimension(34, 0.0f));
        float dimension3 = D2.getDimension(41, 0.0f);
        if (fVar.f2841f0 != dimension3) {
            fVar.f2841f0 = dimension3;
            fVar.invalidateSelf();
            fVar.u();
        }
        float dimension4 = D2.getDimension(40, 0.0f);
        if (fVar.f2842g0 != dimension4) {
            fVar.f2842g0 = dimension4;
            fVar.invalidateSelf();
            fVar.u();
        }
        fVar.K(D2.getDimension(29, 0.0f));
        fVar.I(D2.getDimension(27, 0.0f));
        float dimension5 = D2.getDimension(13, 0.0f);
        if (fVar.f2845j0 != dimension5) {
            fVar.f2845j0 = dimension5;
            fVar.invalidateSelf();
            fVar.u();
        }
        fVar.K0 = D2.getDimensionPixelSize(4, Integer.MAX_VALUE);
        D2.recycle();
        TypedArray D3 = j.D(context2, attributeSet, iArr, R.attr.chipStyle, 2131952694, new int[0]);
        this.f2087t = D3.getBoolean(32, false);
        this.f2089v = (int) Math.ceil(D3.getDimension(20, (float) Math.ceil(TypedValue.applyDimension(1, 48, getContext().getResources().getDisplayMetrics()))));
        D3.recycle();
        setChipDrawable(fVar);
        fVar.i(o0.i(this));
        TypedArray D4 = j.D(context2, attributeSet, iArr, R.attr.chipStyle, 2131952694, new int[0]);
        boolean hasValue = D4.hasValue(37);
        D4.recycle();
        this.f2091x = new d(this, this);
        d();
        if (!hasValue) {
            setOutlineProvider(new c(this));
        }
        setChecked(this.f2083p);
        setText(fVar.K);
        setEllipsize(fVar.I0);
        g();
        if (!this.f2079k.J0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        f();
        if (this.f2087t) {
            setMinHeight(this.f2089v);
        }
        this.f2088u = getLayoutDirection();
        super.setOnCheckedChangeListener(new f3.a(this, 0));
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.A;
        rectF.setEmpty();
        if (c() && this.f2082n != null) {
            f fVar = this.f2079k;
            Rect bounds = fVar.getBounds();
            rectF.setEmpty();
            if (fVar.T()) {
                float f5 = fVar.f2845j0 + fVar.f2844i0 + fVar.U + fVar.f2843h0 + fVar.f2842g0;
                if (a0.b.a(fVar) == 0) {
                    float f6 = bounds.right;
                    rectF.right = f6;
                    rectF.left = f6 - f5;
                } else {
                    float f7 = bounds.left;
                    rectF.left = f7;
                    rectF.right = f7 + f5;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        Rect rect = this.f2093z;
        rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return rect;
    }

    private m3.d getTextAppearance() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2852q0.f3507f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z4) {
        if (this.f2085r != z4) {
            this.f2085r = z4;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z4) {
        if (this.f2084q != z4) {
            this.f2084q = z4;
            refreshDrawableState();
        }
    }

    public final void b(int i5) {
        this.f2089v = i5;
        if (!this.f2087t) {
            InsetDrawable insetDrawable = this.f2080l;
            if (insetDrawable == null) {
                int[] iArr = n3.a.f4089a;
                e();
                return;
            } else if (insetDrawable != null) {
                this.f2080l = null;
                setMinWidth(0);
                setMinHeight((int) getChipMinHeight());
                int[] iArr2 = n3.a.f4089a;
                e();
                return;
            } else {
                return;
            }
        }
        int max = Math.max(0, i5 - ((int) this.f2079k.F));
        int max2 = Math.max(0, i5 - this.f2079k.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            InsetDrawable insetDrawable2 = this.f2080l;
            if (insetDrawable2 == null) {
                int[] iArr3 = n3.a.f4089a;
                e();
                return;
            } else if (insetDrawable2 != null) {
                this.f2080l = null;
                setMinWidth(0);
                setMinHeight((int) getChipMinHeight());
                int[] iArr4 = n3.a.f4089a;
                e();
                return;
            } else {
                return;
            }
        }
        int i6 = max2 > 0 ? max2 / 2 : 0;
        int i7 = max > 0 ? max / 2 : 0;
        if (this.f2080l != null) {
            Rect rect = new Rect();
            this.f2080l.getPadding(rect);
            if (rect.top == i7 && rect.bottom == i7 && rect.left == i6 && rect.right == i6) {
                int[] iArr5 = n3.a.f4089a;
                e();
                return;
            }
        }
        if (getMinHeight() != i5) {
            setMinHeight(i5);
        }
        if (getMinWidth() != i5) {
            setMinWidth(i5);
        }
        this.f2080l = new InsetDrawable((Drawable) this.f2079k, i6, i7, i6, i7);
        int[] iArr6 = n3.a.f4089a;
        e();
    }

    public final boolean c() {
        f fVar = this.f2079k;
        if (fVar != null) {
            Drawable drawable = fVar.R;
            if (drawable == null) {
                drawable = null;
            } else if (drawable instanceof g) {
                ((h) ((g) drawable)).getClass();
                drawable = null;
            }
            if (drawable != null) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        if (c()) {
            f fVar = this.f2079k;
            if ((fVar != null && fVar.Q) && this.f2082n != null) {
                z0.n(this, this.f2091x);
                this.f2092y = true;
                return;
            }
        }
        z0.n(this, null);
        this.f2092y = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
        if (r1 != Integer.MIN_VALUE) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchHoverEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            boolean r0 = r10.f2092y
            if (r0 != 0) goto L9
            boolean r11 = super.dispatchHoverEvent(r11)
            return r11
        L9:
            f3.d r0 = r10.f2091x
            android.view.accessibility.AccessibilityManager r1 = r0.f2829h
            boolean r2 = r1.isEnabled()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L70
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 != 0) goto L1c
            goto L70
        L1c:
            int r1 = r11.getAction()
            r2 = 256(0x100, float:3.59E-43)
            r5 = 128(0x80, float:1.794E-43)
            r6 = 7
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r6) goto L42
            r6 = 9
            if (r1 == r6) goto L42
            r6 = 10
            if (r1 == r6) goto L32
            goto L70
        L32:
            int r1 = r0.f2834m
            if (r1 == r7) goto L70
            if (r1 != r7) goto L39
            goto L6e
        L39:
            r0.f2834m = r7
            r0.q(r7, r5)
            r0.q(r1, r2)
            goto L6e
        L42:
            float r1 = r11.getX()
            float r6 = r11.getY()
            com.google.android.material.chip.Chip r8 = r0.f2835n
            boolean r9 = r8.c()
            if (r9 == 0) goto L5e
            android.graphics.RectF r8 = r8.getCloseIconTouchBounds()
            boolean r1 = r8.contains(r1, r6)
            if (r1 == 0) goto L5e
            r1 = r3
            goto L5f
        L5e:
            r1 = r4
        L5f:
            int r6 = r0.f2834m
            if (r6 != r1) goto L64
            goto L6c
        L64:
            r0.f2834m = r1
            r0.q(r1, r5)
            r0.q(r6, r2)
        L6c:
            if (r1 == r7) goto L70
        L6e:
            r0 = r3
            goto L71
        L70:
            r0 = r4
        L71:
            if (r0 != 0) goto L7b
            boolean r11 = super.dispatchHoverEvent(r11)
            if (r11 == 0) goto L7a
            goto L7b
        L7a:
            r3 = r4
        L7b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f2092y) {
            d dVar = this.f2091x;
            dVar.getClass();
            boolean z4 = false;
            int i5 = 0;
            z4 = false;
            z4 = false;
            z4 = false;
            z4 = false;
            z4 = false;
            if (keyEvent.getAction() != 1) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 61) {
                    int i6 = 66;
                    if (keyCode != 66) {
                        switch (keyCode) {
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                                if (keyEvent.hasNoModifiers()) {
                                    if (keyCode == 19) {
                                        i6 = 33;
                                    } else if (keyCode == 21) {
                                        i6 = 17;
                                    } else if (keyCode != 22) {
                                        i6 = 130;
                                    }
                                    int repeatCount = keyEvent.getRepeatCount() + 1;
                                    boolean z5 = false;
                                    while (i5 < repeatCount && dVar.m(i6, null)) {
                                        i5++;
                                        z5 = true;
                                    }
                                    z4 = z5;
                                    break;
                                }
                                break;
                        }
                    }
                    if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                        int i7 = dVar.f2833l;
                        if (i7 != Integer.MIN_VALUE) {
                            Chip chip = dVar.f2835n;
                            if (i7 == 0) {
                                chip.performClick();
                            } else if (i7 == 1) {
                                chip.playSoundEffect(0);
                                View.OnClickListener onClickListener = chip.f2082n;
                                if (onClickListener != null) {
                                    onClickListener.onClick(chip);
                                }
                                if (chip.f2092y) {
                                    chip.f2091x.q(1, 1);
                                }
                            }
                        }
                        z4 = true;
                    }
                } else if (keyEvent.hasNoModifiers()) {
                    z4 = dVar.m(2, null);
                } else if (keyEvent.hasModifiers(1)) {
                    z4 = dVar.m(1, null);
                }
            }
            if (!z4 || dVar.f2833l == Integer.MIN_VALUE) {
                return super.dispatchKeyEvent(keyEvent);
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.u, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i5;
        super.drawableStateChanged();
        f fVar = this.f2079k;
        boolean z4 = false;
        if (fVar != null && f.t(fVar.R)) {
            f fVar2 = this.f2079k;
            ?? isEnabled = isEnabled();
            int i6 = isEnabled;
            if (this.f2086s) {
                i6 = isEnabled + 1;
            }
            int i7 = i6;
            if (this.f2085r) {
                i7 = i6 + 1;
            }
            int i8 = i7;
            if (this.f2084q) {
                i8 = i7 + 1;
            }
            int i9 = i8;
            if (isChecked()) {
                i9 = i8 + 1;
            }
            int[] iArr = new int[i9];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (this.f2086s) {
                iArr[i5] = 16842908;
                i5++;
            }
            if (this.f2085r) {
                iArr[i5] = 16843623;
                i5++;
            }
            if (this.f2084q) {
                iArr[i5] = 16842919;
                i5++;
            }
            if (isChecked()) {
                iArr[i5] = 16842913;
            }
            if (!Arrays.equals(fVar2.E0, iArr)) {
                fVar2.E0 = iArr;
                if (fVar2.T()) {
                    z4 = fVar2.v(fVar2.getState(), iArr);
                }
            }
        }
        if (z4) {
            invalidate();
        }
    }

    public final void e() {
        this.f2081m = new RippleDrawable(n3.a.a(this.f2079k.J), getBackgroundDrawable(), null);
        f fVar = this.f2079k;
        if (fVar.F0) {
            fVar.F0 = false;
            fVar.G0 = null;
            fVar.onStateChange(fVar.getState());
        }
        RippleDrawable rippleDrawable = this.f2081m;
        WeakHashMap weakHashMap = z0.f3233a;
        setBackground(rippleDrawable);
        f();
    }

    public final void f() {
        f fVar;
        if (TextUtils.isEmpty(getText()) || (fVar = this.f2079k) == null) {
            return;
        }
        int q5 = (int) (fVar.q() + fVar.f2845j0 + fVar.f2842g0);
        f fVar2 = this.f2079k;
        int p5 = (int) (fVar2.p() + fVar2.f2838c0 + fVar2.f2841f0);
        if (this.f2080l != null) {
            Rect rect = new Rect();
            this.f2080l.getPadding(rect);
            p5 += rect.left;
            q5 += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = z0.f3233a;
        setPaddingRelative(p5, paddingTop, q5, paddingBottom);
    }

    public final void g() {
        TextPaint paint = getPaint();
        f fVar = this.f2079k;
        if (fVar != null) {
            paint.drawableState = fVar.getState();
        }
        m3.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.B);
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (TextUtils.isEmpty(this.f2090w)) {
            f fVar = this.f2079k;
            if (!(fVar != null && fVar.W)) {
                return isClickable() ? "android.widget.Button" : "android.view.View";
            }
            getParent();
            return "android.widget.Button";
        }
        return this.f2090w;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f2080l;
        return insetDrawable == null ? this.f2079k : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.Y;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.Z;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.E;
        }
        return null;
    }

    public float getChipCornerRadius() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return Math.max(0.0f, fVar.r());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f2079k;
    }

    public float getChipEndPadding() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2845j0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        f fVar = this.f2079k;
        if (fVar == null || (drawable = fVar.M) == null) {
            return null;
        }
        if (drawable instanceof g) {
            ((h) ((g) drawable)).getClass();
            return null;
        }
        return drawable;
    }

    public float getChipIconSize() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.O;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.N;
        }
        return null;
    }

    public float getChipMinHeight() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.F;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2838c0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.H;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.I;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        Drawable drawable;
        f fVar = this.f2079k;
        if (fVar == null || (drawable = fVar.R) == null) {
            return null;
        }
        if (drawable instanceof g) {
            ((h) ((g) drawable)).getClass();
            return null;
        }
        return drawable;
    }

    public CharSequence getCloseIconContentDescription() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.V;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2844i0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.U;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2843h0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.T;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.I0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f2092y) {
            d dVar = this.f2091x;
            if (dVar.f2833l == 1 || dVar.f2832k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public x2.b getHideMotionSpec() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2837b0;
        }
        return null;
    }

    public float getIconEndPadding() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2840e0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2839d0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.J;
        }
        return null;
    }

    public p3.j getShapeAppearanceModel() {
        return this.f2079k.f4294g.f4274a;
    }

    public x2.b getShowMotionSpec() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2836a0;
        }
        return null;
    }

    public float getTextEndPadding() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2842g0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        f fVar = this.f2079k;
        if (fVar != null) {
            return fVar.f2841f0;
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a.U(this, this.f2079k);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i5) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, D);
        }
        f fVar = this.f2079k;
        if (fVar != null && fVar.W) {
            View.mergeDrawableStates(onCreateDrawableState, E);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z4, int i5, Rect rect) {
        super.onFocusChanged(z4, i5, rect);
        if (this.f2092y) {
            d dVar = this.f2091x;
            int i6 = dVar.f2833l;
            if (i6 != Integer.MIN_VALUE) {
                dVar.j(i6);
            }
            if (z4) {
                dVar.m(i5, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        f fVar = this.f2079k;
        accessibilityNodeInfo.setCheckable(fVar != null && fVar.W);
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i5) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i5);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        if (this.f2088u != i5) {
            this.f2088u = i5;
            f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L18;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L49
            if (r0 == r2) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L44
            goto L50
        L21:
            boolean r0 = r5.f2084q
            if (r0 == 0) goto L50
            if (r1 != 0) goto L4e
            r5.setCloseIconPressed(r3)
            goto L4e
        L2b:
            boolean r0 = r5.f2084q
            if (r0 == 0) goto L44
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.f2082n
            if (r0 == 0) goto L39
            r0.onClick(r5)
        L39:
            boolean r0 = r5.f2092y
            if (r0 == 0) goto L42
            f3.d r0 = r5.f2091x
            r0.q(r2, r2)
        L42:
            r0 = r2
            goto L45
        L44:
            r0 = r3
        L45:
            r5.setCloseIconPressed(r3)
            goto L51
        L49:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r2)
        L4e:
            r0 = r2
            goto L51
        L50:
            r0 = r3
        L51:
            if (r0 != 0) goto L5b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            r2 = r3
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f2090w = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2081m) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i5) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.u, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2081m) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.u, android.view.View
    public void setBackgroundResource(int i5) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z4) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.w(z4);
        }
    }

    public void setCheckableResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.w(fVar.f2846k0.getResources().getBoolean(i5));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        f fVar = this.f2079k;
        if (fVar == null) {
            this.f2083p = z4;
        } else if (fVar.W) {
            super.setChecked(z4);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.x(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z4) {
        setCheckedIconVisible(z4);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i5) {
        setCheckedIconVisible(i5);
    }

    public void setCheckedIconResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.x(a.x(fVar.f2846k0, i5));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.y(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.y(a.u(fVar.f2846k0, i5));
        }
    }

    public void setCheckedIconVisible(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.z(fVar.f2846k0.getResources().getBoolean(i5));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        f fVar = this.f2079k;
        if (fVar == null || fVar.E == colorStateList) {
            return;
        }
        fVar.E = colorStateList;
        fVar.onStateChange(fVar.getState());
    }

    public void setChipBackgroundColorResource(int i5) {
        ColorStateList u3;
        f fVar = this.f2079k;
        if (fVar == null || fVar.E == (u3 = a.u(fVar.f2846k0, i5))) {
            return;
        }
        fVar.E = u3;
        fVar.onStateChange(fVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.A(f5);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.A(fVar.f2846k0.getResources().getDimension(i5));
        }
    }

    public void setChipDrawable(f fVar) {
        f fVar2 = this.f2079k;
        if (fVar2 != fVar) {
            if (fVar2 != null) {
                fVar2.H0 = new WeakReference(null);
            }
            this.f2079k = fVar;
            fVar.J0 = false;
            fVar.H0 = new WeakReference(this);
            b(this.f2089v);
        }
    }

    public void setChipEndPadding(float f5) {
        f fVar = this.f2079k;
        if (fVar == null || fVar.f2845j0 == f5) {
            return;
        }
        fVar.f2845j0 = f5;
        fVar.invalidateSelf();
        fVar.u();
    }

    public void setChipEndPaddingResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            float dimension = fVar.f2846k0.getResources().getDimension(i5);
            if (fVar.f2845j0 != dimension) {
                fVar.f2845j0 = dimension;
                fVar.invalidateSelf();
                fVar.u();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.B(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z4) {
        setChipIconVisible(z4);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i5) {
        setChipIconVisible(i5);
    }

    public void setChipIconResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.B(a.x(fVar.f2846k0, i5));
        }
    }

    public void setChipIconSize(float f5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.C(f5);
        }
    }

    public void setChipIconSizeResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.C(fVar.f2846k0.getResources().getDimension(i5));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.D(colorStateList);
        }
    }

    public void setChipIconTintResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.D(a.u(fVar.f2846k0, i5));
        }
    }

    public void setChipIconVisible(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.E(fVar.f2846k0.getResources().getBoolean(i5));
        }
    }

    public void setChipMinHeight(float f5) {
        f fVar = this.f2079k;
        if (fVar == null || fVar.F == f5) {
            return;
        }
        fVar.F = f5;
        fVar.invalidateSelf();
        fVar.u();
    }

    public void setChipMinHeightResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            float dimension = fVar.f2846k0.getResources().getDimension(i5);
            if (fVar.F != dimension) {
                fVar.F = dimension;
                fVar.invalidateSelf();
                fVar.u();
            }
        }
    }

    public void setChipStartPadding(float f5) {
        f fVar = this.f2079k;
        if (fVar == null || fVar.f2838c0 == f5) {
            return;
        }
        fVar.f2838c0 = f5;
        fVar.invalidateSelf();
        fVar.u();
    }

    public void setChipStartPaddingResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            float dimension = fVar.f2846k0.getResources().getDimension(i5);
            if (fVar.f2838c0 != dimension) {
                fVar.f2838c0 = dimension;
                fVar.invalidateSelf();
                fVar.u();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.F(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.F(a.u(fVar.f2846k0, i5));
        }
    }

    public void setChipStrokeWidth(float f5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.G(f5);
        }
    }

    public void setChipStrokeWidthResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.G(fVar.f2846k0.getResources().getDimension(i5));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i5) {
        setText(getResources().getString(i5));
    }

    public void setCloseIcon(Drawable drawable) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.H(drawable);
        }
        d();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        f fVar = this.f2079k;
        if (fVar == null || fVar.V == charSequence) {
            return;
        }
        String str = f0.b.f2726d;
        f0.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? f0.b.f2729g : f0.b.f2728f;
        fVar.V = bVar.c(charSequence, bVar.f2732c);
        fVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z4) {
        setCloseIconVisible(z4);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i5) {
        setCloseIconVisible(i5);
    }

    public void setCloseIconEndPadding(float f5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.I(f5);
        }
    }

    public void setCloseIconEndPaddingResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.I(fVar.f2846k0.getResources().getDimension(i5));
        }
    }

    public void setCloseIconResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.H(a.x(fVar.f2846k0, i5));
        }
        d();
    }

    public void setCloseIconSize(float f5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.J(f5);
        }
    }

    public void setCloseIconSizeResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.J(fVar.f2846k0.getResources().getDimension(i5));
        }
    }

    public void setCloseIconStartPadding(float f5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.K(f5);
        }
    }

    public void setCloseIconStartPaddingResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.K(fVar.f2846k0.getResources().getDimension(i5));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.L(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.L(a.u(fVar.f2846k0, i5));
        }
    }

    public void setCloseIconVisible(int i5) {
        setCloseIconVisible(getResources().getBoolean(i5));
    }

    @Override // androidx.appcompat.widget.u, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.u, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i7 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i5, i6, i7, i8);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i7 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i5, i6, i7, i8);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.i(f5);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f2079k == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.I0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z4) {
        this.f2087t = z4;
        b(this.f2089v);
    }

    @Override // android.widget.TextView
    public void setGravity(int i5) {
        if (i5 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i5);
        }
    }

    public void setHideMotionSpec(x2.b bVar) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.f2837b0 = bVar;
        }
    }

    public void setHideMotionSpecResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.f2837b0 = x2.b.a(fVar.f2846k0, i5);
        }
    }

    public void setIconEndPadding(float f5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.N(f5);
        }
    }

    public void setIconEndPaddingResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.N(fVar.f2846k0.getResources().getDimension(i5));
        }
    }

    public void setIconStartPadding(float f5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.O(f5);
        }
    }

    public void setIconStartPaddingResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.O(fVar.f2846k0.getResources().getDimension(i5));
        }
    }

    public void setInternalOnCheckedChangeListener(j3.e eVar) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int i5) {
        if (this.f2079k == null) {
            return;
        }
        super.setLayoutDirection(i5);
    }

    @Override // android.widget.TextView
    public void setLines(int i5) {
        if (i5 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i5);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i5) {
        if (i5 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i5);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i5) {
        super.setMaxWidth(i5);
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.K0 = i5;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i5) {
        if (i5 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i5);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.o = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f2082n = onClickListener;
        d();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.P(colorStateList);
        }
        if (this.f2079k.F0) {
            return;
        }
        e();
    }

    public void setRippleColorResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.P(a.u(fVar.f2846k0, i5));
            if (this.f2079k.F0) {
                return;
            }
            e();
        }
    }

    @Override // p3.u
    public void setShapeAppearanceModel(p3.j jVar) {
        this.f2079k.setShapeAppearanceModel(jVar);
    }

    public void setShowMotionSpec(x2.b bVar) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.f2836a0 = bVar;
        }
    }

    public void setShowMotionSpecResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.f2836a0 = x2.b.a(fVar.f2846k0, i5);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z4) {
        if (!z4) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z4);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        f fVar = this.f2079k;
        if (fVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(fVar.J0 ? null : charSequence, bufferType);
        f fVar2 = this.f2079k;
        if (fVar2 == null || TextUtils.equals(fVar2.K, charSequence)) {
            return;
        }
        fVar2.K = charSequence;
        fVar2.f2852q0.f3505d = true;
        fVar2.invalidateSelf();
        fVar2.u();
    }

    public void setTextAppearance(m3.d dVar) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.Q(dVar);
        }
        g();
    }

    public void setTextAppearanceResource(int i5) {
        setTextAppearance(getContext(), i5);
    }

    public void setTextEndPadding(float f5) {
        f fVar = this.f2079k;
        if (fVar == null || fVar.f2842g0 == f5) {
            return;
        }
        fVar.f2842g0 = f5;
        fVar.invalidateSelf();
        fVar.u();
    }

    public void setTextEndPaddingResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            float dimension = fVar.f2846k0.getResources().getDimension(i5);
            if (fVar.f2842g0 != dimension) {
                fVar.f2842g0 = dimension;
                fVar.invalidateSelf();
                fVar.u();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i5, float f5) {
        super.setTextSize(i5, f5);
        f fVar = this.f2079k;
        if (fVar != null) {
            float applyDimension = TypedValue.applyDimension(i5, f5, getResources().getDisplayMetrics());
            i iVar = fVar.f2852q0;
            m3.d dVar = iVar.f3507f;
            if (dVar != null) {
                dVar.f3982k = applyDimension;
                iVar.f3502a.setTextSize(applyDimension);
                fVar.u();
                fVar.invalidateSelf();
            }
        }
        g();
    }

    public void setTextStartPadding(float f5) {
        f fVar = this.f2079k;
        if (fVar == null || fVar.f2841f0 == f5) {
            return;
        }
        fVar.f2841f0 = f5;
        fVar.invalidateSelf();
        fVar.u();
    }

    public void setTextStartPaddingResource(int i5) {
        f fVar = this.f2079k;
        if (fVar != null) {
            float dimension = fVar.f2846k0.getResources().getDimension(i5);
            if (fVar.f2841f0 != dimension) {
                fVar.f2841f0 = dimension;
                fVar.invalidateSelf();
                fVar.u();
            }
        }
    }

    public void setCloseIconVisible(boolean z4) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.M(z4);
        }
        d();
    }

    public void setCheckedIconVisible(boolean z4) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.z(z4);
        }
    }

    public void setChipIconVisible(boolean z4) {
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.E(z4);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.Q(new m3.d(fVar.f2846k0, i5));
        }
        g();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i5) {
        super.setTextAppearance(i5);
        f fVar = this.f2079k;
        if (fVar != null) {
            fVar.Q(new m3.d(fVar.f2846k0, i5));
        }
        g();
    }
}

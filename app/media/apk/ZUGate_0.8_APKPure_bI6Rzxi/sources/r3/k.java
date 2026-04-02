package r3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.github.appintro.R;
import h0.m0;
import h0.o0;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class k extends FrameLayout {

    /* renamed from: r */
    public static final j f4503r = new j();

    /* renamed from: g */
    public l f4504g;

    /* renamed from: h */
    public final p3.j f4505h;

    /* renamed from: i */
    public int f4506i;

    /* renamed from: j */
    public final float f4507j;

    /* renamed from: k */
    public final float f4508k;

    /* renamed from: l */
    public final int f4509l;

    /* renamed from: m */
    public final int f4510m;

    /* renamed from: n */
    public ColorStateList f4511n;
    public PorterDuff.Mode o;

    /* renamed from: p */
    public Rect f4512p;

    /* renamed from: q */
    public boolean f4513q;

    /* JADX WARN: Multi-variable type inference failed */
    public k(Context context, AttributeSet attributeSet) {
        super(p2.a.b0(context, attributeSet, 0, 0), attributeSet);
        GradientDrawable gradientDrawable;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, w2.a.f5408x);
        if (obtainStyledAttributes.hasValue(6)) {
            WeakHashMap weakHashMap = z0.f3233a;
            o0.s(this, obtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.f4506i = obtainStyledAttributes.getInt(2, 0);
        if (obtainStyledAttributes.hasValue(8) || obtainStyledAttributes.hasValue(9)) {
            this.f4505h = new p3.j(p3.j.b(context2, attributeSet, 0, 0));
        }
        this.f4507j = obtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(p2.a.v(context2, obtainStyledAttributes, 4));
        setBackgroundTintMode(p2.a.O(obtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.f4508k = obtainStyledAttributes.getFloat(1, 1.0f);
        this.f4509l = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f4510m = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f4503r);
        setFocusable(true);
        if (getBackground() == null) {
            int B = e4.e.B(e4.e.l(this, R.attr.colorSurface), getBackgroundOverlayColorAlpha(), e4.e.l(this, R.attr.colorOnSurface));
            p3.j jVar = this.f4505h;
            if (jVar != null) {
                v0.b bVar = l.f4514u;
                p3.g gVar = new p3.g(jVar);
                gVar.j(ColorStateList.valueOf(B));
                gradientDrawable = gVar;
            } else {
                Resources resources = getResources();
                v0.b bVar2 = l.f4514u;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(dimension);
                gradientDrawable2.setColor(B);
                gradientDrawable = gradientDrawable2;
            }
            ColorStateList colorStateList = this.f4511n;
            if (colorStateList != null) {
                a0.a.h(gradientDrawable, colorStateList);
            }
            WeakHashMap weakHashMap2 = z0.f3233a;
            setBackground(gradientDrawable);
        }
    }

    public static /* synthetic */ void a(k kVar, l lVar) {
        kVar.setBaseTransientBottomBar(lVar);
    }

    public void setBaseTransientBottomBar(l lVar) {
        this.f4504g = lVar;
    }

    public float getActionTextColorAlpha() {
        return this.f4508k;
    }

    public int getAnimationMode() {
        return this.f4506i;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f4507j;
    }

    public int getMaxInlineActionWidth() {
        return this.f4510m;
    }

    public int getMaxWidth() {
        return this.f4509l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Insets mandatorySystemGestureInsets;
        int i5;
        super.onAttachedToWindow();
        l lVar = this.f4504g;
        if (lVar != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                WindowInsets rootWindowInsets = lVar.f4528i.getRootWindowInsets();
                if (rootWindowInsets != null) {
                    mandatorySystemGestureInsets = rootWindowInsets.getMandatorySystemGestureInsets();
                    i5 = mandatorySystemGestureInsets.bottom;
                    lVar.f4534p = i5;
                    lVar.e();
                }
            } else {
                lVar.getClass();
            }
        }
        WeakHashMap weakHashMap = z0.f3233a;
        m0.c(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0030, code lost:
        if (r1 == false) goto L17;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDetachedFromWindow() {
        /*
            r6 = this;
            super.onDetachedFromWindow()
            r3.l r0 = r6.f4504g
            if (r0 == 0) goto L43
            r3.r r1 = r3.r.b()
            r3.i r2 = r0.f4538t
            java.lang.Object r3 = r1.f4547a
            monitor-enter(r3)
            boolean r4 = r1.c(r2)     // Catch: java.lang.Throwable -> L28
            r5 = 1
            if (r4 != 0) goto L32
            r3.q r1 = r1.f4550d     // Catch: java.lang.Throwable -> L28
            r4 = 0
            if (r1 == 0) goto L2f
            if (r2 == 0) goto L2a
            java.lang.ref.WeakReference r1 = r1.f4543a     // Catch: java.lang.Throwable -> L28
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L28
            if (r1 != r2) goto L2a
            r1 = r5
            goto L2b
        L28:
            r0 = move-exception
            goto L41
        L2a:
            r1 = r4
        L2b:
            if (r1 == 0) goto L2f
            r1 = r5
            goto L30
        L2f:
            r1 = r4
        L30:
            if (r1 == 0) goto L33
        L32:
            r4 = r5
        L33:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L28
            if (r4 == 0) goto L43
            android.os.Handler r1 = r3.l.f4517x
            r3.g r2 = new r3.g
            r2.<init>(r0, r5)
            r1.post(r2)
            goto L43
        L41:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L28
            throw r0
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.k.onDetachedFromWindow():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        l lVar = this.f4504g;
        if (lVar == null || !lVar.f4536r) {
            return;
        }
        lVar.d();
        lVar.f4536r = false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        int i7 = this.f4509l;
        if (i7 <= 0 || getMeasuredWidth() <= i7) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), i6);
    }

    public void setAnimationMode(int i5) {
        this.f4506i = i5;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f4511n != null) {
            drawable = drawable.mutate();
            a0.a.h(drawable, this.f4511n);
            a0.a.i(drawable, this.o);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f4511n = colorStateList;
        if (getBackground() != null) {
            Drawable mutate = getBackground().mutate();
            a0.a.h(mutate, colorStateList);
            a0.a.i(mutate, this.o);
            if (mutate != getBackground()) {
                super.setBackgroundDrawable(mutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.o = mode;
        if (getBackground() != null) {
            Drawable mutate = getBackground().mutate();
            a0.a.i(mutate, mode);
            if (mutate != getBackground()) {
                super.setBackgroundDrawable(mutate);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (this.f4513q || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        this.f4512p = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        l lVar = this.f4504g;
        if (lVar != null) {
            v0.b bVar = l.f4514u;
            lVar.e();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f4503r);
        super.setOnClickListener(onClickListener);
    }
}

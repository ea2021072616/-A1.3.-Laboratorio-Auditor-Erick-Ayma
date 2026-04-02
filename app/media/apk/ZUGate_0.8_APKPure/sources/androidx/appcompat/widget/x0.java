package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
/* loaded from: classes.dex */
public final class x0 extends Spinner {
    public static final int[] o = {16843505};

    /* renamed from: g  reason: collision with root package name */
    public final s f576g;

    /* renamed from: h  reason: collision with root package name */
    public final Context f577h;

    /* renamed from: i  reason: collision with root package name */
    public final l f578i;

    /* renamed from: j  reason: collision with root package name */
    public SpinnerAdapter f579j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f580k;

    /* renamed from: l  reason: collision with root package name */
    public final w0 f581l;

    /* renamed from: m  reason: collision with root package name */
    public int f582m;

    /* renamed from: n  reason: collision with root package name */
    public final Rect f583n;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r6 == null) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x0(android.content.Context r12, android.util.AttributeSet r13) {
        /*
            r11 = this;
            r0 = 2130969638(0x7f040426, float:1.7547964E38)
            r11.<init>(r12, r13, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r11.f583n = r1
            android.content.Context r1 = r11.getContext()
            androidx.appcompat.widget.d3.a(r11, r1)
            int[] r1 = c.a.f1703u
            r2 = 0
            android.content.res.TypedArray r3 = r12.obtainStyledAttributes(r13, r1, r0, r2)
            androidx.appcompat.widget.s r4 = new androidx.appcompat.widget.s
            r4.<init>(r11)
            r11.f576g = r4
            r4 = 4
            int r4 = r3.getResourceId(r4, r2)
            if (r4 == 0) goto L31
            g.d r5 = new g.d
            r5.<init>(r12, r4)
            r11.f577h = r5
            goto L33
        L31:
            r11.f577h = r12
        L33:
            r4 = -1
            r5 = 0
            int[] r6 = androidx.appcompat.widget.x0.o     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            android.content.res.TypedArray r6 = r12.obtainStyledAttributes(r13, r6, r0, r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            boolean r7 = r6.hasValue(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
            if (r7 == 0) goto L5b
            int r4 = r6.getInt(r2, r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
            goto L5b
        L46:
            r12 = move-exception
            r5 = r6
            goto Ld0
        L4a:
            r7 = move-exception
            goto L52
        L4c:
            r12 = move-exception
            goto Ld0
        L4f:
            r6 = move-exception
            r7 = r6
            r6 = r5
        L52:
            java.lang.String r8 = "AppCompatSpinner"
            java.lang.String r9 = "Could not read android:spinnerMode"
            android.util.Log.i(r8, r9, r7)     // Catch: java.lang.Throwable -> L46
            if (r6 == 0) goto L5e
        L5b:
            r6.recycle()
        L5e:
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L98
            if (r4 == r7) goto L65
            goto La5
        L65:
            androidx.appcompat.widget.u0 r4 = new androidx.appcompat.widget.u0
            android.content.Context r8 = r11.f577h
            r4.<init>(r11, r8, r13)
            android.content.Context r8 = r11.f577h
            androidx.appcompat.widget.z2 r1 = androidx.appcompat.widget.z2.m(r8, r13, r1, r0)
            java.lang.Object r8 = r1.f606b
            android.content.res.TypedArray r8 = (android.content.res.TypedArray) r8
            r9 = 3
            r10 = -2
            int r8 = r8.getLayoutDimension(r9, r10)
            r11.f582m = r8
            android.graphics.drawable.Drawable r8 = r1.e(r7)
            r4.m(r8)
            java.lang.String r6 = r3.getString(r6)
            r4.I = r6
            r1.n()
            r11.f581l = r4
            androidx.appcompat.widget.l r1 = new androidx.appcompat.widget.l
            r1.<init>(r11, r11, r4, r7)
            r11.f578i = r1
            goto La5
        L98:
            androidx.appcompat.widget.r0 r1 = new androidx.appcompat.widget.r0
            r1.<init>(r11)
            r11.f581l = r1
            java.lang.String r4 = r3.getString(r6)
            r1.f506i = r4
        La5:
            java.lang.CharSequence[] r1 = r3.getTextArray(r2)
            if (r1 == 0) goto Lbc
            android.widget.ArrayAdapter r2 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r2.<init>(r12, r4, r1)
            r12 = 2131493007(0x7f0c008f, float:1.8609482E38)
            r2.setDropDownViewResource(r12)
            r11.setAdapter(r2)
        Lbc:
            r3.recycle()
            r11.f580k = r7
            android.widget.SpinnerAdapter r12 = r11.f579j
            if (r12 == 0) goto Lca
            r11.setAdapter(r12)
            r11.f579j = r5
        Lca:
            androidx.appcompat.widget.s r12 = r11.f576g
            r12.e(r13, r0)
            return
        Ld0:
            if (r5 == 0) goto Ld5
            r5.recycle()
        Ld5:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x0.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i5 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i6 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i6 = Math.max(i6, view.getMeasuredWidth());
        }
        if (drawable != null) {
            Rect rect = this.f583n;
            drawable.getPadding(rect);
            return i6 + rect.left + rect.right;
        }
        return i6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        s sVar = this.f576g;
        if (sVar != null) {
            sVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        w0 w0Var = this.f581l;
        return w0Var != null ? w0Var.c() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        w0 w0Var = this.f581l;
        return w0Var != null ? w0Var.e() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f581l != null ? this.f582m : super.getDropDownWidth();
    }

    public final w0 getInternalPopup() {
        return this.f581l;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        w0 w0Var = this.f581l;
        return w0Var != null ? w0Var.h() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f577h;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        w0 w0Var = this.f581l;
        return w0Var != null ? w0Var.i() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        s sVar = this.f576g;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        s sVar = this.f576g;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w0 w0Var = this.f581l;
        if (w0Var == null || !w0Var.a()) {
            return;
        }
        w0Var.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.f581l == null || View.MeasureSpec.getMode(i5) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i5)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        v0 v0Var = (v0) parcelable;
        super.onRestoreInstanceState(v0Var.getSuperState());
        if (!v0Var.f548b || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new h.e(2, this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        v0 v0Var = new v0(super.onSaveInstanceState());
        w0 w0Var = this.f581l;
        v0Var.f548b = w0Var != null && w0Var.a();
        return v0Var;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        l lVar = this.f578i;
        if (lVar == null || !lVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        w0 w0Var = this.f581l;
        if (w0Var != null) {
            if (w0Var.a()) {
                return true;
            }
            w0Var.d(getTextDirection(), getTextAlignment());
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        s sVar = this.f576g;
        if (sVar != null) {
            sVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        s sVar = this.f576g;
        if (sVar != null) {
            sVar.g(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i5) {
        w0 w0Var = this.f581l;
        if (w0Var == null) {
            super.setDropDownHorizontalOffset(i5);
            return;
        }
        w0Var.p(i5);
        w0Var.b(i5);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i5) {
        w0 w0Var = this.f581l;
        if (w0Var != null) {
            w0Var.n(i5);
        } else {
            super.setDropDownVerticalOffset(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i5) {
        if (this.f581l != null) {
            this.f582m = i5;
        } else {
            super.setDropDownWidth(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        w0 w0Var = this.f581l;
        if (w0Var != null) {
            w0Var.m(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i5) {
        setPopupBackgroundDrawable(p2.a.x(getPopupContext(), i5));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        w0 w0Var = this.f581l;
        if (w0Var != null) {
            w0Var.k(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        s sVar = this.f576g;
        if (sVar != null) {
            sVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        s sVar = this.f576g;
        if (sVar != null) {
            sVar.j(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f580k) {
            this.f579j = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        w0 w0Var = this.f581l;
        if (w0Var != null) {
            Context context = this.f577h;
            if (context == null) {
                context = getContext();
            }
            w0Var.o(new s0(spinnerAdapter, context.getTheme()));
        }
    }
}

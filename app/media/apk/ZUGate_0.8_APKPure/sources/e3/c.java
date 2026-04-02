package e3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.u;
import androidx.appcompat.widget.z2;
import b4.j;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.github.appintro.R;
import e4.e;
import f1.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import y.i;
import y.q;
/* loaded from: classes.dex */
public final class c extends u {
    public static final int[] E = {R.attr.state_indeterminate};
    public static final int[] F = {R.attr.state_error};
    public static final int[][] G = {new int[]{16842910, R.attr.state_error}, new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public static final int H = Resources.getSystem().getIdentifier("btn_check_material_anim", AppIntroBaseFragmentKt.ARG_DRAWABLE, "android");
    public CharSequence A;
    public CompoundButton.OnCheckedChangeListener B;
    public final d C;
    public final a D;

    /* renamed from: k  reason: collision with root package name */
    public final LinkedHashSet f2687k;

    /* renamed from: l  reason: collision with root package name */
    public final LinkedHashSet f2688l;

    /* renamed from: m  reason: collision with root package name */
    public ColorStateList f2689m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2690n;
    public boolean o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2691p;

    /* renamed from: q  reason: collision with root package name */
    public CharSequence f2692q;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f2693r;

    /* renamed from: s  reason: collision with root package name */
    public Drawable f2694s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f2695t;

    /* renamed from: u  reason: collision with root package name */
    public ColorStateList f2696u;

    /* renamed from: v  reason: collision with root package name */
    public ColorStateList f2697v;

    /* renamed from: w  reason: collision with root package name */
    public PorterDuff.Mode f2698w;

    /* renamed from: x  reason: collision with root package name */
    public int f2699x;

    /* renamed from: y  reason: collision with root package name */
    public int[] f2700y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f2701z;

    public c(Context context, AttributeSet attributeSet) {
        super(p2.a.b0(context, attributeSet, R.attr.checkboxStyle, 2131952704), attributeSet, R.attr.checkboxStyle);
        this.f2687k = new LinkedHashSet();
        this.f2688l = new LinkedHashSet();
        Context context2 = getContext();
        d dVar = new d(context2);
        Resources resources = context2.getResources();
        Resources.Theme theme = context2.getTheme();
        ThreadLocal threadLocal = q.f5568a;
        Drawable a5 = i.a(resources, R.drawable.mtrl_checkbox_button_checked_unchecked, theme);
        dVar.f2754g = a5;
        a5.setCallback(dVar.f2753l);
        new f1.c(dVar.f2754g.getConstantState());
        this.C = dVar;
        this.D = new a(this);
        Context context3 = getContext();
        this.f2693r = n0.c.a(this);
        this.f2696u = getSuperButtonTintList();
        setSupportButtonTintList(null);
        int[] iArr = w2.a.f5399n;
        j.e(context3, attributeSet, R.attr.checkboxStyle, 2131952704);
        j.f(context3, attributeSet, iArr, R.attr.checkboxStyle, 2131952704, new int[0]);
        z2 z2Var = new z2(context3, context3.obtainStyledAttributes(attributeSet, iArr, R.attr.checkboxStyle, 2131952704));
        this.f2694s = z2Var.e(2);
        if (this.f2693r != null && e.O(context3, R.attr.isMaterial3Theme, false)) {
            if (z2Var.i(0, 0) == H && z2Var.i(1, 0) == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f2693r = p2.a.x(context3, R.drawable.mtrl_checkbox_button);
                this.f2695t = true;
                if (this.f2694s == null) {
                    this.f2694s = p2.a.x(context3, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.f2697v = p2.a.w(context3, z2Var, 3);
        this.f2698w = p2.a.O(z2Var.h(4, -1), PorterDuff.Mode.SRC_IN);
        this.f2690n = z2Var.a(10, false);
        this.o = z2Var.a(6, true);
        this.f2691p = z2Var.a(9, false);
        this.f2692q = z2Var.k(8);
        if (z2Var.l(7)) {
            setCheckedState(z2Var.h(7, 0));
        }
        z2Var.n();
        a();
    }

    private String getButtonStateDescription() {
        int i5 = this.f2699x;
        return i5 == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i5 == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f2689m == null) {
            int l5 = e.l(this, R.attr.colorControlActivated);
            int l6 = e.l(this, R.attr.colorError);
            int l7 = e.l(this, R.attr.colorSurface);
            int l8 = e.l(this, R.attr.colorOnSurface);
            this.f2689m = new ColorStateList(G, new int[]{e.B(l7, 1.0f, l6), e.B(l7, 1.0f, l5), e.B(l7, 0.54f, l8), e.B(l7, 0.38f, l8), e.B(l7, 0.38f, l8)});
        }
        return this.f2689m;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f2696u;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        androidx.appcompat.widget.d dVar;
        Drawable drawable = this.f2693r;
        ColorStateList colorStateList3 = this.f2696u;
        PorterDuff.Mode b5 = n0.b.b(this);
        if (drawable == null) {
            drawable = null;
        } else if (colorStateList3 != null) {
            drawable = drawable.mutate();
            if (b5 != null) {
                a0.a.i(drawable, b5);
            }
        }
        this.f2693r = drawable;
        Drawable drawable2 = this.f2694s;
        ColorStateList colorStateList4 = this.f2697v;
        PorterDuff.Mode mode = this.f2698w;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (colorStateList4 != null) {
            drawable2 = drawable2.mutate();
            if (mode != null) {
                a0.a.i(drawable2, mode);
            }
        }
        this.f2694s = drawable2;
        if (this.f2695t) {
            d dVar2 = this.C;
            if (dVar2 != null) {
                Drawable drawable3 = dVar2.f2754g;
                a aVar = this.D;
                if (drawable3 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable3;
                    if (aVar.f2684a == null) {
                        aVar.f2684a = new f1.a(aVar);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(aVar.f2684a);
                }
                ArrayList arrayList = dVar2.f2752k;
                f1.b bVar = dVar2.f2749h;
                if (arrayList != null && aVar != null) {
                    arrayList.remove(aVar);
                    if (dVar2.f2752k.size() == 0 && (dVar = dVar2.f2751j) != null) {
                        bVar.f2745b.removeListener(dVar);
                        dVar2.f2751j = null;
                    }
                }
                Drawable drawable4 = dVar2.f2754g;
                if (drawable4 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable4;
                    if (aVar.f2684a == null) {
                        aVar.f2684a = new f1.a(aVar);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar.f2684a);
                } else if (aVar != null) {
                    if (dVar2.f2752k == null) {
                        dVar2.f2752k = new ArrayList();
                    }
                    if (!dVar2.f2752k.contains(aVar)) {
                        dVar2.f2752k.add(aVar);
                        if (dVar2.f2751j == null) {
                            dVar2.f2751j = new androidx.appcompat.widget.d(2, dVar2);
                        }
                        bVar.f2745b.addListener(dVar2.f2751j);
                    }
                }
            }
            Drawable drawable5 = this.f2693r;
            if ((drawable5 instanceof AnimatedStateListDrawable) && dVar2 != null) {
                ((AnimatedStateListDrawable) drawable5).addTransition(R.id.checked, R.id.unchecked, dVar2, false);
                ((AnimatedStateListDrawable) this.f2693r).addTransition(R.id.indeterminate, R.id.unchecked, dVar2, false);
            }
        }
        Drawable drawable6 = this.f2693r;
        if (drawable6 != null && (colorStateList2 = this.f2696u) != null) {
            a0.a.h(drawable6, colorStateList2);
        }
        Drawable drawable7 = this.f2694s;
        if (drawable7 != null && (colorStateList = this.f2697v) != null) {
            a0.a.h(drawable7, colorStateList);
        }
        Drawable drawable8 = this.f2693r;
        Drawable drawable9 = this.f2694s;
        if (drawable8 == null) {
            drawable8 = drawable9;
        } else if (drawable9 != null) {
            int intrinsicWidth = drawable9.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable8.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable9.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable8.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable8.getIntrinsicWidth() || intrinsicHeight > drawable8.getIntrinsicHeight()) {
                float f5 = intrinsicWidth / intrinsicHeight;
                if (f5 >= drawable8.getIntrinsicWidth() / drawable8.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable8.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f5);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable8.getIntrinsicHeight();
                    intrinsicWidth = (int) (f5 * intrinsicHeight);
                }
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable8, drawable9});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable8 = layerDrawable;
        }
        super.setButtonDrawable(drawable8);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f2693r;
    }

    public Drawable getButtonIconDrawable() {
        return this.f2694s;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f2697v;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f2698w;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f2696u;
    }

    public int getCheckedState() {
        return this.f2699x;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f2692q;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f2699x == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2690n && this.f2696u == null && this.f2697v == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i5) {
        int[] copyOf;
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, E);
        }
        if (this.f2691p) {
            View.mergeDrawableStates(onCreateDrawableState, F);
        }
        int i6 = 0;
        while (true) {
            if (i6 >= onCreateDrawableState.length) {
                copyOf = Arrays.copyOf(onCreateDrawableState, onCreateDrawableState.length + 1);
                copyOf[onCreateDrawableState.length] = 16842912;
                break;
            }
            int i7 = onCreateDrawableState[i6];
            if (i7 == 16842912) {
                copyOf = onCreateDrawableState;
                break;
            } else if (i7 == 0) {
                copyOf = (int[]) onCreateDrawableState.clone();
                copyOf[i6] = 16842912;
                break;
            } else {
                i6++;
            }
        }
        this.f2700y = copyOf;
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable a5;
        if (!this.o || !TextUtils.isEmpty(getText()) || (a5 = n0.c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - a5.getIntrinsicWidth()) / 2) * (p2.a.C(this) ? -1 : 1);
        int save = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = a5.getBounds();
            a0.a.f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f2691p) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f2692q));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCheckedState(bVar.f2686b);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f2686b = getCheckedState();
        return bVar;
    }

    @Override // androidx.appcompat.widget.u, android.widget.CompoundButton
    public void setButtonDrawable(int i5) {
        setButtonDrawable(p2.a.x(getContext(), i5));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f2694s = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i5) {
        setButtonIconDrawable(p2.a.x(getContext(), i5));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f2697v == colorStateList) {
            return;
        }
        this.f2697v = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f2698w == mode) {
            return;
        }
        this.f2698w = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f2696u == colorStateList) {
            return;
        }
        this.f2696u = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z4) {
        this.o = z4;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        setCheckedState(z4 ? 1 : 0);
    }

    public void setCheckedState(int i5) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f2699x != i5) {
            this.f2699x = i5;
            super.setChecked(i5 == 1);
            refreshDrawableState();
            if (Build.VERSION.SDK_INT >= 30 && this.A == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.f2701z) {
                return;
            }
            this.f2701z = true;
            LinkedHashSet linkedHashSet = this.f2688l;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    b0.n(it.next());
                    throw null;
                }
            }
            if (this.f2699x != 2 && (onCheckedChangeListener = this.B) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f2701z = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f2692q = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i5) {
        setErrorAccessibilityLabel(i5 != 0 ? getResources().getText(i5) : null);
    }

    public void setErrorShown(boolean z4) {
        if (this.f2691p == z4) {
            return;
        }
        this.f2691p = z4;
        refreshDrawableState();
        Iterator it = this.f2687k.iterator();
        if (it.hasNext()) {
            b0.n(it.next());
            throw null;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.B = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.A = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
        } else {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        this.f2690n = z4;
        if (z4) {
            n0.b.c(this, getMaterialThemeColorsTintList());
        } else {
            n0.b.c(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // androidx.appcompat.widget.u, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f2693r = drawable;
        this.f2695t = false;
        a();
    }
}

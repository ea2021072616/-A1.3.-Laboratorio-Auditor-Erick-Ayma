package s3;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.i1;
import androidx.appcompat.widget.z2;
import com.github.appintro.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import h0.z0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class n extends LinearLayout {
    public static final /* synthetic */ int C = 0;
    public w.g A;
    public final l B;

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout f4896g;

    /* renamed from: h  reason: collision with root package name */
    public final FrameLayout f4897h;

    /* renamed from: i  reason: collision with root package name */
    public final CheckableImageButton f4898i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f4899j;

    /* renamed from: k  reason: collision with root package name */
    public PorterDuff.Mode f4900k;

    /* renamed from: l  reason: collision with root package name */
    public View.OnLongClickListener f4901l;

    /* renamed from: m  reason: collision with root package name */
    public final CheckableImageButton f4902m;

    /* renamed from: n  reason: collision with root package name */
    public final androidx.activity.result.j f4903n;
    public int o;

    /* renamed from: p  reason: collision with root package name */
    public final LinkedHashSet f4904p;

    /* renamed from: q  reason: collision with root package name */
    public ColorStateList f4905q;

    /* renamed from: r  reason: collision with root package name */
    public PorterDuff.Mode f4906r;

    /* renamed from: s  reason: collision with root package name */
    public int f4907s;

    /* renamed from: t  reason: collision with root package name */
    public ImageView.ScaleType f4908t;

    /* renamed from: u  reason: collision with root package name */
    public View.OnLongClickListener f4909u;

    /* renamed from: v  reason: collision with root package name */
    public CharSequence f4910v;

    /* renamed from: w  reason: collision with root package name */
    public final i1 f4911w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f4912x;

    /* renamed from: y  reason: collision with root package name */
    public EditText f4913y;

    /* renamed from: z  reason: collision with root package name */
    public final AccessibilityManager f4914z;

    public n(TextInputLayout textInputLayout, z2 z2Var) {
        super(textInputLayout.getContext());
        CharSequence k5;
        this.o = 0;
        this.f4904p = new LinkedHashSet();
        this.B = new l(this);
        m mVar = new m(this);
        this.f4914z = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f4896g = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f4897h = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton a5 = a(this, from, R.id.text_input_error_icon);
        this.f4898i = a5;
        CheckableImageButton a6 = a(frameLayout, from, R.id.text_input_end_icon);
        this.f4902m = a6;
        this.f4903n = new androidx.activity.result.j(this, z2Var);
        i1 i1Var = new i1(getContext(), null);
        this.f4911w = i1Var;
        if (z2Var.l(38)) {
            this.f4899j = p2.a.w(getContext(), z2Var, 38);
        }
        if (z2Var.l(39)) {
            this.f4900k = p2.a.O(z2Var.h(39, -1), null);
        }
        if (z2Var.l(37)) {
            i(z2Var.e(37));
        }
        a5.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap weakHashMap = z0.f3233a;
        a5.setImportantForAccessibility(2);
        a5.setClickable(false);
        a5.setPressable(false);
        a5.setFocusable(false);
        if (!z2Var.l(53)) {
            if (z2Var.l(32)) {
                this.f4905q = p2.a.w(getContext(), z2Var, 32);
            }
            if (z2Var.l(33)) {
                this.f4906r = p2.a.O(z2Var.h(33, -1), null);
            }
        }
        if (z2Var.l(30)) {
            g(z2Var.h(30, 0));
            if (z2Var.l(27) && a6.getContentDescription() != (k5 = z2Var.k(27))) {
                a6.setContentDescription(k5);
            }
            a6.setCheckable(z2Var.a(26, true));
        } else if (z2Var.l(53)) {
            if (z2Var.l(54)) {
                this.f4905q = p2.a.w(getContext(), z2Var, 54);
            }
            if (z2Var.l(55)) {
                this.f4906r = p2.a.O(z2Var.h(55, -1), null);
            }
            g(z2Var.a(53, false) ? 1 : 0);
            CharSequence k6 = z2Var.k(51);
            if (a6.getContentDescription() != k6) {
                a6.setContentDescription(k6);
            }
        }
        int d5 = z2Var.d(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (d5 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (d5 != this.f4907s) {
            this.f4907s = d5;
            a6.setMinimumWidth(d5);
            a6.setMinimumHeight(d5);
            a5.setMinimumWidth(d5);
            a5.setMinimumHeight(d5);
        }
        if (z2Var.l(31)) {
            ImageView.ScaleType l5 = p2.a.l(z2Var.h(31, -1));
            this.f4908t = l5;
            a6.setScaleType(l5);
            a5.setScaleType(l5);
        }
        i1Var.setVisibility(8);
        i1Var.setId(R.id.textinput_suffix_text);
        i1Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        i1Var.setAccessibilityLiveRegion(1);
        i1Var.setTextAppearance(z2Var.i(72, 0));
        if (z2Var.l(73)) {
            i1Var.setTextColor(z2Var.b(73));
        }
        CharSequence k7 = z2Var.k(71);
        this.f4910v = TextUtils.isEmpty(k7) ? null : k7;
        i1Var.setText(k7);
        n();
        frameLayout.addView(a6);
        addView(i1Var);
        addView(frameLayout);
        addView(a5);
        textInputLayout.f2216k0.add(mVar);
        if (textInputLayout.f2213j != null) {
            mVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new h.f(2, this));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i5) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i5);
        if (p2.a.B(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final o b() {
        int i5 = this.o;
        androidx.activity.result.j jVar = this.f4903n;
        SparseArray sparseArray = (SparseArray) jVar.f101i;
        o oVar = (o) sparseArray.get(i5);
        if (oVar == null) {
            if (i5 == -1) {
                oVar = new e((n) jVar.f102j, 0);
            } else if (i5 == 0) {
                oVar = new e((n) jVar.f102j, 1);
            } else if (i5 == 1) {
                oVar = new v((n) jVar.f102j, jVar.f100h);
            } else if (i5 == 2) {
                oVar = new d((n) jVar.f102j);
            } else if (i5 != 3) {
                throw new IllegalArgumentException(b0.f("Invalid end icon mode: ", i5));
            } else {
                oVar = new k((n) jVar.f102j);
            }
            sparseArray.append(i5, oVar);
        }
        return oVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.f4902m;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        WeakHashMap weakHashMap = z0.f3233a;
        return this.f4911w.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.f4897h.getVisibility() == 0 && this.f4902m.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f4898i.getVisibility() == 0;
    }

    public final void f(boolean z4) {
        boolean z5;
        boolean isActivated;
        boolean isChecked;
        o b5 = b();
        boolean k5 = b5.k();
        CheckableImageButton checkableImageButton = this.f4902m;
        boolean z6 = true;
        if (!k5 || (isChecked = checkableImageButton.isChecked()) == b5.l()) {
            z5 = false;
        } else {
            checkableImageButton.setChecked(!isChecked);
            z5 = true;
        }
        if (!(b5 instanceof k) || (isActivated = checkableImageButton.isActivated()) == b5.j()) {
            z6 = z5;
        } else {
            checkableImageButton.setActivated(!isActivated);
        }
        if (z4 || z6) {
            p2.a.P(this.f4896g, checkableImageButton, this.f4905q);
        }
    }

    public final void g(int i5) {
        if (this.o == i5) {
            return;
        }
        o b5 = b();
        w.g gVar = this.A;
        AccessibilityManager accessibilityManager = this.f4914z;
        if (gVar != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(new i0.b(gVar));
        }
        this.A = null;
        b5.s();
        this.o = i5;
        Iterator it = this.f4904p.iterator();
        if (it.hasNext()) {
            b0.n(it.next());
            throw null;
        }
        h(i5 != 0);
        o b6 = b();
        int i6 = this.f4903n.f99g;
        if (i6 == 0) {
            i6 = b6.d();
        }
        Drawable x5 = i6 != 0 ? p2.a.x(getContext(), i6) : null;
        CheckableImageButton checkableImageButton = this.f4902m;
        checkableImageButton.setImageDrawable(x5);
        TextInputLayout textInputLayout = this.f4896g;
        if (x5 != null) {
            p2.a.b(textInputLayout, checkableImageButton, this.f4905q, this.f4906r);
            p2.a.P(textInputLayout, checkableImageButton, this.f4905q);
        }
        int c5 = b6.c();
        CharSequence text = c5 != 0 ? getResources().getText(c5) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(b6.k());
        if (!b6.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i5);
        }
        b6.r();
        w.g h5 = b6.h();
        this.A = h5;
        if (h5 != null && accessibilityManager != null) {
            WeakHashMap weakHashMap = z0.f3233a;
            if (isAttachedToWindow()) {
                accessibilityManager.addTouchExplorationStateChangeListener(new i0.b(this.A));
            }
        }
        View.OnClickListener f5 = b6.f();
        View.OnLongClickListener onLongClickListener = this.f4909u;
        checkableImageButton.setOnClickListener(f5);
        p2.a.T(checkableImageButton, onLongClickListener);
        EditText editText = this.f4913y;
        if (editText != null) {
            b6.m(editText);
            j(b6);
        }
        p2.a.b(textInputLayout, checkableImageButton, this.f4905q, this.f4906r);
        f(true);
    }

    public final void h(boolean z4) {
        if (d() != z4) {
            this.f4902m.setVisibility(z4 ? 0 : 8);
            k();
            m();
            this.f4896g.q();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f4898i;
        checkableImageButton.setImageDrawable(drawable);
        l();
        p2.a.b(this.f4896g, checkableImageButton, this.f4899j, this.f4900k);
    }

    public final void j(o oVar) {
        if (this.f4913y == null) {
            return;
        }
        if (oVar.e() != null) {
            this.f4913y.setOnFocusChangeListener(oVar.e());
        }
        if (oVar.g() != null) {
            this.f4902m.setOnFocusChangeListener(oVar.g());
        }
    }

    public final void k() {
        this.f4897h.setVisibility((this.f4902m.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility(d() || e() || !((this.f4910v == null || this.f4912x) ? true : false) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f4898i;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f4896g;
        checkableImageButton.setVisibility(drawable != null && textInputLayout.f2224p.f4940q && textInputLayout.m() ? 0 : 8);
        k();
        m();
        if (this.o != 0) {
            return;
        }
        textInputLayout.q();
    }

    public final void m() {
        int i5;
        TextInputLayout textInputLayout = this.f4896g;
        if (textInputLayout.f2213j == null) {
            return;
        }
        if (d() || e()) {
            i5 = 0;
        } else {
            EditText editText = textInputLayout.f2213j;
            WeakHashMap weakHashMap = z0.f3233a;
            i5 = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = textInputLayout.f2213j.getPaddingTop();
        int paddingBottom = textInputLayout.f2213j.getPaddingBottom();
        WeakHashMap weakHashMap2 = z0.f3233a;
        this.f4911w.setPaddingRelative(dimensionPixelSize, paddingTop, i5, paddingBottom);
    }

    public final void n() {
        i1 i1Var = this.f4911w;
        int visibility = i1Var.getVisibility();
        int i5 = (this.f4910v == null || this.f4912x) ? 8 : 0;
        if (visibility != i5) {
            b().p(i5 == 0);
        }
        k();
        i1Var.setVisibility(i5);
        this.f4896g.q();
    }
}

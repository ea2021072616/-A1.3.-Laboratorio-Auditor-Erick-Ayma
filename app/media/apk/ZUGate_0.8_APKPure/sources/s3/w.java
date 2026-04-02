package s3;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.i1;
import androidx.appcompat.widget.z2;
import com.github.appintro.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class w extends LinearLayout {

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout f4964g;

    /* renamed from: h  reason: collision with root package name */
    public final i1 f4965h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f4966i;

    /* renamed from: j  reason: collision with root package name */
    public final CheckableImageButton f4967j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f4968k;

    /* renamed from: l  reason: collision with root package name */
    public PorterDuff.Mode f4969l;

    /* renamed from: m  reason: collision with root package name */
    public int f4970m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView.ScaleType f4971n;
    public View.OnLongClickListener o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4972p;

    public w(TextInputLayout textInputLayout, z2 z2Var) {
        super(textInputLayout.getContext());
        CharSequence k5;
        this.f4964g = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f4967j = checkableImageButton;
        i1 i1Var = new i1(getContext(), null);
        this.f4965h = i1Var;
        if (p2.a.B(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.o;
        checkableImageButton.setOnClickListener(null);
        p2.a.T(checkableImageButton, onLongClickListener);
        this.o = null;
        checkableImageButton.setOnLongClickListener(null);
        p2.a.T(checkableImageButton, null);
        if (z2Var.l(69)) {
            this.f4968k = p2.a.w(getContext(), z2Var, 69);
        }
        if (z2Var.l(70)) {
            this.f4969l = p2.a.O(z2Var.h(70, -1), null);
        }
        if (z2Var.l(66)) {
            b(z2Var.e(66));
            if (z2Var.l(65) && checkableImageButton.getContentDescription() != (k5 = z2Var.k(65))) {
                checkableImageButton.setContentDescription(k5);
            }
            checkableImageButton.setCheckable(z2Var.a(64, true));
        }
        int d5 = z2Var.d(67, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (d5 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (d5 != this.f4970m) {
            this.f4970m = d5;
            checkableImageButton.setMinimumWidth(d5);
            checkableImageButton.setMinimumHeight(d5);
        }
        if (z2Var.l(68)) {
            ImageView.ScaleType l5 = p2.a.l(z2Var.h(68, -1));
            this.f4971n = l5;
            checkableImageButton.setScaleType(l5);
        }
        i1Var.setVisibility(8);
        i1Var.setId(R.id.textinput_prefix_text);
        i1Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap weakHashMap = z0.f3233a;
        i1Var.setAccessibilityLiveRegion(1);
        i1Var.setTextAppearance(z2Var.i(60, 0));
        if (z2Var.l(61)) {
            i1Var.setTextColor(z2Var.b(61));
        }
        CharSequence k6 = z2Var.k(59);
        this.f4966i = TextUtils.isEmpty(k6) ? null : k6;
        i1Var.setText(k6);
        e();
        addView(checkableImageButton);
        addView(i1Var);
    }

    public final int a() {
        CheckableImageButton checkableImageButton = this.f4967j;
        int marginEnd = checkableImageButton.getVisibility() == 0 ? ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth() : 0;
        WeakHashMap weakHashMap = z0.f3233a;
        return this.f4965h.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f4967j;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f4968k;
            PorterDuff.Mode mode = this.f4969l;
            TextInputLayout textInputLayout = this.f4964g;
            p2.a.b(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            p2.a.P(textInputLayout, checkableImageButton, this.f4968k);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.o;
        checkableImageButton.setOnClickListener(null);
        p2.a.T(checkableImageButton, onLongClickListener);
        this.o = null;
        checkableImageButton.setOnLongClickListener(null);
        p2.a.T(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z4) {
        CheckableImageButton checkableImageButton = this.f4967j;
        if ((checkableImageButton.getVisibility() == 0) != z4) {
            checkableImageButton.setVisibility(z4 ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        EditText editText = this.f4964g.f2213j;
        if (editText == null) {
            return;
        }
        int i5 = 0;
        if (!(this.f4967j.getVisibility() == 0)) {
            WeakHashMap weakHashMap = z0.f3233a;
            i5 = editText.getPaddingStart();
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = z0.f3233a;
        this.f4965h.setPaddingRelative(i5, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void e() {
        int i5 = (this.f4966i == null || this.f4972p) ? 8 : 0;
        setVisibility(this.f4967j.getVisibility() == 0 || i5 == 0 ? 0 : 8);
        this.f4965h.setVisibility(i5);
        this.f4964g.q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        d();
    }
}

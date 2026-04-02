package s3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.i1;
import com.github.appintro.R;
import com.google.android.material.textfield.TextInputLayout;
import h0.z0;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class r {
    public ColorStateList A;
    public Typeface B;

    /* renamed from: a  reason: collision with root package name */
    public final int f4925a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4926b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4927c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeInterpolator f4928d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeInterpolator f4929e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeInterpolator f4930f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f4931g;

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout f4932h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f4933i;

    /* renamed from: j  reason: collision with root package name */
    public int f4934j;

    /* renamed from: k  reason: collision with root package name */
    public FrameLayout f4935k;

    /* renamed from: l  reason: collision with root package name */
    public Animator f4936l;

    /* renamed from: m  reason: collision with root package name */
    public final float f4937m;

    /* renamed from: n  reason: collision with root package name */
    public int f4938n;
    public int o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f4939p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f4940q;

    /* renamed from: r  reason: collision with root package name */
    public i1 f4941r;

    /* renamed from: s  reason: collision with root package name */
    public CharSequence f4942s;

    /* renamed from: t  reason: collision with root package name */
    public int f4943t;

    /* renamed from: u  reason: collision with root package name */
    public int f4944u;

    /* renamed from: v  reason: collision with root package name */
    public ColorStateList f4945v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f4946w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f4947x;

    /* renamed from: y  reason: collision with root package name */
    public i1 f4948y;

    /* renamed from: z  reason: collision with root package name */
    public int f4949z;

    public r(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f4931g = context;
        this.f4932h = textInputLayout;
        this.f4937m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f4925a = p2.a.Q(context, R.attr.motionDurationShort4, 217);
        this.f4926b = p2.a.Q(context, R.attr.motionDurationMedium4, 167);
        this.f4927c = p2.a.Q(context, R.attr.motionDurationShort4, 167);
        this.f4928d = p2.a.R(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, x2.a.f5487d);
        LinearInterpolator linearInterpolator = x2.a.f5484a;
        this.f4929e = p2.a.R(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f4930f = p2.a.R(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(TextView textView, int i5) {
        if (this.f4933i == null && this.f4935k == null) {
            Context context = this.f4931g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f4933i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f4933i;
            TextInputLayout textInputLayout = this.f4932h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f4935k = new FrameLayout(context);
            this.f4933i.addView(this.f4935k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i5 == 0 || i5 == 1) {
            this.f4935k.setVisibility(0);
            this.f4935k.addView(textView);
        } else {
            this.f4933i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f4933i.setVisibility(0);
        this.f4934j++;
    }

    public final void b() {
        LinearLayout linearLayout = this.f4933i;
        TextInputLayout textInputLayout = this.f4932h;
        if ((linearLayout == null || textInputLayout.getEditText() == null) ? false : true) {
            EditText editText = textInputLayout.getEditText();
            Context context = this.f4931g;
            boolean B = p2.a.B(context);
            LinearLayout linearLayout2 = this.f4933i;
            WeakHashMap weakHashMap = z0.f3233a;
            int paddingStart = editText.getPaddingStart();
            if (B) {
                paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
            if (B) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
            }
            int paddingEnd = editText.getPaddingEnd();
            if (B) {
                paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
            }
            linearLayout2.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
        }
    }

    public final void c() {
        Animator animator = this.f4936l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z4, TextView textView, int i5, int i6, int i7) {
        if (textView == null || !z4) {
            return;
        }
        if (i5 == i7 || i5 == i6) {
            boolean z5 = i7 == i5;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z5 ? 1.0f : 0.0f);
            int i8 = this.f4927c;
            ofFloat.setDuration(z5 ? this.f4926b : i8);
            ofFloat.setInterpolator(z5 ? this.f4929e : this.f4930f);
            if (i5 == i7 && i6 != 0) {
                ofFloat.setStartDelay(i8);
            }
            arrayList.add(ofFloat);
            if (i7 != i5 || i6 == 0) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f4937m, 0.0f);
            ofFloat2.setDuration(this.f4925a);
            ofFloat2.setInterpolator(this.f4928d);
            ofFloat2.setStartDelay(i8);
            arrayList.add(ofFloat2);
        }
    }

    public final TextView e(int i5) {
        if (i5 != 1) {
            if (i5 != 2) {
                return null;
            }
            return this.f4948y;
        }
        return this.f4941r;
    }

    public final void f() {
        this.f4939p = null;
        c();
        if (this.f4938n == 1) {
            if (!this.f4947x || TextUtils.isEmpty(this.f4946w)) {
                this.o = 0;
            } else {
                this.o = 2;
            }
        }
        i(this.f4938n, h(this.f4941r, ""), this.o);
    }

    public final void g(TextView textView, int i5) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f4933i;
        if (linearLayout == null) {
            return;
        }
        boolean z4 = true;
        if (i5 != 0 && i5 != 1) {
            z4 = false;
        }
        if (!z4 || (frameLayout = this.f4935k) == null) {
            linearLayout.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i6 = this.f4934j - 1;
        this.f4934j = i6;
        LinearLayout linearLayout2 = this.f4933i;
        if (i6 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(TextView textView, CharSequence charSequence) {
        WeakHashMap weakHashMap = z0.f3233a;
        TextInputLayout textInputLayout = this.f4932h;
        return textInputLayout.isLaidOut() && textInputLayout.isEnabled() && !(this.o == this.f4938n && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public final void i(int i5, boolean z4, int i6) {
        TextView e5;
        TextView e6;
        if (i5 == i6) {
            return;
        }
        if (z4) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f4936l = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.f4947x, this.f4948y, 2, i5, i6);
            d(arrayList, this.f4940q, this.f4941r, 1, i5, i6);
            e4.e.F(animatorSet, arrayList);
            animatorSet.addListener(new p(this, i6, e(i5), i5, e(i6)));
            animatorSet.start();
        } else if (i5 != i6) {
            if (i6 != 0 && (e6 = e(i6)) != null) {
                e6.setVisibility(0);
                e6.setAlpha(1.0f);
            }
            if (i5 != 0 && (e5 = e(i5)) != null) {
                e5.setVisibility(4);
                if (i5 == 1) {
                    e5.setText((CharSequence) null);
                }
            }
            this.f4938n = i6;
        }
        TextInputLayout textInputLayout = this.f4932h;
        textInputLayout.r();
        textInputLayout.u(z4, false);
        textInputLayout.x();
    }
}

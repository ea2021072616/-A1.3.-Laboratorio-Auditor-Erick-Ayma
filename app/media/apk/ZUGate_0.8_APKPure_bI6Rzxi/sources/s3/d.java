package s3;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class d extends o {

    /* renamed from: e  reason: collision with root package name */
    public final int f4868e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4869f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeInterpolator f4870g;

    /* renamed from: h  reason: collision with root package name */
    public final TimeInterpolator f4871h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f4872i;

    /* renamed from: j  reason: collision with root package name */
    public final com.google.android.material.datepicker.m f4873j;

    /* renamed from: k  reason: collision with root package name */
    public final b f4874k;

    /* renamed from: l  reason: collision with root package name */
    public AnimatorSet f4875l;

    /* renamed from: m  reason: collision with root package name */
    public ValueAnimator f4876m;

    public d(n nVar) {
        super(nVar);
        this.f4873j = new com.google.android.material.datepicker.m(1, this);
        this.f4874k = new b(this, 0);
        this.f4868e = p2.a.Q(nVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f4869f = p2.a.Q(nVar.getContext(), R.attr.motionDurationShort3, 150);
        this.f4870g = p2.a.R(nVar.getContext(), R.attr.motionEasingLinearInterpolator, x2.a.f5484a);
        this.f4871h = p2.a.R(nVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, x2.a.f5487d);
    }

    @Override // s3.o
    public final void a() {
        if (this.f4916b.f4910v != null) {
            return;
        }
        t(u());
    }

    @Override // s3.o
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // s3.o
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // s3.o
    public final View.OnFocusChangeListener e() {
        return this.f4874k;
    }

    @Override // s3.o
    public final View.OnClickListener f() {
        return this.f4873j;
    }

    @Override // s3.o
    public final View.OnFocusChangeListener g() {
        return this.f4874k;
    }

    @Override // s3.o
    public final void m(EditText editText) {
        this.f4872i = editText;
        this.f4915a.setEndIconVisible(u());
    }

    @Override // s3.o
    public final void p(boolean z4) {
        if (this.f4916b.f4910v == null) {
            return;
        }
        t(z4);
    }

    @Override // s3.o
    public final void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.f4871h);
        ofFloat.setDuration(this.f4869f);
        ofFloat.addUpdateListener(new a(this, 0));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f4870g;
        ofFloat2.setInterpolator(timeInterpolator);
        int i5 = this.f4868e;
        ofFloat2.setDuration(i5);
        ofFloat2.addUpdateListener(new a(this, 1));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f4875l = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.f4875l.addListener(new c(this, 0));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(i5);
        ofFloat3.addUpdateListener(new a(this, 1));
        this.f4876m = ofFloat3;
        ofFloat3.addListener(new c(this, 1));
    }

    @Override // s3.o
    public final void s() {
        EditText editText = this.f4872i;
        if (editText != null) {
            editText.post(new androidx.activity.d(11, this));
        }
    }

    public final void t(boolean z4) {
        boolean z5 = this.f4916b.d() == z4;
        if (z4 && !this.f4875l.isRunning()) {
            this.f4876m.cancel();
            this.f4875l.start();
            if (z5) {
                this.f4875l.end();
            }
        } else if (z4) {
        } else {
            this.f4875l.cancel();
            this.f4876m.start();
            if (z5) {
                this.f4876m.end();
            }
        }
    }

    public final boolean u() {
        EditText editText = this.f4872i;
        return editText != null && (editText.hasFocus() || this.f4918d.hasFocus()) && this.f4872i.getText().length() > 0;
    }
}

package s3;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.github.appintro.R;
import com.google.android.material.textfield.TextInputLayout;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class k extends o {

    /* renamed from: e  reason: collision with root package name */
    public final int f4881e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4882f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeInterpolator f4883g;

    /* renamed from: h  reason: collision with root package name */
    public AutoCompleteTextView f4884h;

    /* renamed from: i  reason: collision with root package name */
    public final com.google.android.material.datepicker.m f4885i;

    /* renamed from: j  reason: collision with root package name */
    public final b f4886j;

    /* renamed from: k  reason: collision with root package name */
    public final w.g f4887k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4888l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f4889m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4890n;
    public long o;

    /* renamed from: p  reason: collision with root package name */
    public AccessibilityManager f4891p;

    /* renamed from: q  reason: collision with root package name */
    public ValueAnimator f4892q;

    /* renamed from: r  reason: collision with root package name */
    public ValueAnimator f4893r;

    public k(n nVar) {
        super(nVar);
        this.f4885i = new com.google.android.material.datepicker.m(2, this);
        this.f4886j = new b(this, 1);
        this.f4887k = new w.g(10, this);
        this.o = Long.MAX_VALUE;
        this.f4882f = p2.a.Q(nVar.getContext(), R.attr.motionDurationShort3, 67);
        this.f4881e = p2.a.Q(nVar.getContext(), R.attr.motionDurationShort3, 50);
        this.f4883g = p2.a.R(nVar.getContext(), R.attr.motionEasingLinearInterpolator, x2.a.f5484a);
    }

    @Override // s3.o
    public final void a() {
        if (this.f4891p.isTouchExplorationEnabled()) {
            if ((this.f4884h.getInputType() != 0) && !this.f4918d.hasFocus()) {
                this.f4884h.dismissDropDown();
            }
        }
        this.f4884h.post(new androidx.activity.d(12, this));
    }

    @Override // s3.o
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // s3.o
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // s3.o
    public final View.OnFocusChangeListener e() {
        return this.f4886j;
    }

    @Override // s3.o
    public final View.OnClickListener f() {
        return this.f4885i;
    }

    @Override // s3.o
    public final w.g h() {
        return this.f4887k;
    }

    @Override // s3.o
    public final boolean i(int i5) {
        return i5 != 0;
    }

    @Override // s3.o
    public final boolean j() {
        return this.f4888l;
    }

    @Override // s3.o
    public final boolean l() {
        return this.f4890n;
    }

    @Override // s3.o
    public final void m(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f4884h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: s3.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                k kVar = k.this;
                kVar.getClass();
                if (motionEvent.getAction() == 1) {
                    long currentTimeMillis = System.currentTimeMillis() - kVar.o;
                    if (currentTimeMillis < 0 || currentTimeMillis > 300) {
                        kVar.f4889m = false;
                    }
                    kVar.u();
                    kVar.f4889m = true;
                    kVar.o = System.currentTimeMillis();
                }
                return false;
            }
        });
        this.f4884h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: s3.j
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                k kVar = k.this;
                kVar.f4889m = true;
                kVar.o = System.currentTimeMillis();
                kVar.t(false);
            }
        });
        this.f4884h.setThreshold(0);
        TextInputLayout textInputLayout = this.f4915a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!(editText.getInputType() != 0) && this.f4891p.isTouchExplorationEnabled()) {
            WeakHashMap weakHashMap = z0.f3233a;
            this.f4918d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // s3.o
    public final void n(i0.j jVar) {
        if (!(this.f4884h.getInputType() != 0)) {
            jVar.h(Spinner.class.getName());
        }
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        if (accessibilityNodeInfo.isShowingHintText()) {
            accessibilityNodeInfo.setHintText(null);
        }
    }

    @Override // s3.o
    public final void o(AccessibilityEvent accessibilityEvent) {
        if (this.f4891p.isEnabled()) {
            boolean z4 = false;
            if (this.f4884h.getInputType() != 0) {
                return;
            }
            if ((accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f4890n && !this.f4884h.isPopupShowing()) {
                z4 = true;
            }
            if (accessibilityEvent.getEventType() == 1 || z4) {
                u();
                this.f4889m = true;
                this.o = System.currentTimeMillis();
            }
        }
    }

    @Override // s3.o
    public final void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f4883g;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration(this.f4882f);
        ofFloat.addUpdateListener(new a(this, 2));
        this.f4893r = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(this.f4881e);
        ofFloat2.addUpdateListener(new a(this, 2));
        this.f4892q = ofFloat2;
        ofFloat2.addListener(new androidx.appcompat.widget.d(9, this));
        this.f4891p = (AccessibilityManager) this.f4917c.getSystemService("accessibility");
    }

    @Override // s3.o
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.f4884h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f4884h.setOnDismissListener(null);
        }
    }

    public final void t(boolean z4) {
        if (this.f4890n != z4) {
            this.f4890n = z4;
            this.f4893r.cancel();
            this.f4892q.start();
        }
    }

    public final void u() {
        if (this.f4884h == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.o;
        if (currentTimeMillis < 0 || currentTimeMillis > 300) {
            this.f4889m = false;
        }
        if (this.f4889m) {
            this.f4889m = false;
            return;
        }
        t(!this.f4890n);
        if (!this.f4890n) {
            this.f4884h.dismissDropDown();
            return;
        }
        this.f4884h.requestFocus();
        this.f4884h.showDropDown();
    }
}

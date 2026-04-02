package s3;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class v extends o {

    /* renamed from: e  reason: collision with root package name */
    public final int f4961e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f4962f;

    /* renamed from: g  reason: collision with root package name */
    public final com.google.android.material.datepicker.m f4963g;

    public v(n nVar, int i5) {
        super(nVar);
        this.f4961e = R.drawable.design_password_eye;
        this.f4963g = new com.google.android.material.datepicker.m(3, this);
        if (i5 != 0) {
            this.f4961e = i5;
        }
    }

    @Override // s3.o
    public final void b() {
        q();
    }

    @Override // s3.o
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // s3.o
    public final int d() {
        return this.f4961e;
    }

    @Override // s3.o
    public final View.OnClickListener f() {
        return this.f4963g;
    }

    @Override // s3.o
    public final boolean k() {
        return true;
    }

    @Override // s3.o
    public final boolean l() {
        EditText editText = this.f4962f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // s3.o
    public final void m(EditText editText) {
        this.f4962f = editText;
        q();
    }

    @Override // s3.o
    public final void r() {
        EditText editText = this.f4962f;
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            this.f4962f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // s3.o
    public final void s() {
        EditText editText = this.f4962f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}

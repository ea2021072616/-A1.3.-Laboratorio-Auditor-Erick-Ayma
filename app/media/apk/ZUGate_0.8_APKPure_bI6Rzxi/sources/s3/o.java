package s3;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout f4915a;

    /* renamed from: b  reason: collision with root package name */
    public final n f4916b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f4917c;

    /* renamed from: d  reason: collision with root package name */
    public final CheckableImageButton f4918d;

    public o(n nVar) {
        this.f4915a = nVar.f4896g;
        this.f4916b = nVar;
        this.f4917c = nVar.getContext();
        this.f4918d = nVar.f4902m;
    }

    public void a() {
    }

    public void b() {
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public w.g h() {
        return null;
    }

    public boolean i(int i5) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this instanceof k;
    }

    public boolean l() {
        return false;
    }

    public void m(EditText editText) {
    }

    public void n(i0.j jVar) {
    }

    public void o(AccessibilityEvent accessibilityEvent) {
    }

    public void p(boolean z4) {
    }

    public final void q() {
        this.f4916b.f(false);
    }

    public abstract void r();

    public void s() {
    }
}

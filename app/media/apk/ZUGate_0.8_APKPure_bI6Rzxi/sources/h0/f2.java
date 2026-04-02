package h0;

import android.os.Build;
import android.view.View;
import java.util.Objects;
/* loaded from: classes.dex */
public class f2 {

    /* renamed from: b  reason: collision with root package name */
    public static final h2 f3129b;

    /* renamed from: a  reason: collision with root package name */
    public final h2 f3130a;

    static {
        int i5 = Build.VERSION.SDK_INT;
        f3129b = (i5 >= 30 ? new y1() : i5 >= 29 ? new x1() : new w1()).b().f3144a.a().f3144a.b().f3144a.c();
    }

    public f2(h2 h2Var) {
        this.f3130a = h2Var;
    }

    public h2 a() {
        return this.f3130a;
    }

    public h2 b() {
        return this.f3130a;
    }

    public h2 c() {
        return this.f3130a;
    }

    public void d(View view) {
    }

    public k e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f2) {
            f2 f2Var = (f2) obj;
            return n() == f2Var.n() && m() == f2Var.m() && Objects.equals(j(), f2Var.j()) && Objects.equals(h(), f2Var.h()) && Objects.equals(e(), f2Var.e());
        }
        return false;
    }

    public z.c f(int i5) {
        return z.c.f5748e;
    }

    public z.c g() {
        return j();
    }

    public z.c h() {
        return z.c.f5748e;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    public z.c i() {
        return j();
    }

    public z.c j() {
        return z.c.f5748e;
    }

    public z.c k() {
        return j();
    }

    public h2 l(int i5, int i6, int i7, int i8) {
        return f3129b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void o(z.c[] cVarArr) {
    }

    public void p(h2 h2Var) {
    }

    public void q(z.c cVar) {
    }
}

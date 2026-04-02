package d;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.k3;
import androidx.appcompat.widget.p3;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class x0 extends b {

    /* renamed from: a  reason: collision with root package name */
    public final p3 f2474a;

    /* renamed from: b  reason: collision with root package name */
    public final Window.Callback f2475b;

    /* renamed from: c  reason: collision with root package name */
    public final v0 f2476c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2477d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2478e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2479f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f2480g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final androidx.activity.j f2481h = new androidx.activity.j(1, this);

    public x0(Toolbar toolbar, CharSequence charSequence, h0 h0Var) {
        v0 v0Var = new v0(this);
        toolbar.getClass();
        p3 p3Var = new p3(toolbar, false);
        this.f2474a = p3Var;
        h0Var.getClass();
        this.f2475b = h0Var;
        p3Var.f496k = h0Var;
        toolbar.setOnMenuItemClickListener(v0Var);
        if (!p3Var.f492g) {
            p3Var.f493h = charSequence;
            if ((p3Var.f487b & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (p3Var.f492g) {
                    h0.z0.o(toolbar.getRootView(), charSequence);
                }
            }
        }
        this.f2476c = new v0(this);
    }

    @Override // d.b
    public final boolean a() {
        ActionMenuView actionMenuView = this.f2474a.f486a.f249g;
        if (actionMenuView != null) {
            androidx.appcompat.widget.n nVar = actionMenuView.f207z;
            return nVar != null && nVar.f();
        }
        return false;
    }

    @Override // d.b
    public final boolean b() {
        k3 k3Var = this.f2474a.f486a.S;
        if ((k3Var == null || k3Var.f400h == null) ? false : true) {
            h.q qVar = k3Var == null ? null : k3Var.f400h;
            if (qVar != null) {
                qVar.collapseActionView();
            }
            return true;
        }
        return false;
    }

    @Override // d.b
    public final void c(boolean z4) {
        if (z4 == this.f2479f) {
            return;
        }
        this.f2479f = z4;
        ArrayList arrayList = this.f2480g;
        if (arrayList.size() <= 0) {
            return;
        }
        androidx.appcompat.widget.b0.n(arrayList.get(0));
        throw null;
    }

    @Override // d.b
    public final int d() {
        return this.f2474a.f487b;
    }

    @Override // d.b
    public final Context e() {
        return this.f2474a.a();
    }

    @Override // d.b
    public final boolean f() {
        p3 p3Var = this.f2474a;
        Toolbar toolbar = p3Var.f486a;
        androidx.activity.j jVar = this.f2481h;
        toolbar.removeCallbacks(jVar);
        Toolbar toolbar2 = p3Var.f486a;
        WeakHashMap weakHashMap = h0.z0.f3233a;
        toolbar2.postOnAnimation(jVar);
        return true;
    }

    @Override // d.b
    public final void g() {
    }

    @Override // d.b
    public final void h() {
        this.f2474a.f486a.removeCallbacks(this.f2481h);
    }

    @Override // d.b
    public final boolean i(int i5, KeyEvent keyEvent) {
        Menu q5 = q();
        if (q5 != null) {
            q5.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return q5.performShortcut(i5, keyEvent, 0);
        }
        return false;
    }

    @Override // d.b
    public final boolean j(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            k();
        }
        return true;
    }

    @Override // d.b
    public final boolean k() {
        ActionMenuView actionMenuView = this.f2474a.f486a.f249g;
        if (actionMenuView != null) {
            androidx.appcompat.widget.n nVar = actionMenuView.f207z;
            return nVar != null && nVar.l();
        }
        return false;
    }

    @Override // d.b
    public final void l(boolean z4) {
    }

    @Override // d.b
    public final void m(boolean z4) {
        p3 p3Var = this.f2474a;
        p3Var.b((p3Var.f487b & (-5)) | 4);
    }

    @Override // d.b
    public final void n(boolean z4) {
    }

    @Override // d.b
    public final void o(CharSequence charSequence) {
        p3 p3Var = this.f2474a;
        if (p3Var.f492g) {
            return;
        }
        p3Var.f493h = charSequence;
        if ((p3Var.f487b & 8) != 0) {
            Toolbar toolbar = p3Var.f486a;
            toolbar.setTitle(charSequence);
            if (p3Var.f492g) {
                h0.z0.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    public final Menu q() {
        boolean z4 = this.f2478e;
        p3 p3Var = this.f2474a;
        if (!z4) {
            w0 w0Var = new w0(this);
            v0 v0Var = new v0(this);
            Toolbar toolbar = p3Var.f486a;
            toolbar.T = w0Var;
            toolbar.U = v0Var;
            ActionMenuView actionMenuView = toolbar.f249g;
            if (actionMenuView != null) {
                actionMenuView.A = w0Var;
                actionMenuView.B = v0Var;
            }
            this.f2478e = true;
        }
        return p3Var.f486a.getMenu();
    }
}

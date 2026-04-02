package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.o0;
import androidx.fragment.app.w0;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f120a;

    /* renamed from: b  reason: collision with root package name */
    public final b4.c f121b = new b4.c();

    /* renamed from: c  reason: collision with root package name */
    public o0 f122c;

    /* renamed from: d  reason: collision with root package name */
    public final OnBackInvokedCallback f123d;

    /* renamed from: e  reason: collision with root package name */
    public OnBackInvokedDispatcher f124e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f125f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f126g;

    public z(Runnable runnable) {
        this.f120a = runnable;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33) {
            this.f123d = i5 >= 34 ? w.f116a.a(new r(this, 0), new r(this, 1), new s(0, this), new s(1, this)) : u.f111a.a(new s(2, this));
        }
    }

    public final void a(androidx.lifecycle.t tVar, o0 o0Var) {
        e4.e.f(o0Var, "onBackPressedCallback");
        androidx.lifecycle.o lifecycle = tVar.getLifecycle();
        if (((androidx.lifecycle.v) lifecycle).f1151c == androidx.lifecycle.n.DESTROYED) {
            return;
        }
        o0Var.f962b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, lifecycle, o0Var));
        d();
        o0Var.f963c = new y(0, this);
    }

    public final void b() {
        Object obj;
        b4.c cVar = this.f121b;
        ListIterator<E> listIterator = cVar.listIterator(cVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((o0) obj).f961a) {
                break;
            }
        }
        o0 o0Var = (o0) obj;
        this.f122c = null;
        if (o0Var == null) {
            Runnable runnable = this.f120a;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        w0 w0Var = o0Var.f964d;
        w0Var.x(true);
        if (w0Var.f1032h.f961a) {
            w0Var.P();
        } else {
            w0Var.f1031g.b();
        }
    }

    public final void c(boolean z4) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f124e;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.f123d) == null) {
            return;
        }
        u uVar = u.f111a;
        if (z4 && !this.f125f) {
            uVar.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f125f = true;
        } else if (z4 || !this.f125f) {
        } else {
            uVar.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f125f = false;
        }
    }

    public final void d() {
        boolean z4;
        boolean z5 = this.f126g;
        b4.c cVar = this.f121b;
        if (!(cVar instanceof Collection) || !cVar.isEmpty()) {
            Iterator it = cVar.iterator();
            while (it.hasNext()) {
                if (((o0) it.next()).f961a) {
                    z4 = true;
                    break;
                }
            }
        }
        z4 = false;
        this.f126g = z4;
        if (z4 == z5 || Build.VERSION.SDK_INT < 33) {
            return;
        }
        c(z4);
    }
}

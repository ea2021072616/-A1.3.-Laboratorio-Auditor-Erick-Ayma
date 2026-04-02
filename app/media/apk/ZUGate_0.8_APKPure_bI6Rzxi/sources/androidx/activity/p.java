package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
/* loaded from: classes.dex */
public class p extends Dialog implements androidx.lifecycle.t, a0, b1.f {

    /* renamed from: g  reason: collision with root package name */
    public androidx.lifecycle.v f69g;

    /* renamed from: h  reason: collision with root package name */
    public final b1.e f70h;

    /* renamed from: i  reason: collision with root package name */
    public final z f71i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, int i5) {
        super(context, i5);
        e4.e.f(context, "context");
        this.f70h = z0.d.c(this);
        this.f71i = new z(new d(2, this));
    }

    public static void a(p pVar) {
        e4.e.f(pVar, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e4.e.f(view, "view");
        b();
        super.addContentView(view, layoutParams);
    }

    public final void b() {
        Window window = getWindow();
        e4.e.c(window);
        View decorView = window.getDecorView();
        e4.e.e(decorView, "window!!.decorView");
        b4.j.S(decorView, this);
        Window window2 = getWindow();
        e4.e.c(window2);
        View decorView2 = window2.getDecorView();
        e4.e.e(decorView2, "window!!.decorView");
        p2.a.S(decorView2, this);
        Window window3 = getWindow();
        e4.e.c(window3);
        View decorView3 = window3.getDecorView();
        e4.e.e(decorView3, "window!!.decorView");
        b4.j.T(decorView3, this);
    }

    @Override // androidx.lifecycle.t
    public final androidx.lifecycle.o getLifecycle() {
        androidx.lifecycle.v vVar = this.f69g;
        if (vVar == null) {
            androidx.lifecycle.v vVar2 = new androidx.lifecycle.v(this);
            this.f69g = vVar2;
            return vVar2;
        }
        return vVar;
    }

    @Override // androidx.activity.a0
    public final z getOnBackPressedDispatcher() {
        return this.f71i;
    }

    @Override // b1.f
    public final b1.d getSavedStateRegistry() {
        return this.f70h.f1617b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f71i.b();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            e4.e.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            z zVar = this.f71i;
            zVar.getClass();
            zVar.f124e = onBackInvokedDispatcher;
            zVar.c(zVar.f126g);
        }
        this.f70h.b(bundle);
        androidx.lifecycle.v vVar = this.f69g;
        if (vVar == null) {
            vVar = new androidx.lifecycle.v(this);
            this.f69g = vVar;
        }
        vVar.e(androidx.lifecycle.m.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        e4.e.e(onSaveInstanceState, "super.onSaveInstanceState()");
        this.f70h.c(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        androidx.lifecycle.v vVar = this.f69g;
        if (vVar == null) {
            vVar = new androidx.lifecycle.v(this);
            this.f69g = vVar;
        }
        vVar.e(androidx.lifecycle.m.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        androidx.lifecycle.v vVar = this.f69g;
        if (vVar == null) {
            vVar = new androidx.lifecycle.v(this);
            this.f69g = vVar;
        }
        vVar.e(androidx.lifecycle.m.ON_DESTROY);
        this.f69g = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i5) {
        b();
        super.setContentView(i5);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        e4.e.f(view, "view");
        b();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e4.e.f(view, "view");
        b();
        super.setContentView(view, layoutParams);
    }
}

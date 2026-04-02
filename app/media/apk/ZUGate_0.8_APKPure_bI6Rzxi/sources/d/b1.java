package d;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class b1 extends g.b implements h.m {

    /* renamed from: i  reason: collision with root package name */
    public final Context f2285i;

    /* renamed from: j  reason: collision with root package name */
    public final h.o f2286j;

    /* renamed from: k  reason: collision with root package name */
    public g.a f2287k;

    /* renamed from: l  reason: collision with root package name */
    public WeakReference f2288l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ c1 f2289m;

    public b1(c1 c1Var, Context context, c0 c0Var) {
        this.f2289m = c1Var;
        this.f2285i = context;
        this.f2287k = c0Var;
        h.o oVar = new h.o(context);
        oVar.f3035r = 1;
        this.f2286j = oVar;
        oVar.f3029k = this;
    }

    @Override // g.b
    public final void a() {
        c1 c1Var = this.f2289m;
        if (c1Var.f2302i != this) {
            return;
        }
        if (!c1Var.f2308p) {
            this.f2287k.b(this);
        } else {
            c1Var.f2303j = this;
            c1Var.f2304k = this.f2287k;
        }
        this.f2287k = null;
        c1Var.q(false);
        ActionBarContextView actionBarContextView = c1Var.f2299f;
        if (actionBarContextView.f174q == null) {
            actionBarContextView.e();
        }
        c1Var.f2296c.setHideOnContentScrollEnabled(c1Var.f2313u);
        c1Var.f2302i = null;
    }

    @Override // g.b
    public final View b() {
        WeakReference weakReference = this.f2288l;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // h.m
    public final void c(h.o oVar) {
        if (this.f2287k == null) {
            return;
        }
        i();
        androidx.appcompat.widget.n nVar = this.f2289m.f2299f.f168j;
        if (nVar != null) {
            nVar.l();
        }
    }

    @Override // h.m
    public final boolean d(h.o oVar, MenuItem menuItem) {
        g.a aVar = this.f2287k;
        if (aVar != null) {
            return aVar.d(this, menuItem);
        }
        return false;
    }

    @Override // g.b
    public final h.o e() {
        return this.f2286j;
    }

    @Override // g.b
    public final MenuInflater f() {
        return new g.j(this.f2285i);
    }

    @Override // g.b
    public final CharSequence g() {
        return this.f2289m.f2299f.getSubtitle();
    }

    @Override // g.b
    public final CharSequence h() {
        return this.f2289m.f2299f.getTitle();
    }

    @Override // g.b
    public final void i() {
        if (this.f2289m.f2302i != this) {
            return;
        }
        h.o oVar = this.f2286j;
        oVar.w();
        try {
            this.f2287k.a(this, oVar);
        } finally {
            oVar.v();
        }
    }

    @Override // g.b
    public final boolean j() {
        return this.f2289m.f2299f.f182y;
    }

    @Override // g.b
    public final void k(View view) {
        this.f2289m.f2299f.setCustomView(view);
        this.f2288l = new WeakReference(view);
    }

    @Override // g.b
    public final void l(int i5) {
        m(this.f2289m.f2294a.getResources().getString(i5));
    }

    @Override // g.b
    public final void m(CharSequence charSequence) {
        this.f2289m.f2299f.setSubtitle(charSequence);
    }

    @Override // g.b
    public final void n(int i5) {
        o(this.f2289m.f2294a.getResources().getString(i5));
    }

    @Override // g.b
    public final void o(CharSequence charSequence) {
        this.f2289m.f2299f.setTitle(charSequence);
    }

    @Override // g.b
    public final void p(boolean z4) {
        this.f2864h = z4;
        this.f2289m.f2299f.setTitleOptional(z4);
    }
}

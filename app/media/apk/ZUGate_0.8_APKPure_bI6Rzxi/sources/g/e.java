package g;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class e extends b implements h.m {

    /* renamed from: i  reason: collision with root package name */
    public final Context f2871i;

    /* renamed from: j  reason: collision with root package name */
    public final ActionBarContextView f2872j;

    /* renamed from: k  reason: collision with root package name */
    public final a f2873k;

    /* renamed from: l  reason: collision with root package name */
    public WeakReference f2874l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2875m;

    /* renamed from: n  reason: collision with root package name */
    public final h.o f2876n;

    public e(Context context, ActionBarContextView actionBarContextView, a aVar) {
        this.f2871i = context;
        this.f2872j = actionBarContextView;
        this.f2873k = aVar;
        h.o oVar = new h.o(actionBarContextView.getContext());
        oVar.f3035r = 1;
        this.f2876n = oVar;
        oVar.f3029k = this;
    }

    @Override // g.b
    public final void a() {
        if (this.f2875m) {
            return;
        }
        this.f2875m = true;
        this.f2873k.b(this);
    }

    @Override // g.b
    public final View b() {
        WeakReference weakReference = this.f2874l;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // h.m
    public final void c(h.o oVar) {
        i();
        androidx.appcompat.widget.n nVar = this.f2872j.f168j;
        if (nVar != null) {
            nVar.l();
        }
    }

    @Override // h.m
    public final boolean d(h.o oVar, MenuItem menuItem) {
        return this.f2873k.d(this, menuItem);
    }

    @Override // g.b
    public final h.o e() {
        return this.f2876n;
    }

    @Override // g.b
    public final MenuInflater f() {
        return new j(this.f2872j.getContext());
    }

    @Override // g.b
    public final CharSequence g() {
        return this.f2872j.getSubtitle();
    }

    @Override // g.b
    public final CharSequence h() {
        return this.f2872j.getTitle();
    }

    @Override // g.b
    public final void i() {
        this.f2873k.a(this, this.f2876n);
    }

    @Override // g.b
    public final boolean j() {
        return this.f2872j.f182y;
    }

    @Override // g.b
    public final void k(View view) {
        this.f2872j.setCustomView(view);
        this.f2874l = view != null ? new WeakReference(view) : null;
    }

    @Override // g.b
    public final void l(int i5) {
        m(this.f2871i.getString(i5));
    }

    @Override // g.b
    public final void m(CharSequence charSequence) {
        this.f2872j.setSubtitle(charSequence);
    }

    @Override // g.b
    public final void n(int i5) {
        o(this.f2871i.getString(i5));
    }

    @Override // g.b
    public final void o(CharSequence charSequence) {
        this.f2872j.setTitle(charSequence);
    }

    @Override // g.b
    public final void p(boolean z4) {
        this.f2864h = z4;
        this.f2872j.setTitleOptional(z4);
    }
}

package h;

import android.view.MenuItem;
import d.u0;
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f2986b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem f2987c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f2988d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u0 f2989e;

    public g(u0 u0Var, h hVar, q qVar, o oVar) {
        this.f2989e = u0Var;
        this.f2986b = hVar;
        this.f2987c = qVar;
        this.f2988d = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f2986b;
        if (hVar != null) {
            u0 u0Var = this.f2989e;
            ((i) u0Var.f2463h).G = true;
            hVar.f2991b.c(false);
            ((i) u0Var.f2463h).G = false;
        }
        MenuItem menuItem = this.f2987c;
        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
            this.f2988d.q(menuItem, null, 4);
        }
    }
}

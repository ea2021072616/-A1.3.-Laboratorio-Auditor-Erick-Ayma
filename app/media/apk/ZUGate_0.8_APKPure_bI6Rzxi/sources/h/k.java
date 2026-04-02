package h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;
/* loaded from: classes.dex */
public final class k implements a0, AdapterView.OnItemClickListener {

    /* renamed from: g  reason: collision with root package name */
    public Context f3013g;

    /* renamed from: h  reason: collision with root package name */
    public LayoutInflater f3014h;

    /* renamed from: i  reason: collision with root package name */
    public o f3015i;

    /* renamed from: j  reason: collision with root package name */
    public ExpandedMenuView f3016j;

    /* renamed from: k  reason: collision with root package name */
    public z f3017k;

    /* renamed from: l  reason: collision with root package name */
    public j f3018l;

    public k(Context context) {
        this.f3013g = context;
        this.f3014h = LayoutInflater.from(context);
    }

    @Override // h.a0
    public final void b(o oVar, boolean z4) {
        z zVar = this.f3017k;
        if (zVar != null) {
            zVar.b(oVar, z4);
        }
    }

    @Override // h.a0
    public final void c(z zVar) {
        this.f3017k = zVar;
    }

    @Override // h.a0
    public final void d(Context context, o oVar) {
        if (this.f3013g != null) {
            this.f3013g = context;
            if (this.f3014h == null) {
                this.f3014h = LayoutInflater.from(context);
            }
        }
        this.f3015i = oVar;
        j jVar = this.f3018l;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    @Override // h.a0
    public final boolean e() {
        return false;
    }

    @Override // h.a0
    public final boolean g(q qVar) {
        return false;
    }

    @Override // h.a0
    public final void h() {
        j jVar = this.f3018l;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    @Override // h.a0
    public final boolean i(q qVar) {
        return false;
    }

    @Override // h.a0
    public final boolean k(g0 g0Var) {
        if (g0Var.hasVisibleItems()) {
            p pVar = new p(g0Var);
            Context context = g0Var.f3025g;
            d.m mVar = new d.m(context);
            Object obj = mVar.f2398h;
            k kVar = new k(((d.i) obj).f2339a);
            pVar.f3046i = kVar;
            kVar.f3017k = pVar;
            g0Var.b(kVar, context);
            k kVar2 = pVar.f3046i;
            if (kVar2.f3018l == null) {
                kVar2.f3018l = new j(kVar2);
            }
            d.i iVar = (d.i) obj;
            iVar.f2354q = kVar2.f3018l;
            iVar.f2355r = pVar;
            View view = g0Var.f3038u;
            if (view != null) {
                iVar.f2343e = view;
            } else {
                ((d.i) obj).f2341c = g0Var.f3037t;
                ((d.i) obj).f2342d = g0Var.f3036s;
            }
            iVar.o = pVar;
            d.n a5 = mVar.a();
            pVar.f3045h = a5;
            a5.setOnDismissListener(pVar);
            WindowManager.LayoutParams attributes = pVar.f3045h.getWindow().getAttributes();
            attributes.type = 1003;
            attributes.flags |= 131072;
            pVar.f3045h.show();
            z zVar = this.f3017k;
            if (zVar != null) {
                zVar.h(g0Var);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        this.f3015i.q(this.f3018l.getItem(i5), this, 0);
    }
}

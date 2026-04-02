package n2;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.k;
import b3.f;
import com.android.billingclient.api.Purchase;
import com.google.android.gms.internal.play_billing.j;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import h0.h2;
import h0.x;
import h0.z0;
import h1.g;
import h1.o;
import h1.s;
import h1.u;
import i0.t;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import r3.h;
import w1.p;
import y4.i;
/* loaded from: classes.dex */
public final /* synthetic */ class b implements t, x, c3.a, h1.b {

    /* renamed from: g  reason: collision with root package name */
    public Object f4085g;

    public /* synthetic */ b(Object obj) {
        this.f4085g = obj;
    }

    @Override // h0.x
    public final h2 a(View view, h2 h2Var) {
        y4.a aVar = (y4.a) this.f4085g;
        f fVar = aVar.f5715s;
        if (fVar != null) {
            aVar.f5709l.W.remove(fVar);
        }
        y4.a aVar2 = (y4.a) this.f4085g;
        aVar2.f5715s = new f(aVar2.o, h2Var);
        y4.a aVar3 = (y4.a) this.f4085g;
        aVar3.f5715s.e(aVar3.getWindow());
        y4.a aVar4 = (y4.a) this.f4085g;
        BottomSheetBehavior bottomSheetBehavior = aVar4.f5709l;
        f fVar2 = aVar4.f5715s;
        ArrayList arrayList = bottomSheetBehavior.W;
        if (!arrayList.contains(fVar2)) {
            arrayList.add(fVar2);
        }
        return h2Var;
    }

    @Override // h1.b
    public final void b(g gVar) {
        if (gVar.f3283b != 0) {
            ((i) this.f4085g).f5734a.a();
            return;
        }
        h1.a aVar = ((i) this.f4085g).f5734a;
        b bVar = new b(this);
        aVar.getClass();
        if (!aVar.b()) {
            g gVar2 = u.f3327j;
            aVar.i(s.a(2, 9, gVar2));
            com.google.android.gms.internal.play_billing.d dVar = com.google.android.gms.internal.play_billing.f.f1859c;
            bVar.g(gVar2, j.f1896f);
        } else if (TextUtils.isEmpty("inapp")) {
            com.google.android.gms.internal.play_billing.s.e("BillingClient", "Please provide a valid product type.");
            g gVar3 = u.f3322e;
            aVar.i(s.a(50, 9, gVar3));
            com.google.android.gms.internal.play_billing.d dVar2 = com.google.android.gms.internal.play_billing.f.f1859c;
            bVar.g(gVar3, j.f1896f);
        } else if (aVar.h(new o(aVar, "inapp", bVar, 1), 30000L, new k(aVar, bVar, 5), aVar.d()) == null) {
            g f5 = aVar.f();
            aVar.i(s.a(25, 9, f5));
            com.google.android.gms.internal.play_billing.d dVar3 = com.google.android.gms.internal.play_billing.f.f1859c;
            bVar.g(f5, j.f1896f);
        }
    }

    @Override // i0.t
    public final boolean c(View view) {
        boolean z4 = false;
        if (((SwipeDismissBehavior) this.f4085g).v(view)) {
            WeakHashMap weakHashMap = z0.f3233a;
            boolean z5 = view.getLayoutDirection() == 1;
            int i5 = ((SwipeDismissBehavior) this.f4085g).f2016e;
            if ((i5 == 0 && z5) || (i5 == 1 && !z5)) {
                z4 = true;
            }
            int width = view.getWidth();
            if (z4) {
                width = -width;
            }
            view.offsetLeftAndRight(width);
            view.setAlpha(0.0f);
            h hVar = ((SwipeDismissBehavior) this.f4085g).f2013b;
            if (hVar != null) {
                hVar.b(view);
            }
            return true;
        }
        return false;
    }

    public final void d(p pVar, BufferedWriter bufferedWriter) {
        x3.d dVar = (x3.d) this.f4085g;
        x3.e eVar = new x3.e(bufferedWriter, dVar.f5502a, dVar.f5503b, dVar.f5504c, dVar.f5505d);
        eVar.e(pVar);
        eVar.g();
        eVar.f5507b.flush();
    }

    @Override // h1.b
    public final void e() {
    }

    public final void f(g gVar, ArrayList arrayList) {
        ((Dialog) ((d0) this.f4085g).f306h).dismiss();
        if (gVar.f3283b == 0) {
            if (((i) ((d0) this.f4085g).f307i).f5735b.isFinishing()) {
                ((i) ((d0) this.f4085g).f307i).f5734a.a();
                return;
            } else {
                ((i) ((d0) this.f4085g).f307i).f5735b.runOnUiThread(new k(this, 14, arrayList));
                return;
            }
        }
        Activity activity = ((i) ((d0) this.f4085g).f307i).f5735b;
        Toast.makeText(activity, "Error on get detail (code " + gVar.f3283b + ")", 0).show();
        ((i) ((d0) this.f4085g).f307i).f5734a.a();
    }

    public final void g(g gVar, List list) {
        if (gVar.f3283b != 0) {
            return;
        }
        Iterator it = list.iterator();
        boolean z4 = true;
        boolean z5 = true;
        while (true) {
            if (!it.hasNext()) {
                z4 = false;
                break;
            }
            Purchase purchase = (Purchase) it.next();
            if (purchase.f1801c.optBoolean("acknowledged", true)) {
                Iterator it2 = purchase.a().iterator();
                while (it2.hasNext()) {
                    ((i) ((b) this.f4085g).f4085g).f5736c.a((String) it2.next(), false);
                }
            } else {
                ((i) ((b) this.f4085g).f4085g).a(purchase);
                z5 = false;
            }
        }
        if (!z4) {
            ((i) ((b) this.f4085g).f4085g).f5736c.a(null, false);
        }
        if (z5) {
            ((i) ((b) this.f4085g).f4085g).f5734a.a();
        }
    }

    public b(SwipeDismissBehavior swipeDismissBehavior) {
        swipeDismissBehavior.getClass();
        swipeDismissBehavior.f2018g = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        swipeDismissBehavior.f2019h = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        swipeDismissBehavior.f2016e = 0;
    }
}

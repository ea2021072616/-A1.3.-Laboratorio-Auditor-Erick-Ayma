package y4;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.k;
import androidx.emoji2.text.u;
import com.android.billingclient.api.Purchase;
import com.github.appintro.R;
import h1.o;
import h1.s;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final h1.a f5734a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f5735b;

    /* renamed from: c  reason: collision with root package name */
    public final e f5736c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5737d;

    public i(Activity activity, boolean z4, e eVar) {
        this.f5735b = activity;
        this.f5736c = eVar;
        h1.h hVar = new h1.h(false);
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
        if (!hVar.f3285a) {
            throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
        }
        this.f5734a = new h1.a(hVar, activity, this);
        this.f5737d = z4;
    }

    public final void a(Purchase purchase) {
        JSONObject jSONObject = purchase.f1801c;
        String optString = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        if (optString == null) {
            throw new IllegalArgumentException("Purchase token must be set");
        }
        u uVar = new u(2);
        uVar.f788b = optString;
        d0 d0Var = new d0(this, purchase, 28);
        h1.a aVar = this.f5734a;
        if (!aVar.b()) {
            h1.g gVar = h1.u.f3327j;
            aVar.i(s.a(2, 3, gVar));
            d0Var.k(gVar);
        } else if (TextUtils.isEmpty(uVar.f788b)) {
            com.google.android.gms.internal.play_billing.s.e("BillingClient", "Please provide a valid purchase token.");
            h1.g gVar2 = h1.u.f3324g;
            aVar.i(s.a(26, 3, gVar2));
            d0Var.k(gVar2);
        } else if (!aVar.f3252l) {
            h1.g gVar3 = h1.u.f3319b;
            aVar.i(s.a(27, 3, gVar3));
            d0Var.k(gVar3);
        } else if (aVar.h(new o(aVar, uVar, d0Var, 3), 30000L, new k(aVar, d0Var, 8), aVar.d()) == null) {
            h1.g f5 = aVar.f();
            aVar.i(s.a(25, 3, f5));
            d0Var.k(f5);
        }
    }

    public final void b(h1.g gVar, List list) {
        if (this.f5737d) {
            int i5 = gVar.f3283b;
            Activity activity = this.f5735b;
            if (i5 != 0 || list == null || list.size() <= 0) {
                if (gVar.f3283b == 7) {
                    Toast.makeText(activity, "Already Donated! Thank you :)", 0).show();
                    return;
                }
                return;
            }
            Toast.makeText(activity, (int) R.string.thanks_for_donate, 0).show();
            Purchase purchase = (Purchase) list.get(0);
            Iterator it = purchase.a().iterator();
            while (it.hasNext()) {
                this.f5736c.a((String) it.next(), true);
            }
            a(purchase);
        }
    }
}

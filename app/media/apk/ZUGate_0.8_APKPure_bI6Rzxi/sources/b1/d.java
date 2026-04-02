package b1;

import android.os.Bundle;
import androidx.lifecycle.j;
import d.o;
import j.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public boolean f1611b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f1612c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1613d;

    /* renamed from: e  reason: collision with root package name */
    public o f1614e;

    /* renamed from: a  reason: collision with root package name */
    public final g f1610a = new g();

    /* renamed from: f  reason: collision with root package name */
    public boolean f1615f = true;

    public final Bundle a(String str) {
        if (this.f1613d) {
            Bundle bundle = this.f1612c;
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle(str);
                Bundle bundle3 = this.f1612c;
                if (bundle3 != null) {
                    bundle3.remove(str);
                }
                Bundle bundle4 = this.f1612c;
                if (!((bundle4 == null || bundle4.isEmpty()) ? false : true)) {
                    this.f1612c = null;
                }
                return bundle2;
            }
            return null;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final c b() {
        Map.Entry entry;
        c cVar;
        Iterator it = this.f1610a.iterator();
        do {
            j.e eVar = (j.e) it;
            if (!eVar.hasNext()) {
                return null;
            }
            entry = (Map.Entry) eVar.next();
            e4.e.e(entry, "components");
            cVar = (c) entry.getValue();
        } while (!e4.e.a((String) entry.getKey(), "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return cVar;
    }

    public final void c(String str, c cVar) {
        Object obj;
        e4.e.f(str, "key");
        e4.e.f(cVar, "provider");
        g gVar = this.f1610a;
        j.c e5 = gVar.e(str);
        if (e5 != null) {
            obj = e5.f3421c;
        } else {
            j.c cVar2 = new j.c(str, cVar);
            gVar.f3432e++;
            j.c cVar3 = gVar.f3430c;
            if (cVar3 == null) {
                gVar.f3429b = cVar2;
                gVar.f3430c = cVar2;
            } else {
                cVar3.f3422d = cVar2;
                cVar2.f3423e = cVar3;
                gVar.f3430c = cVar2;
            }
            obj = null;
        }
        if (!(((c) obj) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void d() {
        if (!this.f1615f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        o oVar = this.f1614e;
        if (oVar == null) {
            oVar = new o(this);
        }
        this.f1614e = oVar;
        try {
            j.class.getDeclaredConstructor(new Class[0]);
            o oVar2 = this.f1614e;
            if (oVar2 != null) {
                ((Set) oVar2.f2443b).add(j.class.getName());
            }
        } catch (NoSuchMethodException e5) {
            throw new IllegalArgumentException("Class " + j.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
        }
    }
}

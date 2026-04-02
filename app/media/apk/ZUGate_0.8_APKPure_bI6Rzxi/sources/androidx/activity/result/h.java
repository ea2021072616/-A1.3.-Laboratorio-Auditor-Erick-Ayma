package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.n0;
import androidx.lifecycle.m;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f92a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f93b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f94c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f95d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final transient HashMap f96e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f97f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f98g = new Bundle();

    public final boolean a(int i5, int i6, Intent intent) {
        c cVar;
        String str = (String) this.f92a.get(Integer.valueOf(i5));
        if (str == null) {
            return false;
        }
        f fVar = (f) this.f96e.get(str);
        if (fVar == null || (cVar = fVar.f88a) == null || !this.f95d.contains(str)) {
            this.f97f.remove(str);
            this.f98g.putParcelable(str, new b(intent, i6));
            return true;
        }
        cVar.a(fVar.f89b.c(intent, i6));
        this.f95d.remove(str);
        return true;
    }

    public abstract void b(int i5, b.a aVar, Object obj);

    public final e c(final String str, t tVar, final b.a aVar, final c cVar) {
        o lifecycle = tVar.getLifecycle();
        v vVar = (v) lifecycle;
        if (vVar.f1151c.compareTo(n.STARTED) >= 0) {
            throw new IllegalStateException("LifecycleOwner " + tVar + " is attempting to register while current state is " + vVar.f1151c + ". LifecycleOwners must call register before they are STARTED.");
        }
        e(str);
        HashMap hashMap = this.f94c;
        g gVar = (g) hashMap.get(str);
        if (gVar == null) {
            gVar = new g(lifecycle);
        }
        r rVar = new r() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // androidx.lifecycle.r
            public final void b(t tVar2, m mVar) {
                boolean equals = m.ON_START.equals(mVar);
                String str2 = str;
                h hVar = h.this;
                if (!equals) {
                    if (m.ON_STOP.equals(mVar)) {
                        hVar.f96e.remove(str2);
                        return;
                    } else if (m.ON_DESTROY.equals(mVar)) {
                        hVar.f(str2);
                        return;
                    } else {
                        return;
                    }
                }
                HashMap hashMap2 = hVar.f96e;
                b.a aVar2 = aVar;
                c cVar2 = cVar;
                hashMap2.put(str2, new f(aVar2, cVar2));
                HashMap hashMap3 = hVar.f97f;
                if (hashMap3.containsKey(str2)) {
                    Object obj = hashMap3.get(str2);
                    hashMap3.remove(str2);
                    cVar2.a(obj);
                }
                Bundle bundle = hVar.f98g;
                b bVar = (b) bundle.getParcelable(str2);
                if (bVar != null) {
                    bundle.remove(str2);
                    cVar2.a(aVar2.c(bVar.f83c, bVar.f82b));
                }
            }
        };
        gVar.f90a.a(rVar);
        gVar.f91b.add(rVar);
        hashMap.put(str, gVar);
        return new e(this, str, aVar, 0);
    }

    public final e d(String str, b.a aVar, n0 n0Var) {
        e(str);
        this.f96e.put(str, new f(aVar, n0Var));
        HashMap hashMap = this.f97f;
        if (hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            hashMap.remove(str);
            n0Var.a(obj);
        }
        Bundle bundle = this.f98g;
        b bVar = (b) bundle.getParcelable(str);
        if (bVar != null) {
            bundle.remove(str);
            n0Var.a(aVar.c(bVar.f83c, bVar.f82b));
        }
        return new e(this, str, aVar, 1);
    }

    public final void e(String str) {
        HashMap hashMap = this.f93b;
        if (((Integer) hashMap.get(str)) != null) {
            return;
        }
        int a5 = k4.e.f3661b.a();
        while (true) {
            int i5 = a5 + 65536;
            HashMap hashMap2 = this.f92a;
            if (!hashMap2.containsKey(Integer.valueOf(i5))) {
                hashMap2.put(Integer.valueOf(i5), str);
                hashMap.put(str, Integer.valueOf(i5));
                return;
            }
            a5 = k4.e.f3661b.a();
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.f95d.contains(str) && (num = (Integer) this.f93b.remove(str)) != null) {
            this.f92a.remove(num);
        }
        this.f96e.remove(str);
        HashMap hashMap = this.f97f;
        if (hashMap.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + hashMap.get(str));
            hashMap.remove(str);
        }
        Bundle bundle = this.f98g;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + bundle.getParcelable(str));
            bundle.remove(str);
        }
        HashMap hashMap2 = this.f94c;
        g gVar = (g) hashMap2.get(str);
        if (gVar != null) {
            ArrayList arrayList = gVar.f91b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                gVar.f90a.b((r) it.next());
            }
            arrayList.clear();
            hashMap2.remove(str);
        }
    }
}

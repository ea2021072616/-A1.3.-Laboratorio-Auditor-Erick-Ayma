package b1;

import android.os.Bundle;
import androidx.lifecycle.m;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import androidx.savedstate.Recreator;
import j.g;
import java.util.Map;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final f f1616a;

    /* renamed from: b  reason: collision with root package name */
    public final d f1617b = new d();

    /* renamed from: c  reason: collision with root package name */
    public boolean f1618c;

    public e(f fVar) {
        this.f1616a = fVar;
    }

    public final void a() {
        f fVar = this.f1616a;
        o lifecycle = fVar.getLifecycle();
        if (!(((v) lifecycle).f1151c == n.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.a(new Recreator(fVar));
        final d dVar = this.f1617b;
        dVar.getClass();
        if (!(!dVar.f1611b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.a(new r() { // from class: b1.a
            @Override // androidx.lifecycle.r
            public final void b(t tVar, m mVar) {
                d dVar2 = d.this;
                e4.e.f(dVar2, "this$0");
                if (mVar == m.ON_START) {
                    dVar2.f1615f = true;
                } else if (mVar == m.ON_STOP) {
                    dVar2.f1615f = false;
                }
            }
        });
        dVar.f1611b = true;
        this.f1618c = true;
    }

    public final void b(Bundle bundle) {
        if (!this.f1618c) {
            a();
        }
        v vVar = (v) this.f1616a.getLifecycle();
        if (!(!(vVar.f1151c.compareTo(n.STARTED) >= 0))) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + vVar.f1151c).toString());
        }
        d dVar = this.f1617b;
        if (!dVar.f1611b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!dVar.f1613d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        dVar.f1612c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        dVar.f1613d = true;
    }

    public final void c(Bundle bundle) {
        e4.e.f(bundle, "outBundle");
        d dVar = this.f1617b;
        dVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = dVar.f1612c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        g gVar = dVar.f1610a;
        gVar.getClass();
        j.d dVar2 = new j.d(gVar);
        gVar.f3431d.put(dVar2, Boolean.FALSE);
        while (dVar2.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar2.next();
            bundle2.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}

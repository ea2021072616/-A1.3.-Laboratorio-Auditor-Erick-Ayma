package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;
/* loaded from: classes.dex */
public final class n0 implements b1.c {

    /* renamed from: a  reason: collision with root package name */
    public final b1.d f1130a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1131b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f1132c;

    /* renamed from: d  reason: collision with root package name */
    public final a4.c f1133d;

    public n0(b1.d dVar, w0 w0Var) {
        e4.e.f(dVar, "savedStateRegistry");
        e4.e.f(w0Var, "viewModelStoreOwner");
        this.f1130a = dVar;
        this.f1133d = new a4.c(new androidx.activity.s(3, w0Var));
    }

    @Override // b1.c
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1132c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((o0) this.f1133d.a()).f1134d.entrySet()) {
            String str = (String) entry.getKey();
            Bundle a5 = ((m0) entry.getValue()).f1123e.a();
            if (!e4.e.a(a5, Bundle.EMPTY)) {
                bundle.putBundle(str, a5);
            }
        }
        this.f1131b = false;
        return bundle;
    }

    public final void b() {
        if (this.f1131b) {
            return;
        }
        Bundle a5 = this.f1130a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1132c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (a5 != null) {
            bundle.putAll(a5);
        }
        this.f1132c = bundle;
        this.f1131b = true;
        o0 o0Var = (o0) this.f1133d.a();
    }
}

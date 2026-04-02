package androidx.fragment.app;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class z0 extends androidx.lifecycle.r0 {

    /* renamed from: j  reason: collision with root package name */
    public static final p3.e f1076j = new p3.e(0);

    /* renamed from: g  reason: collision with root package name */
    public final boolean f1080g;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f1077d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap f1078e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f1079f = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public boolean f1081h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1082i = false;

    public z0(boolean z4) {
        this.f1080g = z4;
    }

    @Override // androidx.lifecycle.r0
    public final void b() {
        if (w0.I(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1081h = true;
    }

    public final void c(Fragment fragment) {
        if (this.f1082i) {
            if (w0.I(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        HashMap hashMap = this.f1077d;
        if (hashMap.containsKey(fragment.mWho)) {
            return;
        }
        hashMap.put(fragment.mWho, fragment);
        if (w0.I(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public final void d(Fragment fragment) {
        if (w0.I(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        e(fragment.mWho);
    }

    public final void e(String str) {
        HashMap hashMap = this.f1078e;
        z0 z0Var = (z0) hashMap.get(str);
        if (z0Var != null) {
            z0Var.b();
            hashMap.remove(str);
        }
        HashMap hashMap2 = this.f1079f;
        androidx.lifecycle.v0 v0Var = (androidx.lifecycle.v0) hashMap2.get(str);
        if (v0Var != null) {
            v0Var.a();
            hashMap2.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z0.class != obj.getClass()) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return this.f1077d.equals(z0Var.f1077d) && this.f1078e.equals(z0Var.f1078e) && this.f1079f.equals(z0Var.f1079f);
    }

    public final void f(Fragment fragment) {
        if (this.f1082i) {
            if (w0.I(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.f1077d.remove(fragment.mWho) != null) && w0.I(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public final int hashCode() {
        int hashCode = this.f1078e.hashCode();
        return this.f1079f.hashCode() + ((hashCode + (this.f1077d.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f1077d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f1078e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f1079f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}

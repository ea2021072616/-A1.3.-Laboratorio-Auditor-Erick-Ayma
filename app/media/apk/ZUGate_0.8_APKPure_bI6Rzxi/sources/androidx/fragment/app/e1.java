package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f867a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f868b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f869c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public z0 f870d;

    public final void a(Fragment fragment) {
        if (this.f867a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f867a) {
            this.f867a.add(fragment);
        }
        fragment.mAdded = true;
    }

    public final Fragment b(String str) {
        d1 d1Var = (d1) this.f868b.get(str);
        if (d1Var != null) {
            return d1Var.f860c;
        }
        return null;
    }

    public final Fragment c(String str) {
        Fragment findFragmentByWho;
        for (d1 d1Var : this.f868b.values()) {
            if (d1Var != null && (findFragmentByWho = d1Var.f860c.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (d1 d1Var : this.f868b.values()) {
            if (d1Var != null) {
                arrayList.add(d1Var);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (d1 d1Var : this.f868b.values()) {
            if (d1Var != null) {
                arrayList.add(d1Var.f860c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.f867a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f867a) {
            arrayList = new ArrayList(this.f867a);
        }
        return arrayList;
    }

    public final void g(d1 d1Var) {
        Fragment fragment = d1Var.f860c;
        String str = fragment.mWho;
        HashMap hashMap = this.f868b;
        if (hashMap.get(str) != null) {
            return;
        }
        hashMap.put(fragment.mWho, d1Var);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                this.f870d.c(fragment);
            } else {
                this.f870d.f(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (w0.I(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public final void h(d1 d1Var) {
        Fragment fragment = d1Var.f860c;
        if (fragment.mRetainInstance) {
            this.f870d.f(fragment);
        }
        if (((d1) this.f868b.put(fragment.mWho, null)) != null && w0.I(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    public final c1 i(String str, c1 c1Var) {
        HashMap hashMap = this.f869c;
        return c1Var != null ? (c1) hashMap.put(str, c1Var) : (c1) hashMap.remove(str);
    }
}

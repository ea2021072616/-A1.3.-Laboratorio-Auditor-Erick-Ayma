package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class p1 implements androidx.lifecycle.i, b1.f, androidx.lifecycle.w0 {

    /* renamed from: g  reason: collision with root package name */
    public final Fragment f967g;

    /* renamed from: h  reason: collision with root package name */
    public final androidx.lifecycle.v0 f968h;

    /* renamed from: i  reason: collision with root package name */
    public androidx.lifecycle.t0 f969i;

    /* renamed from: j  reason: collision with root package name */
    public androidx.lifecycle.v f970j = null;

    /* renamed from: k  reason: collision with root package name */
    public b1.e f971k = null;

    public p1(Fragment fragment, androidx.lifecycle.v0 v0Var) {
        this.f967g = fragment;
        this.f968h = v0Var;
    }

    public final void a(androidx.lifecycle.m mVar) {
        this.f970j.e(mVar);
    }

    public final void b() {
        if (this.f970j == null) {
            this.f970j = new androidx.lifecycle.v(this);
            b1.e c5 = z0.d.c(this);
            this.f971k = c5;
            c5.a();
            b4.j.o(this);
        }
    }

    @Override // androidx.lifecycle.i
    public final w0.b getDefaultViewModelCreationExtras() {
        Application application;
        Fragment fragment = this.f967g;
        Context applicationContext = fragment.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        w0.e eVar = new w0.e();
        LinkedHashMap linkedHashMap = eVar.f5293a;
        if (application != null) {
            linkedHashMap.put(l2.i.f3855i, application);
        }
        linkedHashMap.put(b4.j.f1662a, this);
        linkedHashMap.put(b4.j.f1663b, this);
        if (fragment.getArguments() != null) {
            linkedHashMap.put(b4.j.f1664c, fragment.getArguments());
        }
        return eVar;
    }

    @Override // androidx.lifecycle.i
    public final androidx.lifecycle.t0 getDefaultViewModelProviderFactory() {
        Application application;
        Fragment fragment = this.f967g;
        androidx.lifecycle.t0 defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(fragment.mDefaultFactory)) {
            this.f969i = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f969i == null) {
            Context applicationContext = fragment.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                } else if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                } else {
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                }
            }
            this.f969i = new androidx.lifecycle.p0(application, this, fragment.getArguments());
        }
        return this.f969i;
    }

    @Override // androidx.lifecycle.t
    public final androidx.lifecycle.o getLifecycle() {
        b();
        return this.f970j;
    }

    @Override // b1.f
    public final b1.d getSavedStateRegistry() {
        b();
        return this.f971k.f1617b;
    }

    @Override // androidx.lifecycle.w0
    public final androidx.lifecycle.v0 getViewModelStore() {
        b();
        return this.f968h;
    }
}

package k2;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: k  reason: collision with root package name */
    public static final b f3566k = new b();

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f3567g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f3568h = new AtomicBoolean();

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f3569i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public boolean f3570j = false;

    public final void a(boolean z4) {
        synchronized (f3566k) {
            Iterator it = this.f3569i.iterator();
            while (it.hasNext()) {
                r2.d dVar = ((l) it.next()).f3592a.f3589m;
                dVar.sendMessage(dVar.obtainMessage(1, Boolean.valueOf(z4)));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f3568h;
        boolean compareAndSet = this.f3567g.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f3568h;
        boolean compareAndSet = this.f3567g.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i5) {
        if (i5 == 20 && this.f3567g.compareAndSet(false, true)) {
            this.f3568h.set(true);
            a(true);
        }
    }
}

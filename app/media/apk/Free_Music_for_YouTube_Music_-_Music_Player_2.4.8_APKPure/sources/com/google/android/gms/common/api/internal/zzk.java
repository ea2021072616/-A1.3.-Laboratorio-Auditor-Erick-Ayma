package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.zzp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class zzk implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final zzk zzfim = new zzk();
    private final AtomicBoolean zzfin = new AtomicBoolean();
    private final AtomicBoolean zzfio = new AtomicBoolean();
    private final ArrayList<zzl> mListeners = new ArrayList<>();
    private boolean zzdoj = false;

    private zzk() {
    }

    public static void zza(Application application) {
        synchronized (zzfim) {
            if (!zzfim.zzdoj) {
                application.registerActivityLifecycleCallbacks(zzfim);
                application.registerComponentCallbacks(zzfim);
                zzfim.zzdoj = true;
            }
        }
    }

    public static zzk zzafy() {
        return zzfim;
    }

    private final void zzbe(boolean z) {
        synchronized (zzfim) {
            ArrayList<zzl> arrayList = this.mListeners;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                zzl zzlVar = arrayList.get(i);
                i++;
                zzlVar.zzbe(z);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.zzfin.compareAndSet(true, false);
        this.zzfio.set(true);
        if (compareAndSet) {
            zzbe(false);
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
        boolean compareAndSet = this.zzfin.compareAndSet(true, false);
        this.zzfio.set(true);
        if (compareAndSet) {
            zzbe(false);
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
    public final void onTrimMemory(int i) {
        if (i == 20 && this.zzfin.compareAndSet(false, true)) {
            this.zzfio.set(true);
            zzbe(true);
        }
    }

    public final void zza(zzl zzlVar) {
        synchronized (zzfim) {
            this.mListeners.add(zzlVar);
        }
    }

    public final boolean zzafz() {
        return this.zzfin.get();
    }

    @TargetApi(16)
    public final boolean zzbd(boolean z) {
        if (!this.zzfio.get()) {
            if (!zzp.zzale()) {
                return true;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.zzfio.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.zzfin.set(true);
            }
        }
        return this.zzfin.get();
    }
}

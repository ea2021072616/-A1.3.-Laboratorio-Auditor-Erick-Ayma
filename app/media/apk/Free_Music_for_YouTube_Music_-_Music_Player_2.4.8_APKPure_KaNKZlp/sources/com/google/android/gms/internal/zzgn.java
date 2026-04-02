package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
final class zzgn implements Application.ActivityLifecycleCallbacks {
    private final Application zzawp;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzaxj;
    private boolean zzaxk = false;

    public zzgn(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzaxj = new WeakReference<>(activityLifecycleCallbacks);
        this.zzawp = application;
    }

    private final void zza(zzgv zzgvVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzaxj.get();
            if (activityLifecycleCallbacks != null) {
                zzgvVar.zza(activityLifecycleCallbacks);
            } else if (!this.zzaxk) {
                this.zzawp.unregisterActivityLifecycleCallbacks(this);
                this.zzaxk = true;
            }
        } catch (Exception e) {
            zzafx.zzb("Error while dispatching lifecycle callback.", e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzgo(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zza(new zzgu(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(new zzgr(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(new zzgq(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzgt(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(new zzgp(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zza(new zzgs(this, activity));
    }
}

package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzha implements Application.ActivityLifecycleCallbacks {
    @Nullable
    private Activity mActivity;
    private Context mContext;
    private Runnable zzayk;
    private long zzayl;
    private final Object mLock = new Object();
    private boolean zzayg = true;
    private boolean zzayh = false;
    private final List<zzhc> zzayi = new ArrayList();
    private final List<zzhp> zzayj = new ArrayList();
    private boolean zzaqo = false;

    private final void setActivity(Activity activity) {
        synchronized (this.mLock) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.mActivity = activity;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zza(zzha zzhaVar, boolean z) {
        zzhaVar.zzayg = false;
        return false;
    }

    @Nullable
    public final Activity getActivity() {
        return this.mActivity;
    }

    @Nullable
    public final Context getContext() {
        return this.mContext;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.mLock) {
            if (this.mActivity == null) {
                return;
            }
            if (this.mActivity.equals(activity)) {
                this.mActivity = null;
            }
            Iterator<zzhp> it = this.zzayj.iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().zza(activity)) {
                        it.remove();
                    }
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    zzafx.zzb("onActivityStateChangedListener threw exception.", e);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.mLock) {
            Iterator<zzhp> it = this.zzayj.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        this.zzayh = true;
        if (this.zzayk != null) {
            zzahf.zzdbo.removeCallbacks(this.zzayk);
        }
        Handler handler = zzahf.zzdbo;
        zzhb zzhbVar = new zzhb(this);
        this.zzayk = zzhbVar;
        handler.postDelayed(zzhbVar, this.zzayl);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzayh = false;
        boolean z = this.zzayg ? false : true;
        this.zzayg = true;
        if (this.zzayk != null) {
            zzahf.zzdbo.removeCallbacks(this.zzayk);
        }
        synchronized (this.mLock) {
            Iterator<zzhp> it = this.zzayj.iterator();
            while (it.hasNext()) {
                it.next();
            }
            if (z) {
                for (zzhc zzhcVar : this.zzayi) {
                    try {
                        zzhcVar.zzg(true);
                    } catch (Exception e) {
                        zzafx.zzb("OnForegroundStateChangedListener threw exception.", e);
                    }
                }
            } else {
                zzafx.zzcb("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (this.zzaqo) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            setActivity((Activity) context);
        }
        this.mContext = context;
        this.zzayl = ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjm)).longValue();
        this.zzaqo = true;
    }

    public final void zza(zzhc zzhcVar) {
        synchronized (this.mLock) {
            this.zzayi.add(zzhcVar);
        }
    }
}

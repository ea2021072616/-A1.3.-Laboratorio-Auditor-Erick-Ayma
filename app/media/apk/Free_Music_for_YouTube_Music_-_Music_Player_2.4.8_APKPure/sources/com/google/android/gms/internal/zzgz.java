package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
@zzzt
/* loaded from: classes.dex */
public final class zzgz {
    private final Object zzayd = new Object();
    private zzha zzaye = null;
    private boolean zzayf = false;

    @Nullable
    public final Activity getActivity() {
        Activity activity;
        synchronized (this.zzayd) {
            activity = this.zzaye != null ? this.zzaye.getActivity() : null;
        }
        return activity;
    }

    @Nullable
    public final Context getContext() {
        Context context;
        synchronized (this.zzayd) {
            context = this.zzaye != null ? this.zzaye.getContext() : null;
        }
        return context;
    }

    public final void initialize(Context context) {
        synchronized (this.zzayd) {
            if (!this.zzayf) {
                if (!((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjl)).booleanValue()) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzafx.zzcs("Can not cast Context to Application");
                    return;
                }
                if (this.zzaye == null) {
                    this.zzaye = new zzha();
                }
                this.zzaye.zza(application, context);
                this.zzayf = true;
            }
        }
    }

    public final void zza(zzhc zzhcVar) {
        synchronized (this.zzayd) {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjl)).booleanValue()) {
                if (this.zzaye == null) {
                    this.zzaye = new zzha();
                }
                this.zzaye.zza(zzhcVar);
            }
        }
    }
}

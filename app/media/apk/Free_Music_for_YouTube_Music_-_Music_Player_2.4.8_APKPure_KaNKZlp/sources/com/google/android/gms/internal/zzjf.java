package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import com.facebook.internal.NativeProtocol;
@zzzt
/* loaded from: classes.dex */
public class zzjf {
    private final Object mLock = new Object();
    private zzkn zzbcx;
    private final zziw zzbcy;
    private final zziv zzbcz;
    private final zzlo zzbda;
    private final zzqm zzbdb;
    private final zzadn zzbdc;
    private final zzxf zzbdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public abstract class zza<T> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public zza() {
        }

        @Nullable
        protected abstract T zza(zzkn zzknVar) throws RemoteException;

        @Nullable
        protected abstract T zzhq() throws RemoteException;

        @Nullable
        protected final T zzhr() {
            zzkn zzhp = zzjf.this.zzhp();
            if (zzhp == null) {
                zzaji.zzcs("ClientApi class cannot be loaded.");
                return null;
            }
            try {
                return zza(zzhp);
            } catch (RemoteException e) {
                zzaji.zzc("Cannot invoke local loader using ClientApi class", e);
                return null;
            }
        }

        @Nullable
        protected final T zzhs() {
            try {
                return zzhq();
            } catch (RemoteException e) {
                zzaji.zzc("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    public zzjf(zziw zziwVar, zziv zzivVar, zzlo zzloVar, zzqm zzqmVar, zzadn zzadnVar, zzxf zzxfVar) {
        this.zzbcy = zziwVar;
        this.zzbcz = zzivVar;
        this.zzbda = zzloVar;
        this.zzbdb = zzqmVar;
        this.zzbdc = zzadnVar;
        this.zzbdd = zzxfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static <T> T zza(Context context, boolean z, zza<T> zzaVar) {
        if (!z) {
            zzjo.zzhu();
            if (!zzaje.zzba(context)) {
                zzaji.zzcb("Google Play Services is not available");
                z = true;
            }
        }
        zzjo.zzhu();
        int zzat = zzaje.zzat(context);
        zzjo.zzhu();
        if (zzat <= zzaje.zzas(context) ? z : true) {
            T zzhr = zzaVar.zzhr();
            return zzhr == null ? zzaVar.zzhs() : zzhr;
        }
        T zzhs = zzaVar.zzhs();
        return zzhs == null ? zzaVar.zzhr() : zzhs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "no_ads_fallback");
        bundle.putString("flow", str);
        zzjo.zzhu().zza(context, (String) null, "gmob-apps", bundle, true);
    }

    @Nullable
    private static zzkn zzho() {
        zzkn asInterface;
        try {
            Object newInstance = zzjf.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                asInterface = zzko.asInterface((IBinder) newInstance);
            } else {
                zzaji.zzcs("ClientApi class is not an instance of IBinder");
                asInterface = null;
            }
            return asInterface;
        } catch (Exception e) {
            zzaji.zzc("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final zzkn zzhp() {
        zzkn zzknVar;
        synchronized (this.mLock) {
            if (this.zzbcx == null) {
                this.zzbcx = zzho();
            }
            zzknVar = this.zzbcx;
        }
        return zzknVar;
    }

    public final zzpg zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzpg) zza(context, false, (zza<Object>) new zzjl(this, frameLayout, frameLayout2, context));
    }

    public final zzka zzb(Context context, String str, zzva zzvaVar) {
        return (zzka) zza(context, false, (zza<Object>) new zzjj(this, context, str, zzvaVar));
    }

    @Nullable
    public final zzxg zzb(Activity activity) {
        boolean z = false;
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            zzaji.e("useClientJar flag not found in activity intent extras.");
        }
        return (zzxg) zza(activity, z, new zzjn(this, activity));
    }
}

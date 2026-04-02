package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzaz;
import com.google.android.gms.common.internal.zzba;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.dynamite.DynamiteModule;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzf {
    private static zzaz zzfff;
    private static final Object zzffg = new Object();
    private static Context zzffh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(String str, zzg zzgVar) {
        return zza(str, zzgVar, false);
    }

    private static boolean zza(String str, zzg zzgVar, boolean z) {
        if (zzaex()) {
            zzbp.zzu(zzffh);
            try {
                return zzfff.zza(new zzm(str, zzgVar, z), com.google.android.gms.dynamic.zzn.zzw(zzffh.getPackageManager()));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return false;
            }
        }
        return false;
    }

    private static boolean zzaex() {
        boolean z = true;
        if (zzfff == null) {
            zzbp.zzu(zzffh);
            synchronized (zzffg) {
                if (zzfff == null) {
                    try {
                        zzfff = zzba.zzal(DynamiteModule.zza(zzffh, DynamiteModule.zzgpi, "com.google.android.gms.googlecertificates").zzgv("com.google.android.gms.common.GoogleCertificatesImpl"));
                    } catch (DynamiteModule.zzc e) {
                        Log.e("GoogleCertificates", "Failed to load com.google.android.gms.googlecertificates", e);
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb(String str, zzg zzgVar) {
        return zza(str, zzgVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzby(Context context) {
        synchronized (zzf.class) {
            if (zzffh != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzffh = context.getApplicationContext();
            }
        }
    }
}

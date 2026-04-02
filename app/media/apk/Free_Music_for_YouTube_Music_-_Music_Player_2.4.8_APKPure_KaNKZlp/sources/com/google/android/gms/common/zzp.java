package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzbdp;
/* loaded from: classes.dex */
public class zzp {
    private static zzp zzffw;
    private final Context mContext;

    private zzp(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzg zza(PackageInfo packageInfo, zzg... zzgVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzh zzhVar = new zzh(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzgVarArr.length; i++) {
            if (zzgVarArr[i].equals(zzhVar)) {
                return zzgVarArr[i];
            }
        }
        return null;
    }

    private static boolean zza(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? zza(packageInfo, zzj.zzffm) : zza(packageInfo, zzj.zzffm[0])) != null) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzb(PackageInfo packageInfo, boolean z) {
        boolean z2 = false;
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
        } else {
            zzh zzhVar = new zzh(packageInfo.signatures[0].toByteArray());
            String str = packageInfo.packageName;
            z2 = z ? zzf.zzb(str, zzhVar) : zzf.zza(str, zzhVar);
            if (!z2) {
                Log.d("GoogleSignatureVerifier", new StringBuilder(27).append("Cert not in list. atk=").append(z).toString());
            }
        }
        return z2;
    }

    public static zzp zzca(Context context) {
        zzbp.zzu(context);
        synchronized (zzp.class) {
            if (zzffw == null) {
                zzf.zzby(context);
                zzffw = new zzp(context);
            }
        }
        return zzffw;
    }

    private final boolean zzfr(String str) {
        try {
            PackageInfo packageInfo = zzbdp.zzcs(this.mContext).getPackageInfo(str, 64);
            if (packageInfo == null) {
                return false;
            }
            if (zzo.zzbz(this.mContext)) {
                return zzb(packageInfo, true);
            }
            boolean zzb = zzb(packageInfo, false);
            if (!zzb && zzb(packageInfo, true)) {
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
            return zzb;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @Deprecated
    public final boolean zza(PackageManager packageManager, int i) {
        String[] packagesForUid = zzbdp.zzcs(this.mContext).getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            return false;
        }
        for (String str : packagesForUid) {
            if (zzfr(str)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public final boolean zza(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo != null) {
            if (zza(packageInfo, false)) {
                return true;
            }
            if (zza(packageInfo, true)) {
                if (zzo.zzbz(this.mContext)) {
                    return true;
                }
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
        }
        return false;
    }
}

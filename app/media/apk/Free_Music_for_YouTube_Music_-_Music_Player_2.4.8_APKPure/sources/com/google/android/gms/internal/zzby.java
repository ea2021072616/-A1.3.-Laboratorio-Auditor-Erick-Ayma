package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzby {
    static zzdgg zzyu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzy() {
        if (zzyu != null) {
            return true;
        }
        String str = (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzblz);
        if (str.length() == 0) {
            return false;
        }
        try {
            try {
                zzdgi zzae = zzdgm.zzae(zzbt.zza(str, true));
                zzdhk.zzbnc();
                zzyu = zzdhk.zza(zzae);
                return zzyu != null;
            } catch (GeneralSecurityException e) {
                return false;
            }
        } catch (IllegalArgumentException e2) {
            return false;
        }
    }
}

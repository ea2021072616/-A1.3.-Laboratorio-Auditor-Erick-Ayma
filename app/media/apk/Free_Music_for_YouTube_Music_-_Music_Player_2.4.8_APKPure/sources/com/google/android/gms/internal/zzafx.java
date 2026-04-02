package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;
@zzzt
/* loaded from: classes.dex */
public final class zzafx extends zzaji {
    public static void v(String str) {
        if (zzqr()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzqr() {
        if (zzad(2)) {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkr)).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}

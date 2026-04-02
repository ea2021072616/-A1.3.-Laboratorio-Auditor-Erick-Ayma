package com.google.android.gms.internal;

import android.annotation.TargetApi;
@zzzt
@TargetApi(17)
/* loaded from: classes.dex */
public final class zzaja {
    private static zzaja zzddu = null;
    String zzbwh;

    private zzaja() {
    }

    public static zzaja zzrk() {
        if (zzddu == null) {
            zzddu = new zzaja();
        }
        return zzddu;
    }
}

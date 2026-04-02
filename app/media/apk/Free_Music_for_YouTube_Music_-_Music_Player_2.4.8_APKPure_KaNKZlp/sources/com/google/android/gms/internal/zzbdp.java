package com.google.android.gms.internal;

import android.content.Context;
/* loaded from: classes2.dex */
public final class zzbdp {
    private static zzbdp zzfzn = new zzbdp();
    private zzbdo zzfzm = null;

    private final synchronized zzbdo zzcr(Context context) {
        if (this.zzfzm == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzfzm = new zzbdo(context);
        }
        return this.zzfzm;
    }

    public static zzbdo zzcs(Context context) {
        return zzfzn.zzcr(context);
    }
}

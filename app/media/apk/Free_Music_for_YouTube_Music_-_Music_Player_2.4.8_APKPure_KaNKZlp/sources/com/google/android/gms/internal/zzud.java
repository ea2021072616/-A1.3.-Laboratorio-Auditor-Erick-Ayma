package com.google.android.gms.internal;

import android.content.Context;
@zzzt
/* loaded from: classes.dex */
public final class zzud {
    private final Object mLock = new Object();
    private zzue zzbzw;

    public final zzue zzb(Context context, zzajk zzajkVar) {
        zzue zzueVar;
        synchronized (this.mLock) {
            if (this.zzbzw == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                this.zzbzw = new zzue(context, zzajkVar, (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbfv));
            }
            zzueVar = this.zzbzw;
        }
        return zzueVar;
    }
}

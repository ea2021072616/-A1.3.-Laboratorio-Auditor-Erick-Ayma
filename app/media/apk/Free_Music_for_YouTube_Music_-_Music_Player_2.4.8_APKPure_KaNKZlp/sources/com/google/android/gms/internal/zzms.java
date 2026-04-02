package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayerFactory;
@zzzt
/* loaded from: classes.dex */
public final class zzms {
    private final Object mLock = new Object();
    private final ConditionVariable zzbfq = new ConditionVariable();
    private volatile boolean zzaqo = false;
    @Nullable
    private SharedPreferences zzbfr = null;

    public final void initialize(Context context) {
        if (this.zzaqo) {
            return;
        }
        synchronized (this.mLock) {
            if (this.zzaqo) {
                return;
            }
            Context remoteContext = com.google.android.gms.common.zzo.getRemoteContext(context);
            if (remoteContext != null || context == null) {
                context = remoteContext;
            } else {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
            }
            if (context == null) {
                this.zzbfq.open();
                return;
            }
            com.google.android.gms.ads.internal.zzbv.zzel();
            this.zzbfr = context.getSharedPreferences("google_ads_flags", 0);
            this.zzaqo = true;
            this.zzbfq.open();
        }
    }

    public final <T> T zzd(zzmk<T> zzmkVar) {
        if (this.zzbfq.block(ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS)) {
            if (!this.zzaqo || this.zzbfr == null) {
                synchronized (this.mLock) {
                    if (!this.zzaqo || this.zzbfr == null) {
                        return zzmkVar.zzik();
                    }
                }
            }
            return (T) zzaiz.zza(new zzmt(this, zzmkVar));
        }
        throw new IllegalStateException("Flags.initialize() was not called!");
    }
}

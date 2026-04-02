package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzzt;
import java.util.concurrent.TimeUnit;
@zzzt
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzak {
    private long zzcic;
    private final long zzcib = TimeUnit.MILLISECONDS.toNanos(((Long) zzbv.zzen().zzd(zzmu.zzbgv)).longValue());
    private boolean zzcid = true;

    public final void zza(SurfaceTexture surfaceTexture, zzx zzxVar) {
        if (zzxVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.zzcid || Math.abs(timestamp - this.zzcic) >= this.zzcib) {
            this.zzcid = false;
            this.zzcic = timestamp;
            zzahf.zzdbo.post(new zzal(this, zzxVar));
        }
    }

    public final void zzmx() {
        this.zzcid = true;
    }
}

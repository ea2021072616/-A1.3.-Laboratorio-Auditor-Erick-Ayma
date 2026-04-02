package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzbvq implements com.google.android.gms.common.internal.zzf, com.google.android.gms.common.internal.zzg {
    private final String packageName;
    private zzbvr zzhpx;
    private final String zzhpy;
    private final LinkedBlockingQueue<zzax> zzhpz;
    private final HandlerThread zzhqa = new HandlerThread("GassClient");

    public zzbvq(Context context, String str, String str2) {
        this.packageName = str;
        this.zzhpy = str2;
        this.zzhqa.start();
        this.zzhpx = new zzbvr(context, this.zzhqa.getLooper(), this, this);
        this.zzhpz = new LinkedBlockingQueue<>();
        this.zzhpx.zzajf();
    }

    private final zzbvw zzasa() {
        try {
            return this.zzhpx.zzasc();
        } catch (DeadObjectException | IllegalStateException e) {
            return null;
        }
    }

    private static zzax zzasb() {
        zzax zzaxVar = new zzax();
        zzaxVar.zzdq = 32768L;
        return zzaxVar;
    }

    private final void zzod() {
        if (this.zzhpx != null) {
            if (this.zzhpx.isConnected() || this.zzhpx.isConnecting()) {
                this.zzhpx.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnected(Bundle bundle) {
        zzbvw zzasa = zzasa();
        if (zzasa != null) {
            try {
                this.zzhpz.put(zzasa.zza(new zzbvs(this.packageName, this.zzhpy)).zzasd());
                zzod();
                this.zzhqa.quit();
            } catch (Throwable th) {
                try {
                    this.zzhpz.put(zzasb());
                } catch (InterruptedException e) {
                } catch (Throwable th2) {
                    zzod();
                    this.zzhqa.quit();
                    throw th2;
                }
                zzod();
                this.zzhqa.quit();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzg
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzhpz.put(zzasb());
        } catch (InterruptedException e) {
        }
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnectionSuspended(int i) {
        try {
            this.zzhpz.put(zzasb());
        } catch (InterruptedException e) {
        }
    }

    public final zzax zzdh(int i) {
        zzax zzaxVar;
        try {
            zzaxVar = this.zzhpz.poll(ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzaxVar = null;
        }
        return zzaxVar == null ? zzasb() : zzaxVar;
    }
}

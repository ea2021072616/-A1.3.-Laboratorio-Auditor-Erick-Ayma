package com.google.android.gms.ads.internal;

import android.os.Debug;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzmu;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzb extends TimerTask {
    private /* synthetic */ CountDownLatch zzamw;
    private /* synthetic */ Timer zzamx;
    private /* synthetic */ zza zzamy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zza zzaVar, CountDownLatch countDownLatch, Timer timer) {
        this.zzamy = zzaVar;
        this.zzamw = countDownLatch;
        this.zzamx = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (((Integer) zzbv.zzen().zzd(zzmu.zzbni)).intValue() != this.zzamw.getCount()) {
            zzafx.zzcb("Stopping method tracing");
            Debug.stopMethodTracing();
            if (this.zzamw.getCount() == 0) {
                this.zzamx.cancel();
                return;
            }
        }
        String concat = String.valueOf(this.zzamy.zzams.zzaie.getPackageName()).concat("_adsTrace_");
        try {
            zzafx.zzcb("Starting method tracing");
            this.zzamw.countDown();
            Debug.startMethodTracing(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append(zzbv.zzeg().currentTimeMillis()).toString(), ((Integer) zzbv.zzen().zzd(zzmu.zzbnj)).intValue());
        } catch (Exception e) {
            zzafx.zzc("Exception occurred while starting method tracing.", e);
        }
    }
}

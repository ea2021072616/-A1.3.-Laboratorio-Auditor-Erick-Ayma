package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes2.dex */
public final class zzd extends Thread {
    private static final boolean DEBUG = zzab.DEBUG;
    private final BlockingQueue<zzp<?>> zzg;
    private final BlockingQueue<zzp<?>> zzh;
    private final zzb zzi;
    private final zzw zzj;
    private volatile boolean zzk = false;

    public zzd(BlockingQueue<zzp<?>> blockingQueue, BlockingQueue<zzp<?>> blockingQueue2, zzb zzbVar, zzw zzwVar) {
        this.zzg = blockingQueue;
        this.zzh = blockingQueue2;
        this.zzi = zzbVar;
        this.zzj = zzwVar;
    }

    public final void quit() {
        this.zzk = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (DEBUG) {
            zzab.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzi.initialize();
        while (true) {
            try {
                zzp<?> take = this.zzg.take();
                take.zzb("cache-queue-take");
                zzc zza = this.zzi.zza(take.getUrl());
                if (zza == null) {
                    take.zzb("cache-miss");
                    this.zzh.put(take);
                } else {
                    if (zza.zzd < System.currentTimeMillis()) {
                        take.zzb("cache-hit-expired");
                        take.zza(zza);
                        this.zzh.put(take);
                    } else {
                        take.zzb("cache-hit");
                        zzt<?> zza2 = take.zza(new zzn(zza.data, zza.zzf));
                        take.zzb("cache-hit-parsed");
                        if (zza.zze < System.currentTimeMillis()) {
                            take.zzb("cache-hit-refresh-needed");
                            take.zza(zza);
                            zza2.zzbg = true;
                            this.zzj.zza(take, zza2, new zze(this, take));
                        } else {
                            this.zzj.zza(take, zza2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.zzk) {
                    return;
                }
            }
        }
    }
}

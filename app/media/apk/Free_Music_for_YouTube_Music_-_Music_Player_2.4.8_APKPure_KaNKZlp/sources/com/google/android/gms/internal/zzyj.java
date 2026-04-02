package com.google.android.gms.internal;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
final class zzyj implements Runnable {
    private /* synthetic */ CountDownLatch zzamw;
    private /* synthetic */ zzyi zzcky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyj(zzyi zzyiVar, CountDownLatch countDownLatch) {
        this.zzcky = zzyiVar;
        this.zzamw = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzakk zzakkVar;
        synchronized (this.zzcky.zzckm) {
            zzyi zzyiVar = this.zzcky;
            zzakkVar = this.zzcky.zzbvz;
            zzyiVar.zzckx = com.google.android.gms.ads.internal.zzas.zza(zzakkVar, this.zzcky.zzckw, this.zzamw);
        }
    }
}

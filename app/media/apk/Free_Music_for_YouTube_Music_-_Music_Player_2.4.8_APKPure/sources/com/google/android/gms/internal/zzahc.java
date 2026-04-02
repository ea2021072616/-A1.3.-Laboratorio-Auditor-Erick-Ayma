package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahc implements Runnable {
    private /* synthetic */ zzajx zzdbk;
    private /* synthetic */ Callable zzdbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahc(zzajx zzajxVar, Callable callable) {
        this.zzdbk = zzajxVar;
        this.zzdbl = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Process.setThreadPriority(10);
            this.zzdbk.set(this.zzdbl.call());
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "AdThreadPool.submit");
            this.zzdbk.setException(e);
        }
    }
}

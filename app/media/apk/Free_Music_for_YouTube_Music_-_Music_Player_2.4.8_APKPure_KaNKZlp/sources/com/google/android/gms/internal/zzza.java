package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzza implements Runnable {
    private /* synthetic */ AtomicInteger zzcmp;
    private /* synthetic */ int zzcmq;
    private /* synthetic */ zzajx zzcmr;
    private /* synthetic */ List zzcms;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzza(AtomicInteger atomicInteger, int i, zzajx zzajxVar, List list) {
        this.zzcmp = atomicInteger;
        this.zzcmq = i;
        this.zzcmr = zzajxVar;
        this.zzcms = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List zzl;
        if (this.zzcmp.incrementAndGet() >= this.zzcmq) {
            try {
                zzajx zzajxVar = this.zzcmr;
                zzl = zzys.zzl(this.zzcms);
                zzajxVar.set(zzl);
            } catch (InterruptedException | ExecutionException e) {
                zzafx.zzc("Unable to convert list of futures to a future of list", e);
            }
        }
    }
}

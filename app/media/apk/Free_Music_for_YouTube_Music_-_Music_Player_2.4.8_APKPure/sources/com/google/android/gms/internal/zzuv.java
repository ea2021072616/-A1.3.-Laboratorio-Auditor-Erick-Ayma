package com.google.android.gms.internal;

import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
final class zzuv implements Callable<zzur> {
    private /* synthetic */ zzuo zzccn;
    private /* synthetic */ zzuu zzcco;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuv(zzuu zzuuVar, zzuo zzuoVar) {
        this.zzcco = zzuuVar;
        this.zzccn = zzuoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: zzlr */
    public final zzur call() throws Exception {
        Object obj;
        boolean z;
        long j;
        long j2;
        obj = this.zzcco.mLock;
        synchronized (obj) {
            z = this.zzcco.zzccj;
            if (z) {
                return null;
            }
            zzuo zzuoVar = this.zzccn;
            j = this.zzcco.mStartTime;
            j2 = this.zzcco.zzcch;
            return zzuoVar.zza(j, j2);
        }
    }
}

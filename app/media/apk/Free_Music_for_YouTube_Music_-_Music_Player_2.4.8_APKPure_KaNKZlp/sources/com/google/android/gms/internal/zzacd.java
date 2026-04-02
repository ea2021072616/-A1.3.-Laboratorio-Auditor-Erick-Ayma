package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzacd implements zzrn {
    private /* synthetic */ zzaca zzcsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacd(zzaca zzacaVar) {
        this.zzcsr = zzacaVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        Object obj;
        zzajx zzajxVar;
        String str;
        zzajx zzajxVar2;
        obj = this.zzcsr.mLock;
        synchronized (obj) {
            zzajxVar = this.zzcsr.zzcsm;
            if (zzajxVar.isDone()) {
                return;
            }
            zzacg zzacgVar = new zzacg(-2, map);
            str = this.zzcsr.zzcjq;
            if (str.equals(zzacgVar.getRequestId())) {
                zzajxVar2 = this.zzcsr.zzcsm;
                zzajxVar2.set(zzacgVar);
            }
        }
    }
}

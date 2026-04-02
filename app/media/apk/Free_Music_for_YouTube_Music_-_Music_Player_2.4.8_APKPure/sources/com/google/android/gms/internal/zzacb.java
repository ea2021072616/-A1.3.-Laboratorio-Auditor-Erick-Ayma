package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzacb implements zzrn {
    private /* synthetic */ zzaca zzcsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacb(zzaca zzacaVar) {
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
            str = this.zzcsr.zzcjq;
            if (str.equals(map.get("request_id"))) {
                zzacg zzacgVar = new zzacg(1, map);
                String type = zzacgVar.getType();
                String valueOf = String.valueOf(zzacgVar.zzok());
                zzafx.zzcs(new StringBuilder(String.valueOf(type).length() + 24 + String.valueOf(valueOf).length()).append("Invalid ").append(type).append(" request error: ").append(valueOf).toString());
                zzajxVar2 = this.zzcsr.zzcsm;
                zzajxVar2.set(zzacgVar);
            }
        }
    }
}

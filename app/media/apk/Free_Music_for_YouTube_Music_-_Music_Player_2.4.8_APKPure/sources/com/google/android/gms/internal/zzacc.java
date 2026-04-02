package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzacc implements zzrn {
    private /* synthetic */ zzaca zzcsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacc(zzaca zzacaVar) {
        this.zzcsr = zzacaVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        Object obj;
        zzajx zzajxVar;
        String str;
        zzajx zzajxVar2;
        String str2;
        obj = this.zzcsr.mLock;
        synchronized (obj) {
            zzajxVar = this.zzcsr.zzcsm;
            if (zzajxVar.isDone()) {
                return;
            }
            zzacg zzacgVar = new zzacg(-2, map);
            str = this.zzcsr.zzcjq;
            if (str.equals(zzacgVar.getRequestId())) {
                String url = zzacgVar.getUrl();
                if (url == null) {
                    zzafx.zzcs("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (url.contains("%40mediation_adapters%40")) {
                    str2 = this.zzcsr.zzcsl;
                    String replaceAll = url.replaceAll("%40mediation_adapters%40", zzafu.zzb(zzakkVar.getContext(), map.get("check_adapters"), str2));
                    zzacgVar.setUrl(replaceAll);
                    String valueOf = String.valueOf(replaceAll);
                    zzafx.v(valueOf.length() != 0 ? "Ad request URL modified to ".concat(valueOf) : new String("Ad request URL modified to "));
                }
                zzajxVar2 = this.zzcsr.zzcsm;
                zzajxVar2.set(zzacgVar);
            }
        }
    }
}

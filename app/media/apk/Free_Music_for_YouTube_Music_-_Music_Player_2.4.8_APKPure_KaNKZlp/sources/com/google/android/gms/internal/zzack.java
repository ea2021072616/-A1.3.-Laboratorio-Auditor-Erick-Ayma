package com.google.android.gms.internal;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzack implements Callable<zzach> {
    private /* synthetic */ Context zzaok;
    private /* synthetic */ zzacj zzcve;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzack(zzacj zzacjVar, Context context) {
        this.zzcve = zzacjVar;
        this.zzaok = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzach call() throws Exception {
        WeakHashMap weakHashMap;
        zzach zzop;
        WeakHashMap weakHashMap2;
        weakHashMap = this.zzcve.zzcvd;
        zzacl zzaclVar = (zzacl) weakHashMap.get(this.zzaok);
        if (zzaclVar != null) {
            if (!(zzaclVar.zzcvf + ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkw)).longValue() < com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis())) {
                if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkv)).booleanValue()) {
                    zzop = new zzaci(this.zzaok, zzaclVar.zzcvg).zzop();
                    weakHashMap2 = this.zzcve.zzcvd;
                    weakHashMap2.put(this.zzaok, new zzacl(this.zzcve, zzop));
                    return zzop;
                }
            }
        }
        zzop = new zzaci(this.zzaok).zzop();
        weakHashMap2 = this.zzcve.zzcvd;
        weakHashMap2.put(this.zzaok, new zzacl(this.zzcve, zzop));
        return zzop;
    }
}

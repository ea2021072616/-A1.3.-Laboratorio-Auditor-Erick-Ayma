package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzuw implements Runnable {
    private /* synthetic */ zzuu zzcco;
    private /* synthetic */ zzajr zzccp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuw(zzuu zzuuVar, zzajr zzajrVar) {
        this.zzcco = zzuuVar;
        this.zzccp = zzajrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        Map map2;
        map = this.zzcco.zzcck;
        for (zzajr zzajrVar : map.keySet()) {
            if (zzajrVar != this.zzccp) {
                map2 = this.zzcco.zzcck;
                ((zzuo) map2.get(zzajrVar)).cancel();
            }
        }
    }
}

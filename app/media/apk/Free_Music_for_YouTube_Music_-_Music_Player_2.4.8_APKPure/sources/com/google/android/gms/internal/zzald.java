package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzald implements Runnable {
    private /* synthetic */ Map zzamc;
    private /* synthetic */ zzalc zzdib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzald(zzalc zzalcVar, Map map) {
        this.zzdib = zzalcVar;
        this.zzamc = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzakk zzakkVar;
        zzakkVar = this.zzdib.zzbvz;
        zzakkVar.zza("pubVideoCmd", this.zzamc);
    }
}

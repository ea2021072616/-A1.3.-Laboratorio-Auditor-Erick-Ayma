package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzyv implements Runnable {
    private /* synthetic */ zzys zzcly;
    private /* synthetic */ zzajx zzcma;
    private /* synthetic */ String zzcmb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyv(zzys zzysVar, zzajx zzajxVar, String str) {
        this.zzcly = zzysVar;
        this.zzcma = zzajxVar;
        this.zzcmb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzbc zzbcVar;
        zzajx zzajxVar = this.zzcma;
        zzbcVar = this.zzcly.zzclp;
        zzajxVar.set(zzbcVar.zzdm().get(this.zzcmb));
    }
}

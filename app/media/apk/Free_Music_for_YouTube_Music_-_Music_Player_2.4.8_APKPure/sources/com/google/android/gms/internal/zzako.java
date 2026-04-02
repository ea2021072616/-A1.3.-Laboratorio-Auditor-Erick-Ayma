package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzako implements Runnable {
    private /* synthetic */ zzakl zzdgj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzako(zzakl zzaklVar) {
        this.zzdgj = zzaklVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzakr zzakrVar;
        zzakr zzakrVar2;
        this.zzdgj.zzbvz.zzso();
        com.google.android.gms.ads.internal.overlay.zzm zzrz = this.zzdgj.zzbvz.zzrz();
        if (zzrz != null) {
            zzrz.zzmo();
        }
        zzakrVar = this.zzdgj.zzdft;
        if (zzakrVar != null) {
            zzakrVar2 = this.zzdgj.zzdft;
            zzakrVar2.zzcs();
            zzakl.zza(this.zzdgj, (zzakr) null);
        }
    }
}

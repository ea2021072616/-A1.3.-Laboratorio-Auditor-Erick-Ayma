package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzahf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzn implements zzb {
    final /* synthetic */ zza zzbzb;
    final /* synthetic */ zzm zzbzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(zzm zzmVar, zza zzaVar) {
        this.zzbzc = zzmVar;
        this.zzbzb = zzaVar;
    }

    @Override // com.google.android.gms.ads.internal.js.zzb
    public final void zzlb() {
        zzahf.zzdbo.postDelayed(new zzo(this), zzw.zzbzj);
    }
}

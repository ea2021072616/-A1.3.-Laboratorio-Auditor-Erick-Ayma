package com.google.android.gms.internal;

import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzos extends zzyr {
    private /* synthetic */ zzom zzbsz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzos(zzom zzomVar) {
        this.zzbsz = zzomVar;
    }

    @Override // com.google.android.gms.internal.zzyr
    public final void zzd(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        WeakReference weakReference;
        zzrn zze;
        zzrn zzf;
        zzrn zzg;
        zzrn zzh;
        weakReference = this.zzbsz.zzbsw;
        zzakk zzakkVar = (zzakk) weakReference.get();
        if (zzakkVar == null) {
            return;
        }
        zze = this.zzbsz.zze(zzaiVar);
        zzaiVar.zza("/loadHtml", zze);
        zzf = this.zzbsz.zzf(zzaiVar);
        zzaiVar.zza("/showOverlay", zzf);
        zzg = this.zzbsz.zzg(zzaiVar);
        zzaiVar.zza("/hideOverlay", zzg);
        zzakl zzsb = zzakkVar.zzsb();
        zzh = this.zzbsz.zzh(zzaiVar);
        zzsb.zza("/sendMessageToSdk", zzh);
    }
}

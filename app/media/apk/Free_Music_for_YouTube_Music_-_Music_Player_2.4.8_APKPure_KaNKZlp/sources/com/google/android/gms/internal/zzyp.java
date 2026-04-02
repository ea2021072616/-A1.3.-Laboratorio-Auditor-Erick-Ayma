package com.google.android.gms.internal;

import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzyp implements zzaif<com.google.android.gms.ads.internal.js.zza> {
    private /* synthetic */ zzym zzclm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyp(zzym zzymVar) {
        this.zzclm = zzymVar;
    }

    @Override // com.google.android.gms.internal.zzaif
    public final /* synthetic */ void zzc(com.google.android.gms.ads.internal.js.zza zzaVar) {
        com.google.android.gms.ads.internal.zzbc zzbcVar;
        zzbcVar = this.zzclm.zzclf;
        com.google.android.gms.ads.internal.zzbc zzbcVar2 = (com.google.android.gms.ads.internal.zzbc) new WeakReference(zzbcVar).get();
        zzaVar.zza(zzbcVar2, zzbcVar2, zzbcVar2, zzbcVar2, false, null, null, null);
    }
}

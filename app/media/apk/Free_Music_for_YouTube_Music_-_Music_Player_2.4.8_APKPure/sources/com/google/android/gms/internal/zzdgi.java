package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdgq;
/* loaded from: classes2.dex */
public final class zzdgi {
    private final zzdgq.zzc zzkzz;
    private final byte[] zzlaa = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgi(zzdgq.zzc zzcVar) {
        this.zzkzz = zzcVar;
    }

    public final String toString() {
        zzdgq.zzc zzcVar = this.zzkzz;
        zzdgq.zzd.zza zzfj = zzdgq.zzd.zzbmx().zzfj(zzcVar.zzbmm());
        for (zzdgq.zzc.zzb zzbVar : zzcVar.zzbmn()) {
            zzfj.zzb(zzdgq.zzd.zzb.zzbmz().zznx(zzbVar.zzbmr().zzbme()).zzb(zzbVar.zzbms()).zzb(zzbVar.zzbmu()).zzfl(zzbVar.zzbmt()).zzccr());
        }
        return zzfj.zzccr().toString();
    }

    public final zzdgq.zzc zzbls() {
        return this.zzkzz;
    }
}

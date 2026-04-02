package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdgj;
import com.google.android.gms.internal.zzdgq;
import java.security.GeneralSecurityException;
/* loaded from: classes2.dex */
final class zzdhf implements zzdgh<zzdfl, zzdgj.zza, zzdgj.zzb> {
    /* renamed from: zza  reason: avoid collision after fix types in other method */
    private static zzdfl zza2(zzdgj.zza zzaVar) throws GeneralSecurityException {
        zzdik.zzp(zzaVar.getVersion(), 0);
        return new zzdhe(zzaVar.zzblt().zzbly(), (zzdfl) zzdgp.zzlam.zza(zzaVar.zzblt().zzblx()));
    }

    private static zzdgj.zza zza(zzdgj.zzb zzbVar) throws GeneralSecurityException {
        return zzdgj.zza.zzblu().zzb(zzbVar.zzblt()).zzff(0).zzccr();
    }

    private static zzdgj.zza zzad(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zza(zzdgj.zzb.zzu(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid KmsEnvelopeAead key format", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzx */
    public final zzdfl zzq(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zza2(zzdgj.zza.zzt(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid KMSEnvelopeAead key");
        }
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* bridge */ /* synthetic */ zzdfl zza(zzdgj.zza zzaVar) throws GeneralSecurityException {
        return zza2(zzaVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* synthetic */ zzdgj.zza zzb(zzdgj.zzb zzbVar) throws GeneralSecurityException {
        return zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* synthetic */ zzdgj.zza zzr(zzedk zzedkVar) throws GeneralSecurityException {
        return zzad(zzedkVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final zzdgq.zza zzs(zzedk zzedkVar) throws GeneralSecurityException {
        return zzdgq.zza.zzbmh().zznw("type.googleapis.com/google.cloud.crypto.tink.KmsEnvelopeAeadKey").zzw(zzad(zzedkVar).zzcbi()).zzb(zzdgq.zza.zzb.REMOTE).zzccr();
    }
}

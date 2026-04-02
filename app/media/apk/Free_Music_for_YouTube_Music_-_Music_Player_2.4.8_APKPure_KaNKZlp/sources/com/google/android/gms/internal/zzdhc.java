package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdfq;
import com.google.android.gms.internal.zzdgq;
import java.security.GeneralSecurityException;
/* loaded from: classes2.dex */
final class zzdhc implements zzdgh<zzdfl, zzdfq.zza, zzdfq.zzb> {
    /* renamed from: zza  reason: avoid collision after fix types in other method */
    private static zzdfl zza2(zzdfq.zza zzaVar) throws GeneralSecurityException {
        zzdik.zzp(zzaVar.getVersion(), 0);
        zzdik.zzfo(zzaVar.zzbjv().size());
        if (zzaVar.zzbke().zzbkb() == 12 || zzaVar.zzbke().zzbkb() == 16) {
            return new zzdhq(zzaVar.zzbjv().toByteArray(), zzaVar.zzbke().zzbkb());
        }
        throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
    }

    private static zzdfq.zza zza(zzdfq.zzb zzbVar) throws GeneralSecurityException {
        zzdik.zzfo(zzbVar.getKeySize());
        if (zzbVar.zzbke().zzbkb() == 12 || zzbVar.zzbke().zzbkb() == 16) {
            return zzdfq.zza.zzbkf().zzh(zzedk.zzaq(zzdij.zzfn(zzbVar.getKeySize()))).zzb(zzbVar.zzbke()).zzez(0).zzccr();
        }
        throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzab */
    public final zzdfq.zza zzr(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zza(zzdfq.zzb.zzi(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid AesEax key format", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzx */
    public final zzdfl zzq(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zza2(zzdfq.zza.zzg(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid AesEax key");
        }
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* bridge */ /* synthetic */ zzdfl zza(zzdfq.zza zzaVar) throws GeneralSecurityException {
        return zza2(zzaVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* synthetic */ zzdfq.zza zzb(zzdfq.zzb zzbVar) throws GeneralSecurityException {
        return zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final zzdgq.zza zzs(zzedk zzedkVar) throws GeneralSecurityException {
        return zzdgq.zza.zzbmh().zznw("type.googleapis.com/google.cloud.crypto.tink.AesEaxKey").zzw(zzr(zzedkVar).zzcbi()).zzb(zzdgq.zza.zzb.SYMMETRIC).zzccr();
    }
}

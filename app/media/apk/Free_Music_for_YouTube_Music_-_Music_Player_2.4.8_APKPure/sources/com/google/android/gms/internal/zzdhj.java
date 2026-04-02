package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdgc;
import com.google.android.gms.internal.zzdgq;
import java.security.GeneralSecurityException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzdhj implements zzdgh<zzdgg, zzdgc.zzc, Object> {
    /* renamed from: zza  reason: avoid collision after fix types in other method */
    private static zzdgg zza2(zzdgc.zzc zzcVar) throws GeneralSecurityException {
        zzdik.zzp(zzcVar.getVersion(), 0);
        zzdgc.zzb zzbkz = zzcVar.zzbkz();
        zzdgx.zza(zzbkz.zzbku().zzbld());
        zzdgx.zza(zzbkz.zzbku().zzble());
        if (zzbkz.zzbkw() == zzdfu.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzdgp.zzlam.zza(zzbkz.zzbkv().zzbkr());
        zzdgc.zzd zzbku = zzcVar.zzbkz().zzbku();
        return new zzdhi(zzdgx.zza(zzbku.zzbld(), zzcVar.zzbla().toByteArray(), zzcVar.zzblb().toByteArray()), zzbku.zzblf().toByteArray(), zzdgx.zza(zzbku.zzble()), zzcVar.zzbkz().zzbkv().zzbkr(), zzcVar.zzbkz().zzbkw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzae */
    public final zzdgg zzq(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zza2(zzdgc.zzc.zzm(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid EciesAeadHkdfPublicKey.");
        }
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* bridge */ /* synthetic */ zzdgg zza(zzdgc.zzc zzcVar) throws GeneralSecurityException {
        return zza2(zzcVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* synthetic */ zzdgc.zzc zzb(Object obj) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* synthetic */ zzdgc.zzc zzr(zzedk zzedkVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final zzdgq.zza zzs(zzedk zzedkVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }
}

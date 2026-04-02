package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdfo;
import com.google.android.gms.internal.zzdgq;
import java.security.GeneralSecurityException;
/* loaded from: classes2.dex */
final class zzdhb implements zzdgh<zzdih, zzdfo.zza, zzdfo.zzb> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zza */
    public final zzdfo.zza zzb(zzdfo.zzb zzbVar) throws GeneralSecurityException {
        zzdik.zzfo(zzbVar.getKeySize());
        zzc(zzbVar.zzbju());
        return zzdfo.zza.zzbjw().zzb(zzbVar.zzbju()).zze(zzedk.zzaq(zzdij.zzfn(zzbVar.getKeySize()))).zzey(0).zzccr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzaa */
    public final zzdfo.zza zzr(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zzb(zzdfo.zzb.zzf(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid AesCtr key format", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzc */
    public final zzdhp zza(zzdfo.zza zzaVar) throws GeneralSecurityException {
        zzdik.zzp(zzaVar.getVersion(), 0);
        zzdik.zzfo(zzaVar.zzbjv().size());
        zzc(zzaVar.zzbju());
        return new zzdhp(zzaVar.zzbjv().toByteArray(), zzaVar.zzbju().zzbkb());
    }

    private static void zzc(zzdfo.zzc zzcVar) throws GeneralSecurityException {
        if (zzcVar.zzbkb() < 12 || zzcVar.zzbkb() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzz */
    public final zzdhp zzq(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zza(zzdfo.zza.zzd(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid AesCtr Key");
        }
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final zzdgq.zza zzs(zzedk zzedkVar) throws GeneralSecurityException {
        return zzdgq.zza.zzbmh().zznw("type.googleapis.com/google.cloud.crypto.tink.AesCtrKey").zzw(zzr(zzedkVar).zzcbi()).zzb(zzdgq.zza.zzb.SYMMETRIC).zzccr();
    }
}

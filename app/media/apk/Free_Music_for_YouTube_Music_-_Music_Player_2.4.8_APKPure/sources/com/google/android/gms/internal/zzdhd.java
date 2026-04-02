package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdfs;
import com.google.android.gms.internal.zzdgq;
import java.security.GeneralSecurityException;
/* loaded from: classes2.dex */
final class zzdhd implements zzdgh<zzdfl, zzdfs.zza, zzdfs.zzb> {
    private static zzdfs.zza zza(zzdfs.zzb zzbVar) throws GeneralSecurityException {
        zzdik.zzfo(zzbVar.getKeySize());
        return zzdfs.zza.zzbkk().zzk(zzedk.zzaq(zzdij.zzfn(zzbVar.getKeySize()))).zzb(zzbVar.zzbkm()).zzfa(0).zzccr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzac */
    public final zzdfs.zza zzr(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zza(zzdfs.zzb.zzl(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid AesGcm key format", e);
        }
    }

    private static zzdfl zzx(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return new zzdhr(zzdfs.zza.zzj(zzedkVar).zzbjv().toByteArray());
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid AesGcm key");
        }
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* synthetic */ zzdfl zza(zzdfs.zza zzaVar) throws GeneralSecurityException {
        zzdfs.zza zzaVar2 = zzaVar;
        zzdik.zzp(zzaVar2.getVersion(), 0);
        zzdik.zzfo(zzaVar2.zzbjv().size());
        return new zzdhr(zzaVar2.zzbjv().toByteArray());
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* synthetic */ zzdfs.zza zzb(zzdfs.zzb zzbVar) throws GeneralSecurityException {
        return zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* synthetic */ zzdfl zzq(zzedk zzedkVar) throws GeneralSecurityException {
        return zzx(zzedkVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final zzdgq.zza zzs(zzedk zzedkVar) throws GeneralSecurityException {
        return zzdgq.zza.zzbmh().zznw("type.googleapis.com/google.cloud.crypto.tink.AesGcmKey").zzw(zzr(zzedkVar).zzcbi()).zzb(zzdgq.zza.zzb.SYMMETRIC).zzccr();
    }
}

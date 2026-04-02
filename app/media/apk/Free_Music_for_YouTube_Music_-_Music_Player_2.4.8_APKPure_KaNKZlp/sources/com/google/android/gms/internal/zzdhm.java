package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdge;
import com.google.android.gms.internal.zzdgq;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
final class zzdhm implements zzdgh<zzdgl, zzdge.zza, zzdge.zzb> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zza */
    public final zzdge.zza zzb(zzdge.zzb zzbVar) throws GeneralSecurityException {
        if (zzbVar.getKeySize() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzc(zzbVar.zzbli());
        return zzdge.zza.zzblj().zzfe(0).zzb(zzbVar.zzbli()).zzo(zzedk.zzaq(zzdij.zzfn(zzbVar.getKeySize()))).zzccr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzaf */
    public final zzdgl zzq(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zza(zzdge.zza.zzn(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid Hmac key");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzag */
    public final zzdge.zza zzr(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zzb(zzdge.zzb.zzp(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid Hmac key format", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzc */
    public final zzdgl zza(zzdge.zza zzaVar) throws GeneralSecurityException {
        zzdik.zzp(zzaVar.getVersion(), 0);
        if (zzaVar.zzbjv().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzc(zzaVar.zzbli());
        zzdfy zzblo = zzaVar.zzbli().zzblo();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzaVar.zzbjv().toByteArray(), "HMAC");
        int zzblp = zzaVar.zzbli().zzblp();
        switch (zzblo) {
            case SHA1:
                return new zzdii("HMACSHA1", secretKeySpec, zzblp);
            case SHA256:
                return new zzdii("HMACSHA256", secretKeySpec, zzblp);
            case SHA512:
                return new zzdii("HMACSHA512", secretKeySpec, zzblp);
            default:
                throw new GeneralSecurityException("unknown hash");
        }
    }

    private static void zzc(zzdge.zzc zzcVar) throws GeneralSecurityException {
        if (zzcVar.zzblp() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        switch (zzcVar.zzblo()) {
            case SHA1:
                if (zzcVar.zzblp() > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case SHA256:
                if (zzcVar.zzblp() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case SHA512:
                if (zzcVar.zzblp() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            default:
                throw new GeneralSecurityException("unknown hash type");
        }
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final zzdgq.zza zzs(zzedk zzedkVar) throws GeneralSecurityException {
        return zzdgq.zza.zzbmh().zznw("type.googleapis.com/google.cloud.crypto.tink.HmacKey").zzw(zzr(zzedkVar).zzcbi()).zzb(zzdgq.zza.zzb.SYMMETRIC).zzccr();
    }
}

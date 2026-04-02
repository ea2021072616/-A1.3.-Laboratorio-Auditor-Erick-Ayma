package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdfm;
import com.google.android.gms.internal.zzdfo;
import com.google.android.gms.internal.zzdge;
import com.google.android.gms.internal.zzdgq;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
class zzdha implements zzdgh<zzdfl, zzdfm.zza, zzdfm.zzb> {
    private static final Logger logger = Logger.getLogger(zzdha.class.getName());

    static {
        try {
            zzdgp.zzlam.zza("type.googleapis.com/google.cloud.crypto.tink.AesCtrKey", new zzdhb());
            zzdho.zzbnc();
        } catch (GeneralSecurityException e) {
            Logger logger2 = logger;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(e);
            logger2.logp(level, "com.google.cloud.crypto.tink.aead.AesCtrHmacAeadKeyManager", "<clinit>", new StringBuilder(String.valueOf(valueOf).length() + 30).append("cannot register key managers: ").append(valueOf).toString());
        }
    }

    /* renamed from: zza  reason: avoid collision after fix types in other method */
    private static zzdfl zza2(zzdfm.zza zzaVar) throws GeneralSecurityException {
        zzdik.zzp(zzaVar.getVersion(), 0);
        return new zzdhx((zzdih) zzdgp.zzlam.zzb("type.googleapis.com/google.cloud.crypto.tink.AesCtrKey", zzaVar.zzbjm()), (zzdgl) zzdgp.zzlam.zzb("type.googleapis.com/google.cloud.crypto.tink.HmacKey", zzaVar.zzbjn()), zzaVar.zzbjn().zzbli().zzblp());
    }

    private static zzdfm.zza zza(zzdfm.zzb zzbVar) throws GeneralSecurityException {
        return zzdfm.zza.zzbjp().zzb((zzdfo.zza) zzdgp.zzlam.zza("type.googleapis.com/google.cloud.crypto.tink.AesCtrKey", (String) zzbVar.zzbjr())).zzb((zzdge.zza) zzdgp.zzlam.zza("type.googleapis.com/google.cloud.crypto.tink.HmacKey", (String) zzbVar.zzbjs())).zzex(0).zzccr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdgh
    /* renamed from: zzx */
    public final zzdfl zzq(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zza2(zzdfm.zza.zza(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid AesCtrHmacAead key");
        }
    }

    private static zzdfm.zza zzy(zzedk zzedkVar) throws GeneralSecurityException {
        try {
            return zza(zzdfm.zzb.zzb(zzedkVar));
        } catch (zzeer e) {
            throw new GeneralSecurityException("invalid AesCtrHmacAead key format", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* bridge */ /* synthetic */ zzdfl zza(zzdfm.zza zzaVar) throws GeneralSecurityException {
        return zza2(zzaVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* synthetic */ zzdfm.zza zzb(zzdfm.zzb zzbVar) throws GeneralSecurityException {
        return zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final /* synthetic */ zzdfm.zza zzr(zzedk zzedkVar) throws GeneralSecurityException {
        return zzy(zzedkVar);
    }

    @Override // com.google.android.gms.internal.zzdgh
    public final zzdgq.zza zzs(zzedk zzedkVar) throws GeneralSecurityException {
        return zzdgq.zza.zzbmh().zznw("type.googleapis.com/google.cloud.crypto.tink.AesCtrHmacAeadKey").zzw(zzy(zzedkVar).zzcbi()).zzb(zzdgq.zza.zzb.SYMMETRIC).zzccr();
    }
}

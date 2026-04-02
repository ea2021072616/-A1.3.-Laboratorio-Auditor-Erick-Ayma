package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdfm;
import com.google.android.gms.internal.zzdfo;
import com.google.android.gms.internal.zzdfs;
import com.google.android.gms.internal.zzdge;
import com.google.android.gms.internal.zzdgq;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzdhg {
    private final int zzlce;
    private final int zzlcf;
    private zzdfs.zza zzlcg;
    private zzdfm.zza zzlch;
    private int zzlci;

    public zzdhg(zzdgq.zzb zzbVar) throws GeneralSecurityException {
        String zzbme = zzbVar.zzbme();
        if (zzbme.equals("type.googleapis.com/google.cloud.crypto.tink.AesGcmKey")) {
            try {
                zzdfs.zzb zzl = zzdfs.zzb.zzl(zzbVar.zzbmf());
                this.zzlce = zzdhh.zzlcj;
                this.zzlcg = (zzdfs.zza) zzdgp.zzlam.zzb(zzbVar);
                this.zzlcf = zzl.getKeySize();
            } catch (zzeer e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (!zzbme.equals("type.googleapis.com/google.cloud.crypto.tink.AesCtrHmacAeadKey")) {
            String valueOf = String.valueOf(zzbme);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        } else {
            try {
                zzdfm.zzb zzb = zzdfm.zzb.zzb(zzbVar.zzbmf());
                this.zzlce = zzdhh.zzlck;
                this.zzlch = (zzdfm.zza) zzdgp.zzlam.zzb(zzbVar);
                this.zzlci = zzb.zzbjr().getKeySize();
                this.zzlcf = zzb.zzbjs().getKeySize() + this.zzlci;
            } catch (zzeer e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        }
    }

    public final zzdfl zzag(byte[] bArr) throws GeneralSecurityException {
        if (this.zzlce == zzdhh.zzlcj) {
            return (zzdfl) zzdgp.zzlam.zzb("type.googleapis.com/google.cloud.crypto.tink.AesGcmKey", zzdfs.zza.zzbkk().zza((zzdfs.zza.C0080zza) this.zzlcg).zzk(zzedk.zzaq(bArr)).zzccr());
        } else if (this.zzlce == zzdhh.zzlck) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzlci);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzlci, this.zzlcf);
            zzdfm.zza.C0077zza zzb = zzdfm.zza.zzbjp().zzex(this.zzlch.getVersion()).zzb(zzdfo.zza.zzbjw().zza((zzdfo.zza.C0078zza) this.zzlch.zzbjm()).zze(zzedk.zzaq(copyOfRange)).zzccr());
            return (zzdfl) zzdgp.zzlam.zzb("type.googleapis.com/google.cloud.crypto.tink.AesCtrHmacAeadKey", zzb.zzb(zzdge.zza.zzblj().zza((zzdge.zza.C0082zza) this.zzlch.zzbjn()).zzo(zzedk.zzaq(copyOfRange2)).zzccr()).zzccr());
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }

    public final int zzbnd() {
        return this.zzlcf;
    }
}

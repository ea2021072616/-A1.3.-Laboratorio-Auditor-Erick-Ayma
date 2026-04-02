package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class zzdhv {
    private ECPublicKey zzlcm;

    public zzdhv(ECPublicKey eCPublicKey) {
        this.zzlcm = eCPublicKey;
    }

    public final zzdhw zza(String str, byte[] bArr, byte[] bArr2, int i, zzdhu zzdhuVar) throws GeneralSecurityException {
        int i2 = 1;
        ECParameterSpec params = this.zzlcm.getParams();
        KeyPairGenerator zzny = zzdhy.zzldo.zzny("EC");
        zzny.initialize(params);
        KeyPair generateKeyPair = zzny.generateKeyPair();
        ECPublicKey eCPublicKey = (ECPublicKey) generateKeyPair.getPublic();
        zzdhs.zza(this.zzlcm.getW(), this.zzlcm.getParams().getCurve());
        KeyAgreement zzny2 = zzdhy.zzldn.zzny("ECDH");
        zzny2.init((ECPrivateKey) generateKeyPair.getPrivate());
        zzny2.doPhase(this.zzlcm, true);
        byte[] generateSecret = zzny2.generateSecret();
        byte[] zza = zzdhs.zza(eCPublicKey.getParams().getCurve(), zzdhuVar, eCPublicKey.getW());
        byte[] zzc = zzdik.zzc(zza, generateSecret);
        Mac zzny3 = zzdhy.zzldk.zzny(str);
        if (i > zzny3.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr == null || bArr.length == 0) {
            zzny3.init(new SecretKeySpec(new byte[zzny3.getMacLength()], str));
        } else {
            zzny3.init(new SecretKeySpec(bArr, str));
        }
        byte[] bArr3 = new byte[i];
        zzny3.init(new SecretKeySpec(zzny3.doFinal(zzc), str));
        byte[] bArr4 = new byte[0];
        int i3 = 0;
        while (true) {
            zzny3.update(bArr4);
            zzny3.update(bArr2);
            zzny3.update((byte) i2);
            bArr4 = zzny3.doFinal();
            if (bArr4.length + i3 >= i) {
                System.arraycopy(bArr4, 0, bArr3, i3, i - i3);
                return new zzdhw(zza, bArr3);
            }
            System.arraycopy(bArr4, 0, bArr3, i3, bArr4.length);
            i3 += bArr4.length;
            i2++;
        }
    }
}

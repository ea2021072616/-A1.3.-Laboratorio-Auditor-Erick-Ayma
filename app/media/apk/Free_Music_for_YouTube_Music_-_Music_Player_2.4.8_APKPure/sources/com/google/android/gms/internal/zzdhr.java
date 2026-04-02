package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class zzdhr implements zzdfl {
    private final SecretKeySpec zzlct;

    public zzdhr(byte[] bArr) {
        this.zzlct = new SecretKeySpec(bArr, "AES");
    }

    @Override // com.google.android.gms.internal.zzdfl
    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 12 + 16];
        byte[] zzfn = zzdij.zzfn(12);
        System.arraycopy(zzfn, 0, bArr3, 0, 12);
        Cipher zzny = zzdhy.zzldj.zzny("AES/GCM/NoPadding");
        zzny.init(1, this.zzlct, new GCMParameterSpec(128, zzfn));
        zzny.updateAAD(bArr2);
        zzny.doFinal(bArr, 0, bArr.length, bArr3, 12);
        return bArr3;
    }
}

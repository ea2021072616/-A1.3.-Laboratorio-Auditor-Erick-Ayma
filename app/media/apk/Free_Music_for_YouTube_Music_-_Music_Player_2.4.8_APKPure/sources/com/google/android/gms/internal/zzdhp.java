package com.google.android.gms.internal;

import android.support.v7.widget.ActivityChooserView;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class zzdhp implements zzdih {
    private final SecretKeySpec zzlct;
    private final int zzlcu;
    private final int zzlcv = zzdhy.zzldj.zzny("AES/CTR/NoPadding").getBlockSize();

    public zzdhp(byte[] bArr, int i) throws GeneralSecurityException {
        this.zzlct = new SecretKeySpec(bArr, "AES");
        if (i < 12 || i > this.zzlcv) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzlcu = i;
    }

    @Override // com.google.android.gms.internal.zzdih
    public final byte[] zzah(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - this.zzlcu) {
            throw new GeneralSecurityException(new StringBuilder(43).append("plaintext length can not exceed ").append(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - this.zzlcu).toString());
        }
        byte[] bArr2 = new byte[this.zzlcu + bArr.length];
        byte[] zzfn = zzdij.zzfn(this.zzlcu);
        System.arraycopy(zzfn, 0, bArr2, 0, this.zzlcu);
        int length = bArr.length;
        int i = this.zzlcu;
        Cipher zzny = zzdhy.zzldj.zzny("AES/CTR/NoPadding");
        byte[] bArr3 = new byte[this.zzlcv];
        System.arraycopy(zzfn, 0, bArr3, 0, this.zzlcu);
        zzny.init(1, this.zzlct, new IvParameterSpec(bArr3));
        if (zzny.doFinal(bArr, 0, length, bArr2, i) != length) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        return bArr2;
    }
}

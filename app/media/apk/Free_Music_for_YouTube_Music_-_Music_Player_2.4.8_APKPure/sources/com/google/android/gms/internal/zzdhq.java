package com.google.android.gms.internal;

import android.support.v7.widget.ActivityChooserView;
import com.flurry.android.Constants;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class zzdhq implements zzdfl {
    private final SecretKeySpec zzlct;
    private final byte[] zzlcw;
    private final byte[] zzlcx;
    private final int zzlcy;

    public zzdhq(byte[] bArr, int i) throws GeneralSecurityException {
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzlcy = i;
        this.zzlct = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, this.zzlct);
        this.zzlcw = zzai(cipher.doFinal(new byte[16]));
        this.zzlcx = zzai(this.zzlcw);
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zze(bArr3, this.zzlcw));
        }
        int i4 = 0;
        byte[] doFinal = cipher.doFinal(bArr3);
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i2 + i4, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zze(copyOfRange, this.zzlcw);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzlcx, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zze(doFinal, bArr2));
    }

    private static byte[] zzai(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < 15; i++) {
            bArr2[i] = (byte) ((bArr[i] << 1) ^ ((bArr[i + 1] & Constants.UNKNOWN) >>> 7));
        }
        bArr2[15] = (byte) (((bArr[0] & 128) != 0 ? TsExtractor.TS_STREAM_TYPE_E_AC3 : 0) ^ (bArr[15] << 1));
        return bArr2;
    }

    private static byte[] zze(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    @Override // com.google.android.gms.internal.zzdfl
    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - this.zzlcy) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[this.zzlcy + bArr.length + 16];
        byte[] zzfn = zzdij.zzfn(this.zzlcy);
        System.arraycopy(zzfn, 0, bArr3, 0, this.zzlcy);
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, this.zzlct);
        byte[] zza = zza(cipher, 0, zzfn, 0, zzfn.length);
        byte[] zza2 = zza(cipher, 1, bArr2, 0, bArr2.length);
        Cipher cipher2 = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher2.init(1, this.zzlct, new IvParameterSpec(zza));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.zzlcy);
        byte[] zza3 = zza(cipher, 2, bArr3, this.zzlcy, bArr.length);
        int length = bArr.length + this.zzlcy;
        for (int i = 0; i < 16; i++) {
            bArr3[length + i] = (byte) ((zza2[i] ^ zza[i]) ^ zza3[i]);
        }
        return bArr3;
    }
}

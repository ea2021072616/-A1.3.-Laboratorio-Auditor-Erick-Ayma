package com.google.android.gms.internal;

import android.support.v7.widget.ActivityChooserView;
import java.security.GeneralSecurityException;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public final class zzdik {
    private static final Pattern zzldy = Pattern.compile("^projects/([0-9a-zA-Z\\-]+)/locations/([0-9a-zA-Z\\-]+)/keyRings/([0-9a-zA-Z\\-]+)/cryptoKeys/([0-9a-zA-Z\\-]+)$", 2);
    private static final Pattern zzldz = Pattern.compile("^projects/([0-9a-zA-Z\\-]+)/locations/([0-9a-zA-Z\\-]+)/keyRings/([0-9a-zA-Z\\-]+)/cryptoKeys/([0-9a-zA-Z\\-]+)/cryptoKeyVersions/([0-9a-zA-Z\\-]+)$", 2);

    public static boolean zzaig() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static byte[] zzc(byte[]... bArr) throws GeneralSecurityException {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            if (i > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - bArr2.length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i += bArr2.length;
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
            i2 += bArr4.length;
        }
        return bArr3;
    }

    public static void zzfo(int i) throws GeneralSecurityException {
        if (i != 16 && i != 24 && i != 32) {
            throw new GeneralSecurityException("invalid Aes key size");
        }
    }

    public static void zzp(int i, int i2) throws GeneralSecurityException {
        if (i < 0 || i > 0) {
            throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", Integer.valueOf(i), 0));
        }
    }
}

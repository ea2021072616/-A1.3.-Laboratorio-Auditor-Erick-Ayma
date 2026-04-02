package com.google.android.gms.internal;

import java.security.SecureRandom;
/* loaded from: classes2.dex */
public final class zzdij {
    private static final SecureRandom zzldx = new SecureRandom();

    public static byte[] zzfn(int i) {
        byte[] bArr = new byte[i];
        zzldx.nextBytes(bArr);
        return bArr;
    }
}

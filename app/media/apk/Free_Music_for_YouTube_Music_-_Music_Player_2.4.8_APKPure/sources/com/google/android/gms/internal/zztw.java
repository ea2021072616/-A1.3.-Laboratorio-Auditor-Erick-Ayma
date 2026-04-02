package com.google.android.gms.internal;

import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzt
/* loaded from: classes.dex */
public final class zztw {
    private final Object[] mParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztw(zzix zzixVar, String str, int i) {
        this.mParams = com.google.android.gms.ads.internal.zzp.zza((String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkc), zzixVar, str, i, null);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zztw) {
            return Arrays.equals(this.mParams, ((zztw) obj).mParams);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.mParams);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.mParams);
        return new StringBuilder(String.valueOf(arrays).length() + 24).append("[InterstitialAdPoolKey ").append(arrays).append("]").toString();
    }
}

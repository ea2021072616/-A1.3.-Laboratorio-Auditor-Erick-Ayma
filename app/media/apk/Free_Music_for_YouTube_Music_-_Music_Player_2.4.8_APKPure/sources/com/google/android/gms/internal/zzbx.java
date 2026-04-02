package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
final class zzbx implements Runnable {
    private zzbx() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzbv.zza(MessageDigest.getInstance("MD5"));
        } catch (NoSuchAlgorithmException e) {
        } finally {
            zzbv.zzyt.countDown();
        }
    }
}

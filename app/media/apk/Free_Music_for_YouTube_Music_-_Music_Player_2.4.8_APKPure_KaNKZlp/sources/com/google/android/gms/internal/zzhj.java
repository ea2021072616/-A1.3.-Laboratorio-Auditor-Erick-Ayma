package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@zzzt
/* loaded from: classes.dex */
public abstract class zzhj {
    @Nullable
    private static MessageDigest zzazm = null;
    protected Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final MessageDigest zzgx() {
        MessageDigest messageDigest;
        synchronized (this.mLock) {
            if (zzazm != null) {
                messageDigest = zzazm;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        zzazm = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = zzazm;
            }
        }
        return messageDigest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] zzx(String str);
}

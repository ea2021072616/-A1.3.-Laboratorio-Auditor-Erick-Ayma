package com.google.android.gms.internal;

import com.flurry.android.Constants;
import com.google.android.exoplayer2.C;
import java.nio.charset.Charset;
import java.security.MessageDigest;
@zzzt
/* loaded from: classes.dex */
public final class zzhs extends zzhj {
    private MessageDigest zzazt;
    private final int zzazw;
    private final int zzazx;

    public zzhs(int i) {
        int i2 = i / 8;
        this.zzazw = i % 8 > 0 ? i2 + 1 : i2;
        this.zzazx = i;
    }

    @Override // com.google.android.gms.internal.zzhj
    public final byte[] zzx(String str) {
        byte[] bArr;
        synchronized (this.mLock) {
            this.zzazt = zzgx();
            if (this.zzazt == null) {
                bArr = new byte[0];
            } else {
                this.zzazt.reset();
                this.zzazt.update(str.getBytes(Charset.forName(C.UTF8_NAME)));
                byte[] digest = this.zzazt.digest();
                bArr = new byte[digest.length > this.zzazw ? this.zzazw : digest.length];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
                if (this.zzazx % 8 > 0) {
                    long j = 0;
                    for (int i = 0; i < bArr.length; i++) {
                        if (i > 0) {
                            j <<= 8;
                        }
                        j += bArr[i] & Constants.UNKNOWN;
                    }
                    long j2 = j >>> (8 - (this.zzazx % 8));
                    for (int i2 = this.zzazw - 1; i2 >= 0; i2--) {
                        bArr[i2] = (byte) (255 & j2);
                        j2 >>>= 8;
                    }
                }
            }
        }
        return bArr;
    }
}

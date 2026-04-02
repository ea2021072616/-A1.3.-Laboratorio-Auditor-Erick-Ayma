package com.google.android.gms.internal;

import java.util.Random;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@zzzt
/* loaded from: classes.dex */
public final class zzjp extends zzkr {
    private Object mLock = new Object();
    private final Random zzbdm = new Random();
    private long zzbdn;

    public zzjp() {
        zzhw();
    }

    @Override // com.google.android.gms.internal.zzkq
    public final long getValue() {
        return this.zzbdn;
    }

    public final void zzhw() {
        synchronized (this.mLock) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = this.zzbdm.nextInt() + IjkMediaMeta.AV_CH_WIDE_LEFT;
                if (j != this.zzbdn && j != 0) {
                    break;
                }
            }
            this.zzbdn = j;
        }
    }
}

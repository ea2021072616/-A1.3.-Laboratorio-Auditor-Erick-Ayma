package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
/* loaded from: classes.dex */
public final class zzy extends zzakd<zzai> {
    private final Object mLock = new Object();
    private final zzac zzbzk;
    private boolean zzbzl;

    public zzy(zzac zzacVar) {
        this.zzbzk = zzacVar;
    }

    public final void release() {
        synchronized (this.mLock) {
            if (this.zzbzl) {
                return;
            }
            this.zzbzl = true;
            zza(new zzz(this), new zzakb());
            zza(new zzaa(this), new zzab(this));
        }
    }
}

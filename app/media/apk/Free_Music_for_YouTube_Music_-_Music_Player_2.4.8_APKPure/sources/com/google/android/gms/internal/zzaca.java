package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.concurrent.Future;
@zzzt
/* loaded from: classes.dex */
public final class zzaca {
    private String zzcjq;
    private String zzcsl;
    com.google.android.gms.ads.internal.js.zzy zzcsn;
    private final Object mLock = new Object();
    private zzajx<zzacg> zzcsm = new zzajx<>();
    public final zzrn zzcso = new zzacb(this);
    public final zzrn zzcsp = new zzacc(this);
    public final zzrn zzcsq = new zzacd(this);

    public zzaca(String str, String str2) {
        this.zzcsl = str2;
        this.zzcjq = str;
    }

    public final void fail() {
        this.zzcsm.set(new zzacg(0, new HashMap()));
    }

    public final Future<zzacg> zzoj() {
        return this.zzcsm;
    }
}

package com.google.android.gms.internal;
/* loaded from: classes.dex */
public final class zzadx {
    private int mErrorCode;
    private String zzcbm;
    private String zzcwj;
    private long zzcwk;

    public final zzadx zzaa(int i) {
        this.mErrorCode = i;
        return this;
    }

    public final zzadx zzbw(String str) {
        this.zzcbm = str;
        return this;
    }

    public final zzadx zzbx(String str) {
        this.zzcwj = str;
        return this;
    }

    public final zzadx zzg(long j) {
        this.zzcwk = j;
        return this;
    }

    public final zzadv zzox() {
        return new zzadv(this);
    }
}

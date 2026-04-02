package com.google.android.gms.internal;

import java.util.List;
@zzzt
/* loaded from: classes.dex */
final class zzru {
    private final String zzbrs;
    private final String zzbvl;
    private final int zzbvs;
    private final List<zzrr> zzbvt;

    public zzru(String str, int i, List<zzrr> list, String str2) {
        this.zzbvl = str;
        this.zzbvs = i;
        this.zzbvt = list;
        this.zzbrs = str2;
    }

    public final String getBody() {
        return this.zzbrs;
    }

    public final int getResponseCode() {
        return this.zzbvs;
    }

    public final String zzka() {
        return this.zzbvl;
    }

    public final Iterable<zzrr> zzkf() {
        return this.zzbvt;
    }
}

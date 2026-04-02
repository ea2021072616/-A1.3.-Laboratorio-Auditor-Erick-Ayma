package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzt
/* loaded from: classes.dex */
public final class zzrt {
    private final zzru zzbvp;
    private final boolean zzbvq;
    private final String zzbvr;

    public zzrt(zzro zzroVar, boolean z, zzru zzruVar, String str) {
        this.zzbvq = z;
        this.zzbvp = zzruVar;
        this.zzbvr = str;
    }

    public final String getReason() {
        return this.zzbvr;
    }

    public final boolean isSuccess() {
        return this.zzbvq;
    }

    public final zzru zzke() {
        return this.zzbvp;
    }
}

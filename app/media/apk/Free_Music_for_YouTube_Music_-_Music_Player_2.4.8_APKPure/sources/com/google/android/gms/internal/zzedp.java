package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzedp {
    private final byte[] buffer;
    private final zzedw zzmxx;

    private zzedp(int i) {
        this.buffer = new byte[i];
        this.zzmxx = zzedw.zzat(this.buffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzedp(int i, zzedl zzedlVar) {
        this(i);
    }

    public final zzedk zzcbp() {
        this.zzmxx.zzccd();
        return new zzedr(this.buffer);
    }

    public final zzedw zzcbq() {
        return this.zzmxx;
    }
}

package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafi;
/* loaded from: classes.dex */
final class zzm implements Runnable {
    private /* synthetic */ zzl zzanh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzl zzlVar) {
        this.zzanh = zzlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzanh.zzane.zzb(new zzafi(this.zzanh.zzamz, null, null, null, null, null, null, null));
    }
}

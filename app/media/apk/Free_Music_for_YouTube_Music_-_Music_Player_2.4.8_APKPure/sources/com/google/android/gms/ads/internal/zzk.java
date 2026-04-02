package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzk implements Runnable {
    private /* synthetic */ zzafj zzamz;
    private /* synthetic */ zzi zzane;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(zzi zziVar, zzafj zzafjVar) {
        this.zzane = zziVar;
        this.zzamz = zzafjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzane.zzb(new zzafi(this.zzamz, null, null, null, null, null, null, null));
    }
}

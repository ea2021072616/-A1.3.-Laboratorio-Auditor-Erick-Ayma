package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafj;
/* loaded from: classes.dex */
final class zzbd implements Runnable {
    private /* synthetic */ zzafj zzamz;
    private /* synthetic */ zzbc zzara;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbd(zzbc zzbcVar, zzafj zzafjVar) {
        this.zzara = zzbcVar;
        this.zzamz = zzafjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzara.zzb(new zzafi(this.zzamz, null, null, null, null, null, null, null));
    }
}

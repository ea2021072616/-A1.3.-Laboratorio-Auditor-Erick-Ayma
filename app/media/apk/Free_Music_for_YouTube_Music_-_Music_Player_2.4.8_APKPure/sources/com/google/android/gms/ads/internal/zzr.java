package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafi;
/* loaded from: classes.dex */
final class zzr implements Runnable {
    private /* synthetic */ zzq zzanl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(zzq zzqVar) {
        this.zzanl = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzafi zzafiVar;
        zzq zzqVar = this.zzanl;
        zzafiVar = this.zzanl.zzanj;
        zzqVar.zzb(zzafiVar);
    }
}

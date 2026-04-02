package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzyq implements Runnable {
    private /* synthetic */ com.google.android.gms.ads.internal.js.zza zzcln;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyq(zzym zzymVar, com.google.android.gms.ads.internal.js.zza zzaVar) {
        this.zzcln = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcln.destroy();
    }
}

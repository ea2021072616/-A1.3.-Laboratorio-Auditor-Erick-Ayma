package com.google.android.gms.ads.internal;
/* loaded from: classes.dex */
final class zzg implements Runnable {
    private /* synthetic */ zzd zzanc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zzd zzdVar) {
        this.zzanc = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzanc.zzamr.pause();
    }
}

package com.google.android.gms.ads.internal;
/* loaded from: classes.dex */
final class zzh implements Runnable {
    private /* synthetic */ zzd zzanc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(zzd zzdVar) {
        this.zzanc = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzanc.zzamr.resume();
    }
}

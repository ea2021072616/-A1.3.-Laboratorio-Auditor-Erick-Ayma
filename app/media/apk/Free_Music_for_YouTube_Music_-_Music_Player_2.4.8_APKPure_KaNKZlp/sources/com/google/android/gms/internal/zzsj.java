package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzsj implements Runnable {
    private /* synthetic */ zzsi zzbwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsj(zzsi zzsiVar) {
        this.zzbwf = zzsiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzbv.zzex().zzb(this.zzbwf);
    }
}

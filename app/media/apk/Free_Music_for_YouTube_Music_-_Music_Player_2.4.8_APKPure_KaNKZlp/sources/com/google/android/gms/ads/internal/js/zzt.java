package com.google.android.gms.ads.internal.js;
/* loaded from: classes.dex */
final class zzt implements Runnable {
    private /* synthetic */ zzs zzbzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzs zzsVar) {
        this.zzbzg = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbzg.zzbzb.destroy();
    }
}

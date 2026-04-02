package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzabk implements Runnable {
    private /* synthetic */ zzabf zzcrc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabk(zzabf zzabfVar) {
        this.zzcrc = zzabfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.js.zzy zzyVar;
        com.google.android.gms.ads.internal.js.zzy zzyVar2;
        zzyVar = this.zzcrc.zzcrb;
        if (zzyVar != null) {
            zzyVar2 = this.zzcrc.zzcrb;
            zzyVar2.release();
            this.zzcrc.zzcrb = null;
        }
    }
}

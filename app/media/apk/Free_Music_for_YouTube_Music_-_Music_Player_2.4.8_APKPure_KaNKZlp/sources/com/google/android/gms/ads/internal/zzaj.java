package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzix;
/* loaded from: classes.dex */
final class zzaj implements Runnable {
    private /* synthetic */ zzix zzape;
    private /* synthetic */ zzai zzapf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(zzai zzaiVar, zzix zzixVar) {
        this.zzapf = zzaiVar;
        this.zzape = zzixVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean zzcv;
        obj = this.zzapf.mLock;
        synchronized (obj) {
            zzcv = this.zzapf.zzcv();
            if (zzcv) {
                this.zzapf.zze(this.zzape);
            } else {
                this.zzapf.zzb(this.zzape, 1);
            }
        }
    }
}

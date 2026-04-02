package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzix;
/* loaded from: classes.dex */
final class zzak implements Runnable {
    private /* synthetic */ zzix zzape;
    private /* synthetic */ zzai zzapf;
    private /* synthetic */ int zzapg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(zzai zzaiVar, zzix zzixVar, int i) {
        this.zzapf = zzaiVar;
        this.zzape = zzixVar;
        this.zzapg = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzapf.mLock;
        synchronized (obj) {
            this.zzapf.zzb(this.zzape, this.zzapg);
        }
    }
}

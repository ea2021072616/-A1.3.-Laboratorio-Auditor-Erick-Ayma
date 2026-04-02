package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzym;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbk implements Runnable {
    private /* synthetic */ zzbc zzara;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbk(zzbc zzbcVar) {
        this.zzara = zzbcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzara.mLock;
        synchronized (obj) {
            zzym zzdi = this.zzara.zzdi();
            if (zzdi != null) {
                zzdi.zzlf();
            }
        }
    }
}

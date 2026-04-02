package com.google.android.gms.internal;

import java.util.concurrent.Future;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahd implements Runnable {
    private /* synthetic */ zzajx zzdbk;
    private /* synthetic */ Future zzdbm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahd(zzajx zzajxVar, Future future) {
        this.zzdbk = zzajxVar;
        this.zzdbm = future;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzdbk.isCancelled()) {
            this.zzdbm.cancel(true);
        }
    }
}

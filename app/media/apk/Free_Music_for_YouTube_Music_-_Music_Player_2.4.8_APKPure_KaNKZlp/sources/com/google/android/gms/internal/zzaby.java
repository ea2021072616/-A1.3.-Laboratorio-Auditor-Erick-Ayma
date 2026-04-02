package com.google.android.gms.internal;

import java.util.concurrent.Future;
/* loaded from: classes.dex */
final class zzaby implements Runnable {
    private /* synthetic */ Future zzcsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaby(zzabs zzabsVar, Future future) {
        this.zzcsj = future;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzcsj.isDone()) {
            return;
        }
        this.zzcsj.cancel(true);
    }
}

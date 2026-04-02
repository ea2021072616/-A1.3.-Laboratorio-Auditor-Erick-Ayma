package com.google.android.gms.internal;

import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zzaha implements Callable<Void> {
    private /* synthetic */ Runnable zzdbj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaha(Runnable runnable) {
        this.zzdbj = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        this.zzdbj.run();
        return null;
    }
}

package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
final class zzi implements Executor {
    private /* synthetic */ Handler zzs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(zzh zzhVar, Handler handler) {
        this.zzs = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zzs.post(runnable);
    }
}

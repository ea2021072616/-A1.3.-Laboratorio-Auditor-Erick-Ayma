package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
final class zzafb implements ThreadFactory {
    private final AtomicInteger zzcya = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafb(zzaez zzaezVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, new StringBuilder(42).append("AdWorker(SCION_TASK_EXECUTOR) #").append(this.zzcya.getAndIncrement()).toString());
    }
}

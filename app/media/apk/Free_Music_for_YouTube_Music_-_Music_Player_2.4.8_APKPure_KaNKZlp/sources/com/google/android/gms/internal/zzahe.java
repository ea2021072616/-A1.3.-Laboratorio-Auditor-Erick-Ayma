package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
final class zzahe implements ThreadFactory {
    private final AtomicInteger zzcya = new AtomicInteger(1);
    private /* synthetic */ String zzdbn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahe(String str) {
        this.zzdbn = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.zzdbn;
        return new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 23).append("AdWorker(").append(str).append(") #").append(this.zzcya.getAndIncrement()).toString());
    }
}

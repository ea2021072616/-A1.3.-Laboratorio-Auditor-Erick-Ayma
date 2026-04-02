package com.google.android.gms.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzt
/* loaded from: classes.dex */
public final class zzajq<T> implements zzajr<T> {
    private final T value;
    private final zzajs zzdeu = new zzajs();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajq(T t) {
        this.value = t;
        this.zzdeu.zzrr();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final T get() {
        return this.value;
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) {
        return this.value;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzajr
    public final void zza(Runnable runnable, Executor executor) {
        this.zzdeu.zza(runnable, executor);
    }
}

package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzt
/* loaded from: classes.dex */
public class zzajx<T> implements zzajr<T> {
    private T mValue;
    private boolean zzccj;
    private Throwable zzdfd;
    private boolean zzdfe;
    private final Object mLock = new Object();
    private final zzajs zzdff = new zzajs();

    private final boolean zzrs() {
        return this.zzdfd != null || this.zzdfe;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2 = false;
        if (z) {
            synchronized (this.mLock) {
                if (!zzrs()) {
                    this.zzccj = true;
                    this.zzdfe = true;
                    this.mLock.notifyAll();
                    this.zzdff.zzrr();
                    z2 = true;
                }
            }
        }
        return z2;
    }

    @Override // java.util.concurrent.Future
    public T get() throws CancellationException, ExecutionException, InterruptedException {
        T t;
        synchronized (this.mLock) {
            if (!zzrs()) {
                try {
                    this.mLock.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzdfd != null) {
                throw new ExecutionException(this.zzdfd);
            }
            if (this.zzccj) {
                throw new CancellationException("SettableFuture was cancelled.");
            }
            t = this.mValue;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.mLock) {
            if (!zzrs()) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.mLock.wait(millis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzdfd != null) {
                throw new ExecutionException(this.zzdfd);
            }
            if (!this.zzdfe) {
                throw new TimeoutException("SettableFuture timed out.");
            }
            if (this.zzccj) {
                throw new CancellationException("SettableFuture was cancelled.");
            }
            t = this.mValue;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzccj;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean zzrs;
        synchronized (this.mLock) {
            zzrs = zzrs();
        }
        return zzrs;
    }

    public final void set(@Nullable T t) {
        synchronized (this.mLock) {
            if (this.zzccj) {
                return;
            }
            if (zzrs()) {
                com.google.android.gms.ads.internal.zzbv.zzee().zza(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
                return;
            }
            this.zzdfe = true;
            this.mValue = t;
            this.mLock.notifyAll();
            this.zzdff.zzrr();
        }
    }

    public final void setException(Throwable th) {
        synchronized (this.mLock) {
            if (this.zzccj) {
                return;
            }
            if (zzrs()) {
                com.google.android.gms.ads.internal.zzbv.zzee().zza(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
                return;
            }
            this.zzdfd = th;
            this.mLock.notifyAll();
            this.zzdff.zzrr();
        }
    }

    @Override // com.google.android.gms.internal.zzajr
    public final void zza(Runnable runnable, Executor executor) {
        this.zzdff.zza(runnable, executor);
    }
}

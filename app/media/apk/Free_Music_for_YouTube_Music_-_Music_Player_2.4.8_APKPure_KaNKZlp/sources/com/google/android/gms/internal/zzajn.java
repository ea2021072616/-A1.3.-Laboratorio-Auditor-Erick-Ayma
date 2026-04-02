package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
@zzzt
/* loaded from: classes.dex */
public final class zzajn {
    public static <A, B> zzajr<B> zza(final zzajr<A> zzajrVar, final zzajm<A, B> zzajmVar, Executor executor) {
        final zzajx zzajxVar = new zzajx();
        zzajrVar.zza(new Runnable(zzajxVar, zzajmVar, zzajrVar) { // from class: com.google.android.gms.internal.zzajo
            private final zzajx zzdep;
            private final zzajm zzdeq;
            private final zzajr zzder;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdep = zzajxVar;
                this.zzdeq = zzajmVar;
                this.zzder = zzajrVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzajx zzajxVar2 = this.zzdep;
                try {
                    zzajxVar2.set(this.zzdeq.apply(this.zzder.get()));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    zzajxVar2.setException(e);
                } catch (CancellationException e2) {
                    zzajxVar2.cancel(true);
                } catch (ExecutionException e3) {
                    e = e3;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    zzajxVar2.setException(e);
                }
            }
        }, executor);
        zzajxVar.zza(new Runnable(zzajxVar, zzajrVar) { // from class: com.google.android.gms.internal.zzajp
            private final zzajr zzdes;
            private final Future zzdet;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdes = zzajxVar;
                this.zzdet = zzajrVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzajr zzajrVar2 = this.zzdes;
                Future future = this.zzdet;
                if (zzajrVar2.isCancelled()) {
                    future.cancel(true);
                }
            }
        }, zzaju.zzdfb);
        return zzajxVar;
    }

    public static <T> T zza(Future<T> future, T t) {
        try {
            return future.get(((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbll)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            future.cancel(true);
            zzafx.zzc("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "Futures.resolveFuture");
            return t;
        } catch (Exception e2) {
            future.cancel(true);
            zzafx.zzb("Error waiting for future.", e2);
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e2, "Futures.resolveFuture");
            return t;
        }
    }

    public static <T> T zza(Future<T> future, T t, long j, TimeUnit timeUnit) {
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            future.cancel(true);
            zzafx.zzc("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "Futures.resolveFuture");
            return t;
        } catch (Exception e2) {
            future.cancel(true);
            zzafx.zzb("Error waiting for future.", e2);
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e2, "Futures.resolveFuture");
            return t;
        }
    }

    public static <T> zzajq<T> zzg(T t) {
        return new zzajq<>(t);
    }
}

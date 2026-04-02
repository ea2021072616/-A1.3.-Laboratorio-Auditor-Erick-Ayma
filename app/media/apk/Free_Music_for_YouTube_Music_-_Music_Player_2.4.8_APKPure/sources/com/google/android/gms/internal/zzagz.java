package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@zzzt
/* loaded from: classes.dex */
public final class zzagz {
    public static final ThreadPoolExecutor zzdbh = new ThreadPoolExecutor(20, 20, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzcg("Default"));
    private static final ThreadPoolExecutor zzdbi = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzcg("Loader"));

    static {
        zzdbh.allowCoreThreadTimeOut(true);
        zzdbi.allowCoreThreadTimeOut(true);
    }

    public static zzajr<Void> zza(int i, Runnable runnable) {
        return i == 1 ? zza(zzdbi, new zzaha(runnable)) : zza(zzdbh, new zzahb(runnable));
    }

    public static zzajr<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzajr<T> zza(ExecutorService executorService, Callable<T> callable) {
        zzajx zzajxVar = new zzajx();
        try {
            zzajxVar.zza(new zzahd(zzajxVar, executorService.submit(new zzahc(zzajxVar, callable))), zzaju.zzdfa);
        } catch (RejectedExecutionException e) {
            zzafx.zzc("Thread execution is rejected.", e);
            zzajxVar.setException(e);
        }
        return zzajxVar;
    }

    private static ThreadFactory zzcg(String str) {
        return new zzahe(str);
    }
}

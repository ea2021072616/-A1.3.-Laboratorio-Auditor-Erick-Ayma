package com.crashlytics.android.core;

import android.os.Looper;
import b.a.a.a.c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CrashlyticsExecutorServiceWrapper {
    private final ExecutorService executorService;

    public CrashlyticsExecutorServiceWrapper(ExecutorService executorService) {
        this.executorService = executorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T executeSyncLoggingException(Callable<T> callable) {
        T t = null;
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                t = this.executorService.submit(callable).get(4L, TimeUnit.SECONDS);
            } else {
                t = this.executorService.submit(callable).get();
            }
        } catch (RejectedExecutionException e) {
            c.h().a(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
        } catch (Exception e2) {
            c.h().e(CrashlyticsCore.TAG, "Failed to execute task.", e2);
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Future<?> executeAsync(final Runnable runnable) {
        try {
            return this.executorService.submit(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsExecutorServiceWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        c.h().e(CrashlyticsCore.TAG, "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            c.h().a(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> Future<T> executeAsync(final Callable<T> callable) {
        try {
            return this.executorService.submit(new Callable<T>() { // from class: com.crashlytics.android.core.CrashlyticsExecutorServiceWrapper.2
                @Override // java.util.concurrent.Callable
                public T call() throws Exception {
                    try {
                        return (T) callable.call();
                    } catch (Exception e) {
                        c.h().e(CrashlyticsCore.TAG, "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            c.h().a(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}

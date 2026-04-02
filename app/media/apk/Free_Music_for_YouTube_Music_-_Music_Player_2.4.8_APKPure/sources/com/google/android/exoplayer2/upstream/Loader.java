package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final class Loader implements LoaderErrorThrower {
    public static final int DONT_RETRY = 2;
    public static final int DONT_RETRY_FATAL = 3;
    private static final int MSG_CANCEL = 1;
    private static final int MSG_END_OF_SOURCE = 2;
    private static final int MSG_FATAL_ERROR = 4;
    private static final int MSG_IO_EXCEPTION = 3;
    private static final int MSG_START = 0;
    public static final int RETRY = 0;
    public static final int RETRY_RESET_ERROR_COUNT = 1;
    private LoadTask<? extends Loadable> currentTask;
    private final ExecutorService downloadExecutorService;
    private IOException fatalError;

    /* loaded from: classes.dex */
    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t, long j, long j2, boolean z);

        void onLoadCompleted(T t, long j, long j2);

        int onLoadError(T t, long j, long j2, IOException iOException);
    }

    /* loaded from: classes.dex */
    public interface Loadable {
        void cancelLoad();

        boolean isLoadCanceled();

        void load() throws IOException, InterruptedException;
    }

    /* loaded from: classes.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Exception exc) {
            super("Unexpected " + exc.getClass().getSimpleName() + ": " + exc.getMessage(), exc);
        }
    }

    public Loader(String str) {
        this.downloadExecutorService = Util.newSingleThreadExecutor(str);
    }

    public <T extends Loadable> long startLoading(T t, Callback<T> callback, int i) {
        Looper myLooper = Looper.myLooper();
        Assertions.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(myLooper, t, callback, i, elapsedRealtime).start(0L);
        return elapsedRealtime;
    }

    public boolean isLoading() {
        return this.currentTask != null;
    }

    public void cancelLoading() {
        this.currentTask.cancel(false);
    }

    public void release() {
        release(null);
    }

    public void release(Runnable runnable) {
        if (this.currentTask != null) {
            this.currentTask.cancel(true);
        }
        if (runnable != null) {
            this.downloadExecutorService.submit(runnable);
        }
        this.downloadExecutorService.shutdown();
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int i) throws IOException {
        if (this.fatalError != null) {
            throw this.fatalError;
        }
        if (this.currentTask != null) {
            LoadTask<? extends Loadable> loadTask = this.currentTask;
            if (i == Integer.MIN_VALUE) {
                i = this.currentTask.defaultMinRetryCount;
            }
            loadTask.maybeThrowError(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        private static final String TAG = "LoadTask";
        private final Callback<T> callback;
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;
        private volatile Thread executorThread;
        private final T loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper, T t, Callback<T> callback, int i, long j) {
            super(looper);
            this.loadable = t;
            this.callback = callback;
            this.defaultMinRetryCount = i;
            this.startTimeMs = j;
        }

        public void maybeThrowError(int i) throws IOException {
            if (this.currentError != null && this.errorCount > i) {
                throw this.currentError;
            }
        }

        public void start(long j) {
            Assertions.checkState(Loader.this.currentTask == null);
            Loader.this.currentTask = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                submitToExecutor();
            }
        }

        public void cancel(boolean z) {
            this.released = z;
            this.currentError = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.loadable.cancelLoad();
                if (this.executorThread != null) {
                    this.executorThread.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.callback.onLoadCanceled(this.loadable, elapsedRealtime, elapsedRealtime - this.startTimeMs, true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.executorThread = Thread.currentThread();
                if (!this.loadable.isLoadCanceled()) {
                    TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                    try {
                        this.loadable.load();
                    } finally {
                        TraceUtil.endSection();
                    }
                }
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e) {
                if (!this.released) {
                    obtainMessage(3, e).sendToTarget();
                }
            } catch (Error e2) {
                Log.e(TAG, "Unexpected error loading stream", e2);
                if (!this.released) {
                    obtainMessage(4, e2).sendToTarget();
                }
                throw e2;
            } catch (InterruptedException e3) {
                Assertions.checkState(this.loadable.isLoadCanceled());
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e4) {
                Log.e(TAG, "Unexpected exception loading stream", e4);
                if (!this.released) {
                    obtainMessage(3, new UnexpectedLoaderException(e4)).sendToTarget();
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!this.released) {
                if (message.what == 0) {
                    submitToExecutor();
                } else if (message.what == 4) {
                    throw ((Error) message.obj);
                } else {
                    finish();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.startTimeMs;
                    if (this.loadable.isLoadCanceled()) {
                        this.callback.onLoadCanceled(this.loadable, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.callback.onLoadCanceled(this.loadable, elapsedRealtime, j, false);
                            return;
                        case 2:
                            this.callback.onLoadCompleted(this.loadable, elapsedRealtime, j);
                            return;
                        case 3:
                            this.currentError = (IOException) message.obj;
                            int onLoadError = this.callback.onLoadError(this.loadable, elapsedRealtime, j, this.currentError);
                            if (onLoadError == 3) {
                                Loader.this.fatalError = this.currentError;
                                return;
                            } else if (onLoadError != 2) {
                                this.errorCount = onLoadError == 1 ? 1 : this.errorCount + 1;
                                start(getRetryDelayMillis());
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        }

        private void submitToExecutor() {
            this.currentError = null;
            Loader.this.downloadExecutorService.submit(Loader.this.currentTask);
        }

        private void finish() {
            Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }
}

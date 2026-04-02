package com.crashlytics.android.answers;

import b.a.a.a.a.c.a.b;
import b.a.a.a.a.c.a.c;
import b.a.a.a.a.c.a.e;
import b.a.a.a.a.d.f;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
class AnswersRetryFilesSender implements f {
    private static final int BACKOFF_MS = 1000;
    private static final int BACKOFF_POWER = 8;
    private static final double JITTER_PERCENT = 0.1d;
    private static final int MAX_RETRIES = 5;
    private final SessionAnalyticsFilesSender filesSender;
    private final RetryManager retryManager;

    public static AnswersRetryFilesSender build(SessionAnalyticsFilesSender sessionAnalyticsFilesSender) {
        return new AnswersRetryFilesSender(sessionAnalyticsFilesSender, new RetryManager(new e(new RandomBackoff(new c(1000L, 8), JITTER_PERCENT), new b(5))));
    }

    AnswersRetryFilesSender(SessionAnalyticsFilesSender sessionAnalyticsFilesSender, RetryManager retryManager) {
        this.filesSender = sessionAnalyticsFilesSender;
        this.retryManager = retryManager;
    }

    @Override // b.a.a.a.a.d.f
    public boolean send(List<File> list) {
        long nanoTime = System.nanoTime();
        if (this.retryManager.canRetry(nanoTime)) {
            if (this.filesSender.send(list)) {
                this.retryManager.reset();
                return true;
            }
            this.retryManager.recordRetry(nanoTime);
            return false;
        }
        return false;
    }
}

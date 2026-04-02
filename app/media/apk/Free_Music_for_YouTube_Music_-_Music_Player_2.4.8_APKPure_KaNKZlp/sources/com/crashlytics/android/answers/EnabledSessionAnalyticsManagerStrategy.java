package com.crashlytics.android.answers;

import android.content.Context;
import b.a.a.a.a.b.g;
import b.a.a.a.a.d.f;
import b.a.a.a.a.e.e;
import b.a.a.a.a.g.b;
import b.a.a.a.c;
import b.a.a.a.i;
import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    private final Context context;
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    f filesSender;
    private final e httpRequestFactory;
    private final i kit;
    final SessionEventMetadata metadata;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference<>();
    g apiKey = new g();
    EventFilter eventFilter = new KeepAllEventFilter();
    boolean customEventsEnabled = true;
    boolean predefinedEventsEnabled = true;
    volatile int rolloverIntervalSeconds = -1;

    public EnabledSessionAnalyticsManagerStrategy(i iVar, Context context, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, e eVar, SessionEventMetadata sessionEventMetadata) {
        this.kit = iVar;
        this.context = context;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = eVar;
        this.metadata = sessionEventMetadata;
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void setAnalyticsSettingsData(b bVar, String str) {
        this.filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(this.kit, str, bVar.f212a, this.httpRequestFactory, this.apiKey.a(this.context)));
        this.filesManager.setAnalyticsSettingsData(bVar);
        this.customEventsEnabled = bVar.f;
        c.h().a(Answers.TAG, "Custom event tracking " + (this.customEventsEnabled ? "enabled" : "disabled"));
        this.predefinedEventsEnabled = bVar.g;
        c.h().a(Answers.TAG, "Predefined event tracking " + (this.predefinedEventsEnabled ? "enabled" : "disabled"));
        if (bVar.i > 1) {
            c.h().a(Answers.TAG, "Event sampling enabled");
            this.eventFilter = new SamplingEventFilter(bVar.i);
        }
        this.rolloverIntervalSeconds = bVar.f213b;
        scheduleTimeBasedFileRollOver(0L, this.rolloverIntervalSeconds);
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void processEvent(SessionEvent.Builder builder) {
        SessionEvent build = builder.build(this.metadata);
        if (!this.customEventsEnabled && SessionEvent.Type.CUSTOM.equals(build.type)) {
            c.h().a(Answers.TAG, "Custom events tracking disabled - skipping event: " + build);
        } else if (!this.predefinedEventsEnabled && SessionEvent.Type.PREDEFINED.equals(build.type)) {
            c.h().a(Answers.TAG, "Predefined events tracking disabled - skipping event: " + build);
        } else if (this.eventFilter.skipEvent(build)) {
            c.h().a(Answers.TAG, "Skipping filtered event: " + build);
        } else {
            try {
                this.filesManager.writeEvent(build);
            } catch (IOException e) {
                c.h().e(Answers.TAG, "Failed to write event: " + build, e);
            }
            scheduleTimeBasedRollOverIfNeeded();
        }
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
        if (this.rolloverIntervalSeconds != -1) {
            scheduleTimeBasedFileRollOver(this.rolloverIntervalSeconds, this.rolloverIntervalSeconds);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void sendEvents() {
        /*
            r9 = this;
            r1 = 0
            b.a.a.a.a.d.f r0 = r9.filesSender
            if (r0 != 0) goto Ld
            android.content.Context r0 = r9.context
            java.lang.String r1 = "skipping files send because we don't yet know the target endpoint"
            b.a.a.a.a.b.i.a(r0, r1)
        Lc:
            return
        Ld:
            android.content.Context r0 = r9.context
            java.lang.String r2 = "Sending all files"
            b.a.a.a.a.b.i.a(r0, r2)
            com.crashlytics.android.answers.SessionAnalyticsFilesManager r0 = r9.filesManager
            java.util.List r0 = r0.getBatchOfFilesToSend()
            r2 = r0
            r0 = r1
        L1c:
            int r1 = r2.size()     // Catch: java.lang.Exception -> L62
            if (r1 <= 0) goto L52
            android.content.Context r1 = r9.context     // Catch: java.lang.Exception -> L62
            java.util.Locale r3 = java.util.Locale.US     // Catch: java.lang.Exception -> L62
            java.lang.String r4 = "attempt to send batch of %d files"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L62
            r6 = 0
            int r7 = r2.size()     // Catch: java.lang.Exception -> L62
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L62
            r5[r6] = r7     // Catch: java.lang.Exception -> L62
            java.lang.String r3 = java.lang.String.format(r3, r4, r5)     // Catch: java.lang.Exception -> L62
            b.a.a.a.a.b.i.a(r1, r3)     // Catch: java.lang.Exception -> L62
            b.a.a.a.a.d.f r1 = r9.filesSender     // Catch: java.lang.Exception -> L62
            boolean r3 = r1.send(r2)     // Catch: java.lang.Exception -> L62
            if (r3 == 0) goto L50
            int r1 = r2.size()     // Catch: java.lang.Exception -> L62
            int r1 = r1 + r0
            com.crashlytics.android.answers.SessionAnalyticsFilesManager r0 = r9.filesManager     // Catch: java.lang.Exception -> L84
            r0.deleteSentFiles(r2)     // Catch: java.lang.Exception -> L84
            r0 = r1
        L50:
            if (r3 != 0) goto L5a
        L52:
            if (r0 != 0) goto Lc
            com.crashlytics.android.answers.SessionAnalyticsFilesManager r0 = r9.filesManager
            r0.deleteOldestInRollOverIfOverMax()
            goto Lc
        L5a:
            com.crashlytics.android.answers.SessionAnalyticsFilesManager r1 = r9.filesManager     // Catch: java.lang.Exception -> L62
            java.util.List r1 = r1.getBatchOfFilesToSend()     // Catch: java.lang.Exception -> L62
            r2 = r1
            goto L1c
        L62:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
        L66:
            android.content.Context r2 = r9.context
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to send batch of analytics files to server: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r0.getMessage()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            b.a.a.a.a.b.i.a(r2, r3, r0)
            r0 = r1
            goto L52
        L84:
            r0 = move-exception
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.answers.EnabledSessionAnalyticsManagerStrategy.sendEvents():void");
    }

    @Override // b.a.a.a.a.d.e
    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            b.a.a.a.a.b.i.a(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            this.rolloverFutureRef.get().cancel(false);
            this.rolloverFutureRef.set(null);
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    @Override // b.a.a.a.a.d.e
    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (IOException e) {
            b.a.a.a.a.b.i.a(this.context, "Failed to roll file over.", e);
            return false;
        }
    }

    void scheduleTimeBasedFileRollOver(long j, long j2) {
        if (this.rolloverFutureRef.get() == null) {
            b.a.a.a.a.d.i iVar = new b.a.a.a.a.d.i(this.context, this);
            b.a.a.a.a.b.i.a(this.context, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.rolloverFutureRef.set(this.executorService.scheduleAtFixedRate(iVar, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                b.a.a.a.a.b.i.a(this.context, "Failed to schedule time based file roll over", e);
            }
        }
    }
}

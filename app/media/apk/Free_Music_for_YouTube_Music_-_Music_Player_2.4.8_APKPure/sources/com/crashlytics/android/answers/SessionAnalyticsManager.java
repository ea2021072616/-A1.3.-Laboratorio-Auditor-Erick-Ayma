package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import b.a.a.a.a;
import b.a.a.a.a.b.n;
import b.a.a.a.a.b.o;
import b.a.a.a.a.f.b;
import b.a.a.a.c;
import b.a.a.a.i;
import com.crashlytics.android.answers.BackgroundManager;
import com.crashlytics.android.answers.SessionEvent;
import java.util.concurrent.ScheduledExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SessionAnalyticsManager implements BackgroundManager.Listener {
    static final String EXECUTOR_SERVICE = "Answers Events Handler";
    static final String ON_CRASH_ERROR_MSG = "onCrash called from main thread!!!";
    final BackgroundManager backgroundManager;
    final AnswersEventsHandler eventsHandler;
    private final long installedAt;
    final a lifecycleManager;
    final AnswersPreferenceManager preferenceManager;

    public static SessionAnalyticsManager build(i iVar, Context context, o oVar, String str, String str2, long j) {
        SessionMetadataCollector sessionMetadataCollector = new SessionMetadataCollector(context, oVar, str, str2);
        AnswersFilesManagerProvider answersFilesManagerProvider = new AnswersFilesManagerProvider(context, new b(iVar));
        b.a.a.a.a.e.b bVar = new b.a.a.a.a.e.b(c.h());
        a aVar = new a(context);
        ScheduledExecutorService b2 = n.b(EXECUTOR_SERVICE);
        return new SessionAnalyticsManager(new AnswersEventsHandler(iVar, context, answersFilesManagerProvider, sessionMetadataCollector, bVar, b2), aVar, new BackgroundManager(b2), AnswersPreferenceManager.build(context), j);
    }

    SessionAnalyticsManager(AnswersEventsHandler answersEventsHandler, a aVar, BackgroundManager backgroundManager, AnswersPreferenceManager answersPreferenceManager, long j) {
        this.eventsHandler = answersEventsHandler;
        this.lifecycleManager = aVar;
        this.backgroundManager = backgroundManager;
        this.preferenceManager = answersPreferenceManager;
        this.installedAt = j;
    }

    public void enable() {
        this.eventsHandler.enable();
        this.lifecycleManager.a(new AnswersLifecycleCallbacks(this, this.backgroundManager));
        this.backgroundManager.registerListener(this);
        if (isFirstLaunch()) {
            onInstall(this.installedAt);
            this.preferenceManager.setAnalyticsLaunched();
        }
    }

    public void disable() {
        this.lifecycleManager.a();
        this.eventsHandler.disable();
    }

    public void onCustom(CustomEvent customEvent) {
        c.h().a(Answers.TAG, "Logged custom event: " + customEvent);
        this.eventsHandler.processEventAsync(SessionEvent.customEventBuilder(customEvent));
    }

    public void onPredefined(PredefinedEvent predefinedEvent) {
        c.h().a(Answers.TAG, "Logged predefined event: " + predefinedEvent);
        this.eventsHandler.processEventAsync(SessionEvent.predefinedEventBuilder(predefinedEvent));
    }

    public void onCrash(String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(ON_CRASH_ERROR_MSG);
        }
        c.h().a(Answers.TAG, "Logged crash");
        this.eventsHandler.processEventSync(SessionEvent.crashEventBuilder(str, str2));
    }

    public void onError(String str) {
    }

    public void onInstall(long j) {
        c.h().a(Answers.TAG, "Logged install");
        this.eventsHandler.processEventAsyncAndFlush(SessionEvent.installEventBuilder(j));
    }

    public void onLifecycle(Activity activity, SessionEvent.Type type) {
        c.h().a(Answers.TAG, "Logged lifecycle event: " + type.name());
        this.eventsHandler.processEventAsync(SessionEvent.lifecycleEventBuilder(type, activity));
    }

    @Override // com.crashlytics.android.answers.BackgroundManager.Listener
    public void onBackground() {
        c.h().a(Answers.TAG, "Flush events when app is backgrounded");
        this.eventsHandler.flushEvents();
    }

    public void setAnalyticsSettingsData(b.a.a.a.a.g.b bVar, String str) {
        this.backgroundManager.setFlushOnBackground(bVar.h);
        this.eventsHandler.setAnalyticsSettingsData(bVar, str);
    }

    boolean isFirstLaunch() {
        return !this.preferenceManager.hasAnalyticsLaunched();
    }
}

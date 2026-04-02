package com.crashlytics.android.answers;

import b.a.a.a.a.d.e;
import b.a.a.a.a.g.b;
import com.crashlytics.android.answers.SessionEvent;
/* loaded from: classes.dex */
interface SessionAnalyticsManagerStrategy extends e {
    void deleteAllEvents();

    void processEvent(SessionEvent.Builder builder);

    void sendEvents();

    void setAnalyticsSettingsData(b bVar, String str);
}

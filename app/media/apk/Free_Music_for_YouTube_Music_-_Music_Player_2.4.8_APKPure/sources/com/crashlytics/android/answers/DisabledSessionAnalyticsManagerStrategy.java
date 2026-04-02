package com.crashlytics.android.answers;

import b.a.a.a.a.g.b;
import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;
/* loaded from: classes.dex */
class DisabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void setAnalyticsSettingsData(b bVar, String str) {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void processEvent(SessionEvent.Builder builder) {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void sendEvents() {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void deleteAllEvents() {
    }

    @Override // b.a.a.a.a.d.e
    public boolean rollFileOver() throws IOException {
        return false;
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
    }

    @Override // b.a.a.a.a.d.e
    public void cancelTimeBasedFileRollOver() {
    }
}

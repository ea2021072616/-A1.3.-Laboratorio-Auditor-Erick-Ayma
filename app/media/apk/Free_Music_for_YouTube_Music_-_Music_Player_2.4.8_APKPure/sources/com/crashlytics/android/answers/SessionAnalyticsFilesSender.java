package com.crashlytics.android.answers;

import b.a.a.a.a.b.a;
import b.a.a.a.a.b.r;
import b.a.a.a.a.d.f;
import b.a.a.a.a.e.c;
import b.a.a.a.a.e.d;
import b.a.a.a.a.e.e;
import b.a.a.a.i;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
class SessionAnalyticsFilesSender extends a implements f {
    static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(i iVar, String str, String str2, e eVar, String str3) {
        super(iVar, str, str2, eVar, c.POST);
        this.apiKey = str3;
    }

    @Override // b.a.a.a.a.d.f
    public boolean send(List<File> list) {
        d a2 = getHttpRequest().a(a.HEADER_CLIENT_TYPE, "android").a(a.HEADER_CLIENT_VERSION, this.kit.getVersion()).a(a.HEADER_API_KEY, this.apiKey);
        int i = 0;
        for (File file : list) {
            a2.a(FILE_PARAM_NAME + i, file.getName(), FILE_CONTENT_TYPE, file);
            i++;
        }
        b.a.a.a.c.h().a(Answers.TAG, "Sending " + list.size() + " analytics files to " + getUrl());
        int b2 = a2.b();
        b.a.a.a.c.h().a(Answers.TAG, "Response code for analytics file send is " + b2);
        return r.a(b2) == 0;
    }
}

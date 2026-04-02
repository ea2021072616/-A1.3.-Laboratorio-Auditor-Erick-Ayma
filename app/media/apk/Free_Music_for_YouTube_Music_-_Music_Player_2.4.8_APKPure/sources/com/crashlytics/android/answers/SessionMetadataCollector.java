package com.crashlytics.android.answers;

import android.content.Context;
import b.a.a.a.a.b.i;
import b.a.a.a.a.b.o;
import java.util.Map;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SessionMetadataCollector {
    private final Context context;
    private final o idManager;
    private final String versionCode;
    private final String versionName;

    public SessionMetadataCollector(Context context, o oVar, String str, String str2) {
        this.context = context;
        this.idManager = oVar;
        this.versionCode = str;
        this.versionName = str2;
    }

    public SessionEventMetadata getMetadata() {
        Map<o.a, String> i = this.idManager.i();
        String m = i.m(this.context);
        String d = this.idManager.d();
        String g = this.idManager.g();
        return new SessionEventMetadata(this.idManager.c(), UUID.randomUUID().toString(), this.idManager.b(), i.get(o.a.ANDROID_ID), i.get(o.a.ANDROID_ADVERTISING_ID), this.idManager.l(), i.get(o.a.FONT_TOKEN), m, d, g, this.versionCode, this.versionName);
    }
}

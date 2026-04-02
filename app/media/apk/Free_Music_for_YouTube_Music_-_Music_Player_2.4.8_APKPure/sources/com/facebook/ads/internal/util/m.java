package com.facebook.ads.internal.util;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f1544a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1545b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1546c;

    public m(String str, String str2) {
        this(str, str2, false);
    }

    public m(String str, String str2, boolean z) {
        this.f1544a = str;
        this.f1545b = str2;
        this.f1546c = z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("stacktrace", this.f1544a);
        hashMap.put("app_crashed_version", this.f1545b);
        hashMap.put("caught_exception", this.f1546c);
        return hashMap;
    }
}

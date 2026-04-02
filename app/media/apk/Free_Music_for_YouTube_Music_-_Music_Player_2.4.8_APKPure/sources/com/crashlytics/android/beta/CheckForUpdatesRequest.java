package com.crashlytics.android.beta;

import b.a.a.a.a.b.a;
import b.a.a.a.a.e.c;
import b.a.a.a.a.e.d;
import b.a.a.a.a.e.e;
import b.a.a.a.i;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class CheckForUpdatesRequest extends a {
    static final String BETA_SOURCE = "3";
    static final String BUILD_VERSION = "build_version";
    static final String DISPLAY_VERSION = "display_version";
    static final String HEADER_BETA_TOKEN = "X-CRASHLYTICS-BETA-TOKEN";
    static final String INSTANCE = "instance";
    static final String SDK_ANDROID_DIR_TOKEN_TYPE = "3";
    static final String SOURCE = "source";
    private final CheckForUpdatesResponseTransform responseTransform;

    static String createBetaTokenHeaderValueFor(String str) {
        return "3:" + str;
    }

    public CheckForUpdatesRequest(i iVar, String str, String str2, e eVar, CheckForUpdatesResponseTransform checkForUpdatesResponseTransform) {
        super(iVar, str, str2, eVar, c.GET);
        this.responseTransform = checkForUpdatesResponseTransform;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0120  */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v5, types: [b.a.a.a.a.e.d] */
    /* JADX WARN: Type inference failed for: r2v6, types: [b.a.a.a.l] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.crashlytics.android.beta.CheckForUpdatesResponse invoke(java.lang.String r8, java.lang.String r9, com.crashlytics.android.beta.BuildProperties r10) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.beta.CheckForUpdatesRequest.invoke(java.lang.String, java.lang.String, com.crashlytics.android.beta.BuildProperties):com.crashlytics.android.beta.CheckForUpdatesResponse");
    }

    private d applyHeadersTo(d dVar, String str, String str2) {
        return dVar.a(a.HEADER_ACCEPT, a.ACCEPT_JSON_VALUE).a(a.HEADER_USER_AGENT, a.CRASHLYTICS_USER_AGENT + this.kit.getVersion()).a(a.HEADER_DEVELOPER_TOKEN, a.CLS_ANDROID_SDK_DEVELOPER_TOKEN).a(a.HEADER_CLIENT_TYPE, "android").a(a.HEADER_CLIENT_VERSION, this.kit.getVersion()).a(a.HEADER_API_KEY, str).a(HEADER_BETA_TOKEN, createBetaTokenHeaderValueFor(str2));
    }

    private Map<String, String> getQueryParamsFor(BuildProperties buildProperties) {
        HashMap hashMap = new HashMap();
        hashMap.put(BUILD_VERSION, buildProperties.versionCode);
        hashMap.put(DISPLAY_VERSION, buildProperties.versionName);
        hashMap.put(INSTANCE, buildProperties.buildId);
        hashMap.put("source", "3");
        return hashMap;
    }
}

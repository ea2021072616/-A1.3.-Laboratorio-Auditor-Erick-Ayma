package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import b.a.a.a.a.a.b;
import b.a.a.a.a.b.m;
import b.a.a.a.a.b.o;
import b.a.a.a.a.b.s;
import b.a.a.a.a.f.d;
import b.a.a.a.a.g.f;
import b.a.a.a.a.g.q;
import b.a.a.a.a.g.t;
import b.a.a.a.c;
import b.a.a.a.i;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class Beta extends i<Boolean> implements m {
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String CRASHLYTICS_BUILD_PROPERTIES = "crashlytics-build.properties";
    static final String NO_DEVICE_TOKEN = "";
    public static final String TAG = "Beta";
    private final b<String> deviceTokenCache = new b<>();
    private final DeviceTokenLoader deviceTokenLoader = new DeviceTokenLoader();
    private UpdatesController updatesController;

    public static Beta getInstance() {
        return (Beta) c.a(Beta.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.a.a.i
    @TargetApi(14)
    public boolean onPreExecute() {
        this.updatesController = createUpdatesController(Build.VERSION.SDK_INT, (Application) getContext().getApplicationContext());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // b.a.a.a.i
    public Boolean doInBackground() {
        c.h().a(TAG, "Beta kit initializing...");
        Context context = getContext();
        o idManager = getIdManager();
        if (TextUtils.isEmpty(getBetaDeviceToken(context, idManager.j()))) {
            c.h().a(TAG, "A Beta device token was not found for this app");
            return false;
        }
        c.h().a(TAG, "Beta device token is present, checking for app updates.");
        f betaSettingsData = getBetaSettingsData();
        BuildProperties loadBuildProperties = loadBuildProperties(context);
        if (canCheckForUpdates(betaSettingsData, loadBuildProperties)) {
            this.updatesController.initialize(context, this, idManager, betaSettingsData, loadBuildProperties, new d(this), new s(), new b.a.a.a.a.e.b(c.h()));
        }
        return true;
    }

    @TargetApi(14)
    UpdatesController createUpdatesController(int i, Application application) {
        return i >= 14 ? new ActivityLifecycleCheckForUpdatesController(getFabric().e(), getFabric().f()) : new ImmediateCheckForUpdatesController();
    }

    @Override // b.a.a.a.a.b.m
    public Map<o.a, String> getDeviceIdentifiers() {
        String betaDeviceToken = getBetaDeviceToken(getContext(), getIdManager().j());
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(betaDeviceToken)) {
            hashMap.put(o.a.FONT_TOKEN, betaDeviceToken);
        }
        return hashMap;
    }

    @Override // b.a.a.a.i
    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    @Override // b.a.a.a.i
    public String getVersion() {
        return "1.2.2.142";
    }

    boolean canCheckForUpdates(f fVar, BuildProperties buildProperties) {
        return (fVar == null || TextUtils.isEmpty(fVar.f224a) || buildProperties == null) ? false : true;
    }

    private String getBetaDeviceToken(Context context, String str) {
        String str2;
        try {
            str2 = this.deviceTokenCache.a(context, this.deviceTokenLoader);
            if ("".equals(str2)) {
                str2 = null;
            }
        } catch (Exception e) {
            c.h().e(TAG, "Failed to load the Beta device token", e);
            str2 = null;
        }
        c.h().a(TAG, "Beta device token present: " + (!TextUtils.isEmpty(str2)));
        return str2;
    }

    private f getBetaSettingsData() {
        t b2 = q.a().b();
        if (b2 != null) {
            return b2.f;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.crashlytics.android.beta.BuildProperties loadBuildProperties(android.content.Context r8) {
        /*
            r7 = this;
            r1 = 0
            android.content.res.AssetManager r0 = r8.getAssets()     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L8a
            java.lang.String r2 = "crashlytics-build.properties"
            java.io.InputStream r2 = r0.open(r2)     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L8a
            if (r2 == 0) goto Lab
            com.crashlytics.android.beta.BuildProperties r1 = com.crashlytics.android.beta.BuildProperties.fromPropertiesStream(r2)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La1
            b.a.a.a.l r0 = b.a.a.a.c.h()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.String r3 = "Beta"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            r4.<init>()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.String r5 = r1.packageName     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.String r5 = " build properties: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.String r5 = r1.versionName     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.String r5 = " ("
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.String r5 = r1.versionCode     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.String r5 = ")"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.String r5 = " - "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.String r5 = r1.buildId     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            r0.a(r3, r4)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La6
            r0 = r1
        L54:
            if (r2 == 0) goto L59
            r2.close()     // Catch: java.io.IOException -> L5a
        L59:
            return r0
        L5a:
            r1 = move-exception
            b.a.a.a.l r2 = b.a.a.a.c.h()
            java.lang.String r3 = "Beta"
            java.lang.String r4 = "Error closing Beta build properties asset"
            r2.e(r3, r4, r1)
            goto L59
        L67:
            r0 = move-exception
            r2 = r1
            r6 = r1
            r1 = r0
            r0 = r6
        L6c:
            b.a.a.a.l r3 = b.a.a.a.c.h()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r4 = "Beta"
            java.lang.String r5 = "Error reading Beta build properties"
            r3.e(r4, r5, r1)     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto L59
            r2.close()     // Catch: java.io.IOException -> L7d
            goto L59
        L7d:
            r1 = move-exception
            b.a.a.a.l r2 = b.a.a.a.c.h()
            java.lang.String r3 = "Beta"
            java.lang.String r4 = "Error closing Beta build properties asset"
            r2.e(r3, r4, r1)
            goto L59
        L8a:
            r0 = move-exception
            r2 = r1
        L8c:
            if (r2 == 0) goto L91
            r2.close()     // Catch: java.io.IOException -> L92
        L91:
            throw r0
        L92:
            r1 = move-exception
            b.a.a.a.l r2 = b.a.a.a.c.h()
            java.lang.String r3 = "Beta"
            java.lang.String r4 = "Error closing Beta build properties asset"
            r2.e(r3, r4, r1)
            goto L91
        L9f:
            r0 = move-exception
            goto L8c
        La1:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L6c
        La6:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L6c
        Lab:
            r0 = r1
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.beta.Beta.loadBuildProperties(android.content.Context):com.crashlytics.android.beta.BuildProperties");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getOverridenSpiEndpoint() {
        return b.a.a.a.a.b.i.b(getContext(), CRASHLYTICS_API_ENDPOINT);
    }
}

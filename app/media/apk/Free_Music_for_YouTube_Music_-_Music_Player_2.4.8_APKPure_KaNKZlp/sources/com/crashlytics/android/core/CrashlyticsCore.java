package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import b.a.a.a.a.b.g;
import b.a.a.a.a.b.j;
import b.a.a.a.a.b.n;
import b.a.a.a.a.c.d;
import b.a.a.a.a.c.l;
import b.a.a.a.a.c.m;
import b.a.a.a.a.e.e;
import b.a.a.a.a.f.a;
import b.a.a.a.a.f.b;
import b.a.a.a.a.g.o;
import b.a.a.a.a.g.p;
import b.a.a.a.a.g.q;
import b.a.a.a.a.g.t;
import b.a.a.a.c;
import b.a.a.a.i;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.CrashPromptDialog;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;
@d(a = {CrashEventDataProvider.class})
/* loaded from: classes.dex */
public class CrashlyticsCore extends i<Void> {
    static final float CLS_DEFAULT_PROCESS_DELAY = 1.0f;
    static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
    static final String COLLECT_CUSTOM_LOGS = "com.crashlytics.CollectCustomLogs";
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    private static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final boolean SHOULD_PROMPT_BEFORE_SENDING_REPORTS_DEFAULT = false;
    public static final String TAG = "CrashlyticsCore";
    private String apiKey;
    private final ConcurrentHashMap<String, String> attributes;
    private String buildId;
    private CrashlyticsFileMarker crashMarker;
    private float delay;
    private boolean disabled;
    private CrashlyticsExecutorServiceWrapper executorServiceWrapper;
    private CrashEventDataProvider externalCrashEventDataProvider;
    private a fileStore;
    private CrashlyticsUncaughtExceptionHandler handler;
    private e httpRequestFactory;
    private CrashlyticsFileMarker initializationMarker;
    private String installerPackageName;
    private CrashlyticsListener listener;
    private String packageName;
    private final PinningInfoProvider pinningInfo;
    private File sdkDir;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;
    private String versionCode;
    private String versionName;

    /* loaded from: classes.dex */
    public static class Builder {
        private float delay = -1.0f;
        private boolean disabled = false;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public Builder delay(float f) {
            if (f <= 0.0f) {
                throw new IllegalArgumentException("delay must be greater than 0");
            }
            if (this.delay > 0.0f) {
                throw new IllegalStateException("delay already set.");
            }
            this.delay = f;
            return this;
        }

        public Builder listener(CrashlyticsListener crashlyticsListener) {
            if (crashlyticsListener == null) {
                throw new IllegalArgumentException("listener must not be null.");
            }
            if (this.listener != null) {
                throw new IllegalStateException("listener already set.");
            }
            this.listener = crashlyticsListener;
            return this;
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider) {
            if (pinningInfoProvider == null) {
                throw new IllegalArgumentException("pinningInfoProvider must not be null.");
            }
            if (this.pinningInfoProvider != null) {
                throw new IllegalStateException("pinningInfoProvider already set.");
            }
            this.pinningInfoProvider = pinningInfoProvider;
            return this;
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        public CrashlyticsCore build() {
            if (this.delay < 0.0f) {
                this.delay = 1.0f;
            }
            return new CrashlyticsCore(this.delay, this.listener, this.pinningInfoProvider, this.disabled);
        }
    }

    public CrashlyticsCore() {
        this(1.0f, null, null, false);
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z) {
        this(f, crashlyticsListener, pinningInfoProvider, z, n.a("Crashlytics Exception Handler"));
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.userEmail = null;
        this.userName = null;
        this.delay = f;
        this.listener = crashlyticsListener == null ? new NoOpListener() : crashlyticsListener;
        this.pinningInfo = pinningInfoProvider;
        this.disabled = z;
        this.executorServiceWrapper = new CrashlyticsExecutorServiceWrapper(executorService);
        this.attributes = new ConcurrentHashMap<>();
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.a.a.i
    public boolean onPreExecute() {
        return onPreExecute(super.getContext());
    }

    boolean onPreExecute(Context context) {
        if (this.disabled) {
            return false;
        }
        this.apiKey = new g().a(context);
        if (this.apiKey != null) {
            this.buildId = b.a.a.a.a.b.i.m(context);
            if (!isBuildIdValid(this.buildId, b.a.a.a.a.b.i.a(context, CRASHLYTICS_REQUIRE_BUILD_ID, true))) {
                throw new m(MISSING_BUILD_ID_MSG);
            }
            c.h().c(TAG, "Initializing Crashlytics " + getVersion());
            this.fileStore = new b(this);
            this.crashMarker = new CrashlyticsFileMarker(CRASH_MARKER_FILE_NAME, this.fileStore);
            this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, this.fileStore);
            try {
                setAndValidateKitProperties(context);
                ManifestUnityVersionProvider manifestUnityVersionProvider = new ManifestUnityVersionProvider(context, getPackageName());
                boolean didPreviousInitializationFail = didPreviousInitializationFail();
                checkForPreviousCrash();
                if (installExceptionHandler(manifestUnityVersionProvider)) {
                    if (didPreviousInitializationFail && b.a.a.a.a.b.i.n(context)) {
                        finishInitSynchronously();
                        return false;
                    }
                    return true;
                }
                return false;
            } catch (Exception e) {
                c.h().e(TAG, "Crashlytics was not started due to an exception during initialization", e);
                return false;
            }
        }
        return false;
    }

    private void setAndValidateKitProperties(Context context) throws PackageManager.NameNotFoundException {
        CrashlyticsPinningInfoProvider crashlyticsPinningInfoProvider = this.pinningInfo != null ? new CrashlyticsPinningInfoProvider(this.pinningInfo) : null;
        this.httpRequestFactory = new b.a.a.a.a.e.b(c.h());
        this.httpRequestFactory.a(crashlyticsPinningInfoProvider);
        this.packageName = context.getPackageName();
        this.installerPackageName = getIdManager().j();
        c.h().a(TAG, "Installer package name is: " + this.installerPackageName);
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.packageName, 0);
        this.versionCode = Integer.toString(packageInfo.versionCode);
        this.versionName = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
    }

    private boolean installExceptionHandler(UnityVersionProvider unityVersionProvider) {
        try {
            c.h().a(TAG, "Installing exception handler...");
            this.handler = new CrashlyticsUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler(), this.executorServiceWrapper, getIdManager(), unityVersionProvider, this.fileStore, this);
            this.handler.openSession();
            Thread.setDefaultUncaughtExceptionHandler(this.handler);
            c.h().a(TAG, "Successfully installed exception handler.");
            return true;
        } catch (Exception e) {
            c.h().e(TAG, "There was a problem installing the exception handler.", e);
            this.handler = null;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.a.a.i
    public Void doInBackground() {
        markInitializationStarted();
        SessionEventData externalCrashEventData = getExternalCrashEventData();
        if (externalCrashEventData != null) {
            this.handler.writeExternalCrashEvent(externalCrashEventData);
        }
        this.handler.cleanInvalidTempFiles();
        try {
            t b2 = q.a().b();
            if (b2 == null) {
                c.h().d(TAG, "Received null settings, skipping initialization!");
            } else if (b2.d.f232c) {
                this.handler.finalizeSessions();
                CreateReportSpiCall createReportSpiCall = getCreateReportSpiCall(b2);
                if (createReportSpiCall == null) {
                    c.h().d(TAG, "Unable to create a call to upload reports.");
                    markInitializationComplete();
                } else {
                    new ReportUploader(this.apiKey, createReportSpiCall).uploadReports(this.delay);
                    markInitializationComplete();
                }
            } else {
                c.h().a(TAG, "Collection of crash reports disabled in Crashlytics settings.");
                markInitializationComplete();
            }
        } catch (Exception e) {
            c.h().e(TAG, "Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            markInitializationComplete();
        }
        return null;
    }

    @Override // b.a.a.a.i
    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    @Override // b.a.a.a.i
    public String getVersion() {
        return "2.3.14.151";
    }

    public static CrashlyticsCore getInstance() {
        return (CrashlyticsCore) c.a(CrashlyticsCore.class);
    }

    public PinningInfoProvider getPinningInfoProvider() {
        if (this.disabled) {
            return null;
        }
        return this.pinningInfo;
    }

    public void logException(Throwable th) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging exceptions.")) {
            if (th == null) {
                c.h().a(5, TAG, "Crashlytics is ignoring a request to log a null exception.");
            } else {
                this.handler.writeNonFatalException(Thread.currentThread(), th);
            }
        }
    }

    public void log(String str) {
        doLog(3, TAG, str);
    }

    private void doLog(int i, String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging messages.")) {
            this.handler.writeToLog(System.currentTimeMillis() - this.startTime, formatLogMessage(i, str, str2));
        }
    }

    public void log(int i, String str, String str2) {
        doLog(i, str, str2);
        c.h().a(i, "" + str, "" + str2, true);
    }

    public void setUserIdentifier(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userId = sanitizeAttribute(str);
            this.handler.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserName(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userName = sanitizeAttribute(str);
            this.handler.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserEmail(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userEmail = sanitizeAttribute(str);
            this.handler.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setString(String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting keys.")) {
            if (str == null) {
                Context context = getContext();
                if (context != null && b.a.a.a.a.b.i.i(context)) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
                c.h().e(TAG, "Attempting to set custom attribute with null key, ignoring.", null);
                return;
            }
            String sanitizeAttribute = sanitizeAttribute(str);
            if (this.attributes.size() >= 64 && !this.attributes.containsKey(sanitizeAttribute)) {
                c.h().a(TAG, "Exceeded maximum number of custom attributes (64)");
                return;
            }
            this.attributes.put(sanitizeAttribute, str2 == null ? "" : sanitizeAttribute(str2));
            this.handler.cacheKeyData(this.attributes);
        }
    }

    public void setBool(String str, boolean z) {
        setString(str, Boolean.toString(z));
    }

    public void setDouble(String str, double d) {
        setString(str, Double.toString(d));
    }

    public void setFloat(String str, float f) {
        setString(str, Float.toString(f));
    }

    public void setInt(String str, int i) {
        setString(str, Integer.toString(i));
    }

    public void setLong(String str, long j) {
        setString(str, Long.toString(j));
    }

    public void crash() {
        new CrashTest().indexOutOfBounds();
    }

    public boolean verifyPinning(URL url) {
        try {
            return internalVerifyPinning(url);
        } catch (Exception e) {
            c.h().e(TAG, "Could not verify SSL pinning", e);
            return false;
        }
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        c.h().d(TAG, "Use of setListener is deprecated.");
        if (crashlyticsListener == null) {
            throw new IllegalArgumentException("listener must not be null.");
        }
        this.listener = crashlyticsListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void recordLoggedExceptionEvent(String str, String str2) {
        Answers answers = (Answers) c.a(Answers.class);
        if (answers != null) {
            answers.onException(new j.b(str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void recordFatalExceptionEvent(String str, String str2) {
        Answers answers = (Answers) c.a(Answers.class);
        if (answers != null) {
            answers.onException(new j.a(str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getInstallerPackageName() {
        return this.installerPackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getVersionName() {
        return this.versionName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getVersionCode() {
        return this.versionCode;
    }

    String getOverridenSpiEndpoint() {
        return b.a.a.a.a.b.i.b(getContext(), CRASHLYTICS_API_ENDPOINT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBuildId() {
        return this.buildId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashlyticsUncaughtExceptionHandler getHandler() {
        return this.handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserIdentifier() {
        if (getIdManager().a()) {
            return this.userId;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserEmail() {
        if (getIdManager().a()) {
            return this.userEmail;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserName() {
        if (getIdManager().a()) {
            return this.userName;
        }
        return null;
    }

    private void finishInitSynchronously() {
        b.a.a.a.a.c.g<Void> gVar = new b.a.a.a.a.c.g<Void>() { // from class: com.crashlytics.android.core.CrashlyticsCore.1
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                return CrashlyticsCore.this.doInBackground();
            }

            @Override // b.a.a.a.a.c.j, b.a.a.a.a.c.i
            public b.a.a.a.a.c.e getPriority() {
                return b.a.a.a.a.c.e.IMMEDIATE;
            }
        };
        for (l lVar : getDependencies()) {
            gVar.addDependency(lVar);
        }
        Future submit = getFabric().f().submit(gVar);
        c.h().a(TAG, "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            c.h().e(TAG, "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            c.h().e(TAG, "Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            c.h().e(TAG, "Crashlytics timed out during initialization.", e3);
        }
    }

    void markInitializationStarted() {
        this.executorServiceWrapper.executeSyncLoggingException(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsCore.2
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                CrashlyticsCore.this.initializationMarker.create();
                c.h().a(CrashlyticsCore.TAG, "Initialization marker file created.");
                return null;
            }
        });
    }

    void markInitializationComplete() {
        this.executorServiceWrapper.executeAsync(new Callable<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsCore.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                try {
                    boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                    c.h().a(CrashlyticsCore.TAG, "Initialization marker file removed: " + remove);
                    return Boolean.valueOf(remove);
                } catch (Exception e) {
                    c.h().e(CrashlyticsCore.TAG, "Problem encountered deleting Crashlytics initialization marker.", e);
                    return false;
                }
            }
        });
    }

    boolean didPreviousInitializationFail() {
        return ((Boolean) this.executorServiceWrapper.executeSyncLoggingException(new Callable<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsCore.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                return Boolean.valueOf(CrashlyticsCore.this.initializationMarker.isPresent());
            }
        })).booleanValue();
    }

    void setExternalCrashEventDataProvider(CrashEventDataProvider crashEventDataProvider) {
        this.externalCrashEventDataProvider = crashEventDataProvider;
    }

    SessionEventData getExternalCrashEventData() {
        if (this.externalCrashEventDataProvider == null) {
            return null;
        }
        return this.externalCrashEventDataProvider.getCrashEventData();
    }

    boolean internalVerifyPinning(URL url) {
        if (getPinningInfoProvider() != null) {
            b.a.a.a.a.e.d a2 = this.httpRequestFactory.a(b.a.a.a.a.e.c.GET, url.toString());
            ((HttpsURLConnection) a2.a()).setInstanceFollowRedirects(false);
            a2.b();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File getSdkDirectory() {
        if (this.sdkDir == null) {
            this.sdkDir = new b(this).a();
        }
        return this.sdkDir;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldPromptUserBeforeSendingCrashReports() {
        return ((Boolean) q.a().a(new q.b<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsCore.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // b.a.a.a.a.g.q.b
            public Boolean usingSettings(t tVar) {
                if (tVar.d.f230a) {
                    return Boolean.valueOf(CrashlyticsCore.this.shouldSendReportsWithoutPrompting() ? false : true);
                }
                return false;
            }
        }, false)).booleanValue();
    }

    boolean shouldSendReportsWithoutPrompting() {
        return new b.a.a.a.a.f.d(this).a().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
    }

    @SuppressLint({"CommitPrefEdits"})
    void setShouldSendUserReportsWithoutPrompting(boolean z) {
        b.a.a.a.a.f.d dVar = new b.a.a.a.a.f.d(this);
        dVar.a(dVar.b().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canSendWithUserApproval() {
        return ((Boolean) q.a().a(new q.b<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsCore.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // b.a.a.a.a.g.q.b
            public Boolean usingSettings(t tVar) {
                boolean z = true;
                Activity b2 = CrashlyticsCore.this.getFabric().b();
                if (b2 != null && !b2.isFinishing() && CrashlyticsCore.this.shouldPromptUserBeforeSendingCrashReports()) {
                    z = CrashlyticsCore.this.getSendDecisionFromUser(b2, tVar.f251c);
                }
                return Boolean.valueOf(z);
            }
        }, true)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateReportSpiCall getCreateReportSpiCall(t tVar) {
        if (tVar != null) {
            return new DefaultCreateReportSpiCall(this, getOverridenSpiEndpoint(), tVar.f249a.d, this.httpRequestFactory);
        }
        return null;
    }

    private void checkForPreviousCrash() {
        if (Boolean.TRUE.equals((Boolean) this.executorServiceWrapper.executeSyncLoggingException(new CrashMarkerCheck(this.crashMarker)))) {
            try {
                this.listener.crashlyticsDidDetectCrashDuringPreviousExecution();
            } catch (Exception e) {
                c.h().e(TAG, "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createCrashMarker() {
        this.crashMarker.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getSendDecisionFromUser(Activity activity, o oVar) {
        final CrashPromptDialog create = CrashPromptDialog.create(activity, oVar, new CrashPromptDialog.AlwaysSendCallback() { // from class: com.crashlytics.android.core.CrashlyticsCore.7
            @Override // com.crashlytics.android.core.CrashPromptDialog.AlwaysSendCallback
            public void sendUserReportsWithoutPrompting(boolean z) {
                CrashlyticsCore.this.setShouldSendUserReportsWithoutPrompting(z);
            }
        });
        activity.runOnUiThread(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsCore.8
            @Override // java.lang.Runnable
            public void run() {
                create.show();
            }
        });
        c.h().a(TAG, "Waiting for user opt-in.");
        create.await();
        return create.getOptIn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p getSessionSettingsData() {
        t b2 = q.a().b();
        if (b2 == null) {
            return null;
        }
        return b2.f250b;
    }

    private static String formatLogMessage(int i, String str, String str2) {
        return b.a.a.a.a.b.i.b(i) + "/" + str + " " + str2;
    }

    private static boolean ensureFabricWithCalled(String str) {
        CrashlyticsCore crashlyticsCore = getInstance();
        if (crashlyticsCore == null || crashlyticsCore.handler == null) {
            c.h().e(TAG, "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
            return false;
        }
        return true;
    }

    private static String sanitizeAttribute(String str) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() > 1024) {
                return trim.substring(0, 1024);
            }
            return trim;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class CrashMarkerCheck implements Callable<Boolean> {
        private final CrashlyticsFileMarker crashMarker;

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.crashMarker = crashlyticsFileMarker;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            if (!this.crashMarker.isPresent()) {
                return Boolean.FALSE;
            }
            c.h().a(CrashlyticsCore.TAG, "Found previous crash marker.");
            this.crashMarker.remove();
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes.dex */
    private static final class NoOpListener implements CrashlyticsListener {
        private NoOpListener() {
        }

        @Override // com.crashlytics.android.core.CrashlyticsListener
        public void crashlyticsDidDetectCrashDuringPreviousExecution() {
        }
    }

    static boolean isBuildIdValid(String str, boolean z) {
        if (!z) {
            c.h().a(TAG, "Configured not to require a build ID.");
            return true;
        } else if (b.a.a.a.a.b.i.c(str)) {
            Log.e(TAG, ".");
            Log.e(TAG, ".     |  | ");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".   \\ |  | /");
            Log.e(TAG, ".    \\    /");
            Log.e(TAG, ".     \\  /");
            Log.e(TAG, ".      \\/");
            Log.e(TAG, ".");
            Log.e(TAG, MISSING_BUILD_ID_MSG);
            Log.e(TAG, ".");
            Log.e(TAG, ".      /\\");
            Log.e(TAG, ".     /  \\");
            Log.e(TAG, ".    /    \\");
            Log.e(TAG, ".   / |  | \\");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".");
            return false;
        } else {
            return true;
        }
    }
}

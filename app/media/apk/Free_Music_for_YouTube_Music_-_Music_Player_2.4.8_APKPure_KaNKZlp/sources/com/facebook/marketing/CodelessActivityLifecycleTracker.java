package com.facebook.marketing;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.facebook.marketing.internal.ButtonIndexer;
/* loaded from: classes.dex */
public class CodelessActivityLifecycleTracker {
    private static final String TAG = CodelessActivityLifecycleTracker.class.getCanonicalName();
    private static Boolean isAppIndexingEnabled = false;
    private static final ButtonIndexer buttonIndexer = new ButtonIndexer();

    public static void startTracking(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.facebook.marketing.CodelessActivityLifecycleTracker.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                CodelessActivityLifecycleTracker.buttonIndexer.add(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                CodelessActivityLifecycleTracker.buttonIndexer.remove(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }

    public static boolean getIsAppIndexingEnabled() {
        return isAppIndexingEnabled.booleanValue();
    }

    public static void updateAppIndexing(Boolean bool) {
        isAppIndexingEnabled = bool;
    }
}

package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
/* loaded from: classes.dex */
public abstract class d0 {
    public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        e4.e.f(activity, "activity");
        e4.e.f(activityLifecycleCallbacks, "callback");
        activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}

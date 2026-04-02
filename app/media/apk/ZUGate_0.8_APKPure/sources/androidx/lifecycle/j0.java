package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* loaded from: classes.dex */
public final class j0 implements Application.ActivityLifecycleCallbacks {
    public static final i0 Companion = new i0();

    public static final void registerIn(Activity activity) {
        Companion.getClass();
        e4.e.f(activity, "activity");
        activity.registerActivityLifecycleCallbacks(new j0());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        e4.e.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        e4.e.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        e4.e.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(Activity activity, Bundle bundle) {
        e4.e.f(activity, "activity");
        int i5 = k0.f1113h;
        p3.e.e(activity, m.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        e4.e.f(activity, "activity");
        int i5 = k0.f1113h;
        p3.e.e(activity, m.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        e4.e.f(activity, "activity");
        int i5 = k0.f1113h;
        p3.e.e(activity, m.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(Activity activity) {
        e4.e.f(activity, "activity");
        int i5 = k0.f1113h;
        p3.e.e(activity, m.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        e4.e.f(activity, "activity");
        int i5 = k0.f1113h;
        p3.e.e(activity, m.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
        e4.e.f(activity, "activity");
        int i5 = k0.f1113h;
        p3.e.e(activity, m.ON_STOP);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        e4.e.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        e4.e.f(activity, "activity");
        e4.e.f(bundle, "bundle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        e4.e.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        e4.e.f(activity, "activity");
    }
}

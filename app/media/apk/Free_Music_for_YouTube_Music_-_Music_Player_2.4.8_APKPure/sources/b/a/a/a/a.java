package b.a.a.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;
/* compiled from: ActivityLifecycleManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Application f78a;

    /* renamed from: b  reason: collision with root package name */
    private C0008a f79b;

    /* compiled from: ActivityLifecycleManager.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }
    }

    public a(Context context) {
        this.f78a = (Application) context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.f79b = new C0008a(this.f78a);
        }
    }

    public boolean a(b bVar) {
        return this.f79b != null && this.f79b.a(bVar);
    }

    public void a() {
        if (this.f79b == null) {
            return;
        }
        this.f79b.a();
    }

    /* compiled from: ActivityLifecycleManager.java */
    /* renamed from: b.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0008a {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Application.ActivityLifecycleCallbacks> f80a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private final Application f81b;

        C0008a(Application application) {
            this.f81b = application;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(14)
        public void a() {
            for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.f80a) {
                this.f81b.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(14)
        public boolean a(final b bVar) {
            if (this.f81b != null) {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: b.a.a.a.a.a.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        bVar.onActivityCreated(activity, bundle);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        bVar.onActivityStarted(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        bVar.onActivityResumed(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        bVar.onActivityPaused(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        bVar.onActivityStopped(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        bVar.onActivitySaveInstanceState(activity, bundle);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        bVar.onActivityDestroyed(activity);
                    }
                };
                this.f81b.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                this.f80a.add(activityLifecycleCallbacks);
                return true;
            }
            return false;
        }
    }
}

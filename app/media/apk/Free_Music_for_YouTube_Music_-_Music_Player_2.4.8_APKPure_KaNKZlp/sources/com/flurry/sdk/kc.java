package com.flurry.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.flurry.sdk.kb;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class kc {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2034a = kc.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static kc f2035b;

    /* renamed from: c  reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f2036c;

    private kc() {
        if (Build.VERSION.SDK_INT < 14 || this.f2036c != null) {
            return;
        }
        Context context = jy.a().f2022a;
        if (!(context instanceof Application)) {
            return;
        }
        this.f2036c = new Application.ActivityLifecycleCallbacks() { // from class: com.flurry.sdk.kc.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                km.a(3, kc.f2034a, "onActivityCreated for activity:" + activity);
                a(activity, kb.a.kCreated);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStarted(Activity activity) {
                km.a(3, kc.f2034a, "onActivityStarted for activity:" + activity);
                a(activity, kb.a.kStarted);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                km.a(3, kc.f2034a, "onActivityResumed for activity:" + activity);
                a(activity, kb.a.kResumed);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity) {
                km.a(3, kc.f2034a, "onActivityPaused for activity:" + activity);
                a(activity, kb.a.kPaused);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStopped(Activity activity) {
                km.a(3, kc.f2034a, "onActivityStopped for activity:" + activity);
                a(activity, kb.a.kStopped);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                km.a(3, kc.f2034a, "onActivitySaveInstanceState for activity:" + activity);
                a(activity, kb.a.kSaveState);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity) {
                km.a(3, kc.f2034a, "onActivityDestroyed for activity:" + activity);
                a(activity, kb.a.kDestroyed);
            }

            private static void a(Activity activity, kb.a aVar) {
                kb kbVar = new kb();
                kbVar.f2029a = new WeakReference<>(activity);
                kbVar.f2030b = aVar;
                kbVar.b();
            }
        };
        ((Application) context).registerActivityLifecycleCallbacks(this.f2036c);
    }

    public static synchronized kc a() {
        kc kcVar;
        synchronized (kc.class) {
            if (f2035b == null) {
                f2035b = new kc();
            }
            kcVar = f2035b;
        }
        return kcVar;
    }

    public final boolean b() {
        return this.f2036c != null;
    }
}

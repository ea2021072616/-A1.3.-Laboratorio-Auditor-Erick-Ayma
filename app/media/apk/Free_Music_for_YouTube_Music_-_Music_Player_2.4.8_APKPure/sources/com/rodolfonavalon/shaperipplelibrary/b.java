package com.rodolfonavalon.shaperipplelibrary;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
/* compiled from: LifeCycleManager.java */
@TargetApi(14)
/* loaded from: classes2.dex */
class b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private ShapeRipple f5118a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f5119b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ShapeRipple shapeRipple) {
        this.f5118a = shapeRipple;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f5118a == null) {
            a.b("Shape Ripple is null, activity listener is not attached!!");
            return;
        }
        this.f5119b = a(this.f5118a.getContext());
        this.f5119b.getApplication().registerActivityLifecycleCallbacks(this);
    }

    private void b() {
        if (this.f5119b != null) {
            this.f5119b.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.f5118a != null && this.f5119b == activity) {
            this.f5118a.d();
            a.a("Activity is Resumed");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.f5118a != null && this.f5119b == activity) {
            this.f5118a.a();
            a.a("Activity is Paused");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.f5119b == activity) {
            b();
            a.a("Activity is Destroyed");
        }
    }

    private Activity a(Context context) {
        for (Context context2 = context; context2 instanceof ContextWrapper; context2 = ((ContextWrapper) context2).getBaseContext()) {
            if (context2 instanceof Activity) {
                return (Activity) context2;
            }
        }
        throw new IllegalArgumentException("Context does not derived from any activity, Do not use the Application Context!!");
    }
}

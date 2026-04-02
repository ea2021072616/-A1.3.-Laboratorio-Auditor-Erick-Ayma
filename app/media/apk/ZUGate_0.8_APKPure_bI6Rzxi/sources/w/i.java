package w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* loaded from: classes.dex */
public final class i implements Application.ActivityLifecycleCallbacks {

    /* renamed from: g  reason: collision with root package name */
    public Object f5251g;

    /* renamed from: h  reason: collision with root package name */
    public Activity f5252h;

    /* renamed from: i  reason: collision with root package name */
    public final int f5253i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5254j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5255k = false;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5256l = false;

    public i(Activity activity) {
        this.f5252h = activity;
        this.f5253i = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f5252h == activity) {
            this.f5252h = null;
            this.f5255k = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivityPaused(android.app.Activity r6) {
        /*
            r5 = this;
            boolean r0 = r5.f5255k
            if (r0 == 0) goto L43
            boolean r0 = r5.f5256l
            if (r0 != 0) goto L43
            boolean r0 = r5.f5254j
            if (r0 != 0) goto L43
            java.lang.Object r0 = r5.f5251g
            r1 = 1
            java.lang.reflect.Field r2 = w.j.f5259c     // Catch: java.lang.Throwable -> L33
            java.lang.Object r2 = r2.get(r6)     // Catch: java.lang.Throwable -> L33
            if (r2 != r0) goto L3b
            int r0 = r6.hashCode()     // Catch: java.lang.Throwable -> L33
            int r3 = r5.f5253i
            if (r0 == r3) goto L20
            goto L3b
        L20:
            java.lang.reflect.Field r0 = w.j.f5258b     // Catch: java.lang.Throwable -> L33
            java.lang.Object r6 = r0.get(r6)     // Catch: java.lang.Throwable -> L33
            android.os.Handler r0 = w.j.f5263g     // Catch: java.lang.Throwable -> L33
            androidx.appcompat.widget.k r3 = new androidx.appcompat.widget.k     // Catch: java.lang.Throwable -> L33
            r4 = 4
            r3.<init>(r6, r2, r4)     // Catch: java.lang.Throwable -> L33
            r0.postAtFrontOfQueue(r3)     // Catch: java.lang.Throwable -> L33
            r6 = r1
            goto L3c
        L33:
            r6 = move-exception
            java.lang.String r0 = "ActivityRecreator"
            java.lang.String r2 = "Exception while fetching field values"
            android.util.Log.e(r0, r2, r6)
        L3b:
            r6 = 0
        L3c:
            if (r6 == 0) goto L43
            r5.f5256l = r1
            r6 = 0
            r5.f5251g = r6
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w.i.onActivityPaused(android.app.Activity):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f5252h == activity) {
            this.f5254j = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}

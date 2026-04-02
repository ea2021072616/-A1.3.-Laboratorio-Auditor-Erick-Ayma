package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
/* loaded from: classes.dex */
public final class f0 extends g {
    final /* synthetic */ h0 this$0;

    public f0(h0 h0Var) {
        this.this$0 = h0Var;
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        e4.e.f(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i5 = k0.f1113h;
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            e4.e.d(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((k0) findFragmentByTag).f1114g = this.this$0.f1112n;
        }
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        e4.e.f(activity, "activity");
        h0 h0Var = this.this$0;
        int i5 = h0Var.f1106h - 1;
        h0Var.f1106h = i5;
        if (i5 == 0) {
            Handler handler = h0Var.f1109k;
            e4.e.c(handler);
            handler.postDelayed(h0Var.f1111m, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        e4.e.f(activity, "activity");
        d0.a(activity, new e0(this.this$0));
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        e4.e.f(activity, "activity");
        h0 h0Var = this.this$0;
        int i5 = h0Var.f1105g - 1;
        h0Var.f1105g = i5;
        if (i5 == 0 && h0Var.f1107i) {
            h0Var.f1110l.e(m.ON_STOP);
            h0Var.f1108j = true;
        }
    }
}

package androidx.lifecycle;

import android.app.Activity;
/* loaded from: classes.dex */
public final class e0 extends g {
    final /* synthetic */ h0 this$0;

    public e0(h0 h0Var) {
        this.this$0 = h0Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        e4.e.f(activity, "activity");
        this.this$0.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        e4.e.f(activity, "activity");
        h0 h0Var = this.this$0;
        int i5 = h0Var.f1105g + 1;
        h0Var.f1105g = i5;
        if (i5 == 1 && h0Var.f1108j) {
            h0Var.f1110l.e(m.ON_START);
            h0Var.f1108j = false;
        }
    }
}

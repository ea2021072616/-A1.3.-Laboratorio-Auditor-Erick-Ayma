package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes.dex */
public final class k0 extends Fragment {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ int f1113h = 0;

    /* renamed from: g  reason: collision with root package name */
    public g0 f1114g;

    public final void a(m mVar) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            e4.e.e(activity, "activity");
            p3.e.e(activity, mVar);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(m.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(m.ON_DESTROY);
        this.f1114g = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(m.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        g0 g0Var = this.f1114g;
        if (g0Var != null) {
            g0Var.f1104a.a();
        }
        a(m.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        g0 g0Var = this.f1114g;
        if (g0Var != null) {
            h0 h0Var = g0Var.f1104a;
            int i5 = h0Var.f1105g + 1;
            h0Var.f1105g = i5;
            if (i5 == 1 && h0Var.f1108j) {
                h0Var.f1110l.e(m.ON_START);
                h0Var.f1108j = false;
            }
        }
        a(m.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(m.ON_STOP);
    }
}

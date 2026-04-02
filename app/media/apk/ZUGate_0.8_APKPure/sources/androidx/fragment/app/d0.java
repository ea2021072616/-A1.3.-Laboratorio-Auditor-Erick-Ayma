package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class d0 extends ComponentActivity implements w.e, w.f {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final h0 mFragments;
    boolean mResumed;
    final androidx.lifecycle.v mFragmentLifecycleRegistry = new androidx.lifecycle.v(this);
    boolean mStopped = true;

    public d0() {
        final d.q qVar = (d.q) this;
        this.mFragments = new h0(new c0(qVar));
        getSavedStateRegistry().c(LIFECYCLE_TAG, new androidx.activity.f(1, this));
        addOnConfigurationChangedListener(new g0.a() { // from class: androidx.fragment.app.b0
            @Override // g0.a
            public final void a(Object obj) {
                int i5 = r2;
                d0 d0Var = qVar;
                switch (i5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        d0Var.mFragments.a();
                        return;
                    default:
                        Intent intent = (Intent) obj;
                        d0Var.mFragments.a();
                        return;
                }
            }
        });
        addOnNewIntentListener(new g0.a() { // from class: androidx.fragment.app.b0
            @Override // g0.a
            public final void a(Object obj) {
                int i5 = r2;
                d0 d0Var = qVar;
                switch (i5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        d0Var.mFragments.a();
                        return;
                    default:
                        Intent intent = (Intent) obj;
                        d0Var.mFragments.a();
                        return;
                }
            }
        });
        addOnContextAvailableListener(new androidx.activity.g(this, 1));
    }

    public static void d(d0 d0Var) {
        i0 i0Var = d0Var.mFragments.f912a;
        i0Var.f921j.b(i0Var, i0Var, null);
    }

    public static /* synthetic */ Bundle e(d0 d0Var) {
        d0Var.markFragmentsCreated();
        d0Var.mFragmentLifecycleRegistry.e(androidx.lifecycle.m.ON_STOP);
        return new Bundle();
    }

    public static boolean f(w0 w0Var) {
        boolean z4 = false;
        for (Fragment fragment : w0Var.f1027c.f()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z4 |= f(fragment.getChildFragmentManager());
                }
                p1 p1Var = fragment.mViewLifecycleOwner;
                androidx.lifecycle.n nVar = androidx.lifecycle.n.STARTED;
                if (p1Var != null) {
                    p1Var.b();
                    if (p1Var.f970j.f1151c.compareTo(nVar) >= 0) {
                        fragment.mViewLifecycleOwner.f970j.g();
                        z4 = true;
                    }
                }
                if (fragment.mLifecycleRegistry.f1151c.compareTo(nVar) >= 0) {
                    fragment.mLifecycleRegistry.g();
                    z4 = true;
                }
            }
        }
        return z4;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f912a.f921j.f1030f.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                x0.a.a(this).b(str2, printWriter);
            }
            this.mFragments.f912a.f921j.u(str, fileDescriptor, printWriter, strArr);
        }
    }

    public w0 getSupportFragmentManager() {
        return this.mFragments.f912a.f921j;
    }

    @Deprecated
    public x0.a getSupportLoaderManager() {
        return x0.a.a(this);
    }

    public void markFragmentsCreated() {
        do {
        } while (f(getSupportFragmentManager()));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i5, i6, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity, w.o, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.e(androidx.lifecycle.m.ON_CREATE);
        x0 x0Var = this.mFragments.f912a.f921j;
        x0Var.E = false;
        x0Var.F = false;
        x0Var.L.f1082i = false;
        x0Var.t(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f912a.f921j.k();
        this.mFragmentLifecycleRegistry.e(androidx.lifecycle.m.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        if (i5 == 6) {
            return this.mFragments.f912a.f921j.i(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f912a.f921j.t(5);
        this.mFragmentLifecycleRegistry.e(androidx.lifecycle.m.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i5, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f912a.f921j.x(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.e(androidx.lifecycle.m.ON_RESUME);
        x0 x0Var = this.mFragments.f912a.f921j;
        x0Var.E = false;
        x0Var.F = false;
        x0Var.L.f1082i = false;
        x0Var.t(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            x0 x0Var = this.mFragments.f912a.f921j;
            x0Var.E = false;
            x0Var.F = false;
            x0Var.L.f1082i = false;
            x0Var.t(4);
        }
        this.mFragments.f912a.f921j.x(true);
        this.mFragmentLifecycleRegistry.e(androidx.lifecycle.m.ON_START);
        x0 x0Var2 = this.mFragments.f912a.f921j;
        x0Var2.E = false;
        x0Var2.F = false;
        x0Var2.L.f1082i = false;
        x0Var2.t(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        x0 x0Var = this.mFragments.f912a.f921j;
        x0Var.F = true;
        x0Var.L.f1082i = true;
        x0Var.t(4);
        this.mFragmentLifecycleRegistry.e(androidx.lifecycle.m.ON_STOP);
    }

    public void setEnterSharedElementCallback(w.h0 h0Var) {
        w.a.c(this, null);
    }

    public void setExitSharedElementCallback(w.h0 h0Var) {
        w.a.d(this, null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i5, Bundle bundle) {
        if (i5 == -1) {
            startActivityForResult(intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i5, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        if (i5 == -1) {
            startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        w.a.a(this);
    }

    public void supportPostponeEnterTransition() {
        w.a.b(this);
    }

    public void supportStartPostponedEnterTransition() {
        w.a.e(this);
    }

    @Override // w.f
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i5) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i5) {
        startActivityFromFragment(fragment, intent, i5, (Bundle) null);
    }
}

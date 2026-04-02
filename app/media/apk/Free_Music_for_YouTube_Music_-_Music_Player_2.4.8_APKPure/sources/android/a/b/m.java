package android.a.b;

import android.a.b.g;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
/* compiled from: ReportFragment.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class m extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private a f76a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportFragment.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new m(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.f76a);
        a(g.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        b(this.f76a);
        a(g.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f76a);
        a(g.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(g.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(g.a.ON_STOP);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(g.a.ON_DESTROY);
        this.f76a = null;
    }

    private void a(g.a aVar) {
        Activity activity = getActivity();
        if (activity instanceof j) {
            ((j) activity).a().a(aVar);
        } else if (activity instanceof h) {
            g lifecycle = ((h) activity).getLifecycle();
            if (lifecycle instanceof i) {
                ((i) lifecycle).a(aVar);
            }
        }
    }
}

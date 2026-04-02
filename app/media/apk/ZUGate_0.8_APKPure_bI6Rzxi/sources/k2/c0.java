package k2;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class c0 extends Fragment implements f {

    /* renamed from: g  reason: collision with root package name */
    public final Map f3571g = Collections.synchronizedMap(new l.b());

    /* renamed from: h  reason: collision with root package name */
    public int f3572h = 0;

    /* renamed from: i  reason: collision with root package name */
    public Bundle f3573i;

    static {
        new WeakHashMap();
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f3571g.values()) {
            lifecycleCallback.getClass();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        for (LifecycleCallback lifecycleCallback : this.f3571g.values()) {
            lifecycleCallback.b(i5, i6, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3572h = 1;
        this.f3573i = bundle;
        for (Map.Entry entry : this.f3571g.entrySet()) {
            ((LifecycleCallback) entry.getValue()).c(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f3572h = 5;
        for (LifecycleCallback lifecycleCallback : this.f3571g.values()) {
            lifecycleCallback.getClass();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f3572h = 3;
        for (LifecycleCallback lifecycleCallback : this.f3571g.values()) {
            lifecycleCallback.d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f3571g.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).e(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f3572h = 2;
        for (LifecycleCallback lifecycleCallback : this.f3571g.values()) {
            lifecycleCallback.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f3572h = 4;
        for (LifecycleCallback lifecycleCallback : this.f3571g.values()) {
            lifecycleCallback.g();
        }
    }
}

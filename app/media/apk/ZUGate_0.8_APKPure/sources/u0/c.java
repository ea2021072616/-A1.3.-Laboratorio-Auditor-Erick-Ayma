package u0;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w0;
import d.v;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final b f5128a = b.f5125c;

    public static b a(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                e4.e.e(fragment.getParentFragmentManager(), "declaringFragment.parentFragmentManager");
            }
            fragment = fragment.getParentFragment();
        }
        return f5128a;
    }

    public static void b(b bVar, j jVar) {
        Fragment fragment = jVar.f5129b;
        String name = fragment.getClass().getName();
        a aVar = a.PENALTY_LOG;
        Set set = bVar.f5126a;
        if (set.contains(aVar)) {
            Log.d("FragmentStrictMode", "Policy violation in ".concat(name), jVar);
        }
        if (set.contains(a.PENALTY_DEATH)) {
            v vVar = new v(name, 3, jVar);
            if (!fragment.isAdded()) {
                vVar.run();
                return;
            }
            Handler handler = fragment.getParentFragmentManager().f1043t.f920i;
            e4.e.e(handler, "fragment.parentFragmentManager.host.handler");
            if (e4.e.a(handler.getLooper(), Looper.myLooper())) {
                vVar.run();
            } else {
                handler.post(vVar);
            }
        }
    }

    public static void c(j jVar) {
        if (w0.I(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(jVar.f5129b.getClass().getName()), jVar);
        }
    }

    public static final void d(Fragment fragment, String str) {
        e4.e.f(fragment, "fragment");
        e4.e.f(str, "previousFragmentId");
        d dVar = new d(fragment, str);
        c(dVar);
        b a5 = a(fragment);
        if (a5.f5126a.contains(a.DETECT_FRAGMENT_REUSE) && e(a5, fragment.getClass(), d.class)) {
            b(a5, dVar);
        }
    }

    public static boolean e(b bVar, Class cls, Class cls2) {
        Set set = (Set) bVar.f5127b.get(cls.getName());
        if (set == null) {
            return true;
        }
        if (e4.e.a(cls2.getSuperclass(), j.class) || !set.contains(cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}

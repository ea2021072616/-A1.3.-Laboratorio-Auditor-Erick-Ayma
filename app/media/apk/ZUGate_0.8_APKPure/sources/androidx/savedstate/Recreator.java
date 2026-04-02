package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.m;
import androidx.lifecycle.r;
import androidx.lifecycle.r0;
import androidx.lifecycle.t;
import androidx.lifecycle.v0;
import androidx.lifecycle.w0;
import b1.b;
import b1.d;
import b1.f;
import e4.e;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import p2.a;
/* loaded from: classes.dex */
public final class Recreator implements r {

    /* renamed from: a  reason: collision with root package name */
    public final f f1587a;

    public Recreator(f fVar) {
        e.f(fVar, "owner");
        this.f1587a = fVar;
    }

    @Override // androidx.lifecycle.r
    public final void b(t tVar, m mVar) {
        LinkedHashMap linkedHashMap;
        if (mVar != m.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        tVar.getLifecycle().b(this);
        f fVar = this.f1587a;
        Bundle a5 = fVar.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (a5 == null) {
            return;
        }
        ArrayList<String> stringArrayList = a5.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(b.class);
                e.e(asSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object newInstance = declaredConstructor.newInstance(new Object[0]);
                        e.e(newInstance, "{\n                constr…wInstance()\n            }");
                        b bVar = (b) newInstance;
                        if (!(fVar instanceof w0)) {
                            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
                        }
                        v0 viewModelStore = ((w0) fVar).getViewModelStore();
                        d savedStateRegistry = fVar.getSavedStateRegistry();
                        viewModelStore.getClass();
                        Iterator it = new HashSet(viewModelStore.f1157a.keySet()).iterator();
                        while (true) {
                            boolean hasNext = it.hasNext();
                            linkedHashMap = viewModelStore.f1157a;
                            if (!hasNext) {
                                break;
                            }
                            String str2 = (String) it.next();
                            e.f(str2, "key");
                            r0 r0Var = (r0) linkedHashMap.get(str2);
                            e.c(r0Var);
                            a.c(r0Var, savedStateRegistry, fVar.getLifecycle());
                        }
                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                            savedStateRegistry.d();
                        }
                    } catch (Exception e5) {
                        throw new RuntimeException("Failed to instantiate " + str, e5);
                    }
                } catch (NoSuchMethodException e6) {
                    throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e6);
                }
            } catch (ClassNotFoundException e7) {
                throw new RuntimeException("Class " + str + " wasn't found", e7);
            }
        }
    }
}

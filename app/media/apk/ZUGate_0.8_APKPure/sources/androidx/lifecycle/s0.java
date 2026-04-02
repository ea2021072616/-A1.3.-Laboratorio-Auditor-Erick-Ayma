package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public final class s0 extends l2.i {
    public static s0 o;

    /* renamed from: n  reason: collision with root package name */
    public final Application f1146n;

    public s0(Application application) {
        this.f1146n = application;
    }

    @Override // l2.i, androidx.lifecycle.t0
    public final r0 a(Class cls) {
        Application application = this.f1146n;
        if (application != null) {
            return f(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.t0
    public final r0 c(Class cls, w0.e eVar) {
        if (this.f1146n != null) {
            return a(cls);
        }
        Application application = (Application) eVar.f5293a.get(l2.i.f3855i);
        if (application != null) {
            return f(cls, application);
        }
        if (a.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return super.a(cls);
    }

    public final r0 f(Class cls, Application application) {
        if (a.class.isAssignableFrom(cls)) {
            try {
                r0 r0Var = (r0) cls.getConstructor(Application.class).newInstance(application);
                e4.e.e(r0Var, "{\n                try {\n…          }\n            }");
                return r0Var;
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (InstantiationException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            } catch (NoSuchMethodException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException("Cannot create an instance of " + cls, e8);
            }
        }
        return super.a(cls);
    }
}

package e4;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class a implements c4.b, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final c4.b f2702b;

    public a(c4.b bVar) {
        this.f2702b = bVar;
    }

    @Override // c4.b
    public final void c(Object obj) {
        c4.b bVar = this;
        while (true) {
            a aVar = (a) bVar;
            c4.b bVar2 = aVar.f2702b;
            e.c(bVar2);
            try {
                obj = aVar.g(obj);
                if (obj == d4.a.COROUTINE_SUSPENDED) {
                    return;
                }
            } catch (Throwable th) {
                obj = e.h(th);
            }
            aVar.h();
            if (!(bVar2 instanceof a)) {
                bVar2.c(obj);
                return;
            }
            bVar = bVar2;
        }
    }

    public c4.b e(Object obj, c4.b bVar) {
        e.f(bVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public final StackTraceElement f() {
        int i5;
        String str;
        d dVar = (d) getClass().getAnnotation(d.class);
        String str2 = null;
        if (dVar == null) {
            return null;
        }
        int v5 = dVar.v();
        if (v5 > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v5 + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            i5 = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            i5 = -1;
        }
        int i6 = i5 >= 0 ? dVar.l()[i5] : -1;
        d.e eVar = p2.a.f4249d;
        d.e eVar2 = p2.a.f4248c;
        if (eVar == null) {
            try {
                d.e eVar3 = new d.e(Class.class.getDeclaredMethod("getModule", new Class[0]), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]), 13);
                p2.a.f4249d = eVar3;
                eVar = eVar3;
            } catch (Exception unused2) {
                p2.a.f4249d = eVar2;
                eVar = eVar2;
            }
        }
        if (eVar != eVar2) {
            Method method = (Method) eVar.f2321h;
            Object invoke = method != null ? method.invoke(getClass(), new Object[0]) : null;
            if (invoke != null) {
                Method method2 = (Method) eVar.f2322i;
                Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
                if (invoke2 != null) {
                    Method method3 = (Method) eVar.f2323j;
                    Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
                    if (invoke3 instanceof String) {
                        str2 = invoke3;
                    }
                }
            }
        }
        if (str2 == null) {
            str = dVar.c();
        } else {
            str = str2 + '/' + dVar.c();
        }
        return new StackTraceElement(str, dVar.m(), dVar.f(), i6);
    }

    public abstract Object g(Object obj);

    public void h() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object f5 = f();
        if (f5 == null) {
            f5 = getClass().getName();
        }
        sb.append(f5);
        return sb.toString();
    }
}

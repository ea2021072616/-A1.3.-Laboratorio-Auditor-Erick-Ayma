package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final d f1100c = new d();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1101a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f1102b = new HashMap();

    public static void c(HashMap hashMap, c cVar, m mVar, Class cls) {
        m mVar2 = (m) hashMap.get(cVar);
        if (mVar2 == null || mVar == mVar2) {
            if (mVar2 == null) {
                hashMap.put(cVar, mVar);
                return;
            }
            return;
        }
        Method method = cVar.f1099b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + mVar2 + ", new value " + mVar);
    }

    public final b a(Class cls, Method[] methodArr) {
        int i5;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            hashMap.putAll(b(superclass).f1097b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : b(cls2).f1097b.entrySet()) {
                c(hashMap, (c) entry.getKey(), (m) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e5) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e5);
            }
        }
        boolean z4 = false;
        for (Method method : methodArr) {
            c0 c0Var = (c0) method.getAnnotation(c0.class);
            if (c0Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i5 = 0;
                } else if (!t.class.isAssignableFrom(parameterTypes[0])) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i5 = 1;
                }
                m value = c0Var.value();
                if (parameterTypes.length > 1) {
                    if (!m.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != m.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i5 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                c(hashMap, new c(i5, method), value, cls);
                z4 = true;
            }
        }
        b bVar = new b(hashMap);
        this.f1101a.put(cls, bVar);
        this.f1102b.put(cls, Boolean.valueOf(z4));
        return bVar;
    }

    public final b b(Class cls) {
        b bVar = (b) this.f1101a.get(cls);
        return bVar != null ? bVar : a(cls, null);
    }
}

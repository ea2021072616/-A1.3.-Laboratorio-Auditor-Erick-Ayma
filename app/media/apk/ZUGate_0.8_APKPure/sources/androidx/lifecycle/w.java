package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f1158a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap f1159b = new HashMap();

    public static void a(Constructor constructor, Object obj) {
        try {
            Object newInstance = constructor.newInstance(obj);
            e4.e.e(newInstance, "{\n            constructo…tance(`object`)\n        }");
            androidx.appcompat.widget.b0.m(newInstance);
            throw null;
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException(e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        int I0 = p4.d.I0(str, ".", 0, false);
        if (I0 >= 0) {
            int length = (str.length() - 1) + 1;
            if (length < 0) {
                throw new OutOfMemoryError();
            }
            StringBuilder sb2 = new StringBuilder(length);
            int i5 = 0;
            do {
                sb2.append((CharSequence) str, i5, I0);
                sb2.append("_");
                i5 = I0 + 1;
                if (I0 >= str.length()) {
                    break;
                }
                I0 = p4.d.I0(str, ".", i5, false);
            } while (I0 > 0);
            sb2.append((CharSequence) str, i5, str.length());
            str = sb2.toString();
            e4.e.e(str, "stringBuilder.append(this, i, length).toString()");
        }
        return androidx.appcompat.widget.b0.i(sb, str, "_LifecycleAdapter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int c(Class cls) {
        Constructor constructor;
        boolean z4;
        HashMap hashMap = f1158a;
        Integer num = (Integer) hashMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i5 = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r42 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r42 != null ? r42.getName() : "";
                e4.e.e(name, "fullPackage");
                if (!(name.length() == 0)) {
                    e4.e.e(canonicalName, "name");
                    canonicalName = canonicalName.substring(name.length() + 1);
                    e4.e.e(canonicalName, "this as java.lang.String).substring(startIndex)");
                }
                e4.e.e(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String b5 = b(canonicalName);
                if (!(name.length() == 0)) {
                    b5 = name + '.' + b5;
                }
                constructor = Class.forName(b5).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException(e5);
            }
            HashMap hashMap2 = f1159b;
            if (constructor != null) {
                List singletonList = Collections.singletonList(constructor);
                e4.e.e(singletonList, "singletonList(element)");
                hashMap2.put(cls, singletonList);
            } else {
                d dVar = d.f1100c;
                HashMap hashMap3 = dVar.f1102b;
                Boolean bool = (Boolean) hashMap3.get(cls);
                if (bool != null) {
                    z4 = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length) {
                                hashMap3.put(cls, Boolean.FALSE);
                                z4 = false;
                                break;
                            } else if (((c0) declaredMethods[i6].getAnnotation(c0.class)) != null) {
                                dVar.a(cls, declaredMethods);
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                    } catch (NoClassDefFoundError e6) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e6);
                    }
                }
                if (!z4) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && s.class.isAssignableFrom(superclass)) {
                        e4.e.e(superclass, "superclass");
                        if (c(superclass) != 1) {
                            Object obj = hashMap2.get(superclass);
                            e4.e.c(obj);
                            arrayList = new ArrayList((Collection) obj);
                        }
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    e4.e.e(interfaces, "klass.interfaces");
                    int length2 = interfaces.length;
                    int i7 = 0;
                    while (true) {
                        if (i7 < length2) {
                            Class<?> cls2 = interfaces[i7];
                            if (cls2 != null && s.class.isAssignableFrom(cls2)) {
                                e4.e.e(cls2, "intrface");
                                if (c(cls2) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                Object obj2 = hashMap2.get(cls2);
                                e4.e.c(obj2);
                                arrayList.addAll((Collection) obj2);
                            }
                            i7++;
                        } else if (arrayList != null) {
                            hashMap2.put(cls, arrayList);
                        }
                    }
                }
            }
            i5 = 2;
        }
        hashMap.put(cls, Integer.valueOf(i5));
        return i5;
    }
}

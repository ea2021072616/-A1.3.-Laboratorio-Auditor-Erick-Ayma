package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class q0 {

    /* renamed from: a  reason: collision with root package name */
    public static final List f1141a;

    /* renamed from: b  reason: collision with root package name */
    public static final List f1142b;

    static {
        List asList = Arrays.asList(Application.class, m0.class);
        e4.e.e(asList, "asList(this)");
        f1141a = asList;
        List singletonList = Collections.singletonList(m0.class);
        e4.e.e(singletonList, "singletonList(element)");
        f1142b = singletonList;
    }

    public static final Constructor a(Class cls, List list) {
        List list2;
        e4.e.f(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        e4.e.e(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            e4.e.e(parameterTypes, "constructor.parameterTypes");
            int length = parameterTypes.length;
            if (length == 0) {
                list2 = b4.f.f1659b;
            } else if (length != 1) {
                list2 = new ArrayList(new b4.b(parameterTypes));
            } else {
                list2 = Collections.singletonList(parameterTypes[0]);
                e4.e.e(list2, "singletonList(element)");
            }
            if (e4.e.a(list, list2)) {
                return constructor;
            }
            if (list.size() == list2.size() && list2.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final r0 b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (r0) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Failed to access " + cls, e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e7.getCause());
        }
    }
}

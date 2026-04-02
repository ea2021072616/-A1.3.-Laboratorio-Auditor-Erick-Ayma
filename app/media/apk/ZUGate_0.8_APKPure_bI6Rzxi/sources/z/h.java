package z;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import d.u0;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class h extends u0 {

    /* renamed from: i  reason: collision with root package name */
    public static Class f5758i = null;

    /* renamed from: j  reason: collision with root package name */
    public static Constructor f5759j = null;

    /* renamed from: k  reason: collision with root package name */
    public static Method f5760k = null;

    /* renamed from: l  reason: collision with root package name */
    public static Method f5761l = null;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f5762m = false;

    public h() {
        super(12);
    }

    public static boolean D(Object obj, String str, int i5, boolean z4) {
        E();
        try {
            return ((Boolean) f5760k.invoke(obj, str, Integer.valueOf(i5), Boolean.valueOf(z4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static void E() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        if (f5762m) {
            return;
        }
        f5762m = true;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e5) {
            Log.e("TypefaceCompatApi21Impl", e5.getClass().getName(), e5);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f5759j = constructor;
        f5758i = cls;
        f5760k = method2;
        f5761l = method;
    }

    @Override // d.u0
    public Typeface v(Context context, y.f fVar, Resources resources, int i5) {
        y.g[] gVarArr;
        E();
        try {
            Object newInstance = f5759j.newInstance(new Object[0]);
            for (y.g gVar : fVar.f5546a) {
                File o = m0.a.o(context);
                if (o == null) {
                    return null;
                }
                try {
                    if (!m0.a.c(o, resources, gVar.f5552f)) {
                        return null;
                    }
                    if (!D(newInstance, o.getPath(), gVar.f5548b, gVar.f5549c)) {
                        return null;
                    }
                    o.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    o.delete();
                }
            }
            E();
            try {
                Object newInstance2 = Array.newInstance(f5758i, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f5761l.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e5) {
                throw new RuntimeException(e5);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }
}

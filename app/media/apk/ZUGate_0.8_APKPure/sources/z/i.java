package z;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends h {

    /* renamed from: n  reason: collision with root package name */
    public final Class f5763n;
    public final Constructor o;

    /* renamed from: p  reason: collision with root package name */
    public final Method f5764p;

    /* renamed from: q  reason: collision with root package name */
    public final Method f5765q;

    /* renamed from: r  reason: collision with root package name */
    public final Method f5766r;

    /* renamed from: s  reason: collision with root package name */
    public final Method f5767s;

    /* renamed from: t  reason: collision with root package name */
    public final Method f5768t;

    public i() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = J(cls);
            method3 = K(cls);
            method4 = cls.getMethod("freeze", new Class[0]);
            method = cls.getMethod("abortCreation", new Class[0]);
            method5 = L(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e5) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e5.getClass().getName()), e5);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f5763n = cls;
        this.o = constructor;
        this.f5764p = method2;
        this.f5765q = method3;
        this.f5766r = method4;
        this.f5767s = method;
        this.f5768t = method5;
    }

    public static Method J(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public static Method K(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public final boolean F(Context context, Object obj, String str, int i5, int i6, int i7, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f5764p.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface G(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f5763n, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f5768t.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean H(Object obj) {
        try {
            return ((Boolean) this.f5766r.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean I() {
        Method method = this.f5764p;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return method != null;
    }

    public Method L(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // z.h, d.u0
    public final Typeface v(Context context, y.f fVar, Resources resources, int i5) {
        Object obj;
        y.g[] gVarArr;
        if (I()) {
            try {
                obj = this.o.newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                obj = null;
            }
            if (obj == null) {
                return null;
            }
            for (y.g gVar : fVar.f5546a) {
                if (!F(context, obj, gVar.f5547a, gVar.f5551e, gVar.f5548b, gVar.f5549c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(gVar.f5550d))) {
                    try {
                        this.f5767s.invoke(obj, new Object[0]);
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                    return null;
                }
            }
            if (H(obj)) {
                return G(obj);
            }
            return null;
        }
        return super.v(context, fVar, resources, i5);
    }

    @Override // d.u0
    public final Typeface w(Context context, e0.g[] gVarArr, int i5) {
        Object obj;
        Typeface G;
        boolean z4;
        if (gVarArr.length < 1) {
            return null;
        }
        if (!I()) {
            e0.g A = A(i5, gVarArr);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(A.f2577a, "r", null);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(A.f2579c).setItalic(A.f2580d).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        HashMap hashMap = new HashMap();
        for (e0.g gVar : gVarArr) {
            if (gVar.f2581e == 0) {
                Uri uri = gVar.f2577a;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, m0.a.s(context, uri));
                }
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
        try {
            obj = this.o.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused2) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        int length = gVarArr.length;
        int i6 = 0;
        boolean z5 = false;
        while (true) {
            Method method = this.f5767s;
            if (i6 >= length) {
                if (!z5) {
                    try {
                        method.invoke(obj, new Object[0]);
                        return null;
                    } catch (IllegalAccessException | InvocationTargetException unused3) {
                        return null;
                    }
                } else if (H(obj) && (G = G(obj)) != null) {
                    return Typeface.create(G, i5);
                } else {
                    return null;
                }
            }
            e0.g gVar2 = gVarArr[i6];
            ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(gVar2.f2577a);
            if (byteBuffer != null) {
                try {
                    z4 = ((Boolean) this.f5765q.invoke(obj, byteBuffer, Integer.valueOf(gVar2.f2578b), null, Integer.valueOf(gVar2.f2579c), Integer.valueOf(gVar2.f2580d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused4) {
                    z4 = false;
                }
                if (!z4) {
                    try {
                        method.invoke(obj, new Object[0]);
                        return null;
                    } catch (IllegalAccessException | InvocationTargetException unused5) {
                        return null;
                    }
                }
                z5 = true;
            }
            i6++;
            z5 = z5;
        }
    }

    @Override // d.u0
    public final Typeface y(Context context, Resources resources, int i5, String str, int i6) {
        Object obj;
        if (I()) {
            try {
                obj = this.o.newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                obj = null;
            }
            if (obj == null) {
                return null;
            }
            if (!F(context, obj, str, 0, -1, -1, null)) {
                try {
                    this.f5767s.invoke(obj, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
                return null;
            } else if (H(obj)) {
                return G(obj);
            } else {
                return null;
            }
        }
        return super.y(context, resources, i5, str, i6);
    }
}

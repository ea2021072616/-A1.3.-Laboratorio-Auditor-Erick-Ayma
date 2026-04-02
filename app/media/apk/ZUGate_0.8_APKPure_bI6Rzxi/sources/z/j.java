package z;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class j extends i {
    @Override // z.i
    public final Typeface G(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f5763n, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f5768t.invoke(null, newInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // z.i
    public final Method L(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), String.class, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}

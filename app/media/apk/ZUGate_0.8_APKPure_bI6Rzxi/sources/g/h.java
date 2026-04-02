package g;

import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class h implements MenuItem.OnMenuItemClickListener {

    /* renamed from: i  reason: collision with root package name */
    public static final Class[] f2883i = {MenuItem.class};

    /* renamed from: g  reason: collision with root package name */
    public final Object f2884g;

    /* renamed from: h  reason: collision with root package name */
    public final Method f2885h;

    public h(Object obj, String str) {
        this.f2884g = obj;
        Class<?> cls = obj.getClass();
        try {
            this.f2885h = cls.getMethod(str, f2883i);
        } catch (Exception e5) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
            inflateException.initCause(e5);
            throw inflateException;
        }
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Method method = this.f2885h;
        try {
            Class<?> returnType = method.getReturnType();
            Class<?> cls = Boolean.TYPE;
            Object obj = this.f2884g;
            if (returnType == cls) {
                return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
            }
            method.invoke(obj, menuItem);
            return true;
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }
}

package androidx.appcompat.widget;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class x1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f584a;

    /* renamed from: b  reason: collision with root package name */
    public static final Method f585b;

    /* renamed from: c  reason: collision with root package name */
    public static final Method f586c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f587d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
            f584a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f585b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f586c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f587d = true;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        }
    }
}

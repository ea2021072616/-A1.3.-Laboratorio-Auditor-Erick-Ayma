package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* compiled from: EasyPermissions.java */
/* loaded from: classes2.dex */
public class b {

    /* compiled from: EasyPermissions.java */
    /* loaded from: classes2.dex */
    public interface a extends ActivityCompat.OnRequestPermissionsResultCallback {
        void a(int i, List<String> list);

        void b(int i, List<String> list);
    }

    public static boolean a(Context context, @NonNull String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            Log.w("EasyPermissions", "hasPermissions: API version < M, returning true by default");
            return true;
        } else if (context == null) {
            throw new IllegalArgumentException("Can't check permissions for null context");
        } else {
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void a(@NonNull Activity activity, @NonNull String str, int i, @NonNull String... strArr) {
        a(activity, str, 17039370, 17039360, i, strArr);
    }

    public static void a(@NonNull Activity activity, @NonNull String str, @StringRes int i, @StringRes int i2, int i3, @NonNull String... strArr) {
        a(pub.devrel.easypermissions.a.f.a(activity), str, i, i2, i3, strArr);
    }

    private static void a(@NonNull pub.devrel.easypermissions.a.f fVar, @NonNull String str, @StringRes int i, @StringRes int i2, int i3, @NonNull String... strArr) {
        if (a(fVar.b(), strArr)) {
            a(fVar.c(), i3, strArr);
        } else {
            fVar.b(str, i, i2, i3, strArr);
        }
    }

    public static void a(int i, @NonNull String[] strArr, @NonNull int[] iArr, @NonNull Object... objArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (iArr[i2] == 0) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        for (Object obj : objArr) {
            if (!arrayList.isEmpty() && (obj instanceof a)) {
                ((a) obj).a(i, arrayList);
            }
            if (!arrayList2.isEmpty() && (obj instanceof a)) {
                ((a) obj).b(i, arrayList2);
            }
            if (!arrayList.isEmpty() && arrayList2.isEmpty()) {
                a(obj, i);
            }
        }
    }

    public static boolean a(@NonNull Activity activity, @NonNull List<String> list) {
        return pub.devrel.easypermissions.a.f.a(activity).a(list);
    }

    private static void a(@NonNull Object obj, int i, @NonNull String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            iArr[i2] = 0;
        }
        a(i, strArr, iArr, obj);
    }

    private static void a(@NonNull Object obj, int i) {
        Class<?> cls;
        Method[] declaredMethods;
        for (Class<? super Object> superclass = a(obj) ? obj.getClass().getSuperclass() : cls; superclass != null; superclass = superclass.getSuperclass()) {
            for (Method method : superclass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(pub.devrel.easypermissions.a.class) && ((pub.devrel.easypermissions.a) method.getAnnotation(pub.devrel.easypermissions.a.class)).a() == i) {
                    if (method.getParameterTypes().length > 0) {
                        throw new RuntimeException("Cannot execute method " + method.getName() + " because it is non-void method and/or has input parameters.");
                    }
                    try {
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        method.invoke(obj, new Object[0]);
                    } catch (IllegalAccessException e) {
                        Log.e("EasyPermissions", "runDefaultMethod:IllegalAccessException", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("EasyPermissions", "runDefaultMethod:InvocationTargetException", e2);
                    }
                }
            }
        }
    }

    private static boolean a(@NonNull Object obj) {
        if (obj.getClass().getSimpleName().endsWith(b.a.a.a.a.d.b.ROLL_OVER_FILE_NAME_SEPARATOR)) {
            try {
                return Class.forName("org.androidannotations.api.view.HasViews").isInstance(obj);
            } catch (ClassNotFoundException e) {
                return false;
            }
        }
        return false;
    }
}

package h0;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public abstract class v1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Field f3215a;

    /* renamed from: b  reason: collision with root package name */
    public static final Field f3216b;

    /* renamed from: c  reason: collision with root package name */
    public static final Field f3217c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f3218d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f3215a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f3216b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f3217c = declaredField3;
            declaredField3.setAccessible(true);
            f3218d = true;
        } catch (ReflectiveOperationException e5) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e5.getMessage(), e5);
        }
    }
}

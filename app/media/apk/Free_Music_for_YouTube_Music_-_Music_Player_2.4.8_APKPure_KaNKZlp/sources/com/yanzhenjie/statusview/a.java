package com.yanzhenjie.statusview;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* compiled from: StatusUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static void a(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    public static void b(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setNavigationBarColor(i);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 256);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 512);
            window.addFlags(Integer.MIN_VALUE);
            window.setNavigationBarColor(0);
        }
    }

    public static boolean a(Activity activity, boolean z) {
        boolean c2 = c(activity, z);
        if (!c2) {
            c2 = b(activity, z);
        }
        if (!c2 && z && Build.VERSION.SDK_INT >= 23) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            return true;
        } else if (c2 || z || Build.VERSION.SDK_INT < 23) {
            return c2;
        } else {
            View decorView2 = activity.getWindow().getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
            return true;
        }
    }

    private static boolean b(Activity activity, boolean z) {
        int i;
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            if (z) {
                i = i2 | i3;
            } else {
                i = (i2 ^ (-1)) & i3;
            }
            declaredField2.setInt(attributes, i);
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean c(Activity activity, boolean z) {
        Window window = activity.getWindow();
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            if (z) {
                method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } else {
                method.invoke(window, 0, Integer.valueOf(i));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

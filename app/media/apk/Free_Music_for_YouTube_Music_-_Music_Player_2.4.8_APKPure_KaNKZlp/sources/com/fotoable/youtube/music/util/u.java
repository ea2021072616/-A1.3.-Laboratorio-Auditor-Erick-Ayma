package com.fotoable.youtube.music.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: ScreenUtils.java */
/* loaded from: classes.dex */
public class u {
    public static void a(View view) {
        a(view, false);
    }

    public static void a(View view, boolean z) {
        Object tag;
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 24 && !z && (tag = view.getTag()) != null && (tag instanceof Integer)) {
                try {
                    int intValue = ((Integer) tag).intValue();
                    if (intValue <= 3) {
                        view.setTag(Integer.valueOf(intValue + 1));
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
            view.setSystemUiVisibility(14086);
        }
    }

    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static int b(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static boolean c(Context context) {
        boolean z;
        Exception exc;
        boolean z2;
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        } catch (Exception e) {
            z = false;
            exc = e;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
            if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str)) {
                return false;
            }
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
                return true;
            }
            return z2;
        } catch (Exception e2) {
            exc = e2;
            z = z2;
            ThrowableExtension.printStackTrace(exc);
            return z;
        }
    }
}

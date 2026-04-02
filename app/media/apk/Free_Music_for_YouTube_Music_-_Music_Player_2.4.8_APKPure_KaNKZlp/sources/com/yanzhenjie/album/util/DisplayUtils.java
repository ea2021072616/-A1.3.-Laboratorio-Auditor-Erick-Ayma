package com.yanzhenjie.album.util;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
/* loaded from: classes2.dex */
public class DisplayUtils {
    private static boolean isInitialize = false;
    private static float mDensity;
    private static float mScaledDensity;
    public static int sScreenHeight;
    public static int sScreenWidth;

    public static void initScreen(Activity activity) {
        if (!isInitialize) {
            isInitialize = true;
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            sScreenWidth = displayMetrics.widthPixels;
            sScreenHeight = displayMetrics.heightPixels;
            mDensity = displayMetrics.density;
            mScaledDensity = displayMetrics.scaledDensity;
        }
    }

    public static int px2dip(float f) {
        return (int) ((f / mDensity) + 0.5f);
    }

    public static int dip2px(float f) {
        return (int) ((mDensity * f) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / mScaledDensity) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((mScaledDensity * f) + 0.5f);
    }
}

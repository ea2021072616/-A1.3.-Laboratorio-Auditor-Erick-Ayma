package com.pili.pldroid.player.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
/* loaded from: classes.dex */
public final class Util {
    public static final int SDK_INT = Build.VERSION.SDK_INT;

    public static String getUserAgent(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") PLDroidPlayer/" + Config.VERSION;
    }

    public static Pair<Integer, Integer> getResolution(Context context) {
        return Build.VERSION.SDK_INT >= 17 ? getRealResolution(context) : getRealResolutionOnOldDevice(context);
    }

    private static Pair<Integer, Integer> getRealResolutionOnOldDevice(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            return new Pair<>((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0]), (Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0]));
        } catch (Exception e) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        }
    }

    @TargetApi(17)
    private static Pair<Integer, Integer> getRealResolution(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    public static boolean isUrlLocalFile(String str) {
        return getPathScheme(str) == null || "file".equals(getPathScheme(str));
    }

    public static String getPathScheme(String str) {
        return Uri.parse(str).getScheme();
    }

    @Deprecated
    public static boolean isLiveStreaming(String str) {
        return str.startsWith("rtmp://") || str.endsWith(".m3u8");
    }

    public static int getDisplayDefaultRotation(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }
}

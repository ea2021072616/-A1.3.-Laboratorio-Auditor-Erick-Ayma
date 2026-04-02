package com.fotoable.youtube.music.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.fotoable.youtube.music.MusicApplication;
import com.google.android.gms.common.zzo;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
/* compiled from: TCommonUtils.java */
/* loaded from: classes.dex */
public class w {
    public static boolean a(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Exception e) {
            return true;
        }
    }

    public static int b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static String c(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            ThrowableExtension.printStackTrace(e);
            packageInfo = null;
        }
        if (packageInfo == null) {
            return "";
        }
        return context.getPackageName();
    }

    public static String d(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            ThrowableExtension.printStackTrace(e);
            packageInfo = null;
        }
        if (packageInfo == null) {
            return "";
        }
        return packageInfo.versionName;
    }

    public static String e(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            ThrowableExtension.printStackTrace(e);
            packageInfo = null;
        }
        if (packageInfo == null) {
            return "";
        }
        return "" + packageInfo.versionCode;
    }

    public static boolean a(Context context, String str) {
        PackageInfo packageInfo;
        if (str == null) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean a(String str, Context context) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage(zzo.GOOGLE_PLAY_STORE_PACKAGE);
        intent.setFlags(268435456);
        intent.setData(Uri.parse("market://details?id=" + str));
        return a(context, intent);
    }

    public static boolean a(Context context, Intent intent) {
        if (context == null || intent == null) {
            return false;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            ThrowableExtension.printStackTrace(e);
            return false;
        } catch (IllegalArgumentException e2) {
            ThrowableExtension.printStackTrace(e2);
            return false;
        } catch (Exception e3) {
            ThrowableExtension.printStackTrace(e3);
            return false;
        }
    }

    public static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static String a() {
        String str;
        try {
            String a2 = v.a(MusicApplication.c(), "AppInstallID", "");
            if (TextUtils.isEmpty(a2)) {
                String str2 = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
                try {
                    str = Build.class.getField("SERIAL").get(null).toString();
                } catch (Throwable th) {
                    str = "FreeMusic";
                }
                String uuid = new UUID(str2.hashCode(), str.hashCode()).toString();
                v.b(MusicApplication.c(), "AppInstallID", uuid);
                return uuid;
            }
            return a2;
        } catch (Throwable th2) {
            ThrowableExtension.printStackTrace(th2);
            return "";
        }
    }

    public static File a(Bitmap bitmap, String str) {
        int i = 80;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > 1024) {
            byteArrayOutputStream.reset();
            i -= 10;
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            long length = byteArrayOutputStream.toByteArray().length;
        }
        String str2 = com.fotoable.youtube.music.quicktools.a.b.a(str) + "" + System.currentTimeMillis();
        File file = new File(Environment.getExternalStorageDirectory(), "/Free Music/cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str2 + ".png");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                ThrowableExtension.printStackTrace(e);
            }
        } catch (FileNotFoundException e2) {
            ThrowableExtension.printStackTrace(e2);
        }
        a(bitmap);
        return file2;
    }

    public static void a(Bitmap... bitmapArr) {
        if (bitmapArr != null) {
            for (Bitmap bitmap : bitmapArr) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }
    }

    public static String b() {
        String property;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                property = WebSettings.getDefaultUserAgent(MusicApplication.c());
            } catch (Exception e) {
                property = System.getProperty("http.agent");
            }
        } else {
            property = System.getProperty("http.agent");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = property.length();
        for (int i = 0; i < length; i++) {
            char charAt = property.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static int a(int i) {
        if (1.0d - ((((0.299d * Color.red(i)) + (0.587d * Color.green(i))) + (0.114d * Color.blue(i))) / 255.0d) >= 0.5d) {
            return -1;
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }
}

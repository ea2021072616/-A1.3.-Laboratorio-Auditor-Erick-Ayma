package com.fotoable.youtube.music.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.fotoable.free.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: RomUtils.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4901a = r.class.getSimpleName();

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r6) {
        /*
            r1 = 0
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            r2.<init>()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            java.lang.String r3 = "getprop "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            java.lang.String r2 = r2.toString()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            java.lang.Process r0 = r0.exec(r2)     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            r3.<init>(r0)     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            r0 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r0)     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L6c
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7f
            r2.close()     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7f
            if (r2 == 0) goto L38
            r2.close()     // Catch: java.io.IOException -> L39
        L38:
            return r0
        L39:
            r1 = move-exception
            java.lang.String r2 = com.fotoable.youtube.music.util.r.f4901a
            java.lang.String r3 = "Exception while closing InputStream"
            android.util.Log.e(r2, r3, r1)
            goto L38
        L42:
            r0 = move-exception
            r2 = r1
        L44:
            java.lang.String r3 = com.fotoable.youtube.music.util.r.f4901a     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r4.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r5 = "Unable to read sysprop "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L7c
            android.util.Log.e(r3, r4, r0)     // Catch: java.lang.Throwable -> L7c
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.io.IOException -> L63
        L61:
            r0 = r1
            goto L38
        L63:
            r0 = move-exception
            java.lang.String r2 = com.fotoable.youtube.music.util.r.f4901a
            java.lang.String r3 = "Exception while closing InputStream"
            android.util.Log.e(r2, r3, r0)
            goto L61
        L6c:
            r0 = move-exception
        L6d:
            if (r1 == 0) goto L72
            r1.close()     // Catch: java.io.IOException -> L73
        L72:
            throw r0
        L73:
            r1 = move-exception
            java.lang.String r2 = com.fotoable.youtube.music.util.r.f4901a
            java.lang.String r3 = "Exception while closing InputStream"
            android.util.Log.e(r2, r3, r1)
            goto L72
        L7c:
            r0 = move-exception
            r1 = r2
            goto L6d
        L7f:
            r0 = move-exception
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fotoable.youtube.music.util.r.a(java.lang.String):java.lang.String");
    }

    public static boolean a() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name"));
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    private static boolean a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                h.a(f4901a, Log.getStackTraceString(e));
            }
        } else {
            h.a(f4901a, "Below API 19 cannot invoke!");
        }
        return false;
    }

    public static void a(Activity activity) {
        int b2 = b();
        h.a(f4901a, "MIUI版本号：" + b2);
        try {
            if (b2 == 5) {
                b(activity);
            } else if (b2 == 6) {
                c(activity);
            } else if (b2 == 7) {
                d(activity);
            } else if (b2 == 8) {
                e(activity);
            } else {
                h.a(f4901a, "this is a special MIUI rom version, its version code " + b2);
                b.b("Dev_MIUI浮层授权失败", "不支持的版本", b2 + ",型号:" + Build.MODEL + ",系统版本:" + Build.VERSION.RELEASE);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            b.b("Dev_MIUI浮层授权失败", "跳转异常", new StringBuilder().append(b2).append(",型号:").append(Build.MODEL).append(",系统版本:").append(Build.VERSION.RELEASE).append("，Exception:").append(e).toString() != null ? e.getMessage() : "无异常信息");
        }
    }

    public static int b() {
        String a2 = a("ro.miui.ui.version.name");
        if (a2 != null) {
            try {
                return Integer.parseInt(a2.substring(1));
            } catch (Exception e) {
                h.a(f4901a, "get miui version code error, version : " + a2);
                h.a(f4901a, Log.getStackTraceString(e));
            }
        }
        return -1;
    }

    public static void b(Activity activity) {
        String packageName = activity.getPackageName();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", packageName, null));
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, 1);
            return;
        }
        h.a(f4901a, "intent is not available!");
        b.b("Dev_MIUI浮层授权失败", "Intent is not available", "5,型号:" + Build.MODEL + ",系统版本:" + Build.VERSION.RELEASE);
    }

    public static void c(Activity activity) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", activity.getPackageName());
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, 1);
            return;
        }
        h.a(f4901a, "Intent is not available!");
        b.b("Dev_MIUI浮层授权失败", "Intent is not available", "6,型号:" + Build.MODEL + ",系统版本:" + Build.VERSION.RELEASE);
    }

    public static void d(Activity activity) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", activity.getPackageName());
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, 1);
            return;
        }
        h.a(f4901a, "Intent is not available!");
        b.b("Dev_MIUI浮层授权失败", "Intent is not available", "7,型号:" + Build.MODEL + ",系统版本:" + Build.VERSION.RELEASE);
    }

    public static void e(Activity activity) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", activity.getPackageName());
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, 1);
            h.a(f4901a, "跳转到授权界面");
            return;
        }
        try {
            Intent intent2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent2.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivityForResult(intent2, 1);
            b.b("Dev_MIUI浮层授权默认调用方式", "机型信息", Build.MANUFACTURER + "&" + Build.MODEL + "&" + Build.VERSION.RELEASE);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            b.b("Dev_MIUI浮层授权失败", "Intent is not available", "8,型号:" + Build.MODEL + ",系统版本:" + Build.VERSION.RELEASE);
            Toast.makeText(activity, (int) R.string.request_permission_error_msg, 0).show();
            b.b("Dev_无法跳转到授权界面", "异常信息", e != null ? e.getMessage() + "" : "无异常信息");
            b.b("Dev_无法跳转到授权界面", "产商&机型&系统版本", Build.MANUFACTURER + "&" + Build.MODEL + "&" + Build.VERSION.RELEASE);
        }
        h.a(f4901a, "无法跳转到授权界面");
        h.a(f4901a, "Intent is not available!");
    }

    private static boolean a(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}

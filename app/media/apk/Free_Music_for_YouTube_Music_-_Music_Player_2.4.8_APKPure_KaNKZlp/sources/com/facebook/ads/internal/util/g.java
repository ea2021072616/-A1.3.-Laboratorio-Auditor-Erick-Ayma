package com.facebook.ads.internal.util;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.InterstitialAdActivity;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f1527a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");

    /* renamed from: b  reason: collision with root package name */
    private static final String f1528b = g.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<AdSize, com.facebook.ads.internal.e> f1529c = new HashMap();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f1530a;

        /* renamed from: b  reason: collision with root package name */
        public String f1531b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1532c;

        public a(String str, String str2, boolean z) {
            this.f1530a = str;
            this.f1531b = str2;
            this.f1532c = z;
        }
    }

    static {
        f1529c.put(AdSize.INTERSTITIAL, com.facebook.ads.internal.e.WEBVIEW_INTERSTITIAL_UNKNOWN);
        f1529c.put(AdSize.RECTANGLE_HEIGHT_250, com.facebook.ads.internal.e.WEBVIEW_BANNER_250);
        f1529c.put(AdSize.BANNER_HEIGHT_90, com.facebook.ads.internal.e.WEBVIEW_BANNER_90);
        f1529c.put(AdSize.BANNER_HEIGHT_50, com.facebook.ads.internal.e.WEBVIEW_BANNER_50);
    }

    private static Intent a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setComponent(null);
        if (Build.VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        return intent;
    }

    public static final <P, PR, R> AsyncTask<P, PR, R> a(AsyncTask<P, PR, R> asyncTask, P... pArr) {
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, pArr);
        } else {
            asyncTask.execute(pArr);
        }
        return asyncTask;
    }

    public static com.facebook.ads.internal.e a(AdSize adSize) {
        com.facebook.ads.internal.e eVar = f1529c.get(adSize);
        return eVar == null ? com.facebook.ads.internal.e.WEBVIEW_BANNER_LEGACY : eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.internal.util.g.a a(android.content.ContentResolver r7) {
        /*
            r6 = 0
            r0 = 3
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L74
            r0 = 0
            java.lang.String r1 = "aid"
            r2[r0] = r1     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L74
            r0 = 1
            java.lang.String r1 = "androidid"
            r2[r0] = r1     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L74
            r0 = 2
            java.lang.String r1 = "limit_tracking"
            r2[r0] = r1     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L74
            android.net.Uri r1 = com.facebook.ads.internal.util.g.f1527a     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L74
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> L74
            if (r1 == 0) goto L25
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            if (r0 != 0) goto L33
        L25:
            com.facebook.ads.internal.util.g$a r0 = new com.facebook.ads.internal.util.g$a     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r2 = 0
            r3 = 0
            r4 = 0
            r0.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            if (r1 == 0) goto L32
            r1.close()
        L32:
            return r0
        L33:
            java.lang.String r0 = "aid"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.String r2 = r1.getString(r0)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.String r0 = "androidid"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.String r3 = r1.getString(r0)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.String r0 = "limit_tracking"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            com.facebook.ads.internal.util.g$a r0 = new com.facebook.ads.internal.util.g$a     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r0.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            if (r1 == 0) goto L32
            r1.close()
            goto L32
        L64:
            r0 = move-exception
            r1 = r6
        L66:
            com.facebook.ads.internal.util.g$a r0 = new com.facebook.ads.internal.util.g$a     // Catch: java.lang.Throwable -> L7c
            r2 = 0
            r3 = 0
            r4 = 0
            r0.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L32
            r1.close()
            goto L32
        L74:
            r0 = move-exception
            r1 = r6
        L76:
            if (r1 == 0) goto L7b
            r1.close()
        L7b:
            throw r0
        L7c:
            r0 = move-exception
            goto L76
        L7e:
            r0 = move-exception
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.util.g.a(android.content.ContentResolver):com.facebook.ads.internal.util.g$a");
    }

    public static Object a(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String a(double d) {
        return String.format(Locale.US, "%.3f", Double.valueOf(d));
    }

    public static String a(long j) {
        return a(j / 1000.0d);
    }

    public static String a(InputStream inputStream) {
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[4096];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                String stringWriter2 = stringWriter.toString();
                stringWriter.close();
                inputStreamReader.close();
                return stringWriter2;
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    public static String a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
        }
        return jSONObject.toString();
    }

    public static String a(JSONObject jSONObject, String str) {
        return a(jSONObject, str, (String) null);
    }

    public static String a(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString(str, str2);
        if ("null".equals(optString)) {
            return null;
        }
        return optString;
    }

    public static String a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            String a2 = a(gZIPInputStream);
            gZIPInputStream.close();
            byteArrayInputStream.close();
            return a2;
        } catch (Exception e) {
            c.a(b.a(e, "Error decompressing data"));
            ThrowableExtension.printStackTrace(e);
            return "";
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method a(String str, String str2, Class<?>... clsArr) {
        try {
            return a(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static void a(Context context, Uri uri) {
        Intent a2 = a(uri);
        a2.addCategory("android.intent.category.BROWSABLE");
        a2.addFlags(268435456);
        a2.putExtra("com.android.browser.application_id", context.getPackageName());
        a2.putExtra("create_new_tab", false);
        context.startActivity(a2);
    }

    public static void a(Context context, Uri uri, String str) {
        if (com.facebook.ads.internal.view.a.d.a(uri.getScheme()) && com.facebook.ads.internal.h.d(context)) {
            b(context, uri, str);
        } else {
            a(context, uri);
        }
    }

    public static void a(Context context, String str) {
        if (AdSettings.isTestMode(context)) {
            Log.d("FBAudienceNetworkLog", str + " (displayed for test ads only)");
        }
    }

    public static void a(DisplayMetrics displayMetrics, View view, AdSize adSize) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) >= adSize.getWidth() ? displayMetrics.widthPixels : (int) Math.ceil(adSize.getWidth() * displayMetrics.density), (int) Math.ceil(adSize.getHeight() * displayMetrics.density));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }

    public static boolean a(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            String str = runningTaskInfo.topActivity.getPackageName() + ".UnityPlayerActivity";
            Boolean valueOf = Boolean.valueOf(((ActivityManager) context.getSystemService("activity")).getRunningTasks(2).get(0).topActivity.getClassName() == str || b(str));
            Log.d("IS_UNITY", Boolean.toString(valueOf.booleanValue()));
            return valueOf.booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        try {
            Class.forName(str + "." + str2);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static byte[] a(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            c.a(b.a(e, "Error compressing data"));
            ThrowableExtension.printStackTrace(e);
            return new byte[0];
        }
    }

    private static void b(Context context, Uri uri, String str) {
        Intent intent = new Intent(context, AudienceNetworkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(AudienceNetworkActivity.VIEW_TYPE, AudienceNetworkActivity.Type.BROWSER);
        intent.putExtra(AudienceNetworkActivity.BROWSER_URL, uri.toString());
        intent.putExtra(AudienceNetworkActivity.CLIENT_TOKEN, str);
        intent.putExtra(AudienceNetworkActivity.HANDLER_TIME, System.currentTimeMillis());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setClass(context, InterstitialAdActivity.class);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                a(context, uri);
            }
        }
    }

    public static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}

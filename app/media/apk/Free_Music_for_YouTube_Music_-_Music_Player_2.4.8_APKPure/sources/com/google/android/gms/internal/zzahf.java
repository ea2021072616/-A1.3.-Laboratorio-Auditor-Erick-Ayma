package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import b.a.a.a.a.b.a;
import com.google.android.exoplayer2.C;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzahf {
    public static final Handler zzdbo = new zzafy(Looper.getMainLooper());
    private static AtomicReference<List<String>> zzdbp = new AtomicReference<>(null);
    private static AtomicReference<List<String>> zzdbq = new AtomicReference<>(null);
    private String zzbwh;
    private com.google.android.gms.ads.internal.js.zzl zzbzz;
    private final Object mLock = new Object();
    private boolean zzdbr = true;
    private boolean zzdbs = false;

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            zzdbo.post(runnable);
        }
    }

    public static Bundle zza(zzhd zzhdVar) {
        String str;
        String zzpw;
        String zzpx;
        if (zzhdVar == null) {
            return null;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbia)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbic)).booleanValue()) {
                return null;
            }
        }
        if (com.google.android.gms.ads.internal.zzbv.zzee().zzpp() && com.google.android.gms.ads.internal.zzbv.zzee().zzpq()) {
            return null;
        }
        if (zzhdVar.zzgr()) {
            zzhdVar.wakeup();
        }
        zzgx zzgp = zzhdVar.zzgp();
        if (zzgp != null) {
            String zzge = zzgp.zzge();
            String zzgf = zzgp.zzgf();
            String zzgg = zzgp.zzgg();
            if (zzge != null) {
                com.google.android.gms.ads.internal.zzbv.zzee().zzce(zzge);
            }
            if (zzgg != null) {
                com.google.android.gms.ads.internal.zzbv.zzee().zzcf(zzgg);
                zzpw = zzge;
                str = zzgf;
                zzpx = zzgg;
            } else {
                zzpw = zzge;
                str = zzgf;
                zzpx = zzgg;
            }
        } else {
            str = null;
            zzpw = com.google.android.gms.ads.internal.zzbv.zzee().zzpw();
            zzpx = com.google.android.gms.ads.internal.zzbv.zzee().zzpx();
        }
        Bundle bundle = new Bundle(1);
        if (zzpx != null) {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbic)).booleanValue() && !com.google.android.gms.ads.internal.zzbv.zzee().zzpq()) {
                bundle.putString("v_fp_vertical", zzpx);
            }
        }
        if (zzpw != null) {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbia)).booleanValue() && !com.google.android.gms.ads.internal.zzbv.zzee().zzpp()) {
                bundle.putString("fingerprint", zzpw);
                if (!zzpw.equals(str)) {
                    bundle.putString("v_fp", str);
                }
            }
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    public static DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    public static String zza(Context context, View view, zzjb zzjbVar) {
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbis)).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", zzjbVar.width);
                jSONObject2.put("height", zzjbVar.height);
                jSONObject.put("size", jSONObject2);
                jSONObject.put("activity", zzal(context));
                if (!zzjbVar.zzbcr) {
                    JSONArray jSONArray = new JSONArray();
                    while (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("type", parent.getClass().getName());
                            jSONObject3.put("index_of_child", indexOfChild);
                            jSONArray.put(jSONObject3);
                        }
                        view = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("parents", jSONArray);
                    }
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                zzafx.zzc("Fail to get view hierarchy json", e);
                return null;
            }
        }
        return null;
    }

    private static String zza(Context context, zzcv zzcvVar, String str, View view) {
        if (zzcvVar == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzcvVar.zzd(parse)) {
                parse = zzcvVar.zza(parse, context, view);
            }
            return parse.toString();
        } catch (Exception e) {
            return str;
        }
    }

    public static String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    private final JSONArray zza(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            zza(jSONArray, it.next());
        }
        return jSONArray;
    }

    public static void zza(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void zza(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
    }

    @TargetApi(18)
    public static void zza(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbot)).booleanValue()) {
                zzc(context, intent);
            }
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            zzafx.zzcb(new StringBuilder(String.valueOf(uri2).length() + 26).append("Opening ").append(uri2).append(" in a new browser.").toString());
        } catch (ActivityNotFoundException e) {
            zzafx.zzb("No browser is found.", e);
        }
    }

    public static void zza(Context context, String str, List<String> list) {
        for (String str2 : list) {
            new zzaiw(context, str, str2).zzns();
        }
    }

    public static void zza(List<String> list, String str) {
        for (String str2 : list) {
            new zzaiw(str2, str).zzns();
        }
    }

    private final void zza(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zzc((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzk((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zza((Collection) obj));
        } else if (!(obj instanceof Object[])) {
            jSONArray.put(obj);
        } else {
            JSONArray jSONArray2 = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                zza(jSONArray2, obj2);
            }
            jSONArray.put(jSONArray2);
        }
    }

    private final void zza(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzc((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzk((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zza(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    @TargetApi(24)
    public static boolean zza(Activity activity, Configuration configuration) {
        zzjo.zzhu();
        int zzc = zzaje.zzc(activity, configuration.screenHeightDp);
        int zzc2 = zzaje.zzc(activity, configuration.screenWidthDp);
        DisplayMetrics zza = zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza.heightPixels;
        int i2 = zza.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int intValue = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbpd)).intValue() * ((int) Math.round(activity.getResources().getDisplayMetrics().density + 0.5d));
        return zzb(i, dimensionPixelSize + zzc, intValue) && zzb(i2, zzc2, intValue);
    }

    public static boolean zza(ClassLoader classLoader, Class<?> cls, String str) {
        try {
            return cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean zzag(Context context) {
        boolean z;
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            zzafx.zzcs("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            zzafx.zzcs(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboard"));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            zzafx.zzcs(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboardHidden"));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            zzafx.zzcs(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "orientation"));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            zzafx.zzcs(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenLayout"));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            zzafx.zzcs(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "uiMode"));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            zzafx.zzcs(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenSize"));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) == 0) {
            zzafx.zzcs(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "smallestScreenSize"));
            return false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String zzai(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Exception e) {
            return zzqs();
        }
    }

    public static AlertDialog.Builder zzaj(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static zzmf zzak(Context context) {
        return new zzmf(context);
    }

    private static String zzal(Context context) {
        ActivityManager activityManager;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            activityManager = (ActivityManager) context.getSystemService("activity");
        } catch (Exception e) {
        }
        if (activityManager == null) {
            return null;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
        if (runningTasks != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
            return runningTaskInfo.topActivity.getClassName();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        if (r0.importance != 100) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r1.inKeyguardRestrictedInputMode() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
        r0 = (android.os.PowerManager) r6.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        if (r0 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        r0 = r0.isScreenOn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzam(android.content.Context r6) {
        /*
            r2 = 0
            java.lang.String r0 = "activity"
            java.lang.Object r0 = r6.getSystemService(r0)     // Catch: java.lang.Throwable -> L59
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch: java.lang.Throwable -> L59
            java.lang.String r1 = "keyguard"
            java.lang.Object r1 = r6.getSystemService(r1)     // Catch: java.lang.Throwable -> L59
            android.app.KeyguardManager r1 = (android.app.KeyguardManager) r1     // Catch: java.lang.Throwable -> L59
            if (r0 == 0) goto L15
            if (r1 != 0) goto L17
        L15:
            r0 = r2
        L16:
            return r0
        L17:
            java.util.List r0 = r0.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L59
            if (r0 != 0) goto L1f
            r0 = r2
            goto L16
        L1f:
            java.util.Iterator r3 = r0.iterator()     // Catch: java.lang.Throwable -> L59
        L23:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L59
            if (r0 == 0) goto L57
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L59
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0     // Catch: java.lang.Throwable -> L59
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L59
            int r5 = r0.pid     // Catch: java.lang.Throwable -> L59
            if (r4 != r5) goto L23
            int r0 = r0.importance     // Catch: java.lang.Throwable -> L59
            r3 = 100
            if (r0 != r3) goto L57
            boolean r0 = r1.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L59
            if (r0 != 0) goto L57
            java.lang.String r0 = "power"
            java.lang.Object r0 = r6.getSystemService(r0)     // Catch: java.lang.Throwable -> L59
            android.os.PowerManager r0 = (android.os.PowerManager) r0     // Catch: java.lang.Throwable -> L59
            if (r0 != 0) goto L52
            r0 = r2
        L4e:
            if (r0 == 0) goto L57
            r0 = 1
            goto L16
        L52:
            boolean r0 = r0.isScreenOn()     // Catch: java.lang.Throwable -> L59
            goto L4e
        L57:
            r0 = r2
            goto L16
        L59:
            r0 = move-exception
            r0 = r2
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahf.zzam(android.content.Context):boolean");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0043 -> B:10:0x002c). Please submit an issue!!! */
    public static Bitmap zzan(Context context) {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        if (context instanceof Activity) {
            try {
            } catch (RuntimeException e) {
                zzafx.zzb("Fail to capture screen shot", e);
            }
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmj)).booleanValue()) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    bitmap = zzo(window.getDecorView().getRootView());
                }
                bitmap = bitmap2;
            } else {
                bitmap = zzn(((Activity) context).getWindow().getDecorView());
            }
            bitmap2 = bitmap;
            return bitmap2;
        }
        return null;
    }

    public static AudioManager zzao(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public static float zzap(Context context) {
        AudioManager zzao = zzao(context);
        if (zzao == null) {
            return 0.0f;
        }
        int streamMaxVolume = zzao.getStreamMaxVolume(3);
        int streamVolume = zzao.getStreamVolume(3);
        if (streamMaxVolume != 0) {
            return streamVolume / streamMaxVolume;
        }
        return 0.0f;
    }

    public static int zzaq(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    public static boolean zzar(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        } catch (Throwable th) {
            zzafx.zzb("Error loading class.", th);
            com.google.android.gms.ads.internal.zzbv.zzee().zza(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static int zzas(Context context) {
        return DynamiteModule.zzaf(context, ModuleDescriptor.MODULE_ID);
    }

    public static int zzat(Context context) {
        return DynamiteModule.zzae(context, ModuleDescriptor.MODULE_ID);
    }

    public static Uri zzb(String str, String str2, String str3) throws UnsupportedOperationException {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(str.substring(0, indexOf + 1) + str2 + "=" + str3 + "&" + str.substring(indexOf + 1)) : Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }

    public static String zzb(zzakk zzakkVar, String str) {
        Context context = zzakkVar.getContext();
        zzcv zzsd = zzakkVar.zzsd();
        if (zzakkVar == null) {
            throw null;
        }
        return zza(context, zzsd, str, (View) zzakkVar);
    }

    public static void zzb(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
    }

    public static void zzb(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void zzb(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzagz.zza(runnable);
        }
    }

    private static boolean zzb(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    private final JSONObject zzc(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    @TargetApi(18)
    public static void zzc(Context context, Intent intent) {
        if (intent != null && com.google.android.gms.common.util.zzp.zzalg()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder(CustomTabsIntent.EXTRA_SESSION, null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static boolean zzc(Context context, String str, String str2) {
        return zzbdp.zzcs(context).checkPermission(str2, str) == 0;
    }

    public static String zzch(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public static int zzci(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            zzafx.zzcs(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Could not parse value:").append(valueOf).toString());
            return 0;
        }
    }

    public static boolean zzcj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static boolean zzck(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (zzdbp.get() == null) {
            try {
                JSONArray jSONArray = new JSONArray((String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbiy));
                ArrayList arrayList = new ArrayList(jSONArray.length());
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                zzdbp.compareAndSet(null, arrayList);
            } catch (JSONException e) {
                zzafx.zzcs("Could not parse click ping schema");
                return false;
            }
        }
        for (String str2 : zzdbp.get()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzcl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (zzdbq.get() == null) {
            try {
                JSONArray jSONArray = new JSONArray((String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbiz));
                ArrayList arrayList = new ArrayList(jSONArray.length());
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                zzdbq.compareAndSet(null, arrayList);
            } catch (JSONException e) {
                zzafx.zzcs("Could not parse impression ping schema");
                return false;
            }
        }
        for (String str2 : zzdbq.get()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void zzd(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, arrayList);
    }

    public static float zzde() {
        com.google.android.gms.ads.internal.zzbv.zzev();
        com.google.android.gms.ads.internal.zzay zzdd = com.google.android.gms.ads.internal.zzay.zzdd();
        if (zzdd == null || !zzdd.zzdf()) {
            return 1.0f;
        }
        return zzdd.zzde();
    }

    public static boolean zzdg() {
        com.google.android.gms.ads.internal.zzbv.zzev();
        com.google.android.gms.ads.internal.zzay zzdd = com.google.android.gms.ads.internal.zzay.zzdd();
        if (zzdd != null) {
            return zzdd.zzdg();
        }
        return false;
    }

    public static void zze(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes(C.UTF8_NAME));
            openFileOutput.close();
        } catch (Exception e) {
            zzafx.zzb("Error writing to file in internal storage.", e);
        }
    }

    public static int[] zzf(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        return (window == null || (findViewById = window.findViewById(16908290)) == null) ? zzqw() : new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public static Map<String, String> zzg(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : com.google.android.gms.ads.internal.zzbv.zzec().zzh(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public static Bitmap zzl(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap zzm(View view) {
        if (view == null) {
            return null;
        }
        Bitmap zzo = zzo(view);
        return zzo == null ? zzn(view) : zzo;
    }

    private static Bitmap zzn(@NonNull View view) {
        Bitmap bitmap;
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                zzafx.zzcs("Width or height of view is zero");
                bitmap = null;
            } else {
                bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(bitmap);
                view.layout(0, 0, width, height);
                view.draw(canvas);
            }
            return bitmap;
        } catch (RuntimeException e) {
            zzafx.zzb("Fail to capture the webview", e);
            return null;
        }
    }

    private static Bitmap zzo(@NonNull View view) {
        Bitmap bitmap;
        RuntimeException e;
        boolean isDrawingCacheEnabled;
        try {
            isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            bitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
        } catch (RuntimeException e2) {
            bitmap = null;
            e = e2;
        }
        try {
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (RuntimeException e3) {
            e = e3;
            zzafx.zzb("Fail to capture the web view", e);
            return bitmap;
        }
        return bitmap;
    }

    public static int zzp(@Nullable View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    private static String zzqs() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(Build.VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public static String zzqt() {
        return UUID.randomUUID().toString();
    }

    public static String zzqu() {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public static String zzqv() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()).append(str).append(" ").append(str2).toString();
    }

    private static int[] zzqw() {
        return new int[]{0, 0};
    }

    public static Bundle zzqx() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbha)).booleanValue()) {
                Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhb)).booleanValue()) {
                Runtime runtime = Runtime.getRuntime();
                bundle.putLong("runtime_free_memory", runtime.freeMemory());
                bundle.putLong("runtime_max_memory", runtime.maxMemory());
                bundle.putLong("runtime_total_memory", runtime.totalMemory());
            }
            bundle.putInt("web_view_count", com.google.android.gms.ads.internal.zzbv.zzee().zzqn());
        } catch (Exception e) {
            zzafx.zzc("Unable to gather memory stats", e);
        }
        return bundle;
    }

    public static String zzt(Context context, String str) {
        try {
            return new String(com.google.android.gms.common.util.zzm.zza(context.openFileInput(str), true), C.UTF8_NAME);
        } catch (IOException e) {
            zzafx.zzcb("Error reading from internal storage.");
            return "";
        }
    }

    public final JSONObject zza(Bundle bundle, JSONObject jSONObject) {
        try {
            return zzc(bundle);
        } catch (JSONException e) {
            zzafx.zzb("Error converting Bundle to JSON", e);
            return null;
        }
    }

    public final void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            com.google.android.gms.ads.internal.zzbv.zzea();
            bundle.putString("device", zzqv());
            bundle.putString("eids", TextUtils.join(",", zzmu.zzil()));
        }
        zzjo.zzhu();
        zzaje.zza(context, str, str2, bundle, z, new zzahi(this, context, str));
    }

    public final void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty(a.HEADER_USER_AGENT, zzs(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final void zza(Context context, List<String> list) {
        if ((context instanceof Activity) && !TextUtils.isEmpty(zzehn.zzex((Activity) context))) {
            if (list == null) {
                zzafx.v("Cannot ping urls: empty list.");
            } else if (!zznr.zzk(context)) {
                zzafx.v("Cannot ping url because custom tabs is not supported");
            } else {
                zznr zznrVar = new zznr();
                zznrVar.zza(new zzahg(this, list, zznrVar, context));
                zznrVar.zzd((Activity) context);
            }
        }
    }

    public final boolean zza(View view, Context context) {
        KeyguardManager keyguardManager = null;
        Context applicationContext = context.getApplicationContext();
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null && (systemService instanceof KeyguardManager)) {
            keyguardManager = (KeyguardManager) systemService;
        }
        return zza(view, powerManager, keyguardManager);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
        if (r0 != false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(android.view.View r6, android.os.PowerManager r7, android.app.KeyguardManager r8) {
        /*
            r5 = this;
            r3 = 0
            r2 = 1
            r1 = 0
            com.google.android.gms.internal.zzahf r0 = com.google.android.gms.ads.internal.zzbv.zzea()
            boolean r0 = r0.zzdbr
            if (r0 != 0) goto L47
            if (r8 != 0) goto L8a
            r0 = r1
        Le:
            if (r0 == 0) goto L47
            com.google.android.gms.internal.zzmk<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmu.zzbku
            com.google.android.gms.internal.zzms r4 = com.google.android.gms.ads.internal.zzbv.zzen()
            java.lang.Object r0 = r4.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L98
            android.view.View r0 = r6.getRootView()
            if (r0 == 0) goto L8f
            android.content.Context r0 = r0.getContext()
            boolean r4 = r0 instanceof android.app.Activity
            if (r4 == 0) goto L8f
            android.app.Activity r0 = (android.app.Activity) r0
        L32:
            if (r0 == 0) goto L96
            android.view.Window r0 = r0.getWindow()
            if (r0 != 0) goto L91
            r0 = r3
        L3b:
            if (r0 == 0) goto L96
            int r0 = r0.flags
            r3 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r3
            if (r0 == 0) goto L96
            r0 = r2
        L45:
            if (r0 == 0) goto L98
        L47:
            r0 = r2
        L48:
            int r3 = r6.getVisibility()
            if (r3 != 0) goto L9c
            boolean r3 = r6.isShown()
            if (r3 == 0) goto L9c
            if (r7 == 0) goto L5c
            boolean r3 = r7.isScreenOn()
            if (r3 == 0) goto L9a
        L5c:
            r3 = r2
        L5d:
            if (r3 == 0) goto L9c
            if (r0 == 0) goto L9c
            com.google.android.gms.internal.zzmk<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmu.zzbks
            com.google.android.gms.internal.zzms r3 = com.google.android.gms.ads.internal.zzbv.zzen()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L89
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            boolean r0 = r6.getLocalVisibleRect(r0)
            if (r0 != 0) goto L89
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            boolean r0 = r6.getGlobalVisibleRect(r0)
            if (r0 == 0) goto L9c
        L89:
            return r2
        L8a:
            boolean r0 = r8.inKeyguardRestrictedInputMode()
            goto Le
        L8f:
            r0 = r3
            goto L32
        L91:
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()
            goto L3b
        L96:
            r0 = r1
            goto L45
        L98:
            r0 = r1
            goto L48
        L9a:
            r3 = r1
            goto L5d
        L9c:
            r2 = r1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahf.zza(android.view.View, android.os.PowerManager, android.app.KeyguardManager):boolean");
    }

    public final boolean zzah(Context context) {
        if (this.zzdbs) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zzahj(this, null), intentFilter);
        this.zzdbs = true;
        return true;
    }

    public final void zzb(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkx)).booleanValue()) {
            zza(context, str, str2, bundle, z);
        }
    }

    public final com.google.android.gms.ads.internal.js.zzl zze(Context context, zzajk zzajkVar) {
        com.google.android.gms.ads.internal.js.zzl zzlVar;
        synchronized (this.mLock) {
            if (this.zzbzz == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.zzbzz = new com.google.android.gms.ads.internal.js.zzl(context, zzajkVar, (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbfv));
            }
            zzlVar = this.zzbzz;
        }
        return zzlVar;
    }

    public final int[] zzg(Activity activity) {
        int[] zzf = zzf(activity);
        zzjo.zzhu();
        zzjo.zzhu();
        return new int[]{zzaje.zzd(activity, zzf[0]), zzaje.zzd(activity, zzf[1])};
    }

    public final int[] zzh(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        int[] zzqw = (window == null || (findViewById = window.findViewById(16908290)) == null) ? zzqw() : new int[]{findViewById.getTop(), findViewById.getBottom()};
        zzjo.zzhu();
        zzjo.zzhu();
        return new int[]{zzaje.zzd(activity, zzqw[0]), zzaje.zzd(activity, zzqw[1])};
    }

    public final JSONObject zzk(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zza(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    public final String zzs(Context context, String str) {
        String str2;
        synchronized (this.mLock) {
            if (this.zzbwh != null) {
                str2 = this.zzbwh;
            } else if (str == null) {
                str2 = zzqs();
            } else {
                try {
                    this.zzbwh = com.google.android.gms.ads.internal.zzbv.zzec().getDefaultUserAgent(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.zzbwh)) {
                    zzjo.zzhu();
                    if (zzaje.zzrq()) {
                        this.zzbwh = zzai(context);
                    } else {
                        this.zzbwh = null;
                        zzdbo.post(new zzahh(this, context));
                        while (this.zzbwh == null) {
                            try {
                                this.mLock.wait();
                            } catch (InterruptedException e2) {
                                this.zzbwh = zzqs();
                                String valueOf = String.valueOf(this.zzbwh);
                                zzafx.zzcs(valueOf.length() != 0 ? "Interrupted, use default user agent: ".concat(valueOf) : new String("Interrupted, use default user agent: "));
                            }
                        }
                    }
                }
                String valueOf2 = String.valueOf(this.zzbwh);
                this.zzbwh = new StringBuilder(String.valueOf(valueOf2).length() + 10 + String.valueOf(str).length()).append(valueOf2).append(" (Mobile; ").append(str).toString();
                try {
                    if (zzbdp.zzcs(context).zzalq()) {
                        this.zzbwh = String.valueOf(this.zzbwh).concat(";aia");
                    }
                } catch (Exception e3) {
                    com.google.android.gms.ads.internal.zzbv.zzee().zza(e3, "AdUtil.getUserAgent");
                }
                this.zzbwh = String.valueOf(this.zzbwh).concat(")");
                str2 = this.zzbwh;
            }
        }
        return str2;
    }
}

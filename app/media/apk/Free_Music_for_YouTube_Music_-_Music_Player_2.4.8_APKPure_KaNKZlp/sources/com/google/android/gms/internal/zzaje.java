package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.a.a.a.b.a;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.StringTokenizer;
@zzzt
/* loaded from: classes.dex */
public final class zzaje {
    public static final Handler zzdee = new Handler(Looper.getMainLooper());
    private static final String zzdef = AdView.class.getName();
    private static final String zzdeg = InterstitialAd.class.getName();
    private static final String zzdeh = PublisherAdView.class.getName();
    private static final String zzdei = PublisherInterstitialAd.class.getName();
    private static final String zzdej = SearchAdView.class.getName();
    private static final String zzdek = AdLoader.class.getName();

    public static int zza(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, i, displayMetrics);
    }

    @Nullable
    public static String zza(StackTraceElement[] stackTraceElementArr, String str) {
        String str2;
        for (int i = 0; i + 1 < stackTraceElementArr.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            String className = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (zzdef.equalsIgnoreCase(className) || zzdeg.equalsIgnoreCase(className) || zzdeh.equalsIgnoreCase(className) || zzdei.equalsIgnoreCase(className) || zzdej.equalsIgnoreCase(className) || zzdek.equalsIgnoreCase(className))) {
                str2 = stackTraceElementArr[i + 1].getClassName();
                break;
            }
        }
        str2 = null;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            StringBuilder sb = new StringBuilder();
            int i2 = 2;
            if (stringTokenizer.hasMoreElements()) {
                sb.append(stringTokenizer.nextToken());
                while (true) {
                    int i3 = i2 - 1;
                    if (i2 <= 0 || !stringTokenizer.hasMoreElements()) {
                        break;
                    }
                    sb.append(".").append(stringTokenizer.nextToken());
                    i2 = i3;
                }
                str = sb.toString();
            }
            if (str2 != null && !str2.contains(str)) {
                return str2;
            }
        }
        return null;
    }

    public static void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z, zzajh zzajhVar) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", Build.VERSION.RELEASE);
            bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
            bundle.putString("appid", applicationContext.getPackageName());
            if (str == null) {
                com.google.android.gms.common.zze.zzaew();
                str = new StringBuilder(23).append(com.google.android.gms.common.zze.zzbx(context)).append(".11200000").toString();
            }
            bundle.putString("js", str);
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        zzajhVar.zzcm(appendQueryParameter.toString());
    }

    private final void zza(ViewGroup viewGroup, zzjb zzjbVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setBackgroundColor(i2);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(i);
        int zzc = zzc(context, 3);
        frameLayout.addView(textView, new FrameLayout.LayoutParams(zzjbVar.widthPixels - zzc, zzjbVar.heightPixels - zzc, 17));
        viewGroup.addView(frameLayout, zzjbVar.widthPixels, zzjbVar.heightPixels);
    }

    public static void zza(boolean z, HttpURLConnection httpURLConnection, @Nullable String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty(a.HEADER_USER_AGENT, str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public static int zzas(Context context) {
        return DynamiteModule.zzaf(context, ModuleDescriptor.MODULE_ID);
    }

    public static int zzat(Context context) {
        return DynamiteModule.zzae(context, ModuleDescriptor.MODULE_ID);
    }

    public static String zzay(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return zzcq(((contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id")) == null || zzrp()) ? "emulator" : "emulator");
    }

    @Nullable
    public static String zzaz(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return null;
        }
        return Settings.Secure.getString(contentResolver, "android_id");
    }

    public static int zzb(DisplayMetrics displayMetrics, int i) {
        return Math.round(i / displayMetrics.density);
    }

    public static boolean zzba(Context context) {
        return com.google.android.gms.common.zze.zzaew().isGooglePlayServicesAvailable(context) == 0;
    }

    public static boolean zzbb(Context context) {
        int isGooglePlayServicesAvailable = com.google.android.gms.common.zze.zzaew().isGooglePlayServicesAvailable(context);
        return isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2;
    }

    public static boolean zzbc(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    @TargetApi(17)
    public static boolean zzbd(Context context) {
        int intValue;
        int intValue2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (com.google.android.gms.common.util.zzp.zzalf()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            intValue = displayMetrics.heightPixels;
            intValue2 = displayMetrics.widthPixels;
        } else {
            try {
                intValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.heightPixels == intValue && displayMetrics.widthPixels == intValue2;
    }

    public static int zzbe(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int zzc(Context context, int i) {
        return zza(context.getResources().getDisplayMetrics(), i);
    }

    public static String zzcq(String str) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static int zzd(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return zzb(displayMetrics, i);
    }

    public static boolean zzrp() {
        return Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
    }

    public static boolean zzrq() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public final void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        zza(context, null, str2, bundle, true, new zzajf(this));
    }

    public final void zza(ViewGroup viewGroup, zzjb zzjbVar, String str) {
        zza(viewGroup, zzjbVar, str, ViewCompat.MEASURED_STATE_MASK, -1);
    }

    public final void zza(ViewGroup viewGroup, zzjb zzjbVar, String str, String str2) {
        zzaji.zzcs(str2);
        zza(viewGroup, zzjbVar, str, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK);
    }
}

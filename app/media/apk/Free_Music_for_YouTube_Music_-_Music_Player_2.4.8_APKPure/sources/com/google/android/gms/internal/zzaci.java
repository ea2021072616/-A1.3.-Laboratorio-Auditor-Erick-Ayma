package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.facebook.places.model.PlaceFields;
import java.util.Locale;
/* loaded from: classes.dex */
public final class zzaci {
    private float zzaxh;
    private int zzcof;
    private int zzcog;
    private int zzcue;
    private boolean zzcuf;
    private boolean zzcug;
    private String zzcuh;
    private String zzcui;
    private boolean zzcuj;
    private boolean zzcuk;
    private boolean zzcul;
    private boolean zzcum;
    private String zzcun;
    private String zzcuo;
    private String zzcup;
    private int zzcuq;
    private int zzcur;
    private int zzcus;
    private int zzcut;
    private int zzcuu;
    private int zzcuv;
    private double zzcuw;
    private boolean zzcux;
    private boolean zzcuy;
    private int zzcuz;
    private String zzcva;
    private String zzcvb;
    private boolean zzcvc;

    public zzaci(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzm(context);
        zzn(context);
        zzo(context);
        Locale locale = Locale.getDefault();
        this.zzcuf = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzcug = zza(packageManager, "http://www.google.com") != null;
        this.zzcui = locale.getCountry();
        zzjo.zzhu();
        this.zzcuj = zzaje.zzrp();
        this.zzcuk = com.google.android.gms.common.util.zzi.zzcl(context);
        this.zzcun = locale.getLanguage();
        this.zzcuo = zzb(context, packageManager);
        this.zzcup = zza(context, packageManager);
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        this.zzaxh = displayMetrics.density;
        this.zzcof = displayMetrics.widthPixels;
        this.zzcog = displayMetrics.heightPixels;
    }

    public zzaci(Context context, zzach zzachVar) {
        context.getPackageManager();
        zzm(context);
        zzn(context);
        zzo(context);
        this.zzcva = Build.FINGERPRINT;
        this.zzcvb = Build.DEVICE;
        this.zzcvc = com.google.android.gms.common.util.zzp.zzald() && zznr.zzk(context);
        this.zzcuf = zzachVar.zzcuf;
        this.zzcug = zzachVar.zzcug;
        this.zzcui = zzachVar.zzcui;
        this.zzcuj = zzachVar.zzcuj;
        this.zzcuk = zzachVar.zzcuk;
        this.zzcun = zzachVar.zzcun;
        this.zzcuo = zzachVar.zzcuo;
        this.zzcup = zzachVar.zzcup;
        this.zzaxh = zzachVar.zzaxh;
        this.zzcof = zzachVar.zzcof;
        this.zzcog = zzachVar.zzcog;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    private static String zza(Context context, PackageManager packageManager) {
        try {
            PackageInfo packageInfo = zzbdp.zzcs(context).getPackageInfo(com.google.android.gms.common.zzo.GOOGLE_PLAY_STORE_PACKAGE, 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                return new StringBuilder(String.valueOf(str).length() + 12).append(i).append(".").append(str).toString();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static String zzb(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = zzbdp.zzcs(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                return new StringBuilder(String.valueOf(str).length() + 12).append(i).append(".").append(str).toString();
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private final void zzm(Context context) {
        com.google.android.gms.ads.internal.zzbv.zzea();
        AudioManager zzao = zzahf.zzao(context);
        if (zzao != null) {
            try {
                this.zzcue = zzao.getMode();
                this.zzcul = zzao.isMusicActive();
                this.zzcum = zzao.isSpeakerphoneOn();
                this.zzcuq = zzao.getStreamVolume(3);
                this.zzcuu = zzao.getRingerMode();
                this.zzcuv = zzao.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzbv.zzee().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzcue = -2;
        this.zzcul = false;
        this.zzcum = false;
        this.zzcuq = 0;
        this.zzcuu = 0;
        this.zzcuv = 0;
    }

    @TargetApi(16)
    private final void zzn(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzcuh = telephonyManager.getNetworkOperator();
        this.zzcus = telephonyManager.getNetworkType();
        this.zzcut = telephonyManager.getPhoneType();
        this.zzcur = -2;
        this.zzcuy = false;
        this.zzcuz = -1;
        com.google.android.gms.ads.internal.zzbv.zzea();
        if (zzahf.zzc(context, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.zzcur = activeNetworkInfo.getType();
                this.zzcuz = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.zzcur = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.zzcuy = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void zzo(Context context) {
        boolean z = false;
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            this.zzcuw = -1.0d;
            this.zzcux = false;
            return;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        this.zzcuw = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
        this.zzcux = (intExtra == 2 || intExtra == 5) ? true : true;
    }

    public final zzach zzop() {
        return new zzach(this.zzcue, this.zzcuf, this.zzcug, this.zzcuh, this.zzcui, this.zzcuj, this.zzcuk, this.zzcul, this.zzcum, this.zzcun, this.zzcuo, this.zzcup, this.zzcuq, this.zzcur, this.zzcus, this.zzcut, this.zzcuu, this.zzcuv, this.zzaxh, this.zzcof, this.zzcog, this.zzcuw, this.zzcux, this.zzcuy, this.zzcuz, this.zzcva, this.zzcvc, this.zzcvb);
    }
}

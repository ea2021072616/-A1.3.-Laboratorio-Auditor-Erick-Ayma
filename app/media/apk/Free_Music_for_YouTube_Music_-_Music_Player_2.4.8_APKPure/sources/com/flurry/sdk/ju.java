package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.flurry.sdk.lq;
/* loaded from: classes.dex */
public class ju implements lq.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2009a = ju.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static ju f2010b;

    /* renamed from: c  reason: collision with root package name */
    private String f2011c;
    private String d;

    private ju() {
        lp a2 = lp.a();
        this.f2011c = (String) a2.a("VersionName");
        a2.a("VersionName", (lq.a) this);
        km.a(4, f2009a, "initSettings, VersionName = " + this.f2011c);
    }

    public static synchronized ju a() {
        ju juVar;
        synchronized (ju.class) {
            if (f2010b == null) {
                f2010b = new ju();
            }
            juVar = f2010b;
        }
        return juVar;
    }

    public static String b() {
        return Build.VERSION.RELEASE;
    }

    public static String c() {
        return Build.DEVICE;
    }

    public static String d() {
        return Build.ID;
    }

    public static String e() {
        return Build.MANUFACTURER;
    }

    public static String f() {
        return Build.MODEL;
    }

    public static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "unknown";
        }
    }

    public final synchronized String g() {
        String str;
        if (!TextUtils.isEmpty(this.f2011c)) {
            str = this.f2011c;
        } else if (!TextUtils.isEmpty(this.d)) {
            str = this.d;
        } else {
            this.d = h();
            str = this.d;
        }
        return str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002e -> B:5:0x0019). Please submit an issue!!! */
    private static String h() {
        PackageInfo packageInfo;
        try {
            Context context = jy.a().f2022a;
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable th) {
            km.a(6, f2009a, "", th);
        }
        if (packageInfo.versionName != null) {
            return packageInfo.versionName;
        }
        if (packageInfo.versionCode != 0) {
            return Integer.toString(packageInfo.versionCode);
        }
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    @Override // com.flurry.sdk.lq.a
    public final void a(String str, Object obj) {
        if (str.equals("VersionName")) {
            this.f2011c = (String) obj;
            km.a(4, f2009a, "onSettingUpdate, VersionName = " + this.f2011c);
            return;
        }
        km.a(6, f2009a, "onSettingUpdate internal error!");
    }
}

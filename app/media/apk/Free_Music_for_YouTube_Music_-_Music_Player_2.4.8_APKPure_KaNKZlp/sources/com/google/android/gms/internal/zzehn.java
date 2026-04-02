package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.customtabs.CustomTabsService;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzehn {
    private static String zznhh;

    public static String zzex(Context context) {
        if (zznhh != null) {
            return zznhh;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        String str = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            zznhh = null;
        } else if (arrayList.size() == 1) {
            zznhh = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(str) && !zzk(context, intent) && arrayList.contains(str)) {
            zznhh = str;
        } else if (arrayList.contains("com.android.chrome")) {
            zznhh = "com.android.chrome";
        } else if (arrayList.contains("com.chrome.beta")) {
            zznhh = "com.chrome.beta";
        } else if (arrayList.contains("com.chrome.dev")) {
            zznhh = "com.chrome.dev";
        } else if (arrayList.contains("com.google.android.apps.chrome")) {
            zznhh = "com.google.android.apps.chrome";
        }
        return zznhh;
    }

    private static boolean zzk(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        try {
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        } catch (RuntimeException e) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
        if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            IntentFilter intentFilter = resolveInfo.filter;
            if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                return true;
            }
        }
        return false;
    }
}

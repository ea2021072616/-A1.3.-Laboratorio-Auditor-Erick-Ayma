package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzsb {
    private final zzakk zzbvz;

    public zzsb(zzakk zzakkVar) {
        this.zzbvz = zzakkVar;
    }

    private static Intent zza(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }

    private static ResolveInfo zza(Context context, Intent intent) {
        return zza(context, intent, new ArrayList());
    }

    private static ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
        ResolveInfo resolveInfo;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
        if (queryIntentActivities != null && resolveActivity != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= queryIntentActivities.size()) {
                    break;
                }
                ResolveInfo resolveInfo2 = queryIntentActivities.get(i2);
                if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                    resolveInfo = resolveActivity;
                    break;
                }
                i = i2 + 1;
            }
        }
        resolveInfo = null;
        arrayList.addAll(queryIntentActivities);
        return resolveInfo;
    }

    private static Intent zzf(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.Intent zza(android.content.Context r13, java.util.Map<java.lang.String, java.lang.String> r14) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsb.zza(android.content.Context, java.util.Map):android.content.Intent");
    }
}

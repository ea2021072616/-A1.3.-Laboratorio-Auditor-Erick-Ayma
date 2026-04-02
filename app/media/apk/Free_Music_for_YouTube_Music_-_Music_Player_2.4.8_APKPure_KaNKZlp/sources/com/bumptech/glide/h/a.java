package com.bumptech.glide.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: ApplicationVersionSignature.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap<String, com.bumptech.glide.load.c> f713a = new ConcurrentHashMap<>();

    public static com.bumptech.glide.load.c a(Context context) {
        String packageName = context.getPackageName();
        com.bumptech.glide.load.c cVar = f713a.get(packageName);
        if (cVar == null) {
            com.bumptech.glide.load.c b2 = b(context);
            com.bumptech.glide.load.c putIfAbsent = f713a.putIfAbsent(packageName, b2);
            return putIfAbsent == null ? b2 : putIfAbsent;
        }
        return cVar;
    }

    private static com.bumptech.glide.load.c b(Context context) {
        PackageInfo packageInfo;
        String uuid;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            ThrowableExtension.printStackTrace(e);
            packageInfo = null;
        }
        if (packageInfo != null) {
            uuid = String.valueOf(packageInfo.versionCode);
        } else {
            uuid = UUID.randomUUID().toString();
        }
        return new c(uuid);
    }
}

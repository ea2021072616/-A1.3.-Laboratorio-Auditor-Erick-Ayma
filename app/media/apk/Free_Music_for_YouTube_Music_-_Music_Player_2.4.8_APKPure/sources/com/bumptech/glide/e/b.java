package com.bumptech.glide.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ManifestParser.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f669a;

    public b(Context context) {
        this.f669a = context;
    }

    public List<a> a() {
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f669a.getPackageManager().getApplicationInfo(this.f669a.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(a(str));
                    }
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    private static a a(String str) {
        Object obj;
        Object obj2;
        try {
            try {
                Object newInstance = Class.forName(str).newInstance();
                if (!(newInstance instanceof a)) {
                    throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
                }
                return (a) newInstance;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + obj2, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + obj, e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }
}

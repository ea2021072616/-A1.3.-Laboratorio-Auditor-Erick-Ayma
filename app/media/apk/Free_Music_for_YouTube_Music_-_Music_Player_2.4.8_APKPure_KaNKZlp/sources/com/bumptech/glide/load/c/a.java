package com.bumptech.glide.load.c;

import android.net.Uri;
/* compiled from: AssetUriParser.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f862a = "file:///android_asset/".length();

    public static boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public static String b(Uri uri) {
        return uri.toString().substring(f862a);
    }
}

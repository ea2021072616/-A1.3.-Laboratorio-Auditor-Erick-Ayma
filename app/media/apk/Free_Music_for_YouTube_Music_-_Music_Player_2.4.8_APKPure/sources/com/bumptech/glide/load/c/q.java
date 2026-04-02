package com.bumptech.glide.load.c;

import android.content.Context;
import android.net.Uri;
/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public abstract class q<T> implements l<Uri, T> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f897a;

    /* renamed from: b  reason: collision with root package name */
    private final l<d, T> f898b;

    protected abstract com.bumptech.glide.load.a.c<T> a(Context context, Uri uri);

    protected abstract com.bumptech.glide.load.a.c<T> a(Context context, String str);

    public q(Context context, l<d, T> lVar) {
        this.f897a = context;
        this.f898b = lVar;
    }

    @Override // com.bumptech.glide.load.c.l
    public final com.bumptech.glide.load.a.c<T> a(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (a(scheme)) {
            if (a.a(uri)) {
                return a(this.f897a, a.b(uri));
            }
            return a(this.f897a, uri);
        } else if (this.f898b != null) {
            if (!"http".equals(scheme) && !"https".equals(scheme)) {
                return null;
            }
            return this.f898b.a(new d(uri.toString()), i, i2);
        } else {
            return null;
        }
    }

    private static boolean a(String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }
}

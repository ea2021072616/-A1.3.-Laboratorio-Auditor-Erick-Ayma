package com.bumptech.glide.load.c;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
/* compiled from: ResourceLoader.java */
/* loaded from: classes.dex */
public class n<T> implements l<Integer, T> {

    /* renamed from: a  reason: collision with root package name */
    private final l<Uri, T> f894a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f895b;

    public n(Context context, l<Uri, T> lVar) {
        this(context.getResources(), lVar);
    }

    public n(Resources resources, l<Uri, T> lVar) {
        this.f895b = resources;
        this.f894a = lVar;
    }

    @Override // com.bumptech.glide.load.c.l
    public com.bumptech.glide.load.a.c<T> a(Integer num, int i, int i2) {
        Uri uri;
        try {
            uri = Uri.parse("android.resource://" + this.f895b.getResourcePackageName(num.intValue()) + '/' + this.f895b.getResourceTypeName(num.intValue()) + '/' + this.f895b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            }
            uri = null;
        }
        if (uri != null) {
            return this.f894a.a(uri, i, i2);
        }
        return null;
    }
}

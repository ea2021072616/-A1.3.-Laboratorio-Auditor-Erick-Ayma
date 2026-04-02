package com.bumptech.glide.load.c.b;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.i;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.q;
import java.io.InputStream;
/* compiled from: StreamUriLoader.java */
/* loaded from: classes.dex */
public class g extends q<InputStream> implements d<Uri> {

    /* compiled from: StreamUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<Uri, InputStream> {
        @Override // com.bumptech.glide.load.c.m
        public l<Uri, InputStream> a(Context context, com.bumptech.glide.load.c.c cVar) {
            return new g(context, cVar.a(com.bumptech.glide.load.c.d.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.c.m
        public void a() {
        }
    }

    public g(Context context, l<com.bumptech.glide.load.c.d, InputStream> lVar) {
        super(context, lVar);
    }

    @Override // com.bumptech.glide.load.c.q
    protected com.bumptech.glide.load.a.c<InputStream> a(Context context, Uri uri) {
        return new i(context, uri);
    }

    @Override // com.bumptech.glide.load.c.q
    protected com.bumptech.glide.load.a.c<InputStream> a(Context context, String str) {
        return new com.bumptech.glide.load.a.h(context.getApplicationContext().getAssets(), str);
    }
}

package com.bumptech.glide.load.c.b;

import android.content.Context;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.r;
import java.io.InputStream;
import java.net.URL;
/* compiled from: StreamUrlLoader.java */
/* loaded from: classes.dex */
public class h extends r<InputStream> {

    /* compiled from: StreamUrlLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<URL, InputStream> {
        @Override // com.bumptech.glide.load.c.m
        public l<URL, InputStream> a(Context context, com.bumptech.glide.load.c.c cVar) {
            return new h(cVar.a(com.bumptech.glide.load.c.d.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.c.m
        public void a() {
        }
    }

    public h(l<com.bumptech.glide.load.c.d, InputStream> lVar) {
        super(lVar);
    }
}

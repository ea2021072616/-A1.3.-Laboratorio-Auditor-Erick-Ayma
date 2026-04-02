package com.bumptech.glide.load.c.b;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import java.io.File;
import java.io.InputStream;
/* compiled from: StreamFileLoader.java */
/* loaded from: classes.dex */
public class c extends com.bumptech.glide.load.c.b<InputStream> implements d<File> {

    /* compiled from: StreamFileLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<File, InputStream> {
        @Override // com.bumptech.glide.load.c.m
        public l<File, InputStream> a(Context context, com.bumptech.glide.load.c.c cVar) {
            return new c(cVar.a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.c.m
        public void a() {
        }
    }

    public c(l<Uri, InputStream> lVar) {
        super(lVar);
    }
}

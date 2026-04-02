package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.q;
/* compiled from: FileDescriptorUriLoader.java */
/* loaded from: classes.dex */
public class e extends q<ParcelFileDescriptor> implements b<Uri> {

    /* compiled from: FileDescriptorUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<Uri, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.c.m
        public l<Uri, ParcelFileDescriptor> a(Context context, com.bumptech.glide.load.c.c cVar) {
            return new e(context, cVar.a(com.bumptech.glide.load.c.d.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.c.m
        public void a() {
        }
    }

    public e(Context context, l<com.bumptech.glide.load.c.d, ParcelFileDescriptor> lVar) {
        super(context, lVar);
    }

    @Override // com.bumptech.glide.load.c.q
    protected com.bumptech.glide.load.a.c<ParcelFileDescriptor> a(Context context, Uri uri) {
        return new com.bumptech.glide.load.a.e(context, uri);
    }

    @Override // com.bumptech.glide.load.c.q
    protected com.bumptech.glide.load.a.c<ParcelFileDescriptor> a(Context context, String str) {
        return new com.bumptech.glide.load.a.d(context.getApplicationContext().getAssets(), str);
    }
}

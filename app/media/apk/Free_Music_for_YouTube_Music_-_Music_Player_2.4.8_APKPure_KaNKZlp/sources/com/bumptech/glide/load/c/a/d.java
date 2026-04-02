package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.p;
/* compiled from: FileDescriptorStringLoader.java */
/* loaded from: classes.dex */
public class d extends p<ParcelFileDescriptor> implements b<String> {

    /* compiled from: FileDescriptorStringLoader.java */
    /* loaded from: classes.dex */
    public static class a implements m<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.c.m
        public l<String, ParcelFileDescriptor> a(Context context, com.bumptech.glide.load.c.c cVar) {
            return new d(cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.c.m
        public void a() {
        }
    }

    public d(l<Uri, ParcelFileDescriptor> lVar) {
        super(lVar);
    }
}

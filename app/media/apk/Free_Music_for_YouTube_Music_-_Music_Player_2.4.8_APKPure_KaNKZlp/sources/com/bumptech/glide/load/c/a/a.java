package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import java.io.File;
/* compiled from: FileDescriptorFileLoader.java */
/* loaded from: classes.dex */
public class a extends com.bumptech.glide.load.c.b<ParcelFileDescriptor> implements b<File> {

    /* compiled from: FileDescriptorFileLoader.java */
    /* renamed from: com.bumptech.glide.load.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0029a implements m<File, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.c.m
        public l<File, ParcelFileDescriptor> a(Context context, com.bumptech.glide.load.c.c cVar) {
            return new a(cVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.c.m
        public void a() {
        }
    }

    public a(l<Uri, ParcelFileDescriptor> lVar) {
        super(lVar);
    }
}

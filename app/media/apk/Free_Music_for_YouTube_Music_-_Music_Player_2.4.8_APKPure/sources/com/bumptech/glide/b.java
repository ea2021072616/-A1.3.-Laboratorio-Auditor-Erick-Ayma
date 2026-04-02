package com.bumptech.glide;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.l;
import java.io.InputStream;
/* compiled from: BitmapTypeRequest.java */
/* loaded from: classes.dex */
public class b<ModelType> extends a<ModelType, Bitmap> {
    private final com.bumptech.glide.load.c.l<ModelType, InputStream> g;
    private final com.bumptech.glide.load.c.l<ModelType, ParcelFileDescriptor> h;
    private final i i;
    private final l.c j;

    private static <A, R> com.bumptech.glide.f.e<A, com.bumptech.glide.load.c.g, Bitmap, R> a(i iVar, com.bumptech.glide.load.c.l<A, InputStream> lVar, com.bumptech.glide.load.c.l<A, ParcelFileDescriptor> lVar2, Class<R> cls, com.bumptech.glide.load.resource.e.c<Bitmap, R> cVar) {
        if (lVar == null && lVar2 == null) {
            return null;
        }
        if (cVar == null) {
            cVar = iVar.a(Bitmap.class, cls);
        }
        return new com.bumptech.glide.f.e<>(new com.bumptech.glide.load.c.f(lVar, lVar2), cVar, iVar.b(com.bumptech.glide.load.c.g.class, Bitmap.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e<ModelType, ?, ?, ?> eVar, com.bumptech.glide.load.c.l<ModelType, InputStream> lVar, com.bumptech.glide.load.c.l<ModelType, ParcelFileDescriptor> lVar2, l.c cVar) {
        super(a(eVar.f667c, lVar, lVar2, Bitmap.class, null), Bitmap.class, eVar);
        this.g = lVar;
        this.h = lVar2;
        this.i = eVar.f667c;
        this.j = cVar;
    }
}

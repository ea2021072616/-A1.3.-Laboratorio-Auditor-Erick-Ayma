package com.bumptech.glide;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.d.m;
import com.bumptech.glide.l;
import java.io.InputStream;
/* compiled from: DrawableTypeRequest.java */
/* loaded from: classes.dex */
public class d<ModelType> extends c<ModelType> {
    private final com.bumptech.glide.load.c.l<ModelType, InputStream> g;
    private final com.bumptech.glide.load.c.l<ModelType, ParcelFileDescriptor> h;
    private final l.c i;

    private static <A, Z, R> com.bumptech.glide.f.e<A, com.bumptech.glide.load.c.g, Z, R> a(i iVar, com.bumptech.glide.load.c.l<A, InputStream> lVar, com.bumptech.glide.load.c.l<A, ParcelFileDescriptor> lVar2, Class<Z> cls, Class<R> cls2, com.bumptech.glide.load.resource.e.c<Z, R> cVar) {
        if (lVar == null && lVar2 == null) {
            return null;
        }
        if (cVar == null) {
            cVar = iVar.a(cls, cls2);
        }
        return new com.bumptech.glide.f.e<>(new com.bumptech.glide.load.c.f(lVar, lVar2), cVar, iVar.b(com.bumptech.glide.load.c.g.class, cls));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Class<ModelType> cls, com.bumptech.glide.load.c.l<ModelType, InputStream> lVar, com.bumptech.glide.load.c.l<ModelType, ParcelFileDescriptor> lVar2, Context context, i iVar, m mVar, com.bumptech.glide.d.g gVar, l.c cVar) {
        super(context, cls, a(iVar, lVar, lVar2, com.bumptech.glide.load.resource.d.a.class, com.bumptech.glide.load.resource.a.b.class, null), iVar, mVar, gVar);
        this.g = lVar;
        this.h = lVar2;
        this.i = cVar;
    }

    public b<ModelType> l() {
        return (b) this.i.a(new b(this, this.g, this.h, this.i));
    }

    public h<ModelType> m() {
        return (h) this.i.a(new h(this, this.g, this.i));
    }
}

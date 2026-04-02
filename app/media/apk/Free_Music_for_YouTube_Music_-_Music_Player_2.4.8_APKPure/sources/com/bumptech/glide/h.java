package com.bumptech.glide;

import com.bumptech.glide.l;
import java.io.InputStream;
/* compiled from: GifTypeRequest.java */
/* loaded from: classes.dex */
public class h<ModelType> extends g<ModelType> {
    private final com.bumptech.glide.load.c.l<ModelType, InputStream> g;
    private final l.c h;

    private static <A, R> com.bumptech.glide.f.e<A, InputStream, com.bumptech.glide.load.resource.c.b, R> a(i iVar, com.bumptech.glide.load.c.l<A, InputStream> lVar, Class<R> cls, com.bumptech.glide.load.resource.e.c<com.bumptech.glide.load.resource.c.b, R> cVar) {
        if (lVar == null) {
            return null;
        }
        if (cVar == null) {
            cVar = iVar.a(com.bumptech.glide.load.resource.c.b.class, cls);
        }
        return new com.bumptech.glide.f.e<>(lVar, cVar, iVar.b(InputStream.class, com.bumptech.glide.load.resource.c.b.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e<ModelType, ?, ?, ?> eVar, com.bumptech.glide.load.c.l<ModelType, InputStream> lVar, l.c cVar) {
        super(a(eVar.f667c, lVar, com.bumptech.glide.load.resource.c.b.class, (com.bumptech.glide.load.resource.e.c) null), com.bumptech.glide.load.resource.c.b.class, eVar);
        this.g = lVar;
        this.h = cVar;
        c();
    }
}

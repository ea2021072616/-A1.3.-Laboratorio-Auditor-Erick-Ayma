package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.d.m;
import com.bumptech.glide.l;
/* compiled from: GenericTranscodeRequest.java */
/* loaded from: classes.dex */
public class f<ModelType, DataType, ResourceType> extends e<ModelType, DataType, ResourceType, ResourceType> {
    private final com.bumptech.glide.load.c.l<ModelType, DataType> g;
    private final Class<DataType> h;
    private final Class<ResourceType> i;
    private final l.c j;

    private static <A, T, Z, R> com.bumptech.glide.f.f<A, T, Z, R> a(i iVar, com.bumptech.glide.load.c.l<A, T> lVar, Class<T> cls, Class<Z> cls2, com.bumptech.glide.load.resource.e.c<Z, R> cVar) {
        return new com.bumptech.glide.f.e(lVar, cVar, iVar.b(cls, cls2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, i iVar, Class<ModelType> cls, com.bumptech.glide.load.c.l<ModelType, DataType> lVar, Class<DataType> cls2, Class<ResourceType> cls3, m mVar, com.bumptech.glide.d.g gVar, l.c cVar) {
        super(context, cls, a(iVar, lVar, cls2, cls3, com.bumptech.glide.load.resource.e.e.b()), cls3, iVar, mVar, gVar);
        this.g = lVar;
        this.h = cls2;
        this.i = cls3;
        this.j = cVar;
    }
}

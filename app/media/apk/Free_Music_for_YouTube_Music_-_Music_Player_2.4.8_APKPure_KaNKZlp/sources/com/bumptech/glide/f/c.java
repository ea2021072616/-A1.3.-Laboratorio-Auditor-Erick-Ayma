package com.bumptech.glide.f;

import com.bumptech.glide.i.g;
import java.util.HashMap;
import java.util.Map;
/* compiled from: DataLoadProviderRegistry.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final g f673a = new g();

    /* renamed from: b  reason: collision with root package name */
    private final Map<g, b<?, ?>> f674b = new HashMap();

    public <T, Z> void a(Class<T> cls, Class<Z> cls2, b<T, Z> bVar) {
        this.f674b.put(new g(cls, cls2), bVar);
    }

    public <T, Z> b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        b<T, Z> bVar;
        synchronized (f673a) {
            f673a.a(cls, cls2);
            bVar = (b<T, Z>) this.f674b.get(f673a);
        }
        if (bVar == null) {
            return d.e();
        }
        return bVar;
    }
}

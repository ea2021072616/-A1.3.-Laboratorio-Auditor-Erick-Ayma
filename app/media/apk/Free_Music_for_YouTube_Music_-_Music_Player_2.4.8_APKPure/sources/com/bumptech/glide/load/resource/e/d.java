package com.bumptech.glide.load.resource.e;

import com.bumptech.glide.i.g;
import java.util.HashMap;
import java.util.Map;
/* compiled from: TranscoderRegistry.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final g f1004a = new g();

    /* renamed from: b  reason: collision with root package name */
    private final Map<g, c<?, ?>> f1005b = new HashMap();

    public <Z, R> void a(Class<Z> cls, Class<R> cls2, c<Z, R> cVar) {
        this.f1005b.put(new g(cls, cls2), cVar);
    }

    public <Z, R> c<Z, R> a(Class<Z> cls, Class<R> cls2) {
        c<Z, R> cVar;
        if (cls.equals(cls2)) {
            return e.b();
        }
        synchronized (f1004a) {
            f1004a.a(cls, cls2);
            cVar = (c<Z, R>) this.f1005b.get(f1004a);
        }
        if (cVar == null) {
            throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
        }
        return cVar;
    }
}

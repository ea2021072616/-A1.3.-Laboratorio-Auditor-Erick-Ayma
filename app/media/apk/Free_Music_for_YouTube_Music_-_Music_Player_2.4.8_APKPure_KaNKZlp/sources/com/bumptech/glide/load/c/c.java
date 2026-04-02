package com.bumptech.glide.load.c;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* compiled from: GenericLoaderFactory.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final l f867c = new l() { // from class: com.bumptech.glide.load.c.c.1
        @Override // com.bumptech.glide.load.c.l
        public com.bumptech.glide.load.a.c a(Object obj, int i, int i2) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class, Map<Class, m>> f868a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class, Map<Class, l>> f869b = new HashMap();
    private final Context d;

    public c(Context context) {
        this.d = context.getApplicationContext();
    }

    public synchronized <T, Y> m<T, Y> a(Class<T> cls, Class<Y> cls2, m<T, Y> mVar) {
        m<T, Y> put;
        this.f869b.clear();
        Map<Class, m> map = this.f868a.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f868a.put(cls, map);
        }
        put = map.put(cls2, mVar);
        if (put != null) {
            Iterator<Map<Class, m>> it = this.f868a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().containsValue(put)) {
                    put = null;
                    break;
                }
            }
        }
        return put;
    }

    public synchronized <T, Y> l<T, Y> a(Class<T> cls, Class<Y> cls2) {
        l<T, Y> c2;
        c2 = c(cls, cls2);
        if (c2 != null) {
            if (f867c.equals(c2)) {
                c2 = null;
            }
        } else {
            m<T, Y> d = d(cls, cls2);
            if (d != null) {
                c2 = d.a(this.d, this);
                a(cls, cls2, c2);
            } else {
                b(cls, cls2);
            }
        }
        return c2;
    }

    private <T, Y> void b(Class<T> cls, Class<Y> cls2) {
        a(cls, cls2, f867c);
    }

    private <T, Y> void a(Class<T> cls, Class<Y> cls2, l<T, Y> lVar) {
        Map<Class, l> map = this.f869b.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f869b.put(cls, map);
        }
        map.put(cls2, lVar);
    }

    private <T, Y> l<T, Y> c(Class<T> cls, Class<Y> cls2) {
        Map<Class, l> map = this.f869b.get(cls);
        if (map == null) {
            return null;
        }
        return map.get(cls2);
    }

    private <T, Y> m<T, Y> d(Class<T> cls, Class<Y> cls2) {
        m mVar;
        Map<Class, m> map;
        Map<Class, m> map2 = this.f868a.get(cls);
        if (map2 == null) {
            mVar = null;
        } else {
            mVar = map2.get(cls2);
        }
        if (mVar == null) {
            Iterator<Class> it = this.f868a.keySet().iterator();
            while (true) {
                m<T, Y> mVar2 = mVar;
                if (!it.hasNext()) {
                    return mVar2;
                }
                Class next = it.next();
                if (!next.isAssignableFrom(cls) || (map = this.f868a.get(next)) == null) {
                    mVar = mVar2;
                } else {
                    mVar = map.get(cls2);
                    if (mVar != null) {
                        return mVar;
                    }
                }
            }
        } else {
            return mVar;
        }
    }
}

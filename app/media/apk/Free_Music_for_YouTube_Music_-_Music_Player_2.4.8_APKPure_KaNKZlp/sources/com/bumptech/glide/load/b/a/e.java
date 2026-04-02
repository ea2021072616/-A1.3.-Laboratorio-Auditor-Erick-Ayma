package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.b.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
class e<K extends h, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f782a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f783b = new HashMap();

    public void a(K k, V v) {
        a<K, V> aVar = this.f783b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f783b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a((a<K, V>) v);
    }

    public V a(K k) {
        a<K, V> aVar = this.f783b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f783b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public V a() {
        a aVar = this.f782a.f785b;
        while (true) {
            a aVar2 = aVar;
            if (!aVar2.equals(this.f782a)) {
                V v = (V) aVar2.a();
                if (v == null) {
                    d(aVar2);
                    this.f783b.remove(aVar2.f786c);
                    ((h) aVar2.f786c).a();
                    aVar = aVar2.f785b;
                } else {
                    return v;
                }
            } else {
                return null;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f782a.f784a; !aVar.equals(this.f782a); aVar = aVar.f784a) {
            z = true;
            sb.append('{').append(aVar.f786c).append(':').append(aVar.b()).append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(" )").toString();
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        aVar.f785b = this.f782a;
        aVar.f784a = this.f782a.f784a;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.f785b = this.f782a.f785b;
        aVar.f784a = this.f782a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.f784a.f785b = aVar;
        aVar.f785b.f784a = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f785b.f784a = aVar.f784a;
        aVar.f784a.f785b = aVar.f785b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        a<K, V> f784a;

        /* renamed from: b  reason: collision with root package name */
        a<K, V> f785b;

        /* renamed from: c  reason: collision with root package name */
        private final K f786c;
        private List<V> d;

        public a() {
            this(null);
        }

        public a(K k) {
            this.f785b = this;
            this.f784a = this;
            this.f786c = k;
        }

        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.d.remove(b2 - 1);
            }
            return null;
        }

        public int b() {
            if (this.d != null) {
                return this.d.size();
            }
            return 0;
        }

        public void a(V v) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(v);
        }
    }
}

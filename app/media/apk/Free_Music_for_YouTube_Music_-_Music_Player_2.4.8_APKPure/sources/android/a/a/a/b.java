package android.a.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private c<K, V> f43a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f44b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap<Object<K, V>, Boolean> f45c = new WeakHashMap<>();
    private int d = 0;

    public int a() {
        return this.d;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f43a, this.f44b);
        this.f45c.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> b() {
        C0001b c0001b = new C0001b(this.f44b, this.f43a);
        this.f45c.put(c0001b, false);
        return c0001b;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f45c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f43a;
    }

    public Map.Entry<K, V> e() {
        return this.f44b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (a() == bVar.a()) {
                Iterator<Map.Entry<K, V>> it = iterator();
                Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    Map.Entry<K, V> next2 = it2.next();
                    if (next == null && next2 != null) {
                        return false;
                    }
                    if (next != null && !next.equals(next2)) {
                        return false;
                    }
                }
                return (it.hasNext() || it2.hasNext()) ? false : true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f52a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f53b;

        abstract c<K, V> a(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f52a = cVar2;
            this.f53b = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f53b != null;
        }

        private c<K, V> b() {
            if (this.f53b == this.f52a || this.f52a == null) {
                return null;
            }
            return a(this.f53b);
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f53b;
            this.f53b = b();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.a.a.a.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.f48c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: android.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0001b<K, V> extends e<K, V> {
        C0001b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.a.a.a.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private c<K, V> f50b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f51c;

        private d() {
            this.f51c = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f51c ? b.this.f43a != null : (this.f50b == null || this.f50b.f48c == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (this.f51c) {
                this.f51c = false;
                this.f50b = b.this.f43a;
            } else {
                this.f50b = this.f50b != null ? this.f50b.f48c : null;
            }
            return this.f50b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final K f46a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        final V f47b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f48c;
        c<K, V> d;

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.f46a;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.f47b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f46a + "=" + this.f47b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f46a.equals(cVar.f46a) && this.f47b.equals(cVar.f47b);
            }
            return false;
        }
    }
}

package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class h implements Map, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public transient l f1874b;

    /* renamed from: c  reason: collision with root package name */
    public transient m f1875c;

    /* renamed from: d  reason: collision with root package name */
    public transient n f1876d;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        n nVar = this.f1876d;
        if (nVar == null) {
            o oVar = (o) this;
            n nVar2 = new n(1, oVar.f1936g, oVar.f1935f);
            this.f1876d = nVar2;
            nVar = nVar2;
        }
        return nVar.contains(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        l lVar = this.f1874b;
        if (lVar == null) {
            o oVar = (o) this;
            l lVar2 = new l(oVar, oVar.f1935f, oVar.f1936g);
            this.f1874b = lVar2;
            return lVar2;
        }
        return lVar;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        l lVar = this.f1874b;
        if (lVar == null) {
            o oVar = (o) this;
            l lVar2 = new l(oVar, oVar.f1935f, oVar.f1936g);
            this.f1874b = lVar2;
            lVar = lVar2;
        }
        Iterator it = lVar.iterator();
        int i5 = 0;
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return i5;
            }
            E next = bVar.next();
            i5 += next != 0 ? next.hashCode() : 0;
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return ((o) this).f1936g == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        m mVar = this.f1875c;
        if (mVar == null) {
            o oVar = (o) this;
            m mVar2 = new m(oVar, new n(0, oVar.f1936g, oVar.f1935f));
            this.f1875c = mVar2;
            return mVar2;
        }
        return mVar;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int i5 = ((o) this).f1936g;
        if (i5 >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(i5 * 8, 1073741824L));
            sb.append('{');
            Iterator it = ((l) entrySet()).iterator();
            boolean z4 = true;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!z4) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                z4 = false;
            }
            sb.append('}');
            return sb.toString();
        }
        throw new IllegalArgumentException(androidx.appcompat.widget.b0.f("size cannot be negative but was: ", i5));
    }

    @Override // java.util.Map
    public final Collection values() {
        n nVar = this.f1876d;
        if (nVar == null) {
            o oVar = (o) this;
            n nVar2 = new n(1, oVar.f1936g, oVar.f1935f);
            this.f1876d = nVar2;
            return nVar2;
        }
        return nVar;
    }
}

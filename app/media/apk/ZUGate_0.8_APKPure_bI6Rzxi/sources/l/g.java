package l;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class g implements Set {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3691b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h.d f3692c;

    public /* synthetic */ g(h.d dVar, int i5) {
        this.f3691b = i5;
        this.f3692c = dVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f3691b) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f3691b) {
            case 0:
                h.d dVar = this.f3692c;
                int f5 = dVar.f();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    dVar.i(entry.getKey(), entry.getValue());
                }
                return f5 != dVar.f();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        int i5 = this.f3691b;
        h.d dVar = this.f3692c;
        switch (i5) {
            case 0:
                dVar.c();
                return;
            default:
                dVar.c();
                return;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        int i5 = this.f3691b;
        boolean z4 = true;
        h.d dVar = this.f3692c;
        switch (i5) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int g5 = dVar.g(entry.getKey());
                    if (g5 < 0) {
                        return false;
                    }
                    Object d5 = dVar.d(g5, 1);
                    Object value = entry.getValue();
                    if (d5 != value && (d5 == null || !d5.equals(value))) {
                        z4 = false;
                    }
                    return z4;
                }
                return false;
            default:
                return dVar.g(obj) >= 0;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f3691b) {
            case 0:
                for (Object obj : collection) {
                    if (!contains(obj)) {
                        return false;
                    }
                }
                return true;
            default:
                b e5 = this.f3692c.e();
                for (Object obj2 : collection) {
                    if (!e5.containsKey(obj2)) {
                        return false;
                    }
                }
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.f3691b) {
            case 0:
                return h.d.l(this, obj);
            default:
                return h.d.l(this, obj);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        int i5 = this.f3691b;
        h.d dVar = this.f3692c;
        switch (i5) {
            case 0:
                int i6 = 0;
                for (int f5 = dVar.f() - 1; f5 >= 0; f5--) {
                    Object d5 = dVar.d(f5, 0);
                    Object d6 = dVar.d(f5, 1);
                    i6 += (d5 == null ? 0 : d5.hashCode()) ^ (d6 == null ? 0 : d6.hashCode());
                }
                return i6;
            default:
                int i7 = 0;
                for (int f6 = dVar.f() - 1; f6 >= 0; f6--) {
                    Object d7 = dVar.d(f6, 0);
                    i7 += d7 == null ? 0 : d7.hashCode();
                }
                return i7;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        int i5 = this.f3691b;
        h.d dVar = this.f3692c;
        switch (i5) {
            case 0:
                return dVar.f() == 0;
            default:
                return dVar.f() == 0;
        }
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        int i5 = this.f3691b;
        h.d dVar = this.f3692c;
        switch (i5) {
            case 0:
                return new h(dVar);
            default:
                return new f(dVar, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f3691b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                h.d dVar = this.f3692c;
                int g5 = dVar.g(obj);
                if (g5 >= 0) {
                    dVar.j(g5);
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f3691b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                b e5 = this.f3692c.e();
                int i5 = e5.f3705d;
                for (Object obj : collection) {
                    e5.remove(obj);
                }
                return i5 != e5.f3705d;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f3691b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return h.d.n(this.f3692c.e(), collection);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        int i5 = this.f3691b;
        h.d dVar = this.f3692c;
        switch (i5) {
            case 0:
                return dVar.f();
            default:
                return dVar.f();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.f3691b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                h.d dVar = this.f3692c;
                int f5 = dVar.f();
                Object[] objArr = new Object[f5];
                for (int i5 = 0; i5 < f5; i5++) {
                    objArr[i5] = dVar.d(i5, 0);
                }
                return objArr;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f3691b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return this.f3692c.o(0, objArr);
        }
    }
}

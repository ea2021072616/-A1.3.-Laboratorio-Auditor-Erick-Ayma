package l;

import java.util.Collection;
import java.util.Iterator;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class i implements Collection {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3697b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f3698c;

    public i() {
        this.f3697b = 1;
        this.f3698c = new WeakHashMap();
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f3697b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                WeakHashMap weakHashMap = (WeakHashMap) this.f3698c;
                if (weakHashMap.containsKey(obj)) {
                    return false;
                }
                weakHashMap.put(obj, Boolean.TRUE);
                return true;
        }
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f3697b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return false;
        }
    }

    @Override // java.util.Collection
    public final void clear() {
        int i5 = this.f3697b;
        Object obj = this.f3698c;
        switch (i5) {
            case 0:
                ((h.d) obj).c();
                return;
            default:
                ((WeakHashMap) obj).clear();
                return;
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        int i5 = this.f3697b;
        Object obj2 = this.f3698c;
        switch (i5) {
            case 0:
                return ((h.d) obj2).h(obj) >= 0;
            default:
                return ((WeakHashMap) obj2).containsKey(obj);
        }
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f3697b) {
            case 0:
                for (Object obj : collection) {
                    if (!contains(obj)) {
                        return false;
                    }
                }
                return true;
            default:
                return false;
        }
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        int i5 = this.f3697b;
        Object obj = this.f3698c;
        switch (i5) {
            case 0:
                return ((h.d) obj).f() == 0;
            default:
                return ((WeakHashMap) obj).isEmpty();
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        int i5 = this.f3697b;
        Object obj = this.f3698c;
        switch (i5) {
            case 0:
                return new f((h.d) obj, 1);
            default:
                return ((WeakHashMap) obj).keySet().iterator();
        }
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        int i5 = this.f3697b;
        Object obj2 = this.f3698c;
        switch (i5) {
            case 0:
                h.d dVar = (h.d) obj2;
                int h5 = dVar.h(obj);
                if (h5 >= 0) {
                    dVar.j(h5);
                    return true;
                }
                return false;
            default:
                return ((WeakHashMap) obj2).remove(obj) != null;
        }
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i5 = 0;
        switch (this.f3697b) {
            case 0:
                h.d dVar = (h.d) this.f3698c;
                int f5 = dVar.f();
                boolean z4 = false;
                while (i5 < f5) {
                    if (collection.contains(dVar.d(i5, 1))) {
                        dVar.j(i5);
                        i5--;
                        f5--;
                        z4 = true;
                    }
                    i5++;
                }
                return z4;
            default:
                return false;
        }
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i5 = 0;
        switch (this.f3697b) {
            case 0:
                h.d dVar = (h.d) this.f3698c;
                int f5 = dVar.f();
                boolean z4 = false;
                while (i5 < f5) {
                    if (!collection.contains(dVar.d(i5, 1))) {
                        dVar.j(i5);
                        i5--;
                        f5--;
                        z4 = true;
                    }
                    i5++;
                }
                return z4;
            default:
                return false;
        }
    }

    @Override // java.util.Collection
    public final int size() {
        int i5 = this.f3697b;
        Object obj = this.f3698c;
        switch (i5) {
            case 0:
                return ((h.d) obj).f();
            default:
                return ((WeakHashMap) obj).size();
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        int i5 = this.f3697b;
        Object obj = this.f3698c;
        switch (i5) {
            case 0:
                h.d dVar = (h.d) obj;
                int f5 = dVar.f();
                Object[] objArr = new Object[f5];
                for (int i6 = 0; i6 < f5; i6++) {
                    objArr[i6] = dVar.d(i6, 1);
                }
                return objArr;
            default:
                return ((WeakHashMap) obj).keySet().toArray();
        }
    }

    public i(h.d dVar) {
        this.f3697b = 0;
        this.f3698c = dVar;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        int i5 = this.f3697b;
        Object obj = this.f3698c;
        switch (i5) {
            case 0:
                return ((h.d) obj).o(1, objArr);
            default:
                return ((WeakHashMap) obj).keySet().toArray(objArr);
        }
    }
}

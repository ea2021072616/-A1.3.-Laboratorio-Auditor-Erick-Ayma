package l;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class h implements Iterator, Map.Entry {

    /* renamed from: b  reason: collision with root package name */
    public int f3693b;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h.d f3696e;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3695d = false;

    /* renamed from: c  reason: collision with root package name */
    public int f3694c = -1;

    public h(h.d dVar) {
        this.f3696e = dVar;
        this.f3693b = dVar.f() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this.f3695d) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                int i5 = this.f3694c;
                h.d dVar = this.f3696e;
                Object d5 = dVar.d(i5, 0);
                if (key == d5 || (key != null && key.equals(d5))) {
                    Object value = entry.getValue();
                    Object d6 = dVar.d(this.f3694c, 1);
                    return value == d6 || (value != null && value.equals(d6));
                }
                return false;
            }
            return false;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f3695d) {
            return this.f3696e.d(this.f3694c, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f3695d) {
            return this.f3696e.d(this.f3694c, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3694c < this.f3693b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (this.f3695d) {
            int i5 = this.f3694c;
            h.d dVar = this.f3696e;
            Object d5 = dVar.d(i5, 0);
            Object d6 = dVar.d(this.f3694c, 1);
            return (d5 == null ? 0 : d5.hashCode()) ^ (d6 != null ? d6.hashCode() : 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f3694c++;
            this.f3695d = true;
            return this;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f3695d) {
            throw new IllegalStateException();
        }
        this.f3696e.j(this.f3694c);
        this.f3694c--;
        this.f3693b--;
        this.f3695d = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f3695d) {
            return this.f3696e.k(this.f3694c, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}

package h0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class e0 implements Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f3120b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Iterator f3121c;

    public e0(Iterator it) {
        this.f3121c = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3121c.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object next = this.f3121c.next();
        Iterator it = (Iterator) e1.f3122d.c(next);
        ArrayList arrayList = this.f3120b;
        if (it == null || !it.hasNext()) {
            while (!this.f3121c.hasNext() && (!arrayList.isEmpty())) {
                if (arrayList.isEmpty()) {
                    throw new NoSuchElementException("List is empty.");
                }
                this.f3121c = (Iterator) arrayList.get(e4.e.r(arrayList));
                if (arrayList.isEmpty()) {
                    throw new NoSuchElementException("List is empty.");
                }
                arrayList.remove(e4.e.r(arrayList));
            }
        } else {
            arrayList.add(this.f3121c);
            this.f3121c = it;
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

package o4;

import c4.b;
import c4.f;
import c4.g;
import e4.e;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class a implements Iterator, b {

    /* renamed from: b  reason: collision with root package name */
    public int f4116b;

    /* renamed from: c  reason: collision with root package name */
    public Object f4117c;

    /* renamed from: d  reason: collision with root package name */
    public Iterator f4118d;

    /* renamed from: e  reason: collision with root package name */
    public b f4119e;

    @Override // c4.b
    public final f a() {
        return g.f1790b;
    }

    public final RuntimeException b() {
        int i5 = this.f4116b;
        if (i5 != 4) {
            if (i5 != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.f4116b);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    @Override // c4.b
    public final void c(Object obj) {
        e.Y(obj);
        this.f4116b = 4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i5 = this.f4116b;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2 || i5 == 3) {
                        return true;
                    }
                    if (i5 == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator it = this.f4118d;
                e.c(it);
                if (it.hasNext()) {
                    this.f4116b = 2;
                    return true;
                }
                this.f4118d = null;
            }
            this.f4116b = 5;
            b bVar = this.f4119e;
            e.c(bVar);
            this.f4119e = null;
            bVar.c(a4.e.f34a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i5 = this.f4116b;
        if (i5 == 0 || i5 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        } else if (i5 == 2) {
            this.f4116b = 1;
            Iterator it = this.f4118d;
            e.c(it);
            return it.next();
        } else if (i5 == 3) {
            this.f4116b = 0;
            Object obj = this.f4117c;
            this.f4117c = null;
            return obj;
        } else {
            throw b();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

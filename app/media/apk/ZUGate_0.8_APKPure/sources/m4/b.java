package m4;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class b implements Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final int f3989b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3990c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3991d;

    /* renamed from: e  reason: collision with root package name */
    public int f3992e;

    public b(int i5, int i6, int i7) {
        this.f3989b = i7;
        this.f3990c = i6;
        boolean z4 = true;
        if (i7 <= 0 ? i5 < i6 : i5 > i6) {
            z4 = false;
        }
        this.f3991d = z4;
        this.f3992e = z4 ? i5 : i6;
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public final Object next() {
        int i5 = this.f3992e;
        if (i5 != this.f3990c) {
            this.f3992e = this.f3989b + i5;
        } else if (!this.f3991d) {
            throw new NoSuchElementException();
        } else {
            this.f3991d = false;
        }
        return Integer.valueOf(i5);
    }

    public final void b() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3991d;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void remove() {
        b();
        throw null;
    }
}

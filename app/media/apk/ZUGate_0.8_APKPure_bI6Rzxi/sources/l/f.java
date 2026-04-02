package l;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class f implements Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final int f3686b;

    /* renamed from: c  reason: collision with root package name */
    public int f3687c;

    /* renamed from: d  reason: collision with root package name */
    public int f3688d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3689e = false;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ h.d f3690f;

    public f(h.d dVar, int i5) {
        this.f3690f = dVar;
        this.f3686b = i5;
        this.f3687c = dVar.f();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3688d < this.f3687c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            Object d5 = this.f3690f.d(this.f3688d, this.f3686b);
            this.f3688d++;
            this.f3689e = true;
            return d5;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f3689e) {
            throw new IllegalStateException();
        }
        int i5 = this.f3688d - 1;
        this.f3688d = i5;
        this.f3687c--;
        this.f3689e = false;
        this.f3690f.j(i5);
    }
}

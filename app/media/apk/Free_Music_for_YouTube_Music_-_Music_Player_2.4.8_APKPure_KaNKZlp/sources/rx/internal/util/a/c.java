package rx.internal.util.a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: SpscAtomicArrayQueue.java */
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: c  reason: collision with root package name */
    final AtomicLong f5576c;
    long d;
    final AtomicLong e;
    final int f;

    @Override // rx.internal.util.a.a, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // rx.internal.util.a.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public c(int i) {
        super(i);
        this.f5576c = new AtomicLong();
        this.e = new AtomicLong();
        this.f = Math.min(i / 4, g.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.f5573a;
        int i = this.f5574b;
        long j = this.f5576c.get();
        int a2 = a(j, i);
        if (j >= this.d) {
            int i2 = this.f;
            if (a(atomicReferenceArray, a(i2 + j, i)) == null) {
                this.d = i2 + j;
            } else if (a(atomicReferenceArray, a2) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, a2, e);
        b(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.e.get();
        int a2 = a(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.f5573a;
        E a3 = a(atomicReferenceArray, a2);
        if (a3 == null) {
            return null;
        }
        a(atomicReferenceArray, a2, null);
        c(j + 1);
        return a3;
    }

    @Override // java.util.Queue
    public E peek() {
        return a(a(this.e.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long a2 = a();
        while (true) {
            long b2 = b();
            long a3 = a();
            if (a2 == a3) {
                return (int) (b2 - a3);
            }
            a2 = a3;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return b() == a();
    }

    private void b(long j) {
        this.f5576c.lazySet(j);
    }

    private void c(long j) {
        this.e.lazySet(j);
    }

    private long a() {
        return this.e.get();
    }

    private long b() {
        return this.f5576c.get();
    }
}

package rx.internal.util.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;
/* compiled from: SpscExactAtomicArrayQueue.java */
/* loaded from: classes2.dex */
public final class d<T> extends AtomicReferenceArray<T> implements Queue<T> {
    private static final long serialVersionUID = 6210984603741293445L;

    /* renamed from: a  reason: collision with root package name */
    final int f5577a;

    /* renamed from: b  reason: collision with root package name */
    final int f5578b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicLong f5579c;
    final AtomicLong d;

    public d(int i) {
        super(Pow2.roundToPowerOfTwo(i));
        int length = length();
        this.f5577a = length - 1;
        this.f5578b = length - i;
        this.f5579c = new AtomicLong();
        this.d = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        long j = this.f5579c.get();
        int i = this.f5577a;
        if (get(((int) (this.f5578b + j)) & i) != null) {
            return false;
        }
        this.f5579c.lazySet(j + 1);
        lazySet(i & ((int) j), t);
        return true;
    }

    @Override // java.util.Queue
    public T poll() {
        long j = this.d.get();
        int i = this.f5577a & ((int) j);
        T t = get(i);
        if (t == null) {
            return null;
        }
        this.d.lazySet(j + 1);
        lazySet(i, null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        return get(((int) this.d.get()) & this.f5577a);
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f5579c == this.d;
    }

    @Override // java.util.Collection
    public int size() {
        long j = this.d.get();
        while (true) {
            long j2 = this.f5579c.get();
            long j3 = this.d.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }
}

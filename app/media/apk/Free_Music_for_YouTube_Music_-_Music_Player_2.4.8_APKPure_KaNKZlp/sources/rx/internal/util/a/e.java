package rx.internal.util.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;
/* compiled from: SpscUnboundedAtomicArrayQueue.java */
/* loaded from: classes2.dex */
public final class e<T> implements Queue<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f5580a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object j = new Object();

    /* renamed from: b  reason: collision with root package name */
    final AtomicLong f5581b;

    /* renamed from: c  reason: collision with root package name */
    int f5582c;
    long d;
    int e;
    AtomicReferenceArray<Object> f;
    int g;
    AtomicReferenceArray<Object> h;
    final AtomicLong i;

    public e(int i) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i));
        int i2 = roundToPowerOfTwo - 1;
        this.f5581b = new AtomicLong();
        this.i = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.f = atomicReferenceArray;
        this.e = i2;
        a(roundToPowerOfTwo);
        this.h = atomicReferenceArray;
        this.g = i2;
        this.d = i2 - 1;
        a(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f;
        long c2 = c();
        int i = this.e;
        int a2 = a(c2, i);
        if (c2 < this.d) {
            return a(atomicReferenceArray, t, c2, a2);
        }
        int i2 = this.f5582c;
        if (a(atomicReferenceArray, a(i2 + c2, i)) == null) {
            this.d = (i2 + c2) - 1;
            return a(atomicReferenceArray, t, c2, a2);
        } else if (a(atomicReferenceArray, a(1 + c2, i)) != null) {
            return a(atomicReferenceArray, t, c2, a2);
        } else {
            a(atomicReferenceArray, c2, a2, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i) {
        a(1 + j2);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f = atomicReferenceArray2;
        this.d = (j2 + j3) - 1;
        a(j2 + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, j);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, b(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.h;
        long d = d();
        int i = this.g;
        int a2 = a(d, i);
        T t = (T) a(atomicReferenceArray, a2);
        boolean z = t == j;
        if (t != null && !z) {
            b(d + 1);
            a(atomicReferenceArray, a2, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), d, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i) {
        this.h = atomicReferenceArray;
        int a2 = a(j2, i);
        T t = (T) a(atomicReferenceArray, a2);
        if (t == null) {
            return null;
        }
        b(1 + j2);
        a(atomicReferenceArray, a2, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.h;
        long d = d();
        int i = this.g;
        T t = (T) a(atomicReferenceArray, a(d, i));
        if (t == j) {
            return b(a(atomicReferenceArray), d, i);
        }
        return t;
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i) {
        this.h = atomicReferenceArray;
        return (T) a(atomicReferenceArray, a(j2, i));
    }

    @Override // java.util.Collection
    public int size() {
        long b2 = b();
        while (true) {
            long a2 = a();
            long b3 = b();
            if (b2 == b3) {
                return (int) (a2 - b3);
            }
            b2 = b3;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return a() == b();
    }

    private void a(int i) {
        this.f5582c = Math.min(i / 4, f5580a);
    }

    private long a() {
        return this.f5581b.get();
    }

    private long b() {
        return this.i.get();
    }

    private long c() {
        return this.f5581b.get();
    }

    private long d() {
        return this.i.get();
    }

    private void a(long j2) {
        this.f5581b.lazySet(j2);
    }

    private void b(long j2) {
        this.i.lazySet(j2);
    }

    private static int a(long j2, int i) {
        return b(((int) j2) & i);
    }

    private static int b(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
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

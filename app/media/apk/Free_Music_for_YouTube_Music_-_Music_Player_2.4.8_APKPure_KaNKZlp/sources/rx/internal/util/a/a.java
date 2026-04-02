package rx.internal.util.a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;
/* compiled from: AtomicReferenceArrayQueue.java */
/* loaded from: classes2.dex */
abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    protected final AtomicReferenceArray<E> f5573a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f5574b;

    public a(int i) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.f5574b = roundToPowerOfTwo - 1;
        this.f5573a = new AtomicReferenceArray<>(roundToPowerOfTwo);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(long j, int i) {
        return ((int) j) & i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(long j) {
        return ((int) j) & this.f5574b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.lazySet(i, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(int i) {
        return a(this.f5573a, i);
    }
}

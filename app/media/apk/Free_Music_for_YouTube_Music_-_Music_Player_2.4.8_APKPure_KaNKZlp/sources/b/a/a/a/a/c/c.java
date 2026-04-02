package b.a.a.a.a.c;

import b.a.a.a.a.c.b;
import b.a.a.a.a.c.i;
import b.a.a.a.a.c.l;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: DependencyPriorityBlockingQueue.java */
/* loaded from: classes.dex */
public class c<E extends b & l & i> extends PriorityBlockingQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    final Queue<E> f162a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private final ReentrantLock f163b = new ReentrantLock();

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* renamed from: a */
    public E take() throws InterruptedException {
        return b(0, null, null);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    /* renamed from: b */
    public E peek() {
        try {
            return b(1, null, null);
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* renamed from: a */
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return b(3, Long.valueOf(j), timeUnit);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    /* renamed from: c */
    public E poll() {
        try {
            return b(2, null, null);
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public int size() {
        try {
            this.f163b.lock();
            return this.f162a.size() + super.size();
        } finally {
            this.f163b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        try {
            this.f163b.lock();
            return (T[]) a(super.toArray(tArr), this.f162a.toArray(tArr));
        } finally {
            this.f163b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        try {
            this.f163b.lock();
            return a(super.toArray(), this.f162a.toArray());
        } finally {
            this.f163b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        try {
            this.f163b.lock();
            int drainTo = super.drainTo(collection) + this.f162a.size();
            while (!this.f162a.isEmpty()) {
                collection.add(this.f162a.poll());
            }
            return drainTo;
        } finally {
            this.f163b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f163b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f162a.isEmpty() && drainTo <= i) {
                collection.add(this.f162a.poll());
                drainTo++;
            }
            return drainTo;
        } finally {
            this.f163b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        boolean z;
        try {
            this.f163b.lock();
            if (!super.contains(obj)) {
                if (!this.f162a.contains(obj)) {
                    z = false;
                    return z;
                }
            }
            z = true;
            return z;
        } finally {
            this.f163b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        try {
            this.f163b.lock();
            this.f162a.clear();
            super.clear();
        } finally {
            this.f163b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        boolean z;
        try {
            this.f163b.lock();
            if (!super.remove(obj)) {
                if (!this.f162a.remove(obj)) {
                    z = false;
                    return z;
                }
            }
            z = true;
            return z;
        } finally {
            this.f163b.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            this.f163b.lock();
            return super.removeAll(collection) | this.f162a.removeAll(collection);
        } finally {
            this.f163b.unlock();
        }
    }

    E a(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        switch (i) {
            case 0:
                return (E) ((b) super.take());
            case 1:
                return (E) ((b) super.peek());
            case 2:
                return (E) ((b) super.poll());
            case 3:
                return (E) ((b) super.poll(l.longValue(), timeUnit));
            default:
                return null;
        }
    }

    boolean a(int i, E e) {
        try {
            this.f163b.lock();
            if (i == 1) {
                super.remove(e);
            }
            return this.f162a.offer(e);
        } finally {
            this.f163b.unlock();
        }
    }

    E b(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        E a2;
        while (true) {
            a2 = a(i, l, timeUnit);
            if (a2 == null || a(a2)) {
                break;
            }
            a(i, (int) a2);
        }
        return a2;
    }

    boolean a(E e) {
        return e.areDependenciesMet();
    }

    public void d() {
        try {
            this.f163b.lock();
            Iterator<E> it = this.f162a.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (a(next)) {
                    super.offer(next);
                    it.remove();
                }
            }
        } finally {
            this.f163b.unlock();
        }
    }

    <T> T[] a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2));
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}

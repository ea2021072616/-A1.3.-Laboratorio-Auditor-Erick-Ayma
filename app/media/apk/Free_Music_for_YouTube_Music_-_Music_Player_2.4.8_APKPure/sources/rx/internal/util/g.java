package rx.internal.util;

import java.util.Queue;
import rx.internal.util.unsafe.SpmcArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.m;
/* compiled from: RxRingBuffer.java */
/* loaded from: classes2.dex */
public class g implements m {

    /* renamed from: b  reason: collision with root package name */
    public static final int f5597b;

    /* renamed from: a  reason: collision with root package name */
    public volatile Object f5598a;

    /* renamed from: c  reason: collision with root package name */
    private Queue<Object> f5599c;
    private final int d;

    static {
        int i = 128;
        if (f.a()) {
            i = 16;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        f5597b = i;
    }

    public static g a() {
        return UnsafeAccess.isUnsafeAvailable() ? new g(false, f5597b) : new g();
    }

    public static g b() {
        return UnsafeAccess.isUnsafeAvailable() ? new g(true, f5597b) : new g();
    }

    private g(Queue<Object> queue, int i) {
        this.f5599c = queue;
        this.d = i;
    }

    private g(boolean z, int i) {
        this.f5599c = z ? new SpmcArrayQueue<>(i) : new SpscArrayQueue<>(i);
        this.d = i;
    }

    public synchronized void c() {
    }

    @Override // rx.m
    public void unsubscribe() {
        c();
    }

    g() {
        this(new rx.internal.util.a.c(f5597b), f5597b);
    }

    public void a(Object obj) throws rx.b.c {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            Queue<Object> queue = this.f5599c;
            if (queue == null) {
                z2 = true;
                z = false;
            } else if (queue.offer(rx.internal.a.d.a(obj))) {
                z = false;
            }
        }
        if (z2) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z) {
            throw new rx.b.c();
        }
    }

    public void d() {
        if (this.f5598a == null) {
            this.f5598a = rx.internal.a.d.a();
        }
    }

    public boolean e() {
        Queue<Object> queue = this.f5599c;
        return queue == null || queue.isEmpty();
    }

    public Object f() {
        Object obj = null;
        synchronized (this) {
            Queue<Object> queue = this.f5599c;
            if (queue != null) {
                Object poll = queue.poll();
                obj = this.f5598a;
                if (poll == null && obj != null && queue.peek() == null) {
                    this.f5598a = null;
                } else {
                    obj = poll;
                }
            }
        }
        return obj;
    }

    public Object g() {
        Object obj;
        synchronized (this) {
            Queue<Object> queue = this.f5599c;
            if (queue == null) {
                obj = null;
            } else {
                Object peek = queue.peek();
                obj = this.f5598a;
                if (peek != null || obj == null || queue.peek() != null) {
                    obj = peek;
                }
            }
        }
        return obj;
    }

    public boolean b(Object obj) {
        return rx.internal.a.d.b(obj);
    }

    public Object c(Object obj) {
        return rx.internal.a.d.c(obj);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f5599c == null;
    }
}

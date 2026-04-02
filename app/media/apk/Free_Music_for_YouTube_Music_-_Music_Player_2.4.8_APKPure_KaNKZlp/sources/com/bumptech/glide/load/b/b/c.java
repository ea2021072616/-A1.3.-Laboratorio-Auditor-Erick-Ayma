package com.bumptech.glide.load.b.b;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<com.bumptech.glide.load.c, a> f800a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f801b = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.load.c cVar) {
        a aVar;
        synchronized (this) {
            aVar = this.f800a.get(cVar);
            if (aVar == null) {
                aVar = this.f801b.a();
                this.f800a.put(cVar, aVar);
            }
            aVar.f803b++;
        }
        aVar.f802a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.bumptech.glide.load.c cVar) {
        a aVar;
        synchronized (this) {
            aVar = this.f800a.get(cVar);
            if (aVar == null || aVar.f803b <= 0) {
                throw new IllegalArgumentException("Cannot release a lock that is not held, key: " + cVar + ", interestedThreads: " + (aVar == null ? 0 : aVar.f803b));
            }
            int i = aVar.f803b - 1;
            aVar.f803b = i;
            if (i == 0) {
                a remove = this.f800a.remove(cVar);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", key: " + cVar);
                }
                this.f801b.a(remove);
            }
        }
        aVar.f802a.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f802a;

        /* renamed from: b  reason: collision with root package name */
        int f803b;

        private a() {
            this.f802a = new ReentrantLock();
        }
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f804a;

        private b() {
            this.f804a = new ArrayDeque();
        }

        a a() {
            a poll;
            synchronized (this.f804a) {
                poll = this.f804a.poll();
            }
            if (poll == null) {
                return new a();
            }
            return poll;
        }

        void a(a aVar) {
            synchronized (this.f804a) {
                if (this.f804a.size() < 10) {
                    this.f804a.offer(aVar);
                }
            }
        }
    }
}

package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.b.a.h;
import java.util.Queue;
/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
abstract class b<T extends h> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f778a = com.bumptech.glide.i.h.a(20);

    protected abstract T b();

    /* JADX INFO: Access modifiers changed from: protected */
    public T c() {
        T poll = this.f778a.poll();
        if (poll == null) {
            return b();
        }
        return poll;
    }

    public void a(T t) {
        if (this.f778a.size() < 20) {
            this.f778a.offer(t);
        }
    }
}

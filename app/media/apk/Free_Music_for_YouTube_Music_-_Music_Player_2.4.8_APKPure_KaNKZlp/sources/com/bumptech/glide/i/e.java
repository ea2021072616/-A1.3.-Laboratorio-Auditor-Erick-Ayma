package com.bumptech.glide.i;

import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class e<T, Y> {

    /* renamed from: b  reason: collision with root package name */
    private int f728b;

    /* renamed from: c  reason: collision with root package name */
    private final int f729c;

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<T, Y> f727a = new LinkedHashMap<>(100, 0.75f, true);
    private int d = 0;

    public e(int i) {
        this.f729c = i;
        this.f728b = i;
    }

    protected int a(Y y) {
        return 1;
    }

    protected void a(T t, Y y) {
    }

    public int b() {
        return this.d;
    }

    public Y b(T t) {
        return this.f727a.get(t);
    }

    public Y b(T t, Y y) {
        if (a(y) >= this.f728b) {
            a(t, y);
            return null;
        }
        Y put = this.f727a.put(t, y);
        if (y != null) {
            this.d += a(y);
        }
        if (put != null) {
            this.d -= a(put);
        }
        c();
        return put;
    }

    public Y c(T t) {
        Y remove = this.f727a.remove(t);
        if (remove != null) {
            this.d -= a(remove);
        }
        return remove;
    }

    public void a() {
        b(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        while (this.d > i) {
            Map.Entry<T, Y> next = this.f727a.entrySet().iterator().next();
            Y value = next.getValue();
            this.d -= a(value);
            T key = next.getKey();
            this.f727a.remove(key);
            a(key, value);
        }
    }

    private void c() {
        b(this.f728b);
    }
}

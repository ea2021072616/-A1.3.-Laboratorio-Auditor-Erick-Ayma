package com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public final class kk<V> extends FutureTask<V> {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Callable<V>> f2051a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Runnable> f2052b;

    public kk(Runnable runnable, V v) {
        super(runnable, v);
        this.f2051a = new WeakReference<>(null);
        this.f2052b = new WeakReference<>(runnable);
    }

    public final Runnable a() {
        return this.f2052b.get();
    }
}

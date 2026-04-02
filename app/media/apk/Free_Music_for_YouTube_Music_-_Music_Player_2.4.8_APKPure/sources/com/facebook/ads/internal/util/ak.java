package com.facebook.ads.internal.util;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public abstract class ak<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<T> f1508a;

    public ak(T t) {
        this.f1508a = new WeakReference<>(t);
    }

    public T a() {
        return this.f1508a.get();
    }
}

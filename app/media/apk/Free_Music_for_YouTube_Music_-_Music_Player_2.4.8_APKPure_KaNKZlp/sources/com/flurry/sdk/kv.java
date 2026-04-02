package com.flurry.sdk;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class kv<T> extends WeakReference<T> {
    public kv(T t) {
        super(t);
    }

    public final int hashCode() {
        Object obj = get();
        return obj == null ? super.hashCode() : obj.hashCode();
    }

    public final boolean equals(Object obj) {
        Object obj2 = get();
        return obj instanceof Reference ? obj2.equals(((Reference) obj).get()) : obj2.equals(obj);
    }
}

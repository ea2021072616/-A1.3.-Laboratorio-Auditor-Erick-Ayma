package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzeew<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzlnx;

    public zzeew(Iterator<Map.Entry<K, Object>> it) {
        this.zzlnx = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzlnx.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzlnx.next();
        return next.getValue() instanceof zzeet ? new zzeev(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzlnx.remove();
    }
}

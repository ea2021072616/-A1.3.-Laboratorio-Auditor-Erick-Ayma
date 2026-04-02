package com.google.android.gms.internal;

import java.util.Map;
/* loaded from: classes2.dex */
final class zzeev<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzeet> zzmzp;

    private zzeev(Map.Entry<K, zzeet> entry) {
        this.zzmzp = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzmzp.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzmzp.getValue() == null) {
            return null;
        }
        return zzeet.zzccx();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzeey) {
            return this.zzmzp.getValue().zzg((zzeey) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}

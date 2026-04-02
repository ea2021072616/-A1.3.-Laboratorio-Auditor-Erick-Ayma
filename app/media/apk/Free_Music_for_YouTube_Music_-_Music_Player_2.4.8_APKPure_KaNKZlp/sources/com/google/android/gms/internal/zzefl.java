package com.google.android.gms.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
final class zzefl<K, V> extends AbstractSet<Map.Entry<K, V>> {
    private /* synthetic */ zzefe zznad;

    private zzefl(zzefe zzefeVar) {
        this.zznad = zzefeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzefl(zzefe zzefeVar, zzeff zzeffVar) {
        this(zzefeVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zznad.zza((zzefe) ((Comparable) entry.getKey()), (Comparable) entry.getValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zznad.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zznad.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzefk(this.zznad, null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            this.zznad.remove(entry.getKey());
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zznad.size();
    }
}

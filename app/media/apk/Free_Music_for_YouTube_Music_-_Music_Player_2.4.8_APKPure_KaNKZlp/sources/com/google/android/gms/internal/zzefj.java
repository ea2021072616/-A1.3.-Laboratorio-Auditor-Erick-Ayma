package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* loaded from: classes2.dex */
public final class zzefj<K, V> implements Comparable<zzefj>, Map.Entry<K, V> {
    private V value;
    private final Comparable zznac;
    private /* synthetic */ zzefe zznad;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public zzefj(zzefe zzefeVar, K k, V v) {
        this.zznad = zzefeVar;
        this.zznac = k;
        this.value = v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzefj(zzefe zzefeVar, Map.Entry<K, V> entry) {
        this(zzefeVar, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzefj zzefjVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzefjVar.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return equals(this.zznac, entry.getKey()) && equals(this.value, entry.getValue());
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zznac;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return (this.zznac == null ? 0 : this.zznac.hashCode()) ^ (this.value != null ? this.value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zznad.zzcdb();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zznac);
        String valueOf2 = String.valueOf(this.value);
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
    }
}

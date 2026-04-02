package com.google.android.gms.internal;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class zzefe<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzkeu;
    private final int zzmzv;
    private List<zzefj> zzmzw;
    private Map<K, V> zzmzx;
    private volatile zzefl zzmzy;
    private Map<K, V> zzmzz;

    private zzefe(int i) {
        this.zzmzv = i;
        this.zzmzw = Collections.emptyList();
        this.zzmzx = Collections.emptyMap();
        this.zzmzz = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzefe(int i, zzeff zzeffVar) {
        this(i);
    }

    private final int zza(K k) {
        int size = this.zzmzw.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzmzw.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        int i2 = size;
        while (i <= i2) {
            int i3 = (i + i2) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzmzw.get(i3).getKey());
            if (compareTo2 < 0) {
                i2 = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i = i3 + 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzcdb() {
        if (this.zzkeu) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzcdc() {
        zzcdb();
        if (this.zzmzx.isEmpty() && !(this.zzmzx instanceof TreeMap)) {
            this.zzmzx = new TreeMap();
            this.zzmzz = ((TreeMap) this.zzmzx).descendingMap();
        }
        return (SortedMap) this.zzmzx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzeec<FieldDescriptorType>> zzefe<FieldDescriptorType, Object> zzgv(int i) {
        return new zzeff(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzgx(int i) {
        zzcdb();
        V v = (V) this.zzmzw.remove(i).getValue();
        if (!this.zzmzx.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzcdc().entrySet().iterator();
            this.zzmzw.add(new zzefj(this, it.next()));
            it.remove();
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzcdb();
        if (!this.zzmzw.isEmpty()) {
            this.zzmzw.clear();
        }
        if (this.zzmzx.isEmpty()) {
            return;
        }
        this.zzmzx.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzefe<K, V>) comparable) >= 0 || this.zzmzx.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzmzy == null) {
            this.zzmzy = new zzefl(this, null);
        }
        return this.zzmzy;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzefe) {
            zzefe zzefeVar = (zzefe) obj;
            int size = size();
            if (size != zzefeVar.size()) {
                return false;
            }
            int zzccz = zzccz();
            if (zzccz != zzefeVar.zzccz()) {
                return entrySet().equals(zzefeVar.entrySet());
            }
            for (int i = 0; i < zzccz; i++) {
                if (!zzgw(i).equals(zzefeVar.zzgw(i))) {
                    return false;
                }
            }
            if (zzccz != size) {
                return this.zzmzx.equals(zzefeVar.zzmzx);
            }
            return true;
        }
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzefe<K, V>) comparable);
        return zza >= 0 ? (V) this.zzmzw.get(zza).getValue() : this.zzmzx.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int zzccz = zzccz();
        int i = 0;
        for (int i2 = 0; i2 < zzccz; i2++) {
            i += this.zzmzw.get(i2).hashCode();
        }
        return this.zzmzx.size() > 0 ? this.zzmzx.hashCode() + i : i;
    }

    public final boolean isImmutable() {
        return this.zzkeu;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzefe<K, V>) ((Comparable) obj), (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzcdb();
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzefe<K, V>) comparable);
        if (zza >= 0) {
            return (V) zzgx(zza);
        }
        if (this.zzmzx.isEmpty()) {
            return null;
        }
        return this.zzmzx.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzmzw.size() + this.zzmzx.size();
    }

    public final V zza(K k, V v) {
        zzcdb();
        int zza = zza((zzefe<K, V>) k);
        if (zza >= 0) {
            return (V) this.zzmzw.get(zza).setValue(v);
        }
        zzcdb();
        if (this.zzmzw.isEmpty() && !(this.zzmzw instanceof ArrayList)) {
            this.zzmzw = new ArrayList(this.zzmzv);
        }
        int i = -(zza + 1);
        if (i >= this.zzmzv) {
            return zzcdc().put(k, v);
        }
        if (this.zzmzw.size() == this.zzmzv) {
            zzefj remove = this.zzmzw.remove(this.zzmzv - 1);
            zzcdc().put((K) remove.getKey(), (V) remove.getValue());
        }
        this.zzmzw.add(i, new zzefj(this, k, v));
        return null;
    }

    public void zzbhq() {
        if (this.zzkeu) {
            return;
        }
        this.zzmzx = this.zzmzx.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzmzx);
        this.zzmzz = this.zzmzz.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzmzz);
        this.zzkeu = true;
    }

    public final int zzccz() {
        return this.zzmzw.size();
    }

    public final Iterable<Map.Entry<K, V>> zzcda() {
        return this.zzmzx.isEmpty() ? zzefg.zzcdd() : this.zzmzx.entrySet();
    }

    public final Map.Entry<K, V> zzgw(int i) {
        return this.zzmzw.get(i);
    }
}

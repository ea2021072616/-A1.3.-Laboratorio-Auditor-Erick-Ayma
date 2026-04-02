package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
final class zzefd<E> extends zzedi<E> {
    private static final zzefd<Object> zzmzt;
    private final List<E> zzmzu;

    static {
        zzefd<Object> zzefdVar = new zzefd<>();
        zzmzt = zzefdVar;
        zzefdVar.zzbhq();
    }

    zzefd() {
        this(new ArrayList(10));
    }

    private zzefd(List<E> list) {
        this.zzmzu = list;
    }

    public static <E> zzefd<E> zzccy() {
        return (zzefd<E>) zzmzt;
    }

    @Override // com.google.android.gms.internal.zzedi, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        zzcbl();
        this.zzmzu.add(i, e);
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.zzmzu.get(i);
    }

    @Override // com.google.android.gms.internal.zzedi, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzcbl();
        E remove = this.zzmzu.remove(i);
        this.modCount++;
        return remove;
    }

    @Override // com.google.android.gms.internal.zzedi, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        zzcbl();
        E e2 = this.zzmzu.set(i, e);
        this.modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzmzu.size();
    }

    @Override // com.google.android.gms.internal.zzeeq
    public final /* synthetic */ zzeeq zzgu(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzmzu);
        return new zzefd(arrayList);
    }
}

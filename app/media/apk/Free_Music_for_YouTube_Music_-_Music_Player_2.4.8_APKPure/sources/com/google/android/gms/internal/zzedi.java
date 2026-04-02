package com.google.android.gms.internal;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes2.dex */
abstract class zzedi<E> extends AbstractList<E> implements zzeeq<E> {
    private boolean zzmxq = true;

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        zzcbl();
        super.add(i, e);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        zzcbl();
        return super.add(e);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        zzcbl();
        return super.addAll(i, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        zzcbl();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        zzcbl();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            if (obj instanceof RandomAccess) {
                List list = (List) obj;
                int size = size();
                if (size != list.size()) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (!get(i).equals(list.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        zzcbl();
        return (E) super.remove(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        zzcbl();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        zzcbl();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        zzcbl();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        zzcbl();
        return (E) super.set(i, e);
    }

    @Override // com.google.android.gms.internal.zzeeq
    public final void zzbhq() {
        this.zzmxq = false;
    }

    @Override // com.google.android.gms.internal.zzeeq
    public final boolean zzcbk() {
        return this.zzmxq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzcbl() {
        if (!this.zzmxq) {
            throw new UnsupportedOperationException();
        }
    }
}

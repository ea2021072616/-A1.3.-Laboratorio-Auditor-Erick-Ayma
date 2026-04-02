package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class w0 extends t implements RandomAccess, x0 {

    /* renamed from: c  reason: collision with root package name */
    public final List f1984c;

    static {
        new w0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(int i5) {
        super(true);
        ArrayList arrayList = new ArrayList(i5);
        this.f1984c = arrayList;
    }

    @Override // com.google.android.gms.internal.play_billing.x0
    public final x0 a() {
        return this.f1959b ? new a2(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i5, Object obj) {
        e();
        this.f1984c.add(i5, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractList, java.util.List
    public final boolean addAll(int i5, Collection collection) {
        e();
        if (collection instanceof x0) {
            collection = ((x0) collection).c();
        }
        boolean addAll = this.f1984c.addAll(i5, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.play_billing.r0
    public final /* bridge */ /* synthetic */ r0 b(int i5) {
        if (i5 >= size()) {
            ArrayList arrayList = new ArrayList(i5);
            arrayList.addAll(this.f1984c);
            return new w0(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.play_billing.x0
    public final List c() {
        return Collections.unmodifiableList(this.f1984c);
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        e();
        this.f1984c.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.x0
    public final Object d(int i5) {
        return this.f1984c.get(i5);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g */
    public final String get(int i5) {
        String str;
        List list = this.f1984c;
        Object obj = list.get(i5);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof z)) {
            byte[] bArr = (byte[]) obj;
            String str2 = new String(bArr, s0.f1953a);
            l2.i iVar = h2.f1882a;
            int length = bArr.length;
            h2.f1882a.getClass();
            if (l2.i.e(bArr, 0, length)) {
                list.set(i5, str2);
            }
            return str2;
        }
        z zVar = (z) obj;
        Charset charset = s0.f1953a;
        if (zVar.i() == 0) {
            str = "";
        } else {
            a0 a0Var = (a0) zVar;
            str = new String(a0Var.f1833d, 0, a0Var.i(), charset);
        }
        a0 a0Var2 = (a0) zVar;
        if (h2.d(a0Var2.f1833d, 0, a0Var2.i())) {
            list.set(i5, str);
        }
        return str;
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractList, java.util.List
    public final Object remove(int i5) {
        e();
        Object remove = this.f1984c.remove(i5);
        ((AbstractList) this).modCount++;
        if (remove instanceof String) {
            return (String) remove;
        }
        if (remove instanceof z) {
            z zVar = (z) remove;
            Charset charset = s0.f1953a;
            if (zVar.i() == 0) {
                return "";
            }
            a0 a0Var = (a0) zVar;
            return new String(a0Var.f1833d, 0, a0Var.i(), charset);
        }
        return new String((byte[]) remove, s0.f1953a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        e();
        Object obj2 = this.f1984c.set(i5, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 instanceof z) {
            z zVar = (z) obj2;
            Charset charset = s0.f1953a;
            if (zVar.i() == 0) {
                return "";
            }
            a0 a0Var = (a0) zVar;
            return new String(a0Var.f1833d, 0, a0Var.i(), charset);
        }
        return new String((byte[]) obj2, s0.f1953a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1984c.size();
    }

    public w0(ArrayList arrayList) {
        super(true);
        this.f1984c = arrayList;
    }

    public w0() {
        super(false);
        this.f1984c = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.play_billing.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}

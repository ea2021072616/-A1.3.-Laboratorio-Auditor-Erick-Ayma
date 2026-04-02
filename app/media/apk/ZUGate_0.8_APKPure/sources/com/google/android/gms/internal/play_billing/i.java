package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class i extends c implements Set {

    /* renamed from: c  reason: collision with root package name */
    public transient f f1883c;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.c
    public f h() {
        f fVar = this.f1883c;
        if (fVar == null) {
            f k5 = k();
            this.f1883c = k5;
            return k5;
        }
        return fVar;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        Iterator it = iterator();
        int i5 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i5 += next != null ? next.hashCode() : 0;
        }
        return i5;
    }

    public f k() {
        Object[] array = toArray();
        d dVar = f.f1859c;
        int length = array.length;
        return length == 0 ? j.f1896f : new j(length, array);
    }
}

package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class x implements Iterator {
    @Override // java.util.Iterator
    public final Object next() {
        w wVar = (w) this;
        int i5 = wVar.f1981b;
        if (i5 < wVar.f1982c) {
            wVar.f1981b = i5 + 1;
            return Byte.valueOf(wVar.f1983d.h(i5));
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

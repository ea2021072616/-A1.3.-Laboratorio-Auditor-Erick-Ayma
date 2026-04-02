package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzedl implements Iterator {
    private final int limit;
    private int position = 0;
    private /* synthetic */ zzedk zzmxu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedl(zzedk zzedkVar) {
        this.zzmxu = zzedkVar;
        this.limit = this.zzmxu.size();
    }

    private final byte nextByte() {
        try {
            zzedk zzedkVar = this.zzmxu;
            int i = this.position;
            this.position = i + 1;
            return zzedkVar.zzgi(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

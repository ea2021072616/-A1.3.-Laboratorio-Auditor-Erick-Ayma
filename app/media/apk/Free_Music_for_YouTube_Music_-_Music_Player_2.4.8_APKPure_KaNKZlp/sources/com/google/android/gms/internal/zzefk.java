package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
final class zzefk<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private /* synthetic */ zzefe zznad;
    private boolean zznae;
    private Iterator<Map.Entry<K, V>> zznaf;

    private zzefk(zzefe zzefeVar) {
        this.zznad = zzefeVar;
        this.pos = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzefk(zzefe zzefeVar, zzeff zzeffVar) {
        this(zzefeVar);
    }

    private final Iterator<Map.Entry<K, V>> zzcdf() {
        Map map;
        if (this.zznaf == null) {
            map = this.zznad.zzmzx;
            this.zznaf = map.entrySet().iterator();
        }
        return this.zznaf;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.pos + 1;
        list = this.zznad.zzmzw;
        return i < list.size() || zzcdf().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.zznae = true;
        int i = this.pos + 1;
        this.pos = i;
        list = this.zznad.zzmzw;
        if (i < list.size()) {
            list2 = this.zznad.zzmzw;
            return (Map.Entry) list2.get(this.pos);
        }
        return zzcdf().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zznae) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zznae = false;
        this.zznad.zzcdb();
        int i = this.pos;
        list = this.zznad.zzmzw;
        if (i >= list.size()) {
            zzcdf().remove();
            return;
        }
        zzefe zzefeVar = this.zznad;
        int i2 = this.pos;
        this.pos = i2 - 1;
        zzefeVar.zzgx(i2);
    }
}

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzsk implements Iterable<zzsi> {
    private final List<zzsi> zzbwg = new LinkedList();

    public static boolean zze(zzakk zzakkVar) {
        zzsi zzg = zzg(zzakkVar);
        if (zzg != null) {
            zzg.zzbwd.abort();
            return true;
        }
        return false;
    }

    public static boolean zzf(zzakk zzakkVar) {
        return zzg(zzakkVar) != null;
    }

    private static zzsi zzg(zzakk zzakkVar) {
        Iterator<zzsi> it = com.google.android.gms.ads.internal.zzbv.zzex().iterator();
        while (it.hasNext()) {
            zzsi next = it.next();
            if (next.zzbvz == zzakkVar) {
                return next;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<zzsi> iterator() {
        return this.zzbwg.iterator();
    }

    public final void zza(zzsi zzsiVar) {
        this.zzbwg.add(zzsiVar);
    }

    public final void zzb(zzsi zzsiVar) {
        this.zzbwg.remove(zzsiVar);
    }

    public final int zzkg() {
        return this.zzbwg.size();
    }
}

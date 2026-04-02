package com.google.android.gms.internal;
/* loaded from: classes2.dex */
public final class zzeek implements zzeem {
    public static final zzeek zzmyz = new zzeek();

    private zzeek() {
    }

    @Override // com.google.android.gms.internal.zzeem
    public final int zza(boolean z, int i, boolean z2, int i2) {
        return z2 ? i2 : i;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final zzedk zza(boolean z, zzedk zzedkVar, boolean z2, zzedk zzedkVar2) {
        return z2 ? zzedkVar2 : zzedkVar;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final <T> zzeeq<T> zza(zzeeq<T> zzeeqVar, zzeeq<T> zzeeqVar2) {
        int size = zzeeqVar.size();
        int size2 = zzeeqVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzeeqVar.zzcbk()) {
                zzeeqVar = zzeeqVar.zzgu(size2 + size);
            }
            zzeeqVar.addAll(zzeeqVar2);
        }
        return size > 0 ? zzeeqVar : zzeeqVar2;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final <T extends zzeey> T zza(T t, T t2) {
        return (t == null || t2 == null) ? t == null ? t2 : t : (T) t.zzccn().zzc(t2).zzccs();
    }

    @Override // com.google.android.gms.internal.zzeem
    public final zzefq zza(zzefq zzefqVar, zzefq zzefqVar2) {
        return zzefqVar2 == zzefq.zzcdh() ? zzefqVar : zzefq.zzb(zzefqVar, zzefqVar2);
    }

    @Override // com.google.android.gms.internal.zzeem
    public final String zza(boolean z, String str, boolean z2, String str2) {
        return z2 ? str2 : str;
    }
}

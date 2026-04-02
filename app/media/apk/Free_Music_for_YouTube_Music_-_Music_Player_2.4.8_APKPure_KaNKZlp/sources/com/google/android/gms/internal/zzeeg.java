package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzeeg implements zzeem {
    static final zzeeg zzmyw = new zzeeg();
    private static zzeeh zzmyx = new zzeeh();

    private zzeeg() {
    }

    @Override // com.google.android.gms.internal.zzeem
    public final int zza(boolean z, int i, boolean z2, int i2) {
        if (z == z2 && i == i2) {
            return i;
        }
        throw zzmyx;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final zzedk zza(boolean z, zzedk zzedkVar, boolean z2, zzedk zzedkVar2) {
        if (z == z2 && zzedkVar.equals(zzedkVar2)) {
            return zzedkVar;
        }
        throw zzmyx;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final <T> zzeeq<T> zza(zzeeq<T> zzeeqVar, zzeeq<T> zzeeqVar2) {
        if (zzeeqVar.equals(zzeeqVar2)) {
            return zzeeqVar;
        }
        throw zzmyx;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final <T extends zzeey> T zza(T t, T t2) {
        if (t == null && t2 == null) {
            return null;
        }
        if (t == null || t2 == null) {
            throw zzmyx;
        }
        zzeed zzeedVar = (zzeed) t;
        if (zzeedVar == t2 || !((zzeed) zzeedVar.zza(zzeel.zzmzg, (Object) null, (Object) null)).getClass().isInstance(t2)) {
            return t;
        }
        zzeed zzeedVar2 = (zzeed) t2;
        zzeedVar.zza(zzeel.zzmzb, this, zzeedVar2);
        zzeedVar.zzmyr = zza(zzeedVar.zzmyr, zzeedVar2.zzmyr);
        return t;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final zzefq zza(zzefq zzefqVar, zzefq zzefqVar2) {
        if (zzefqVar.equals(zzefqVar2)) {
            return zzefqVar;
        }
        throw zzmyx;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final String zza(boolean z, String str, boolean z2, String str2) {
        if (z == z2 && str.equals(str2)) {
            return str;
        }
        throw zzmyx;
    }
}

package com.google.android.gms.internal;
/* loaded from: classes2.dex */
final class zzeej implements zzeem {
    int hashCode = 0;

    @Override // com.google.android.gms.internal.zzeem
    public final int zza(boolean z, int i, boolean z2, int i2) {
        this.hashCode = (this.hashCode * 53) + i;
        return i;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final zzedk zza(boolean z, zzedk zzedkVar, boolean z2, zzedk zzedkVar2) {
        this.hashCode = (this.hashCode * 53) + zzedkVar.hashCode();
        return zzedkVar;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final <T> zzeeq<T> zza(zzeeq<T> zzeeqVar, zzeeq<T> zzeeqVar2) {
        this.hashCode = (this.hashCode * 53) + zzeeqVar.hashCode();
        return zzeeqVar;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final <T extends zzeey> T zza(T t, T t2) {
        int i;
        if (t == null) {
            i = 37;
        } else if (t instanceof zzeed) {
            zzeed zzeedVar = (zzeed) t;
            if (zzeedVar.zzmxn == 0) {
                int i2 = this.hashCode;
                this.hashCode = 0;
                zzeedVar.zza(zzeel.zzmzb, this, zzeedVar);
                zzeedVar.zzmyr = zza(zzeedVar.zzmyr, zzeedVar.zzmyr);
                zzeedVar.zzmxn = this.hashCode;
                this.hashCode = i2;
            }
            i = zzeedVar.zzmxn;
        } else {
            i = t.hashCode();
        }
        this.hashCode = i + (this.hashCode * 53);
        return t;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final zzefq zza(zzefq zzefqVar, zzefq zzefqVar2) {
        this.hashCode = (this.hashCode * 53) + zzefqVar.hashCode();
        return zzefqVar;
    }

    @Override // com.google.android.gms.internal.zzeem
    public final String zza(boolean z, String str, boolean z2, String str2) {
        this.hashCode = (this.hashCode * 53) + str.hashCode();
        return str;
    }
}

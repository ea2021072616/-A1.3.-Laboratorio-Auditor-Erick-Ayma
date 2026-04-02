package com.google.android.gms.internal;

import android.os.Parcel;
@zzzt
/* loaded from: classes.dex */
public final class zzmb extends zzjb {
    public zzmb(zzjb zzjbVar) {
        super(zzjbVar.zzbcq, zzjbVar.height, zzjbVar.heightPixels, zzjbVar.zzbcr, zzjbVar.width, zzjbVar.widthPixels, zzjbVar.zzbcs, zzjbVar.zzbct, zzjbVar.zzbcu, zzjbVar.zzbcv);
    }

    @Override // com.google.android.gms.internal.zzjb, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzbcq, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 3, this.height);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 6, this.width);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

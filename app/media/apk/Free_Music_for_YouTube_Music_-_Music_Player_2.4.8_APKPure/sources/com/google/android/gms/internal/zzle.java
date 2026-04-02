package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
@zzzt
/* loaded from: classes.dex */
public final class zzle extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzle> CREATOR = new zzlf();
    public final int zzbdp;

    public zzle(int i) {
        this.zzbdp = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 2, this.zzbdp);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

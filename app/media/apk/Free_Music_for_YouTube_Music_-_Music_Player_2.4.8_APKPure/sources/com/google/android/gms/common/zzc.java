package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzc extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();
    private String name;
    private int version;

    public zzc(String str, int i) {
        this.name = str;
        this.version = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 1, this.name, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 2, this.version);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

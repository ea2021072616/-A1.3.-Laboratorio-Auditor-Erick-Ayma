package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
@zzzt
/* loaded from: classes.dex */
public final class zzadp extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzadp> CREATOR = new zzadq();
    public final String zzath;
    public final zzix zzcnw;

    public zzadp(zzix zzixVar, String str) {
        this.zzcnw = zzixVar;
        this.zzath = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, (Parcelable) this.zzcnw, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.zzath, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
@zzzt
/* loaded from: classes.dex */
public final class zzabo extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzabo> CREATOR = new zzabp();
    String zzbqu;

    public zzabo(String str) {
        this.zzbqu = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzbqu, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

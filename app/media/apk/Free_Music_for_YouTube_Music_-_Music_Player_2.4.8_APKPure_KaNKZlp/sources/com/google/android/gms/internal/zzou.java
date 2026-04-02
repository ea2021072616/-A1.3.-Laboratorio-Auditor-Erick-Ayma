package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class zzou implements Parcelable.Creator<zzot> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzot createFromParcel(Parcel parcel) {
        int i = 0;
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        zzmd zzmdVar = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 2:
                    z2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 4:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 6:
                    zzmdVar = (zzmd) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzmd.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzot(i3, z2, i2, z, i, zzmdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzot[] newArray(int i) {
        return new zzot[i];
    }
}

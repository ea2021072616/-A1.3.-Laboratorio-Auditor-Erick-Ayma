package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class zzme implements Parcelable.Creator<zzmd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmd createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        boolean z2 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    z2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzmd(z2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmd[] newArray(int i) {
        return new zzmd[i];
    }
}

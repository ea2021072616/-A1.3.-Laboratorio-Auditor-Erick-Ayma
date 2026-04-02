package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzadq implements Parcelable.Creator<zzadp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzadp createFromParcel(Parcel parcel) {
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        String str = null;
        zzix zzixVar = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    zzixVar = (zzix) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzix.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzadp(zzixVar, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzadp[] newArray(int i) {
        return new zzadp[i];
    }
}

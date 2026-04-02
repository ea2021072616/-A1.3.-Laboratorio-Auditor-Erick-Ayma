package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class zzjc implements Parcelable.Creator<zzjb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjb createFromParcel(Parcel parcel) {
        zzjb[] zzjbVarArr = null;
        boolean z = false;
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 3:
                    i4 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 4:
                    i3 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 5:
                    z4 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 6:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 8:
                    zzjbVarArr = (zzjb[]) com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt, zzjb.CREATOR);
                    break;
                case 9:
                    z3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 10:
                    z2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 11:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzjb(str, i4, i3, z4, i2, i, zzjbVarArr, z3, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjb[] newArray(int i) {
        return new zzjb[i];
    }
}

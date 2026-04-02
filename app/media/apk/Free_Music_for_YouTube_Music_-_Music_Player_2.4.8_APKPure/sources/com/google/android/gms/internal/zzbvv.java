package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class zzbvv implements Parcelable.Creator<zzbvu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbvu createFromParcel(Parcel parcel) {
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 2:
                    bArr = com.google.android.gms.common.internal.safeparcel.zzb.zzt(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzbvu(i, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbvu[] newArray(int i) {
        return new zzbvu[i];
    }
}

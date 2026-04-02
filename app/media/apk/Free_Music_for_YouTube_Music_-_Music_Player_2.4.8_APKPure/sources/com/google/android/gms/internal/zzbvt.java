package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class zzbvt implements Parcelable.Creator<zzbvs> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbvs createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
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
        return new zzbvs(i, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbvs[] newArray(int i) {
        return new zzbvs[i];
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzajl implements Parcelable.Creator<zzajk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajk createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        String str = null;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 5:
                    z2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 6:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzajk(str, i2, i, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajk[] newArray(int i) {
        return new zzajk[i];
    }
}

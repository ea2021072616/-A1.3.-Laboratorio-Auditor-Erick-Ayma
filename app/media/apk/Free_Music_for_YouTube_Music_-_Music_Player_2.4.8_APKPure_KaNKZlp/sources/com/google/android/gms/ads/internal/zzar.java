package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzar implements Parcelable.Creator<zzaq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaq createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        String str = null;
        float f = 0.0f;
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    z4 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 3:
                    z3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 5:
                    z2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 6:
                    f = com.google.android.gms.common.internal.safeparcel.zzb.zzl(parcel, readInt);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 8:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzaq(z4, z3, str, z2, f, i, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaq[] newArray(int i) {
        return new zzaq[i];
    }
}

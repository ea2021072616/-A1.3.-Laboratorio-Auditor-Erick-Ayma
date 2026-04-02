package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzaet implements Parcelable.Creator<zzaes> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaes createFromParcel(Parcel parcel) {
        ArrayList<String> arrayList = null;
        boolean z = false;
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 4:
                    z4 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 5:
                    z3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 6:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 7:
                    z2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
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
        return new zzaes(str2, str, z4, z3, arrayList, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaes[] newArray(int i) {
        return new zzaes[i];
    }
}

package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class zziz implements Parcelable.Creator<zzix> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzix createFromParcel(Parcel parcel) {
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        zzlz zzlzVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, readInt);
                    break;
                case 3:
                    bundle = com.google.android.gms.common.internal.safeparcel.zzb.zzs(parcel, readInt);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 6:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 7:
                    i3 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 8:
                    z2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 9:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 10:
                    zzlzVar = (zzlz) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzlz.CREATOR);
                    break;
                case 11:
                    location = (Location) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, Location.CREATOR);
                    break;
                case 12:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 13:
                    bundle2 = com.google.android.gms.common.internal.safeparcel.zzb.zzs(parcel, readInt);
                    break;
                case 14:
                    bundle3 = com.google.android.gms.common.internal.safeparcel.zzb.zzs(parcel, readInt);
                    break;
                case 15:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 16:
                    str3 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 17:
                    str4 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 18:
                    z3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzix(i, j, bundle, i2, arrayList, z, i3, z2, str, zzlzVar, location, str2, bundle2, bundle3, arrayList2, str3, str4, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzix[] newArray(int i) {
        return new zzix[i];
    }
}

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzaap implements Parcelable.Creator<zzaao> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaao createFromParcel(Parcel parcel) {
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        int i2 = 0;
        ArrayList<String> arrayList2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        ArrayList<String> arrayList3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        zzaba zzabaVar = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        boolean z9 = false;
        zzaek zzaekVar = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        boolean z10 = false;
        zzaaq zzaaqVar = null;
        boolean z11 = false;
        String str9 = null;
        ArrayList<String> arrayList6 = null;
        boolean z12 = false;
        String str10 = null;
        zzaes zzaesVar = null;
        String str11 = null;
        boolean z13 = false;
        boolean z14 = false;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 5:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 6:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 7:
                    j = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, readInt);
                    break;
                case 8:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 9:
                    j2 = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, readInt);
                    break;
                case 10:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, readInt);
                    break;
                case 12:
                    i3 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 13:
                    str3 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 14:
                    j4 = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, readInt);
                    break;
                case 15:
                    str4 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 16:
                case 17:
                case 20:
                case 27:
                case 41:
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
                case 18:
                    z2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 19:
                    str5 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 21:
                    str6 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 22:
                    z3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 23:
                    z4 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 24:
                    z5 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 25:
                    z6 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 26:
                    z7 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 28:
                    zzabaVar = (zzaba) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzaba.CREATOR);
                    break;
                case 29:
                    str7 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 30:
                    str8 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 31:
                    z8 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 32:
                    z9 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 33:
                    zzaekVar = (zzaek) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzaek.CREATOR);
                    break;
                case 34:
                    arrayList4 = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 35:
                    arrayList5 = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 36:
                    z10 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 37:
                    zzaaqVar = (zzaaq) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzaaq.CREATOR);
                    break;
                case 38:
                    z11 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 39:
                    str9 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 40:
                    arrayList6 = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 42:
                    z12 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 43:
                    str10 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 44:
                    zzaesVar = (zzaes) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzaes.CREATOR);
                    break;
                case 45:
                    str11 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 46:
                    z13 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 47:
                    z14 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 48:
                    bundle = com.google.android.gms.common.internal.safeparcel.zzb.zzs(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzaao(i, str, str2, arrayList, i2, arrayList2, j, z, j2, arrayList3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, zzabaVar, str7, str8, z8, z9, zzaekVar, arrayList4, arrayList5, z10, zzaaqVar, z11, str9, arrayList6, z12, str10, zzaesVar, str11, z13, z14, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaao[] newArray(int i) {
        return new zzaao[i];
    }
}

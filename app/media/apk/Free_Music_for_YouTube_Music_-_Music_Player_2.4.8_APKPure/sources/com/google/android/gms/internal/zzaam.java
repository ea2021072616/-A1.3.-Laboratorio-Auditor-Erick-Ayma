package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzaam implements Parcelable.Creator<zzaak> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaak createFromParcel(Parcel parcel) {
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        int i = 0;
        Bundle bundle = null;
        zzix zzixVar = null;
        zzjb zzjbVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzajk zzajkVar = null;
        Bundle bundle2 = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        ArrayList<String> arrayList2 = null;
        String str7 = null;
        zzot zzotVar = null;
        ArrayList<String> arrayList3 = null;
        long j2 = 0;
        String str8 = null;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        int i7 = 0;
        Bundle bundle4 = null;
        String str11 = null;
        zzle zzleVar = null;
        boolean z6 = false;
        Bundle bundle5 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        boolean z7 = false;
        ArrayList<Integer> arrayList4 = null;
        String str15 = null;
        ArrayList<String> arrayList5 = null;
        int i8 = 0;
        boolean z8 = false;
        boolean z9 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 2:
                    bundle = com.google.android.gms.common.internal.safeparcel.zzb.zzs(parcel, readInt);
                    break;
                case 3:
                    zzixVar = (zzix) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzix.CREATOR);
                    break;
                case 4:
                    zzjbVar = (zzjb) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzjb.CREATOR);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 9:
                    str3 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 10:
                    str4 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 11:
                    zzajkVar = (zzajk) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzajk.CREATOR);
                    break;
                case 12:
                    bundle2 = com.google.android.gms.common.internal.safeparcel.zzb.zzs(parcel, readInt);
                    break;
                case 13:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 14:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 15:
                    bundle3 = com.google.android.gms.common.internal.safeparcel.zzb.zzs(parcel, readInt);
                    break;
                case 16:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 17:
                case 22:
                case 23:
                case 24:
                case 32:
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
                case 18:
                    i3 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 19:
                    i4 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 20:
                    f = com.google.android.gms.common.internal.safeparcel.zzb.zzl(parcel, readInt);
                    break;
                case 21:
                    str5 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 25:
                    j = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, readInt);
                    break;
                case 26:
                    str6 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 27:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 28:
                    str7 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 29:
                    zzotVar = (zzot) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzot.CREATOR);
                    break;
                case 30:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 31:
                    j2 = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, readInt);
                    break;
                case 33:
                    str8 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 34:
                    f2 = com.google.android.gms.common.internal.safeparcel.zzb.zzl(parcel, readInt);
                    break;
                case 35:
                    i5 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 36:
                    i6 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 37:
                    z3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 38:
                    z4 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 39:
                    str9 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 40:
                    z2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 41:
                    str10 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 42:
                    z5 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 43:
                    i7 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 44:
                    bundle4 = com.google.android.gms.common.internal.safeparcel.zzb.zzs(parcel, readInt);
                    break;
                case 45:
                    str11 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 46:
                    zzleVar = (zzle) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzle.CREATOR);
                    break;
                case 47:
                    z6 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 48:
                    bundle5 = com.google.android.gms.common.internal.safeparcel.zzb.zzs(parcel, readInt);
                    break;
                case 49:
                    str12 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 50:
                    str13 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 51:
                    str14 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 52:
                    z7 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 53:
                    arrayList4 = com.google.android.gms.common.internal.safeparcel.zzb.zzab(parcel, readInt);
                    break;
                case 54:
                    str15 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 55:
                    arrayList5 = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 56:
                    i8 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 57:
                    z8 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 58:
                    z9 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzaak(i, bundle, zzixVar, zzjbVar, str, applicationInfo, packageInfo, str2, str3, str4, zzajkVar, bundle2, i2, arrayList, bundle3, z, i3, i4, f, str5, j, str6, arrayList2, str7, zzotVar, arrayList3, j2, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11, zzleVar, z6, bundle5, str12, str13, str14, z7, arrayList4, str15, arrayList5, i8, z8, z9);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaak[] newArray(int i) {
        return new zzaak[i];
    }
}

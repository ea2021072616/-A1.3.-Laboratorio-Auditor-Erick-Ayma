package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzabe implements Parcelable.Creator<zzabd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzabd createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        PackageInfo packageInfo = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        ApplicationInfo applicationInfo = null;
        zzajk zzajkVar = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    bundle = com.google.android.gms.common.internal.safeparcel.zzb.zzs(parcel, readInt);
                    break;
                case 2:
                    zzajkVar = (zzajk) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzajk.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 6:
                    packageInfo = (PackageInfo) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, PackageInfo.CREATOR);
                    break;
                case 7:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzabd(bundle, zzajkVar, applicationInfo, str2, arrayList, packageInfo, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzabd[] newArray(int i) {
        return new zzabd[i];
    }
}

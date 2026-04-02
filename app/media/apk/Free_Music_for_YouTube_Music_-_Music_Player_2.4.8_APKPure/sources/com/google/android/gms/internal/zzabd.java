package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzabd extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzabd> CREATOR = new zzabe();
    private ApplicationInfo applicationInfo;
    private String packageName;
    private PackageInfo zzcnx;
    private List<String> zzcok;
    private String zzcot;
    private Bundle zzcqu;
    private zzajk zzcqv;

    public zzabd(Bundle bundle, zzajk zzajkVar, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, String str2) {
        this.zzcqu = bundle;
        this.zzcqv = zzajkVar;
        this.packageName = str;
        this.applicationInfo = applicationInfo;
        this.zzcok = list;
        this.zzcnx = packageInfo;
        this.zzcot = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 1, this.zzcqu, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, (Parcelable) this.zzcqv, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, (Parcelable) this.applicationInfo, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 5, this.zzcok, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, (Parcelable) this.zzcnx, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 7, this.zzcot, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

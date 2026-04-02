package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class zzbvs extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzbvs> CREATOR = new zzbvt();
    private String packageName;
    private int versionCode;
    private String zzhqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvs(int i, String str, String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzhqb = str2;
    }

    public zzbvs(String str, String str2) {
        this(1, str, str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.zzhqb, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

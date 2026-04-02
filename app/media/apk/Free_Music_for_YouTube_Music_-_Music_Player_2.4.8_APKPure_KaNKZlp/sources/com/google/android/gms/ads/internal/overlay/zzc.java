package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzc extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();
    public final Intent intent;
    public final String mimeType;
    public final String packageName;
    public final String url;
    private String zzcez;
    public final String zzcfa;
    public final String zzcfb;
    private String zzcfc;

    public zzc(Intent intent) {
        this(null, null, null, null, null, null, null, intent);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, null);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent) {
        this.zzcez = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzcfa = str5;
        this.zzcfb = str6;
        this.zzcfc = str7;
        this.intent = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzcez, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.url, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.mimeType, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, this.zzcfa, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 7, this.zzcfb, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzcfc, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 9, (Parcelable) this.intent, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

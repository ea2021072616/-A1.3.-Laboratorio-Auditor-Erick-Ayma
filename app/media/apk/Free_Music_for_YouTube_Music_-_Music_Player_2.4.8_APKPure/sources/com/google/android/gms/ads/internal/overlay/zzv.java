package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzajk;
/* loaded from: classes.dex */
public final class zzv implements Parcelable.Creator<AdOverlayInfoParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        zzc zzcVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        zzajk zzajkVar = null;
        String str4 = null;
        com.google.android.gms.ads.internal.zzaq zzaqVar = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    zzcVar = (zzc) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zzb.zzr(parcel, readInt);
                    break;
                case 4:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zzb.zzr(parcel, readInt);
                    break;
                case 5:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zzb.zzr(parcel, readInt);
                    break;
                case 6:
                    iBinder4 = com.google.android.gms.common.internal.safeparcel.zzb.zzr(parcel, readInt);
                    break;
                case 7:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 8:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 9:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 10:
                    iBinder5 = com.google.android.gms.common.internal.safeparcel.zzb.zzr(parcel, readInt);
                    break;
                case 11:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 13:
                    str3 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 14:
                    zzajkVar = (zzajk) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, zzajk.CREATOR);
                    break;
                case 15:
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
                case 16:
                    str4 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 17:
                    zzaqVar = (com.google.android.gms.ads.internal.zzaq) com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, readInt, com.google.android.gms.ads.internal.zzaq.CREATOR);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new AdOverlayInfoParcel(zzcVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, zzajkVar, str4, zzaqVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}

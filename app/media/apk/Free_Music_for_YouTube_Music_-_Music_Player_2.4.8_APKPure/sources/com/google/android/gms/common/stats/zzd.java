package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzd implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        ArrayList<String> arrayList = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
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
                case 7:
                case 9:
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 5:
                    i3 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 6:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel, readInt);
                    break;
                case 8:
                    j2 = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, readInt);
                    break;
                case 10:
                    str3 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 11:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 12:
                    str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 13:
                    str4 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 14:
                    i4 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, readInt);
                    break;
                case 15:
                    f = com.google.android.gms.common.internal.safeparcel.zzb.zzl(parcel, readInt);
                    break;
                case 16:
                    j3 = com.google.android.gms.common.internal.safeparcel.zzb.zzi(parcel, readInt);
                    break;
                case 17:
                    str5 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3, str5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}

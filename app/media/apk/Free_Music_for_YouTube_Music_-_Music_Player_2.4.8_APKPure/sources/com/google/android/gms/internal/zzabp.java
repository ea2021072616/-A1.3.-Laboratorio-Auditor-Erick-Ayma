package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzabp implements Parcelable.Creator<zzabo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzabo createFromParcel(Parcel parcel) {
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzabo(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzabo[] newArray(int i) {
        return new zzabo[i];
    }
}

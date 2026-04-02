package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<PublisherAdViewOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PublisherAdViewOptions createFromParcel(Parcel parcel) {
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        boolean z = false;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, readInt);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zzb.zzr(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new PublisherAdViewOptions(z, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PublisherAdViewOptions[] newArray(int i) {
        return new PublisherAdViewOptions[i];
    }
}

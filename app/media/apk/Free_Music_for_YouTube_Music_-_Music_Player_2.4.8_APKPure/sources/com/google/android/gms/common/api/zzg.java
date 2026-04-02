package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
/* loaded from: classes.dex */
public final class zzg implements Parcelable.Creator<Scope> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope createFromParcel(Parcel parcel) {
        int zzd = zzb.zzd(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzb.zzg(parcel, readInt);
                    break;
                case 2:
                    str = zzb.zzq(parcel, readInt);
                    break;
                default:
                    zzb.zzb(parcel, readInt);
                    break;
            }
        }
        zzb.zzaf(parcel, zzd);
        return new Scope(i, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i) {
        return new Scope[i];
    }
}

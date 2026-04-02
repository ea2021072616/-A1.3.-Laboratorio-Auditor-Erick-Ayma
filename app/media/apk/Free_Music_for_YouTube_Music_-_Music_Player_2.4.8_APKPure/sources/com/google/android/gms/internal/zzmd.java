package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
@zzzt
/* loaded from: classes.dex */
public final class zzmd extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzmd> CREATOR = new zzme();
    public final boolean zzbfh;
    public final boolean zzbfi;

    public zzmd(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested());
    }

    public zzmd(boolean z, boolean z2) {
        this.zzbfh = z;
        this.zzbfi = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzbfh);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.zzbfi);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

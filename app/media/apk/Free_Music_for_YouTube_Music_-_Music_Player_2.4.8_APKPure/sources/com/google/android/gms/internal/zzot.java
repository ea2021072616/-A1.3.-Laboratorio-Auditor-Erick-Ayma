package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
@zzzt
/* loaded from: classes.dex */
public final class zzot extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzot> CREATOR = new zzou();
    public final int versionCode;
    public final boolean zzbtc;
    public final int zzbtd;
    public final boolean zzbte;
    public final int zzbtf;
    @Nullable
    public final zzmd zzbtg;

    public zzot(int i, boolean z, int i2, boolean z2, int i3, zzmd zzmdVar) {
        this.versionCode = i;
        this.zzbtc = z;
        this.zzbtd = i2;
        this.zzbte = z2;
        this.zzbtf = i3;
        this.zzbtg = zzmdVar;
    }

    public zzot(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzmd(nativeAdOptions.getVideoOptions()) : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzbtc);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 3, this.zzbtd);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.zzbte);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 5, this.zzbtf);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, (Parcelable) this.zzbtg, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

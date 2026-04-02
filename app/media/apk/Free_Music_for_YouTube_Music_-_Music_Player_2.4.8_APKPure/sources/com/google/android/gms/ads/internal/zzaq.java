package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzaq extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzar();
    public final boolean zzapy;
    public final boolean zzapz;
    private String zzaqa;
    public final boolean zzaqb;
    public final float zzaqc;
    public final int zzaqd;
    public final boolean zzaqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(boolean z, boolean z2, String str, boolean z3, float f, int i, boolean z4) {
        this.zzapy = z;
        this.zzapz = z2;
        this.zzaqa = str;
        this.zzaqb = z3;
        this.zzaqc = f;
        this.zzaqd = i;
        this.zzaqe = z4;
    }

    public zzaq(boolean z, boolean z2, boolean z3, float f, int i, boolean z4) {
        this(z, z2, null, z3, f, i, z4);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzapy);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.zzapz);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.zzaqa, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.zzaqb);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, this.zzaqc);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 7, this.zzaqd);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzaqe);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

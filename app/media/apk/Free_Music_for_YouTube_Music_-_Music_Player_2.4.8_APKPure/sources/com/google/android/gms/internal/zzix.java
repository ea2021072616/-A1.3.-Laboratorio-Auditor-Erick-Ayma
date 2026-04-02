package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbf;
import java.util.Arrays;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzix extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzix> CREATOR = new zziz();
    public final Bundle extras;
    public final int versionCode;
    public final long zzbbl;
    public final int zzbbm;
    public final List<String> zzbbn;
    public final boolean zzbbo;
    public final int zzbbp;
    public final boolean zzbbq;
    public final String zzbbr;
    public final zzlz zzbbs;
    public final Location zzbbt;
    public final String zzbbu;
    public final Bundle zzbbv;
    public final Bundle zzbbw;
    public final List<String> zzbbx;
    public final String zzbby;
    public final String zzbbz;
    public final boolean zzbca;

    public zzix(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, zzlz zzlzVar, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.versionCode = i;
        this.zzbbl = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzbbm = i2;
        this.zzbbn = list;
        this.zzbbo = z;
        this.zzbbp = i3;
        this.zzbbq = z2;
        this.zzbbr = str;
        this.zzbbs = zzlzVar;
        this.zzbbt = location;
        this.zzbbu = str2;
        this.zzbbv = bundle2 == null ? new Bundle() : bundle2;
        this.zzbbw = bundle3;
        this.zzbbx = list2;
        this.zzbby = str3;
        this.zzbbz = str4;
        this.zzbca = z3;
    }

    public static void zzh(zzix zzixVar) {
        zzixVar.zzbbv.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzixVar.extras);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzix) {
            zzix zzixVar = (zzix) obj;
            return this.versionCode == zzixVar.versionCode && this.zzbbl == zzixVar.zzbbl && zzbf.equal(this.extras, zzixVar.extras) && this.zzbbm == zzixVar.zzbbm && zzbf.equal(this.zzbbn, zzixVar.zzbbn) && this.zzbbo == zzixVar.zzbbo && this.zzbbp == zzixVar.zzbbp && this.zzbbq == zzixVar.zzbbq && zzbf.equal(this.zzbbr, zzixVar.zzbbr) && zzbf.equal(this.zzbbs, zzixVar.zzbbs) && zzbf.equal(this.zzbbt, zzixVar.zzbbt) && zzbf.equal(this.zzbbu, zzixVar.zzbbu) && zzbf.equal(this.zzbbv, zzixVar.zzbbv) && zzbf.equal(this.zzbbw, zzixVar.zzbbw) && zzbf.equal(this.zzbbx, zzixVar.zzbbx) && zzbf.equal(this.zzbby, zzixVar.zzbby) && zzbf.equal(this.zzbbz, zzixVar.zzbbz) && this.zzbca == zzixVar.zzbca;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.versionCode), Long.valueOf(this.zzbbl), this.extras, Integer.valueOf(this.zzbbm), this.zzbbn, Boolean.valueOf(this.zzbbo), Integer.valueOf(this.zzbbp), Boolean.valueOf(this.zzbbq), this.zzbbr, this.zzbbs, this.zzbbt, this.zzbbu, this.zzbbv, this.zzbbw, this.zzbbx, this.zzbby, this.zzbbz, Boolean.valueOf(this.zzbca)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzbbl);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.extras, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 4, this.zzbbm);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 5, this.zzbbn, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, this.zzbbo);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 7, this.zzbbp);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzbbq);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 9, this.zzbbr, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 10, (Parcelable) this.zzbbs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 11, (Parcelable) this.zzbbt, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 12, this.zzbbu, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 13, this.zzbbv, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 14, this.zzbbw, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzb(parcel, 15, this.zzbbx, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 16, this.zzbby, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 17, this.zzbbz, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 18, this.zzbca);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

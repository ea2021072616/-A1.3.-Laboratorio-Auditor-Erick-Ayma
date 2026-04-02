package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
@zzzt
/* loaded from: classes.dex */
public class zzjb extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzjb> CREATOR = new zzjc();
    public final int height;
    public final int heightPixels;
    public final int width;
    public final int widthPixels;
    public final String zzbcq;
    public final boolean zzbcr;
    public final zzjb[] zzbcs;
    public final boolean zzbct;
    public final boolean zzbcu;
    public boolean zzbcv;

    public zzjb() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzjb(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzjb(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjb.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    public zzjb(zzjb zzjbVar, zzjb[] zzjbVarArr) {
        this(zzjbVar.zzbcq, zzjbVar.height, zzjbVar.heightPixels, zzjbVar.zzbcr, zzjbVar.width, zzjbVar.widthPixels, zzjbVarArr, zzjbVar.zzbct, zzjbVar.zzbcu, zzjbVar.zzbcv);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjb(String str, int i, int i2, boolean z, int i3, int i4, zzjb[] zzjbVarArr, boolean z2, boolean z3, boolean z4) {
        this.zzbcq = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzbcr = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzbcs = zzjbVarArr;
        this.zzbct = z2;
        this.zzbcu = z3;
        this.zzbcv = z4;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (zzd(displayMetrics) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzjb zzhm() {
        return new zzjb("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public static zzjb zzi(Context context) {
        return new zzjb("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzbcq, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 3, this.height);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 4, this.heightPixels);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.zzbcr);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 6, this.width);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 7, this.widthPixels);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, (Parcelable[]) this.zzbcs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 9, this.zzbct);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 10, this.zzbcu);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 11, this.zzbcv);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }

    public final AdSize zzhn() {
        return com.google.android.gms.ads.zzb.zza(this.width, this.height, this.zzbcq);
    }
}

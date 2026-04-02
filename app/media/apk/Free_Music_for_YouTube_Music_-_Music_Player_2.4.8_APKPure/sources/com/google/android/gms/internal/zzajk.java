package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
@zzzt
/* loaded from: classes.dex */
public final class zzajk extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzajk> CREATOR = new zzajl();
    public String zzcp;
    public int zzdel;
    public int zzdem;
    public boolean zzden;
    public boolean zzdeo;

    public zzajk(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzajk(int i, int i2, boolean z, boolean z2) {
        this(11200000, i2, true, false, z2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private zzajk(int r7, int r8, boolean r9, boolean r10, boolean r11) {
        /*
            r6 = this;
            java.lang.String r1 = "afma-sdk-a-v"
            if (r9 == 0) goto L47
            java.lang.String r0 = "0"
        L6:
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 24
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r2 = "."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = "."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return
        L47:
            java.lang.String r0 = "1"
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzajk.<init>(int, int, boolean, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajk(String str, int i, int i2, boolean z, boolean z2) {
        this.zzcp = str;
        this.zzdel = i;
        this.zzdem = i2;
        this.zzden = z;
        this.zzdeo = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzcp, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 3, this.zzdel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 4, this.zzdem);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.zzden);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, this.zzdeo);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

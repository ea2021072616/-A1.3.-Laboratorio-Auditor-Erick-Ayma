package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzcmq extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzcmq> CREATOR = new zzcmw();
    private static byte[][] zzfdl = new byte[0];
    private static zzcmq zzjhy = new zzcmq("", null, zzfdl, zzfdl, zzfdl, zzfdl, null, null);
    private static final zzcmv zzjih = new zzcmr();
    private static final zzcmv zzjii = new zzcms();
    private static final zzcmv zzjij = new zzcmt();
    private static final zzcmv zzjik = new zzcmu();
    private String zzjhz;
    private byte[] zzjia;
    private byte[][] zzjib;
    private byte[][] zzjic;
    private byte[][] zzjid;
    private byte[][] zzjie;
    private int[] zzjif;
    private byte[][] zzjig;

    public zzcmq(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.zzjhz = str;
        this.zzjia = bArr;
        this.zzjib = bArr2;
        this.zzjic = bArr3;
        this.zzjid = bArr4;
        this.zzjie = bArr5;
        this.zzjif = iArr;
        this.zzjig = bArr6;
    }

    private static void zza(StringBuilder sb, String str, int[] iArr) {
        sb.append(str);
        sb.append("=");
        if (iArr == null) {
            sb.append("null");
            return;
        }
        sb.append("(");
        int length = iArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            int i2 = iArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append(i2);
            i++;
            z = false;
        }
        sb.append(")");
    }

    private static void zza(StringBuilder sb, String str, byte[][] bArr) {
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            sb.append("null");
            return;
        }
        sb.append("(");
        int length = bArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            byte[] bArr2 = bArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append("'");
            sb.append(Base64.encodeToString(bArr2, 3));
            sb.append("'");
            i++;
            z = false;
        }
        sb.append(")");
    }

    private static List<String> zzb(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] bArr2 : bArr) {
            arrayList.add(Base64.encodeToString(bArr2, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static List<Integer> zze(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzcmq) {
            zzcmq zzcmqVar = (zzcmq) obj;
            return zzcmx.equals(this.zzjhz, zzcmqVar.zzjhz) && Arrays.equals(this.zzjia, zzcmqVar.zzjia) && zzcmx.equals(zzb(this.zzjib), zzb(zzcmqVar.zzjib)) && zzcmx.equals(zzb(this.zzjic), zzb(zzcmqVar.zzjic)) && zzcmx.equals(zzb(this.zzjid), zzb(zzcmqVar.zzjid)) && zzcmx.equals(zzb(this.zzjie), zzb(zzcmqVar.zzjie)) && zzcmx.equals(zze(this.zzjif), zze(zzcmqVar.zzjif)) && zzcmx.equals(zzb(this.zzjig), zzb(zzcmqVar.zzjig));
        }
        return false;
    }

    public final String toString() {
        String sb;
        StringBuilder sb2 = new StringBuilder("ExperimentTokens");
        sb2.append("(");
        if (this.zzjhz == null) {
            sb = "null";
        } else {
            String str = this.zzjhz;
            sb = new StringBuilder(String.valueOf("'").length() + String.valueOf(str).length() + String.valueOf("'").length()).append("'").append(str).append("'").toString();
        }
        sb2.append(sb);
        sb2.append(", ");
        byte[] bArr = this.zzjia;
        sb2.append("direct");
        sb2.append("=");
        if (bArr == null) {
            sb2.append("null");
        } else {
            sb2.append("'");
            sb2.append(Base64.encodeToString(bArr, 3));
            sb2.append("'");
        }
        sb2.append(", ");
        zza(sb2, "GAIA", this.zzjib);
        sb2.append(", ");
        zza(sb2, "PSEUDO", this.zzjic);
        sb2.append(", ");
        zza(sb2, "ALWAYS", this.zzjid);
        sb2.append(", ");
        zza(sb2, "OTHER", this.zzjie);
        sb2.append(", ");
        zza(sb2, "weak", this.zzjif);
        sb2.append(", ");
        zza(sb2, "directs", this.zzjig);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzjhz, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.zzjia, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 4, this.zzjib, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 5, this.zzjic, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 6, this.zzjid, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 7, this.zzjie, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 8, this.zzjif, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 9, this.zzjig, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

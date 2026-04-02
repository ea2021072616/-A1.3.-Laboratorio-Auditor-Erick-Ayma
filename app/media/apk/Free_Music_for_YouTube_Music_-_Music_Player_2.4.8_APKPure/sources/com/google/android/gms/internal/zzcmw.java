package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class zzcmw implements Parcelable.Creator<zzcmq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcmq createFromParcel(Parcel parcel) {
        byte[][] bArr = null;
        int zzd = com.google.android.gms.common.internal.safeparcel.zzb.zzd(parcel);
        int[] iArr = null;
        byte[][] bArr2 = null;
        byte[][] bArr3 = null;
        byte[][] bArr4 = null;
        byte[][] bArr5 = null;
        byte[] bArr6 = null;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zzb.zzq(parcel, readInt);
                    break;
                case 3:
                    bArr6 = com.google.android.gms.common.internal.safeparcel.zzb.zzt(parcel, readInt);
                    break;
                case 4:
                    bArr5 = com.google.android.gms.common.internal.safeparcel.zzb.zzu(parcel, readInt);
                    break;
                case 5:
                    bArr4 = com.google.android.gms.common.internal.safeparcel.zzb.zzu(parcel, readInt);
                    break;
                case 6:
                    bArr3 = com.google.android.gms.common.internal.safeparcel.zzb.zzu(parcel, readInt);
                    break;
                case 7:
                    bArr2 = com.google.android.gms.common.internal.safeparcel.zzb.zzu(parcel, readInt);
                    break;
                case 8:
                    iArr = com.google.android.gms.common.internal.safeparcel.zzb.zzw(parcel, readInt);
                    break;
                case 9:
                    bArr = com.google.android.gms.common.internal.safeparcel.zzb.zzu(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, readInt);
                    break;
            }
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzaf(parcel, zzd);
        return new zzcmq(str, bArr6, bArr5, bArr4, bArr3, bArr2, iArr, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcmq[] newArray(int i) {
        return new zzcmq[i];
    }
}

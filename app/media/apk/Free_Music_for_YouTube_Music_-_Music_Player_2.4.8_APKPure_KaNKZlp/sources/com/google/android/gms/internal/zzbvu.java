package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class zzbvu extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzbvu> CREATOR = new zzbvv();
    private int versionCode;
    private zzax zzhqc = null;
    private byte[] zzhqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvu(int i, byte[] bArr) {
        this.versionCode = i;
        this.zzhqd = bArr;
        zzamf();
    }

    private final void zzamf() {
        if (this.zzhqc != null || this.zzhqd == null) {
            if (this.zzhqc == null || this.zzhqd != null) {
                if (this.zzhqc != null && this.zzhqd != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.zzhqc != null || this.zzhqd != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zzc(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, this.zzhqd != null ? this.zzhqd : zzego.zzc(this.zzhqc), false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }

    public final zzax zzasd() {
        if (!(this.zzhqc != null)) {
            try {
                this.zzhqc = (zzax) zzego.zza(new zzax(), this.zzhqd);
                this.zzhqd = null;
            } catch (zzegn e) {
                throw new IllegalStateException(e);
            }
        }
        zzamf();
        return this.zzhqc;
    }
}

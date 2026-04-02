package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import java.io.InputStream;
@zzzt
/* loaded from: classes.dex */
public final class zzib extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzib> CREATOR = new zzic();
    @Nullable
    private ParcelFileDescriptor zzbaj;

    public zzib() {
        this(null);
    }

    public zzib(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbaj = parcelFileDescriptor;
    }

    private synchronized ParcelFileDescriptor zzhb() {
        return this.zzbaj;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, (Parcelable) zzhb(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }

    public final synchronized boolean zzgz() {
        return this.zzbaj != null;
    }

    @Nullable
    public final synchronized InputStream zzha() {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = null;
        synchronized (this) {
            if (this.zzbaj != null) {
                autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbaj);
                this.zzbaj = null;
            }
        }
        return autoCloseInputStream;
    }
}

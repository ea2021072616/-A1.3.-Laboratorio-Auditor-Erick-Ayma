package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzat;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public final class zzm extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();
    private final String zzffn;
    private final zzg zzffo;
    private final boolean zzffp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(String str, IBinder iBinder, boolean z) {
        this.zzffn = str;
        this.zzffo = zzai(iBinder);
        this.zzffp = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(String str, zzg zzgVar, boolean z) {
        this.zzffn = str;
        this.zzffo = zzgVar;
        this.zzffp = z;
    }

    private static zzg zzai(IBinder iBinder) {
        zzh zzhVar;
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper zzaey = zzat.zzak(iBinder).zzaey();
            byte[] bArr = zzaey == null ? null : (byte[]) com.google.android.gms.dynamic.zzn.zzab(zzaey);
            if (bArr != null) {
                zzhVar = new zzh(bArr);
            } else {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                zzhVar = null;
            }
            return zzhVar;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 1, this.zzffn, false);
        if (this.zzffo == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            asBinder = null;
        } else {
            asBinder = this.zzffo.asBinder();
        }
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, asBinder, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 3, this.zzffp);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }
}

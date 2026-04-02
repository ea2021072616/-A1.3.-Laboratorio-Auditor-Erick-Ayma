package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzbvx extends zzee implements zzbvw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.zzbvw
    public final zzbvu zza(zzbvs zzbvsVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzbvsVar);
        Parcel zza = zza(1, zzax);
        zzbvu zzbvuVar = (zzbvu) zzeg.zza(zza, zzbvu.CREATOR);
        zza.recycle();
        return zzbvuVar;
    }
}

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzii extends zzee implements zzih {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzii(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    @Override // com.google.android.gms.internal.zzih
    public final zzib zza(zzie zzieVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzieVar);
        Parcel zza = zza(1, zzax);
        zzib zzibVar = (zzib) zzeg.zza(zza, zzib.CREATOR);
        zza.recycle();
        return zzibVar;
    }
}

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzfj extends zzee implements zzfh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.zzfh
    public final String getId() throws RemoteException {
        Parcel zza = zza(1, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzfh
    public final boolean zzb(boolean z) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, true);
        Parcel zza = zza(2, zzax);
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }
}

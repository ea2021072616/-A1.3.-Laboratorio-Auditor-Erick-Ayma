package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public final class zzadi extends zzee implements zzadh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
    }

    @Override // com.google.android.gms.internal.zzadh
    public final IBinder zza(IObjectWrapper iObjectWrapper, zzva zzvaVar, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzvaVar);
        zzax.writeInt(11200000);
        Parcel zza = zza(1, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}

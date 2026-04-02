package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzfd extends zzee implements zzfc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
    }

    @Override // com.google.android.gms.internal.zzfc
    public final IBinder zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzeg.zza(zzax, iObjectWrapper);
        Parcel zza = zza(1, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }

    @Override // com.google.android.gms.internal.zzfc
    public final IBinder zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzeg.zza(zzax, iObjectWrapper);
        Parcel zza = zza(2, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}

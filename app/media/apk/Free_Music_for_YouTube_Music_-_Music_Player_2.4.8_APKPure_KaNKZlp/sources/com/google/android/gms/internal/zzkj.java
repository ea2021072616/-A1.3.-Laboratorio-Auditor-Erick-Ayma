package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzkj extends zzee implements zzki {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    @Override // com.google.android.gms.internal.zzki
    public final IBinder zza(IObjectWrapper iObjectWrapper, zzjb zzjbVar, String str, zzva zzvaVar, int i, int i2) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzjbVar);
        zzax.writeString(str);
        zzeg.zza(zzax, zzvaVar);
        zzax.writeInt(11200000);
        zzax.writeInt(i2);
        Parcel zza = zza(2, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}

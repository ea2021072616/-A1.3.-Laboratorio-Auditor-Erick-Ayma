package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzke extends zzee implements zzkd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzke(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
    }

    @Override // com.google.android.gms.internal.zzkd
    public final IBinder zza(IObjectWrapper iObjectWrapper, String str, zzva zzvaVar, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzeg.zza(zzax, zzvaVar);
        zzax.writeInt(11200000);
        Parcel zza = zza(1, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}

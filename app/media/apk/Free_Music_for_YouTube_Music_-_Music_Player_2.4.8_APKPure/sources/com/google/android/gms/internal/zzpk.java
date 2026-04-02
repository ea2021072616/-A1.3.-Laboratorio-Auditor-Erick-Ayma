package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzpk extends zzee implements zzpj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
    }

    @Override // com.google.android.gms.internal.zzpj
    public final IBinder zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, iObjectWrapper2);
        zzeg.zza(zzax, iObjectWrapper3);
        zzax.writeInt(11200000);
        Parcel zza = zza(1, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}

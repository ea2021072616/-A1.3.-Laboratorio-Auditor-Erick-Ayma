package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzkx extends zzee implements zzkw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
    }

    @Override // com.google.android.gms.internal.zzkw
    public final IBinder zza(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeInt(11200000);
        Parcel zza = zza(1, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}

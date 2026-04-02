package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzee;
/* loaded from: classes.dex */
public final class zzau extends zzee implements zzas {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzas
    public final IObjectWrapper zzaey() throws RemoteException {
        Parcel zza = zza(1, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.common.internal.zzas
    public final int zzaez() throws RemoteException {
        Parcel zza = zza(2, zzax());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}

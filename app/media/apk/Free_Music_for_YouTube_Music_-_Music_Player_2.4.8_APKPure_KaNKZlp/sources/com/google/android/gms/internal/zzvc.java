package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzvc extends zzee implements zzva {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzvd zzbh(String str) throws RemoteException {
        zzvd zzvfVar;
        Parcel zzax = zzax();
        zzax.writeString(str);
        Parcel zza = zza(1, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzvfVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzvfVar = queryLocalInterface instanceof zzvd ? (zzvd) queryLocalInterface : new zzvf(readStrongBinder);
        }
        zza.recycle();
        return zzvfVar;
    }

    @Override // com.google.android.gms.internal.zzva
    public final boolean zzbi(String str) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        Parcel zza = zza(2, zzax);
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }
}

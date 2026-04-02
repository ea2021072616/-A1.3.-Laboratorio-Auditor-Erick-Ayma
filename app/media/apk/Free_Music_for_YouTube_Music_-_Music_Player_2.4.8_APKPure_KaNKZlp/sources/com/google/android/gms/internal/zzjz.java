package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzjz extends zzee implements zzjx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.zzjx
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(2, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzjx
    public final boolean isLoading() throws RemoteException {
        Parcel zza = zza(3, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzjx
    public final void zza(zzix zzixVar, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzixVar);
        zzax.writeInt(i);
        zzb(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzjx
    public final String zzch() throws RemoteException {
        Parcel zza = zza(4, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzjx
    public final void zzd(zzix zzixVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzixVar);
        zzb(1, zzax);
    }
}

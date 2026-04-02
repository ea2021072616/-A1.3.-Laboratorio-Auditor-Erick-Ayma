package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zznm extends zzee implements zznk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zznm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.zznk
    public final String getContent() throws RemoteException {
        Parcel zza = zza(2, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zznk
    public final void recordClick() throws RemoteException {
        zzb(4, zzax());
    }

    @Override // com.google.android.gms.internal.zznk
    public final void recordImpression() throws RemoteException {
        zzb(5, zzax());
    }

    @Override // com.google.android.gms.internal.zznk
    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(3, zzax);
    }

    @Override // com.google.android.gms.internal.zznk
    public final String zziz() throws RemoteException {
        Parcel zza = zza(1, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}

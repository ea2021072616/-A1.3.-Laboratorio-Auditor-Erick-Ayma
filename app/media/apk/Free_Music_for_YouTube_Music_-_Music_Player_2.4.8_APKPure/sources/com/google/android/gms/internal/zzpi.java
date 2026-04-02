package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzpi extends zzee implements zzpg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.zzpg
    public final void destroy() throws RemoteException {
        zzb(4, zzax());
    }

    @Override // com.google.android.gms.internal.zzpg
    public final IObjectWrapper zzak(String str) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        Parcel zza = zza(2, zzax);
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzpg
    public final void zzb(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeInt(i);
        zzb(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzpg
    public final void zzd(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzeg.zza(zzax, iObjectWrapper);
        zzb(1, zzax);
    }

    @Override // com.google.android.gms.internal.zzpg
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(3, zzax);
    }
}

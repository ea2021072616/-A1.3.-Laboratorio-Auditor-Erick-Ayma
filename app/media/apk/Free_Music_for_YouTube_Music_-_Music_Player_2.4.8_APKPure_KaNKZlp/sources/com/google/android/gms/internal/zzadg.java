package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public final class zzadg extends zzee implements zzade {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.zzade
    public final void destroy() throws RemoteException {
        zzb(8, zzax());
    }

    @Override // com.google.android.gms.internal.zzade
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(12, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzade
    public final boolean isLoaded() throws RemoteException {
        Parcel zza = zza(5, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzade
    public final void pause() throws RemoteException {
        zzb(6, zzax());
    }

    @Override // com.google.android.gms.internal.zzade
    public final void resume() throws RemoteException {
        zzb(7, zzax());
    }

    @Override // com.google.android.gms.internal.zzade
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, z);
        zzb(34, zzax);
    }

    @Override // com.google.android.gms.internal.zzade
    public final void setUserId(String str) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzb(4, zzax);
    }

    @Override // com.google.android.gms.internal.zzade
    public final void show() throws RemoteException {
        zzb(2, zzax());
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zza(zzadj zzadjVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzadjVar);
        zzb(3, zzax);
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zza(zzadp zzadpVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzadpVar);
        zzb(1, zzax);
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(9, zzax);
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(10, zzax);
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(11, zzax);
    }
}

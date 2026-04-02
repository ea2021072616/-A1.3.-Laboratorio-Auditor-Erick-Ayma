package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzkh extends zzee implements zzkf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void destroy() throws RemoteException {
        zzb(2, zzax());
    }

    @Override // com.google.android.gms.internal.zzkf
    public final String getAdUnitId() throws RemoteException {
        Parcel zza = zza(31, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(18, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzky getVideoController() throws RemoteException {
        zzky zzlaVar;
        Parcel zza = zza(26, zzax());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzlaVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzlaVar = queryLocalInterface instanceof zzky ? (zzky) queryLocalInterface : new zzla(readStrongBinder);
        }
        zza.recycle();
        return zzlaVar;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean isLoading() throws RemoteException {
        Parcel zza = zza(23, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean isReady() throws RemoteException {
        Parcel zza = zza(3, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void pause() throws RemoteException {
        zzb(5, zzax());
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void resume() throws RemoteException {
        zzb(6, zzax());
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, z);
        zzb(34, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, z);
        zzb(22, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void setUserId(String str) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzb(25, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void showInterstitial() throws RemoteException {
        zzb(9, zzax());
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void stopLoading() throws RemoteException {
        zzb(10, zzax());
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzadj zzadjVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzadjVar);
        zzb(24, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzjb zzjbVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzjbVar);
        zzb(13, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzjr zzjrVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzjrVar);
        zzb(20, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzju zzjuVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzjuVar);
        zzb(7, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzkk zzkkVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzkkVar);
        zzb(8, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzkq zzkqVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzkqVar);
        zzb(21, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzle zzleVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzleVar);
        zzb(30, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzmd zzmdVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzmdVar);
        zzb(29, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zznn zznnVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zznnVar);
        zzb(19, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzxn zzxnVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzxnVar);
        zzb(14, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zza(zzxt zzxtVar, String str) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzxtVar);
        zzax.writeString(str);
        zzb(15, zzax);
    }

    @Override // com.google.android.gms.internal.zzkf
    public final boolean zzb(zzix zzixVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzixVar);
        Parcel zza = zza(4, zzax);
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final IObjectWrapper zzbk() throws RemoteException {
        Parcel zza = zza(1, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzjb zzbl() throws RemoteException {
        Parcel zza = zza(12, zzax());
        zzjb zzjbVar = (zzjb) zzeg.zza(zza, zzjb.CREATOR);
        zza.recycle();
        return zzjbVar;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final void zzbn() throws RemoteException {
        zzb(11, zzax());
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzkk zzbw() throws RemoteException {
        zzkk zzkmVar;
        Parcel zza = zza(32, zzax());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzkmVar = queryLocalInterface instanceof zzkk ? (zzkk) queryLocalInterface : new zzkm(readStrongBinder);
        }
        zza.recycle();
        return zzkmVar;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final zzju zzbx() throws RemoteException {
        zzju zzjwVar;
        Parcel zza = zza(33, zzax());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzjwVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzjwVar = queryLocalInterface instanceof zzju ? (zzju) queryLocalInterface : new zzjw(readStrongBinder);
        }
        zza.recycle();
        return zzjwVar;
    }

    @Override // com.google.android.gms.internal.zzkf
    public final String zzch() throws RemoteException {
        Parcel zza = zza(35, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}

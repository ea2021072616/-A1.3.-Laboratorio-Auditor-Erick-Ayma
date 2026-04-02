package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzvf extends zzee implements zzvd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void destroy() throws RemoteException {
        zzb(5, zzax());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final Bundle getInterstitialAdapterInfo() throws RemoteException {
        Parcel zza = zza(18, zzax());
        Bundle bundle = (Bundle) zzeg.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzky getVideoController() throws RemoteException {
        Parcel zza = zza(26, zzax());
        zzky zzh = zzkz.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final IObjectWrapper getView() throws RemoteException {
        Parcel zza = zza(2, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final boolean isInitialized() throws RemoteException {
        Parcel zza = zza(13, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void pause() throws RemoteException {
        zzb(8, zzax());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void resume() throws RemoteException {
        zzb(9, zzax());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, z);
        zzb(25, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void showInterstitial() throws RemoteException {
        zzb(4, zzax());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void showVideo() throws RemoteException {
        zzb(12, zzax());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzaeg zzaegVar, List<String> list) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzaegVar);
        zzax.writeStringList(list);
        zzb(23, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, zzaeg zzaegVar, String str2) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzixVar);
        zzax.writeString(str);
        zzeg.zza(zzax, zzaegVar);
        zzax.writeString(str2);
        zzb(10, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, zzvg zzvgVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzixVar);
        zzax.writeString(str);
        zzeg.zza(zzax, zzvgVar);
        zzb(3, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, String str2, zzvg zzvgVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzixVar);
        zzax.writeString(str);
        zzax.writeString(str2);
        zzeg.zza(zzax, zzvgVar);
        zzb(7, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, String str2, zzvg zzvgVar, zzot zzotVar, List<String> list) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzixVar);
        zzax.writeString(str);
        zzax.writeString(str2);
        zzeg.zza(zzax, zzvgVar);
        zzeg.zza(zzax, zzotVar);
        zzax.writeStringList(list);
        zzb(14, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzjb zzjbVar, zzix zzixVar, String str, zzvg zzvgVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzjbVar);
        zzeg.zza(zzax, zzixVar);
        zzax.writeString(str);
        zzeg.zza(zzax, zzvgVar);
        zzb(1, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(IObjectWrapper iObjectWrapper, zzjb zzjbVar, zzix zzixVar, String str, String str2, zzvg zzvgVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzjbVar);
        zzeg.zza(zzax, zzixVar);
        zzax.writeString(str);
        zzax.writeString(str2);
        zzeg.zza(zzax, zzvgVar);
        zzb(6, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(zzix zzixVar, String str, String str2) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzixVar);
        zzax.writeString(str);
        zzax.writeString(str2);
        zzb(20, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zzc(zzix zzixVar, String str) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzixVar);
        zzax.writeString(str);
        zzb(11, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(21, zzax);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzvm zzls() throws RemoteException {
        zzvm zzvoVar;
        Parcel zza = zza(15, zzax());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzvoVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzvoVar = queryLocalInterface instanceof zzvm ? (zzvm) queryLocalInterface : new zzvo(readStrongBinder);
        }
        zza.recycle();
        return zzvoVar;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzvp zzlt() throws RemoteException {
        zzvp zzvrVar;
        Parcel zza = zza(16, zzax());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzvrVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzvrVar = queryLocalInterface instanceof zzvp ? (zzvp) queryLocalInterface : new zzvr(readStrongBinder);
        }
        zza.recycle();
        return zzvrVar;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final Bundle zzlu() throws RemoteException {
        Parcel zza = zza(17, zzax());
        Bundle bundle = (Bundle) zzeg.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final Bundle zzlv() throws RemoteException {
        Parcel zza = zza(19, zzax());
        Bundle bundle = (Bundle) zzeg.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final boolean zzlw() throws RemoteException {
        Parcel zza = zza(22, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzvd
    public final zzpt zzlx() throws RemoteException {
        Parcel zza = zza(24, zzax());
        zzpt zzm = zzpu.zzm(zza.readStrongBinder());
        zza.recycle();
        return zzm;
    }
}

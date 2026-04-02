package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzkp extends zzee implements zzkn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzka createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzva zzvaVar, int i) throws RemoteException {
        zzka zzkcVar;
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzeg.zza(zzax, zzvaVar);
        zzax.writeInt(i);
        Parcel zza = zza(3, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkcVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzkcVar = queryLocalInterface instanceof zzka ? (zzka) queryLocalInterface : new zzkc(readStrongBinder);
        }
        zza.recycle();
        return zzkcVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzxg createAdOverlay(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        Parcel zza = zza(8, zzax);
        zzxg zzt = zzxh.zzt(zza.readStrongBinder());
        zza.recycle();
        return zzt;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzkf createBannerAdManager(IObjectWrapper iObjectWrapper, zzjb zzjbVar, String str, zzva zzvaVar, int i) throws RemoteException {
        zzkf zzkhVar;
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzjbVar);
        zzax.writeString(str);
        zzeg.zza(zzax, zzvaVar);
        zzax.writeInt(i);
        Parcel zza = zza(1, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkhVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkhVar = queryLocalInterface instanceof zzkf ? (zzkf) queryLocalInterface : new zzkh(readStrongBinder);
        }
        zza.recycle();
        return zzkhVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzxq createInAppPurchaseManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        Parcel zza = zza(7, zzax);
        zzxq zzv = zzxr.zzv(zza.readStrongBinder());
        zza.recycle();
        return zzv;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzkf createInterstitialAdManager(IObjectWrapper iObjectWrapper, zzjb zzjbVar, String str, zzva zzvaVar, int i) throws RemoteException {
        zzkf zzkhVar;
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzjbVar);
        zzax.writeString(str);
        zzeg.zza(zzax, zzvaVar);
        zzax.writeInt(i);
        Parcel zza = zza(2, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkhVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkhVar = queryLocalInterface instanceof zzkf ? (zzkf) queryLocalInterface : new zzkh(readStrongBinder);
        }
        zza.recycle();
        return zzkhVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzpg createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, iObjectWrapper2);
        Parcel zza = zza(5, zzax);
        zzpg zzl = zzph.zzl(zza.readStrongBinder());
        zza.recycle();
        return zzl;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzade createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzva zzvaVar, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzvaVar);
        zzax.writeInt(i);
        Parcel zza = zza(6, zzax);
        zzade zzx = zzadf.zzx(zza.readStrongBinder());
        zza.recycle();
        return zzx;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzkf createSearchAdManager(IObjectWrapper iObjectWrapper, zzjb zzjbVar, String str, int i) throws RemoteException {
        zzkf zzkhVar;
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzjbVar);
        zzax.writeString(str);
        zzax.writeInt(i);
        Parcel zza = zza(10, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkhVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkhVar = queryLocalInterface instanceof zzkf ? (zzkf) queryLocalInterface : new zzkh(readStrongBinder);
        }
        zza.recycle();
        return zzkhVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzkt getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzkt zzkvVar;
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        Parcel zza = zza(4, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkvVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzkvVar = queryLocalInterface instanceof zzkt ? (zzkt) queryLocalInterface : new zzkv(readStrongBinder);
        }
        zza.recycle();
        return zzkvVar;
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzkt getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzkt zzkvVar;
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeInt(i);
        Parcel zza = zza(9, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkvVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzkvVar = queryLocalInterface instanceof zzkt ? (zzkt) queryLocalInterface : new zzkv(readStrongBinder);
        }
        zza.recycle();
        return zzkvVar;
    }
}

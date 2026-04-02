package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public abstract class zzko extends zzef implements zzkn {
    public zzko() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public static zzkn asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
        return queryLocalInterface instanceof zzkn ? (zzkn) queryLocalInterface : new zzkp(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzkf createBannerAdManager = createBannerAdManager(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), (zzjb) zzeg.zza(parcel, zzjb.CREATOR), parcel.readString(), zzvb.zzs(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzeg.zza(parcel2, createBannerAdManager);
                break;
            case 2:
                zzkf createInterstitialAdManager = createInterstitialAdManager(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), (zzjb) zzeg.zza(parcel, zzjb.CREATOR), parcel.readString(), zzvb.zzs(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzeg.zza(parcel2, createInterstitialAdManager);
                break;
            case 3:
                zzka createAdLoaderBuilder = createAdLoaderBuilder(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readString(), zzvb.zzs(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzeg.zza(parcel2, createAdLoaderBuilder);
                break;
            case 4:
                zzkt mobileAdsSettingsManager = getMobileAdsSettingsManager(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzeg.zza(parcel2, mobileAdsSettingsManager);
                break;
            case 5:
                zzpg createNativeAdViewDelegate = createNativeAdViewDelegate(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzeg.zza(parcel2, createNativeAdViewDelegate);
                break;
            case 6:
                zzade createRewardedVideoAd = createRewardedVideoAd(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), zzvb.zzs(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzeg.zza(parcel2, createRewardedVideoAd);
                break;
            case 7:
                zzxq createInAppPurchaseManager = createInAppPurchaseManager(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzeg.zza(parcel2, createInAppPurchaseManager);
                break;
            case 8:
                zzxg createAdOverlay = createAdOverlay(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzeg.zza(parcel2, createAdOverlay);
                break;
            case 9:
                zzkt mobileAdsSettingsManagerWithClientJarVersion = getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzeg.zza(parcel2, mobileAdsSettingsManagerWithClientJarVersion);
                break;
            case 10:
                zzkf createSearchAdManager = createSearchAdManager(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), (zzjb) zzeg.zza(parcel, zzjb.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzeg.zza(parcel2, createSearchAdManager);
                break;
            default:
                return false;
        }
        return true;
    }
}

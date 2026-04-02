package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public interface zzkn extends IInterface {
    zzka createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzva zzvaVar, int i) throws RemoteException;

    zzxg createAdOverlay(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzkf createBannerAdManager(IObjectWrapper iObjectWrapper, zzjb zzjbVar, String str, zzva zzvaVar, int i) throws RemoteException;

    zzxq createInAppPurchaseManager(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzkf createInterstitialAdManager(IObjectWrapper iObjectWrapper, zzjb zzjbVar, String str, zzva zzvaVar, int i) throws RemoteException;

    zzpg createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    zzade createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzva zzvaVar, int i) throws RemoteException;

    zzkf createSearchAdManager(IObjectWrapper iObjectWrapper, zzjb zzjbVar, String str, int i) throws RemoteException;

    zzkt getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzkt getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) throws RemoteException;
}

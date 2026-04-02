package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface zzvg extends IInterface {
    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    void onAppEvent(String str, String str2) throws RemoteException;

    void zza(zzvj zzvjVar) throws RemoteException;

    void zzb(zzpt zzptVar, String str) throws RemoteException;
}

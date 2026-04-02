package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public interface zzkf extends IInterface {
    void destroy() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzky getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzadj zzadjVar) throws RemoteException;

    void zza(zzjb zzjbVar) throws RemoteException;

    void zza(zzjr zzjrVar) throws RemoteException;

    void zza(zzju zzjuVar) throws RemoteException;

    void zza(zzkk zzkkVar) throws RemoteException;

    void zza(zzkq zzkqVar) throws RemoteException;

    void zza(zzle zzleVar) throws RemoteException;

    void zza(zzmd zzmdVar) throws RemoteException;

    void zza(zznn zznnVar) throws RemoteException;

    void zza(zzxn zzxnVar) throws RemoteException;

    void zza(zzxt zzxtVar, String str) throws RemoteException;

    boolean zzb(zzix zzixVar) throws RemoteException;

    IObjectWrapper zzbk() throws RemoteException;

    zzjb zzbl() throws RemoteException;

    void zzbn() throws RemoteException;

    zzkk zzbw() throws RemoteException;

    zzju zzbx() throws RemoteException;

    String zzch() throws RemoteException;
}

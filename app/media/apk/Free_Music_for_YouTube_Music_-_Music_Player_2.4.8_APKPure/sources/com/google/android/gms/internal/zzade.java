package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public interface zzade extends IInterface {
    void destroy() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void show() throws RemoteException;

    void zza(zzadj zzadjVar) throws RemoteException;

    void zza(zzadp zzadpVar) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzg(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper) throws RemoteException;
}

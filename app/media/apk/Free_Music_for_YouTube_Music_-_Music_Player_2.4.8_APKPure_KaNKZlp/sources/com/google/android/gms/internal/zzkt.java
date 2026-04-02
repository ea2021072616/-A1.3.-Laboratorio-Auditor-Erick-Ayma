package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public interface zzkt extends IInterface {
    void initialize() throws RemoteException;

    void setAppMuted(boolean z) throws RemoteException;

    void setAppVolume(float f) throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzc(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzt(String str) throws RemoteException;
}

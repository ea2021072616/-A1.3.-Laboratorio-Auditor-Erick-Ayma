package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public interface zznk extends IInterface {
    String getContent() throws RemoteException;

    void recordClick() throws RemoteException;

    void recordImpression() throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper) throws RemoteException;

    String zziz() throws RemoteException;
}

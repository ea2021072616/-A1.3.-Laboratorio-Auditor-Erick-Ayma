package com.google.android.gms.internal;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public interface zzpc extends IInterface {
    double getScale() throws RemoteException;

    Uri getUri() throws RemoteException;

    IObjectWrapper zzjh() throws RemoteException;
}

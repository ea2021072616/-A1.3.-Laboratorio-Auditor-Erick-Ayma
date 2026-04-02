package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* loaded from: classes2.dex */
public interface zzpt extends IInterface {
    void destroy() throws RemoteException;

    List<String> getAvailableAssetNames() throws RemoteException;

    String getCustomTemplateId() throws RemoteException;

    zzky getVideoController() throws RemoteException;

    void performClick(String str) throws RemoteException;

    void recordImpression() throws RemoteException;

    String zzao(String str) throws RemoteException;

    zzpc zzap(String str) throws RemoteException;

    boolean zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzjj() throws RemoteException;

    IObjectWrapper zzjp() throws RemoteException;
}

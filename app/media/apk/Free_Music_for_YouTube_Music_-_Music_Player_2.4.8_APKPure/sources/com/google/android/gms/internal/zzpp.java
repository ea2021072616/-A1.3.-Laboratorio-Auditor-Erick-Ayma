package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* loaded from: classes2.dex */
public interface zzpp extends IInterface {
    void destroy() throws RemoteException;

    String getAdvertiser() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    zzky getVideoController() throws RemoteException;

    void performClick(Bundle bundle) throws RemoteException;

    boolean recordImpression(Bundle bundle) throws RemoteException;

    void reportTouchEvent(Bundle bundle) throws RemoteException;

    IObjectWrapper zzjj() throws RemoteException;

    zzoy zzjn() throws RemoteException;

    zzpc zzjo() throws RemoteException;
}

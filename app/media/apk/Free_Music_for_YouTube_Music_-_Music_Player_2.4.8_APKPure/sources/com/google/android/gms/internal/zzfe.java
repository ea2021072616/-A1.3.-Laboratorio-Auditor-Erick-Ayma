package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public interface zzfe extends IInterface {
    void zza(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException;

    void zza(int[] iArr) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzbe() throws RemoteException;

    void zzc(byte[] bArr) throws RemoteException;

    void zze(int i) throws RemoteException;

    void zzf(int i) throws RemoteException;
}

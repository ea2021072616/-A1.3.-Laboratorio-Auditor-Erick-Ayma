package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface zzky extends IInterface {
    float getAspectRatio() throws RemoteException;

    int getPlaybackState() throws RemoteException;

    boolean isCustomControlsEnabled() throws RemoteException;

    boolean isMuted() throws RemoteException;

    void mute(boolean z) throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void zza(zzlb zzlbVar) throws RemoteException;

    float zzhx() throws RemoteException;

    float zzhy() throws RemoteException;
}

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* loaded from: classes2.dex */
public interface zzvd extends IInterface {
    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzky getVideoController() throws RemoteException;

    IObjectWrapper getView() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzaeg zzaegVar, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, zzaeg zzaegVar, String str2) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, zzvg zzvgVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, String str2, zzvg zzvgVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzix zzixVar, String str, String str2, zzvg zzvgVar, zzot zzotVar, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzjb zzjbVar, zzix zzixVar, String str, zzvg zzvgVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzjb zzjbVar, zzix zzixVar, String str, String str2, zzvg zzvgVar) throws RemoteException;

    void zza(zzix zzixVar, String str, String str2) throws RemoteException;

    void zzc(zzix zzixVar, String str) throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzvm zzls() throws RemoteException;

    zzvp zzlt() throws RemoteException;

    Bundle zzlu() throws RemoteException;

    Bundle zzlv() throws RemoteException;

    boolean zzlw() throws RemoteException;

    zzpt zzlx() throws RemoteException;
}

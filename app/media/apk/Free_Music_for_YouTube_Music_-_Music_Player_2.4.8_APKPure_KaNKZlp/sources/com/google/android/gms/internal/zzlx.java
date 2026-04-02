package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzlx extends zzadf {
    private zzadj zzbes;

    @Override // com.google.android.gms.internal.zzade
    public final void destroy() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzade
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.zzade
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.zzade
    public final void pause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzade
    public final void resume() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzade
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzade
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzade
    public final void show() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zza(zzadj zzadjVar) throws RemoteException {
        this.zzbes = zzadjVar;
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zza(zzadp zzadpVar) throws RemoteException {
        zzaji.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzaje.zzdee.post(new zzly(this));
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzade
    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
    }
}

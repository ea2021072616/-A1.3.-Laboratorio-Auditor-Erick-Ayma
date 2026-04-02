package com.google.android.gms.internal;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzlr extends zzjy {
    final /* synthetic */ zzlp zzbep;

    private zzlr(zzlp zzlpVar) {
        this.zzbep = zzlpVar;
    }

    @Override // com.google.android.gms.internal.zzjx
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.zzjx
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.zzjx
    public final void zza(zzix zzixVar, int i) throws RemoteException {
        zzaji.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzaje.zzdee.post(new zzls(this));
    }

    @Override // com.google.android.gms.internal.zzjx
    public final String zzch() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.zzjx
    public final void zzd(zzix zzixVar) throws RemoteException {
        zza(zzixVar, 1);
    }
}

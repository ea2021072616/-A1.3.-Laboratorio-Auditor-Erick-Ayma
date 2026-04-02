package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzvi extends zzee implements zzvg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdClicked() throws RemoteException {
        zzb(1, zzax());
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdClosed() throws RemoteException {
        zzb(2, zzax());
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(3, zzax);
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdImpression() throws RemoteException {
        zzb(8, zzax());
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdLeftApplication() throws RemoteException {
        zzb(4, zzax());
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdLoaded() throws RemoteException {
        zzb(6, zzax());
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdOpened() throws RemoteException {
        zzb(5, zzax());
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzb(9, zzax);
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void zza(zzvj zzvjVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzvjVar);
        zzb(7, zzax);
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void zzb(zzpt zzptVar, String str) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzptVar);
        zzax.writeString(str);
        zzb(10, zzax);
    }
}

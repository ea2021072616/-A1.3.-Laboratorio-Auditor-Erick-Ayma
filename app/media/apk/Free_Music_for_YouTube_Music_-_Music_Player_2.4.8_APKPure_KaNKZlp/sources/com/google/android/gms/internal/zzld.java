package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzld extends zzee implements zzlb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzld(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.zzlb
    public final void onVideoEnd() throws RemoteException {
        zzb(4, zzax());
    }

    @Override // com.google.android.gms.internal.zzlb
    public final void onVideoMute(boolean z) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, z);
        zzb(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzlb
    public final void onVideoPause() throws RemoteException {
        zzb(3, zzax());
    }

    @Override // com.google.android.gms.internal.zzlb
    public final void onVideoPlay() throws RemoteException {
        zzb(2, zzax());
    }

    @Override // com.google.android.gms.internal.zzlb
    public final void onVideoStart() throws RemoteException {
        zzb(1, zzax());
    }
}

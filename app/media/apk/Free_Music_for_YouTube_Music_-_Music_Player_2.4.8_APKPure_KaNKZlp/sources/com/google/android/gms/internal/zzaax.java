package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class zzaax extends zzee implements zzaav {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaax(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdResponseListener");
    }

    @Override // com.google.android.gms.internal.zzaav
    public final void zza(zzaao zzaaoVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzaaoVar);
        zzb(1, zzax);
    }
}

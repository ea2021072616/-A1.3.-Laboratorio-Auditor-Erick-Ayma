package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzpz extends zzee implements zzpx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.zzpx
    public final void zza(zzpl zzplVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzplVar);
        zzb(1, zzax);
    }
}

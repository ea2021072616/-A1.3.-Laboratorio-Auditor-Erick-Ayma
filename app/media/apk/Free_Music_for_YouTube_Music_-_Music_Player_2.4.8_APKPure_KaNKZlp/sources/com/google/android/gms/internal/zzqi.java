package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzqi extends zzee implements zzqg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.zzqg
    public final void zza(zzpt zzptVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzptVar);
        zzb(1, zzax);
    }
}

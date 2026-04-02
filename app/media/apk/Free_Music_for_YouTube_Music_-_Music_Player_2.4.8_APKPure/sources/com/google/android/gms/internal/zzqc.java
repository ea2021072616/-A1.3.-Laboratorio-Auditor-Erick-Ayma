package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzqc extends zzee implements zzqa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.zzqa
    public final void zza(zzpp zzppVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzppVar);
        zzb(1, zzax);
    }
}

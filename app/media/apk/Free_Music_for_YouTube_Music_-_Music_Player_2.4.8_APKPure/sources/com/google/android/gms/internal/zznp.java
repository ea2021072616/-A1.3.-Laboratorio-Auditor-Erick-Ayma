package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zznp extends zzee implements zznn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zznp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.zznn
    public final void zza(zznk zznkVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zznkVar);
        zzb(1, zzax);
    }
}

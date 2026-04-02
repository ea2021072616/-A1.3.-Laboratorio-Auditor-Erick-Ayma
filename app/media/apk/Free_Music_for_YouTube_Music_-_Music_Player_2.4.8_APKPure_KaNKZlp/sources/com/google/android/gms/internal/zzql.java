package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzql extends zzee implements zzqj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzql(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.zzqj
    public final void zza(zzkf zzkfVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzkfVar);
        zzeg.zza(zzax, iObjectWrapper);
        zzb(1, zzax);
    }
}

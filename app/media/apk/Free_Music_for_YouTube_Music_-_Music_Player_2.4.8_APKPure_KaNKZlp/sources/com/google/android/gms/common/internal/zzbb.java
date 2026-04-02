package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzeg;
/* loaded from: classes.dex */
public final class zzbb extends zzee implements zzaz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzaz
    public final boolean zza(com.google.android.gms.common.zzm zzmVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzmVar);
        zzeg.zza(zzax, iObjectWrapper);
        Parcel zza = zza(5, zzax);
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }
}

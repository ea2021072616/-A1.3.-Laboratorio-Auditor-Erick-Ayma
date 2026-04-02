package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzks extends zzee implements zzkq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzks(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    @Override // com.google.android.gms.internal.zzkq
    public final long getValue() throws RemoteException {
        Parcel zza = zza(1, zzax());
        long readLong = zza.readLong();
        zza.recycle();
        return readLong;
    }
}

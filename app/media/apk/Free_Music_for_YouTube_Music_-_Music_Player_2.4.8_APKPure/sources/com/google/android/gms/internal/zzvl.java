package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzvl extends zzee implements zzvj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    }

    @Override // com.google.android.gms.internal.zzvj
    public final int zzlq() throws RemoteException {
        Parcel zza = zza(1, zzax());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}

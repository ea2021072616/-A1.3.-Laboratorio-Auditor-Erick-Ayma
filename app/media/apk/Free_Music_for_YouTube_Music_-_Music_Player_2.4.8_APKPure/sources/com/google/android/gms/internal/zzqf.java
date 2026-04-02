package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzqf extends zzee implements zzqd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.zzqd
    public final void zzb(zzpt zzptVar, String str) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzptVar);
        zzax.writeString(str);
        zzb(1, zzax);
    }
}

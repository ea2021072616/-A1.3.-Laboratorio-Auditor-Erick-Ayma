package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzkm extends zzee implements zzkk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    @Override // com.google.android.gms.internal.zzkk
    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzb(1, zzax);
    }
}

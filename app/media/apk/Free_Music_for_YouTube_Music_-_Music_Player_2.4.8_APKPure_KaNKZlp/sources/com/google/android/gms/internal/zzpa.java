package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzpa extends zzee implements zzoy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.zzoy
    public final String getText() throws RemoteException {
        Parcel zza = zza(2, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzoy
    public final List<zzpc> zzjc() throws RemoteException {
        Parcel zza = zza(3, zzax());
        ArrayList zzb = zzeg.zzb(zza);
        zza.recycle();
        return zzb;
    }
}

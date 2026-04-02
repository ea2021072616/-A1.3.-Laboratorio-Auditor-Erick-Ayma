package com.google.android.gms.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzpe extends zzee implements zzpc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.zzpc
    public final double getScale() throws RemoteException {
        Parcel zza = zza(3, zzax());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.zzpc
    public final Uri getUri() throws RemoteException {
        Parcel zza = zza(2, zzax());
        Uri uri = (Uri) zzeg.zza(zza, Uri.CREATOR);
        zza.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.zzpc
    public final IObjectWrapper zzjh() throws RemoteException {
        Parcel zza = zza(1, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }
}

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzkv extends zzee implements zzkt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void initialize() throws RemoteException {
        zzb(1, zzax());
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void setAppMuted(boolean z) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, z);
        zzb(4, zzax);
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void setAppVolume(float f) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeFloat(f);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void zzc(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzb(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void zzc(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzeg.zza(zzax, iObjectWrapper);
        zzb(6, zzax);
    }

    @Override // com.google.android.gms.internal.zzkt
    public final void zzt(String str) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzb(3, zzax);
    }
}

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzfb extends zzee implements zzez {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    }

    @Override // com.google.android.gms.internal.zzez
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, iObjectWrapper2);
        Parcel zza = zza(6, zzax);
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzez
    public final String zza(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        Parcel zza = zza(8, zzax);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzez
    public final String zza(IObjectWrapper iObjectWrapper, byte[] bArr) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeByteArray(bArr);
        Parcel zza = zza(12, zzax);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzez
    public final boolean zza(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        Parcel zza = zza(3, zzax);
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzez
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, iObjectWrapper2);
        Parcel zza = zza(10, zzax);
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzez
    public final void zzb(String str, String str2) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.internal.zzez
    public final boolean zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        Parcel zza = zza(4, zzax);
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzez
    public final boolean zzb(String str, boolean z) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzeg.zza(zzax, z);
        Parcel zza = zza(11, zzax);
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzez
    public final String zzbd() throws RemoteException {
        Parcel zza = zza(1, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzez
    public final String zzc(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        Parcel zza = zza(7, zzax);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzez
    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(9, zzax);
    }

    @Override // com.google.android.gms.internal.zzez
    public final void zzk(String str) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzb(5, zzax);
    }
}

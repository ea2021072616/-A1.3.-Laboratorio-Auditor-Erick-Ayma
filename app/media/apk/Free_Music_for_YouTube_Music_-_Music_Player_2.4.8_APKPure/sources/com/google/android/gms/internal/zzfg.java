package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzfg extends zzee implements zzfe {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.zzfe
    public final void zza(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzax.writeString(null);
        zzb(8, zzax);
    }

    @Override // com.google.android.gms.internal.zzfe
    public final void zza(int[] iArr) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeIntArray(iArr);
        zzb(4, zzax);
    }

    @Override // com.google.android.gms.internal.zzfe
    public final void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.internal.zzfe
    public final void zzbe() throws RemoteException {
        zzb(3, zzax());
    }

    @Override // com.google.android.gms.internal.zzfe
    public final void zzc(byte[] bArr) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeByteArray(bArr);
        zzb(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzfe
    public final void zze(int i) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(6, zzax);
    }

    @Override // com.google.android.gms.internal.zzfe
    public final void zzf(int i) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(7, zzax);
    }
}

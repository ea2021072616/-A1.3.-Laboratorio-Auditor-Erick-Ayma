package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzbvd extends zzee implements zzbvb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    @Override // com.google.android.gms.internal.zzbvb
    public final boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzeg.zza(zzax, z);
        zzax.writeInt(i);
        Parcel zza = zza(2, zzax);
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzbvb
    public final int getIntFlagValue(String str, int i, int i2) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeInt(i);
        zzax.writeInt(i2);
        Parcel zza = zza(3, zzax);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.zzbvb
    public final long getLongFlagValue(String str, long j, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeLong(j);
        zzax.writeInt(i);
        Parcel zza = zza(4, zzax);
        long readLong = zza.readLong();
        zza.recycle();
        return readLong;
    }

    @Override // com.google.android.gms.internal.zzbvb
    public final String getStringFlagValue(String str, String str2, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzax.writeInt(i);
        Parcel zza = zza(5, zzax);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzbvb
    public final void init(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(1, zzax);
    }
}

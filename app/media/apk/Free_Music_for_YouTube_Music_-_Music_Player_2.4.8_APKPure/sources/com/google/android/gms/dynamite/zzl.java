package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzeg;
/* loaded from: classes.dex */
public final class zzl extends zzee implements zzk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int zza(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzeg.zza(zzax, z);
        Parcel zza = zza(3, zzax);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzax.writeInt(i);
        Parcel zza = zza(2, zzax);
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }
}

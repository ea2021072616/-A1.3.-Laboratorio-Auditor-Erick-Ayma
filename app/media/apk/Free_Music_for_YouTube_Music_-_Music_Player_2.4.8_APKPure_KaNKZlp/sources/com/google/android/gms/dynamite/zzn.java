package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzeg;
/* loaded from: classes.dex */
public final class zzn extends zzee implements zzm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.zzm
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzax.writeInt(i);
        zzeg.zza(zzax, iObjectWrapper2);
        Parcel zza = zza(2, zzax);
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }
}

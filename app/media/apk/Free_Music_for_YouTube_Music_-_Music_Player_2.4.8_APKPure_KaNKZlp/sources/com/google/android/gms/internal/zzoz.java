package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class zzoz extends zzef implements zzoy {
    public zzoz() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzoy zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        return queryLocalInterface instanceof zzoy ? (zzoy) queryLocalInterface : new zzpa(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                String text = getText();
                parcel2.writeNoException();
                parcel2.writeString(text);
                return true;
            case 3:
                List<zzpc> zzjc = zzjc();
                parcel2.writeNoException();
                parcel2.writeList(zzjc);
                return true;
            default:
                return false;
        }
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public abstract class zznl extends zzef implements zznk {
    public zznl() {
        attachInterface(this, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                String zziz = zziz();
                parcel2.writeNoException();
                parcel2.writeString(zziz);
                return true;
            case 2:
                String content = getContent();
                parcel2.writeNoException();
                parcel2.writeString(content);
                return true;
            case 3:
                zzi(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                recordClick();
                parcel2.writeNoException();
                return true;
            case 5:
                recordImpression();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}

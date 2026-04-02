package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public abstract class zzfa extends zzef implements zzez {
    public zzfa() {
        attachInterface(this, "com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                String zzbd = zzbd();
                parcel2.writeNoException();
                parcel2.writeString(zzbd);
                return true;
            case 2:
                zzb(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zza = zza(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzeg.zza(parcel2, zza);
                return true;
            case 4:
                boolean zzb = zzb(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzb);
                return true;
            case 5:
                zzk(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper zza2 = zza(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzeg.zza(parcel2, zza2);
                return true;
            case 7:
                String zzc = zzc(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                return true;
            case 8:
                String zza3 = zza(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zza3);
                return true;
            case 9:
                zzd(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                IObjectWrapper zzb2 = zzb(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzb2);
                return true;
            case 11:
                boolean zzb3 = zzb(parcel.readString(), zzeg.zza(parcel));
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzb3);
                return true;
            case 12:
                String zza4 = zza(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeString(zza4);
                return true;
            default:
                return false;
        }
    }
}

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public abstract class zzadf extends zzef implements zzade {
    public zzadf() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzade zzx(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return queryLocalInterface instanceof zzade ? (zzade) queryLocalInterface : new zzadg(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzadj zzadlVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zza((zzadp) zzeg.zza(parcel, zzadp.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                show();
                parcel2.writeNoException();
                break;
            case 3:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzadlVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                    zzadlVar = queryLocalInterface instanceof zzadj ? (zzadj) queryLocalInterface : new zzadl(readStrongBinder);
                }
                zza(zzadlVar);
                parcel2.writeNoException();
                break;
            case 4:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                break;
            case 5:
                boolean isLoaded = isLoaded();
                parcel2.writeNoException();
                zzeg.zza(parcel2, isLoaded);
                break;
            case 6:
                pause();
                parcel2.writeNoException();
                break;
            case 7:
                resume();
                parcel2.writeNoException();
                break;
            case 8:
                destroy();
                parcel2.writeNoException();
                break;
            case 9:
                zzf(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 10:
                zzg(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 11:
                zzh(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 12:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 34:
                setImmersiveMode(zzeg.zza(parcel));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}

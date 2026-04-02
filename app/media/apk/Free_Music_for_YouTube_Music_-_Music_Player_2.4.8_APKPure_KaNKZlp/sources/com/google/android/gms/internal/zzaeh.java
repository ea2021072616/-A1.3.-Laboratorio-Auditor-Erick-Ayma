package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public abstract class zzaeh extends zzef implements zzaeg {
    public zzaeh() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzaeg zzz(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        return queryLocalInterface instanceof zzaeg ? (zzaeg) queryLocalInterface : new zzaei(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzq(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                break;
            case 2:
                zzc(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                zzr(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                break;
            case 4:
                zzs(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                break;
            case 5:
                zzt(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                break;
            case 6:
                zzu(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                break;
            case 7:
                zza(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), (zzaek) zzeg.zza(parcel, zzaek.CREATOR));
                break;
            case 8:
                zzv(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                break;
            case 9:
                zzd(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                zzw(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
/* loaded from: classes2.dex */
public abstract class zzkb extends zzef implements zzka {
    public zzkb() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzkq zzkqVar = null;
        zzju zzjwVar = null;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzjx zzcy = zzcy();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzcy);
                break;
            case 2:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzjwVar = queryLocalInterface instanceof zzju ? (zzju) queryLocalInterface : new zzjw(readStrongBinder);
                }
                zzb(zzjwVar);
                parcel2.writeNoException();
                break;
            case 3:
                zza(zzpy.zzn(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 4:
                zza(zzqb.zzo(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 5:
                zza(parcel.readString(), zzqh.zzq(parcel.readStrongBinder()), zzqe.zzp(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 6:
                zza((zzot) zzeg.zza(parcel, zzot.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzkqVar = queryLocalInterface2 instanceof zzkq ? (zzkq) queryLocalInterface2 : new zzks(readStrongBinder2);
                }
                zzb(zzkqVar);
                parcel2.writeNoException();
                break;
            case 8:
                zza(zzqk.zzr(parcel.readStrongBinder()), (zzjb) zzeg.zza(parcel, zzjb.CREATOR));
                parcel2.writeNoException();
                break;
            case 9:
                zza((PublisherAdViewOptions) zzeg.zza(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}

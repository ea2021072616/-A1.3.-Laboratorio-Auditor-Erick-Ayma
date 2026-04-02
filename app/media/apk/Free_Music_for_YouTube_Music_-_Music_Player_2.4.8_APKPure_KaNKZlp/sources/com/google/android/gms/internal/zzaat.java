package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public abstract class zzaat extends zzef implements zzaas {
    public zzaat() {
        attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaay zzaayVar = null;
        zzaav zzaaxVar = null;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzaao zzb = zzb((zzaak) zzeg.zza(parcel, zzaak.CREATOR));
                parcel2.writeNoException();
                zzeg.zzb(parcel2, zzb);
                break;
            case 2:
                zzaak zzaakVar = (zzaak) zzeg.zza(parcel, zzaak.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    zzaaxVar = queryLocalInterface instanceof zzaav ? (zzaav) queryLocalInterface : new zzaax(readStrongBinder);
                }
                zza(zzaakVar, zzaaxVar);
                parcel2.writeNoException();
                break;
            case 3:
                zzabd zzabdVar = (zzabd) zzeg.zza(parcel, zzabd.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonResponseListener");
                    zzaayVar = queryLocalInterface2 instanceof zzaay ? (zzaay) queryLocalInterface2 : new zzaaz(readStrongBinder2);
                }
                zza(zzabdVar, zzaayVar);
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}

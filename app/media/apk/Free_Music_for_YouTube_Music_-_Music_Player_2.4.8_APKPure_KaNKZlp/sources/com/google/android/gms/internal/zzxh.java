package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public abstract class zzxh extends zzef implements zzxg {
    public zzxh() {
        attachInterface(this, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzxg zzt(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        return queryLocalInterface instanceof zzxg ? (zzxg) queryLocalInterface : new zzxi(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                onCreate((Bundle) zzeg.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                onRestart();
                parcel2.writeNoException();
                break;
            case 3:
                onStart();
                parcel2.writeNoException();
                break;
            case 4:
                onResume();
                parcel2.writeNoException();
                break;
            case 5:
                onPause();
                parcel2.writeNoException();
                break;
            case 6:
                Bundle bundle = (Bundle) zzeg.zza(parcel, Bundle.CREATOR);
                onSaveInstanceState(bundle);
                parcel2.writeNoException();
                zzeg.zzb(parcel2, bundle);
                break;
            case 7:
                onStop();
                parcel2.writeNoException();
                break;
            case 8:
                onDestroy();
                parcel2.writeNoException();
                break;
            case 9:
                zzay();
                parcel2.writeNoException();
                break;
            case 10:
                onBackPressed();
                parcel2.writeNoException();
                break;
            case 11:
                boolean zzmn = zzmn();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzmn);
                break;
            case 12:
                onActivityResult(parcel.readInt(), parcel.readInt(), (Intent) zzeg.zza(parcel, Intent.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                zzo(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}

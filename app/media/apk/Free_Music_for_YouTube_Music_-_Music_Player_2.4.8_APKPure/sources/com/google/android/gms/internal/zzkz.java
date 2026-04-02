package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzkz extends zzef implements zzky {
    public zzkz() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzky zzh(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof zzky ? (zzky) queryLocalInterface : new zzla(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzlb zzldVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                break;
            case 2:
                pause();
                parcel2.writeNoException();
                break;
            case 3:
                mute(zzeg.zza(parcel));
                parcel2.writeNoException();
                break;
            case 4:
                boolean isMuted = isMuted();
                parcel2.writeNoException();
                zzeg.zza(parcel2, isMuted);
                break;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                break;
            case 6:
                float zzhx = zzhx();
                parcel2.writeNoException();
                parcel2.writeFloat(zzhx);
                break;
            case 7:
                float zzhy = zzhy();
                parcel2.writeNoException();
                parcel2.writeFloat(zzhy);
                break;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzldVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    zzldVar = queryLocalInterface instanceof zzlb ? (zzlb) queryLocalInterface : new zzld(readStrongBinder);
                }
                zza(zzldVar);
                parcel2.writeNoException();
                break;
            case 9:
                float aspectRatio = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(aspectRatio);
                break;
            case 10:
                boolean isCustomControlsEnabled = isCustomControlsEnabled();
                parcel2.writeNoException();
                zzeg.zza(parcel2, isCustomControlsEnabled);
                break;
            default:
                return false;
        }
        return true;
    }
}

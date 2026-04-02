package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class zzlc extends zzef implements zzlb {
    public zzlc() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                onVideoStart();
                break;
            case 2:
                onVideoPlay();
                break;
            case 3:
                onVideoPause();
                break;
            case 4:
                onVideoEnd();
                break;
            case 5:
                onVideoMute(zzeg.zza(parcel));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}

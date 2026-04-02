package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class zzpq extends zzef implements zzpp {
    public zzpq() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                IObjectWrapper zzjj = zzjj();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzjj);
                break;
            case 3:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 4:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                break;
            case 5:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                break;
            case 6:
                zzpc zzjo = zzjo();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzjo);
                break;
            case 7:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                break;
            case 8:
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
                break;
            case 9:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzeg.zzb(parcel2, extras);
                break;
            case 10:
                destroy();
                parcel2.writeNoException();
                break;
            case 11:
                zzky videoController = getVideoController();
                parcel2.writeNoException();
                zzeg.zza(parcel2, videoController);
                break;
            case 12:
                performClick((Bundle) zzeg.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                boolean recordImpression = recordImpression((Bundle) zzeg.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzeg.zza(parcel2, recordImpression);
                break;
            case 14:
                reportTouchEvent((Bundle) zzeg.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 15:
                zzoy zzjn = zzjn();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzjn);
                break;
            default:
                return false;
        }
        return true;
    }
}

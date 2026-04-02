package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class zzvn extends zzef implements zzvm {
    public zzvn() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 3:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 4:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                return true;
            case 5:
                zzpc zzji = zzji();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzji);
                return true;
            case 6:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                return true;
            case 7:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                return true;
            case 8:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                return true;
            case 9:
                String price = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(price);
                return true;
            case 10:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 11:
                zzl(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                zzm(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                zzeg.zza(parcel2, overrideImpressionRecording);
                return true;
            case 14:
                boolean overrideClickHandling = getOverrideClickHandling();
                parcel2.writeNoException();
                zzeg.zza(parcel2, overrideClickHandling);
                return true;
            case 15:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzeg.zzb(parcel2, extras);
                return true;
            case 16:
                zzn(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 17:
                zzky videoController = getVideoController();
                parcel2.writeNoException();
                zzeg.zza(parcel2, videoController);
                return true;
            case 18:
                IObjectWrapper zzly = zzly();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzly);
                return true;
            case 19:
                zzoy zzjn = zzjn();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzjn);
                return true;
            case 20:
                IObjectWrapper zzlz = zzlz();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzlz);
                return true;
            default:
                return false;
        }
    }
}

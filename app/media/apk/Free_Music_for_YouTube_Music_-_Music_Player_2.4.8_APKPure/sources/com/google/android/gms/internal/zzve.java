package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public abstract class zzve extends zzef implements zzvd {
    public zzve() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzvg zzviVar;
        zzvg zzviVar2;
        zzvg zzviVar3;
        zzvg zzvgVar = null;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IObjectWrapper zzao = IObjectWrapper.zza.zzao(parcel.readStrongBinder());
                zzjb zzjbVar = (zzjb) zzeg.zza(parcel, zzjb.CREATOR);
                zzix zzixVar = (zzix) zzeg.zza(parcel, zzix.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzviVar3 = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzviVar3 = queryLocalInterface instanceof zzvg ? (zzvg) queryLocalInterface : new zzvi(readStrongBinder);
                }
                zza(zzao, zzjbVar, zzixVar, readString, zzviVar3);
                parcel2.writeNoException();
                break;
            case 2:
                IObjectWrapper view = getView();
                parcel2.writeNoException();
                zzeg.zza(parcel2, view);
                break;
            case 3:
                IObjectWrapper zzao2 = IObjectWrapper.zza.zzao(parcel.readStrongBinder());
                zzix zzixVar2 = (zzix) zzeg.zza(parcel, zzix.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzvgVar = queryLocalInterface2 instanceof zzvg ? (zzvg) queryLocalInterface2 : new zzvi(readStrongBinder2);
                }
                zza(zzao2, zzixVar2, readString2, zzvgVar);
                parcel2.writeNoException();
                break;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                break;
            case 5:
                destroy();
                parcel2.writeNoException();
                break;
            case 6:
                IObjectWrapper zzao3 = IObjectWrapper.zza.zzao(parcel.readStrongBinder());
                zzjb zzjbVar2 = (zzjb) zzeg.zza(parcel, zzjb.CREATOR);
                zzix zzixVar3 = (zzix) zzeg.zza(parcel, zzix.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzvgVar = queryLocalInterface3 instanceof zzvg ? (zzvg) queryLocalInterface3 : new zzvi(readStrongBinder3);
                }
                zza(zzao3, zzjbVar2, zzixVar3, readString3, readString4, zzvgVar);
                parcel2.writeNoException();
                break;
            case 7:
                IObjectWrapper zzao4 = IObjectWrapper.zza.zzao(parcel.readStrongBinder());
                zzix zzixVar4 = (zzix) zzeg.zza(parcel, zzix.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 == null) {
                    zzviVar2 = null;
                } else {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzviVar2 = queryLocalInterface4 instanceof zzvg ? (zzvg) queryLocalInterface4 : new zzvi(readStrongBinder4);
                }
                zza(zzao4, zzixVar4, readString5, readString6, zzviVar2);
                parcel2.writeNoException();
                break;
            case 8:
                pause();
                parcel2.writeNoException();
                break;
            case 9:
                resume();
                parcel2.writeNoException();
                break;
            case 10:
                zza(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), (zzix) zzeg.zza(parcel, zzix.CREATOR), parcel.readString(), zzaeh.zzz(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                zzc((zzix) zzeg.zza(parcel, zzix.CREATOR), parcel.readString());
                parcel2.writeNoException();
                break;
            case 12:
                showVideo();
                parcel2.writeNoException();
                break;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzeg.zza(parcel2, isInitialized);
                break;
            case 14:
                IObjectWrapper zzao5 = IObjectWrapper.zza.zzao(parcel.readStrongBinder());
                zzix zzixVar5 = (zzix) zzeg.zza(parcel, zzix.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 == null) {
                    zzviVar = null;
                } else {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzviVar = queryLocalInterface5 instanceof zzvg ? (zzvg) queryLocalInterface5 : new zzvi(readStrongBinder5);
                }
                zza(zzao5, zzixVar5, readString7, readString8, zzviVar, (zzot) zzeg.zza(parcel, zzot.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                break;
            case 15:
                zzvm zzls = zzls();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzls);
                break;
            case 16:
                zzvp zzlt = zzlt();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzlt);
                break;
            case 17:
                Bundle zzlu = zzlu();
                parcel2.writeNoException();
                zzeg.zzb(parcel2, zzlu);
                break;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzeg.zzb(parcel2, interstitialAdapterInfo);
                break;
            case 19:
                Bundle zzlv = zzlv();
                parcel2.writeNoException();
                zzeg.zzb(parcel2, zzlv);
                break;
            case 20:
                zza((zzix) zzeg.zza(parcel, zzix.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 21:
                zzk(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 22:
                boolean zzlw = zzlw();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzlw);
                break;
            case 23:
                zza(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), zzaeh.zzz(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                break;
            case 24:
                zzpt zzlx = zzlx();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzlx);
                break;
            case 25:
                setImmersiveMode(zzeg.zza(parcel));
                parcel2.writeNoException();
                break;
            case 26:
                zzky videoController = getVideoController();
                parcel2.writeNoException();
                zzeg.zza(parcel2, videoController);
                break;
            default:
                return false;
        }
        return true;
    }
}

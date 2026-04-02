package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public abstract class zzkg extends zzef implements zzkf {
    public zzkg() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzkf zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzkf ? (zzkf) queryLocalInterface : new zzkh(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzkq zzkqVar = null;
        zzju zzjwVar = null;
        zzkk zzkmVar = null;
        zzjr zzjtVar = null;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IObjectWrapper zzbk = zzbk();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzbk);
                break;
            case 2:
                destroy();
                parcel2.writeNoException();
                break;
            case 3:
                boolean isReady = isReady();
                parcel2.writeNoException();
                zzeg.zza(parcel2, isReady);
                break;
            case 4:
                boolean zzb = zzb((zzix) zzeg.zza(parcel, zzix.CREATOR));
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzb);
                break;
            case 5:
                pause();
                parcel2.writeNoException();
                break;
            case 6:
                resume();
                parcel2.writeNoException();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzjwVar = queryLocalInterface instanceof zzju ? (zzju) queryLocalInterface : new zzjw(readStrongBinder);
                }
                zza(zzjwVar);
                parcel2.writeNoException();
                break;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzkmVar = queryLocalInterface2 instanceof zzkk ? (zzkk) queryLocalInterface2 : new zzkm(readStrongBinder2);
                }
                zza(zzkmVar);
                parcel2.writeNoException();
                break;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                break;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                break;
            case 11:
                zzbn();
                parcel2.writeNoException();
                break;
            case 12:
                zzjb zzbl = zzbl();
                parcel2.writeNoException();
                zzeg.zzb(parcel2, zzbl);
                break;
            case 13:
                zza((zzjb) zzeg.zza(parcel, zzjb.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                zza(zzxo.zzu(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 15:
                zza(zzxu.zzw(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 19:
                zza(zzno.zzi(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzjtVar = queryLocalInterface3 instanceof zzjr ? (zzjr) queryLocalInterface3 : new zzjt(readStrongBinder3);
                }
                zza(zzjtVar);
                parcel2.writeNoException();
                break;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzkqVar = queryLocalInterface4 instanceof zzkq ? (zzkq) queryLocalInterface4 : new zzks(readStrongBinder4);
                }
                zza(zzkqVar);
                parcel2.writeNoException();
                break;
            case 22:
                setManualImpressionsEnabled(zzeg.zza(parcel));
                parcel2.writeNoException();
                break;
            case 23:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzeg.zza(parcel2, isLoading);
                break;
            case 24:
                zza(zzadk.zzy(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                break;
            case 26:
                zzky videoController = getVideoController();
                parcel2.writeNoException();
                zzeg.zza(parcel2, videoController);
                break;
            case 29:
                zza((zzmd) zzeg.zza(parcel, zzmd.CREATOR));
                parcel2.writeNoException();
                break;
            case 30:
                zza((zzle) zzeg.zza(parcel, zzle.CREATOR));
                parcel2.writeNoException();
                break;
            case 31:
                String adUnitId = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(adUnitId);
                break;
            case 32:
                zzkk zzbw = zzbw();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzbw);
                break;
            case 33:
                zzju zzbx = zzbx();
                parcel2.writeNoException();
                zzeg.zza(parcel2, zzbx);
                break;
            case 34:
                setImmersiveMode(zzeg.zza(parcel));
                parcel2.writeNoException();
                break;
            case 35:
                String zzch = zzch();
                parcel2.writeNoException();
                parcel2.writeString(zzch);
                break;
        }
        return true;
    }
}

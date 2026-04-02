package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzvo extends zzee implements zzvm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getBody() throws RemoteException {
        Parcel zza = zza(4, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getCallToAction() throws RemoteException {
        Parcel zza = zza(6, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final Bundle getExtras() throws RemoteException {
        Parcel zza = zza(15, zzax());
        Bundle bundle = (Bundle) zzeg.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getHeadline() throws RemoteException {
        Parcel zza = zza(2, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final List getImages() throws RemoteException {
        Parcel zza = zza(3, zzax());
        ArrayList zzb = zzeg.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel zza = zza(14, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel zza = zza(13, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getPrice() throws RemoteException {
        Parcel zza = zza(9, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final double getStarRating() throws RemoteException {
        Parcel zza = zza(7, zzax());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getStore() throws RemoteException {
        Parcel zza = zza(8, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final zzky getVideoController() throws RemoteException {
        Parcel zza = zza(17, zzax());
        zzky zzh = zzkz.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void recordImpression() throws RemoteException {
        zzb(10, zzax());
    }

    @Override // com.google.android.gms.internal.zzvm
    public final zzpc zzji() throws RemoteException {
        Parcel zza = zza(5, zzax());
        zzpc zzk = zzpd.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final zzoy zzjn() throws RemoteException {
        Parcel zza = zza(19, zzax());
        zzoy zzj = zzoz.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(11, zzax);
    }

    @Override // com.google.android.gms.internal.zzvm
    public final IObjectWrapper zzly() throws RemoteException {
        Parcel zza = zza(18, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final IObjectWrapper zzlz() throws RemoteException {
        Parcel zza = zza(20, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(12, zzax);
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(16, zzax);
    }
}

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzpr extends zzee implements zzpp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.zzpp
    public final void destroy() throws RemoteException {
        zzb(10, zzax());
    }

    @Override // com.google.android.gms.internal.zzpp
    public final String getAdvertiser() throws RemoteException {
        Parcel zza = zza(8, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final String getBody() throws RemoteException {
        Parcel zza = zza(5, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final String getCallToAction() throws RemoteException {
        Parcel zza = zza(7, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final Bundle getExtras() throws RemoteException {
        Parcel zza = zza(9, zzax());
        Bundle bundle = (Bundle) zzeg.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final String getHeadline() throws RemoteException {
        Parcel zza = zza(3, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzpp, com.google.android.gms.internal.zzoh
    public final List getImages() throws RemoteException {
        Parcel zza = zza(4, zzax());
        ArrayList zzb = zzeg.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final zzky getVideoController() throws RemoteException {
        Parcel zza = zza(11, zzax());
        zzky zzh = zzkz.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final void performClick(Bundle bundle) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, bundle);
        zzb(12, zzax);
    }

    @Override // com.google.android.gms.internal.zzpp
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, bundle);
        Parcel zza = zza(13, zzax);
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, bundle);
        zzb(14, zzax);
    }

    @Override // com.google.android.gms.internal.zzpp
    public final IObjectWrapper zzjj() throws RemoteException {
        Parcel zza = zza(2, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final zzoy zzjn() throws RemoteException {
        zzoy zzpaVar;
        Parcel zza = zza(15, zzax());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzpaVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzpaVar = queryLocalInterface instanceof zzoy ? (zzoy) queryLocalInterface : new zzpa(readStrongBinder);
        }
        zza.recycle();
        return zzpaVar;
    }

    @Override // com.google.android.gms.internal.zzpp
    public final zzpc zzjo() throws RemoteException {
        zzpc zzpeVar;
        Parcel zza = zza(6, zzax());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzpeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzpeVar = queryLocalInterface instanceof zzpc ? (zzpc) queryLocalInterface : new zzpe(readStrongBinder);
        }
        zza.recycle();
        return zzpeVar;
    }
}

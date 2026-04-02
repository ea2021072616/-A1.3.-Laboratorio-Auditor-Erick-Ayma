package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzvr extends zzee implements zzvp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.zzvp
    public final String getAdvertiser() throws RemoteException {
        Parcel zza = zza(7, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final String getBody() throws RemoteException {
        Parcel zza = zza(4, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final String getCallToAction() throws RemoteException {
        Parcel zza = zza(6, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final Bundle getExtras() throws RemoteException {
        Parcel zza = zza(13, zzax());
        Bundle bundle = (Bundle) zzeg.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final String getHeadline() throws RemoteException {
        Parcel zza = zza(2, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final List getImages() throws RemoteException {
        Parcel zza = zza(3, zzax());
        ArrayList zzb = zzeg.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel zza = zza(12, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel zza = zza(11, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final zzky getVideoController() throws RemoteException {
        Parcel zza = zza(16, zzax());
        zzky zzh = zzkz.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final void recordImpression() throws RemoteException {
        zzb(8, zzax());
    }

    @Override // com.google.android.gms.internal.zzvp
    public final zzoy zzjn() throws RemoteException {
        Parcel zza = zza(19, zzax());
        zzoy zzj = zzoz.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final zzpc zzjo() throws RemoteException {
        Parcel zza = zza(5, zzax());
        zzpc zzk = zzpd.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(9, zzax);
    }

    @Override // com.google.android.gms.internal.zzvp
    public final IObjectWrapper zzly() throws RemoteException {
        Parcel zza = zza(15, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final IObjectWrapper zzlz() throws RemoteException {
        Parcel zza = zza(20, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(10, zzax);
    }

    @Override // com.google.android.gms.internal.zzvp
    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(14, zzax);
    }
}

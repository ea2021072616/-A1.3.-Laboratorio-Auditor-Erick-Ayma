package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzpv extends zzee implements zzpt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.zzpt
    public final void destroy() throws RemoteException {
        zzb(8, zzax());
    }

    @Override // com.google.android.gms.internal.zzpt
    public final List<String> getAvailableAssetNames() throws RemoteException {
        Parcel zza = zza(3, zzax());
        ArrayList<String> createStringArrayList = zza.createStringArrayList();
        zza.recycle();
        return createStringArrayList;
    }

    @Override // com.google.android.gms.internal.zzpt, com.google.android.gms.internal.zzog
    public final String getCustomTemplateId() throws RemoteException {
        Parcel zza = zza(4, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzpt
    public final zzky getVideoController() throws RemoteException {
        Parcel zza = zza(7, zzax());
        zzky zzh = zzkz.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.zzpt
    public final void performClick(String str) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzb(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzpt
    public final void recordImpression() throws RemoteException {
        zzb(6, zzax());
    }

    @Override // com.google.android.gms.internal.zzpt
    public final String zzao(String str) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        Parcel zza = zza(1, zzax);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzpt
    public final zzpc zzap(String str) throws RemoteException {
        zzpc zzpeVar;
        Parcel zzax = zzax();
        zzax.writeString(str);
        Parcel zza = zza(2, zzax);
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

    @Override // com.google.android.gms.internal.zzpt
    public final boolean zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        Parcel zza = zza(10, zzax);
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzpt
    public final IObjectWrapper zzjj() throws RemoteException {
        Parcel zza = zza(11, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.internal.zzpt
    public final IObjectWrapper zzjp() throws RemoteException {
        Parcel zza = zza(9, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }
}

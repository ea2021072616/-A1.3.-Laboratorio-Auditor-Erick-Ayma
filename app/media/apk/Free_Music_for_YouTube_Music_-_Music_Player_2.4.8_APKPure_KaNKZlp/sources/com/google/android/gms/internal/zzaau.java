package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class zzaau extends zzee implements zzaas {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.zzaas
    public final void zza(zzaak zzaakVar, zzaav zzaavVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzaakVar);
        zzeg.zza(zzax, zzaavVar);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.internal.zzaas
    public final void zza(zzabd zzabdVar, zzaay zzaayVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzabdVar);
        zzeg.zza(zzax, zzaayVar);
        zzb(3, zzax);
    }

    @Override // com.google.android.gms.internal.zzaas
    public final zzaao zzb(zzaak zzaakVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzaakVar);
        Parcel zza = zza(1, zzax);
        zzaao zzaaoVar = (zzaao) zzeg.zza(zza, zzaao.CREATOR);
        zza.recycle();
        return zzaaoVar;
    }
}

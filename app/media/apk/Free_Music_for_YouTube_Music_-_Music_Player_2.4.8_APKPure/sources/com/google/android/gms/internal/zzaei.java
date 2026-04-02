package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public final class zzaei extends zzee implements zzaeg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaei(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zza(IObjectWrapper iObjectWrapper, zzaek zzaekVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzeg.zza(zzax, zzaekVar);
        zzb(7, zzax);
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzc(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeInt(i);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzax.writeInt(i);
        zzb(9, zzax);
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(1, zzax);
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(3, zzax);
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(4, zzax);
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(6, zzax);
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(8, zzax);
    }

    @Override // com.google.android.gms.internal.zzaeg
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(10, zzax);
    }
}

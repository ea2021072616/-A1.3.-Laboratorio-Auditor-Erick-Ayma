package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
/* loaded from: classes2.dex */
public final class zzkc extends zzee implements zzka {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, publisherAdViewOptions);
        zzb(9, zzax);
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(zzot zzotVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzotVar);
        zzb(6, zzax);
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(zzpx zzpxVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzpxVar);
        zzb(3, zzax);
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(zzqa zzqaVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzqaVar);
        zzb(4, zzax);
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(zzqj zzqjVar, zzjb zzjbVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzqjVar);
        zzeg.zza(zzax, zzjbVar);
        zzb(8, zzax);
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zza(String str, zzqg zzqgVar, zzqd zzqdVar) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzeg.zza(zzax, zzqgVar);
        zzeg.zza(zzax, zzqdVar);
        zzb(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zzb(zzju zzjuVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzjuVar);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.internal.zzka
    public final void zzb(zzkq zzkqVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzkqVar);
        zzb(7, zzax);
    }

    @Override // com.google.android.gms.internal.zzka
    public final zzjx zzcy() throws RemoteException {
        zzjx zzjzVar;
        Parcel zza = zza(1, zzax());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzjzVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            zzjzVar = queryLocalInterface instanceof zzjx ? (zzjx) queryLocalInterface : new zzjz(readStrongBinder);
        }
        zza.recycle();
        return zzjzVar;
    }
}

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class zzla extends zzee implements zzky {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzla(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.internal.zzky
    public final float getAspectRatio() throws RemoteException {
        Parcel zza = zza(9, zzax());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.zzky
    public final int getPlaybackState() throws RemoteException {
        Parcel zza = zza(5, zzax());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.zzky
    public final boolean isCustomControlsEnabled() throws RemoteException {
        Parcel zza = zza(10, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzky
    public final boolean isMuted() throws RemoteException {
        Parcel zza = zza(4, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzky
    public final void mute(boolean z) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, z);
        zzb(3, zzax);
    }

    @Override // com.google.android.gms.internal.zzky
    public final void pause() throws RemoteException {
        zzb(2, zzax());
    }

    @Override // com.google.android.gms.internal.zzky
    public final void play() throws RemoteException {
        zzb(1, zzax());
    }

    @Override // com.google.android.gms.internal.zzky
    public final void zza(zzlb zzlbVar) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, zzlbVar);
        zzb(8, zzax);
    }

    @Override // com.google.android.gms.internal.zzky
    public final float zzhx() throws RemoteException {
        Parcel zza = zza(6, zzax());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.zzky
    public final float zzhy() throws RemoteException {
        Parcel zza = zza(7, zzax());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }
}

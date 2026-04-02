package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes2.dex */
public final class zzxi extends zzee implements zzxg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzax.writeInt(i2);
        zzeg.zza(zzax, intent);
        zzb(12, zzax);
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onBackPressed() throws RemoteException {
        zzb(10, zzax());
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, bundle);
        zzb(1, zzax);
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onDestroy() throws RemoteException {
        zzb(8, zzax());
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onPause() throws RemoteException {
        zzb(5, zzax());
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onRestart() throws RemoteException {
        zzb(2, zzax());
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onResume() throws RemoteException {
        zzb(4, zzax());
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, bundle);
        Parcel zza = zza(6, zzax);
        if (zza.readInt() != 0) {
            bundle.readFromParcel(zza);
        }
        zza.recycle();
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onStart() throws RemoteException {
        zzb(3, zzax());
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void onStop() throws RemoteException {
        zzb(7, zzax());
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void zzay() throws RemoteException {
        zzb(9, zzax());
    }

    @Override // com.google.android.gms.internal.zzxg
    public final boolean zzmn() throws RemoteException {
        Parcel zza = zza(11, zzax());
        boolean zza2 = zzeg.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzxg
    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzax = zzax();
        zzeg.zza(zzax, iObjectWrapper);
        zzb(13, zzax);
    }
}

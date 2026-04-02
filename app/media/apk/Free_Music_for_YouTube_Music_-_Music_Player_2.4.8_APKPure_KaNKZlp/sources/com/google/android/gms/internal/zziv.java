package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
@zzzt
/* loaded from: classes.dex */
public final class zziv extends com.google.android.gms.dynamic.zzp<zzkd> {
    public zziv() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzka zza(Context context, String str, zzva zzvaVar) {
        zzka zzkcVar;
        try {
            IBinder zza = zzcv(context).zza(com.google.android.gms.dynamic.zzn.zzw(context), str, zzvaVar, 11200000);
            if (zza == null) {
                zzkcVar = null;
            } else {
                IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                zzkcVar = queryLocalInterface instanceof zzka ? (zzka) queryLocalInterface : new zzkc(zza);
            }
            return zzkcVar;
        } catch (RemoteException e) {
            zzaji.zzc("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzq e2) {
            zzaji.zzc("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzkd zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        return queryLocalInterface instanceof zzkd ? (zzkd) queryLocalInterface : new zzke(iBinder);
    }
}

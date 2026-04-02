package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
@zzzt
/* loaded from: classes.dex */
public final class zzlo extends com.google.android.gms.dynamic.zzp<zzkw> {
    public zzlo() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzkw zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return queryLocalInterface instanceof zzkw ? (zzkw) queryLocalInterface : new zzkx(iBinder);
    }

    public final zzkt zzj(Context context) {
        zzkt zzkvVar;
        try {
            IBinder zza = zzcv(context).zza(com.google.android.gms.dynamic.zzn.zzw(context), 11200000);
            if (zza == null) {
                zzkvVar = null;
            } else {
                IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                zzkvVar = queryLocalInterface instanceof zzkt ? (zzkt) queryLocalInterface : new zzkv(zza);
            }
            return zzkvVar;
        } catch (RemoteException e) {
            zzaji.zzc("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzq e2) {
            zzaji.zzc("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
@zzzt
/* loaded from: classes.dex */
public final class zzadn extends com.google.android.gms.dynamic.zzp<zzadh> {
    public zzadn() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public final zzade zza(Context context, zzva zzvaVar) {
        zzade zzadgVar;
        try {
            IBinder zza = zzcv(context).zza(com.google.android.gms.dynamic.zzn.zzw(context), zzvaVar, 11200000);
            if (zza == null) {
                zzadgVar = null;
            } else {
                IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
                zzadgVar = queryLocalInterface instanceof zzade ? (zzade) queryLocalInterface : new zzadg(zza);
            }
            return zzadgVar;
        } catch (RemoteException | com.google.android.gms.dynamic.zzq e) {
            zzaji.zzc("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzadh zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        return queryLocalInterface instanceof zzadh ? (zzadh) queryLocalInterface : new zzadi(iBinder);
    }
}

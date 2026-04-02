package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzjf;
@zzzt
/* loaded from: classes.dex */
public final class zzll {
    private static final Object zzaqm = new Object();
    private static zzll zzbel;
    private zzkt zzbem;
    private RewardedVideoAd zzben;

    private zzll() {
    }

    public static zzll zzif() {
        zzll zzllVar;
        synchronized (zzaqm) {
            if (zzbel == null) {
                zzbel = new zzll();
            }
            zzllVar = zzbel;
        }
        return zzllVar;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (zzaqm) {
            if (this.zzben != null) {
                rewardedVideoAd = this.zzben;
            } else {
                this.zzben = new zzadr(context, (zzade) zzjf.zza(context, false, (zzjf.zza<Object>) new zzjm(zzjo.zzhv(), context, new zzuz())));
                rewardedVideoAd = this.zzben;
            }
        }
        return rewardedVideoAd;
    }

    public final void openDebugMenu(Context context, String str) {
        zzbp.zza(this.zzbem != null, "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.zzbem.zzc(com.google.android.gms.dynamic.zzn.zzw(context), str);
        } catch (RemoteException e) {
            zzaji.zzb("Unable to open debug menu.", e);
        }
    }

    public final void setAppMuted(boolean z) {
        zzbp.zza(this.zzbem != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzbem.setAppMuted(z);
        } catch (RemoteException e) {
            zzaji.zzb("Unable to set app mute state.", e);
        }
    }

    public final void setAppVolume(float f) {
        zzbp.zzb(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        zzbp.zza(this.zzbem != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzbem.setAppVolume(f);
        } catch (RemoteException e) {
            zzaji.zzb("Unable to set app volume.", e);
        }
    }

    public final void zza(Context context, String str, zzln zzlnVar) {
        synchronized (zzaqm) {
            if (this.zzbem != null) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                this.zzbem = (zzkt) zzjf.zza(context, false, (zzjf.zza<Object>) new zzjk(zzjo.zzhv(), context));
                this.zzbem.initialize();
                if (str != null) {
                    this.zzbem.zzc(str, com.google.android.gms.dynamic.zzn.zzw(new zzlm(this, context)));
                }
            } catch (RemoteException e) {
                zzaji.zzc("MobileAdsSettingManager initialization failed", e);
            }
        }
    }
}

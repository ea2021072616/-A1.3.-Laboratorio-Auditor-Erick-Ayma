package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.Random;
/* loaded from: classes2.dex */
final class zztt extends zzjv {
    private final zzju zzbxf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztt(zzju zzjuVar) {
        this.zzbxf = zzjuVar;
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdClicked() throws RemoteException {
        this.zzbxf.onAdClicked();
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdClosed() throws RemoteException {
        if (zzuc.zzkz()) {
            int intValue = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbki)).intValue();
            int intValue2 = ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbkj)).intValue();
            if (intValue <= 0 || intValue2 < 0) {
                com.google.android.gms.ads.internal.zzbv.zzep().zzki();
            } else {
                zzahf.zzdbo.postDelayed(zztu.zzbxg, new Random().nextInt(intValue2 + 1) + intValue);
            }
        }
        this.zzbxf.onAdClosed();
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdFailedToLoad(int i) throws RemoteException {
        this.zzbxf.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdImpression() throws RemoteException {
        this.zzbxf.onAdImpression();
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdLeftApplication() throws RemoteException {
        this.zzbxf.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdLoaded() throws RemoteException {
        this.zzbxf.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdOpened() throws RemoteException {
        this.zzbxf.onAdOpened();
    }
}

package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
@zzzt
/* loaded from: classes.dex */
public final class zzqn extends zzpy {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzbud;

    public zzqn(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzbud = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzpx
    public final void zza(zzpl zzplVar) {
        this.zzbud.onAppInstallAdLoaded(new zzpo(zzplVar));
    }
}

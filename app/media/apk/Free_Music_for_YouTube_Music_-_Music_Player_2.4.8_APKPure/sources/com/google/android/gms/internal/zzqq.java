package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
@zzzt
/* loaded from: classes.dex */
public final class zzqq extends zzqh {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzbug;

    public zzqq(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzbug = onCustomTemplateAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzqg
    public final void zza(zzpt zzptVar) {
        this.zzbug.onCustomTemplateAdLoaded(new zzpw(zzptVar));
    }
}

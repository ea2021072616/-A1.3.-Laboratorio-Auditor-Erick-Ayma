package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd;
@zzzt
/* loaded from: classes.dex */
public final class zzqo extends zzqb {
    private final NativeContentAd.OnContentAdLoadedListener zzbue;

    public zzqo(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzbue = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzqa
    public final void zza(zzpp zzppVar) {
        this.zzbue.onContentAdLoaded(new zzps(zzppVar));
    }
}

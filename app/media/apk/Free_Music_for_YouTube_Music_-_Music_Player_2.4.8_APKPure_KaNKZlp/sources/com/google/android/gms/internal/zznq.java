package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
@zzzt
/* loaded from: classes.dex */
public final class zznq extends zzno {
    private final OnCustomRenderedAdLoadedListener zzbef;

    public zznq(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzbef = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zznn
    public final void zza(zznk zznkVar) {
        this.zzbef.onCustomRenderedAdLoaded(new zznj(zznkVar));
    }
}

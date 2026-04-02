package com.google.android.gms.internal;

import com.google.android.gms.ads.VideoController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzlj extends zzjq {
    private /* synthetic */ zzli zzbei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlj(zzli zzliVar) {
        this.zzbei = zzliVar;
    }

    @Override // com.google.android.gms.internal.zzjq, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        VideoController videoController;
        videoController = this.zzbei.zzbeb;
        videoController.zza(this.zzbei.zzbc());
        super.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.zzjq, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        VideoController videoController;
        videoController = this.zzbei.zzbeb;
        videoController.zza(this.zzbei.zzbc());
        super.onAdLoaded();
    }
}

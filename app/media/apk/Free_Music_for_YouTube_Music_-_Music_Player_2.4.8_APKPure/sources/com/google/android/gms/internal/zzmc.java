package com.google.android.gms.internal;

import com.google.android.gms.ads.VideoController;
/* loaded from: classes2.dex */
public final class zzmc extends zzlc {
    private final VideoController.VideoLifecycleCallbacks zzald;

    public zzmc(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzald = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.zzlb
    public final void onVideoEnd() {
        this.zzald.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.zzlb
    public final void onVideoMute(boolean z) {
        this.zzald.onVideoMute(z);
    }

    @Override // com.google.android.gms.internal.zzlb
    public final void onVideoPause() {
        this.zzald.onVideoPause();
    }

    @Override // com.google.android.gms.internal.zzlb
    public final void onVideoPlay() {
        this.zzald.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.zzlb
    public final void onVideoStart() {
        this.zzald.onVideoStart();
    }
}

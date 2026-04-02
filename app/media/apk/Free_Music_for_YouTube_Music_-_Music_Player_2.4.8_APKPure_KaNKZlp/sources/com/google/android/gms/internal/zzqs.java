package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
/* loaded from: classes2.dex */
final class zzqs implements Runnable {
    private /* synthetic */ PublisherAdView zzbui;
    private /* synthetic */ zzkf zzbuj;
    private /* synthetic */ zzqr zzbuk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqs(zzqr zzqrVar, PublisherAdView publisherAdView, zzkf zzkfVar) {
        this.zzbuk = zzqrVar;
        this.zzbui = publisherAdView;
        this.zzbuj = zzkfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener;
        if (!this.zzbui.zza(this.zzbuj)) {
            zzaji.zzcs("Could not bind ad manager");
            return;
        }
        onPublisherAdViewLoadedListener = this.zzbuk.zzbuh;
        onPublisherAdViewLoadedListener.onPublisherAdViewLoaded(this.zzbui);
    }
}

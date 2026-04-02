package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
@zzzt
/* loaded from: classes.dex */
public class zzjq extends AdListener {
    private final Object lock = new Object();
    private AdListener zzbdo;

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        synchronized (this.lock) {
            if (this.zzbdo != null) {
                this.zzbdo.onAdClosed();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(int i) {
        synchronized (this.lock) {
            if (this.zzbdo != null) {
                this.zzbdo.onAdFailedToLoad(i);
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLeftApplication() {
        synchronized (this.lock) {
            if (this.zzbdo != null) {
                this.zzbdo.onAdLeftApplication();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        synchronized (this.lock) {
            if (this.zzbdo != null) {
                this.zzbdo.onAdLoaded();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdOpened() {
        synchronized (this.lock) {
            if (this.zzbdo != null) {
                this.zzbdo.onAdOpened();
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzbdo = adListener;
        }
    }
}

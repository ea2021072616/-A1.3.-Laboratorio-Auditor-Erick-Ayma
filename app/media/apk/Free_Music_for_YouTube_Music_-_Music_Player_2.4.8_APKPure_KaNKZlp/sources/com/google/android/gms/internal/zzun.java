package com.google.android.gms.internal;

import android.support.annotation.Nullable;
@zzzt
/* loaded from: classes.dex */
public final class zzun extends zzvh {
    private final Object mLock = new Object();
    private zzus zzcbk;
    private zzum zzcbl;

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdClicked() {
        synchronized (this.mLock) {
            if (this.zzcbl != null) {
                this.zzcbl.zzcb();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdClosed() {
        synchronized (this.mLock) {
            if (this.zzcbl != null) {
                this.zzcbl.zzcc();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdFailedToLoad(int i) {
        synchronized (this.mLock) {
            if (this.zzcbk != null) {
                this.zzcbk.zzt(i == 3 ? 1 : 2);
                this.zzcbk = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdImpression() {
        synchronized (this.mLock) {
            if (this.zzcbl != null) {
                this.zzcbl.zzcg();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdLeftApplication() {
        synchronized (this.mLock) {
            if (this.zzcbl != null) {
                this.zzcbl.zzcd();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdLoaded() {
        synchronized (this.mLock) {
            if (this.zzcbk != null) {
                this.zzcbk.zzt(0);
                this.zzcbk = null;
                return;
            }
            if (this.zzcbl != null) {
                this.zzcbl.zzcf();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAdOpened() {
        synchronized (this.mLock) {
            if (this.zzcbl != null) {
                this.zzcbl.zzce();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void onAppEvent(String str, String str2) {
        synchronized (this.mLock) {
            if (this.zzcbl != null) {
                this.zzcbl.zze(str, str2);
            }
        }
    }

    public final void zza(@Nullable zzum zzumVar) {
        synchronized (this.mLock) {
            this.zzcbl = zzumVar;
        }
    }

    public final void zza(zzus zzusVar) {
        synchronized (this.mLock) {
            this.zzcbk = zzusVar;
        }
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void zza(zzvj zzvjVar) {
        synchronized (this.mLock) {
            if (this.zzcbk != null) {
                this.zzcbk.zza(0, zzvjVar);
                this.zzcbk = null;
                return;
            }
            if (this.zzcbl != null) {
                this.zzcbl.zzcf();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzvg
    public final void zzb(zzpt zzptVar, String str) {
        synchronized (this.mLock) {
            if (this.zzcbl != null) {
                this.zzcbl.zza(zzptVar, str);
            }
        }
    }
}

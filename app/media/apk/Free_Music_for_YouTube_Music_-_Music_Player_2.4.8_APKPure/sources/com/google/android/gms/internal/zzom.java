package com.google.android.gms.internal;

import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
final class zzom {
    private final WeakReference<zzakk> zzbsw;
    private String zzbsx;

    public zzom(zzakk zzakkVar) {
        this.zzbsw = new WeakReference<>(zzakkVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzrn zze(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        return new zzon(this, zzaiVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzrn zzf(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        return new zzop(this, zzaiVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzrn zzg(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        return new zzoq(this, zzaiVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzrn zzh(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        return new zzor(this, zzaiVar);
    }
}

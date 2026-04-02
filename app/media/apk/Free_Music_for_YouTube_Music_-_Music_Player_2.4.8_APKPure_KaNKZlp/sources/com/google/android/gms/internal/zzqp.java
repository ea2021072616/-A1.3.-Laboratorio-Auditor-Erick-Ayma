package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
@zzzt
/* loaded from: classes.dex */
public final class zzqp extends zzqe {
    private final NativeCustomTemplateAd.OnCustomClickListener zzbuf;

    public zzqp(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzbuf = onCustomClickListener;
    }

    @Override // com.google.android.gms.internal.zzqd
    public final void zzb(zzpt zzptVar, String str) {
        this.zzbuf.onCustomClick(new zzpw(zzptVar), str);
    }
}

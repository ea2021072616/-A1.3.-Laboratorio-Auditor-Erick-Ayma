package com.google.android.gms.internal;

import android.content.Context;
@zzzt
/* loaded from: classes.dex */
public final class zzaiw extends zzafv {
    private final String zzad;
    private final zzajj zzddq;

    public zzaiw(Context context, String str, String str2) {
        this(str2, com.google.android.gms.ads.internal.zzbv.zzea().zzs(context, str));
    }

    public zzaiw(String str, String str2) {
        this.zzddq = new zzajj(str2);
        this.zzad = str;
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.zzafv
    public final void zzdc() {
        this.zzddq.zzcm(this.zzad);
    }
}

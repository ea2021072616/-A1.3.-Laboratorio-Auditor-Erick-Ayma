package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
@TargetApi(21)
/* loaded from: classes.dex */
public final class zzahu extends zzaht {
    @Override // com.google.android.gms.internal.zzahk
    public final CookieManager zzav(Context context) {
        try {
            return CookieManager.getInstance();
        } catch (Exception e) {
            zzafx.zzb("Failed to obtain CookieManager.", e);
            com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzahn, com.google.android.gms.internal.zzahk
    public final zzakl zzb(zzakk zzakkVar, boolean z) {
        return new zzalr(zzakkVar, z);
    }

    @Override // com.google.android.gms.internal.zzahp, com.google.android.gms.internal.zzahk
    public final int zzrc() {
        return 16974374;
    }
}

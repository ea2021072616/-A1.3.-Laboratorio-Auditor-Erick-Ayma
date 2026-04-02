package com.google.android.gms.internal;

import java.util.Map;
/* loaded from: classes2.dex */
final class zzrk implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        String str = map.get("u");
        if (str == null) {
            zzafx.zzcs("URL missing from httpTrack GMSG.");
        } else {
            new zzaiw(zzakkVar.getContext(), zzakkVar.zzse().zzcp, str).zzqq();
        }
    }
}

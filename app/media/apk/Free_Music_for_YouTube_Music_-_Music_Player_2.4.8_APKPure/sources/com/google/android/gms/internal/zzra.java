package com.google.android.gms.internal;

import java.util.Map;
/* loaded from: classes2.dex */
final class zzra implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbld)).booleanValue()) {
            zzakkVar.zzad(!Boolean.parseBoolean(map.get("disabled")));
        }
    }
}

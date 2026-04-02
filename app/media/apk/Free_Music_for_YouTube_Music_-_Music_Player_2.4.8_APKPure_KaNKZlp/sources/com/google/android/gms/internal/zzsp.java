package com.google.android.gms.internal;

import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzsp implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        int i;
        com.google.android.gms.ads.internal.zzbv.zzex();
        if (map.containsKey("abort")) {
            if (zzsk.zze(zzakkVar)) {
                return;
            }
            zzafx.zzcs("Precache abort but no preload task running.");
            return;
        }
        String str = map.get("src");
        if (str == null) {
            zzafx.zzcs("Precache video action is missing the src parameter.");
            return;
        }
        try {
            i = Integer.parseInt(map.get("player"));
        } catch (NumberFormatException e) {
            i = 0;
        }
        String str2 = map.containsKey("mimetype") ? map.get("mimetype") : "";
        if (zzsk.zzf(zzakkVar)) {
            zzafx.zzcs("Precache task already running.");
            return;
        }
        com.google.android.gms.common.internal.zzc.zzr(zzakkVar.zzbj());
        new zzsi(zzakkVar, zzakkVar.zzbj().zzanp.zza(zzakkVar, i, str2), str).zzqq();
    }
}

package com.google.android.gms.internal;

import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzry implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        if (com.google.android.gms.ads.internal.zzbv.zzez().zzr(zzakkVar.getContext())) {
            int i = -1;
            try {
                i = Integer.parseInt(map.get("eventType"));
            } catch (Exception e) {
                zzafx.zzb("Parse Scion log event type error", e);
            }
            String str = map.get("eventId");
            switch (i) {
                case 0:
                    com.google.android.gms.ads.internal.zzbv.zzez().zzf(zzakkVar.getContext(), str);
                    return;
                case 1:
                    com.google.android.gms.ads.internal.zzbv.zzez().zzg(zzakkVar.getContext(), str);
                    return;
                case 2:
                    com.google.android.gms.ads.internal.zzbv.zzez().zzi(zzakkVar.getContext(), str);
                    return;
                default:
                    return;
            }
        }
    }
}

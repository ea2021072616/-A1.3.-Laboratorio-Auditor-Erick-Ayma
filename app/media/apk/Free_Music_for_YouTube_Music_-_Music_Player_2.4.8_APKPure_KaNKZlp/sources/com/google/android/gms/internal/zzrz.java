package com.google.android.gms.internal;

import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzrz implements zzrn {
    private static Map<String, Integer> zzbvy = com.google.android.gms.common.util.zze.zza("resize", 1, "playVideo", 2, "storePicture", 3, "createCalendarEvent", 4, "setOrientationProperties", 5, "closeResizedAd", 6);
    private final com.google.android.gms.ads.internal.zzw zzbvw;
    private final zzwt zzbvx;

    public zzrz(com.google.android.gms.ads.internal.zzw zzwVar, zzwt zzwtVar) {
        this.zzbvw = zzwVar;
        this.zzbvx = zzwtVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        int intValue = zzbvy.get(map.get("a")).intValue();
        if (intValue != 5 && this.zzbvw != null && !this.zzbvw.zzcq()) {
            this.zzbvw.zzs(null);
            return;
        }
        switch (intValue) {
            case 1:
                this.zzbvx.execute(map);
                return;
            case 2:
            default:
                zzafx.zzcr("Unknown MRAID command called.");
                return;
            case 3:
                new zzww(zzakkVar, map).execute();
                return;
            case 4:
                new zzwq(zzakkVar, map).execute();
                return;
            case 5:
                new zzwv(zzakkVar, map).execute();
                return;
            case 6:
                this.zzbvx.zzl(true);
                return;
        }
    }
}

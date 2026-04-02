package com.google.android.gms.internal;

import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzwv {
    private final zzakk zzbvz;
    private final boolean zzcef;
    private final String zzceg;

    public zzwv(zzakk zzakkVar, Map<String, String> map) {
        this.zzbvz = zzakkVar;
        this.zzceg = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzcef = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzcef = true;
        }
    }

    public final void execute() {
        if (this.zzbvz == null) {
            zzafx.zzcs("AdWebView is null");
        } else {
            this.zzbvz.setRequestedOrientation("portrait".equalsIgnoreCase(this.zzceg) ? com.google.android.gms.ads.internal.zzbv.zzec().zzqz() : "landscape".equalsIgnoreCase(this.zzceg) ? com.google.android.gms.ads.internal.zzbv.zzec().zzqy() : this.zzcef ? -1 : com.google.android.gms.ads.internal.zzbv.zzec().zzra());
        }
    }
}

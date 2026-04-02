package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzrv implements zzrn {
    private final zzrw zzbvu;

    public zzrv(zzrw zzrwVar) {
        this.zzbvu = zzrwVar;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        float f;
        boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground"));
        boolean equals2 = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("blur"));
        try {
        } catch (NumberFormatException e) {
            zzafx.zzb("Fail to parse float", e);
        }
        if (map.get("blurRadius") != null) {
            f = Float.parseFloat(map.get("blurRadius"));
            this.zzbvu.zzd(equals);
            this.zzbvu.zza(equals2, f);
        }
        f = 0.0f;
        this.zzbvu.zzd(equals);
        this.zzbvu.zza(equals2, f);
    }
}

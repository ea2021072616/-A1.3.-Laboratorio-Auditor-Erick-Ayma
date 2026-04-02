package com.google.android.gms.internal;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzol extends zzyr implements zzrn {
    private final WeakReference<zzof> zzapd;
    private final String zzbst;

    public zzol(zzof zzofVar, String str) {
        this.zzapd = new WeakReference<>(zzofVar);
        this.zzbst = str;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        int i;
        zzof zzofVar;
        String str = map.get("ads_id");
        if (TextUtils.isEmpty(str) || !this.zzbst.equals(str)) {
            return;
        }
        try {
            i = Integer.parseInt(map.get("eventType"));
        } catch (Exception e) {
            zzafx.zzb("Parse Scion log event type error", e);
            i = -1;
        }
        if (1 == i) {
            zzof zzofVar2 = this.zzapd.get();
            if (zzofVar2 != null) {
                zzofVar2.zzbs();
            }
        } else if (i != 0 || (zzofVar = this.zzapd.get()) == null) {
        } else {
            zzofVar.zzbt();
        }
    }

    @Override // com.google.android.gms.internal.zzyr
    public final void zzd(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zzaiVar.zza("/logScionEvent", this);
    }
}

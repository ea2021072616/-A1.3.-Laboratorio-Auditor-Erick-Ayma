package com.google.android.gms.internal;

import java.util.Map;
/* loaded from: classes.dex */
public final class zzabn implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        zzrx zzrxVar;
        String str = map.get("request_id");
        String valueOf = String.valueOf(map.get("errors"));
        zzafx.zzcs(valueOf.length() != 0 ? "Invalid request: ".concat(valueOf) : new String("Invalid request: "));
        zzrxVar = zzabf.zzcqz;
        zzrxVar.zzat(str);
    }
}

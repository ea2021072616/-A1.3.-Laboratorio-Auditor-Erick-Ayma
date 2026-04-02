package com.google.android.gms.internal;

import java.util.Map;
/* loaded from: classes2.dex */
final class zzrl implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        String valueOf = String.valueOf(map.get("string"));
        zzafx.zzcr(valueOf.length() != 0 ? "Received log message: ".concat(valueOf) : new String("Received log message: "));
    }
}

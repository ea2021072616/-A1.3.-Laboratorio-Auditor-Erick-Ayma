package com.google.android.gms.internal;

import java.util.Map;
/* loaded from: classes2.dex */
final class zzqz implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        String str = map.get("tx");
        String str2 = map.get("ty");
        String str3 = map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzcv zzsd = zzakkVar.zzsd();
            if (zzsd != null) {
                zzsd.zzac().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException e) {
            zzafx.zzcs("Could not parse touch parameters from gmsg.");
        }
    }
}

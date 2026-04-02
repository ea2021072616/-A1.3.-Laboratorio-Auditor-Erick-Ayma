package com.google.android.gms.internal;

import java.util.Map;
/* loaded from: classes2.dex */
final class zzri implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        com.google.android.gms.ads.internal.overlay.zzm zzrz = zzakkVar.zzrz();
        if (zzrz != null) {
            zzrz.close();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzsa = zzakkVar.zzsa();
        if (zzsa != null) {
            zzsa.close();
        } else {
            zzafx.zzcs("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}

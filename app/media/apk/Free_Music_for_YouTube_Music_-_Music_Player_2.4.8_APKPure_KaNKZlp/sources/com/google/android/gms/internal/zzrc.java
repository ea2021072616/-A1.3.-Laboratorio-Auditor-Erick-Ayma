package com.google.android.gms.internal;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Map;
/* loaded from: classes2.dex */
final class zzrc implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        if (map.keySet().contains(TtmlNode.START)) {
            zzakkVar.zzsb().zztb();
        } else if (map.keySet().contains("stop")) {
            zzakkVar.zzsb().zztc();
        } else if (map.keySet().contains("cancel")) {
            zzakkVar.zzsb().zztd();
        }
    }
}

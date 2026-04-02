package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzsa implements zzrn {
    private final com.google.android.gms.ads.internal.zzw zzbvw;
    private final zzwt zzbvx;

    public zzsa(com.google.android.gms.ads.internal.zzw zzwVar, zzwt zzwtVar) {
        this.zzbvw = zzwVar;
        this.zzbvx = zzwtVar;
    }

    private static boolean zzf(Map<String, String> map) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close"));
    }

    private static int zzg(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if (TtmlNode.TAG_P.equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzbv.zzec().zzqz();
            }
            if ("l".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzbv.zzec().zzqy();
            }
            if ("c".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzbv.zzec().zzra();
            }
        }
        return -1;
    }

    private final void zzk(boolean z) {
        if (this.zzbvx != null) {
            this.zzbvx.zzl(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0165  */
    @Override // com.google.android.gms.internal.zzrn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.zzakk r10, java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsa.zza(com.google.android.gms.internal.zzakk, java.util.Map):void");
    }
}

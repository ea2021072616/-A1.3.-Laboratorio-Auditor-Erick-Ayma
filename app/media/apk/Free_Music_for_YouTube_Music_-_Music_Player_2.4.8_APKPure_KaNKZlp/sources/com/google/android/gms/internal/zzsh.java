package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
final class zzsh implements zzrn {
    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        zzalc zzalcVar;
        if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzble)).booleanValue()) {
            zzalc zzsm = zzakkVar.zzsm();
            if (zzsm == null) {
                try {
                    zzalc zzalcVar2 = new zzalc(zzakkVar, Float.parseFloat(map.get("duration")), AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("customControlsAllowed")));
                    zzakkVar.zza(zzalcVar2);
                    zzalcVar = zzalcVar2;
                } catch (NullPointerException | NumberFormatException e) {
                    zzafx.zzb("Unable to parse videoMeta message.", e);
                    com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                }
            } else {
                zzalcVar = zzsm;
            }
            boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("muted"));
            float parseFloat = Float.parseFloat(map.get("currentTime"));
            int parseInt = Integer.parseInt(map.get("playbackState"));
            int i = (parseInt < 0 || 3 < parseInt) ? 0 : parseInt;
            String str = map.get("aspectRatio");
            float parseFloat2 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (zzafx.zzad(3)) {
                zzafx.zzcb(new StringBuilder(String.valueOf(str).length() + 79).append("Video Meta GMSG: isMuted : ").append(equals).append(" , playbackState : ").append(i).append(" , aspectRatio : ").append(str).toString());
            }
            zzalcVar.zza(parseFloat, i, equals, parseFloat2);
        }
    }
}

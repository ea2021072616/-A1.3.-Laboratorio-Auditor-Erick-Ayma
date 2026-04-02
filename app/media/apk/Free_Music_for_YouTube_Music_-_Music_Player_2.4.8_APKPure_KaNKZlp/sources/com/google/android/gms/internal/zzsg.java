package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzsg implements zzrn {
    private boolean zzbwc;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                zzjo.zzhu();
                return zzaje.zzc(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                zzafx.zzcs(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
                return i;
            }
        }
        return i;
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        int i;
        int i2;
        String[] split;
        String str = map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if (str == null) {
            zzafx.zzcs("Action missing from video GMSG.");
            return;
        }
        if (zzafx.zzad(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            zzafx.zzcb(new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length()).append("Video GMSG: ").append(str).append(" ").append(jSONObject2).toString());
        }
        if ("background".equals(str)) {
            String str2 = map.get(TtmlNode.ATTR_TTS_COLOR);
            if (TextUtils.isEmpty(str2)) {
                zzafx.zzcs("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzakkVar.setBackgroundColor(Color.parseColor(str2));
            } catch (IllegalArgumentException e) {
                zzafx.zzcs("Invalid color parameter in video GMSG.");
            }
        } else if ("decoderProps".equals(str)) {
            String str3 = map.get("mimeTypes");
            if (str3 == null) {
                zzafx.zzcs("No MIME types specified for decoder properties inspection.");
                com.google.android.gms.ads.internal.overlay.zzaa.zza(zzakkVar, "missingMimeTypes");
            } else if (Build.VERSION.SDK_INT < 16) {
                zzafx.zzcs("Video decoder properties available on API versions >= 16.");
                com.google.android.gms.ads.internal.overlay.zzaa.zza(zzakkVar, "deficientApiVersion");
            } else {
                HashMap hashMap = new HashMap();
                for (String str4 : str3.split(",")) {
                    hashMap.put(str4, zzajc.zzcp(str4.trim()));
                }
                com.google.android.gms.ads.internal.overlay.zzaa.zzc(zzakkVar, hashMap);
            }
        } else {
            zzakj zzsj = zzakkVar.zzsj();
            if (zzsj == null) {
                zzafx.zzcs("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzakkVar.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                int zza3 = zza(context, map, "w", -1);
                int zza4 = zza(context, map, "h", -1);
                if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbnc)).booleanValue()) {
                    i = Math.min(zza3, zzakkVar.getMeasuredWidth() - zza);
                    zza4 = Math.min(zza4, zzakkVar.getMeasuredHeight() - zza2);
                } else {
                    i = zza3;
                }
                try {
                    i2 = Integer.parseInt(map.get("player"));
                } catch (NumberFormatException e2) {
                    i2 = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean(map.get("spherical"));
                if (equals && zzsj.zzru() == null) {
                    zzsj.zza(zza, zza2, i, zza4, i2, parseBoolean, new com.google.android.gms.ads.internal.overlay.zzaq(map.get("flags")));
                    return;
                } else {
                    zzsj.zze(zza, zza2, i, zza4);
                    return;
                }
            }
            com.google.android.gms.ads.internal.overlay.zzaa zzru = zzsj.zzru();
            if (zzru == null) {
                com.google.android.gms.ads.internal.overlay.zzaa.zzh(zzakkVar);
            } else if ("click".equals(str)) {
                Context context2 = zzakkVar.getContext();
                int zza5 = zza(context2, map, "x", 0);
                int zza6 = zza(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, zza5, zza6, 0);
                zzru.zze(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                String str5 = map.get("time");
                if (str5 == null) {
                    zzafx.zzcs("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzru.seekTo((int) (Float.parseFloat(str5) * 1000.0f));
                } catch (NumberFormatException e3) {
                    String valueOf = String.valueOf(str5);
                    zzafx.zzcs(valueOf.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf) : new String("Could not parse time parameter from currentTime video GMSG: "));
                }
            } else if (MessengerShareContentUtility.SHARE_BUTTON_HIDE.equals(str)) {
                zzru.setVisibility(4);
            } else if ("load".equals(str)) {
                zzru.zznb();
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean(map.get("muted"))) {
                    zzru.zznc();
                } else {
                    zzru.zznd();
                }
            } else if ("pause".equals(str)) {
                zzru.pause();
            } else if ("play".equals(str)) {
                zzru.play();
            } else if ("show".equals(str)) {
                zzru.setVisibility(0);
            } else if ("src".equals(str)) {
                zzru.zzbq(map.get("src"));
            } else if ("touchMove".equals(str)) {
                Context context3 = zzakkVar.getContext();
                zzru.zza(zza(context3, map, "dx", 0), zza(context3, map, "dy", 0));
                if (this.zzbwc) {
                    return;
                }
                zzakkVar.zzrz().zzmt();
                this.zzbwc = true;
            } else if (!"volume".equals(str)) {
                if ("watermark".equals(str)) {
                    zzru.zzne();
                    return;
                }
                String valueOf2 = String.valueOf(str);
                zzafx.zzcs(valueOf2.length() != 0 ? "Unknown video action: ".concat(valueOf2) : new String("Unknown video action: "));
            } else {
                String str6 = map.get("volume");
                if (str6 == null) {
                    zzafx.zzcs("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzru.zzb(Float.parseFloat(str6));
                } catch (NumberFormatException e4) {
                    String valueOf3 = String.valueOf(str6);
                    zzafx.zzcs(valueOf3.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf3) : new String("Could not parse volume parameter from volume video GMSG: "));
                }
            }
        }
    }
}

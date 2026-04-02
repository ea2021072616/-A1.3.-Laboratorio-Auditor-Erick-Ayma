package com.google.android.gms.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzace {
    private zzaaq zzanv;
    private String zzbrs;
    private final zzaak zzccg;
    private List<String> zzclr;
    private String zzcss;
    private String zzcst;
    private List<String> zzcsu;
    private String zzcsv;
    private String zzcsw;
    private String zzcsx;
    private List<String> zzcsy;
    private zzaek zzctk;
    private List<String> zzctl;
    private List<String> zzctm;
    private String zzctp;
    private List<String> zzctq;
    private boolean zzctr;
    private String zzcts;
    private zzaes zzctt;
    private boolean zzctu;
    private long zzcsz = -1;
    private boolean zzcta = false;
    private final long zzctb = -1;
    private long zzctc = -1;
    private int mOrientation = -1;
    private boolean zzctd = false;
    private boolean zzcte = false;
    private boolean zzctf = false;
    private boolean zzctg = true;
    private boolean zzcth = true;
    private String zzcti = "";
    private boolean zzctj = false;
    private boolean zzcbs = false;
    private boolean zzctn = false;
    private boolean zzcto = false;

    public zzace(zzaak zzaakVar, String str) {
        this.zzcst = str;
        this.zzccg = zzaakVar;
    }

    private static String zza(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static long zzb(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list != null && !list.isEmpty()) {
            String str2 = list.get(0);
            try {
                return Float.parseFloat(str2) * 1000.0f;
            } catch (NumberFormatException e) {
                zzafx.zzcs(new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length()).append("Could not parse float from ").append(str).append(" header: ").append(str2).toString());
            }
        }
        return -1L;
    }

    private static List<String> zzc(Map<String, List<String>> map, String str) {
        String str2;
        List<String> list = map.get(str);
        if (list == null || list.isEmpty() || (str2 = list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    private static boolean zzd(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf(list.get(0)).booleanValue()) ? false : true;
    }

    public final void zza(String str, Map<String, List<String>> map, String str2) {
        this.zzbrs = str2;
        zzi(map);
    }

    public final zzaao zze(long j) {
        return new zzaao(this.zzccg, this.zzcst, this.zzbrs, this.zzcsu, this.zzcsy, this.zzcsz, this.zzcta, -1L, this.zzclr, this.zzctc, this.mOrientation, this.zzcss, j, this.zzcsw, this.zzcsx, this.zzctd, this.zzcte, this.zzctf, this.zzctg, false, this.zzcti, this.zzctj, this.zzcbs, this.zzctk, this.zzctl, this.zzctm, this.zzctn, this.zzanv, this.zzcto, this.zzctp, this.zzctq, this.zzctr, this.zzcts, this.zzctt, this.zzcsv, this.zzcth, this.zzctu);
    }

    public final void zzi(Map<String, List<String>> map) {
        this.zzcss = zza(map, "X-Afma-Ad-Size");
        this.zzcts = zza(map, "X-Afma-Ad-Slot-Size");
        List<String> zzc = zzc(map, "X-Afma-Click-Tracking-Urls");
        if (zzc != null) {
            this.zzcsu = zzc;
        }
        this.zzcsv = zza(map, "X-Afma-Debug-Signals");
        List<String> list = map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.zzcsw = list.get(0);
        }
        List<String> zzc2 = zzc(map, "X-Afma-Tracking-Urls");
        if (zzc2 != null) {
            this.zzcsy = zzc2;
        }
        long zzb = zzb(map, "X-Afma-Interstitial-Timeout");
        if (zzb != -1) {
            this.zzcsz = zzb;
        }
        this.zzcta |= zzd(map, "X-Afma-Mediation");
        List<String> zzc3 = zzc(map, "X-Afma-Manual-Tracking-Urls");
        if (zzc3 != null) {
            this.zzclr = zzc3;
        }
        long zzb2 = zzb(map, "X-Afma-Refresh-Rate");
        if (zzb2 != -1) {
            this.zzctc = zzb2;
        }
        List<String> list2 = map.get("X-Afma-Orientation");
        if (list2 != null && !list2.isEmpty()) {
            String str = list2.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = com.google.android.gms.ads.internal.zzbv.zzec().zzqz();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = com.google.android.gms.ads.internal.zzbv.zzec().zzqy();
            }
        }
        this.zzcsx = zza(map, "X-Afma-ActiveView");
        List<String> list3 = map.get("X-Afma-Use-HTTPS");
        if (list3 != null && !list3.isEmpty()) {
            this.zzctf = Boolean.valueOf(list3.get(0)).booleanValue();
        }
        this.zzctd |= zzd(map, "X-Afma-Custom-Rendering-Allowed");
        this.zzcte = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(zza(map, "X-Afma-Ad-Format"));
        List<String> list4 = map.get("X-Afma-Content-Url-Opted-Out");
        if (list4 != null && !list4.isEmpty()) {
            this.zzctg = Boolean.valueOf(list4.get(0)).booleanValue();
        }
        List<String> list5 = map.get("X-Afma-Content-Vertical-Opted-Out");
        if (list5 != null && !list5.isEmpty()) {
            this.zzcth = Boolean.valueOf(list5.get(0)).booleanValue();
        }
        List<String> list6 = map.get("X-Afma-Gws-Query-Id");
        if (list6 != null && !list6.isEmpty()) {
            this.zzcti = list6.get(0);
        }
        String zza = zza(map, "X-Afma-Fluid");
        if (zza != null && zza.equals("height")) {
            this.zzctj = true;
        }
        this.zzcbs = "native_express".equals(zza(map, "X-Afma-Ad-Format"));
        this.zzctk = zzaek.zzby(zza(map, "X-Afma-Rewards"));
        if (this.zzctl == null) {
            this.zzctl = zzc(map, "X-Afma-Reward-Video-Start-Urls");
        }
        if (this.zzctm == null) {
            this.zzctm = zzc(map, "X-Afma-Reward-Video-Complete-Urls");
        }
        this.zzctn |= zzd(map, "X-Afma-Use-Displayed-Impression");
        this.zzcto |= zzd(map, "X-Afma-Auto-Collect-Location");
        this.zzctp = zza(map, "Set-Cookie");
        String zza2 = zza(map, "X-Afma-Auto-Protection-Configuration");
        if (zza2 == null || TextUtils.isEmpty(zza2)) {
            Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.zzcsw)) {
                buildUpon.appendQueryParameter("debugDialog", this.zzcsw);
            }
            boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbgd)).booleanValue();
            String builder = buildUpon.toString();
            this.zzanv = new zzaaq(booleanValue, Arrays.asList(new StringBuilder(String.valueOf(builder).length() + 18 + String.valueOf("navigationURL").length()).append(builder).append("&").append("navigationURL").append("={NAVIGATION_URL}").toString()));
        } else {
            try {
                this.zzanv = zzaaq.zze(new JSONObject(zza2));
            } catch (JSONException e) {
                zzafx.zzc("Error parsing configuration JSON", e);
                this.zzanv = new zzaaq();
            }
        }
        List<String> zzc4 = zzc(map, "X-Afma-Remote-Ping-Urls");
        if (zzc4 != null) {
            this.zzctq = zzc4;
        }
        String zza3 = zza(map, "X-Afma-Safe-Browsing");
        if (!TextUtils.isEmpty(zza3)) {
            try {
                this.zzctt = zzaes.zzf(new JSONObject(zza3));
            } catch (JSONException e2) {
                zzafx.zzc("Error parsing safe browsing header", e2);
            }
        }
        this.zzctr |= zzd(map, "X-Afma-Render-In-Browser");
        String zza4 = zza(map, "X-Afma-Pool");
        if (TextUtils.isEmpty(zza4)) {
            return;
        }
        try {
            this.zzctu = new JSONObject(zza4).getBoolean("never_pool");
        } catch (JSONException e3) {
            zzafx.zzc("Error parsing interstitial pool header", e3);
        }
    }
}

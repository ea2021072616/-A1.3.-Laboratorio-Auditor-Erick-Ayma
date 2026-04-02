package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@zzzt
/* loaded from: classes.dex */
public final class zzabz {
    private static final SimpleDateFormat zzcsk = new SimpleDateFormat("yyyyMMdd", Locale.US);

    /* JADX WARN: Removed duplicated region for block: B:59:0x0154 A[Catch: JSONException -> 0x024c, TryCatch #0 {JSONException -> 0x024c, blocks: (B:2:0x0000, B:4:0x0030, B:7:0x0038, B:9:0x0043, B:11:0x004e, B:13:0x0059, B:15:0x0063, B:16:0x0067, B:18:0x0085, B:19:0x0094, B:21:0x00a7, B:22:0x00af, B:24:0x00b6, B:26:0x00bc, B:28:0x00d8, B:35:0x00f7, B:39:0x0104, B:40:0x0108, B:44:0x0115, B:45:0x0119, B:49:0x0126, B:51:0x012c, B:53:0x0131, B:54:0x0135, B:56:0x013d, B:57:0x013f, B:59:0x0154, B:60:0x015d, B:69:0x0274, B:68:0x0270, B:67:0x026c, B:32:0x00e6, B:34:0x00ee), top: B:74:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.zzaao zza(android.content.Context r48, com.google.android.gms.internal.zzaak r49, java.lang.String r50) {
        /*
            Method dump skipped, instructions count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzabz.zza(android.content.Context, com.google.android.gms.internal.zzaak, java.lang.String):com.google.android.gms.internal.zzaao");
    }

    @Nullable
    private static List<String> zza(@Nullable JSONArray jSONArray, @Nullable List<String> list) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList<>();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    @Nullable
    public static JSONObject zza(Context context, zzabq zzabqVar) {
        zzjb[] zzjbVarArr;
        String str;
        zzjb[] zzjbVarArr2;
        zzaak zzaakVar = zzabqVar.zzcrj;
        Location location = zzabqVar.zzbbt;
        zzach zzachVar = zzabqVar.zzcrk;
        Bundle bundle = zzabqVar.zzcod;
        JSONObject jSONObject = zzabqVar.zzcrl;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("extra_caps", com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmm));
            if (zzabqVar.zzcok.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", zzabqVar.zzcok));
            }
            if (zzaakVar.zzcnv != null) {
                hashMap.put("ad_pos", zzaakVar.zzcnv);
            }
            zzix zzixVar = zzaakVar.zzcnw;
            String zzqp = zzafu.zzqp();
            if (zzqp != null) {
                hashMap.put("abf", zzqp);
            }
            if (zzixVar.zzbbl != -1) {
                hashMap.put("cust_age", zzcsk.format(new Date(zzixVar.zzbbl)));
            }
            if (zzixVar.extras != null) {
                hashMap.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, zzixVar.extras);
            }
            if (zzixVar.zzbbm != -1) {
                hashMap.put("cust_gender", Integer.valueOf(zzixVar.zzbbm));
            }
            if (zzixVar.zzbbn != null) {
                hashMap.put("kw", zzixVar.zzbbn);
            }
            if (zzixVar.zzbbp != -1) {
                hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(zzixVar.zzbbp));
            }
            if (zzixVar.zzbbo) {
                hashMap.put("adtest", "on");
            }
            if (zzixVar.versionCode >= 2) {
                if (zzixVar.zzbbq) {
                    hashMap.put("d_imp_hdr", 1);
                }
                if (!TextUtils.isEmpty(zzixVar.zzbbr)) {
                    hashMap.put("ppid", zzixVar.zzbbr);
                }
            }
            if (zzixVar.versionCode >= 3 && zzixVar.zzbbu != null) {
                hashMap.put("url", zzixVar.zzbbu);
            }
            if (zzixVar.versionCode >= 5) {
                if (zzixVar.zzbbw != null) {
                    hashMap.put("custom_targeting", zzixVar.zzbbw);
                }
                if (zzixVar.zzbbx != null) {
                    hashMap.put("category_exclusions", zzixVar.zzbbx);
                }
                if (zzixVar.zzbby != null) {
                    hashMap.put("request_agent", zzixVar.zzbby);
                }
            }
            if (zzixVar.versionCode >= 6 && zzixVar.zzbbz != null) {
                hashMap.put("request_pkg", zzixVar.zzbbz);
            }
            if (zzixVar.versionCode >= 7) {
                hashMap.put("is_designed_for_families", Boolean.valueOf(zzixVar.zzbca));
            }
            if (zzaakVar.zzatn.zzbcs != null) {
                boolean z = false;
                boolean z2 = false;
                for (zzjb zzjbVar : zzaakVar.zzatn.zzbcs) {
                    if (!zzjbVar.zzbcu && !z2) {
                        hashMap.put(IjkMediaMeta.IJKM_KEY_FORMAT, zzjbVar.zzbcq);
                        z2 = true;
                    }
                    if (zzjbVar.zzbcu && !z) {
                        hashMap.put("fluid", "height");
                        z = true;
                    }
                    if (z2 && z) {
                        break;
                    }
                }
            } else {
                hashMap.put(IjkMediaMeta.IJKM_KEY_FORMAT, zzaakVar.zzatn.zzbcq);
                if (zzaakVar.zzatn.zzbcu) {
                    hashMap.put("fluid", "height");
                }
            }
            if (zzaakVar.zzatn.width == -1) {
                hashMap.put("smart_w", MessengerShareContentUtility.WEBVIEW_RATIO_FULL);
            }
            if (zzaakVar.zzatn.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (zzaakVar.zzatn.zzbcs != null) {
                StringBuilder sb = new StringBuilder();
                boolean z3 = false;
                for (zzjb zzjbVar2 : zzaakVar.zzatn.zzbcs) {
                    if (zzjbVar2.zzbcu) {
                        z3 = true;
                    } else {
                        if (sb.length() != 0) {
                            sb.append("|");
                        }
                        sb.append(zzjbVar2.width == -1 ? (int) (zzjbVar2.widthPixels / zzachVar.zzaxh) : zzjbVar2.width);
                        sb.append("x");
                        sb.append(zzjbVar2.height == -2 ? (int) (zzjbVar2.heightPixels / zzachVar.zzaxh) : zzjbVar2.height);
                    }
                }
                if (z3) {
                    if (sb.length() != 0) {
                        sb.insert(0, "|");
                    }
                    sb.insert(0, "320x50");
                }
                hashMap.put("sz", sb);
            }
            if (zzaakVar.zzcoc != 0) {
                hashMap.put("native_version", Integer.valueOf(zzaakVar.zzcoc));
                hashMap.put("native_templates", zzaakVar.zzaug);
                zzot zzotVar = zzaakVar.zzatz;
                switch (zzotVar != null ? zzotVar.zzbtd : 0) {
                    case 0:
                        str = "any";
                        break;
                    case 1:
                        str = "portrait";
                        break;
                    case 2:
                        str = "landscape";
                        break;
                    default:
                        str = "not_set";
                        break;
                }
                hashMap.put("native_image_orientation", str);
                if (!zzaakVar.zzcol.isEmpty()) {
                    hashMap.put("native_custom_templates", zzaakVar.zzcol);
                }
                if (zzaakVar.versionCode >= 24) {
                    hashMap.put("max_num_ads", Integer.valueOf(zzaakVar.zzcph));
                }
                if (!TextUtils.isEmpty(zzaakVar.zzcpf)) {
                    try {
                        hashMap.put("native_advanced_settings", new JSONArray(zzaakVar.zzcpf));
                    } catch (JSONException e) {
                        zzafx.zzc("Problem creating json from native advanced settings", e);
                    }
                }
            }
            if (zzaakVar.zzaud != null && zzaakVar.zzaud.size() > 0) {
                for (Integer num : zzaakVar.zzaud) {
                    if (num.intValue() == 2) {
                        hashMap.put("iba", true);
                    } else if (num.intValue() == 1) {
                        hashMap.put("ina", true);
                    }
                }
            }
            if (zzaakVar.zzatn.zzbcv) {
                hashMap.put("ene", true);
            }
            if (zzaakVar.zzaub != null) {
                hashMap.put("is_icon_ad", true);
                hashMap.put("icon_ad_expansion_behavior", Integer.valueOf(zzaakVar.zzaub.zzbdp));
            }
            hashMap.put("slotname", zzaakVar.zzath);
            hashMap.put("pn", zzaakVar.applicationInfo.packageName);
            if (zzaakVar.zzcnx != null) {
                hashMap.put("vc", Integer.valueOf(zzaakVar.zzcnx.versionCode));
            }
            hashMap.put("ms", zzabqVar.zzcny);
            hashMap.put("seq_num", zzaakVar.zzcnz);
            hashMap.put("session_id", zzaakVar.zzcoa);
            hashMap.put("js", zzaakVar.zzatj.zzcp);
            zzact zzactVar = zzabqVar.zzcrh;
            Bundle bundle2 = zzaakVar.zzcox;
            Bundle bundle3 = zzabqVar.zzcrg;
            hashMap.put("am", Integer.valueOf(zzachVar.zzcue));
            hashMap.put("cog", zzu(zzachVar.zzcuf));
            hashMap.put("coh", zzu(zzachVar.zzcug));
            if (!TextUtils.isEmpty(zzachVar.zzcuh)) {
                hashMap.put("carrier", zzachVar.zzcuh);
            }
            hashMap.put("gl", zzachVar.zzcui);
            if (zzachVar.zzcuj) {
                hashMap.put("simulator", 1);
            }
            if (zzachVar.zzcuk) {
                hashMap.put("is_sidewinder", 1);
            }
            hashMap.put("ma", zzu(zzachVar.zzcul));
            hashMap.put("sp", zzu(zzachVar.zzcum));
            hashMap.put("hl", zzachVar.zzcun);
            if (!TextUtils.isEmpty(zzachVar.zzcuo)) {
                hashMap.put("mv", zzachVar.zzcuo);
            }
            hashMap.put("muv", Integer.valueOf(zzachVar.zzcuq));
            if (zzachVar.zzcur != -2) {
                hashMap.put("cnt", Integer.valueOf(zzachVar.zzcur));
            }
            hashMap.put("gnt", Integer.valueOf(zzachVar.zzcus));
            hashMap.put("pt", Integer.valueOf(zzachVar.zzcut));
            hashMap.put("rm", Integer.valueOf(zzachVar.zzcuu));
            hashMap.put("riv", Integer.valueOf(zzachVar.zzcuv));
            Bundle bundle4 = new Bundle();
            bundle4.putString("build_build", zzachVar.zzcva);
            bundle4.putString("build_device", zzachVar.zzcvb);
            Bundle bundle5 = new Bundle();
            bundle5.putBoolean("is_charging", zzachVar.zzcux);
            bundle5.putDouble("battery_level", zzachVar.zzcuw);
            bundle4.putBundle("battery", bundle5);
            Bundle bundle6 = new Bundle();
            bundle6.putInt("active_network_state", zzachVar.zzcuz);
            bundle6.putBoolean("active_network_metered", zzachVar.zzcuy);
            if (zzactVar != null) {
                Bundle bundle7 = new Bundle();
                bundle7.putInt("predicted_latency_micros", zzactVar.zzcvm);
                bundle7.putLong("predicted_down_throughput_bps", zzactVar.zzcvn);
                bundle7.putLong("predicted_up_throughput_bps", zzactVar.zzcvo);
                bundle6.putBundle("predictions", bundle7);
            }
            bundle4.putBundle("network", bundle6);
            Bundle bundle8 = new Bundle();
            bundle8.putBoolean("is_browser_custom_tabs_capable", zzachVar.zzcvc);
            bundle4.putBundle("browser", bundle8);
            if (bundle2 != null) {
                Bundle bundle9 = new Bundle();
                bundle9.putString("runtime_free", Long.toString(bundle2.getLong("runtime_free_memory", -1L)));
                bundle9.putString("runtime_max", Long.toString(bundle2.getLong("runtime_max_memory", -1L)));
                bundle9.putString("runtime_total", Long.toString(bundle2.getLong("runtime_total_memory", -1L)));
                bundle9.putString("web_view_count", Integer.toString(bundle2.getInt("web_view_count", 0)));
                Debug.MemoryInfo memoryInfo = (Debug.MemoryInfo) bundle2.getParcelable("debug_memory_info");
                if (memoryInfo != null) {
                    bundle9.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
                    bundle9.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
                    bundle9.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
                    bundle9.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
                    bundle9.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
                    bundle9.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
                    bundle9.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
                    bundle9.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
                    bundle9.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
                }
                bundle4.putBundle("android_mem_info", bundle9);
            }
            Bundle bundle10 = new Bundle();
            bundle10.putBundle("parental_controls", bundle3);
            if (!TextUtils.isEmpty(zzachVar.zzcup)) {
                bundle10.putString("package_version", zzachVar.zzcup);
            }
            bundle4.putBundle("play_store", bundle10);
            hashMap.put("device", bundle4);
            Bundle bundle11 = new Bundle();
            bundle11.putString("doritos", zzabqVar.zzcri);
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjo)).booleanValue()) {
                String str2 = null;
                boolean z4 = false;
                if (zzabqVar.zzahj != null) {
                    str2 = zzabqVar.zzahj.getId();
                    z4 = zzabqVar.zzahj.isLimitAdTrackingEnabled();
                }
                if (TextUtils.isEmpty(str2)) {
                    zzjo.zzhu();
                    bundle11.putString("pdid", zzaje.zzaz(context));
                    bundle11.putString("pdidtype", "ssaid");
                } else {
                    bundle11.putString("rdid", str2);
                    bundle11.putBoolean("is_lat", z4);
                    bundle11.putString("idtype", "adid");
                }
            }
            hashMap.put("pii", bundle11);
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (location != null) {
                zza(hashMap, location);
            } else if (zzaakVar.zzcnw.versionCode >= 2 && zzaakVar.zzcnw.zzbbt != null) {
                zza(hashMap, zzaakVar.zzcnw.zzbbt);
            }
            if (zzaakVar.versionCode >= 2) {
                hashMap.put("quality_signals", zzaakVar.zzcob);
            }
            if (zzaakVar.versionCode >= 4 && zzaakVar.zzcoe) {
                hashMap.put("forceHttps", Boolean.valueOf(zzaakVar.zzcoe));
            }
            if (bundle != null) {
                hashMap.put("content_info", bundle);
            }
            if (zzaakVar.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(zzaakVar.zzaxh));
                hashMap.put("sh", Integer.valueOf(zzaakVar.zzcog));
                hashMap.put("sw", Integer.valueOf(zzaakVar.zzcof));
            } else {
                hashMap.put("u_sd", Float.valueOf(zzachVar.zzaxh));
                hashMap.put("sh", Integer.valueOf(zzachVar.zzcog));
                hashMap.put("sw", Integer.valueOf(zzachVar.zzcof));
            }
            if (zzaakVar.versionCode >= 6) {
                if (!TextUtils.isEmpty(zzaakVar.zzcoh)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(zzaakVar.zzcoh));
                    } catch (JSONException e2) {
                        zzafx.zzc("Problem serializing view hierarchy to JSON", e2);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(zzaakVar.zzcoi));
            }
            if (zzaakVar.versionCode >= 7) {
                hashMap.put("request_id", zzaakVar.zzcoj);
            }
            if (zzaakVar.versionCode >= 12 && !TextUtils.isEmpty(zzaakVar.zzcon)) {
                hashMap.put("anchor", zzaakVar.zzcon);
            }
            if (zzaakVar.versionCode >= 13) {
                hashMap.put("android_app_volume", Float.valueOf(zzaakVar.zzcoo));
            }
            if (zzaakVar.versionCode >= 18) {
                hashMap.put("android_app_muted", Boolean.valueOf(zzaakVar.zzcou));
            }
            if (zzaakVar.versionCode >= 14 && zzaakVar.zzcop > 0) {
                hashMap.put("target_api", Integer.valueOf(zzaakVar.zzcop));
            }
            if (zzaakVar.versionCode >= 15) {
                hashMap.put("scroll_index", Integer.valueOf(zzaakVar.zzcoq == -1 ? -1 : zzaakVar.zzcoq));
            }
            if (zzaakVar.versionCode >= 16) {
                hashMap.put("_activity_context", Boolean.valueOf(zzaakVar.zzcor));
            }
            if (zzaakVar.versionCode >= 18) {
                if (!TextUtils.isEmpty(zzaakVar.zzcov)) {
                    try {
                        hashMap.put("app_settings", new JSONObject(zzaakVar.zzcov));
                    } catch (JSONException e3) {
                        zzafx.zzc("Problem creating json from app settings", e3);
                    }
                }
                hashMap.put("render_in_browser", Boolean.valueOf(zzaakVar.zzcay));
            }
            if (zzaakVar.versionCode >= 18) {
                hashMap.put("android_num_video_cache_tasks", Integer.valueOf(zzaakVar.zzcow));
            }
            zzajk zzajkVar = zzaakVar.zzatj;
            boolean z5 = zzaakVar.zzcpi;
            boolean z6 = zzabqVar.zzcrm;
            Bundle bundle12 = new Bundle();
            Bundle bundle13 = new Bundle();
            bundle13.putString("cl", "164654066");
            bundle13.putString("rapid_rc", "dev");
            bundle13.putString("rapid_rollup", "HEAD");
            bundle12.putBundle("build_meta", bundle13);
            bundle12.putString("mf", Boolean.toString(((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbmo)).booleanValue()));
            bundle12.putBoolean("instant_app", z5);
            bundle12.putBoolean("lite", zzajkVar.zzdeo);
            bundle12.putBoolean("local_service", z6);
            hashMap.put("sdk_env", bundle12);
            hashMap.put("cache_state", jSONObject);
            if (zzaakVar.versionCode >= 19) {
                hashMap.put("gct", zzaakVar.zzcoy);
            }
            if (zzaakVar.versionCode >= 21 && zzaakVar.zzcoz) {
                hashMap.put("de", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            if (((Boolean) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbka)).booleanValue()) {
                String str3 = zzaakVar.zzatn.zzbcq;
                boolean z7 = str3.equals("interstitial_mb") || str3.equals("reward_mb");
                Bundle bundle14 = zzaakVar.zzcpa;
                boolean z8 = bundle14 != null;
                if (z7 && z8) {
                    Bundle bundle15 = new Bundle();
                    bundle15.putBundle("interstitial_pool", bundle14);
                    hashMap.put("counters", bundle15);
                }
            }
            if (zzaakVar.versionCode >= 22 && com.google.android.gms.ads.internal.zzbv.zzez().zzr(context)) {
                hashMap.put("gmp_app_id", zzaakVar.zzcpb);
                if ("TIME_OUT".equals(zzaakVar.zzcpc)) {
                    hashMap.put("sai_timeout", com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbjd));
                } else if (zzaakVar.zzcpc == null) {
                    hashMap.put("fbs_aiid", "");
                } else {
                    hashMap.put("fbs_aiid", zzaakVar.zzcpc);
                }
                hashMap.put("fbs_aeid", zzaakVar.zzcpd);
            }
            if (zzaakVar.versionCode >= 24) {
                hashMap.put("disable_ml", Boolean.valueOf(zzaakVar.zzcpj));
            }
            String str4 = (String) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhc);
            if (str4 != null && !str4.isEmpty()) {
                if (Build.VERSION.SDK_INT >= ((Integer) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbhd)).intValue()) {
                    HashMap hashMap2 = new HashMap();
                    String[] split = str4.split(",");
                    for (String str5 : split) {
                        hashMap2.put(str5, zzajc.zzcp(str5));
                    }
                    hashMap.put("video_decoders", hashMap2);
                }
            }
            if (zzafx.zzad(2)) {
                String valueOf = String.valueOf(com.google.android.gms.ads.internal.zzbv.zzea().zzk(hashMap).toString(2));
                zzafx.v(valueOf.length() != 0 ? "Ad Request JSON: ".concat(valueOf) : new String("Ad Request JSON: "));
            }
            return com.google.android.gms.ads.internal.zzbv.zzea().zzk(hashMap);
        } catch (JSONException e4) {
            String valueOf2 = String.valueOf(e4.getMessage());
            zzafx.zzcs(valueOf2.length() != 0 ? "Problem serializing ad request to JSON: ".concat(valueOf2) : new String("Problem serializing ad request to JSON: "));
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    public static JSONObject zzb(zzaao zzaaoVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (zzaaoVar.zzchb != null) {
            jSONObject.put("ad_base_url", zzaaoVar.zzchb);
        }
        if (zzaaoVar.zzcpr != null) {
            jSONObject.put("ad_size", zzaaoVar.zzcpr);
        }
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, zzaaoVar.zzbct);
        if (zzaaoVar.zzbct) {
            jSONObject.put("ad_json", zzaaoVar.body);
        } else {
            jSONObject.put("ad_html", zzaaoVar.body);
        }
        if (zzaaoVar.zzcpt != null) {
            jSONObject.put("debug_dialog", zzaaoVar.zzcpt);
        }
        if (zzaaoVar.zzcqk != null) {
            jSONObject.put("debug_signals", zzaaoVar.zzcqk);
        }
        if (zzaaoVar.zzcpn != -1) {
            jSONObject.put("interstitial_timeout", zzaaoVar.zzcpn / 1000.0d);
        }
        if (zzaaoVar.orientation == com.google.android.gms.ads.internal.zzbv.zzec().zzqz()) {
            jSONObject.put("orientation", "portrait");
        } else if (zzaaoVar.orientation == com.google.android.gms.ads.internal.zzbv.zzec().zzqy()) {
            jSONObject.put("orientation", "landscape");
        }
        if (zzaaoVar.zzcau != null) {
            jSONObject.put("click_urls", zzn(zzaaoVar.zzcau));
        }
        if (zzaaoVar.zzcav != null) {
            jSONObject.put("impression_urls", zzn(zzaaoVar.zzcav));
        }
        if (zzaaoVar.zzcpq != null) {
            jSONObject.put("manual_impression_urls", zzn(zzaaoVar.zzcpq));
        }
        if (zzaaoVar.zzcpw != null) {
            jSONObject.put("active_view", zzaaoVar.zzcpw);
        }
        jSONObject.put("ad_is_javascript", zzaaoVar.zzcpu);
        if (zzaaoVar.zzcpv != null) {
            jSONObject.put("ad_passback_url", zzaaoVar.zzcpv);
        }
        jSONObject.put("mediation", zzaaoVar.zzcpo);
        jSONObject.put("custom_render_allowed", zzaaoVar.zzcpx);
        jSONObject.put("content_url_opted_out", zzaaoVar.zzcpy);
        jSONObject.put("content_vertical_opted_out", zzaaoVar.zzcql);
        jSONObject.put("prefetch", zzaaoVar.zzcpz);
        if (zzaaoVar.zzcba != -1) {
            jSONObject.put("refresh_interval_milliseconds", zzaaoVar.zzcba);
        }
        if (zzaaoVar.zzcpp != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", zzaaoVar.zzcpp);
        }
        if (!TextUtils.isEmpty(zzaaoVar.zzcqc)) {
            jSONObject.put("gws_query_id", zzaaoVar.zzcqc);
        }
        jSONObject.put("fluid", zzaaoVar.zzbcu ? "height" : "");
        jSONObject.put("native_express", zzaaoVar.zzbcv);
        if (zzaaoVar.zzcqe != null) {
            jSONObject.put("video_start_urls", zzn(zzaaoVar.zzcqe));
        }
        if (zzaaoVar.zzcqf != null) {
            jSONObject.put("video_complete_urls", zzn(zzaaoVar.zzcqf));
        }
        if (zzaaoVar.zzcqd != null) {
            zzaek zzaekVar = zzaaoVar.zzcqd;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rb_type", zzaekVar.type);
            jSONObject2.put("rb_amount", zzaekVar.zzcww);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("rewards", jSONArray);
        }
        jSONObject.put("use_displayed_impression", zzaaoVar.zzcqg);
        jSONObject.put("auto_protection_configuration", zzaaoVar.zzcqh);
        jSONObject.put("render_in_browser", zzaaoVar.zzcay);
        return jSONObject;
    }

    @Nullable
    private static JSONArray zzn(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    private static Integer zzu(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}

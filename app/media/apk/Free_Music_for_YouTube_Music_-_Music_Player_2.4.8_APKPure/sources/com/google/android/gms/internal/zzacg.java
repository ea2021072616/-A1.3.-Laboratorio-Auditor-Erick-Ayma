package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzacg {
    private int mErrorCode;
    private String zzad;
    private final String zzcjq;
    private final List<String> zzctv;
    private final List<String> zzctw;
    private final String zzctx;
    private final String zzcty;
    private final String zzctz;
    private final String zzcua;
    private final boolean zzcub;
    private final boolean zzcuc;
    private final String zzcud;

    public zzacg(int i, Map<String, String> map) {
        this.zzad = map.get("url");
        this.zzcty = map.get("base_uri");
        this.zzctz = map.get("post_parameters");
        this.zzcub = parseBoolean(map.get("drt_include"));
        this.zzcuc = parseBoolean(map.get("pan_include"));
        this.zzctx = map.get("activation_overlay_url");
        this.zzctw = zzbt(map.get("check_packages"));
        this.zzcjq = map.get("request_id");
        this.zzcua = map.get("type");
        this.zzctv = zzbt(map.get("errors"));
        this.mErrorCode = i;
        this.zzcud = map.get("fetched_ad");
    }

    private static boolean parseBoolean(String str) {
        return str != null && (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) || str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    }

    private static List<String> zzbt(String str) {
        if (str == null) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }

    public final String getRequestId() {
        return this.zzcjq;
    }

    public final String getType() {
        return this.zzcua;
    }

    public final String getUrl() {
        return this.zzad;
    }

    public final void setUrl(String str) {
        this.zzad = str;
    }

    public final List<String> zzok() {
        return this.zzctv;
    }

    public final String zzol() {
        return this.zzcty;
    }

    public final String zzom() {
        return this.zzctz;
    }

    public final boolean zzon() {
        return this.zzcub;
    }

    public final String zzoo() {
        return this.zzcud;
    }
}

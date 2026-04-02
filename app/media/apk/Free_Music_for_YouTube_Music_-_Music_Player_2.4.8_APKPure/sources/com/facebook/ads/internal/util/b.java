package com.facebook.ads.internal.util;

import android.support.annotation.Nullable;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.share.internal.ShareConstants;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f1510a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f1511b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f1512c;
    private int d;
    private String e;

    /* loaded from: classes.dex */
    public enum a {
        OPEN_STORE(0),
        OPEN_LINK(1),
        XOUT(2),
        OPEN_URL(3),
        SHOW_INTERSTITIAL(4);
        
        int f;

        a(int i) {
            this.f = i;
        }
    }

    /* renamed from: com.facebook.ads.internal.util.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0041b {
        LOADING_AD(0);
        

        /* renamed from: b  reason: collision with root package name */
        int f1518b;

        EnumC0041b(int i) {
            this.f1518b = i;
        }
    }

    public b(String str, Map<String, Object> map, int i, String str2) {
        this.f1511b = str;
        this.f1512c = map;
        this.d = i;
        this.e = str2;
    }

    public static b a(long j, a aVar, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("Time", String.valueOf(currentTimeMillis - j));
        hashMap.put("AdAction", String.valueOf(aVar.f));
        return new b("bounceback", hashMap, (int) (currentTimeMillis / 1000), str);
    }

    public static b a(EnumC0041b enumC0041b, AdPlacementType adPlacementType, long j, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("LatencyType", String.valueOf(enumC0041b.f1518b));
        hashMap.put("AdPlacementType", adPlacementType.toString());
        hashMap.put("Time", String.valueOf(j));
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str == null) {
            str = f1510a;
        }
        return new b("latency", hashMap, currentTimeMillis, str);
    }

    public static b a(@Nullable Throwable th, @Nullable String str) {
        HashMap hashMap = new HashMap();
        if (th != null) {
            hashMap.put("ex", th.getClass().getSimpleName());
            hashMap.put("ex_msg", th.getMessage());
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str == null) {
            str = f1510a;
        }
        return new b("error", hashMap, currentTimeMillis, str);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f1511b);
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_DATA, new JSONObject(this.f1512c));
            jSONObject.put("time", this.d);
            jSONObject.put("request_id", this.e);
        } catch (JSONException e) {
            ThrowableExtension.printStackTrace(e);
        }
        return jSONObject;
    }
}

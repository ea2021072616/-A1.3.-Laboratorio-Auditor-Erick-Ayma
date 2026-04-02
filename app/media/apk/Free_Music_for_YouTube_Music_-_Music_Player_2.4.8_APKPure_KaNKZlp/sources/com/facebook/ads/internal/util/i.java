package com.facebook.ads.internal.util;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final String f1533a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1534b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1535c;
    private final List<String> d;
    private final String e;
    private final String f;

    private i(String str, String str2, String str3, List<String> list, String str4, String str5) {
        this.f1533a = str;
        this.f1534b = str2;
        this.f1535c = str3;
        this.d = list;
        this.e = str4;
        this.f = str5;
    }

    public static i a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("package");
        String optString2 = jSONObject.optString("appsite");
        String optString3 = jSONObject.optString("appsite_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("key_hashes");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
        }
        return new i(optString, optString2, optString3, arrayList, jSONObject.optString("market_uri"), jSONObject.optString(MessengerShareContentUtility.FALLBACK_URL));
    }

    public String a() {
        return this.f1533a;
    }

    public String b() {
        return this.f1534b;
    }

    public String c() {
        return this.f1535c;
    }
}

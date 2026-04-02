package com.flurry.sdk;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public class iz implements lg<hz> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1919a = iz.class.getSimpleName();

    @Override // com.flurry.sdk.lg
    public final /* synthetic */ hz a(InputStream inputStream) throws IOException {
        return b(inputStream);
    }

    private static hz b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        String str = new String(ly.a(inputStream));
        km.a(5, f1919a, "Proton response string: " + str);
        hz hzVar = new hz();
        try {
            JSONObject jSONObject = new JSONObject(str);
            hzVar.f1821a = jSONObject.optLong("issued_at", -1L);
            hzVar.f1822b = jSONObject.optLong("refresh_ttl", 3600L);
            hzVar.f1823c = jSONObject.optLong("expiration_ttl", 86400L);
            JSONObject optJSONObject = jSONObject.optJSONObject("global_settings");
            hzVar.d = new ig();
            if (optJSONObject != null) {
                hzVar.d.f1834a = a(optJSONObject.optString("log_level"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("pulse");
            hx hxVar = new hx();
            if (optJSONObject2 != null) {
                a(hxVar, optJSONObject2.optJSONArray("callbacks"));
                hxVar.f1816b = optJSONObject2.optInt("max_callback_retries", 3);
                hxVar.f1817c = optJSONObject2.optInt("max_callback_attempts_per_report", 15);
                hxVar.d = optJSONObject2.optInt("max_report_delay_seconds", IjkMediaCodecInfo.RANK_LAST_CHANCE);
                hxVar.e = optJSONObject2.optString("agent_report_url", "");
            }
            hzVar.e = hxVar;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("analytics");
            hzVar.f = new ij();
            if (optJSONObject3 == null) {
                return hzVar;
            }
            hzVar.f.f1840b = optJSONObject3.optBoolean("analytics_enabled", true);
            hzVar.f.f1839a = optJSONObject3.optInt("max_session_properties", 10);
            return hzVar;
        } catch (JSONException e) {
            throw new IOException("Exception while deserialize: ", e);
        }
    }

    private static ih a(String str) {
        ih ihVar = ih.OFF;
        try {
            if (!TextUtils.isEmpty(str)) {
                return (ih) Enum.valueOf(ih.class, str);
            }
        } catch (Exception e) {
        }
        return ihVar;
    }

    private static void a(hx hxVar, JSONArray jSONArray) throws JSONException {
        JSONObject optJSONObject;
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    hw hwVar = new hw();
                    hwVar.f1813b = optJSONObject2.optString("partner", "");
                    a(hwVar, optJSONObject2.optJSONArray("events"));
                    hwVar.d = b(optJSONObject2.optString("method"));
                    hwVar.e = optJSONObject2.optString("uri_template", "");
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("body_template");
                    if (optJSONObject3 != null) {
                        String optString = optJSONObject3.optString("string", "null");
                        if (!optString.equals("null")) {
                            hwVar.f = optString;
                        }
                    }
                    hwVar.g = optJSONObject2.optInt("max_redirects", 5);
                    hwVar.h = optJSONObject2.optInt("connect_timeout", 20);
                    hwVar.i = optJSONObject2.optInt("request_timeout", 20);
                    hwVar.f1812a = optJSONObject2.optLong("callback_id", -1L);
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("headers");
                    if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("map")) != null) {
                        hwVar.j = lz.a(optJSONObject);
                    }
                    arrayList.add(hwVar);
                }
            }
            hxVar.f1815a = arrayList;
        }
    }

    private static void a(hw hwVar, JSONArray jSONArray) {
        String[] strArr;
        if (jSONArray != null) {
            ArrayList arrayList = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    if (optJSONObject.has("string")) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        ic icVar = new ic();
                        icVar.f1827a = optJSONObject.optString("string", "");
                        arrayList.add(icVar);
                    } else if (optJSONObject.has("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger")) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger");
                        if (optJSONObject2 != null) {
                            id idVar = new id();
                            idVar.f1827a = optJSONObject2.optString("event_name", "");
                            idVar.f1829c = optJSONObject2.optString("event_parameter_name", "");
                            JSONArray optJSONArray = optJSONObject2.optJSONArray("event_parameter_values");
                            if (optJSONArray != null) {
                                String[] strArr2 = new String[optJSONArray.length()];
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    strArr2[i2] = optJSONArray.optString(i2, "");
                                }
                                strArr = strArr2;
                            } else {
                                strArr = new String[0];
                            }
                            idVar.d = strArr;
                            arrayList.add(idVar);
                        }
                    }
                }
            }
            hwVar.f1814c = arrayList;
        }
    }

    private static iw b(String str) {
        iw iwVar = iw.GET;
        try {
            if (!TextUtils.isEmpty(str)) {
                return (iw) Enum.valueOf(iw.class, str);
            }
        } catch (Exception e) {
        }
        return iwVar;
    }

    @Override // com.flurry.sdk.lg
    public final /* synthetic */ void a(OutputStream outputStream, hz hzVar) throws IOException {
        throw new IOException("Serialize not supported for response");
    }
}

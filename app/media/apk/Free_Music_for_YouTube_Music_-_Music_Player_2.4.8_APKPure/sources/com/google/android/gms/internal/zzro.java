package com.google.android.gms.internal;

import android.content.Context;
import com.facebook.GraphResponse;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzt
/* loaded from: classes.dex */
public final class zzro implements zzrn {
    private final Context mContext;
    private final zzajk zzapc;

    public zzro(Context context, zzajk zzajkVar) {
        this.mContext = context;
        this.zzapc = zzajkVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.internal.zzrt zza(com.google.android.gms.internal.zzrs r10) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzro.zza(com.google.android.gms.internal.zzrs):com.google.android.gms.internal.zzrt");
    }

    private static JSONObject zza(zzru zzruVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", zzruVar.zzka());
            if (zzruVar.getBody() != null) {
                jSONObject.put(TtmlNode.TAG_BODY, zzruVar.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zzrr zzrrVar : zzruVar.zzkf()) {
                jSONArray.put(new JSONObject().put("key", zzrrVar.getKey()).put("value", zzrrVar.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", zzruVar.getResponseCode());
        } catch (JSONException e) {
            zzafx.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    private static zzrs zzc(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (MalformedURLException e) {
            zzafx.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zzrr(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new zzrs(optString, url, arrayList, optString3);
    }

    @Override // com.google.android.gms.internal.zzrn
    public final void zza(zzakk zzakkVar, Map<String, String> map) {
        zzagz.zza(new zzrp(this, map, zzakkVar));
    }

    public final JSONObject zzar(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            String str2 = "";
            try {
                str2 = jSONObject.optString("http_request_id");
                zzrt zza = zza(zzc(jSONObject));
                if (zza.isSuccess()) {
                    jSONObject2.put("response", zza(zza.zzke()));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, true);
                } else {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
                    jSONObject2.put("reason", zza.getReason());
                }
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            zzafx.e("The request is not a valid JSON.");
            try {
                return new JSONObject().put(GraphResponse.SUCCESS_KEY, false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }
}

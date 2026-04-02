package com.acrcloud.rec.b.b;

import android.support.v4.app.NotificationCompat;
import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.zhy.view.flowlayout.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: ACRCloudJsonWrapperImpl.java */
/* loaded from: classes.dex */
public class f implements l {
    @Override // com.acrcloud.rec.b.b.l
    public i a(String str, long j) throws a {
        int i = 0;
        if (str == null) {
            return null;
        }
        i iVar = new i();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("status");
            iVar.a(jSONObject2.getInt("code"));
            iVar.a(jSONObject2.getString(NotificationCompat.CATEGORY_MESSAGE));
            iVar.b(jSONObject2.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION));
            if (jSONObject.has("fp_time")) {
                iVar.c(jSONObject.getInt("fp_time"));
            }
            if (jSONObject.has("engine_type")) {
                iVar.b(jSONObject.getInt("engine_type"));
            }
            if (jSONObject.has("ekey")) {
                iVar.c(jSONObject.getString("ekey"));
            }
            if (jSONObject.has("service_type")) {
                iVar.d(jSONObject.getInt("service_type"));
            }
            if (jSONObject.has("result_type")) {
                iVar.e(jSONObject.getInt("result_type"));
            }
            if (j != 0 && jSONObject.has(TtmlNode.TAG_METADATA)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
                if (jSONObject3.has("custom_files")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("custom_files");
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                        if (jSONObject4.has("play_offset_ms")) {
                            jSONObject4.put("play_offset_ms", jSONObject4.getInt("play_offset_ms") + j);
                        }
                        i++;
                    }
                } else if (jSONObject3.has("music")) {
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("music");
                    while (i < jSONArray2.length()) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i);
                        if (jSONObject5.has("play_offset_ms")) {
                            jSONObject5.put("play_offset_ms", jSONObject5.getInt("play_offset_ms") + j);
                        }
                        i++;
                    }
                }
                str = jSONObject.toString();
            }
            iVar.d(str);
            return iVar;
        } catch (Exception e) {
            throw new a(2002, e.getMessage() + "; src result: " + str);
        }
    }

    @Override // com.acrcloud.rec.b.b.l
    public String a(i iVar) {
        if (iVar == null) {
            return null;
        }
        if (iVar.i() != null && !"".equals(iVar.i())) {
            return iVar.i();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", iVar.c());
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, iVar.e());
            jSONObject2.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, iVar.f());
            com.acrcloud.rec.engine.a[] j = iVar.j();
            if (j == null) {
                return a.b(1001);
            }
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < j.length; i++) {
                h.a("ACRCloudWorker", j[i].b());
                JSONObject jSONObject4 = new JSONObject(j[i].b());
                if (iVar.b() != 0) {
                    jSONObject4.put("play_offset_ms", j[i].a() + iVar.b());
                }
                jSONArray.put(jSONObject4);
            }
            jSONObject3.put("custom_files", jSONArray);
            jSONObject.put(TtmlNode.TAG_METADATA, jSONObject3);
            jSONObject.put("status", jSONObject2);
            jSONObject.put("result_type", iVar.k());
            return jSONObject.toString();
        } catch (Exception e) {
            return new a(2002, e.getMessage()).toString();
        }
    }

    @Override // com.acrcloud.rec.b.b.l
    public String a(a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", aVar.a());
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, aVar.b());
            jSONObject2.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, BuildConfig.VERSION_NAME);
            jSONObject.put("status", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e) {
            return String.format("{\"status\":{\"code\":%d, \"msg\":\"%s\", \"version\":\"0.1\"}}", Integer.valueOf(aVar.a()), a.a(aVar.a()));
        }
    }
}

package com.flurry.sdk;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class iy implements lg<hy> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1917a = iy.class.getSimpleName();

    @Override // com.flurry.sdk.lg
    public final /* synthetic */ void a(OutputStream outputStream, hy hyVar) throws IOException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        hy hyVar2 = hyVar;
        if (outputStream != null && hyVar2 != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream) { // from class: com.flurry.sdk.iy.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }
            };
            JSONObject jSONObject3 = new JSONObject();
            try {
                try {
                    a(jSONObject3, "project_key", hyVar2.f1818a);
                    a(jSONObject3, "bundle_id", hyVar2.f1819b);
                    a(jSONObject3, "app_version", hyVar2.f1820c);
                    jSONObject3.put("sdk_version", hyVar2.d);
                    jSONObject3.put("platform", hyVar2.e);
                    a(jSONObject3, "platform_version", hyVar2.f);
                    jSONObject3.put("limit_ad_tracking", hyVar2.g);
                    if (hyVar2.h == null || hyVar2.h.f1826a == null) {
                        jSONObject = null;
                    } else {
                        jSONObject = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        a(jSONObject4, "model", hyVar2.h.f1826a.f1809a);
                        a(jSONObject4, "brand", hyVar2.h.f1826a.f1810b);
                        a(jSONObject4, "id", hyVar2.h.f1826a.f1811c);
                        a(jSONObject4, "device", hyVar2.h.f1826a.d);
                        a(jSONObject4, "product", hyVar2.h.f1826a.e);
                        a(jSONObject4, "version_release", hyVar2.h.f1826a.f);
                        jSONObject.put("com.flurry.proton.generated.avro.v2.AndroidTags", jSONObject4);
                    }
                    if (jSONObject != null) {
                        jSONObject3.put("device_tags", jSONObject);
                    } else {
                        jSONObject3.put("device_tags", JSONObject.NULL);
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (ia iaVar : hyVar2.i) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("type", iaVar.f1824a);
                        a(jSONObject5, "id", iaVar.f1825b);
                        jSONArray.put(jSONObject5);
                    }
                    jSONObject3.put("device_ids", jSONArray);
                    if (hyVar2.j == null || hyVar2.j.f1833a == null) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = new JSONObject();
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.putOpt("latitude", Double.valueOf(hyVar2.j.f1833a.f1830a));
                        jSONObject6.putOpt("longitude", Double.valueOf(hyVar2.j.f1833a.f1831b));
                        jSONObject6.putOpt("accuracy", Float.valueOf(hyVar2.j.f1833a.f1832c));
                        jSONObject2.put("com.flurry.proton.generated.avro.v2.Geolocation", jSONObject6);
                    }
                    if (jSONObject2 != null) {
                        jSONObject3.put("geo", jSONObject2);
                    } else {
                        jSONObject3.put("geo", JSONObject.NULL);
                    }
                    JSONObject jSONObject7 = new JSONObject();
                    if (hyVar2.k != null) {
                        a(jSONObject7, "string", hyVar2.k.f1838a);
                        jSONObject3.put("publisher_user_id", jSONObject7);
                    } else {
                        jSONObject3.put("publisher_user_id", JSONObject.NULL);
                    }
                    km.a(5, f1917a, "Proton Request String: " + jSONObject3.toString());
                    dataOutputStream.write(jSONObject3.toString().getBytes());
                    dataOutputStream.flush();
                } catch (JSONException e) {
                    throw new IOException("Invalid Json", e);
                }
            } finally {
                dataOutputStream.close();
            }
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2) throws IOException, JSONException {
        if (str2 != null) {
            jSONObject.put(str, str2);
        } else {
            jSONObject.put(str, JSONObject.NULL);
        }
    }

    @Override // com.flurry.sdk.lg
    public final /* synthetic */ hy a(InputStream inputStream) throws IOException {
        throw new IOException("Deserialize not supported for request");
    }
}

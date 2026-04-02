package com.airbnb.lottie;

import android.graphics.PointF;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
class as {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF a(JSONObject jSONObject, float f) {
        return new PointF(a(jSONObject.opt("x")) * f, a(jSONObject.opt("y")) * f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF a(JSONArray jSONArray, float f) {
        if (jSONArray.length() < 2) {
            throw new IllegalArgumentException("Unable to parse point for " + jSONArray);
        }
        return new PointF(((float) jSONArray.optDouble(0, 1.0d)) * f, ((float) jSONArray.optDouble(1, 1.0d)) * f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Double) {
            return (float) ((Double) obj).doubleValue();
        }
        if (obj instanceof JSONArray) {
            return (float) ((JSONArray) obj).optDouble(0);
        }
        return 0.0f;
    }
}

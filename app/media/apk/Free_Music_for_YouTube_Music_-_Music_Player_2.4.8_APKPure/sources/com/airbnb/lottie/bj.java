package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.k;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: PointFFactory.java */
/* loaded from: classes.dex */
class bj implements k.a<PointF> {

    /* renamed from: a  reason: collision with root package name */
    static final bj f450a = new bj();

    private bj() {
    }

    @Override // com.airbnb.lottie.k.a
    /* renamed from: a */
    public PointF b(Object obj, float f) {
        if (obj instanceof JSONArray) {
            return as.a((JSONArray) obj, f);
        }
        if (obj instanceof JSONObject) {
            return as.a((JSONObject) obj, f);
        }
        throw new IllegalArgumentException("Unable to parse point from " + obj);
    }
}

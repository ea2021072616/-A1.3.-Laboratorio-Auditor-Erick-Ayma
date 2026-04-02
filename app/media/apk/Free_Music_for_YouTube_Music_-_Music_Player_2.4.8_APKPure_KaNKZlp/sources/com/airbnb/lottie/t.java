package com.airbnb.lottie;

import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import com.airbnb.lottie.k;
import org.json.JSONArray;
/* compiled from: ColorFactory.java */
/* loaded from: classes.dex */
class t implements k.a<Integer> {

    /* renamed from: a  reason: collision with root package name */
    static final t f555a = new t();

    t() {
    }

    @Override // com.airbnb.lottie.k.a
    /* renamed from: a */
    public Integer b(Object obj, float f) {
        JSONArray jSONArray = (JSONArray) obj;
        if (jSONArray.length() == 4) {
            boolean z = true;
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.optDouble(i) > 1.0d) {
                    z = false;
                }
            }
            float f2 = z ? 255.0f : 1.0f;
            return Integer.valueOf(Color.argb((int) (jSONArray.optDouble(3) * f2), (int) (jSONArray.optDouble(0) * f2), (int) (jSONArray.optDouble(1) * f2), (int) (jSONArray.optDouble(2) * f2)));
        }
        return Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK);
    }
}

package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import com.airbnb.lottie.at;
import com.airbnb.lottie.k;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
class bh extends at<PointF> {
    @Nullable
    private Path f;

    private bh(aw awVar, @Nullable PointF pointF, @Nullable PointF pointF2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        super(awVar, pointF, pointF2, interpolator, f, f2);
    }

    /* compiled from: PathKeyframe.java */
    /* loaded from: classes.dex */
    static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static bh a(JSONObject jSONObject, aw awVar, k.a<PointF> aVar) {
            PointF pointF;
            PointF pointF2;
            at a2 = at.a.a(jSONObject, awVar, awVar.g(), aVar);
            JSONArray optJSONArray = jSONObject.optJSONArray("ti");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("to");
            if (optJSONArray == null || optJSONArray2 == null) {
                pointF = null;
                pointF2 = null;
            } else {
                PointF a3 = as.a(optJSONArray2, awVar.g());
                pointF = as.a(optJSONArray, awVar.g());
                pointF2 = a3;
            }
            bh bhVar = new bh(awVar, (PointF) a2.f406a, (PointF) a2.f407b, a2.f408c, a2.d, a2.e);
            boolean z = (a2.f407b == 0 || a2.f406a == 0 || !((PointF) a2.f406a).equals(((PointF) a2.f407b).x, ((PointF) a2.f407b).y)) ? false : true;
            if (bhVar.f407b != 0 && !z) {
                bhVar.f = ch.a((PointF) a2.f406a, (PointF) a2.f407b, pointF2, pointF);
            }
            return bhVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path e() {
        return this.f;
    }
}

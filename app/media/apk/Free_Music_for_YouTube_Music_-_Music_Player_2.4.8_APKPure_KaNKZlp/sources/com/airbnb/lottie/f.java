package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.l;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatablePointValue.java */
/* loaded from: classes.dex */
public class f extends m<PointF, PointF> {
    private f(List<at<PointF>> list, PointF pointF) {
        super(list, pointF);
    }

    @Override // com.airbnb.lottie.k
    /* renamed from: a */
    public au<PointF> b() {
        return !e() ? new cd(this.f536b) : new bk(this.f535a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatablePointValue.java */
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static f a(JSONObject jSONObject, aw awVar) {
            l.a a2 = l.a(jSONObject, awVar.g(), awVar, bj.f450a).a();
            return new f(a2.f533a, (PointF) a2.f534b);
        }
    }
}

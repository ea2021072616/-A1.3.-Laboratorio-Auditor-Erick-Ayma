package com.airbnb.lottie;

import com.airbnb.lottie.bq;
import com.airbnb.lottie.l;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableScaleValue.java */
/* loaded from: classes.dex */
public class g extends m<bq, bq> {
    private g() {
        super(new bq());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(List<at<bq>> list, bq bqVar) {
        super(list, bqVar);
    }

    @Override // com.airbnb.lottie.k
    /* renamed from: a */
    public au<bq> b() {
        return !e() ? new cd(this.f536b) : new bp(this.f535a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableScaleValue.java */
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static g a(JSONObject jSONObject, aw awVar) {
            l.a a2 = l.a(jSONObject, 1.0f, awVar, bq.a.f470a).a();
            return new g(a2.f533a, (bq) a2.f534b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static g a() {
            return new g();
        }
    }
}

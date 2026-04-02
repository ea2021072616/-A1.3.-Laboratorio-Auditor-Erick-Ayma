package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.b;
import com.airbnb.lottie.bh;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatablePathValue.java */
/* loaded from: classes.dex */
public class e implements k<PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<bh> f521a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f522b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k<PointF> a(JSONObject jSONObject, aw awVar) {
        if (jSONObject.has("k")) {
            return new e(jSONObject.opt("k"), awVar);
        }
        return new i(b.a.a(jSONObject.optJSONObject("x"), awVar), b.a.a(jSONObject.optJSONObject("y"), awVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        this.f521a = new ArrayList();
        this.f522b = new PointF(0.0f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Object obj, aw awVar) {
        this.f521a = new ArrayList();
        if (a(obj)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.f521a.add(bh.a.a(jSONArray.optJSONObject(i), awVar, a.f523a));
            }
            at.a(this.f521a);
            return;
        }
        this.f522b = as.a((JSONArray) obj, awVar.g());
    }

    private boolean a(Object obj) {
        if (obj instanceof JSONArray) {
            Object opt = ((JSONArray) obj).opt(0);
            return (opt instanceof JSONObject) && ((JSONObject) opt).has("t");
        }
        return false;
    }

    @Override // com.airbnb.lottie.k
    public n<?, PointF> b() {
        return !a() ? new cd(this.f522b) : new bi(this.f521a);
    }

    public boolean a() {
        return !this.f521a.isEmpty();
    }

    public String toString() {
        return "initialPoint=" + this.f522b;
    }

    /* compiled from: AnimatablePathValue.java */
    /* loaded from: classes.dex */
    private static class a implements k.a<PointF> {

        /* renamed from: a  reason: collision with root package name */
        private static final k.a<PointF> f523a = new a();

        private a() {
        }

        @Override // com.airbnb.lottie.k.a
        /* renamed from: a */
        public PointF b(Object obj, float f) {
            return as.a((JSONArray) obj, f);
        }
    }
}

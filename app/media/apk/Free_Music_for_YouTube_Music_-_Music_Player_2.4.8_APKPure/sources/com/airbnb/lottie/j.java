package com.airbnb.lottie;

import android.graphics.PointF;
import android.util.Log;
import com.airbnb.lottie.b;
import com.airbnb.lottie.d;
import com.airbnb.lottie.g;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Collections;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableTransform.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final e f527a;

    /* renamed from: b  reason: collision with root package name */
    private final k<PointF> f528b;

    /* renamed from: c  reason: collision with root package name */
    private final g f529c;
    private final b d;
    private final d e;

    private j(e eVar, k<PointF> kVar, g gVar, b bVar, d dVar) {
        this.f527a = eVar;
        this.f528b = kVar;
        this.f529c = gVar;
        this.d = bVar;
        this.e = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableTransform.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static j a() {
            return new j(new e(), new e(), g.a.a(), b.a.a(), d.a.a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static j a(JSONObject jSONObject, aw awVar) {
            e eVar;
            k<PointF> kVar;
            g gVar;
            b bVar;
            d dVar;
            JSONObject optJSONObject = jSONObject.optJSONObject("a");
            if (optJSONObject != null) {
                eVar = new e(optJSONObject.opt("k"), awVar);
            } else {
                Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
                eVar = new e();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TtmlNode.TAG_P);
            if (optJSONObject2 != null) {
                kVar = e.a(optJSONObject2, awVar);
            } else {
                a("position");
                kVar = null;
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            if (optJSONObject3 != null) {
                gVar = g.a.a(optJSONObject3, awVar);
            } else {
                gVar = new g(Collections.emptyList(), new bq());
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("r");
            if (optJSONObject4 == null) {
                optJSONObject4 = jSONObject.optJSONObject("rz");
            }
            if (optJSONObject4 != null) {
                bVar = b.a.a(optJSONObject4, awVar, false);
            } else {
                a("rotation");
                bVar = null;
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("o");
            if (optJSONObject5 != null) {
                dVar = d.a.a(optJSONObject5, awVar);
            } else {
                dVar = new d(Collections.emptyList(), 100);
            }
            return new j(eVar, kVar, gVar, bVar, dVar);
        }

        private static void a(String str) {
            throw new IllegalArgumentException("Missing transform for " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a() {
        return this.f527a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k<PointF> b() {
        return this.f528b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g c() {
        return this.f529c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b d() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d e() {
        return this.e;
    }

    public cf f() {
        return new cf(this);
    }
}

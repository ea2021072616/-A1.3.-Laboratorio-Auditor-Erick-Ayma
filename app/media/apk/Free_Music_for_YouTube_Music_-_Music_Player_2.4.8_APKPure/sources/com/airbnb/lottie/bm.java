package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.b;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PolystarShape.java */
/* loaded from: classes.dex */
public class bm {

    /* renamed from: a  reason: collision with root package name */
    private final String f456a;

    /* renamed from: b  reason: collision with root package name */
    private final b f457b;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.b f458c;
    private final k<PointF> d;
    private final com.airbnb.lottie.b e;
    private final com.airbnb.lottie.b f;
    private final com.airbnb.lottie.b g;
    private final com.airbnb.lottie.b h;
    private final com.airbnb.lottie.b i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PolystarShape.java */
    /* loaded from: classes.dex */
    public enum b {
        Star(1),
        Polygon(2);
        

        /* renamed from: c  reason: collision with root package name */
        private final int f461c;

        b(int i) {
            this.f461c = i;
        }

        static b a(int i) {
            b[] values;
            for (b bVar : values()) {
                if (bVar.f461c == i) {
                    return bVar;
                }
            }
            return null;
        }
    }

    private bm(String str, b bVar, com.airbnb.lottie.b bVar2, k<PointF> kVar, com.airbnb.lottie.b bVar3, com.airbnb.lottie.b bVar4, com.airbnb.lottie.b bVar5, com.airbnb.lottie.b bVar6, com.airbnb.lottie.b bVar7) {
        this.f456a = str;
        this.f457b = bVar;
        this.f458c = bVar2;
        this.d = kVar;
        this.e = bVar3;
        this.f = bVar4;
        this.g = bVar5;
        this.h = bVar6;
        this.i = bVar7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PolystarShape.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static bm a(JSONObject jSONObject, aw awVar) {
            com.airbnb.lottie.b bVar;
            com.airbnb.lottie.b bVar2;
            String optString = jSONObject.optString("nm");
            b a2 = b.a(jSONObject.optInt("sy"));
            com.airbnb.lottie.b a3 = b.a.a(jSONObject.optJSONObject("pt"), awVar, false);
            k<PointF> a4 = e.a(jSONObject.optJSONObject(TtmlNode.TAG_P), awVar);
            com.airbnb.lottie.b a5 = b.a.a(jSONObject.optJSONObject("r"), awVar, false);
            com.airbnb.lottie.b a6 = b.a.a(jSONObject.optJSONObject("or"), awVar);
            com.airbnb.lottie.b a7 = b.a.a(jSONObject.optJSONObject("os"), awVar, false);
            if (a2 == b.Star) {
                bVar2 = b.a.a(jSONObject.optJSONObject("ir"), awVar);
                bVar = b.a.a(jSONObject.optJSONObject("is"), awVar, false);
            } else {
                bVar = null;
                bVar2 = null;
            }
            return new bm(optString, a2, a3, a4, a5, bVar2, a6, bVar, a7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f456a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b() {
        return this.f457b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b c() {
        return this.f458c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k<PointF> d() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b f() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b g() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b h() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b i() {
        return this.i;
    }
}

package com.airbnb.lottie;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a;
import com.airbnb.lottie.b;
import com.airbnb.lottie.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeStroke.java */
/* loaded from: classes.dex */
public class by {

    /* renamed from: a  reason: collision with root package name */
    private final String f488a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final com.airbnb.lottie.b f489b;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.airbnb.lottie.b> f490c;
    private final com.airbnb.lottie.a d;
    private final d e;
    private final com.airbnb.lottie.b f;
    private final b g;
    private final c h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeStroke.java */
    /* loaded from: classes.dex */
    public enum b {
        Butt,
        Round,
        Unknown;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Paint.Cap a() {
            switch (this) {
                case Butt:
                    return Paint.Cap.BUTT;
                case Round:
                    return Paint.Cap.ROUND;
                default:
                    return Paint.Cap.SQUARE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeStroke.java */
    /* loaded from: classes.dex */
    public enum c {
        Miter,
        Round,
        Bevel;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Paint.Join a() {
            switch (this) {
                case Bevel:
                    return Paint.Join.BEVEL;
                case Miter:
                    return Paint.Join.MITER;
                case Round:
                    return Paint.Join.ROUND;
                default:
                    return null;
            }
        }
    }

    private by(String str, @Nullable com.airbnb.lottie.b bVar, List<com.airbnb.lottie.b> list, com.airbnb.lottie.a aVar, d dVar, com.airbnb.lottie.b bVar2, b bVar3, c cVar) {
        this.f488a = str;
        this.f489b = bVar;
        this.f490c = list;
        this.d = aVar;
        this.e = dVar;
        this.f = bVar2;
        this.g = bVar3;
        this.h = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeStroke.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static by a(JSONObject jSONObject, aw awVar) {
            String optString = jSONObject.optString("nm");
            ArrayList arrayList = new ArrayList();
            com.airbnb.lottie.a a2 = a.C0015a.a(jSONObject.optJSONObject("c"), awVar);
            com.airbnb.lottie.b a3 = b.a.a(jSONObject.optJSONObject("w"), awVar);
            d a4 = d.a.a(jSONObject.optJSONObject("o"), awVar);
            b bVar = b.values()[jSONObject.optInt("lc") - 1];
            c cVar = c.values()[jSONObject.optInt("lj") - 1];
            com.airbnb.lottie.b bVar2 = null;
            if (jSONObject.has("d")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("d");
                com.airbnb.lottie.b bVar3 = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject.optString("n");
                    if (optString2.equals("o")) {
                        bVar3 = b.a.a(optJSONObject.optJSONObject("v"), awVar);
                    } else if (optString2.equals("d") || optString2.equals("g")) {
                        arrayList.add(b.a.a(optJSONObject.optJSONObject("v"), awVar));
                    }
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
                bVar2 = bVar3;
            }
            return new by(optString, bVar2, arrayList, a2, a4, a3, bVar, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f488a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.a b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b d() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.b> e() {
        return this.f490c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b f() {
        return this.f489b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c h() {
        return this.h;
    }
}

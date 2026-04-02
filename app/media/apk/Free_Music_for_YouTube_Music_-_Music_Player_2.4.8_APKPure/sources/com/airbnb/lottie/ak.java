package com.airbnb.lottie;

import android.support.annotation.Nullable;
import com.airbnb.lottie.b;
import com.airbnb.lottie.by;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientStroke.java */
/* loaded from: classes.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private final String f393a;

    /* renamed from: b  reason: collision with root package name */
    private final am f394b;

    /* renamed from: c  reason: collision with root package name */
    private final c f395c;
    private final d d;
    private final f e;
    private final f f;
    private final b g;
    private final by.b h;
    private final by.c i;
    private final List<b> j;
    @Nullable
    private final b k;

    private ak(String str, am amVar, c cVar, d dVar, f fVar, f fVar2, b bVar, by.b bVar2, by.c cVar2, List<b> list, @Nullable b bVar3) {
        this.f393a = str;
        this.f394b = amVar;
        this.f395c = cVar;
        this.d = dVar;
        this.e = fVar;
        this.f = fVar2;
        this.g = bVar;
        this.h = bVar2;
        this.i = cVar2;
        this.j = list;
        this.k = bVar3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f393a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public am b() {
        return this.f394b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c c() {
        return this.f395c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d d() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f f() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public by.b h() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public by.c i() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> j() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public b k() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GradientStroke.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ak a(JSONObject jSONObject, aw awVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("g");
            if (optJSONObject != null && optJSONObject.has("k")) {
                optJSONObject = optJSONObject.optJSONObject("k");
            }
            c cVar = null;
            if (optJSONObject != null) {
                cVar = c.a.a(optJSONObject, awVar);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            d dVar = null;
            if (optJSONObject2 != null) {
                dVar = d.a.a(optJSONObject2, awVar);
            }
            am amVar = jSONObject.optInt("t", 1) == 1 ? am.Linear : am.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            f fVar = null;
            if (optJSONObject3 != null) {
                fVar = f.a.a(optJSONObject3, awVar);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            f fVar2 = null;
            if (optJSONObject4 != null) {
                fVar2 = f.a.a(optJSONObject4, awVar);
            }
            b a2 = b.a.a(jSONObject.optJSONObject("w"), awVar);
            by.b bVar = by.b.values()[jSONObject.optInt("lc") - 1];
            by.c cVar2 = by.c.values()[jSONObject.optInt("lj") - 1];
            b bVar2 = null;
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has("d")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("d");
                b bVar3 = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject5.optString("n");
                    if (optString2.equals("o")) {
                        bVar3 = b.a.a(optJSONObject5.optJSONObject("v"), awVar);
                    } else if (optString2.equals("d") || optString2.equals("g")) {
                        arrayList.add(b.a.a(optJSONObject5.optJSONObject("v"), awVar));
                    }
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
                bVar2 = bVar3;
            }
            return new ak(optString, amVar, cVar, dVar, fVar, fVar2, a2, bVar, cVar2, arrayList, bVar2);
        }
    }
}

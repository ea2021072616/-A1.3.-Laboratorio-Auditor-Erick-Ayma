package com.airbnb.lottie;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public class bs {

    /* renamed from: a  reason: collision with root package name */
    private final List<z> f474a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f475b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f476c;

    private bs(PointF pointF, boolean z, List<z> list) {
        this.f474a = new ArrayList();
        this.f475b = pointF;
        this.f476c = z;
        this.f474a.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs() {
        this.f474a = new ArrayList();
    }

    private void a(float f, float f2) {
        if (this.f475b == null) {
            this.f475b = new PointF();
        }
        this.f475b.set(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointF a() {
        return this.f475b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f476c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<z> c() {
        return this.f474a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(bs bsVar, bs bsVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.f475b == null) {
            this.f475b = new PointF();
        }
        this.f476c = bsVar.b() || bsVar2.b();
        if (!this.f474a.isEmpty() && this.f474a.size() != bsVar.c().size() && this.f474a.size() != bsVar2.c().size()) {
            throw new IllegalStateException("Curves must have the same number of control points. This: " + c().size() + "\tShape 1: " + bsVar.c().size() + "\tShape 2: " + bsVar2.c().size());
        }
        if (this.f474a.isEmpty()) {
            for (int size = bsVar.c().size() - 1; size >= 0; size--) {
                this.f474a.add(new z());
            }
        }
        PointF a2 = bsVar.a();
        PointF a3 = bsVar2.a();
        a(bd.a(a2.x, a3.x, f), bd.a(a2.y, a3.y, f));
        for (int size2 = this.f474a.size() - 1; size2 >= 0; size2--) {
            z zVar = bsVar.c().get(size2);
            z zVar2 = bsVar2.c().get(size2);
            PointF a4 = zVar.a();
            PointF b2 = zVar.b();
            PointF c2 = zVar.c();
            PointF a5 = zVar2.a();
            PointF b3 = zVar2.b();
            PointF c3 = zVar2.c();
            this.f474a.get(size2).a(bd.a(a4.x, a5.x, f), bd.a(a4.y, a5.y, f));
            this.f474a.get(size2).b(bd.a(b2.x, b3.x, f), bd.a(b2.y, b3.y, f));
            this.f474a.get(size2).c(bd.a(c2.x, c3.x, f), bd.a(c2.y, c3.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f474a.size() + "closed=" + this.f476c + '}';
    }

    /* compiled from: ShapeData.java */
    /* loaded from: classes.dex */
    static class a implements k.a<bs> {

        /* renamed from: a  reason: collision with root package name */
        static final a f477a = new a();

        private a() {
        }

        @Override // com.airbnb.lottie.k.a
        /* renamed from: a */
        public bs b(Object obj, float f) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = null;
            if (obj instanceof JSONArray) {
                Object opt = ((JSONArray) obj).opt(0);
                if (!(opt instanceof JSONObject) || !((JSONObject) opt).has("v")) {
                    jSONObject = null;
                } else {
                    jSONObject = (JSONObject) opt;
                }
                jSONObject2 = jSONObject;
            } else if ((obj instanceof JSONObject) && ((JSONObject) obj).has("v")) {
                jSONObject2 = (JSONObject) obj;
            }
            if (jSONObject2 == null) {
                return null;
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("v");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("i");
            JSONArray optJSONArray3 = jSONObject2.optJSONArray("o");
            boolean optBoolean = jSONObject2.optBoolean("c", false);
            if (optJSONArray == null || optJSONArray2 == null || optJSONArray3 == null || optJSONArray.length() != optJSONArray2.length() || optJSONArray.length() != optJSONArray3.length()) {
                throw new IllegalStateException("Unable to process points array or tangents. " + jSONObject2);
            }
            if (optJSONArray.length() == 0) {
                return new bs(new PointF(), false, Collections.emptyList());
            }
            int length = optJSONArray.length();
            PointF a2 = a(0, optJSONArray);
            a2.x *= f;
            a2.y *= f;
            ArrayList arrayList = new ArrayList(length);
            for (int i = 1; i < length; i++) {
                PointF a3 = a(i, optJSONArray);
                PointF a4 = a(i - 1, optJSONArray);
                PointF a5 = a(i - 1, optJSONArray3);
                PointF a6 = a(i, optJSONArray2);
                PointF a7 = bd.a(a4, a5);
                PointF a8 = bd.a(a3, a6);
                a7.x *= f;
                a7.y *= f;
                a8.x *= f;
                a8.y *= f;
                a3.x *= f;
                a3.y *= f;
                arrayList.add(new z(a7, a8, a3));
            }
            if (optBoolean) {
                PointF a9 = a(0, optJSONArray);
                PointF a10 = a(length - 1, optJSONArray);
                PointF a11 = a(length - 1, optJSONArray3);
                PointF a12 = a(0, optJSONArray2);
                PointF a13 = bd.a(a10, a11);
                PointF a14 = bd.a(a9, a12);
                if (f != 1.0f) {
                    a13.x *= f;
                    a13.y *= f;
                    a14.x *= f;
                    a14.y *= f;
                    a9.x *= f;
                    a9.y *= f;
                }
                arrayList.add(new z(a13, a14, a9));
            }
            return new bs(a2, optBoolean, arrayList);
        }

        private static PointF a(int i, JSONArray jSONArray) {
            if (i >= jSONArray.length()) {
                throw new IllegalArgumentException("Invalid index " + i + ". There are only " + jSONArray.length() + " points.");
            }
            JSONArray optJSONArray = jSONArray.optJSONArray(i);
            Object opt = optJSONArray.opt(0);
            Object opt2 = optJSONArray.opt(1);
            return new PointF(opt instanceof Double ? new Float(((Double) opt).doubleValue()).floatValue() : ((Integer) opt).intValue(), opt2 instanceof Double ? new Float(((Double) opt2).doubleValue()).floatValue() : ((Integer) opt2).intValue());
        }
    }
}

package com.airbnb.lottie;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public class at<T> {
    private static final Interpolator f = new LinearInterpolator();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    final T f406a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    final T f407b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    final Interpolator f408c;
    final float d;
    @Nullable
    Float e;
    private final aw g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<? extends at<?>> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            list.get(i2).e = Float.valueOf(list.get(i2 + 1).d);
            i = i2 + 1;
        }
        at<?> atVar = list.get(size - 1);
        if (atVar.f406a == null) {
            list.remove(atVar);
        }
    }

    public at(aw awVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.g = awVar;
        this.f406a = t;
        this.f407b = t2;
        this.f408c = interpolator;
        this.d = f2;
        this.e = f3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float a() {
        return this.d / this.g.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float b() {
        if (this.e == null) {
            return 1.0f;
        }
        return this.e.floatValue() / this.g.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f408c == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= a() && f2 <= b();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f406a + ", endValue=" + this.f407b + ", startFrame=" + this.d + ", endFrame=" + this.e + ", interpolator=" + this.f408c + '}';
    }

    /* compiled from: Keyframe.java */
    /* loaded from: classes.dex */
    static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static <T> at<T> a(JSONObject jSONObject, aw awVar, float f, k.a<T> aVar) {
            T b2;
            Interpolator interpolator;
            T t;
            PointF pointF;
            PointF pointF2;
            T t2;
            Interpolator interpolator2;
            float f2 = 0.0f;
            if (jSONObject.has("t")) {
                f2 = (float) jSONObject.optDouble("t", 0.0d);
                Object opt = jSONObject.opt("s");
                T b3 = opt != null ? aVar.b(opt, f) : null;
                Object opt2 = jSONObject.opt("e");
                T b4 = opt2 != null ? aVar.b(opt2, f) : null;
                JSONObject optJSONObject = jSONObject.optJSONObject("o");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("i");
                if (optJSONObject == null || optJSONObject2 == null) {
                    pointF = null;
                    pointF2 = null;
                } else {
                    pointF2 = as.a(optJSONObject, f);
                    pointF = as.a(optJSONObject2, f);
                }
                if (jSONObject.optInt("h", 0) == 1) {
                    interpolator2 = at.f;
                    t2 = b3;
                } else if (pointF2 == null) {
                    t2 = b4;
                    interpolator2 = at.f;
                } else {
                    pointF2.x = bd.b(pointF2.x, -f, f);
                    pointF2.y = bd.b(pointF2.y, -100.0f, 100.0f);
                    pointF.x = bd.b(pointF.x, -f, f);
                    pointF.y = bd.b(pointF.y, -100.0f, 100.0f);
                    Interpolator create = PathInterpolatorCompat.create(pointF2.x / f, pointF2.y / f, pointF.x / f, pointF.y / f);
                    t2 = b4;
                    interpolator2 = create;
                }
                interpolator = interpolator2;
                b2 = t2;
                t = b3;
            } else {
                b2 = aVar.b(jSONObject, f);
                interpolator = null;
                t = b2;
            }
            return new at<>(awVar, t, b2, interpolator, f2, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static <T> List<at<T>> a(JSONArray jSONArray, aw awVar, float f, k.a<T> aVar) {
            int length = jSONArray.length();
            if (length == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(a(jSONArray.optJSONObject(i), awVar, f, aVar));
            }
            at.a(arrayList);
            return arrayList;
        }
    }
}

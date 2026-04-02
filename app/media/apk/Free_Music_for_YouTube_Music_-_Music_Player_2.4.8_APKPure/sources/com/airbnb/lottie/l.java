package com.airbnb.lottie;

import android.support.annotation.Nullable;
import com.airbnb.lottie.at;
import com.airbnb.lottie.k;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableValueParser.java */
/* loaded from: classes.dex */
public class l<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f530a;

    /* renamed from: b  reason: collision with root package name */
    private final float f531b;

    /* renamed from: c  reason: collision with root package name */
    private final aw f532c;
    private final k.a<T> d;

    private l(@Nullable JSONObject jSONObject, float f, aw awVar, k.a<T> aVar) {
        this.f530a = jSONObject;
        this.f531b = f;
        this.f532c = awVar;
        this.d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> l<T> a(@Nullable JSONObject jSONObject, float f, aw awVar, k.a<T> aVar) {
        return new l<>(jSONObject, f, awVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> a() {
        List<at<T>> b2 = b();
        return new a<>(b2, a((List) b2));
    }

    private List<at<T>> b() {
        if (this.f530a != null) {
            Object opt = this.f530a.opt("k");
            if (a(opt)) {
                return at.a.a((JSONArray) opt, this.f532c, this.f531b, this.d);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T a(List<at<T>> list) {
        if (this.f530a != null) {
            if (!list.isEmpty()) {
                return list.get(0).f406a;
            }
            return this.d.b(this.f530a.opt("k"), this.f531b);
        }
        return null;
    }

    private static boolean a(Object obj) {
        if (obj instanceof JSONArray) {
            Object opt = ((JSONArray) obj).opt(0);
            return (opt instanceof JSONObject) && ((JSONObject) opt).has("t");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableValueParser.java */
    /* loaded from: classes.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final List<at<T>> f533a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        final T f534b;

        a(List<at<T>> list, @Nullable T t) {
            this.f533a = list;
            this.f534b = t;
        }
    }
}

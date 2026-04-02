package com.airbnb.lottie;

import com.airbnb.lottie.k;
import com.airbnb.lottie.l;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableFloatValue.java */
/* loaded from: classes.dex */
public class b extends m<Float, Float> {
    private b() {
        super(Float.valueOf(0.0f));
    }

    private b(List<at<Float>> list, Float f) {
        super(list, f);
    }

    @Override // com.airbnb.lottie.k
    /* renamed from: a */
    public au<Float> b() {
        return !e() ? new cd(this.f536b) : new ae(this.f535a);
    }

    @Override // com.airbnb.lottie.m
    /* renamed from: c */
    public Float d() {
        return (Float) this.f536b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatableFloatValue.java */
    /* renamed from: com.airbnb.lottie.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016b implements k.a<Float> {

        /* renamed from: a  reason: collision with root package name */
        static final C0016b f436a = new C0016b();

        private C0016b() {
        }

        @Override // com.airbnb.lottie.k.a
        /* renamed from: a */
        public Float b(Object obj, float f) {
            return Float.valueOf(as.a(obj) * f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableFloatValue.java */
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a() {
            return new b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(JSONObject jSONObject, aw awVar) {
            return a(jSONObject, awVar, true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(JSONObject jSONObject, aw awVar, boolean z) {
            l.a a2 = l.a(jSONObject, z ? awVar.g() : 1.0f, awVar, C0016b.f436a).a();
            return new b(a2.f533a, (Float) a2.f534b);
        }
    }
}

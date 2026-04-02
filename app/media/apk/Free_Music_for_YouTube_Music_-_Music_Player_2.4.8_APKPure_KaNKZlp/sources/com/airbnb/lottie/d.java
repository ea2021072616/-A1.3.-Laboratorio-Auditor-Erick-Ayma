package com.airbnb.lottie;

import com.airbnb.lottie.k;
import com.airbnb.lottie.l;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableIntegerValue.java */
/* loaded from: classes.dex */
public class d extends m<Integer, Integer> {
    private d() {
        super(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List<at<Integer>> list, Integer num) {
        super(list, num);
    }

    @Override // com.airbnb.lottie.k
    /* renamed from: a */
    public au<Integer> b() {
        return !e() ? new cd(this.f536b) : new aq(this.f535a);
    }

    @Override // com.airbnb.lottie.m
    /* renamed from: c */
    public Integer d() {
        return (Integer) this.f536b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableIntegerValue.java */
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static d a() {
            return new d();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static d a(JSONObject jSONObject, aw awVar) {
            l.a a2 = l.a(jSONObject, 1.0f, awVar, b.f520a).a();
            return new d(a2.f533a, (Integer) a2.f534b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatableIntegerValue.java */
    /* loaded from: classes.dex */
    public static class b implements k.a<Integer> {

        /* renamed from: a  reason: collision with root package name */
        private static final b f520a = new b();

        private b() {
        }

        @Override // com.airbnb.lottie.k.a
        /* renamed from: a */
        public Integer b(Object obj, float f) {
            return Integer.valueOf(Math.round(as.a(obj) * f));
        }
    }
}

package com.airbnb.lottie;

import com.airbnb.lottie.l;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableColorValue.java */
/* loaded from: classes.dex */
public class a extends m<Integer, Integer> {
    private a(List<at<Integer>> list, Integer num) {
        super(list, num);
    }

    @Override // com.airbnb.lottie.k
    /* renamed from: a */
    public au<Integer> b() {
        return !e() ? new cd(this.f536b) : new u(this.f535a);
    }

    @Override // com.airbnb.lottie.m
    public String toString() {
        return "AnimatableColorValue{initialValue=" + this.f536b + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableColorValue.java */
    /* renamed from: com.airbnb.lottie.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0015a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(JSONObject jSONObject, aw awVar) {
            l.a a2 = l.a(jSONObject, 1.0f, awVar, t.f555a).a();
            return new a(a2.f533a, (Integer) a2.f534b);
        }
    }
}

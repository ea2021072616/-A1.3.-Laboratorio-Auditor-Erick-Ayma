package com.airbnb.lottie;

import com.airbnb.lottie.k;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScaleXY.java */
/* loaded from: classes.dex */
public class bq {

    /* renamed from: a  reason: collision with root package name */
    private final float f468a;

    /* renamed from: b  reason: collision with root package name */
    private final float f469b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(float f, float f2) {
        this.f468a = f;
        this.f469b = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq() {
        this(1.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.f468a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f469b;
    }

    public String toString() {
        return a() + "x" + b();
    }

    /* compiled from: ScaleXY.java */
    /* loaded from: classes.dex */
    static class a implements k.a<bq> {

        /* renamed from: a  reason: collision with root package name */
        static final a f470a = new a();

        private a() {
        }

        @Override // com.airbnb.lottie.k.a
        /* renamed from: a */
        public bq b(Object obj, float f) {
            JSONArray jSONArray = (JSONArray) obj;
            return new bq((((float) jSONArray.optDouble(0, 1.0d)) / 100.0f) * f, (((float) jSONArray.optDouble(1, 1.0d)) / 100.0f) * f);
        }
    }
}

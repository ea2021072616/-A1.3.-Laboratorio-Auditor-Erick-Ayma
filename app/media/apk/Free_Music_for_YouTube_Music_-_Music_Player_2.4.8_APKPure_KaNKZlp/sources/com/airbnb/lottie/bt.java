package com.airbnb.lottie;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a;
import com.airbnb.lottie.d;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public class bt {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f478a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f479b;

    /* renamed from: c  reason: collision with root package name */
    private final String f480c;
    @Nullable
    private final com.airbnb.lottie.a d;
    @Nullable
    private final d e;

    private bt(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.a aVar, @Nullable d dVar) {
        this.f480c = str;
        this.f478a = z;
        this.f479b = fillType;
        this.d = aVar;
        this.e = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeFill.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static bt a(JSONObject jSONObject, aw awVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("c");
            com.airbnb.lottie.a a2 = optJSONObject != null ? a.C0015a.a(optJSONObject, awVar) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            return new bt(optString, jSONObject.optBoolean("fillEnabled"), jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, a2, optJSONObject2 != null ? d.a.a(optJSONObject2, awVar) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f480c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.a b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public d c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path.FillType d() {
        return this.f479b;
    }

    public String toString() {
        return "ShapeFill{color=" + (this.d == null ? "null" : Integer.toHexString(this.d.d().intValue())) + ", fillEnabled=" + this.f478a + ", opacity=" + (this.e == null ? "null" : this.e.d()) + '}';
    }
}

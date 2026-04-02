package com.airbnb.lottie;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientFill.java */
/* loaded from: classes.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private final am f387a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f388b;

    /* renamed from: c  reason: collision with root package name */
    private final c f389c;
    private final d d;
    private final f e;
    private final f f;
    private final String g;
    @Nullable
    private final b h;
    @Nullable
    private final b i;

    private ai(String str, am amVar, Path.FillType fillType, c cVar, d dVar, f fVar, f fVar2, b bVar, b bVar2) {
        this.f387a = amVar;
        this.f388b = fillType;
        this.f389c = cVar;
        this.d = dVar;
        this.e = fVar;
        this.f = fVar2;
        this.g = str;
        this.h = bVar;
        this.i = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public am b() {
        return this.f387a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path.FillType c() {
        return this.f388b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        return this.f389c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d e() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f f() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f g() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GradientFill.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ai a(JSONObject jSONObject, aw awVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("g");
            if (optJSONObject != null && optJSONObject.has("k")) {
                int optInt = optJSONObject.optInt(TtmlNode.TAG_P);
                optJSONObject = optJSONObject.optJSONObject("k");
                try {
                    optJSONObject.put(TtmlNode.TAG_P, optInt);
                } catch (JSONException e) {
                }
            }
            c a2 = optJSONObject != null ? c.a.a(optJSONObject, awVar) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            d a3 = optJSONObject2 != null ? d.a.a(optJSONObject2, awVar) : null;
            Path.FillType fillType = jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
            am amVar = jSONObject.optInt("t", 1) == 1 ? am.Linear : am.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            f a4 = optJSONObject3 != null ? f.a.a(optJSONObject3, awVar) : null;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            return new ai(optString, amVar, fillType, a2, a3, a4, optJSONObject4 != null ? f.a.a(optJSONObject4, awVar) : null, null, null);
        }
    }
}

package com.airbnb.lottie;

import com.airbnb.lottie.h;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class bx {

    /* renamed from: a  reason: collision with root package name */
    private final String f485a;

    /* renamed from: b  reason: collision with root package name */
    private final int f486b;

    /* renamed from: c  reason: collision with root package name */
    private final h f487c;

    private bx(String str, int i, h hVar) {
        this.f485a = str;
        this.f486b = i;
        this.f487c = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static bx a(JSONObject jSONObject, aw awVar) {
            return new bx(jSONObject.optString("nm"), jSONObject.optInt("ind"), h.a.a(jSONObject.optJSONObject("ks"), awVar));
        }
    }

    public String a() {
        return this.f485a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h b() {
        return this.f487c;
    }

    public String toString() {
        return "ShapePath{name=" + this.f485a + ", index=" + this.f486b + ", hasAnimation=" + this.f487c.e() + '}';
    }
}

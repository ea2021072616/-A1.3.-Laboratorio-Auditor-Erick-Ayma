package com.airbnb.lottie;

import com.airbnb.lottie.b;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeTrimPath.java */
/* loaded from: classes.dex */
public class bz {

    /* renamed from: a  reason: collision with root package name */
    private final String f499a;

    /* renamed from: b  reason: collision with root package name */
    private final b f500b;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.b f501c;
    private final com.airbnb.lottie.b d;
    private final com.airbnb.lottie.b e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeTrimPath.java */
    /* loaded from: classes.dex */
    public enum b {
        Simultaneously,
        Individually;

        static b a(int i) {
            switch (i) {
                case 1:
                    return Simultaneously;
                case 2:
                    return Individually;
                default:
                    throw new IllegalArgumentException("Unknown trim path type " + i);
            }
        }
    }

    private bz(String str, b bVar, com.airbnb.lottie.b bVar2, com.airbnb.lottie.b bVar3, com.airbnb.lottie.b bVar4) {
        this.f499a = str;
        this.f500b = bVar;
        this.f501c = bVar2;
        this.d = bVar3;
        this.e = bVar4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeTrimPath.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static bz a(JSONObject jSONObject, aw awVar) {
            return new bz(jSONObject.optString("nm"), b.a(jSONObject.optInt("m", 1)), b.a.a(jSONObject.optJSONObject("s"), awVar, false), b.a.a(jSONObject.optJSONObject("e"), awVar, false), b.a.a(jSONObject.optJSONObject("o"), awVar, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f499a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b() {
        return this.f500b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b d() {
        return this.f501c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.b e() {
        return this.e;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f501c + ", end: " + this.d + ", offset: " + this.e + "}";
    }
}

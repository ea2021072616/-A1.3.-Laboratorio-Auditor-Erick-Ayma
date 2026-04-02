package com.airbnb.lottie;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;
/* compiled from: LottieImageAsset.java */
/* loaded from: classes.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private final int f428a;

    /* renamed from: b  reason: collision with root package name */
    private final int f429b;

    /* renamed from: c  reason: collision with root package name */
    private final String f430c;
    private final String d;

    private ay(int i, int i2, String str, String str2) {
        this.f428a = i;
        this.f429b = i2;
        this.f430c = str;
        this.d = str2;
    }

    /* compiled from: LottieImageAsset.java */
    /* loaded from: classes.dex */
    static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ay a(JSONObject jSONObject) {
            return new ay(jSONObject.optInt("w"), jSONObject.optInt("h"), jSONObject.optString("id"), jSONObject.optString(TtmlNode.TAG_P));
        }
    }

    public String a() {
        return this.f430c;
    }

    public String b() {
        return this.d;
    }
}

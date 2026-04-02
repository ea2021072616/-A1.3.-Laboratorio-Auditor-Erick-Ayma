package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircleShape.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private final String f552a;

    /* renamed from: b  reason: collision with root package name */
    private final k<PointF> f553b;

    /* renamed from: c  reason: collision with root package name */
    private final f f554c;

    private s(String str, k<PointF> kVar, f fVar) {
        this.f552a = str;
        this.f553b = kVar;
        this.f554c = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircleShape.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static s a(JSONObject jSONObject, aw awVar) {
            return new s(jSONObject.optString("nm"), e.a(jSONObject.optJSONObject(TtmlNode.TAG_P), awVar), f.a.a(jSONObject.optJSONObject("s"), awVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f552a;
    }

    public k<PointF> b() {
        return this.f553b;
    }

    public f c() {
        return this.f554c;
    }
}

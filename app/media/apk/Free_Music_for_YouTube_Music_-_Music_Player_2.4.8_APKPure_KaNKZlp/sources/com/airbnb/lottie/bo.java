package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.b;
import com.airbnb.lottie.f;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public class bo {

    /* renamed from: a  reason: collision with root package name */
    private final String f465a;

    /* renamed from: b  reason: collision with root package name */
    private final k<PointF> f466b;

    /* renamed from: c  reason: collision with root package name */
    private final f f467c;
    private final b d;

    private bo(String str, k<PointF> kVar, f fVar, b bVar) {
        this.f465a = str;
        this.f466b = kVar;
        this.f467c = fVar;
        this.d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RectangleShape.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static bo a(JSONObject jSONObject, aw awVar) {
            return new bo(jSONObject.optString("nm"), e.a(jSONObject.optJSONObject(TtmlNode.TAG_P), awVar), f.a.a(jSONObject.optJSONObject("s"), awVar), b.a.a(jSONObject.optJSONObject("r"), awVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f465a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f c() {
        return this.f467c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k<PointF> d() {
        return this.f466b;
    }

    public String toString() {
        return "RectangleShape{cornerRadius=" + this.d.d() + ", position=" + this.f466b + ", size=" + this.f467c + '}';
    }
}

package com.airbnb.lottie;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import com.airbnb.lottie.az;
import com.airbnb.lottie.j;
import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Layer.java */
/* loaded from: classes.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private static final String f409a = av.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final List<Object> f410b;

    /* renamed from: c  reason: collision with root package name */
    private final aw f411c;
    private final String d;
    private final long e;
    private final b f;
    private final long g;
    @Nullable
    private final String h;
    private final List<az> i;
    private final j j;
    private final int k;
    private final int l;
    private final int m;
    private final float n;
    private final float o;
    private final int p;
    private final int q;
    private final List<at<Float>> r;
    private final c s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Layer.java */
    /* loaded from: classes.dex */
    public enum b {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Layer.java */
    /* loaded from: classes.dex */
    public enum c {
        None,
        Add,
        Invert,
        Unknown
    }

    private av(List<Object> list, aw awVar, String str, long j, b bVar, long j2, @Nullable String str2, List<az> list2, j jVar, int i, int i2, int i3, float f, float f2, int i4, int i5, List<at<Float>> list3, c cVar) {
        this.f410b = list;
        this.f411c = awVar;
        this.d = str;
        this.e = j;
        this.f = bVar;
        this.g = j2;
        this.h = str2;
        this.i = list2;
        this.j = jVar;
        this.k = i;
        this.l = i2;
        this.m = i3;
        this.n = f;
        this.o = f2;
        this.p = i4;
        this.q = i5;
        this.r = list3;
        this.s = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<at<Float>> b() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String e() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<az> h() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c j() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long k() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Object> l() {
        return this.f410b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j m() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.k;
    }

    public String toString() {
        return a("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(d()).append("\n");
        av a2 = this.f411c.a(k());
        if (a2 != null) {
            sb.append("\t\tParents: ").append(a2.d());
            av a3 = this.f411c.a(a2.k());
            while (a3 != null) {
                sb.append("->").append(a3.d());
                a3 = this.f411c.a(a3.k());
            }
            sb.append(str).append("\n");
        }
        if (!h().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(h().size()).append("\n");
        }
        if (p() != 0 && o() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(p()), Integer.valueOf(o()), Integer.valueOf(n())));
        }
        if (!this.f410b.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (Object obj : this.f410b) {
                sb.append(str).append("\t\t").append(obj).append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Layer.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static av a(aw awVar) {
            Rect a2 = awVar.a();
            return new av(Collections.emptyList(), awVar, null, -1L, b.PreComp, -1L, null, Collections.emptyList(), j.a.a(), 0, 0, 0, 0.0f, 0.0f, a2.width(), a2.height(), Collections.emptyList(), c.None);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static av a(JSONObject jSONObject, aw awVar) {
            b bVar;
            String optString = jSONObject.optString("nm");
            String optString2 = jSONObject.optString("refId");
            long optLong = jSONObject.optLong("ind");
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int optInt = jSONObject.optInt("ty", -1);
            if (optInt < b.Unknown.ordinal()) {
                bVar = b.values()[optInt];
            } else {
                bVar = b.Unknown;
            }
            long optLong2 = jSONObject.optLong("parent", -1L);
            if (bVar == b.Solid) {
                i = (int) (jSONObject.optInt("sw") * awVar.g());
                i2 = (int) (jSONObject.optInt("sh") * awVar.g());
                i3 = Color.parseColor(jSONObject.optString("sc"));
            }
            j a2 = j.a.a(jSONObject.optJSONObject("ks"), awVar);
            c cVar = c.values()[jSONObject.optInt(TtmlNode.TAG_TT)];
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("masksProperties");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    arrayList2.add(az.a.a(optJSONArray.optJSONObject(i6), awVar));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("shapes");
            if (optJSONArray2 != null) {
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    Object a3 = bu.a(optJSONArray2.optJSONObject(i7), awVar);
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
            }
            float optDouble = (float) jSONObject.optDouble("sr", 1.0d);
            float optDouble2 = ((float) jSONObject.optDouble(UserDataStore.STATE)) / awVar.f();
            if (bVar == b.PreComp) {
                i4 = (int) (jSONObject.optInt("w") * awVar.g());
                i5 = (int) (jSONObject.optInt("h") * awVar.g());
            }
            float optLong3 = (float) jSONObject.optLong(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            float optLong4 = (float) jSONObject.optLong("op");
            if (optLong3 > 0.0f) {
                arrayList3.add(new at(awVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            }
            if (optLong4 <= 0.0f) {
                optLong4 = (float) (awVar.c() + 1);
            }
            arrayList3.add(new at(awVar, Float.valueOf(1.0f), Float.valueOf(1.0f), null, optLong3, Float.valueOf(optLong4)));
            if (optLong4 <= awVar.f()) {
                arrayList3.add(new at(awVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, optLong4, Float.valueOf((float) awVar.c())));
            }
            return new av(arrayList, awVar, optString, optLong, bVar, optLong2, optString2, arrayList2, a2, i, i2, i3, optDouble, optDouble2, i4, i5, arrayList3, cVar);
        }
    }
}

package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.av;
import com.airbnb.lottie.ay;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* compiled from: LottieComposition.java */
/* loaded from: classes.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, List<av>> f418a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, ay> f419b;

    /* renamed from: c  reason: collision with root package name */
    private final LongSparseArray<av> f420c;
    private final List<av> d;
    private final Rect e;
    private final long f;
    private final long g;
    private final int h;
    private final float i;

    private aw(Rect rect, long j, long j2, int i, float f) {
        this.f418a = new HashMap();
        this.f419b = new HashMap();
        this.f420c = new LongSparseArray<>();
        this.d = new ArrayList();
        this.e = rect;
        this.f = j;
        this.g = j2;
        this.h = i;
        this.i = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public av a(long j) {
        return this.f420c.get(j);
    }

    public Rect a() {
        return this.e;
    }

    public long b() {
        return (((float) (this.g - this.f)) / this.h) * 1000.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<av> d() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public List<av> a(String str) {
        return this.f418a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, ay> e() {
        return this.f419b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return (((float) b()) * this.h) / 1000.0f;
    }

    public float g() {
        return this.i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (av avVar : this.d) {
            sb.append(avVar.a("\t"));
        }
        return sb.toString();
    }

    /* compiled from: LottieComposition.java */
    /* loaded from: classes.dex */
    public static class a {
        public static q a(Context context, String str, bf bfVar) {
            try {
                return a(context, context.getAssets().open(str), bfVar);
            } catch (IOException e) {
                throw new IllegalStateException("Unable to find file " + str, e);
            }
        }

        public static q a(Context context, InputStream inputStream, bf bfVar) {
            ac acVar = new ac(context.getResources(), bfVar);
            acVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[]{inputStream});
            return acVar;
        }

        public static q a(Resources resources, JSONObject jSONObject, bf bfVar) {
            ar arVar = new ar(resources, bfVar);
            arVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[]{jSONObject});
            return arVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static aw a(Resources resources, InputStream inputStream) {
            try {
                try {
                    try {
                        byte[] bArr = new byte[inputStream.available()];
                        inputStream.read(bArr);
                        return a(resources, new JSONObject(new String(bArr, C.UTF8_NAME)));
                    } catch (JSONException e) {
                        throw new IllegalStateException("Unable to load JSON.", e);
                    }
                } catch (IOException e2) {
                    throw new IllegalStateException("Unable to find file.", e2);
                }
            } finally {
                ch.a(inputStream);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static aw a(Resources resources, JSONObject jSONObject) {
            float f = resources.getDisplayMetrics().density;
            int optInt = jSONObject.optInt("w", -1);
            int optInt2 = jSONObject.optInt("h", -1);
            aw awVar = new aw((optInt == -1 || optInt2 == -1) ? null : new Rect(0, 0, (int) (optInt * f), (int) (optInt2 * f)), jSONObject.optLong(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, 0L), jSONObject.optLong("op", 0L), jSONObject.optInt("fr", 0), f);
            JSONArray optJSONArray = jSONObject.optJSONArray("assets");
            b(optJSONArray, awVar);
            a(optJSONArray, awVar);
            a(jSONObject, awVar);
            return awVar;
        }

        private static void a(JSONObject jSONObject, aw awVar) {
            JSONArray optJSONArray = jSONObject.optJSONArray("layers");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    a(awVar.d, awVar.f420c, av.a.a(optJSONArray.optJSONObject(i), awVar));
                }
            }
        }

        private static void a(@Nullable JSONArray jSONArray, aw awVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("layers");
                    if (optJSONArray != null) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        LongSparseArray longSparseArray = new LongSparseArray();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            av a2 = av.a.a(optJSONArray.optJSONObject(i2), awVar);
                            longSparseArray.put(a2.c(), a2);
                            arrayList.add(a2);
                        }
                        awVar.f418a.put(optJSONObject.optString("id"), arrayList);
                    }
                }
            }
        }

        private static void b(@Nullable JSONArray jSONArray, aw awVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject.has(TtmlNode.TAG_P)) {
                        ay a2 = ay.a.a(optJSONObject);
                        awVar.f419b.put(a2.a(), a2);
                    }
                }
            }
        }

        private static void a(List<av> list, LongSparseArray<av> longSparseArray, av avVar) {
            list.add(avVar);
            longSparseArray.put(avVar.c(), avVar);
        }
    }
}

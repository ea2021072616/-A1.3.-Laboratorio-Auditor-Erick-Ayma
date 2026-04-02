package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.AdNetwork;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.util.ai;
import com.facebook.ads.internal.util.al;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.f;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l extends v implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1205a = l.class.getSimpleName();
    private NativeAd.Image A;
    private String B;
    private String C;
    private NativeAdViewAttributes D;
    private List<NativeAd> E;
    private int F;
    private int G;
    private String H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private long N = 0;
    private b.a O = null;
    @Nullable
    private com.facebook.ads.internal.g.f P;

    /* renamed from: b  reason: collision with root package name */
    private Context f1206b;

    /* renamed from: c  reason: collision with root package name */
    private w f1207c;
    private Uri d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private NativeAd.Image j;
    private NativeAd.Image k;
    private NativeAd.Rating l;
    private String m;
    private com.facebook.ads.internal.util.e n;
    private Collection<String> o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private String w;
    private String x;
    private ai y;
    private String z;

    private boolean F() {
        return this.e != null && this.e.length() > 0 && this.h != null && this.h.length() > 0 && (this.j != null || this.I) && this.k != null;
    }

    private void G() {
        if (this.M) {
            return;
        }
        if (this.P != null) {
            this.P.a(this.m);
        }
        this.M = true;
    }

    private void a(Context context, JSONObject jSONObject, com.facebook.ads.internal.g.f fVar, String str, int i, int i2) {
        this.I = true;
        this.f1206b = context;
        this.P = fVar;
        this.F = i;
        this.G = i2;
        a(jSONObject, str);
    }

    private void a(Map<String, String> map, final Map<String, String> map2) {
        try {
            final Map<String, String> c2 = c(map);
            new Handler().postDelayed(new Runnable() { // from class: com.facebook.ads.internal.adapters.l.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(l.this.H)) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(map2);
                    hashMap.putAll(c2);
                    if (l.this.P != null) {
                        l.this.P.d(l.this.H, hashMap);
                    }
                }
            }, this.s * 1000);
        } catch (Exception e) {
        }
    }

    private void a(JSONObject jSONObject, String str) {
        JSONArray jSONArray = null;
        if (this.J) {
            throw new IllegalStateException("Adapter already loaded data");
        }
        if (jSONObject == null) {
            return;
        }
        com.facebook.ads.internal.util.g.a(this.f1206b, "Audience Network Loaded");
        this.H = str;
        this.d = Uri.parse(com.facebook.ads.internal.util.g.a(jSONObject, "fbad_command"));
        this.e = com.facebook.ads.internal.util.g.a(jSONObject, "title");
        this.f = com.facebook.ads.internal.util.g.a(jSONObject, MessengerShareContentUtility.SUBTITLE);
        this.g = com.facebook.ads.internal.util.g.a(jSONObject, TtmlNode.TAG_BODY);
        this.h = com.facebook.ads.internal.util.g.a(jSONObject, "call_to_action");
        this.i = com.facebook.ads.internal.util.g.a(jSONObject, "social_context");
        this.j = NativeAd.Image.fromJSONObject(jSONObject.optJSONObject("icon"));
        this.k = NativeAd.Image.fromJSONObject(jSONObject.optJSONObject(MessengerShareContentUtility.MEDIA_IMAGE));
        this.l = NativeAd.Rating.fromJSONObject(jSONObject.optJSONObject("star_rating"));
        this.m = com.facebook.ads.internal.util.g.a(jSONObject, "used_report_url");
        this.p = jSONObject.optBoolean("manual_imp");
        this.q = jSONObject.optBoolean("enable_view_log");
        this.r = jSONObject.optBoolean("enable_snapshot_log");
        this.s = jSONObject.optInt("snapshot_log_delay_second", 4);
        this.t = jSONObject.optInt("snapshot_compress_quality", 0);
        this.u = jSONObject.optInt("viewability_check_initial_delay", 0);
        this.v = jSONObject.optInt("viewability_check_interval", 1000);
        JSONObject optJSONObject = jSONObject.optJSONObject("ad_choices_icon");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("native_ui_config");
        this.D = (optJSONObject2 == null || optJSONObject2.length() == 0) ? null : new NativeAdViewAttributes(optJSONObject2);
        if (optJSONObject != null) {
            this.A = NativeAd.Image.fromJSONObject(optJSONObject);
        }
        this.B = com.facebook.ads.internal.util.g.a(jSONObject, "ad_choices_link_url");
        this.C = com.facebook.ads.internal.util.g.a(jSONObject, "request_id");
        this.n = com.facebook.ads.internal.util.e.a(jSONObject.optString("invalidation_behavior"));
        try {
            jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
        } catch (JSONException e) {
            ThrowableExtension.printStackTrace(e);
        }
        this.o = com.facebook.ads.internal.util.f.a(jSONArray);
        this.w = com.facebook.ads.internal.util.g.a(jSONObject, "video_url");
        this.x = com.facebook.ads.internal.util.g.a(jSONObject, "video_mpd");
        if (jSONObject.has("video_autoplay_enabled")) {
            this.y = jSONObject.optBoolean("video_autoplay_enabled") ? ai.ON : ai.OFF;
        } else {
            this.y = ai.UNKNOWN;
        }
        this.z = com.facebook.ads.internal.util.g.a(jSONObject, "video_report_url");
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("carousel");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    l lVar = new l();
                    lVar.a(this.f1206b, optJSONArray.getJSONObject(i), this.P, str, i, length);
                    arrayList.add(new NativeAd(this.f1206b, lVar, null));
                }
                this.E = arrayList;
            }
        } catch (JSONException e2) {
            Log.e(f1205a, "Unable to parse carousel data.", e2);
        }
        this.J = true;
        this.K = F();
    }

    private Map<String, String> c(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey("view")) {
            hashMap.put("view", map.get("view"));
        }
        if (map.containsKey("snapshot")) {
            hashMap.put("snapshot", map.get("snapshot"));
        }
        return hashMap;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public List<NativeAd> A() {
        if (b()) {
            return this.E;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String B() {
        return this.H;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public AdNetwork C() {
        return AdNetwork.AN;
    }

    @Override // com.facebook.ads.internal.util.f.a
    public com.facebook.ads.internal.util.e D() {
        return this.n;
    }

    @Override // com.facebook.ads.internal.util.f.a
    public Collection<String> E() {
        return this.o;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public void a() {
    }

    @Override // com.facebook.ads.internal.adapters.v
    public void a(int i) {
        if (b() && i == 0 && this.N > 0 && this.O != null) {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(this.N, this.O, this.C));
            this.N = 0L;
            this.O = null;
        }
    }

    @Override // com.facebook.ads.internal.adapters.v
    public void a(Context context, w wVar, com.facebook.ads.internal.g.f fVar, Map<String, Object> map) {
        this.f1206b = context;
        this.f1207c = wVar;
        this.P = fVar;
        JSONObject jSONObject = (JSONObject) map.get(ShareConstants.WEB_DIALOG_PARAM_DATA);
        a(jSONObject, com.facebook.ads.internal.util.g.a(jSONObject, UserDataStore.CITY));
        if (com.facebook.ads.internal.util.f.a(context, this)) {
            wVar.a(this, AdError.NO_FILL);
            return;
        }
        if (wVar != null) {
            wVar.a(this);
        }
        com.facebook.ads.internal.util.b.f1510a = this.C;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public void a(View view, List<View> list) {
    }

    @Override // com.facebook.ads.internal.adapters.v
    public void a(w wVar) {
        this.f1207c = wVar;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public void a(Map<String, String> map) {
        if (b() && !this.L) {
            if (this.f1207c != null) {
                this.f1207c.b(this);
            }
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (this.I) {
                hashMap.put("cardind", String.valueOf(this.F));
                hashMap.put("cardcnt", String.valueOf(this.G));
            }
            if (!TextUtils.isEmpty(B()) && this.P != null) {
                this.P.a(B(), hashMap);
            }
            if (e() || d()) {
                a(map, hashMap);
            }
            this.L = true;
        }
    }

    @Override // com.facebook.ads.internal.adapters.v
    public void b(Map<String, String> map) {
        if (b()) {
            if (com.facebook.ads.internal.h.b(this.f1206b) && al.b(map)) {
                Log.e(f1205a, "Click happened on lockscreen ad");
                return;
            }
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            com.facebook.ads.internal.util.g.a(this.f1206b, "Click logged");
            if (this.f1207c != null) {
                this.f1207c.c(this);
            }
            if (this.I) {
                hashMap.put("cardind", String.valueOf(this.F));
                hashMap.put("cardcnt", String.valueOf(this.G));
            }
            com.facebook.ads.internal.a.a a2 = com.facebook.ads.internal.a.b.a(this.f1206b, this.H, this.d, hashMap);
            if (a2 != null) {
                try {
                    this.N = System.currentTimeMillis();
                    this.O = a2.a();
                    a2.b();
                } catch (Exception e) {
                    Log.e(f1205a, "Error executing action", e);
                }
            }
        }
    }

    @Override // com.facebook.ads.internal.adapters.v
    public boolean b() {
        return this.J && this.K;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public boolean c() {
        return b() && this.p;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public boolean d() {
        return b() && this.r;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public boolean e() {
        return b() && this.q;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public boolean f() {
        return b() && this.D != null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public boolean g() {
        return true;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public int h() {
        if (this.t < 0 || this.t > 100) {
            return 0;
        }
        return this.t;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public int i() {
        return this.u;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public int j() {
        return this.v;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public NativeAd.Image k() {
        if (b()) {
            return this.j;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public NativeAd.Image l() {
        if (b()) {
            return this.k;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public NativeAdViewAttributes m() {
        if (b()) {
            return this.D;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String n() {
        if (b()) {
            G();
            return this.e;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String o() {
        if (b()) {
            G();
            return this.f;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.AdAdapter
    public void onDestroy() {
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String p() {
        if (b()) {
            G();
            return this.g;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String q() {
        if (b()) {
            G();
            return this.h;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String r() {
        if (b()) {
            G();
            return this.i;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public NativeAd.Rating s() {
        if (b()) {
            G();
            return this.l;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public NativeAd.Image t() {
        if (b()) {
            return this.A;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String u() {
        if (b()) {
            return this.B;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String v() {
        if (b()) {
            return "AdChoices";
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String w() {
        if (b()) {
            return this.w;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String x() {
        if (b()) {
            return this.x;
        }
        return null;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public ai y() {
        return !b() ? ai.UNKNOWN : this.y;
    }

    @Override // com.facebook.ads.internal.adapters.v
    public String z() {
        return this.z;
    }
}

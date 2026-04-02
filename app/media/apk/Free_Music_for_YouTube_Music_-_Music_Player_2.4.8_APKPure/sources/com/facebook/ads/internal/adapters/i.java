package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.ab;
import com.facebook.ads.internal.util.ad;
import com.facebook.ads.internal.util.ah;
import com.facebook.ads.internal.view.d.b.d;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i extends r implements ad<Bundle> {
    static final /* synthetic */ boolean d;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    protected com.facebook.ads.internal.view.n f1188a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    protected JSONObject f1189b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    protected Context f1190c;
    @Nullable
    private com.facebook.ads.a.a i;
    @Nullable
    private com.facebook.ads.internal.g.f j;
    @Nullable
    private String k;
    @Nullable
    private ah m;
    @Nullable
    private String n;
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.b> e = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.b>() { // from class: com.facebook.ads.internal.adapters.i.1
        @Override // com.facebook.ads.internal.g.s
        public Class<com.facebook.ads.internal.view.d.a.b> a() {
            return com.facebook.ads.internal.view.d.a.b.class;
        }

        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.b bVar) {
            if (i.this.i == null) {
                return;
            }
            i.this.i.d(i.this);
        }
    };
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.l> f = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.l>() { // from class: com.facebook.ads.internal.adapters.i.2
        @Override // com.facebook.ads.internal.g.s
        public Class<com.facebook.ads.internal.view.d.a.l> a() {
            return com.facebook.ads.internal.view.d.a.l.class;
        }

        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.l lVar) {
            if (i.this.i == null) {
                return;
            }
            i.this.l = true;
            i.this.i.a(i.this);
        }
    };
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.d> g = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.d>() { // from class: com.facebook.ads.internal.adapters.i.3
        @Override // com.facebook.ads.internal.g.s
        public Class<com.facebook.ads.internal.view.d.a.d> a() {
            return com.facebook.ads.internal.view.d.a.d.class;
        }

        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.d dVar) {
            if (i.this.i == null) {
                return;
            }
            i.this.i.a(i.this, AdError.INTERNAL_ERROR);
        }
    };
    private final com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.a> h = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.a>() { // from class: com.facebook.ads.internal.adapters.i.4
        @Override // com.facebook.ads.internal.g.s
        public Class<com.facebook.ads.internal.view.d.a.a> a() {
            return com.facebook.ads.internal.view.d.a.a.class;
        }

        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.a aVar) {
            if (i.this.i != null) {
                i.this.i.b(i.this);
            }
            if (i.this.j != null) {
                i.this.j.b(i.this.n, new HashMap());
            }
        }
    };
    private boolean l = false;

    static {
        d = !i.class.desiredAssertionStatus();
    }

    private void a(Context context, com.facebook.ads.a.a aVar, JSONObject jSONObject, com.facebook.ads.internal.g.f fVar, @Nullable Bundle bundle) {
        this.f1190c = context;
        this.i = aVar;
        this.j = fVar;
        this.f1189b = jSONObject;
        this.l = false;
        JSONObject jSONObject2 = jSONObject.getJSONObject("video");
        this.n = jSONObject.optString(UserDataStore.CITY);
        this.k = jSONObject2.getString(AudienceNetworkActivity.VIDEO_URL);
        this.f1188a = new com.facebook.ads.internal.view.n(context);
        a();
        this.f1188a.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.e);
        this.f1188a.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.g);
        this.f1188a.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f);
        this.f1188a.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.h);
        if (bundle != null) {
            this.m = new ab(context, fVar, this.f1188a, this.n, bundle.getBundle("logger"));
        } else {
            this.m = new ab(context, fVar, this.f1188a, this.n);
        }
        this.i.a(this, this.f1188a);
        this.f1188a.setVideoURI(this.k);
    }

    protected void a() {
        if (!d && this.f1190c == null) {
            throw new AssertionError();
        }
        if (!d && this.f1189b == null) {
            throw new AssertionError();
        }
        JSONObject jSONObject = this.f1189b.getJSONObject("video");
        JSONObject optJSONObject = this.f1189b.optJSONObject(MimeTypes.BASE_TYPE_TEXT);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        this.f1188a.a(new com.facebook.ads.internal.view.d.b.j(this.f1190c));
        com.facebook.ads.internal.view.d.b.k kVar = new com.facebook.ads.internal.view.d.b.k(this.f1190c);
        this.f1188a.a(kVar);
        this.f1188a.a(new com.facebook.ads.internal.view.d.b.d(kVar, d.a.INVSIBLE));
        this.f1188a.a(new com.facebook.ads.internal.view.d.b.b(this.f1190c));
        String b2 = b();
        if (b2 != null) {
            com.facebook.ads.internal.view.d.b.c cVar = new com.facebook.ads.internal.view.d.b.c(this.f1190c, b2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            cVar.setLayoutParams(layoutParams);
            cVar.setCountdownTextColor(-1);
            this.f1188a.a(cVar);
        }
        if (jSONObject.has("destinationURL") && !jSONObject.isNull("destinationURL")) {
            String string = jSONObject.getString("destinationURL");
            if (!TextUtils.isEmpty(string)) {
                com.facebook.ads.internal.view.d.b.e eVar = new com.facebook.ads.internal.view.d.b.e(this.f1190c, string, this.n, optJSONObject.optString("learnMore", "Learn More"));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(10);
                layoutParams2.addRule(11);
                eVar.setLayoutParams(layoutParams2);
                this.f1188a.a(eVar);
            }
        }
        this.f1188a.a(new com.facebook.ads.internal.view.d.b.a(this.f1190c, "http://m.facebook.com/ads/ad_choices", this.n, new float[]{0.0f, 0.0f, 8.0f, 0.0f}));
        int c2 = c();
        if (c2 > 0) {
            com.facebook.ads.internal.view.d.b.h hVar = new com.facebook.ads.internal.view.d.b.h(this.f1190c, c2, optJSONObject.optString("skipAdIn", "Skip Ad in"), optJSONObject.optString("skipAd", "Skip Ad"));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(12);
            layoutParams3.addRule(11);
            hVar.setLayoutParams(layoutParams3);
            hVar.setPadding(0, 0, 0, 30);
            this.f1188a.a(hVar);
        }
    }

    public final void a(Context context, com.facebook.ads.a.a aVar, com.facebook.ads.internal.g.f fVar, Bundle bundle) {
        try {
            a(context, aVar, new JSONObject(bundle.getString("ad_response")), fVar, bundle);
        } catch (JSONException e) {
            aVar.a(this, AdError.INTERNAL_ERROR);
        }
    }

    @Override // com.facebook.ads.internal.adapters.r
    public final void a(Context context, com.facebook.ads.a.a aVar, Map<String, Object> map, com.facebook.ads.internal.g.f fVar) {
        try {
            a(context, aVar, (JSONObject) map.get(ShareConstants.WEB_DIALOG_PARAM_DATA), fVar, null);
        } catch (JSONException e) {
            aVar.a(this, AdError.INTERNAL_ERROR);
        }
    }

    protected String b() {
        if (d || this.f1189b != null) {
            try {
                JSONObject jSONObject = this.f1189b.getJSONObject("capabilities");
                if (!jSONObject.has("countdown") || jSONObject.isNull("countdown")) {
                    return null;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("countdown");
                if (jSONObject2.has(IjkMediaMeta.IJKM_KEY_FORMAT)) {
                    return jSONObject2.optString(IjkMediaMeta.IJKM_KEY_FORMAT);
                }
                return null;
            } catch (Exception e) {
                Log.w(String.valueOf(i.class), "Invalid JSON", e);
                return null;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        if (d || this.f1189b != null) {
            try {
                JSONObject jSONObject = this.f1189b.getJSONObject("capabilities");
                if (!jSONObject.has("skipButton") || jSONObject.isNull("skipButton")) {
                    return -1;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("skipButton");
                if (jSONObject2.has("skippableSeconds")) {
                    return jSONObject2.getInt("skippableSeconds");
                }
                return -1;
            } catch (Exception e) {
                Log.w(String.valueOf(i.class), "Invalid JSON", e);
                return -1;
            }
        }
        throw new AssertionError();
    }

    @Override // com.facebook.ads.internal.adapters.r
    public boolean d() {
        if (!this.l || this.f1188a == null) {
            return false;
        }
        if (this.m.k() > 0) {
            this.f1188a.a(this.m.k());
            this.f1188a.d();
        } else {
            this.f1188a.d();
            e();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        if (this.j == null) {
            return;
        }
        this.j.a(this.n, new HashMap());
        if (this.i != null) {
            this.i.c(this);
        }
    }

    @Override // com.facebook.ads.internal.util.ad
    public Bundle getSaveInstanceState() {
        if (this.m == null || this.f1189b == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("logger", this.m.getSaveInstanceState());
        bundle.putString("ad_response", this.f1189b.toString());
        return bundle;
    }

    @Override // com.facebook.ads.internal.adapters.AdAdapter
    public void onDestroy() {
        if (this.f1188a != null) {
            this.f1188a.g();
        }
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.n = null;
        this.f1188a = null;
        this.m = null;
        this.f1189b = null;
        this.f1190c = null;
    }
}

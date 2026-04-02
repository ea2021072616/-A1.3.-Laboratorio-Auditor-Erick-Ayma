package com.facebook.ads.internal.adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends InterstitialAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<String, com.facebook.ads.internal.view.d> f1195a = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private Context f1197c;
    private s d;
    private InterstitialAdapterListener e;
    private o g;
    private a h;

    /* renamed from: b  reason: collision with root package name */
    private final String f1196b = UUID.randomUUID().toString();
    private boolean f = false;

    /* loaded from: classes.dex */
    public enum a {
        UNSPECIFIED,
        VERTICAL,
        HORIZONTAL;

        public static a a(int i) {
            return i == 0 ? UNSPECIFIED : i == 2 ? HORIZONTAL : VERTICAL;
        }
    }

    public static com.facebook.ads.internal.view.d a(String str) {
        return f1195a.get(str);
    }

    public static void a(com.facebook.ads.internal.view.d dVar) {
        for (Map.Entry<String, com.facebook.ads.internal.view.d> entry : f1195a.entrySet()) {
            if (entry.getValue() == dVar) {
                f1195a.remove(entry.getKey());
            }
        }
    }

    private int b() {
        int rotation = ((WindowManager) this.f1197c.getSystemService("window")).getDefaultDisplay().getRotation();
        if (this.h == a.UNSPECIFIED) {
            return -1;
        }
        if (this.h == a.HORIZONTAL) {
            switch (rotation) {
                case 2:
                case 3:
                    return 8;
                default:
                    return 0;
            }
        }
        switch (rotation) {
            case 2:
                return 9;
            default:
                return 1;
        }
    }

    @Override // com.facebook.ads.internal.adapters.InterstitialAdapter
    public void loadInterstitialAd(Context context, InterstitialAdapterListener interstitialAdapterListener, Map<String, Object> map, com.facebook.ads.internal.g.f fVar) {
        this.f1197c = context;
        this.e = interstitialAdapterListener;
        JSONObject jSONObject = (JSONObject) map.get(ShareConstants.WEB_DIALOG_PARAM_DATA);
        if (!jSONObject.has("markup")) {
            this.d = new s(context, this.f1196b, this, this.e);
            this.d.a();
            final k kVar = new k();
            kVar.a(context, new com.facebook.ads.a.a() { // from class: com.facebook.ads.internal.adapters.j.1
                @Override // com.facebook.ads.a.a
                public void a(r rVar) {
                    j.this.f = true;
                    if (j.this.e == null) {
                        return;
                    }
                    j.this.e.onInterstitialAdLoaded(j.this);
                }

                @Override // com.facebook.ads.a.a
                public void a(r rVar, View view) {
                    j.this.h = kVar.i();
                    j.f1195a.put(j.this.f1196b, kVar);
                }

                @Override // com.facebook.ads.a.a
                public void a(r rVar, AdError adError) {
                    kVar.j();
                    j.this.e.onInterstitialError(j.this, adError);
                }

                @Override // com.facebook.ads.a.a
                public void b(r rVar) {
                    j.this.e.onInterstitialAdClicked(j.this, "", true);
                }

                @Override // com.facebook.ads.a.a
                public void c(r rVar) {
                    j.this.e.onInterstitialLoggingImpression(j.this);
                }

                @Override // com.facebook.ads.a.a
                public void d(r rVar) {
                }
            }, map, fVar);
            return;
        }
        this.g = o.a(jSONObject);
        if (com.facebook.ads.internal.util.f.a(context, this.g)) {
            interstitialAdapterListener.onInterstitialError(this, AdError.NO_FILL);
            return;
        }
        this.d = new s(context, this.f1196b, this, this.e);
        this.d.a();
        Map<String, String> c2 = this.g.c();
        if (c2.containsKey("orientation")) {
            this.h = a.a(Integer.parseInt(c2.get("orientation")));
        }
        this.f = true;
        if (this.e != null) {
            this.e.onInterstitialAdLoaded(this);
        }
    }

    @Override // com.facebook.ads.internal.adapters.AdAdapter
    public void onDestroy() {
        if (this.d != null) {
            this.d.b();
        }
    }

    @Override // com.facebook.ads.internal.adapters.InterstitialAdapter
    public boolean show() {
        if (!this.f) {
            if (this.e != null) {
                this.e.onInterstitialError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        }
        Intent intent = new Intent(this.f1197c, AudienceNetworkActivity.class);
        intent.putExtra(AudienceNetworkActivity.PREDEFINED_ORIENTATION_KEY, b());
        intent.putExtra(AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, this.f1196b);
        if (f1195a.containsKey(this.f1196b)) {
            intent.putExtra(AudienceNetworkActivity.VIEW_TYPE, AudienceNetworkActivity.Type.NATIVE);
        } else {
            intent.putExtra(AudienceNetworkActivity.VIEW_TYPE, AudienceNetworkActivity.Type.DISPLAY);
            this.g.a(intent);
        }
        intent.addFlags(268435456);
        try {
            this.f1197c.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setClass(this.f1197c, InterstitialAdActivity.class);
            this.f1197c.startActivity(intent);
        }
        return true;
    }
}

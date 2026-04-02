package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.view.c;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends BannerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1182a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private com.facebook.ads.internal.view.c f1183b;

    /* renamed from: c  reason: collision with root package name */
    private p f1184c;
    private BannerAdapterListener d;
    private Map<String, Object> e;
    private Context f;
    private long g;
    private b.a h;

    private void a(com.facebook.ads.internal.f.e eVar) {
        this.g = 0L;
        this.h = null;
        final o a2 = o.a((JSONObject) this.e.get(ShareConstants.WEB_DIALOG_PARAM_DATA));
        if (com.facebook.ads.internal.util.f.a(this.f, a2)) {
            this.d.onBannerError(this, AdError.NO_FILL);
            return;
        }
        this.f1183b = new com.facebook.ads.internal.view.c(this.f, new c.b() { // from class: com.facebook.ads.internal.adapters.h.1
            @Override // com.facebook.ads.internal.view.c.b
            public void a() {
                h.this.f1184c.b();
            }

            @Override // com.facebook.ads.internal.view.c.b
            public void a(int i) {
                if (i != 0 || h.this.g <= 0 || h.this.h == null) {
                    return;
                }
                com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(h.this.g, h.this.h, a2.d()));
                h.this.g = 0L;
                h.this.h = null;
            }

            @Override // com.facebook.ads.internal.view.c.b
            public void a(String str, Map<String, String> map) {
                Uri parse = Uri.parse(str);
                if ("fbad".equals(parse.getScheme()) && com.facebook.ads.internal.a.b.a(parse.getAuthority()) && h.this.d != null) {
                    h.this.d.onBannerAdClicked(h.this);
                }
                com.facebook.ads.internal.a.a a3 = com.facebook.ads.internal.a.b.a(h.this.f, a2.B(), parse, map);
                if (a3 != null) {
                    try {
                        h.this.h = a3.a();
                        h.this.g = System.currentTimeMillis();
                        a3.b();
                    } catch (Exception e) {
                        Log.e(h.f1182a, "Error executing action", e);
                    }
                }
            }

            @Override // com.facebook.ads.internal.view.c.b
            public void b() {
                if (h.this.f1184c != null) {
                    h.this.f1184c.a();
                }
            }
        }, eVar.e());
        this.f1183b.a(eVar.g(), eVar.h());
        this.f1184c = new p(this.f, this.f1183b, this.f1183b.getViewabilityChecker(), new b() { // from class: com.facebook.ads.internal.adapters.h.2
            @Override // com.facebook.ads.internal.adapters.b
            public void d() {
                if (h.this.d != null) {
                    h.this.d.onBannerLoggingImpression(h.this);
                }
            }
        });
        this.f1184c.a(a2);
        this.f1183b.loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), a2.a(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, null);
        if (this.d != null) {
            this.d.onBannerAdLoaded(this, this.f1183b);
        }
    }

    @Override // com.facebook.ads.internal.adapters.BannerAdapter
    public void loadBannerAd(Context context, AdSize adSize, BannerAdapterListener bannerAdapterListener, Map<String, Object> map) {
        this.f = context;
        this.d = bannerAdapterListener;
        this.e = map;
        a((com.facebook.ads.internal.f.e) map.get("definition"));
    }

    @Override // com.facebook.ads.internal.adapters.AdAdapter
    public void onDestroy() {
        if (this.f1183b != null) {
            com.facebook.ads.internal.util.h.a(this.f1183b);
            this.f1183b.destroy();
            this.f1183b = null;
        }
    }
}

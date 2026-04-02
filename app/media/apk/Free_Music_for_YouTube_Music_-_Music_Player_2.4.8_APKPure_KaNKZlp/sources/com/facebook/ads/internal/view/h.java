package com.facebook.ads.internal.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.view.c;
import com.facebook.ads.internal.view.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class h implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1737a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final d.a f1738b;

    /* renamed from: c  reason: collision with root package name */
    private final c f1739c;
    private final com.facebook.ads.internal.adapters.p d;
    private com.facebook.ads.internal.adapters.o e;
    private long f = System.currentTimeMillis();
    private long g;
    private b.a h;

    public h(final AudienceNetworkActivity audienceNetworkActivity, d.a aVar) {
        this.f1738b = aVar;
        this.f1739c = new c(audienceNetworkActivity, new c.b() { // from class: com.facebook.ads.internal.view.h.1
            @Override // com.facebook.ads.internal.view.c.b
            public void a() {
                h.this.d.b();
            }

            @Override // com.facebook.ads.internal.view.c.b
            public void a(int i) {
            }

            @Override // com.facebook.ads.internal.view.c.b
            public void a(String str, Map<String, String> map) {
                Uri parse = Uri.parse(str);
                if ("fbad".equals(parse.getScheme()) && "close".equals(parse.getAuthority())) {
                    audienceNetworkActivity.finish();
                    return;
                }
                if ("fbad".equals(parse.getScheme()) && com.facebook.ads.internal.a.b.a(parse.getAuthority())) {
                    h.this.f1738b.a("com.facebook.ads.interstitial.clicked");
                }
                com.facebook.ads.internal.a.a a2 = com.facebook.ads.internal.a.b.a(audienceNetworkActivity, h.this.e.B(), parse, map);
                if (a2 != null) {
                    try {
                        h.this.h = a2.a();
                        h.this.g = System.currentTimeMillis();
                        a2.b();
                    } catch (Exception e) {
                        Log.e(h.f1737a, "Error executing action", e);
                    }
                }
            }

            @Override // com.facebook.ads.internal.view.c.b
            public void b() {
                h.this.d.a();
            }
        }, 1);
        this.f1739c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.d = new com.facebook.ads.internal.adapters.p(audienceNetworkActivity, this.f1739c, this.f1739c.getViewabilityChecker(), new com.facebook.ads.internal.adapters.b() { // from class: com.facebook.ads.internal.view.h.2
            @Override // com.facebook.ads.internal.adapters.b
            public void d() {
                h.this.f1738b.a("com.facebook.ads.interstitial.impression.logged");
            }
        });
        aVar.a(this.f1739c);
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (bundle != null && bundle.containsKey("dataModel")) {
            this.e = com.facebook.ads.internal.adapters.o.a(bundle.getBundle("dataModel"));
            if (this.e != null) {
                this.f1739c.loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), this.e.a(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, null);
                this.f1739c.a(this.e.e(), this.e.f());
                return;
            }
            return;
        }
        this.e = com.facebook.ads.internal.adapters.o.b(intent);
        if (this.e != null) {
            this.d.a(this.e);
            this.f1739c.loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), this.e.a(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, null);
            this.f1739c.a(this.e.e(), this.e.f());
        }
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(Bundle bundle) {
        if (this.e != null) {
            bundle.putBundle("dataModel", this.e.g());
        }
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(d.a aVar) {
    }

    @Override // com.facebook.ads.internal.view.d
    public void g() {
        this.f1739c.onPause();
    }

    @Override // com.facebook.ads.internal.view.d
    public void h() {
        if (this.g > 0 && this.h != null && this.e != null) {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(this.g, this.h, this.e.d()));
        }
        this.f1739c.onResume();
    }

    @Override // com.facebook.ads.internal.view.d
    public void onDestroy() {
        if (this.e != null) {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(this.f, b.a.XOUT, this.e.d()));
            if (!TextUtils.isEmpty(this.e.B())) {
                HashMap hashMap = new HashMap();
                this.f1739c.getViewabilityChecker().a(hashMap);
                hashMap.put("touch", com.facebook.ads.internal.util.g.a(this.f1739c.getTouchData()));
                com.facebook.ads.internal.g.g.a(this.f1739c.getContext()).e(this.e.B(), hashMap);
            }
        }
        com.facebook.ads.internal.util.h.a(this.f1739c);
        this.f1739c.destroy();
    }
}

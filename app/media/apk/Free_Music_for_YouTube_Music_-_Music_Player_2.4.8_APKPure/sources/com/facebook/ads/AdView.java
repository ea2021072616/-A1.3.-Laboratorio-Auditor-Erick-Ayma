package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.a;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.b;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.g;
/* loaded from: classes.dex */
public class AdView extends RelativeLayout implements Ad {

    /* renamed from: a  reason: collision with root package name */
    private static final c f1030a = c.ADS;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMetrics f1031b;

    /* renamed from: c  reason: collision with root package name */
    private final AdSize f1032c;
    private final String d;
    private DisplayAdController e;
    private AdListener f;
    private View g;
    private volatile boolean h;

    public AdView(Context context, String str, AdSize adSize) {
        super(context);
        if (adSize == null || adSize == AdSize.INTERSTITIAL) {
            throw new IllegalArgumentException("adSize");
        }
        this.f1031b = getContext().getResources().getDisplayMetrics();
        this.f1032c = adSize;
        this.d = str;
        this.e = new DisplayAdController(context, str, g.a(adSize), AdPlacementType.BANNER, adSize, f1030a, 1, false);
        this.e.a(new a() { // from class: com.facebook.ads.AdView.1
            @Override // com.facebook.ads.internal.a
            public void a() {
                if (AdView.this.f != null) {
                    AdView.this.f.onAdClicked(AdView.this);
                }
            }

            @Override // com.facebook.ads.internal.a
            public void a(View view) {
                if (view == null) {
                    throw new IllegalStateException("Cannot present null view");
                }
                AdView.this.g = view;
                AdView.this.removeAllViews();
                AdView.this.addView(AdView.this.g);
                if (AdView.this.g instanceof com.facebook.ads.internal.view.c) {
                    g.a(AdView.this.f1031b, AdView.this.g, AdView.this.f1032c);
                }
                if (AdView.this.f != null) {
                    AdView.this.f.onAdLoaded(AdView.this);
                }
            }

            @Override // com.facebook.ads.internal.a
            public void a(AdAdapter adAdapter) {
                if (AdView.this.e != null) {
                    AdView.this.e.c();
                }
            }

            @Override // com.facebook.ads.internal.a
            public void a(b bVar) {
                if (AdView.this.f != null) {
                    AdView.this.f.onError(AdView.this, bVar.b());
                }
            }

            @Override // com.facebook.ads.internal.a
            public void b() {
                if (AdView.this.f != null) {
                    AdView.this.f.onLoggingImpression(AdView.this);
                }
            }
        });
    }

    @Override // com.facebook.ads.Ad
    public void destroy() {
        if (this.e != null) {
            this.e.d();
            this.e = null;
        }
        removeAllViews();
        this.g = null;
    }

    public void disableAutoRefresh() {
        if (this.e != null) {
            this.e.h();
        }
    }

    @Override // com.facebook.ads.Ad
    public String getPlacementId() {
        return this.d;
    }

    @Override // com.facebook.ads.Ad
    public void loadAd() {
        if (!this.h) {
            this.e.b();
            this.h = true;
        } else if (this.e != null) {
            this.e.g();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.g != null) {
            g.a(this.f1031b, this.g, this.f1032c);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.e == null) {
            return;
        }
        if (i == 0) {
            this.e.f();
        } else if (i == 8) {
            this.e.e();
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f = adListener;
    }
}

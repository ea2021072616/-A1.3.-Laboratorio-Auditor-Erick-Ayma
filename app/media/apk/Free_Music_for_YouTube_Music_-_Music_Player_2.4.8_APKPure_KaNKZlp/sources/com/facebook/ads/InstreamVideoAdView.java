package com.facebook.ads;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.a;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.i;
import com.facebook.ads.internal.adapters.r;
import com.facebook.ads.internal.b;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.g.g;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.ad;
/* loaded from: classes.dex */
public class InstreamVideoAdView extends RelativeLayout implements Ad, ad<Bundle> {

    /* renamed from: a  reason: collision with root package name */
    private final String f1048a;

    /* renamed from: b  reason: collision with root package name */
    private final AdSize f1049b;

    /* renamed from: c  reason: collision with root package name */
    private DisplayAdController f1050c;
    @Nullable
    private i d;
    private boolean e;
    @Nullable
    private InstreamVideoAdListener f;
    @Nullable
    private View g;
    @Nullable
    private Bundle h;

    public InstreamVideoAdView(Context context, Bundle bundle) {
        this(context, bundle.getString("placementID"), (AdSize) bundle.get("adSize"));
        this.h = bundle;
    }

    public InstreamVideoAdView(Context context, String str, AdSize adSize) {
        super(context);
        this.e = false;
        this.f1048a = str;
        this.f1049b = adSize;
        this.f1050c = getController();
    }

    private final void a() {
        if (this.f1050c != null) {
            this.f1050c.d();
            this.f1050c = null;
            this.f1050c = getController();
            this.d = null;
            this.e = false;
            removeAllViews();
        }
    }

    private DisplayAdController getController() {
        this.f1050c = new DisplayAdController(getContext(), this.f1048a, e.INSTREAM_VIDEO, AdPlacementType.INSTREAM, this.f1049b, c.ADS, 1, true);
        this.f1050c.a(new a() { // from class: com.facebook.ads.InstreamVideoAdView.1
            @Override // com.facebook.ads.internal.a
            public void a() {
                if (InstreamVideoAdView.this.f == null) {
                    return;
                }
                InstreamVideoAdView.this.f.onAdClicked(InstreamVideoAdView.this);
            }

            @Override // com.facebook.ads.internal.a
            public void a(View view) {
                if (view == null) {
                    throw new IllegalStateException("Cannot present null view");
                }
                InstreamVideoAdView.this.g = view;
                InstreamVideoAdView.this.removeAllViews();
                InstreamVideoAdView.this.g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                InstreamVideoAdView.this.addView(InstreamVideoAdView.this.g);
            }

            @Override // com.facebook.ads.internal.a
            public void a(AdAdapter adAdapter) {
                if (InstreamVideoAdView.this.f1050c == null) {
                    return;
                }
                InstreamVideoAdView.this.e = true;
                if (InstreamVideoAdView.this.f != null) {
                    InstreamVideoAdView.this.f.onAdLoaded(InstreamVideoAdView.this);
                }
            }

            @Override // com.facebook.ads.internal.a
            public void a(b bVar) {
                if (InstreamVideoAdView.this.f == null) {
                    return;
                }
                InstreamVideoAdView.this.f.onError(InstreamVideoAdView.this, bVar.b());
            }

            @Override // com.facebook.ads.internal.a
            public void b() {
            }

            @Override // com.facebook.ads.internal.a
            public void c() {
                if (InstreamVideoAdView.this.f == null) {
                    return;
                }
                InstreamVideoAdView.this.f.onAdVideoComplete(InstreamVideoAdView.this);
            }
        });
        return this.f1050c;
    }

    @Override // com.facebook.ads.Ad
    public void destroy() {
        a();
    }

    @Override // com.facebook.ads.Ad
    public String getPlacementId() {
        return this.f1048a;
    }

    @Override // com.facebook.ads.internal.util.ad
    public Bundle getSaveInstanceState() {
        Bundle saveInstanceState;
        ad adVar = this.d != null ? this.d : (r) this.f1050c.i();
        if (adVar != null && (saveInstanceState = adVar.getSaveInstanceState()) != null) {
            Bundle bundle = new Bundle();
            bundle.putBundle("adapter", saveInstanceState);
            bundle.putString("placementID", this.f1048a);
            bundle.putSerializable("adSize", this.f1049b);
            return bundle;
        }
        return null;
    }

    public boolean isAdLoaded() {
        return this.e;
    }

    @Override // com.facebook.ads.Ad
    public void loadAd() {
        if (this.h == null) {
            this.f1050c.b();
            return;
        }
        this.d = new i();
        this.d.a(getContext(), new com.facebook.ads.a.a() { // from class: com.facebook.ads.InstreamVideoAdView.2
            @Override // com.facebook.ads.a.a
            public void a(r rVar) {
                InstreamVideoAdView.this.e = true;
                if (InstreamVideoAdView.this.f == null) {
                    return;
                }
                InstreamVideoAdView.this.f.onAdLoaded(InstreamVideoAdView.this);
            }

            @Override // com.facebook.ads.a.a
            public void a(r rVar, View view) {
                if (view == null) {
                    throw new IllegalStateException("Cannot present null view");
                }
                InstreamVideoAdView.this.g = view;
                InstreamVideoAdView.this.removeAllViews();
                InstreamVideoAdView.this.g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                InstreamVideoAdView.this.addView(InstreamVideoAdView.this.g);
            }

            @Override // com.facebook.ads.a.a
            public void a(r rVar, AdError adError) {
                if (InstreamVideoAdView.this.f == null) {
                    return;
                }
                InstreamVideoAdView.this.f.onError(InstreamVideoAdView.this, adError);
            }

            @Override // com.facebook.ads.a.a
            public void b(r rVar) {
                if (InstreamVideoAdView.this.f == null) {
                    return;
                }
                InstreamVideoAdView.this.f.onAdClicked(InstreamVideoAdView.this);
            }

            @Override // com.facebook.ads.a.a
            public void c(r rVar) {
            }

            @Override // com.facebook.ads.a.a
            public void d(r rVar) {
                if (InstreamVideoAdView.this.f == null) {
                    return;
                }
                InstreamVideoAdView.this.f.onAdVideoComplete(InstreamVideoAdView.this);
            }
        }, g.a(getContext()), this.h.getBundle("adapter"));
    }

    public void setAdListener(InstreamVideoAdListener instreamVideoAdListener) {
        this.f = instreamVideoAdListener;
    }

    public boolean show() {
        if (!this.e || (this.f1050c == null && this.d == null)) {
            if (this.f != null) {
                this.f.onError(this, AdError.INTERNAL_ERROR);
                return false;
            }
            return false;
        }
        if (this.d != null) {
            this.d.d();
        } else {
            this.f1050c.c();
        }
        this.e = false;
        return true;
    }
}

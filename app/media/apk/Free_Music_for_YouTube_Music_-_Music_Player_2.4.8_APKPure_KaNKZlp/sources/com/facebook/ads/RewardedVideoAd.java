package com.facebook.ads;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.a;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.x;
import com.facebook.ads.internal.b;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.server.AdPlacementType;
/* loaded from: classes.dex */
public class RewardedVideoAd implements Ad {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1106a = RewardedVideoAd.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1107b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1108c;
    private DisplayAdController d;
    private boolean e = false;
    private RewardedVideoAdListener f;
    private RewardData g;

    public RewardedVideoAd(Context context, String str) {
        this.f1107b = context;
        this.f1108c = str;
    }

    private void a() {
        b();
        this.e = false;
        this.d = new DisplayAdController(this.f1107b, this.f1108c, e.REWARDED_VIDEO, AdPlacementType.REWARDED_VIDEO, AdSize.INTERSTITIAL, c.ADS, 1, true);
        this.d.a(new a() { // from class: com.facebook.ads.RewardedVideoAd.1
            @Override // com.facebook.ads.internal.a
            public void a() {
                if (RewardedVideoAd.this.f != null) {
                    RewardedVideoAd.this.f.onAdClicked(RewardedVideoAd.this);
                }
            }

            @Override // com.facebook.ads.internal.a
            public void a(AdAdapter adAdapter) {
                if (RewardedVideoAd.this.g != null) {
                    ((x) adAdapter).a(RewardedVideoAd.this.g);
                }
                RewardedVideoAd.this.e = true;
                if (RewardedVideoAd.this.f != null) {
                    RewardedVideoAd.this.f.onAdLoaded(RewardedVideoAd.this);
                }
            }

            @Override // com.facebook.ads.internal.a
            public void a(b bVar) {
                if (RewardedVideoAd.this.f != null) {
                    RewardedVideoAd.this.f.onError(RewardedVideoAd.this, bVar.b());
                }
            }

            @Override // com.facebook.ads.internal.a
            public void b() {
                if (RewardedVideoAd.this.f != null) {
                    RewardedVideoAd.this.f.onLoggingImpression(RewardedVideoAd.this);
                }
            }

            @Override // com.facebook.ads.internal.a
            public void f() {
                RewardedVideoAd.this.f.onRewardedVideoCompleted();
            }

            @Override // com.facebook.ads.internal.a
            public void g() {
                if (RewardedVideoAd.this.f != null) {
                    RewardedVideoAd.this.f.onRewardedVideoClosed();
                }
            }

            @Override // com.facebook.ads.internal.a
            public void h() {
                if (RewardedVideoAd.this.f instanceof S2SRewardedVideoAdListener) {
                    ((S2SRewardedVideoAdListener) RewardedVideoAd.this.f).onRewardServerFailed();
                }
            }

            @Override // com.facebook.ads.internal.a
            public void i() {
                if (RewardedVideoAd.this.f instanceof S2SRewardedVideoAdListener) {
                    ((S2SRewardedVideoAdListener) RewardedVideoAd.this.f).onRewardServerSuccess();
                }
            }
        });
        this.d.b();
    }

    private final void b() {
        if (this.d != null) {
            this.d.d();
            this.d = null;
        }
    }

    @Override // com.facebook.ads.Ad
    public void destroy() {
        b();
    }

    @Override // com.facebook.ads.Ad
    public String getPlacementId() {
        return this.f1108c;
    }

    public boolean isAdLoaded() {
        return this.e;
    }

    @Override // com.facebook.ads.Ad
    public void loadAd() {
        try {
            a();
        } catch (Exception e) {
            Log.e(f1106a, "Error loading rewarded video ad", e);
            if (this.f != null) {
                this.f.onError(this, AdError.INTERNAL_ERROR);
            }
        }
    }

    public void setAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f = rewardedVideoAdListener;
    }

    public void setRewardData(RewardData rewardData) {
        this.g = rewardData;
    }

    public boolean show() {
        if (this.e) {
            this.d.c();
            this.e = false;
            return true;
        } else if (this.f != null) {
            this.f.onError(this, AdError.INTERNAL_ERROR);
            return false;
        } else {
            return false;
        }
    }
}

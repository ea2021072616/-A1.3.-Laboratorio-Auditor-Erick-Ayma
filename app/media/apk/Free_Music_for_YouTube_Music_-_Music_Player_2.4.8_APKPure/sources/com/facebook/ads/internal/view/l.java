package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.util.ab;
import com.facebook.ads.internal.util.af;
import com.facebook.ads.internal.view.d;
import com.facebook.ads.internal.view.d.b.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l implements d {

    /* renamed from: a  reason: collision with root package name */
    private com.facebook.ads.internal.j.a f1760a;

    /* renamed from: b  reason: collision with root package name */
    private n f1761b;

    /* renamed from: c  reason: collision with root package name */
    private ab f1762c;
    private af d;
    private d.a e;
    private com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.b> f;
    private com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.d> g;
    private com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.l> h;
    private com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.s> i;
    private String j;
    private Context k;
    private String l;
    private RelativeLayout m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private com.facebook.ads.internal.view.d.b.p q;

    public l(Context context, d.a aVar) {
        this.k = context;
        this.e = aVar;
        i();
    }

    private void i() {
        float f = this.k.getResources().getDisplayMetrics().density;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f1761b = new n(this.k);
        this.f1761b.h();
        this.f1761b.setAutoplay(true);
        this.f1761b.setIsFullScreen(true);
        this.f1761b.setLayoutParams(layoutParams);
        this.f1761b.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.i = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.s>() { // from class: com.facebook.ads.internal.view.l.1
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.s> a() {
                return com.facebook.ads.internal.view.d.a.s.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.s sVar) {
                l.this.d.a(sVar.b(), l.this.f1761b, sVar.a());
            }
        };
        this.f = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.b>() { // from class: com.facebook.ads.internal.view.l.2
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.b> a() {
                return com.facebook.ads.internal.view.d.a.b.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.b bVar) {
                if (l.this.e != null) {
                    l.this.e.a(com.facebook.ads.internal.j.REWARDED_VIDEO_COMPLETE.a(), bVar);
                }
                l.this.e();
            }
        };
        this.g = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.d>() { // from class: com.facebook.ads.internal.view.l.3
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.d> a() {
                return com.facebook.ads.internal.view.d.a.d.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.d dVar) {
                if (l.this.e != null) {
                    l.this.e.a(com.facebook.ads.internal.j.REWARDED_VIDEO_ERROR.a());
                }
                l.this.e();
            }
        };
        this.h = new com.facebook.ads.internal.g.s<com.facebook.ads.internal.view.d.a.l>() { // from class: com.facebook.ads.internal.view.l.4
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.l> a() {
                return com.facebook.ads.internal.view.d.a.l.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.l lVar) {
                if (l.this.f1760a != null) {
                    l.this.f1760a.a();
                }
            }
        };
        this.f1761b.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f);
        this.f1761b.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.g);
        this.f1761b.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.h);
        this.f1761b.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.i);
        this.f1761b.a(new com.facebook.ads.internal.view.d.b.j(this.k));
        this.q = new com.facebook.ads.internal.view.d.b.p(this.k, (int) (6.0f * f));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        this.q.setLayoutParams(layoutParams2);
        this.f1761b.a(this.q);
        if (com.facebook.ads.internal.h.j(this.k)) {
            com.facebook.ads.internal.view.d.b.k kVar = new com.facebook.ads.internal.view.d.b.k(this.k);
            this.f1761b.a(kVar);
            this.f1761b.a(new com.facebook.ads.internal.view.d.b.d(kVar, d.a.INVSIBLE));
        }
        if (com.facebook.ads.internal.h.c(this.k)) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable.setCornerRadius(0.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(12);
            this.m = new RelativeLayout(this.k);
            if (Build.VERSION.SDK_INT >= 16) {
                this.m.setBackground(gradientDrawable);
            } else {
                this.m.setBackgroundDrawable(gradientDrawable);
            }
            this.m.setLayoutParams(layoutParams3);
            this.m.setPadding((int) (16.0f * f), 0, (int) (16.0f * f), (int) (20.0f * f));
            this.n = new TextView(this.k);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.addRule(12);
            layoutParams4.addRule(9);
            layoutParams4.addRule(4);
            this.n.setEllipsize(TextUtils.TruncateAt.END);
            this.n.setGravity(GravityCompat.START);
            this.n.setLayoutParams(layoutParams4);
            this.n.setMaxLines(1);
            this.n.setPadding((int) (72.0f * f), 0, 0, (int) (30.0f * f));
            this.n.setTextColor(-1);
            this.n.setTextSize(20.0f);
            this.o = new TextView(this.k);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.addRule(12);
            layoutParams5.addRule(9);
            this.o.setEllipsize(TextUtils.TruncateAt.END);
            this.o.setGravity(GravityCompat.START);
            this.o.setLayoutParams(layoutParams5);
            this.o.setMaxLines(2);
            this.o.setPadding((int) (72.0f * f), 0, 0, 0);
            this.o.setTextColor(-1);
            this.p = new ImageView(this.k);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams((int) (60.0f * f), (int) (f * 60.0f));
            layoutParams6.addRule(12);
            layoutParams6.addRule(9);
            this.p.setLayoutParams(layoutParams6);
            this.m.addView(this.p);
            this.m.addView(this.n);
            this.m.addView(this.o);
            com.facebook.ads.internal.view.d.b.d dVar = new com.facebook.ads.internal.view.d.b.d(new RelativeLayout(this.k), d.a.INVSIBLE);
            dVar.a(this.m, d.a.INVSIBLE);
            this.f1761b.a(dVar);
        }
        this.f1760a = new com.facebook.ads.internal.j.a(this.f1761b, 1, new a.AbstractC0038a() { // from class: com.facebook.ads.internal.view.l.5
            @Override // com.facebook.ads.internal.j.a.AbstractC0038a
            public void a() {
                if (l.this.d.b()) {
                    return;
                }
                l.this.d.a();
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(l.this.j)) {
                    l.this.f1760a.a(hashMap);
                    hashMap.put("touch", com.facebook.ads.internal.util.g.a(l.this.a()));
                    com.facebook.ads.internal.g.g.a(l.this.k).a(l.this.j, hashMap);
                }
                if (l.this.e != null) {
                    l.this.e.a(com.facebook.ads.internal.j.REWARDED_VIDEO_IMPRESSION.a());
                }
            }
        });
        this.f1760a.a(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.d = new af();
        this.e.a(this.f1761b);
        if (this.m != null) {
            this.e.a(this.m);
        }
        this.e.a(this.q);
    }

    public Map<String, String> a() {
        return this.d.e();
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        String stringExtra = intent.getStringExtra(AudienceNetworkActivity.VIDEO_URL);
        this.j = intent.getStringExtra(AudienceNetworkActivity.CLIENT_TOKEN);
        this.l = intent.getStringExtra(AudienceNetworkActivity.CONTEXT_SWITCH_BEHAVIOR);
        if (this.n != null) {
            this.n.setText(intent.getStringExtra(AudienceNetworkActivity.AD_TITLE));
        }
        if (this.o != null) {
            this.o.setText(intent.getStringExtra(AudienceNetworkActivity.AD_SUBTITLE));
        }
        if (this.p != null) {
            String stringExtra2 = intent.getStringExtra(AudienceNetworkActivity.AD_ICON_URL);
            if (!TextUtils.isEmpty(stringExtra2)) {
                new com.facebook.ads.internal.util.p(this.p).a(stringExtra2);
            }
        }
        this.f1762c = new ab(this.k, com.facebook.ads.internal.g.g.a(this.k), this.f1761b, this.j);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f1761b.setVideoURI(stringExtra);
        }
        this.f1761b.d();
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(Bundle bundle) {
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(d.a aVar) {
    }

    public void b() {
        this.f1761b.a(1);
        this.f1761b.d();
    }

    public void c() {
        this.f1761b.e();
    }

    public boolean d() {
        return this.f1761b.getState() == com.facebook.ads.internal.view.d.c.d.PAUSED;
    }

    public void e() {
        if (this.f1761b != null) {
            this.f1761b.g();
        }
        if (this.f1760a != null) {
            this.f1760a.b();
        }
    }

    public void f() {
        this.f1761b.a(this.f1761b.getCurrentPosition());
        this.f1761b.d();
    }

    @Override // com.facebook.ads.internal.view.d
    public void g() {
        c();
    }

    @Override // com.facebook.ads.internal.view.d
    public void h() {
        if (d()) {
            if (this.l.equals("restart")) {
                b();
            } else if (this.l.equals("resume")) {
                f();
            } else if (this.l.equals("skip")) {
                this.e.a(com.facebook.ads.internal.j.REWARDED_VIDEO_COMPLETE_WITHOUT_REWARD.a(), new com.facebook.ads.internal.view.d.a.b());
                e();
            } else if (this.l.equals("endvideo")) {
                this.e.a(com.facebook.ads.internal.j.REWARDED_VIDEO_END_ACTIVITY.a());
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(this.j)) {
                    this.f1760a.a(hashMap);
                    hashMap.put("touch", com.facebook.ads.internal.util.g.a(a()));
                    com.facebook.ads.internal.g.g.a(this.k).e(this.j, hashMap);
                }
                e();
            }
        }
    }

    @Override // com.facebook.ads.internal.view.d
    public void onDestroy() {
        e();
        this.n = null;
        this.o = null;
        this.p = null;
        this.m = null;
        this.l = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f1760a = null;
        this.d = null;
        this.f1762c = null;
        this.f1761b = null;
        this.e = null;
        this.j = null;
        this.k = null;
        this.q.a();
        this.q = null;
    }
}

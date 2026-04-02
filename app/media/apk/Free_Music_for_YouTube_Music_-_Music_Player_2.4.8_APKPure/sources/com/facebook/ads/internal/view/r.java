package com.facebook.ads.internal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.ab;
import com.facebook.ads.internal.view.d;
/* loaded from: classes.dex */
public class r implements d {

    /* renamed from: a  reason: collision with root package name */
    private final com.facebook.ads.internal.view.d.a.e f1780a = new com.facebook.ads.internal.view.d.a.e() { // from class: com.facebook.ads.internal.view.r.1
        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.d dVar) {
            r.this.e.finish();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.ads.internal.view.d.a.k f1781b = new com.facebook.ads.internal.view.d.a.k() { // from class: com.facebook.ads.internal.view.r.2
        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.j jVar) {
            r.this.g.a("videoInterstitalEvent", jVar);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.ads.internal.view.d.a.i f1782c = new com.facebook.ads.internal.view.d.a.i() { // from class: com.facebook.ads.internal.view.r.3
        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.h hVar) {
            r.this.g.a("videoInterstitalEvent", hVar);
        }
    };
    private final com.facebook.ads.internal.view.d.a.c d = new com.facebook.ads.internal.view.d.a.c() { // from class: com.facebook.ads.internal.view.r.4
        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.b bVar) {
            r.this.g.a("videoInterstitalEvent", bVar);
        }
    };
    private final AudienceNetworkActivity e;
    private final n f;
    private final d.a g;
    private ab h;
    private int i;

    public r(AudienceNetworkActivity audienceNetworkActivity, d.a aVar) {
        this.e = audienceNetworkActivity;
        this.f = new n(audienceNetworkActivity);
        this.f.a(new com.facebook.ads.internal.view.d.b.b(audienceNetworkActivity));
        this.f.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f1781b);
        this.f.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f1782c);
        this.f.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.d);
        this.f.getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f1780a);
        this.g = aVar;
        this.f.setIsFullScreen(true);
        this.f.setVolume(1.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        this.f.setLayoutParams(layoutParams);
        aVar.a(this.f);
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        boolean booleanExtra = intent.getBooleanExtra(AudienceNetworkActivity.AUTOPLAY, false);
        String stringExtra = intent.getStringExtra(AudienceNetworkActivity.VIDEO_URL);
        String stringExtra2 = intent.getStringExtra(AudienceNetworkActivity.VIDEO_MPD);
        Bundle bundleExtra = intent.getBundleExtra(AudienceNetworkActivity.VIDEO_LOGGER);
        String stringExtra3 = intent.getStringExtra(AudienceNetworkActivity.CLIENT_TOKEN);
        this.i = intent.getIntExtra(AudienceNetworkActivity.VIDEO_SEEK_TIME, 0);
        this.f.setAutoplay(booleanExtra);
        this.h = new ab(audienceNetworkActivity, com.facebook.ads.internal.g.g.a(audienceNetworkActivity.getApplicationContext()), this.f, stringExtra3, bundleExtra);
        this.f.setVideoMPD(stringExtra2);
        this.f.setVideoURI(stringExtra);
        if (this.i > 0) {
            this.f.a(this.i);
        }
        this.f.d();
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(Bundle bundle) {
    }

    public void a(View view) {
        this.f.setControlsAnchorView(view);
    }

    @Override // com.facebook.ads.internal.view.d
    public void a(d.a aVar) {
    }

    @Override // com.facebook.ads.internal.view.d
    public void g() {
        this.g.a("videoInterstitalEvent", new com.facebook.ads.internal.view.d.a.f());
        this.f.e();
    }

    @Override // com.facebook.ads.internal.view.d
    public void h() {
        this.g.a("videoInterstitalEvent", new com.facebook.ads.internal.view.d.a.g());
        this.f.d();
    }

    @Override // com.facebook.ads.internal.view.d
    public void onDestroy() {
        this.g.a("videoInterstitalEvent", new com.facebook.ads.internal.view.d.a.p(this.i, this.f.getCurrentPosition()));
        this.h.b(this.f.getCurrentPosition());
        this.f.g();
    }
}

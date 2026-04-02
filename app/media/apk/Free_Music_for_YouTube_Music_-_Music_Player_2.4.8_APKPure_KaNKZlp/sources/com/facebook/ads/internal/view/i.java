package com.facebook.ads.internal.view;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.internal.adapters.aa;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.util.ab;
import java.util.UUID;
/* loaded from: classes.dex */
public class i extends n {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f1752a;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.ads.internal.view.d.a.k f1753c;
    private final com.facebook.ads.internal.view.d.a.i d;
    private final com.facebook.ads.internal.view.d.a.m e;
    private final com.facebook.ads.internal.view.d.a.c f;
    private final String g;
    private final com.facebook.ads.internal.g.f h;
    private final com.facebook.ads.internal.j.a i;
    private final aa j;
    private final com.facebook.ads.internal.view.d.b.f k;
    @Nullable
    private ab l;
    @Nullable
    private String m;
    @Nullable
    private Uri n;
    @Nullable
    private String o;
    @Nullable
    private String p;
    @Nullable
    private j q;
    private boolean r;

    static {
        f1752a = !i.class.desiredAssertionStatus();
    }

    public i(Context context, com.facebook.ads.internal.g.f fVar) {
        super(context);
        this.f1753c = new com.facebook.ads.internal.view.d.a.k() { // from class: com.facebook.ads.internal.view.i.1
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.j jVar) {
                if (i.this.q == null) {
                    return;
                }
                i.this.q.c();
            }
        };
        this.d = new com.facebook.ads.internal.view.d.a.i() { // from class: com.facebook.ads.internal.view.i.2
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.h hVar) {
                if (i.this.q == null) {
                    return;
                }
                i.this.q.b();
            }
        };
        this.e = new com.facebook.ads.internal.view.d.a.m() { // from class: com.facebook.ads.internal.view.i.3
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.l lVar) {
                if (i.this.i()) {
                    i.this.d();
                }
                i.this.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.ads.internal.view.i.3.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            i.this.k();
                        }
                        return true;
                    }
                });
            }
        };
        this.f = new com.facebook.ads.internal.view.d.a.c() { // from class: com.facebook.ads.internal.view.i.4
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.b bVar) {
                if (i.this.q == null) {
                    return;
                }
                i.this.q.h();
            }
        };
        this.g = UUID.randomUUID().toString();
        this.r = false;
        this.h = fVar;
        getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f1753c);
        getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.d);
        getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.f);
        setAutoplay(true);
        setVolume(0.0f);
        this.k = new com.facebook.ads.internal.view.d.b.f(context);
        a(this.k);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        com.facebook.ads.internal.view.d.b.g gVar = new com.facebook.ads.internal.view.d.b.g(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        gVar.setPadding((int) (displayMetrics.density * 2.0f), (int) (displayMetrics.density * 25.0f), (int) (displayMetrics.density * 25.0f), (int) (displayMetrics.density * 2.0f));
        gVar.setLayoutParams(layoutParams);
        a(gVar);
        getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) this.e);
        this.j = new aa(this, getContext());
        this.i = new com.facebook.ads.internal.j.a(this, 50, true, new a.AbstractC0038a() { // from class: com.facebook.ads.internal.view.i.5
            @Override // com.facebook.ads.internal.j.a.AbstractC0038a
            public void a() {
                if ((i.this.i() || i.this.f1772b.getTargetState() == com.facebook.ads.internal.view.d.c.d.STARTED) && i.this.f1772b.getTargetState() != com.facebook.ads.internal.view.d.c.d.PAUSED) {
                    i.this.d();
                }
            }

            @Override // com.facebook.ads.internal.j.a.AbstractC0038a
            public void b() {
                i.this.e();
            }
        });
        this.i.a(0);
        this.i.b(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    private void a(Context context, Intent intent) {
        if (!f1752a && this.m == null) {
            throw new AssertionError();
        }
        if (!f1752a && this.n == null && this.p == null) {
            throw new AssertionError();
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        intent.putExtra("useNativeCloseButton", true);
        intent.putExtra(AudienceNetworkActivity.VIEW_TYPE, AudienceNetworkActivity.Type.VIDEO);
        intent.putExtra(AudienceNetworkActivity.VIDEO_URL, this.n.toString());
        intent.putExtra(AudienceNetworkActivity.CLIENT_TOKEN, this.o == null ? "" : this.o);
        intent.putExtra(AudienceNetworkActivity.VIDEO_MPD, this.p);
        intent.putExtra(AudienceNetworkActivity.VIDEO_REPORT_URL, this.m);
        intent.putExtra(AudienceNetworkActivity.PREDEFINED_ORIENTATION_KEY, 13);
        intent.putExtra(AudienceNetworkActivity.AUTOPLAY, a());
        intent.putExtra(AudienceNetworkActivity.VIDEO_SEEK_TIME, getCurrentPosition());
        intent.putExtra(AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, this.g);
        intent.putExtra(AudienceNetworkActivity.VIDEO_LOGGER, this.l.getSaveInstanceState());
        intent.addFlags(268435456);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Context context = getContext();
        Intent intent = new Intent(context, AudienceNetworkActivity.class);
        a(context, intent);
        try {
            e();
            setVisibility(8);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            try {
                intent.setClass(context, InterstitialAdActivity.class);
                context.startActivity(intent);
            } catch (Exception e2) {
                com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(e2, "Error occurred while loading fullscreen video activity."));
            }
        } catch (Exception e3) {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(e3, "Error occurred while loading fullscreen video activity."));
        }
    }

    private void l() {
        if (getVisibility() == 0 && this.r) {
            this.i.a();
        } else {
            this.i.b();
        }
    }

    public void a(String str, @Nullable String str2) {
        if (this.l != null) {
            this.l.a();
        }
        if (str2 == null) {
            str2 = "";
        }
        this.l = new ab(getContext(), this.h, this, str2);
        this.o = str2;
        this.m = str;
    }

    @Override // com.facebook.ads.internal.view.n
    public void d() {
        if (com.facebook.ads.internal.j.a.a(this, 50).a()) {
            super.d();
        }
    }

    @Nullable
    public j getListener() {
        return this.q;
    }

    public String getUniqueId() {
        return this.g;
    }

    @Override // com.facebook.ads.internal.view.n, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
        this.j.a();
        l();
    }

    @Override // com.facebook.ads.internal.view.n, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = false;
        this.j.b();
        l();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        l();
        super.onVisibilityChanged(view, i);
    }

    public void setImage(String str) {
        this.k.setImage(str);
    }

    public void setListener(@Nullable j jVar) {
        this.q = jVar;
    }

    @Override // com.facebook.ads.internal.view.n
    public void setVideoMPD(String str) {
        if (!f1752a && this.l == null) {
            throw new AssertionError();
        }
        this.p = str;
        super.setVideoMPD(str);
    }

    @Override // com.facebook.ads.internal.view.n
    public void setVideoURI(Uri uri) {
        if (!f1752a && this.l == null) {
            throw new AssertionError();
        }
        this.n = uri;
        super.setVideoURI(uri);
    }
}

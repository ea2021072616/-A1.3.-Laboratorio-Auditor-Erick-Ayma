package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.util.ah;
import com.facebook.ads.internal.util.ai;
import com.facebook.ads.internal.util.w;
import com.facebook.ads.internal.view.d.a.v;
import com.facebook.ads.internal.view.d.a.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends RelativeLayout implements ah.a, com.facebook.ads.internal.view.d.c.e {
    private static final com.facebook.ads.internal.view.d.a.l i = new com.facebook.ads.internal.view.d.a.l();
    private static final com.facebook.ads.internal.view.d.a.d j = new com.facebook.ads.internal.view.d.a.d();
    private static final com.facebook.ads.internal.view.d.a.b k = new com.facebook.ads.internal.view.d.a.b();
    private static final com.facebook.ads.internal.view.d.a.n l = new com.facebook.ads.internal.view.d.a.n();
    private static final com.facebook.ads.internal.view.d.a.q m = new com.facebook.ads.internal.view.d.a.q();
    private static final com.facebook.ads.internal.view.d.a.h n = new com.facebook.ads.internal.view.d.a.h();
    private static final com.facebook.ads.internal.view.d.a.r o = new com.facebook.ads.internal.view.d.a.r();
    private static final com.facebook.ads.internal.view.d.a.j p = new com.facebook.ads.internal.view.d.a.j();
    private static final com.facebook.ads.internal.view.d.a.t q = new com.facebook.ads.internal.view.d.a.t();
    private static final w r = new w();
    private static final v s = new v();

    /* renamed from: a  reason: collision with root package name */
    private final com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q> f1771a;

    /* renamed from: b  reason: collision with root package name */
    protected final com.facebook.ads.internal.view.d.c.c f1772b;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.facebook.ads.internal.view.d.b.m> f1773c;
    private boolean d;
    @Deprecated
    private boolean e;
    @Deprecated
    private boolean f;
    private ai g;
    private boolean h;
    private final Handler t;
    private final View.OnTouchListener u;

    public n(@Nullable Context context) {
        this(context, null);
    }

    public n(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n(@Nullable Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1773c = new ArrayList();
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = ai.UNKNOWN;
        this.h = false;
        this.u = new View.OnTouchListener() { // from class: com.facebook.ads.internal.view.n.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                n.this.f1771a.a((com.facebook.ads.internal.g.r) new com.facebook.ads.internal.view.d.a.s(view, motionEvent));
                return true;
            }
        };
        if (com.facebook.ads.internal.h.a(getContext())) {
            this.f1772b = new com.facebook.ads.internal.view.d.c.a(getContext());
        } else {
            this.f1772b = new com.facebook.ads.internal.view.d.c.b(getContext());
        }
        this.f1772b.setRequestedVolume(1.0f);
        this.f1772b.setVideoStateChangeListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView((View) this.f1772b, layoutParams);
        this.t = new Handler();
        this.f1771a = new com.facebook.ads.internal.g.r<>();
        setOnTouchListener(this.u);
    }

    public void a(int i2) {
        this.f1772b.seekTo(i2);
    }

    @Override // com.facebook.ads.internal.view.d.c.e
    public void a(int i2, int i3) {
        this.f1771a.a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) new com.facebook.ads.internal.view.d.a.p(i2, i3));
    }

    public void a(com.facebook.ads.internal.view.d.b.m mVar) {
        this.f1773c.add(mVar);
    }

    @Override // com.facebook.ads.internal.view.d.c.e
    public void a(com.facebook.ads.internal.view.d.c.d dVar) {
        if (dVar == com.facebook.ads.internal.view.d.c.d.PREPARED) {
            this.f1771a.a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) i);
            if (!i() || this.d) {
                return;
            }
            d();
        } else if (dVar == com.facebook.ads.internal.view.d.c.d.ERROR) {
            this.d = true;
            this.f1771a.a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) j);
        } else if (dVar == com.facebook.ads.internal.view.d.c.d.PLAYBACK_COMPLETED) {
            this.d = true;
            this.t.removeCallbacksAndMessages(null);
            this.f1771a.a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) k);
        } else if (dVar == com.facebook.ads.internal.view.d.c.d.STARTED) {
            this.f1771a.a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) p);
            this.t.removeCallbacksAndMessages(null);
            this.t.postDelayed(new Runnable() { // from class: com.facebook.ads.internal.view.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.d) {
                        return;
                    }
                    n.this.f1771a.a((com.facebook.ads.internal.g.r) n.l);
                    n.this.t.postDelayed(this, 250L);
                }
            }, 250L);
        } else if (dVar == com.facebook.ads.internal.view.d.c.d.PAUSED) {
            this.f1771a.a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) n);
            this.t.removeCallbacksAndMessages(null);
        } else if (dVar == com.facebook.ads.internal.view.d.c.d.IDLE) {
            this.f1771a.a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) o);
            this.t.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.facebook.ads.internal.util.ah.a
    public boolean a() {
        return i();
    }

    @Override // com.facebook.ads.internal.util.ah.a
    public boolean b() {
        return com.facebook.ads.internal.h.a(getContext());
    }

    @Override // com.facebook.ads.internal.util.ah.a
    public boolean c() {
        return this.h;
    }

    public void d() {
        if (this.d && this.f1772b.getState() == com.facebook.ads.internal.view.d.c.d.PLAYBACK_COMPLETED) {
            this.d = false;
        }
        this.f1772b.start();
    }

    public void e() {
        this.f1772b.pause();
    }

    public void f() {
        getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) m);
        this.f1772b.a();
    }

    public void g() {
        this.f1772b.b();
    }

    @Override // com.facebook.ads.internal.util.ah.a
    public int getCurrentPosition() {
        return this.f1772b.getCurrentPosition();
    }

    public int getDuration() {
        return this.f1772b.getDuration();
    }

    @NonNull
    public com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q> getEventBus() {
        return this.f1771a;
    }

    @Override // com.facebook.ads.internal.util.ah.a
    public long getInitialBufferTime() {
        return this.f1772b.getInitialBufferTime();
    }

    public ai getIsAutoPlayFromServer() {
        return this.g;
    }

    public com.facebook.ads.internal.view.d.c.d getState() {
        return this.f1772b.getState();
    }

    public TextureView getTextureView() {
        return (TextureView) this.f1772b;
    }

    public int getVideoHeight() {
        return this.f1772b.getVideoHeight();
    }

    public View getVideoView() {
        return this.f1772b.getView();
    }

    public int getVideoWidth() {
        return this.f1772b.getVideoWidth();
    }

    @Override // com.facebook.ads.internal.util.ah.a
    public float getVolume() {
        return this.f1772b.getVolume();
    }

    public void h() {
        this.f1772b.a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        return getIsAutoPlayFromServer() == ai.UNKNOWN ? this.e && (!this.f || com.facebook.ads.internal.util.w.c(getContext()) == w.a.MOBILE_INTERNET) : getIsAutoPlayFromServer() == ai.ON;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.f1771a.a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) s);
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f1771a.a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) r);
        super.onDetachedFromWindow();
    }

    @Deprecated
    public void setAutoplay(boolean z) {
        this.e = z;
    }

    public void setControlsAnchorView(View view) {
        if (this.f1772b != null) {
            this.f1772b.setControlsAnchorView(view);
        }
    }

    public void setIsAutoPlayFromServer(ai aiVar) {
        this.g = aiVar;
    }

    @Deprecated
    public void setIsAutoplayOnMobile(boolean z) {
        this.f = z;
    }

    public void setIsFullScreen(boolean z) {
        this.h = z;
        this.f1772b.setFullScreen(z);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setVideoMPD(String str) {
        this.f1772b.setVideoMPD(str);
    }

    public void setVideoURI(Uri uri) {
        for (com.facebook.ads.internal.view.d.b.m mVar : this.f1773c) {
            if (mVar instanceof com.facebook.ads.internal.view.d.b.n) {
                com.facebook.ads.internal.view.d.b.n nVar = (com.facebook.ads.internal.view.d.b.n) mVar;
                if (nVar.getParent() == null) {
                    addView(nVar);
                    nVar.a(this);
                }
            } else {
                mVar.a(this);
            }
        }
        this.d = false;
        this.f1772b.setup(uri);
    }

    public void setVideoURI(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVolume(float f) {
        this.f1772b.setRequestedVolume(f);
        getEventBus().a((com.facebook.ads.internal.g.r<com.facebook.ads.internal.g.s, com.facebook.ads.internal.g.q>) q);
    }
}

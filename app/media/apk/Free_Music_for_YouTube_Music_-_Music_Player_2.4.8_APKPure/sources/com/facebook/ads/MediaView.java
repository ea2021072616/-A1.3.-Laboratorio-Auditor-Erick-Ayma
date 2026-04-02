package com.facebook.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.g.f;
import com.facebook.ads.internal.g.g;
import com.facebook.ads.internal.util.p;
import com.facebook.ads.internal.view.e;
import com.facebook.ads.internal.view.hscroll.b;
import com.facebook.ads.internal.view.i;
import com.facebook.ads.internal.view.j;
/* loaded from: classes.dex */
public class MediaView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1057a = MediaView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final int f1058b = Color.argb(51, 145, 150, 165);
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private MediaViewListener f1059c;
    private final e d;
    private final i e;
    private final b f;
    private boolean g;
    @Deprecated
    private boolean h;

    public MediaView(Context context) {
        this(context, null);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = false;
        this.h = true;
        setBackgroundColor(f1058b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.d = new e(context);
        this.d.setVisibility(8);
        addView(this.d, layoutParams);
        this.e = new i(context, getAdEventManager());
        this.e.setVisibility(8);
        layoutParams.addRule(13);
        addView(this.e, layoutParams);
        float f = context.getResources().getDisplayMetrics().density;
        int round = Math.round(4.0f * f);
        int round2 = Math.round(f * 12.0f);
        this.f = new b(getContext());
        this.f.setChildSpacing(round);
        this.f.setPadding(0, round2, 0, round2);
        this.f.setVisibility(8);
        addView(this.f, layoutParams);
    }

    private boolean a(NativeAd nativeAd) {
        return Build.VERSION.SDK_INT >= 14 && !TextUtils.isEmpty(nativeAd.c());
    }

    private boolean b(NativeAd nativeAd) {
        if (nativeAd.g() == null) {
            return false;
        }
        for (NativeAd nativeAd2 : nativeAd.g()) {
            if (nativeAd2.getAdCoverImage() == null) {
                return false;
            }
        }
        return true;
    }

    public void destroy() {
        this.e.g();
    }

    protected f getAdEventManager() {
        return g.a(getContext());
    }

    @Deprecated
    public boolean isAutoplay() {
        return this.h;
    }

    @Deprecated
    public void setAutoplay(boolean z) {
        this.h = z;
        this.e.setAutoplay(z);
    }

    @Deprecated
    public void setAutoplayOnMobile(boolean z) {
        this.e.setIsAutoplayOnMobile(z);
    }

    public void setListener(final MediaViewListener mediaViewListener) {
        this.f1059c = mediaViewListener;
        if (mediaViewListener == null) {
            this.e.setListener(null);
        } else {
            this.e.setListener(new j() { // from class: com.facebook.ads.MediaView.1
                @Override // com.facebook.ads.internal.view.j
                public void a() {
                    mediaViewListener.onVolumeChange(MediaView.this, MediaView.this.e.getVolume());
                }

                @Override // com.facebook.ads.internal.view.j
                public void b() {
                    mediaViewListener.onPause(MediaView.this);
                }

                @Override // com.facebook.ads.internal.view.j
                public void c() {
                    mediaViewListener.onPlay(MediaView.this);
                }

                @Override // com.facebook.ads.internal.view.j
                public void d() {
                    mediaViewListener.onFullscreenBackground(MediaView.this);
                }

                @Override // com.facebook.ads.internal.view.j
                public void e() {
                    mediaViewListener.onFullscreenForeground(MediaView.this);
                }

                @Override // com.facebook.ads.internal.view.j
                public void f() {
                    mediaViewListener.onExitFullscreen(MediaView.this);
                }

                @Override // com.facebook.ads.internal.view.j
                public void g() {
                    mediaViewListener.onEnterFullscreen(MediaView.this);
                }

                @Override // com.facebook.ads.internal.view.j
                public void h() {
                    mediaViewListener.onComplete(MediaView.this);
                }
            });
        }
    }

    public void setNativeAd(NativeAd nativeAd) {
        nativeAd.a(this);
        nativeAd.setMediaViewAutoplay(this.h);
        if (this.g) {
            this.d.a(null, null);
            this.g = false;
        }
        String url = nativeAd.getAdCoverImage() != null ? nativeAd.getAdCoverImage().getUrl() : null;
        if (b(nativeAd)) {
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            bringChildToFront(this.f);
            this.f.setCurrentPosition(0);
            this.f.setAdapter(new com.facebook.ads.internal.adapters.g(this.f, nativeAd.g()));
        } else if (!a(nativeAd)) {
            if (url != null) {
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                this.f.setVisibility(8);
                bringChildToFront(this.d);
                this.g = true;
                new p(this.d).a(url);
            }
        } else {
            String c2 = nativeAd.c();
            String d = nativeAd.d();
            this.e.setImage(null);
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.f.setVisibility(8);
            bringChildToFront(this.e);
            this.g = true;
            this.e.setAutoplay(this.h);
            this.e.setIsAutoPlayFromServer(nativeAd.f());
            if (url != null) {
                this.e.setImage(url);
            }
            this.e.a(nativeAd.e(), nativeAd.h());
            this.e.setVideoMPD(d);
            this.e.setVideoURI(c2);
        }
    }
}

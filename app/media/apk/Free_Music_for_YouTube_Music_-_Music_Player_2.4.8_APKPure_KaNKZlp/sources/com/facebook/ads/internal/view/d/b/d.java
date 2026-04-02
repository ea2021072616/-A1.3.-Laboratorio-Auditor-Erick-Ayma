package com.facebook.ads.internal.view.d.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ads.internal.g.q;
import com.facebook.ads.internal.g.r;
import com.facebook.ads.internal.g.s;
@TargetApi(12)
/* loaded from: classes.dex */
public class d implements m {

    /* renamed from: b  reason: collision with root package name */
    private View f1645b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private a f1646c;
    @Nullable
    private com.facebook.ads.internal.view.n d;
    private final com.facebook.ads.internal.view.d.a.i e = new com.facebook.ads.internal.view.d.a.i() { // from class: com.facebook.ads.internal.view.d.b.d.1
        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.h hVar) {
            d.this.f1644a.removeCallbacksAndMessages(null);
            d.this.f1645b.clearAnimation();
            d.this.f1645b.setAlpha(1.0f);
            d.this.f1645b.setVisibility(0);
        }
    };
    private final com.facebook.ads.internal.view.d.a.k f = new com.facebook.ads.internal.view.d.a.k() { // from class: com.facebook.ads.internal.view.d.b.d.2
        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.j jVar) {
            if (d.this.f1646c == a.FADE_OUT_ON_PLAY) {
                d.this.f1646c = null;
                d.this.f1645b.animate().alpha(0.0f).setDuration(2000L).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.internal.view.d.b.d.2.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        d.this.f1645b.setVisibility(8);
                    }
                });
                return;
            }
            d.this.f1644a.removeCallbacksAndMessages(null);
            d.this.f1645b.clearAnimation();
            d.this.f1645b.setAlpha(0.0f);
            d.this.f1645b.setVisibility(8);
        }
    };
    private final com.facebook.ads.internal.view.d.a.c g = new com.facebook.ads.internal.view.d.a.c() { // from class: com.facebook.ads.internal.view.d.b.d.3
        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.b bVar) {
            if (d.this.f1646c != a.INVSIBLE) {
                d.this.f1645b.setAlpha(1.0f);
                d.this.f1645b.setVisibility(0);
            }
        }
    };
    private final s<com.facebook.ads.internal.view.d.a.s> h = new AnonymousClass4();

    /* renamed from: a  reason: collision with root package name */
    private final Handler f1644a = new Handler();

    /* renamed from: com.facebook.ads.internal.view.d.b.d$4  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends s<com.facebook.ads.internal.view.d.a.s> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.facebook.ads.internal.view.d.b.d$4$1  reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 extends AnimatorListenerAdapter {
            AnonymousClass1() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.f1644a.postDelayed(new Runnable() { // from class: com.facebook.ads.internal.view.d.b.d.4.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.f1645b.animate().alpha(0.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.internal.view.d.b.d.4.1.1.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                d.this.f1645b.setVisibility(8);
                            }
                        });
                    }
                }, 2000L);
            }
        }

        AnonymousClass4() {
        }

        @Override // com.facebook.ads.internal.g.s
        public Class<com.facebook.ads.internal.view.d.a.s> a() {
            return com.facebook.ads.internal.view.d.a.s.class;
        }

        @Override // com.facebook.ads.internal.g.s
        public void a(com.facebook.ads.internal.view.d.a.s sVar) {
            if (d.this.d != null && sVar.b().getAction() == 0) {
                d.this.f1644a.removeCallbacksAndMessages(null);
                d.this.f1645b.setVisibility(0);
                d.this.f1645b.animate().alpha(1.0f).setDuration(500L).setListener(new AnonymousClass1());
            }
        }
    }

    /* loaded from: classes.dex */
    public enum a {
        VISIBLE,
        INVSIBLE,
        FADE_OUT_ON_PLAY
    }

    public d(View view, a aVar) {
        this.f1645b = view;
        this.f1646c = aVar;
        this.f1645b.clearAnimation();
        if (aVar == a.INVSIBLE) {
            this.f1645b.setAlpha(0.0f);
            this.f1645b.setVisibility(8);
            return;
        }
        this.f1645b.setAlpha(1.0f);
        this.f1645b.setVisibility(0);
    }

    public void a(View view, a aVar) {
        this.f1645b = view;
        this.f1646c = aVar;
        this.f1645b.clearAnimation();
        if (aVar == a.INVSIBLE) {
            this.f1645b.setAlpha(0.0f);
            this.f1645b.setVisibility(8);
            return;
        }
        this.f1645b.setAlpha(1.0f);
        this.f1645b.setVisibility(0);
    }

    @Override // com.facebook.ads.internal.view.d.b.m
    public void a(com.facebook.ads.internal.view.n nVar) {
        nVar.getEventBus().a((r<s, q>) this.e);
        nVar.getEventBus().a((r<s, q>) this.f);
        nVar.getEventBus().a((r<s, q>) this.h);
        nVar.getEventBus().a((r<s, q>) this.g);
        this.d = nVar;
    }
}

package com.facebook.ads.internal.view.d.b;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.g.q;
import com.facebook.ads.internal.g.r;
import com.facebook.ads.internal.g.s;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class p extends RelativeLayout implements m {

    /* renamed from: a  reason: collision with root package name */
    private ObjectAnimator f1706a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f1707b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f1708c;
    private com.facebook.ads.internal.view.n d;
    private s e;
    private s f;
    private s g;

    public p(Context context, int i) {
        super(context);
        this.e = new com.facebook.ads.internal.view.d.a.o() { // from class: com.facebook.ads.internal.view.d.b.p.1
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.n nVar) {
                if (p.this.d != null) {
                    p.this.a(p.this.d.getDuration(), p.this.d.getCurrentPosition());
                }
            }
        };
        this.f = new com.facebook.ads.internal.view.d.a.i() { // from class: com.facebook.ads.internal.view.d.b.p.2
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.h hVar) {
                p.this.b();
            }
        };
        this.g = new com.facebook.ads.internal.view.d.a.k() { // from class: com.facebook.ads.internal.view.d.b.p.3
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.j jVar) {
                if (p.this.d != null) {
                    p.this.a(p.this.d.getDuration(), p.this.d.getCurrentPosition());
                }
            }
        };
        this.f1707b = new AtomicInteger(-1);
        this.f1708c = new ProgressBar(context, null, 16842872);
        this.f1708c.setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(0), new ColorDrawable(0), new ScaleDrawable(new ColorDrawable(-16711681), GravityCompat.START, 1.0f, -1.0f)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.f1708c.setProgressDrawable(layerDrawable);
        this.f1708c.setMax(10000);
        addView(this.f1708c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        b();
        if (this.f1707b.get() >= i2 || i <= i2) {
            return;
        }
        this.f1706a = ObjectAnimator.ofInt(this.f1708c, NotificationCompat.CATEGORY_PROGRESS, (i2 * 10000) / i, (Math.min(i2 + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, i) * 10000) / i);
        this.f1706a.setDuration(Math.min((int) ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, i - i2));
        this.f1706a.setInterpolator(new LinearInterpolator());
        this.f1706a.start();
        this.f1707b.set(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f1706a != null) {
            this.f1706a.cancel();
            this.f1706a.setTarget(null);
            this.f1706a = null;
            this.f1708c.clearAnimation();
        }
    }

    public void a() {
        b();
        this.f1708c = null;
        this.d = null;
    }

    @Override // com.facebook.ads.internal.view.d.b.m
    public void a(com.facebook.ads.internal.view.n nVar) {
        this.d = nVar;
        r<s, q> eventBus = nVar.getEventBus();
        eventBus.a((r<s, q>) this.f);
        eventBus.a((r<s, q>) this.g);
        eventBus.a((r<s, q>) this.e);
    }
}

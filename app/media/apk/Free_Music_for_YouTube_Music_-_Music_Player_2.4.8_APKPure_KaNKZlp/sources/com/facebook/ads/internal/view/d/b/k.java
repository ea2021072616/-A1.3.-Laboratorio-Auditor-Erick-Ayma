package com.facebook.ads.internal.view.d.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.g.q;
import com.facebook.ads.internal.g.r;
import com.facebook.ads.internal.g.s;
/* loaded from: classes.dex */
public class k extends n {

    /* renamed from: b  reason: collision with root package name */
    private final l f1688b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.ads.internal.view.d.a.i f1689c;
    private final com.facebook.ads.internal.view.d.a.k d;
    private final com.facebook.ads.internal.view.d.a.c e;
    private final Paint f;
    private final RectF g;

    public k(Context context) {
        super(context);
        this.f1689c = new com.facebook.ads.internal.view.d.a.i() { // from class: com.facebook.ads.internal.view.d.b.k.1
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.h hVar) {
                k.this.f1688b.setChecked(true);
            }
        };
        this.d = new com.facebook.ads.internal.view.d.a.k() { // from class: com.facebook.ads.internal.view.d.b.k.2
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.j jVar) {
                k.this.f1688b.setChecked(false);
            }
        };
        this.e = new com.facebook.ads.internal.view.d.a.c() { // from class: com.facebook.ads.internal.view.d.b.k.3
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.b bVar) {
                k.this.f1688b.setChecked(true);
            }
        };
        this.f1688b = new l(context);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 50.0f), (int) (displayMetrics.density * 50.0f));
        layoutParams.addRule(13);
        this.f1688b.setLayoutParams(layoutParams);
        this.f1688b.setChecked(true);
        this.f = new Paint();
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f.setAlpha(119);
        this.g = new RectF();
        setBackgroundColor(0);
        addView(this.f1688b);
        setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 75.0d), (int) (displayMetrics.density * 75.0d));
        layoutParams2.addRule(13);
        setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.ads.internal.view.d.b.n
    public void a_(final com.facebook.ads.internal.view.n nVar) {
        nVar.getEventBus().a((r<s, q>) this.f1689c);
        nVar.getEventBus().a((r<s, q>) this.d);
        nVar.getEventBus().a((r<s, q>) this.e);
        this.f1688b.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.ads.internal.view.d.b.k.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    return true;
                }
                if (motionEvent.getAction() == 1) {
                    if (nVar.getState() == com.facebook.ads.internal.view.d.c.d.PREPARED) {
                        nVar.d();
                        return true;
                    } else if (nVar.getState() == com.facebook.ads.internal.view.d.c.d.IDLE) {
                        nVar.d();
                        return true;
                    } else if (nVar.getState() == com.facebook.ads.internal.view.d.c.d.PAUSED) {
                        nVar.d();
                        return true;
                    } else if (nVar.getState() == com.facebook.ads.internal.view.d.c.d.STARTED) {
                        nVar.e();
                        return true;
                    } else if (nVar.getState() == com.facebook.ads.internal.view.d.c.d.PLAYBACK_COMPLETED) {
                        nVar.d();
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
        super.a_(nVar);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.g.set(0.0f, 0.0f, getWidth(), getHeight());
        canvas.drawRoundRect(this.g, 5.0f * f, f * 5.0f, this.f);
        super.onDraw(canvas);
    }
}

package com.facebook.ads.internal.view.d.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ads.internal.g.q;
import com.facebook.ads.internal.g.r;
import com.facebook.ads.internal.g.s;
/* loaded from: classes.dex */
public class o extends View implements m {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f1701a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f1702b;

    /* renamed from: c  reason: collision with root package name */
    private float f1703c;
    private final com.facebook.ads.internal.view.d.a.o d;
    private final com.facebook.ads.internal.view.d.a.c e;
    @Nullable
    private com.facebook.ads.internal.view.n f;

    public o(Context context) {
        super(context);
        this.d = new com.facebook.ads.internal.view.d.a.o() { // from class: com.facebook.ads.internal.view.d.b.o.1
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.n nVar) {
                if (o.this.f != null) {
                    int duration = o.this.f.getDuration();
                    if (duration > 0) {
                        o.this.f1703c = o.this.f.getCurrentPosition() / duration;
                    } else {
                        o.this.f1703c = 0.0f;
                    }
                    o.this.postInvalidate();
                }
            }
        };
        this.e = new com.facebook.ads.internal.view.d.a.c() { // from class: com.facebook.ads.internal.view.d.b.o.2
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.b bVar) {
                if (o.this.f != null) {
                    o.this.f1703c = 0.0f;
                    o.this.postInvalidate();
                }
            }
        };
        this.f1701a = new Paint();
        this.f1701a.setStyle(Paint.Style.FILL);
        this.f1701a.setColor(-9528840);
        this.f1702b = new Rect();
    }

    @Override // com.facebook.ads.internal.view.d.b.m
    public void a(com.facebook.ads.internal.view.n nVar) {
        this.f = nVar;
        nVar.getEventBus().a((r<s, q>) this.d);
        nVar.getEventBus().a((r<s, q>) this.e);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f1702b.set(0, 0, (int) (getWidth() * this.f1703c), getHeight());
        canvas.drawRect(this.f1702b, this.f1701a);
        super.draw(canvas);
    }
}

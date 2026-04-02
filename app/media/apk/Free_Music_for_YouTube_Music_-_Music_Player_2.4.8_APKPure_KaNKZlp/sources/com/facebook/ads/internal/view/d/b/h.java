package com.facebook.ads.internal.view.d.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.g.q;
import com.facebook.ads.internal.g.r;
import com.facebook.ads.internal.g.s;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class h extends n {

    /* renamed from: b  reason: collision with root package name */
    private final a f1672b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1673c;
    private final String d;
    private final String e;
    private final AtomicBoolean f;
    private final s<com.facebook.ads.internal.view.d.a.n> g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends TextView {

        /* renamed from: a  reason: collision with root package name */
        private final Paint f1677a;

        /* renamed from: b  reason: collision with root package name */
        private final Paint f1678b;

        /* renamed from: c  reason: collision with root package name */
        private final RectF f1679c;

        public a(Context context) {
            super(context);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            setBackgroundColor(0);
            setTextColor(-3355444);
            setPadding((int) (displayMetrics.density * 9.0f), (int) (displayMetrics.density * 5.0f), (int) (displayMetrics.density * 9.0f), (int) (displayMetrics.density * 5.0f));
            setTextSize(18.0f);
            this.f1677a = new Paint();
            this.f1677a.setStyle(Paint.Style.STROKE);
            this.f1677a.setColor(-10066330);
            this.f1677a.setStrokeWidth(1.0f);
            this.f1677a.setAntiAlias(true);
            this.f1678b = new Paint();
            this.f1678b.setStyle(Paint.Style.FILL);
            this.f1678b.setColor(-1895825408);
            this.f1679c = new RectF();
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            if (getText().length() == 0) {
                return;
            }
            int width = getWidth();
            int height = getHeight();
            this.f1679c.set(0, 0, width, height);
            canvas.drawRoundRect(this.f1679c, 6.0f, 6.0f, this.f1678b);
            this.f1679c.set(2, 2, width - 2, height - 2);
            canvas.drawRoundRect(this.f1679c, 6.0f, 6.0f, this.f1677a);
            super.onDraw(canvas);
        }
    }

    public h(Context context, int i, String str, String str2) {
        super(context);
        this.g = new s<com.facebook.ads.internal.view.d.a.n>() { // from class: com.facebook.ads.internal.view.d.b.h.1
            @Override // com.facebook.ads.internal.g.s
            public Class<com.facebook.ads.internal.view.d.a.n> a() {
                return com.facebook.ads.internal.view.d.a.n.class;
            }

            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.n nVar) {
                if (h.this.f.get()) {
                    return;
                }
                int currentPosition = h.this.f1673c - (h.this.getVideoView().getCurrentPosition() / 1000);
                if (currentPosition > 0) {
                    h.this.f1672b.setText(h.this.d + ' ' + currentPosition);
                    return;
                }
                h.this.f1672b.setText(h.this.e);
                h.this.f.set(true);
            }
        };
        this.f1673c = i;
        this.d = str;
        this.e = str2;
        this.f = new AtomicBoolean(false);
        this.f1672b = new a(context);
        this.f1672b.setText(this.d + ' ' + i);
        addView(this.f1672b, new RelativeLayout.LayoutParams(-2, -2));
    }

    @Override // com.facebook.ads.internal.view.d.b.n
    public void a_(final com.facebook.ads.internal.view.n nVar) {
        nVar.getEventBus().a((r<s, q>) this.g);
        this.f1672b.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.internal.view.d.b.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.f.get()) {
                    nVar.f();
                } else {
                    Log.i("SkipPlugin", "User clicked skip before the ads is allowed to skip.");
                }
            }
        });
    }
}

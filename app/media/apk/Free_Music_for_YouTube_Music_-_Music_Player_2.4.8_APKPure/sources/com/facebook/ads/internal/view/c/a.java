package com.facebook.ads.internal.view.c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.a.b;
import com.facebook.ads.internal.g.q;
import com.facebook.ads.internal.g.r;
import com.facebook.ads.internal.g.s;
import com.facebook.ads.internal.view.n;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f1613a;

    /* renamed from: b  reason: collision with root package name */
    private n f1614b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f1615c;
    private final RectF d;

    public a(Context context, String str, String str2, int i, n nVar) {
        super(context);
        this.f1613a = str;
        this.f1614b = nVar;
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setTextSize(16.0f);
        textView.setText(str2);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        addView(textView);
        this.f1615c = new Paint();
        this.f1615c.setStyle(Paint.Style.FILL);
        this.f1615c.setColor(i);
        this.d = new RectF();
        setBackgroundColor(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.internal.view.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    Uri parse = Uri.parse(a.this.f1613a);
                    a.this.f1614b.getEventBus().a((r<s, q>) new com.facebook.ads.internal.view.d.a.a(parse));
                    com.facebook.ads.internal.a.a a2 = b.a(a.this.getContext(), "", parse, new HashMap());
                    if (a2 != null) {
                        a2.b();
                    }
                } catch (ActivityNotFoundException e) {
                    Log.e(String.valueOf(a.class), "Error while opening " + a.this.f1613a, e);
                } catch (Exception e2) {
                    Log.e(String.valueOf(a.class), "Error executing action", e2);
                }
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.d.set(0.0f, 0.0f, getWidth(), getHeight());
        canvas.drawRoundRect(this.d, 10.0f * f, f * 10.0f, this.f1615c);
        super.onDraw(canvas);
    }
}

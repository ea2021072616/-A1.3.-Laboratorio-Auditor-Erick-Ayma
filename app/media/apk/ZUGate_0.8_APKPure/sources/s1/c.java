package s1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import f0.g;
import t1.h;
/* loaded from: classes.dex */
public abstract class c extends g {

    /* renamed from: b  reason: collision with root package name */
    public final i1.a f4838b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f4839c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f4840d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f4841e;

    public c(i1.a aVar, h hVar) {
        super(hVar);
        this.f4838b = aVar;
        Paint paint = new Paint(1);
        this.f4839c = paint;
        paint.setStyle(Paint.Style.FILL);
        new Paint(4);
        Paint paint2 = new Paint(1);
        this.f4841e = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(t1.g.c(9.0f));
        Paint paint3 = new Paint(1);
        this.f4840d = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f4840d.setStrokeWidth(2.0f);
        this.f4840d.setColor(Color.rgb(255, 187, 115));
    }

    public abstract void c(Canvas canvas);
}

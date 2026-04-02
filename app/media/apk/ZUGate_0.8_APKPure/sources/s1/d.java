package s1;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import f0.g;
import java.util.ArrayList;
import t1.h;
/* loaded from: classes.dex */
public final class d extends g {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f4842b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f4843c;

    /* renamed from: d  reason: collision with root package name */
    public final l1.e f4844d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f4845e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint.FontMetrics f4846f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f4847g;

    public d(h hVar, l1.e eVar) {
        super(hVar);
        this.f4845e = new ArrayList(16);
        this.f4846f = new Paint.FontMetrics();
        this.f4847g = new Path();
        this.f4844d = eVar;
        Paint paint = new Paint(1);
        this.f4842b = paint;
        paint.setTextSize(t1.g.c(9.0f));
        paint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.f4843c = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    public final void c(Canvas canvas, float f5, float f6, l1.f fVar, l1.e eVar) {
        int i5 = fVar.f3759f;
        if (i5 == 1122868 || i5 == 1122867 || i5 == 0) {
            return;
        }
        int save = canvas.save();
        int i6 = fVar.f3755b;
        if (i6 == 3) {
            i6 = eVar.f3743l;
        }
        Paint paint = this.f4843c;
        paint.setColor(i5);
        float f7 = fVar.f3756c;
        if (Float.isNaN(f7)) {
            f7 = eVar.f3744m;
        }
        float c5 = t1.g.c(f7);
        float f8 = c5 / 2.0f;
        int b5 = n.h.b(i6);
        if (b5 != 2) {
            if (b5 == 3) {
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRect(f5, f6 - f8, f5 + c5, f6 + f8, paint);
            } else if (b5 != 4) {
                if (b5 == 5) {
                    float f9 = fVar.f3757d;
                    if (Float.isNaN(f9)) {
                        f9 = eVar.f3745n;
                    }
                    float c6 = t1.g.c(f9);
                    DashPathEffect dashPathEffect = fVar.f3758e;
                    if (dashPathEffect == null) {
                        eVar.getClass();
                        dashPathEffect = null;
                    }
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(c6);
                    paint.setPathEffect(dashPathEffect);
                    Path path = this.f4847g;
                    path.reset();
                    path.moveTo(f5, f6);
                    path.lineTo(f5 + c5, f6);
                    canvas.drawPath(path, paint);
                }
            }
            canvas.restoreToCount(save);
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f5 + f8, f6, f8, paint);
        canvas.restoreToCount(save);
    }
}

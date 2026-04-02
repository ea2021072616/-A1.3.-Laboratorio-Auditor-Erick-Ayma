package s1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.appcompat.widget.b0;
import java.util.ArrayList;
import l1.h;
import t1.g;
/* loaded from: classes.dex */
public final class f extends a {

    /* renamed from: g  reason: collision with root package name */
    public final h f4853g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f4854h;

    /* renamed from: i  reason: collision with root package name */
    public final RectF f4855i;

    /* renamed from: j  reason: collision with root package name */
    public float[] f4856j;

    /* renamed from: k  reason: collision with root package name */
    public final Path f4857k;

    /* renamed from: l  reason: collision with root package name */
    public final float[] f4858l;

    public f(t1.h hVar, h hVar2, t1.f fVar) {
        super(hVar, fVar, hVar2);
        this.f4854h = new Path();
        this.f4855i = new RectF();
        this.f4856j = new float[2];
        new Path();
        new RectF();
        this.f4857k = new Path();
        this.f4858l = new float[2];
        new RectF();
        this.f4853g = hVar2;
        if (hVar != null) {
            this.f4830e.setColor(-16777216);
            this.f4830e.setTextSize(g.c(10.0f));
            Paint paint = new Paint(1);
            paint.setColor(-7829368);
            paint.setStrokeWidth(1.0f);
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    public final float[] e() {
        int length = this.f4856j.length;
        h hVar = this.f4853g;
        int i5 = hVar.f3717m;
        if (length != i5 * 2) {
            this.f4856j = new float[i5 * 2];
        }
        float[] fArr = this.f4856j;
        for (int i6 = 0; i6 < fArr.length; i6 += 2) {
            fArr[i6 + 1] = hVar.f3715k[i6 / 2];
        }
        this.f4828c.c(fArr);
        return fArr;
    }

    public final void f(Canvas canvas) {
        float f5;
        float f6;
        float f7;
        String str;
        h hVar = this.f4853g;
        if (hVar.f3730a && hVar.f3723t) {
            float[] e5 = e();
            Paint paint = this.f4830e;
            paint.setTypeface(null);
            paint.setTextSize(hVar.f3733d);
            paint.setColor(hVar.f3734e);
            float f8 = hVar.f3731b;
            float a5 = (g.a(paint, "A") / 2.5f) + hVar.f3732c;
            int i5 = hVar.I;
            int i6 = hVar.H;
            Object obj = this.f2737a;
            if (i5 == 1) {
                if (i6 == 1) {
                    paint.setTextAlign(Paint.Align.RIGHT);
                    f5 = ((t1.h) obj).f5013b.left;
                    f7 = f5 - f8;
                } else {
                    paint.setTextAlign(Paint.Align.LEFT);
                    f6 = ((t1.h) obj).f5013b.left;
                    f7 = f6 + f8;
                }
            } else if (i6 == 1) {
                paint.setTextAlign(Paint.Align.LEFT);
                f6 = ((t1.h) obj).f5013b.right;
                f7 = f6 + f8;
            } else {
                paint.setTextAlign(Paint.Align.RIGHT);
                f5 = ((t1.h) obj).f5013b.right;
                f7 = f5 - f8;
            }
            int i7 = hVar.E ? hVar.f3717m : hVar.f3717m - 1;
            for (int i8 = !hVar.D ? 1 : 0; i8 < i7; i8++) {
                if (i8 < 0 || i8 >= hVar.f3715k.length) {
                    str = "";
                } else {
                    n1.d dVar = hVar.f3710f;
                    if (dVar == null || ((dVar instanceof n1.a) && ((n1.a) dVar).f4079b != hVar.f3718n)) {
                        hVar.f3710f = new n1.a(hVar.f3718n);
                    }
                    str = hVar.f3710f.a(hVar.f3715k[i8]);
                }
                canvas.drawText(str, f7, e5[(i8 * 2) + 1] + a5, paint);
            }
        }
    }

    public final void g(Canvas canvas) {
        h hVar = this.f4853g;
        if (hVar.f3730a && hVar.f3722s) {
            Paint paint = this.f4831f;
            paint.setColor(hVar.f3713i);
            paint.setStrokeWidth(hVar.f3714j);
            int i5 = hVar.I;
            Object obj = this.f2737a;
            if (i5 == 1) {
                RectF rectF = ((t1.h) obj).f5013b;
                float f5 = rectF.left;
                canvas.drawLine(f5, rectF.top, f5, rectF.bottom, paint);
                return;
            }
            RectF rectF2 = ((t1.h) obj).f5013b;
            float f6 = rectF2.right;
            canvas.drawLine(f6, rectF2.top, f6, rectF2.bottom, paint);
        }
    }

    public final void h(Canvas canvas) {
        h hVar = this.f4853g;
        if (hVar.f3730a && hVar.f3721r) {
            int save = canvas.save();
            RectF rectF = this.f4855i;
            t1.h hVar2 = (t1.h) this.f2737a;
            rectF.set(hVar2.f5013b);
            rectF.inset(0.0f, -this.f4827b.f3712h);
            canvas.clipRect(rectF);
            float[] e5 = e();
            Paint paint = this.f4829d;
            paint.setColor(hVar.f3711g);
            paint.setStrokeWidth(hVar.f3712h);
            paint.setPathEffect(null);
            Path path = this.f4854h;
            path.reset();
            for (int i5 = 0; i5 < e5.length; i5 += 2) {
                int i6 = i5 + 1;
                path.moveTo(hVar2.f5013b.left, e5[i6]);
                path.lineTo(hVar2.f5013b.right, e5[i6]);
                canvas.drawPath(path, paint);
                path.reset();
            }
            canvas.restoreToCount(save);
        }
    }

    public final void i() {
        ArrayList arrayList = this.f4853g.f3725v;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        float[] fArr = this.f4858l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        this.f4857k.reset();
        if (arrayList.size() <= 0) {
            return;
        }
        b0.n(arrayList.get(0));
        throw null;
    }
}

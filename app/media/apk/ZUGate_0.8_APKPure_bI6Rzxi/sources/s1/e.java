package s1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import l1.g;
import t1.h;
/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: g  reason: collision with root package name */
    public final g f4848g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f4849h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f4850i;

    /* renamed from: j  reason: collision with root package name */
    public final RectF f4851j;

    /* renamed from: k  reason: collision with root package name */
    public final float[] f4852k;

    public e(h hVar, g gVar, t1.f fVar) {
        super(hVar, fVar, gVar);
        this.f4849h = new Path();
        this.f4850i = new float[2];
        this.f4851j = new RectF();
        this.f4852k = new float[2];
        new RectF();
        new Path();
        this.f4848g = gVar;
        this.f4830e.setColor(-16777216);
        this.f4830e.setTextAlign(Paint.Align.CENTER);
        this.f4830e.setTextSize(t1.g.c(10.0f));
    }

    @Override // s1.a
    public final void c(float f5, float f6) {
        h hVar = (h) this.f2737a;
        if (hVar.f5013b.width() > 10.0f) {
            float f7 = hVar.f5020i;
            float f8 = hVar.f5018g;
            if (!(f7 <= f8 && f8 <= 1.0f)) {
                RectF rectF = hVar.f5013b;
                float f9 = rectF.left;
                float f10 = rectF.top;
                t1.f fVar = this.f4828c;
                fVar.getClass();
                t1.b b5 = t1.b.b(0.0d, 0.0d);
                fVar.a(f9, f10, b5);
                RectF rectF2 = hVar.f5013b;
                float f11 = rectF2.right;
                float f12 = rectF2.top;
                t1.b b6 = t1.b.b(0.0d, 0.0d);
                fVar.a(f11, f12, b6);
                f5 = (float) b5.f4985b;
                f6 = (float) b6.f4985b;
                t1.b.c(b5);
                t1.b.c(b6);
            }
        }
        d(f5, f6);
    }

    @Override // s1.a
    public final void d(float f5, float f6) {
        super.d(f5, f6);
        g gVar = this.f4848g;
        String b5 = gVar.b();
        Paint paint = this.f4830e;
        paint.setTypeface(null);
        paint.setTextSize(gVar.f3733d);
        t1.a b6 = t1.g.b(paint, b5);
        float f7 = b6.f4982b;
        float a5 = t1.g.a(paint, "Q");
        double d5 = 0.0f;
        t1.a b7 = t1.a.b(Math.abs(((float) Math.sin(d5)) * a5) + Math.abs(((float) Math.cos(d5)) * f7), Math.abs(((float) Math.cos(d5)) * a5) + Math.abs(((float) Math.sin(d5)) * f7));
        Math.round(f7);
        Math.round(a5);
        Math.round(b7.f4982b);
        gVar.D = Math.round(b7.f4983c);
        t1.e eVar = t1.a.f4981d;
        eVar.c(b7);
        eVar.c(b6);
    }

    public final void e(Canvas canvas, float f5, t1.c cVar) {
        Rect rect;
        g gVar = this.f4848g;
        gVar.getClass();
        int i5 = 0;
        boolean z4 = gVar.f3724u && gVar.f3717m > 0;
        int i6 = gVar.f3717m * 2;
        float[] fArr = new float[i6];
        for (int i7 = 0; i7 < i6; i7 += 2) {
            if (z4) {
                fArr[i7] = gVar.f3716l[i7 / 2];
            } else {
                fArr[i7] = gVar.f3715k[i7 / 2];
            }
        }
        this.f4828c.c(fArr);
        int i8 = 0;
        while (i8 < i6) {
            float f6 = fArr[i8];
            h hVar = (h) this.f2737a;
            if (((hVar.a(f6) && hVar.b(f6)) ? 1 : i5) != 0) {
                n1.d dVar = gVar.f3710f;
                if (dVar == null || ((dVar instanceof n1.a) && ((n1.a) dVar).f4079b != gVar.f3718n)) {
                    gVar.f3710f = new n1.a(gVar.f3718n);
                }
                String a5 = gVar.f3710f.a(gVar.f3715k[i8 / 2]);
                Paint paint = this.f4830e;
                Paint.FontMetrics fontMetrics = t1.g.f5011i;
                float fontMetrics2 = paint.getFontMetrics(fontMetrics);
                paint.getTextBounds(a5, i5, a5.length(), t1.g.f5010h);
                float f7 = 0.0f - rect.left;
                float f8 = (-fontMetrics.ascent) + 0.0f;
                Paint.Align textAlign = paint.getTextAlign();
                paint.setTextAlign(Paint.Align.LEFT);
                if (cVar.f4988b != 0.0f || cVar.f4989c != 0.0f) {
                    f7 -= rect.width() * cVar.f4988b;
                    f8 -= fontMetrics2 * cVar.f4989c;
                }
                canvas.drawText(a5, f7 + f6, f8 + f5, paint);
                paint.setTextAlign(textAlign);
            }
            i8 += 2;
            i5 = 0;
        }
    }

    public final void f(Canvas canvas) {
        g gVar = this.f4848g;
        if (gVar.f3721r && gVar.f3730a) {
            int save = canvas.save();
            RectF rectF = this.f4851j;
            Object obj = this.f2737a;
            rectF.set(((h) obj).f5013b);
            l1.a aVar = this.f4827b;
            rectF.inset(-aVar.f3712h, 0.0f);
            canvas.clipRect(rectF);
            if (this.f4850i.length != aVar.f3717m * 2) {
                this.f4850i = new float[gVar.f3717m * 2];
            }
            float[] fArr = this.f4850i;
            for (int i5 = 0; i5 < fArr.length; i5 += 2) {
                float[] fArr2 = gVar.f3715k;
                int i6 = i5 / 2;
                fArr[i5] = fArr2[i6];
                fArr[i5 + 1] = fArr2[i6];
            }
            this.f4828c.c(fArr);
            Paint paint = this.f4829d;
            paint.setColor(gVar.f3711g);
            paint.setStrokeWidth(gVar.f3712h);
            paint.setPathEffect(null);
            Path path = this.f4849h;
            path.reset();
            for (int i7 = 0; i7 < fArr.length; i7 += 2) {
                float f5 = fArr[i7];
                float f6 = fArr[i7 + 1];
                h hVar = (h) obj;
                path.moveTo(f5, hVar.f5013b.bottom);
                path.lineTo(f5, hVar.f5013b.top);
                canvas.drawPath(path, paint);
                path.reset();
            }
            canvas.restoreToCount(save);
        }
    }
}

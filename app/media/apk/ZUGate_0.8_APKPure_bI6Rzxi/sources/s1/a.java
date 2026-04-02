package s1;

import android.graphics.Paint;
import android.graphics.RectF;
import f0.g;
import t1.h;
/* loaded from: classes.dex */
public abstract class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public final l1.a f4827b;

    /* renamed from: c  reason: collision with root package name */
    public final t1.f f4828c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f4829d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f4830e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f4831f;

    public a(h hVar, t1.f fVar, l1.a aVar) {
        super(hVar);
        this.f4828c = fVar;
        this.f4827b = aVar;
        if (hVar != null) {
            this.f4830e = new Paint(1);
            Paint paint = new Paint();
            this.f4829d = paint;
            paint.setColor(-7829368);
            paint.setStrokeWidth(1.0f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAlpha(90);
            Paint paint2 = new Paint();
            this.f4831f = paint2;
            paint2.setColor(-16777216);
            paint2.setStrokeWidth(1.0f);
            paint2.setStyle(Paint.Style.STROKE);
            new Paint(1).setStyle(Paint.Style.STROKE);
        }
    }

    public void c(float f5, float f6) {
        h hVar = (h) this.f2737a;
        if (hVar != null && hVar.f5013b.width() > 10.0f) {
            float f7 = hVar.f5021j;
            float f8 = hVar.f5016e;
            if (!(f7 <= f8 && f8 <= 1.0f)) {
                RectF rectF = hVar.f5013b;
                float f9 = rectF.left;
                float f10 = rectF.top;
                t1.f fVar = this.f4828c;
                fVar.getClass();
                t1.b b5 = t1.b.b(0.0d, 0.0d);
                fVar.a(f9, f10, b5);
                RectF rectF2 = hVar.f5013b;
                float f11 = rectF2.left;
                float f12 = rectF2.bottom;
                t1.b b6 = t1.b.b(0.0d, 0.0d);
                fVar.a(f11, f12, b6);
                f5 = (float) b6.f4986c;
                f6 = (float) b5.f4986c;
                t1.b.c(b5);
                t1.b.c(b6);
            }
        }
        d(f5, f6);
    }

    public void d(float f5, float f6) {
        double floor;
        l1.a aVar = this.f4827b;
        int i5 = aVar.o;
        double abs = Math.abs(f6 - f5);
        if (i5 == 0 || abs <= 0.0d || Double.isInfinite(abs)) {
            aVar.f3715k = new float[0];
            aVar.f3716l = new float[0];
            aVar.f3717m = 0;
            return;
        }
        double d5 = t1.g.d(abs / i5);
        if (aVar.f3720q) {
            double d6 = aVar.f3719p;
            if (d5 < d6) {
                d5 = d6;
            }
        }
        double d7 = t1.g.d(Math.pow(10.0d, (int) Math.log10(d5)));
        if (((int) (d5 / d7)) > 5) {
            d5 = Math.floor(d7 * 10.0d);
        }
        boolean z4 = true;
        int i6 = (!aVar.f3724u || aVar.f3717m <= 0) ? 0 : 1;
        int i7 = (d5 > 0.0d ? 1 : (d5 == 0.0d ? 0 : -1));
        double ceil = i7 == 0 ? 0.0d : Math.ceil(f5 / d5) * d5;
        if (aVar.f3724u && aVar.f3717m > 0) {
            ceil -= d5;
        }
        if (i7 == 0) {
            floor = 0.0d;
        } else {
            floor = Math.floor(f6 / d5) * d5;
            if (floor != Double.POSITIVE_INFINITY) {
                double d8 = floor + 0.0d;
                floor = Double.longBitsToDouble(Double.doubleToRawLongBits(d8) + (d8 >= 0.0d ? 1L : -1L));
            }
        }
        if (i7 != 0) {
            for (double d9 = ceil; d9 <= floor; d9 += d5) {
                i6++;
            }
        }
        aVar.f3717m = i6;
        if (aVar.f3715k.length < i6) {
            aVar.f3715k = new float[i6];
        }
        for (int i8 = 0; i8 < i6; i8++) {
            if (ceil == 0.0d) {
                ceil = 0.0d;
            }
            aVar.f3715k[i8] = (float) ceil;
            ceil += d5;
        }
        if (d5 < 1.0d) {
            aVar.f3718n = (int) Math.ceil(-Math.log10(d5));
        } else {
            aVar.f3718n = 0;
        }
        if ((!aVar.f3724u || aVar.f3717m <= 0) ? false : false) {
            if (aVar.f3716l.length < i6) {
                aVar.f3716l = new float[i6];
            }
            float f7 = ((float) d5) / 2.0f;
            for (int i9 = 0; i9 < i6; i9++) {
                aVar.f3716l[i9] = aVar.f3715k[i9] + f7;
            }
        }
    }
}

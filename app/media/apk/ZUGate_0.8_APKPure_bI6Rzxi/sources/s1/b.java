package s1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import java.util.ArrayList;
import java.util.List;
import t1.g;
import t1.h;
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: f  reason: collision with root package name */
    public final p1.a f4832f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f4833g;

    /* renamed from: h  reason: collision with root package name */
    public j1.a[] f4834h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f4835i;

    /* renamed from: j  reason: collision with root package name */
    public final Paint f4836j;

    /* renamed from: k  reason: collision with root package name */
    public final RectF f4837k;

    public b(p1.a aVar, i1.a aVar2, h hVar) {
        super(aVar2, hVar);
        this.f4833g = new RectF();
        this.f4837k = new RectF();
        this.f4832f = aVar;
        Paint paint = new Paint(1);
        this.f4840d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f4840d.setColor(Color.rgb(0, 0, 0));
        this.f4840d.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.f4835i = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.f4836j = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // s1.c
    public final void c(Canvas canvas) {
        p1.a aVar;
        ArrayList arrayList;
        t1.c cVar;
        float f5;
        boolean z4;
        int i5;
        h hVar;
        h hVar2;
        t1.c cVar2;
        b bVar = this;
        p1.a aVar2 = bVar.f4832f;
        h hVar3 = (h) bVar.f2737a;
        int i6 = 1;
        if (((float) aVar2.getData().e()) < ((float) aVar2.getMaxVisibleCount()) * hVar3.f5020i) {
            ArrayList arrayList2 = aVar2.getBarData().f3943i;
            float c5 = g.c(4.5f);
            boolean z5 = ((BarChart) aVar2).f1803q0;
            int i7 = 0;
            while (i7 < aVar2.getBarData().d()) {
                m1.b bVar2 = (m1.b) arrayList2.get(i7);
                boolean z6 = bVar2.f3957n;
                boolean z7 = bVar2.f3953j;
                if (((z6 && (z7 || bVar2.f3954k)) ? i6 : 0) == 0) {
                    aVar = aVar2;
                    arrayList = arrayList2;
                    f5 = c5;
                    z4 = z5;
                    i5 = i7;
                    hVar = hVar3;
                } else {
                    Paint paint = bVar.f4841e;
                    paint.setTypeface(null);
                    paint.setTextSize(bVar2.f3956m);
                    k1.a aVar3 = (k1.a) aVar2;
                    (bVar2.f3947d == i6 ? aVar3.f3525b0 : aVar3.f3526c0).getClass();
                    float a5 = g.a(paint, "8");
                    float f6 = z5 ? -c5 : a5 + c5;
                    float f7 = z5 ? a5 + c5 : -c5;
                    j1.a aVar4 = bVar.f4834h[i7];
                    bVar.f4838b.getClass();
                    n1.d dVar = bVar2.f3949f;
                    if ((dVar == null ? i6 : 0) != 0) {
                        dVar = g.f5009g;
                    }
                    t1.c cVar3 = (t1.c) t1.c.f4987d.b();
                    t1.c cVar4 = bVar2.f3955l;
                    aVar = aVar2;
                    float f8 = cVar4.f4988b;
                    cVar3.f4988b = f8;
                    cVar3.f4989c = cVar4.f4989c;
                    cVar3.f4988b = g.c(f8);
                    cVar3.f4989c = g.c(cVar3.f4989c);
                    boolean z8 = bVar2.f3928u > 1;
                    ArrayList arrayList3 = bVar2.f3945b;
                    arrayList = arrayList2;
                    List list = bVar2.o;
                    if (z8) {
                        h hVar4 = hVar3;
                        cVar = cVar3;
                        f5 = c5;
                        z4 = z5;
                        i5 = i7;
                        int i8 = 0;
                        int i9 = 0;
                        while (true) {
                            if (i8 >= bVar2.c() * 1.0f) {
                                hVar = hVar4;
                                break;
                            }
                            m1.c cVar5 = (m1.c) ((m1.h) list.get(i8));
                            cVar5.getClass();
                            float[] fArr = aVar4.f3434b;
                            float f9 = (fArr[i9] + fArr[i9 + 2]) / 2.0f;
                            int intValue = ((Integer) arrayList3.get(i8 % arrayList3.size())).intValue();
                            hVar = hVar4;
                            if (!hVar.b(f9)) {
                                break;
                            }
                            int i10 = i9 + 1;
                            ArrayList arrayList4 = arrayList3;
                            float[] fArr2 = aVar4.f3434b;
                            List list2 = list;
                            if (hVar.c(fArr2[i10]) && hVar.a(f9)) {
                                if (z7) {
                                    dVar.getClass();
                                    String a6 = dVar.a(cVar5.f3933b);
                                    float f10 = fArr2[i10];
                                    float f11 = cVar5.f3933b >= 0.0f ? f6 : f7;
                                    paint.setColor(intValue);
                                    canvas.drawText(a6, f9, f10 + f11, paint);
                                }
                                i9 += 4;
                                i8++;
                            }
                            hVar4 = hVar;
                            arrayList3 = arrayList4;
                            list = list2;
                        }
                    } else {
                        int i11 = 0;
                        while (true) {
                            f5 = c5;
                            float[] fArr3 = aVar4.f3434b;
                            z4 = z5;
                            if (i11 >= fArr3.length * 1.0f) {
                                break;
                            }
                            float f12 = (fArr3[i11] + fArr3[i11 + 2]) / 2.0f;
                            if (!hVar3.b(f12)) {
                                break;
                            }
                            int i12 = i11 + 1;
                            int i13 = i7;
                            if (hVar3.c(fArr3[i12]) && hVar3.a(f12)) {
                                int i14 = i11 / 4;
                                cVar2 = cVar3;
                                m1.c cVar6 = (m1.c) ((m1.h) list.get(i14));
                                hVar2 = hVar3;
                                float f13 = cVar6.f3933b;
                                if (z7) {
                                    dVar.getClass();
                                    String a7 = dVar.a(cVar6.f3933b);
                                    float f14 = f13 >= 0.0f ? fArr3[i12] + f6 : fArr3[i11 + 3] + f7;
                                    paint.setColor(((Integer) arrayList3.get(i14 % arrayList3.size())).intValue());
                                    canvas.drawText(a7, f12, f14, paint);
                                }
                            } else {
                                hVar2 = hVar3;
                                cVar2 = cVar3;
                            }
                            i11 += 4;
                            c5 = f5;
                            z5 = z4;
                            i7 = i13;
                            hVar3 = hVar2;
                            cVar3 = cVar2;
                        }
                        cVar = cVar3;
                        i5 = i7;
                        hVar = hVar3;
                    }
                    t1.c.f4987d.c(cVar);
                }
                hVar3 = hVar;
                aVar2 = aVar;
                arrayList2 = arrayList;
                c5 = f5;
                z5 = z4;
                i6 = 1;
                i7 = i5 + 1;
                bVar = this;
            }
        }
    }
}
